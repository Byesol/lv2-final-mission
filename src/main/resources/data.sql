INSERT INTO book(title, author, isbn)
VALUES ('가면산장살인사건','히가시노게이고', 2344234),
       ('모순','양귀자', 234234234);
INSERT INTO member(email)
VALUES ('bsj5967');


INSERT INTO collection(location,collection_status,book_id)
VALUES ('2관 3층','BORROWED', 1),
       ('1관 3층','RESERVED', 2);

INSERT INTO borrow(collection_id,due_date)
VALUES (1,'2025-05-10');

INSERT INTO reservation(member_id,collection_id)
VALUES (1,1 );


