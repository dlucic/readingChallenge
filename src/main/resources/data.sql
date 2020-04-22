INSERT INTO challenges (name, type, status, winner, points)
VALUES ('challenge', 'Test', 'Ongoing', null, 100);

INSERT INTO users (first_name, last_name, username)
VALUES ('davorin', 'lucic', 'dava');

INSERT INTO challenges_users (challenge_id, user_id)
VALUES (1, 1);