BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

INSERT INTO flashcard (subject, question, answer, user_id)
VALUES
  ('Math', 'What is the formula for the area of a circle?', 'A = πr^2', 1),
  ('Math', 'What is the quadratic formula?', 'x = (-b ± √(b^2 - 4ac)) / 2a', 1),
  ('Math', 'What is the Pythagorean theorem?', 'In a right triangle, the square of the length of the hypotenuse is equal to the sum of the squares of the lengths of the other two sides.', 1),
  ('Math', 'What is the value of π (pi)?', 'Approximately 3.14159', 1),
  ('Science', 'What is Newton''s first law of motion?', 'An object at rest will stay at rest, and an object in motion will stay in motion unless acted upon by an external force.', 1),
  ('Science', 'What is the chemical symbol for gold?', 'Au', 1),
  ('Science', 'What is photosynthesis?', 'The process by which green plants and some other organisms use sunlight to synthesize foods with the help of chlorophyll.', 1),
  ('History', 'When did World War II end?', 'September 2, 1945', 2),
  ('History', 'Who was the first President of the United States?', 'George Washington', 2),
  ('Trivia', 'What is the largest mammal on Earth?', 'Blue whale', 2),
  ('Trivia', 'What is the capital of Australia?', 'Canberra', 2),
  ('Trivia', 'What is the tallest mountain in the world?', 'Mount Everest', 2);

 
  insert into deck (deckname, user_id)
  values ('Science', 1);
  insert into deck (deckname, user_id)
  values ('Math', 1);
  insert into deck (deckname, user_id)
  values ('History', 2);
  insert into deck (deckname, user_id)
  values ('Trivia', 2);

insert into flashcard_deck (flashcard_id, deck_id) values (1, 2);
insert into flashcard_deck (flashcard_id, deck_id) values (2, 1);
insert into flashcard_deck (flashcard_id, deck_id) values (3, 3);
insert into flashcard_deck (flashcard_id, deck_id) values (4, 4);
insert into flashcard_deck (flashcard_id, deck_id) values (5, 2);
insert into flashcard_deck (flashcard_id, deck_id) values (6, 1);
insert into flashcard_deck (flashcard_id, deck_id) values (7, 2);
insert into flashcard_deck (flashcard_id, deck_id) values (8, 1);
insert into flashcard_deck (flashcard_id, deck_id) values (9, 3);
insert into flashcard_deck (flashcard_id, deck_id) values (10, 4);
insert into flashcard_deck (flashcard_id, deck_id) values (11, 2);
insert into flashcard_deck (flashcard_id, deck_id) values (12, 4);


COMMIT TRANSACTION;
