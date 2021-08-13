INSERT INTO users (id, dob, name) VALUES (1000, sysdate(), 'First User');
INSERT INTO users (id, dob, name) VALUES (1001, sysdate(), 'Second User');
INSERT INTO users (id, dob, name) VALUES (1002, sysdate(), 'Third User');

INSERT INTO user_post (id, post_content, date, user_id) VALUES(2000, 'First User - post1', sysdate(), 1000);
INSERT INTO user_post (id, post_content, date, user_id) VALUES(2001, 'First User - post2', sysdate(), 1000);