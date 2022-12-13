#!/bin/bash

# 执行初期化SQL文
mysql -h192.168.3.137 -P3306 -utestuser -ptestpassword -Dtest_db</etc/mysql/init/init_db.sql