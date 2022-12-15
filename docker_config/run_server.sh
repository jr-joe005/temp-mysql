#!/bin/bash

# 停止/移除既存容器
docker stop mysql-db-server
docker stop vault-server
docker rm mysql-db-server
docker rm vault-server

# 启动容器,并初期化Postgresql
docker-compose up -d
sleep 60
docker exec -it mysql-db-server bash /etc/mysql/init/init_server.sh

# 重新启动并进入容器，查看实时日志
sleep 5
docker restart mysql-db-server
docker restart vault-server
docker-compose logs -f