set search_path = "ottawaspoon";
/*
The join‐date is used to show when this rater first joined the website. The name field corresponds to
an alias such as SuperSizeMe. Type refers to the type of rater (blog, online, food critic) and
reputation takes a value between 1 and 5. The value of this field is based on the number of people
who found this rater’s opinion helpful, and the default value is 1 (lowest).
*/
create table rater(
    userID int, 
    name varchar, 
    type varchar, 
    join_date date, 
    reputation int,

    primary key (userid)
    );
/*
The Price, Food, Mood and Staff attributes may take a value between 1 (low) to 5 (high). The
comments field is reserved for free text and will be used, in future, for sentiment analysis. Note
that UserID and RestaurantID are foreign keys
*/
create table rating(
    userID int,
    date date, 
    price int, 
    food int,
    mood int,
    staff int, 
    comment varchar, 
    restaurantiD int,

    primary key (userid, date),

    foreign key (userID) references rater (userID),
    foreign key (restaurantID) references restaurant (restaurantID)
    );
/*
This relation contains general information about a restaurant and is useful in the case where a
restaurant chain has many locations. The type attribute contains details about the cuisine, such as
Italian, Indian, Middle Eastern, and so on.
*/
create table restaurant(
    restaurantID int, 
    name varchar,
    type varchar,
    url varchar,

    primary key (restaurantId)
    );
/*
This relation contains the location‐specific data, such as the manager’s details, the phone number,
the address, and so on. Note that RestaurantID is the foreign key. This design assumes that the
restaurant opens and closes at the same time every day; you may modify this design if you wish
*/
create table location(
    locationID int, 
    open_date date,
    manager varchar, 
    phone int, 
    address varchar, 
    hours_open date, 
    hours_close date
    restaurantID int,

    primary key (locationid),

    foreign key restaurantID references restaurant (restaurantID)
    );
/*
    Here we include the item name, as on the menu, the category (starter, main, desert) as well as the
type (food or beverage). RestaurantID is the foreign key.
*/
create table menuitem(
    itemID int, 
    name varchar,
    type varchar, 
    category varchar, 
    description varchar, 
    price int
    restaurantID int,

    primary key (itemid),

    foreign key restaurantID references restaurant (restaurantID)
    );
/*
A rater may explicitly select the menu item, and add a specific rating between 1 (low) to 5 (high)
and a free text comment. All menu items should be selected from a list.
*/
create table ratingItem(
    userID int, 
    date date, 
    itemID int, 
    rating int, 
    comment varchar,

    primary key (userid,date,itemid),

    foreign key userID references rater (userID),
    foreign key date references rating (date),
    foreign key itemID references menuitem (itemID)
    );



--constrains
--pk
--alter table rater
--add constraint PK_id
--primary key (userid);

--alter table rating
--add constraint PK_userid_and_date
--primary key (userid, date);

--alter table restaurant
--add constraint PK_restid
--primary key (restaurantId);

--alter table location
--add constraint PK_locid
--primary key (locationid);

--alter table menuitem
--add constraint PK_menuItemID
--primary key (itemid);

--alter table ratingitem
--add constraint PK_userid_date_Itemid
--primary key (userid,date,itemid);

--fk will not change the constraint so do we need to make it searate????
--alter table rating
--add constraint FK_rater_rating
--foreign key (userid) references rater(userid);