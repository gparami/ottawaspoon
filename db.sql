/*
Database is created with the name ottawaspoondb and the schema ottawaspoon is created for application usage.
If connecting to an existing database, start your sql script from line 7.
*/
CREATE DATABASE ottawaspoondb;
\connect ottawaspoondb;
CREATE SCHEMA ottawaspoon;
set search_path = 'ottawaspoon';

/*
The join-date is used to show when this rater first joined the website. The name field corresponds to
an alias such as SuperSizeMe. Type refers to the type of rater (blog, online, food critic) and
reputation takes a value between 1 and 5. The value of this field is based on the number of people
who found this rater opinion helpful, and the default value is 1 (lowest).
*/
create table ottawaspoon.rater(
    userID int, 
    password varchar,
    e_mail varchar,
    name varchar, 
    join_date date,
    type varchar,
    reputation int,
    primary key (userid)
    );
/*
alter table ottawaspoon.rater
add constraint rater_reputation
    check (reputation between 1 and 5);
*/
/*
This relation contains general information about a restaurant and is useful in the case where a
restaurant chain has many locations. The type attribute contains details about the cuisine, such as
Italian, Indian, Middle Eastern, and so on.
*/
create table ottawaspoon.restaurant(
    restaurantID int, 
    name varchar,
    type varchar,
    url varchar,
    primary key (restaurantId)
    );

/*
The Price, Food, Mood and Staff attributes may take a value between 1 (low) to 5 (high). The
comments field is reserved for free text and will be used, in future, for sentiment analysis. Note
that UserID and RestaurantID are foreign keys
*/
create table ottawaspoon.rating(
    userID int,
    date date, 
    price int, 
    food int,
    mood int,
    staff int, 
    comment varchar, 
    restaurantiD int,
    useful int ,
    primary key (userid, date),
    foreign key (userID) references ottawaspoon.rater (userID),
    foreign key (restaurantID) references ottawaspoon.restaurant (restaurantID)
    );
/*
This relation contains the locationpecific data, such as the managers details, the phone number,
the address, and so on. Note that RestaurantID is the foreign key. This design assumes that the
restaurant opens and closes at the same time every day; you may modify this design if you wish
*/
create table ottawaspoon.location(
    locationID int, 
    open_date date,
    manager varchar, 
    phone varchar, 
    address varchar, 
    hours_open int, --add constraint for opening and cloding
    hours_close int,
    restaurantId int,

    primary key (locationid),

    foreign key (restaurantId) references ottawaspoon.restaurant (restaurantId)
    );

/*
    Here we include the item name, as on the menu, the category (starter, main, desert) as well as the
type (food or beverage). RestaurantID is the foreign key.
*/
create table ottawaspoon.menuitem(
    itemID int, 
    name varchar,
    type varchar, 
    category varchar, 
    description varchar, 
    price int,
    restaurantID int,
    primary key (itemid),
    foreign key (restaurantID) references ottawaspoon.restaurant (restaurantID)
    );
	
/*
A rater may explicitly select the menu item, and add a specific rating between 1 (low) to 5 (high)
and a free text comment. All menu items should be selected from a list.
*/
create table ottawaspoon.ratingItem(
    userID int, 
    date date, 
    itemID int, 
    itemrating int, 
    comment varchar,
    primary key (userid,date,itemid),	
    foreign key (userID,date) references ottawaspoon.rating (userID,date),
    foreign key (itemID) references ottawaspoon.menuitem (itemID)
    );
/* 
*/
--New from Artem
    alter table ratingItem
    alter column comment SET DEFAULT 'no comment';
    