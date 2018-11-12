# Introduction

This Hotel Booking App was made using Java Swing Libraries built using the NetBeans Apache 9 IDE. To store and access data we used the MySQL Community Server v8.0.13 and MySQL Connector/J, a Java Database Connection (JDBC) driver.

# Database Design

We have four tables in the Database which store booking info, hotel reviews/ratings, room information and user information. 
+-----------------------------+
| Tables_in_hotel_booking_app |
+-----------------------------+
| booking_info                |
| hotel_reviews               |
| room_info                   |
| user_info                   |
+-----------------------------+

## booking_info
Every booking (whether valid  cancelled) is saved in this table. The variable 'status' '1' refers to confirmed bookings, and '0' refers to bookings that have been cancelled. 
+------------+--------------+------+-----+---------+-------+
| Field      | Type         | Null | Key | Default | Extra |
+------------+--------------+------+-----+---------+-------+
| Booking_ID | int(11)      | NO   | PRI | NULL    |       |
| username   | varchar(255) | NO   | MUL | NULL    |       |
| Room_ID    | int(11)      | NO   | MUL | NULL    |       |
| Hotel_ID   | int(11)      | NO   |     | NULL    |       |
| Date_In    | date         | NO   |     | NULL    |       |
| Date_Out   | date         | NO   |     | NULL    |       |
| ID_Number  | varchar(255) | YES  |     | NULL    |       |
| ID_Type    | varchar(24)  | YES  |     | NULL    |       |
| status     | int(11)      | YES  |     | NULL    |       |
+------------+--------------+------+-----+---------+-------+

## hotel_reviews
Reviews by earlier users are stored in this database. 
+-----------+--------------+------+-----+---------+-------+
| Field     | Type         | Null | Key | Default | Extra |
+-----------+--------------+------+-----+---------+-------+
| review_id | int(11)      | NO   | PRI | NULL    |       |
| username  | varchar(255) | NO   | MUL | NULL    |       |
| Hotel_ID  | int(11)      | NO   |     | NULL    |       |
+-----------+--------------+------+-----+---------+-------+

## room_info

+-------------------+--------------+------+-----+---------+-------+
| Field             | Type         | Null | Key | Default | Extra |
+-------------------+--------------+------+-----+---------+-------+
| Room_ID           | int(11)      | NO   | PRI | NULL    |       |
| Hotel_ID          | int(11)      | NO   |     | NULL    |       |
| Hotel_Name        | varchar(26)  | NO   |     | NULL    |       |
| Address           | varchar(105) | NO   |     | NULL    |       |
| Room_Number       | int(11)      | NO   |     | NULL    |       |
| City              | varchar(11)  | NO   |     | NULL    |       |
| Tariff            | decimal(6,1) | NO   |     | NULL    |       |
| Max_Occupants     | int(11)      | NO   |     | NULL    |       |
| City_View         | int(11)      | NO   |     | NULL    |       |
| Comp_BF           | int(11)      | NO   |     | NULL    |       |
| WiFi              | int(11)      | NO   |     | NULL    |       |
| Car_Rental        | int(11)      | NO   |     | NULL    |       |
| AC                | int(11)      | NO   |     | NULL    |       |
| Average_Rating    | decimal(5,1) | YES  |     | NULL    |       |
| Number_of_ratings | int(11)      | YES  |     | NULL    |       |
+-------------------+--------------+------+-----+---------+-------+

 
# About

This application was made in November 2018 by Rohit Dwivedula, Vamsi Nallappareddy and Shantanu Gupta.