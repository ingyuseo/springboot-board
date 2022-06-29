TRUNCATE TABLE member;
INSERT INTO member(username, password, name, remark)
VALUES
    ('skku_student1','test1','stu1','test student'),
    ('skku_student2','test2','stu2','test student');

SET FOREIGN_KEY_CHECKS=0;

TRUNCATE TABLE board;
INSERT INTO board(id, title, remark)
VALUES
    (1,'Free board','hihi'),
    (2,'Q&A','Ask me!');

TRUNCATE TABLE post;
INSERT INTO post(board_id, title, contents,username)
VALUES
    (1, 'Wanna be rich','HOW?','stu1'),
    (1, 'Study?','Hard to me','stu2');

SET FOREIGN_KEY_CHECKS=1;