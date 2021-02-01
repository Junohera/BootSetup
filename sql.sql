create table myuser(
    id varchar2(15)
    , name varchar2(30)
);

insert into myuser values('hong1', '홍길동1');
insert into myuser values('hong2', '홍길동2');
insert into myuser values('hong3', '홍길동3');
insert into myuser values('hong4', '홍길동4');
insert into myuser values('hong5', '홍길동5');

select * from myuser;

create table bbs(
    id varchar2(30),
    writer varchar2(30),
    title varchar2(30),
    content varchar2(1000)
);

select * from bbs order by id desc;

insert into bbs values('hong', 'gildon', '반갑습니다', '수고하세요');

CREATE SEQUENCE bbs_SEQ START WITH 1 INCREMENT BY 1;
delete from bbs;


insert into bbs values('hong', 'gildong', '반갑습니다', '수고하세요');
insert into bbs values('hong', 'gildona', '반갑습니다', '수고하세요');
insert into bbs values('hong', 'gildonz', '반갑습니다', '수고하세요');

select * from board;

select * from spmember;

delete from spmember;

insert into spmember values('juno1', '1234', '최준호1', '010', '2172', '7798', 'selectjuno@gmail.com');
insert into spmember values('juno2', '1234', '최준호2', '010', '2172', '7798', 'selectjuno@gmail.com');
insert into spmember values('juno3', '1234', '최준호3', '010', '2172', '7798', 'selectjuno@gmail.com');
insert into spmember values('juno4', '1234', '최준호4', '010', '2172', '7798', 'selectjuno@gmail.com');
insert into spmember values('juno5', '1234', '최준호5', '010', '2172', '7798', 'selectjuno@gmail.com');
insert into spmember values('juno6', '1234', '최준호6', '010', '2172', '7798', 'selectjuno@gmail.com');
insert into spmember values('juno7', '1234', '최준호7', '010', '2172', '7798', 'selectjuno@gmail.com');
insert into spmember values('juno8', '1234', '최준호8', '010', '2172', '7798', 'selectjuno@gmail.com');
insert into spmember values('juno9', '1234', '최준호9', '010', '2172', '7798', 'selectjuno@gmail.com');
insert into spmember values('juno10', '1234', '최준호10', '010', '2172', '7798', 'selectjuno@gmail.com');

select * from reply;
select * from reply where boardnum = 324;

select * from board;

alter table board add image varchar2(30);