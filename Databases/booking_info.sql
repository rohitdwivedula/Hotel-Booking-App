CREATE TABLE booking_info(
Booking_ID INT NOT NULL,
username VARCHAR(255) NOT NULL,
Hotel_ID INT NOT NULL,
rooms_confirmed INT NOT NULL,
rooms_waitlist INT NOT NULL,
Date_In DATE NOT NULL,
Date_Out DATE NOT NULL,
ID_Type VARCHAR(24),
ID_Number VARCHAR(255),
Status INT NOT NULL,
PRIMARY KEY (Booking_ID),
FOREIGN KEY (username) REFERENCES user_info(username)
);
