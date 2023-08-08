BEGIN TRANSACTION;

DROP TABLE IF EXISTS Flashcard_Deck, Deck, Flashcard, users Cascade;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

Create Table Flashcard (
	flashcard_id serial,
	deck_id serial,
	subject varchar NOT NULL,
	question
	answer
);

Create Table Deck (
	deck_id serial,
	deckname
	user_id
);

Create Table Flashcard_Deck (
	flashcard_id int NOT NULL,
	deck_id int NOT NULL,
	sort
);

COMMIT TRANSACTION;