#!/bin/bash

# 执行初期化SQL文
mysql -uroot -ppassword -Dtest_db</etc/mysql/init/init_db.sql

# 配置Postgresql配置文件及SSL证书
echo "conf file move ... START"
cp -f /etc/mysql/ssl_file/ca.pem /var/lib/mysql
cp -f /etc/mysql/ssl_file/ca-key.pem /var/lib/mysql
cp -f /etc/mysql/ssl_file/client-cert.pem /var/lib/mysql
cp -f /etc/mysql/ssl_file/client-key.pem /var/lib/mysql
cp -f /etc/mysql/ssl_file/private_key.pem /var/lib/mysql
cp -f /etc/mysql/ssl_file/public_key.pem /var/lib/mysql
cp -f /etc/mysql/ssl_file/server-cert.pem /var/lib/mysql
cp -f /etc/mysql/ssl_file/server-key.pem /var/lib/mysql
echo "conf file move ... END"