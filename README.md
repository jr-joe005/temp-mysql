# temp-mysql
#### 该项目主要处理内容：
  1. 在Spring Boot项目中，通过SSL连接到MySql数据库。<br/>
     ** 连接到DB的认证方式：账户+密码+SSL证书
  2. 在Spring Boot项目中，通过HashiCrop Vault，获取连接MySql数据库需要的账号密码，然后连接到MySql数据库。<br/>
     ** 尝试了3种DB登录用账户/密码的取得方式：键值对(kv),动态Vault角色,静态Vault角色。<br/>
     ** 不同于temp-postgre, 该项目未使用DataSourceConfig.java，DB连接相关配置直接在配置文件「application.yml」中体现。<br/>
     ** 使用Vault的pom依赖项为：spring-cloud-starter-vault-config
  
** 具体说明文档，见document/备注.md
