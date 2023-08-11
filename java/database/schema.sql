BEGIN TRANSACTION;

DROP TABLE IF EXISTS Flashcard_Deck, Flashcard, Deck, users Cascade;
DROP SEQUENCE IF EXISTS flashcard_id;


CREATE SEQUENCE flashcard_id
	INCREMENT BY 1
	start with 1001
	NO MAXVALUE;


CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

Create Table Deck (
	deck_id SERIAL,
	deckname varchar(50) NOT NULL,
	user_id int NOT NULL,
	CONSTRAINT PK_Deck PRIMARY KEY(deck_id),
	CONSTRAINT FK_user_id FOREIGN KEY(user_id) References users(user_id)
);

Create Table Flashcard (
	flashcard_id SERIAL,
	user_id int NOT NULL,
	subject varchar(100) NOT NULL,
	question varchar NOT NULL,
	answer varchar NOT NULL,
	CONSTRAINT PK_Flashcard PRIMARY KEY (flashcard_id),
	CONSTRAINT FK_user_id FOREIGN KEY(user_id) References users(user_id)
);


Create Table Flashcard_Deck (
	flashcard_id int NOT NULL,
	deck_id int NOT NULL,
	CONSTRAINT FK_flashcard_id FOREIGN KEY(flashcard_id) REFERENCES Flashcard(flashcard_id),
	CONSTRAINT FK_deck_id FOREIGN KEY(deck_id) REFERENCES Deck(deck_id),
	CONSTRAINT PK_Flashcard_Deck PRIMARY KEY(flashcard_id, deck_id)
);
  COMMIT TRANSACTION;
