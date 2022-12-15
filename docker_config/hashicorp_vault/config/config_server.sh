#!/bin/sh

# 配置Vault连接
export VAULT_ADDR="http://127.0.0.1:8200"
export VAULT_TOKEN="$1"

# 验证Vault连接状况
vault status

# 创建secret engine：database
vault secrets enable database

# 创建与Postgresql的连接
vault write database/config/test_db \
      plugin_name="mysql-database-plugin" \
      allowed_roles="dbuser" \
      connection_url="{{username}}:{{password}}@tcp(192.168.3.137:3306)/test_db" \
      username="root" \
      password="password" \
      tls_certificate_key=@/vault/ssl_file/client-tls.pem \
      tls_ca=@/vault/ssl_file/ca.pem

# 创建Vault凭证角色

vault write database/roles/dbuser \
    db_name="test_db" \
    default_ttl="1h" \
    max_ttl="24h" \
    creation_statements="CREATE USER '{{name}}'@'%' IDENTIFIED BY '{{password}}';GRANT SELECT,INSERT,UPDATE ON *.* TO '{{name}}'@'%';" \

# 创建设置动态密钥策略
#vault policy write my_policy /vault/config/policy.hcl

# 使用创建的Postgresql连接和Vault凭证角色，创建并查看Postgresql登录账号和密码
vault read database/creds/dbuser