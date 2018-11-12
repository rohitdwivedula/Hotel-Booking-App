CREATE TABLE hotel_reviews(
	review_id INT NOT NULL,
	username VARCHAR(255) NOT NULL,
	Hotel_ID INT NOT NULL,
	PRIMARY KEY (review_id),
	FOREIGN KEY (username) REFERENCES user_info(username)
);