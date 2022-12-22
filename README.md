# temp-mysql
#### 该项目主要处理内容：
  1. 在Spring Boot项目中，通过SSL连接到MySql数据库。<br/>
     <b>当前状况：</b>SSL+账户/密码两重认证连接到MySql成功；单独使用SSL验证连接到MySql未成功。
  2. 在Spring Boot项目中，通过HashiCrop Vault，获取连接MySql数据库需要的账号密码，然后连接到MySql数据库。<br/>
     <b>当前状况：</b>vault连接到Mysql使用的是账户/密码，未使用SSL证书验证
  
** 具体说明文档，见document/备注.md
