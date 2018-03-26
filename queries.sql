--a
select r.name, type, address, type, address, hours_open, hours_close
from restaurant r, location l
--placeholder is restName
where r.name = restName
and r.restaurantID = l.restaurantID;

--b
select  i.name, i.type, i.category, i.price
from menuitem i, restaurant r
--placeholder is restName
where r.name = restName
and r.restaurantID = i.restaurantID
order by category

--c
select r.name, l.address, l.open_date, l.manager
from restaurant r, location l
--placeholder is resType
where r.type = resType
and r.restaurantID = l.restaurantID
order by r.name

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
select category, name, type, avg(i.price) as average_price
from restaurant r, menuitem i
where r.restaurantID = i.restaurantID
group by category

--f(needs modification)
--select count(*) as ammount_of_rating, 
--from restaurant r,
--
--group by r.name

--g
select name, type, phone
from restaurant r, location l, rating rt
where rt.restaurantiD = r.restaurantiD 
and r.restaurantiD = l.restaurantiD
		from restaurant
		where restaurantiD = r.restaurantiD) not in(select restaurantiD
											from restaurant rr, rating rtt
											where rr.restaurantiD = r.restaurantiD
											and rtt.restaurantiD = rr.restaurantiD
											and rtt.date = like '2015-01-__')
--h(needs modification)
select name, open_date
from restaurant r, rater rat, rating rt
--placeholder is x
where rat.userid = x 
and (select avg(staff)
	from rating
	where r.restaurantiD = restaurantiD)
	<= all
	(select staff
	from rating
	where rat.userID = userid)
	
--i(needs modification)
select r.name, rat.name
from restaurant r, rater rat, rating rrt
where rat.userID = rrt.userID
--place holder y
and y = r.type
and rrt.food = 5--according to what should i get rating
r.restaurantID = rrt.restaurantID

--j
select r.name, avg(rrt.food + rrt.mood + rrt.staff) as ave_rating
from restaurant r, rating rrt
where r.restaurantID = rrt.restaurantID
		and (select count(*)
		from rating
		where r.restaurantID = rrt.restaurantID
		) > 0
order by ave_rating

--k
select rat.name, rat.join_date, rat.reputation, avg(av_rating.f + av_rating.m) as avg_rating, 
						restaurant_name.name, restaurant_name.date
from rater rat, (select r.name as name, rrrt.date as date
				from restaurant r, rating rrrt
				where rrrt.userID = rrt.userID
				and rrrt.restaurantID = r.restaurantID) as restaurant_name, 
											rating rrt, 
											(select rg.food f, rg.mood m
											from rater rr, rating rg
											where rr.userID = rat.userID
											and rg.userID = rr.userID) as av_rating
where rat.userid = rrt.userid
group by rat.name, rat.join_date, rat.reputation, restaurant_name.name, restaurant_name.date
order by avg_rating

--l(skip)

--m
select rat.name, rat.reputation, ri.comment, mi.name, mi.price
from rater rat, ratingItem ri, menuitem mi, restaurant r, (select count(*) as tottal
															from rating rt1, rater rat1, restaurant r1
															-- z is place holder
															where r1.name = z
															rat1.userid = rat.userid
															rt1.userid = rat1.userid
															) as ratings
-- z is place holder
where r.name = z
	and max(ratings.tottal)
	and mi.restaurantID = z.restaurantID
	and ri.userid = rat.userid
	and ri.itemid = mi.itemid

group by rat.name, rat.reputation

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





















