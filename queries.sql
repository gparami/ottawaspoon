--a
select dname, type, address, type, address, hours_open, hours_close
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
select r.name, i.name, l.manger, pr.price, l.address, l.hours_open
from restaurant r, menueitem i, location l, (select price
												from menuitem
												where r.restaurantID = restaurantID) as pr
where pr.price > all(select price
					from menuitem
					where r.restaurantID = restaurantID)
		--placeHoder is restName
		and r.name = restName
		and l.restaurantID = r.restaurantID
		
--e
select category, name, type, avg(i.price) as average_price
from restaurant r, menuitem i
where r.restaurantID = i.restaurantID
group by category

--f
--select count(*) as ammount_of_rating, 
--from restaurant r,
--
--group by r.name

--g
select name, type, phone
from from restaurant r, location l, rating rt
where rt.restaurantiD = r.restaurantiD 
and r.restaurantiD = l.restaurantiD
		from restaurant
		where restaurantiD = r.restaurantiD) not in(select restaurantiD
											from restaurant rr, rating rtt
											where rr.restaurantiD = r.restaurantiD
											and rtt.restaurantiD = rr.restaurantiD
											and rtt.date = like '2015-01-__')
--h
select name, open_date
from restaurant, rater rat, rating rt
--placeholder is x
where rat.userid = x 
and (select name )