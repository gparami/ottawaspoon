--insert the data into the rater/restaurant/menuItem
insert into ottawaspoon.rater (userId,e_mail,name,type,join_date,reputation,password) values,()

insert into ottawaspoon.restaurant(restaurantID,name,type,url) values,()

insert into ottawaspoon.MenuItem(itemID,name,type,category,description,price,restaurantID) values,()

--delete the data into the rater/restaurant/menuItem

delete from rater where rater.userID = '1'

delete from restaurant where restaurant.restaurantID = 1

delete from menuItem where menuItem.itemID = 1

