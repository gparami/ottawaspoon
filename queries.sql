--a
/*
select r.name, type, address, type, address, hours_open, hours_close
from restaurant r, location l
--placeholder is restName
where r.name = restName
and r.restaurantID = l.restaurantID;*/
select *
from restaurant natural join location
where restaurant.name = 'Mug you'--Mug you placeholder

--b
select  i.name, i.price
from menuitem i, restaurant r
where r.name = 'Mug you'--placeholder
and r.restaurantID = i.restaurantID
order by category

--c
select l.open_date, l.manager
from restaurant r natural join location l
where r.type = 'chineese'--placeholder

--d
select r.name, i.name, l.manager, pr.price as most_expensive_price, l.address, l.hours_open
from restaurant r, menuitem i, location l, (select price, restaurantID
												from menuitem
												) as pr
where pr.price >= all(select price
					from menuitem
					where r.restaurantID = restaurantID)
		--placeHoder is restName
		and r.name = restName
		and l.restaurantID = r.restaurantID
		and pr.restaurantID = r.restaurantID
		and i.restaurantID = r.restaurantID
		
--e
select r.type, i.type, avg(i.price) as average_price
from restaurant r, menuitem i
where r.restaurantID = i.restaurantID
group by r.type, i.type

--f
select r.name, rat.name, round(avg(rt.food + rt.mood + rt.staff + rt.price),2) as average_score,count(*) as total_amount_of_ratings
from restaurant r, rater rat, rating rt
where r.restaurantiD = rt.restaurantiD
	and rt.userID = rat.userID
group by r.name, rat.name
order by r.name

--g
select name, type, phone
from restaurant r, location l, rating rt
where rt.restaurantiD = r.restaurantiD 
and r.restaurantiD = l.restaurantiD
		and 
		(select restaurantiD
		from restaurant
		where restaurantiD = r.restaurantiD) not in(select rr.restaurantiD
											from restaurant rr, rating rtt
											where rr.restaurantiD = r.restaurantiD
											and rtt.restaurantiD = rr.restaurantiD
											and rtt.date::text like '2015-1-__' )
--h(needs modification)
/*
select r.name, l.open_date
from restaurant r, rater rat, rating rt, location l
--placeholder is x
where rat.userid = '1'
and l.restaurantiD = r.restaurantiD
and rat.userID = rt.userID
and (select avg(staff)
	from rating
	where r.restaurantiD = restaurantiD)
	<= any
	(select staff
	from rating
	where rat.userID = userid)
	*/
	--h use 14 as X
select r.name,l.open_date
from (location l natural join restaurant r)natural join rating rat 
where
	rat.staff< any( select rat.staff
					from restaurant r natural join rating rat
					where rat.userId = '14' )
order by rat.date

--i(needs modification)
select r.name, rat.name
from restaurant r, rater rat, rating rrt
where rat.userID = rrt.userID
--place holder y
and y = r.type
and rrt.food = 5--according to what should i get rating
r.restaurantID = rrt.restaurantID

--j
select r.name, round(avg(rrt.price + rrt.food + rrt.mood + rrt.staff), 2) as ave_rating
from restaurant r, rating rrt
where r.restaurantID = rrt.restaurantID
		and (select count(*)
		from rating
		where r.restaurantID = rrt.restaurantID
		) > 0
group by r.name
order by ave_rating desc
limit 3

--k
select rat.name, rat.join_date, rat.reputation, food + mood as rating, 
						r.name, rt.date
from rater rat, rating rt, restaurant r
where rat.userid = rt.userid
and rt.restaurantID = r.restaurantID
order by rating desc
limit 10

--l
select rat.name, rat.reputation, food + mood as rating, 
						r.name, rt.date
from rater rat, rating rt, restaurant r
where rat.userid = rt.userid
and rt.restaurantID = r.restaurantID
order by rating desc
limit 10

--m
select rat.name, rat.reputation, rt.comment, mi.name, mi.price
from rater rat, restaurant r, rating rt, 
								menuitem mi, ratingitem ri, (select count(*) as tottal, rat.userid as rater
															from rating rt, rater rat, restaurant r
															where rt.userid = rat.userid
															and r.restaurantid = rt.restaurantid
															-- z is place holder
															and r.name = 'Mug you'
															group by rat.userid																													
															) as ratings,
															(select max (ratings.tottal) as max_tottal
															from  (select count(*) as tottal, rat.userid
																										from rating rt, rater rat, restaurant r
																										where rt.userid = rat.userid
																										and r.restaurantid = rt.restaurantid
																										-- z is place holder
																										and r.name = 'Mug you'
																										group by rat.userid																													
																										) as ratings																																											
																						) as max_ratings
where ratings.rater = rat.userid
and ratings.tottal = max_ratings.max_tottal
and rt.restaurantid = r.restaurantid
and rt.userid = rat.userid
-- z is place holder
and r.name = 'Mug you'
and mi.restaurantid = r.restaurantid
and mi.itemid = ri.itemid
--need more data for rating item with coments to display, if uncoment next line the querry is empty
--and ri.userid = rat.userid

--n
select rat.name, rat.email
from rater rat
where (select avg(sum(food) + sum(mood) + sum(staff))
		from rater ratt, rating rt
		where ratt.userid = rat.userid
		and ratt.userid = rt.userid)
		<
		(select avg(sum(food) + sum(mood) + sum(staff))
		from rater jrat, rating jrt
		where jrat.userid = jrt.userid
		and jrat.name = "John")
		
--o
/*
select name, type, email
from rater rat, rating rt, (select avg (sum(food) + sum(mood) + sum(staff)) as m
							from rater ratt, rating rt
							where ratt.userid = rat.userid
							and ratt.userid = rt.userid) as mean
where (select power(cast(food + mood + staff - mean.m, float) , 2)
							from rater, rating
							where rater.userid = rating.userid
							and rater.userid = rat.userid)
							> any
							(--holy fuck will do it later)
							*/
							--o)
select deviations.userid,deviations.dev,rat.name,rat.type,rat.e_mail,rating.food,r.name
from (select stddev(food) dev, rater.userid userid
	from rating natural join rater
	group by rater.userid) as deviations,
	
	(select max(internDev.dev) devMax
	from
	(select stddev(food) dev, rater.userid userid
	from rating natural join rater
	group by rater.userid) as internDev)
	as deviationsMax,
	rater rat,
	rating,
	restaurant r
where deviations.dev = deviationsMax.devMax and rat.userid= deviations.userid and rating.userid = rat.userid and r.restaurantid = rating.restaurantid





















