
------- *** Spring *** --------

create table spring_mybatistest
(no       number
,name     varchar2(20)
,email    varchar2(100)
,tel      varchar2(20)
,addr     varchar2(200)
,writeday date default sysdate
);

create sequence seq_mybatistest
start with 1
increment by 1
nomaxvalue
nominvalue
nocycle
nocache;


select *
from spring_mybatistest
order by no desc;


create table spring_member
(num       number
,irum      varchar2(20)
,mobile    varchar2(20)
,address   varchar2(200)
,writeday date default sysdate
);

create sequence seq_spring_member
start with 1
increment by 1
nomaxvalue
nominvalue
nocycle
nocache;


select *
from spring_member
order by num desc;


insert into spring_member(num, irum, mobile, address, writeday) 
values(seq_spring_member.nextval, '김희숙', '010-2345-2356', '서울시 연신내', default);

insert into spring_member(num, irum, mobile, address, writeday) 
values(seq_spring_member.nextval, '박효윤', '010-4354-3467', '경기도 수원시', default);

commit;

select *
from spring_member;

alter table spring_member
add hobby varchar2(20);

update spring_member set hobby = '볼링';

commit;


----- *** 문제 *** ------
create table spring_quizmember
(no            number
,name          varchar2(20)
,email         varchar2(100)
,tel           varchar2(20)
,addr          varchar2(200)
,schoolgrade   number(1)    --- 1 : 대졸이상 , 2 : 초대졸 , 3 : 고졸
,writeday date default sysdate
);

create sequence seq_quizmember
start with 1
increment by 1
nomaxvalue
nominvalue
nocycle
nocache;

select *
from spring_quizmember
order by no desc;

--------------------------------------------------------
show user;
-- USER이(가) "HR"입니다.

grant select on departments to myorauser;
grant select on employees to myorauser;
---------------------------------------------------------

show user;
-- USER이(가) "MYORAUSER"입니다.

select *
from hr.departments;

select *
from hr.employees;

create table departments
as
select *
from hr.departments;

create table employees
as
select *
from hr.employees;

select *
from departments;

select *
from employees;


select E.department_id, D.department_name, E.employee_id,
       E.first_name || ' ' || E.last_name as ENAME,
       E.jubun,
       case when substr(E.jubun, 7, 1) in('1','3') then '남' else '여' end as GENDER,
       extract(year from sysdate) - ( substr(E.jubun, 1, 2) + case when substr(E.jubun, 7, 1) in('1','2') then 1900 else 2000 end) + 1 as AGE,
       ltrim( to_char( nvl(E.salary + (E.commission_pct * E.salary), E.salary)*12, 'L9,999,999,999' ) ) as YEARPAY
from employees E left join departments D
on E.department_id = D.department_id
order by E.department_id, E.employee_id;


create or replace view view_employeeDept
as
select E.department_id, D.department_name, E.employee_id,
       E.first_name || ' ' || E.last_name as ENAME,
       E.jubun,
       case when substr(E.jubun, 7, 1) in('1','3') then '남' else '여' end as GENDER,
       extract(year from sysdate) - ( substr(E.jubun, 1, 2) + case when substr(E.jubun, 7, 1) in('1','2') then 1900 else 2000 end) + 1 as AGE,
       ltrim( to_char( nvl(E.salary + (E.commission_pct * E.salary), E.salary)*12, 'L9,999,999,999' ) ) as YEARPAY
from employees E left join departments D
on E.department_id = D.department_id
order by E.department_id, E.employee_id;


select *
from view_employeeDept;


select distinct nvl(department_id, -9999) as department_id
from view_employeeDept
order by department_id;


select *
from view_employeeDept
where department_id is null;






