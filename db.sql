set search_path = "ottawaspoon";

create table rater(userID int, name varchar, type varchar, join_date date, reputation int);
create table rating(userID int, date date, price int, food int, mood int, staff int, comment varchar, restiD int);
create table restaurant(restID int, name varchar, type varchar, url varchar);
create table location(locID int, restID int, open_date date, manager varchar, phone int, address varchar, hours_open date, hourse_close date);
create table menuitem(itemID int, restID int, name varchar, type varchar, category varchar, description varchar, price int);
create table ratingItem(userID int, date date, itemid int, rating int, comment varchar);