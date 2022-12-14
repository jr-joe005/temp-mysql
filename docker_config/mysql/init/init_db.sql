---- 测试用临时表 ----
CREATE TABLE person
(
    id INT,
    name VARCHAR(20),
    age INT,
    address VARCHAR(255)
);

INSERT INTO person(id, name, age, address) VALUES('100001', 'name_01', '20', 'address_01');
INSERT INTO person(id, name, age, address) VALUES('100002', 'name_02', '30', 'address_02');
INSERT INTO person(id, name, age, address) VALUES('100003', 'name_03', '25', 'address_03');

---- 验证数据插入是否成功 ----
select * from person;

---- 强制用户开启SSL认证 ----
ALTER USER 'testuser'@'%' REQUIRE SSL;
FLUSH PRIVILEGES;

---- 确认SSL状态 ----
use mysql;
show variables like '%ssl%';
select ssl_type from user where user='testuser' and host='%';
status;