create database poc4;

use poc4;

create table AUTHOR (AUTHOR_ID INT auto_increment primary key, AUTHOR_NAME VARCHAR(100) not null);
insert into author (author_name) values ("JAMES BOND");
select*from author;


CREATE TABLE POST  (POST_ID INT primary key auto_increment, 
                   POST_NAME varchar(300) not null,
                   AUTHOR_ID int,
                   foreign key(AUTHOR_ID) references AUTHOR (AUTHOR_ID),
                    CREATED_AT datetime);
select*from post;

INSERT INTO POST (POST_ID, POST_NAME, AUTHOR_ID, CREATED_AT) VALUES (
                                                                     1, "MY FIFTH POST",1,current_timestamp()),
                                                                     (2, "MY SIXTH POST",1,current_timestamp()),
                                                                     (3, "MY SEVENTH POST",2,current_timestamp()),
                                                                     (4, "MY EIGTH POST",3,current_timestamp()),
                                                                     (5, "MY NINTH POST",3,current_timestamp());
                                                                     

/* create table comment (
*/

CREATE TABLE COMMENT (COMMENT_ID INT PRIMARY KEY auto_increment,
                      CONTENT varchar(10000),
					  POST_ID INT,
                      foreign key(POST_ID) references POST (POST_ID),
                      CREATED_AT datetime,
					   USER_ID INT,
                       foreign key(USER_ID) references USER (USER_ID));
SELECT * FROM COMMENT;

INSERT INTO COMMENT (COMMENT_ID, CONTENT, POST_ID, CREATED_AT,USER_ID) VALUES (
																	1, "MY 1ST COMMENT",1,current_timestamp(),1),
                                                                     (2, "MY 6th COMMENT",2,current_timestamp(),2),
                                                                     (3, "MY 5th COMMENT",1,current_timestamp(),3),
                                                                     (4, "MY 4TH COMMENT",2,current_timestamp(),1),
                                                                     (5, "MY 8th COMMENT",1,current_timestamp(),2),
                                                                     (6, "MY 2ND COMMENT",2,current_timestamp(),2),
                                                                     (7, "MY 3RD COMMENT",3,current_timestamp(),3),
                                                                      (8, "MY 7th COMMENT",3,current_timestamp(),3),
																	 (9, "MY 9th COMMENT",3,current_timestamp(),3),
                                                                      (10, "MY 10th COMMENT",3,current_timestamp(),3),
                                                                       (11, "MY 11th COMMENT",3,current_timestamp(),3);
                                                                     


              
/* create table user */
					
CREATE TABLE USER (USER_ID INT PRIMARY KEY,
				 USER_NAME VARCHAR(100));
                 
insert into user(user_id,user_name) values (1,"Saurabh");
                 
SELECT*FROM USER;
                      
/* Query: Get list of Posts with latest 10 comments of each post authored by 'James Bond'*/


select P.POST_ID,P.POST_NAME,P.CREATED_AT,A.AUTHOR_NAME,C.COMMENT_ID,C.CONTENT,C.CREATED_AT
from POST P
right join AUTHOR A ON P.AUTHOR_ID=A.AUTHOR_ID
right join COMMENT C ON C.POST_ID=P.POST_ID  where A.AUTHOR_NAME="JAMES BOND"  ORDER BY C.CREATED_AT DESC;