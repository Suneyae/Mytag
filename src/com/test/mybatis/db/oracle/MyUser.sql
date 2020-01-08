--select * from MyUser for update;

--建表语句
create table MyUser (
id number,
username varchar2(32) not null,
password varchar2(128) not null,
administrator varchar2(5),
primary key (id)
);

--插入数据
insert into MyUser
  (ID, USERNAME, PASSWORD, ADMINISTRATOR)
values
  (BXGX_SEQ_AAZ611.Nextval,
   'weiyongle' || BXGX_SEQ_AAZ611.Nextval,
   'hr',
   'hr');