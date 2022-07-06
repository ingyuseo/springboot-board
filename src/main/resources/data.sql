TRUNCATE TABLE member;
INSERT INTO member(username, password, name, remark)
VALUES
    ('skku_student1','test1','stu1','test student'),
    ('skku_student2','test2','stu2','test student');

SET FOREIGN_KEY_CHECKS=0;

TRUNCATE TABLE board;
INSERT INTO board(id, title, remark)
VALUES
    (1,'자유게시판','자유게시판 입니다~'),
    (2,'질문게시판','Ask me!');

TRUNCATE TABLE post;
INSERT INTO post(board_id, title, contents,username)
VALUES
    (1, '돈벌고 싶어요','어떻게?','stu1'),
    (1, 'Study?','하실분?','stu2');

SET FOREIGN_KEY_CHECKS=1;