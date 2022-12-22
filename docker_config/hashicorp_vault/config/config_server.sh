#!/bin/sh

# 配置Vault连接
export VAULT_ADDR="http://127.0.0.1:8200"
export VAULT_TOKEN="$1"

# 验证Vault连接状况
vault status

# 创建secret engine：database
vault secrets enable database

# 创建与Mysql的连接
vault write database/config/test_db \
      plugin_name="mysql-database-plugin" \
      connection_url="{{username}}:{{password}}@tcp(192.168.2.3:3306)/test_db" \
      allowed_roles="dbuser" \
      username="root" \
      password="password"

# 设置动态密钥策略
vault write database/roles/dbuser \
    db_name="test_db" \
    creation_statements="CREATE USER '{{name}}'@'%' IDENTIFIED BY '{{password}}';GRANT SELECT,INSERT,UPDATE ON *.* TO '{{name}}'@'%';" \
    default_ttl="1h" \
    max_ttl="24h"

# 使用创建的Mysql连接和Vault凭证角色，创建并查看Mysql登录账号和密码
vault read database/creds/dbuser