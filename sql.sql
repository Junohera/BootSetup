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
