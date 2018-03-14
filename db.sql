set search_path = 'ottawaspoon';
/*
The joinate is used to show when this rater first joined the website. The name field corresponds to
an alias such as SuperSizeMe. Type refers to the type of rater (blog, online, food critic) and
reputation takes a value between 1 and 5. The value of this field is based on the number of people
who found this rater opinion helpful, and the default value is 1 (lowest).
*/
create table public.rater(
    userID int, 
    name varchar, 
    type int, 
    join_date date, 
    reputation int,

    primary key (userid)
    );

alter table public.rater
add constraint rater_type
    check (type between 1 and 5);
/*
This relation contains general information about a restaurant and is useful in the case where a
restaurant chain has many locations. The type attribute contains details about the cuisine, such as
Italian, Indian, Middle Eastern, and so on.
*/
create table public.restaurant(
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
create table public.rating(
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

    foreign key (userID) references public.rater (userID),
    foreign key (restaurantID) references public.restaurant (restaurantID)
    );
/*
This relation contains the locationpecific data, such as the managers details, the phone number,
the address, and so on. Note that RestaurantID is the foreign key. This design assumes that the
restaurant opens and closes at the same time every day; you may modify this design if you wish
*/
create table public.location(
    locationID int, 
    open_date date,
    manager varchar, 
    phone int, 
    address varchar, 
    hours_open date, 
    hours_close date,
    restaurantId int,

    primary key (locationid),

    foreign key (restaurantId) references public.restaurant (restaurantId)
    );

/*
    Here we include the item name, as on the menu, the category (starter, main, desert) as well as the
type (food or beverage). RestaurantID is the foreign key.
*/
create table public.menuitem(
    itemID int, 
    name varchar,
    type varchar, 
    category varchar, 
    description varchar, 
    price int,
    restaurantID int,

    primary key (itemid),

    foreign key (restaurantID) references public.restaurant (restaurantID)
    );
	
/*
A rater may explicitly select the menu item, and add a specific rating between 1 (low) to 5 (high)
and a free text comment. All menu items should be selected from a list.
*/
create table public.ratingItem(
    userID int, 
    date date, 
    itemID int, 
    itemrating int, 
    comment varchar,

    primary key (userid,date,itemid),
	
    foreign key (userID,date) references public.rating (userID,date),
    foreign key (itemID) references public.menuitem (itemID)
    );


/* 
*/
