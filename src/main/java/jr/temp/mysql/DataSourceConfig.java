//package jr.temp.mysql;
//
//import jr.temp.mysql.cmn.dto.CredentialDto;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.vault.authentication.TokenAuthentication;
//import org.springframework.vault.client.VaultEndpoint;
//import org.springframework.vault.core.VaultTemplate;
//import org.springframework.vault.support.VaultResponseSupport;
//
//import javax.sql.DataSource;
//import java.net.URI;
//
///**
// * DB配置
// */
//@Slf4j
//@Configuration
//public class DataSourceConfig {
//
//    /**
//     * 创建可用数据源1
//     * @return 数据源
//     */
//    @Bean
//    public DataSource dataSourceOne() {
//        String username = "";
//        String password = "";
//
//        /* 指定vault服务的地址 */
//        URI uri = URI.create("http://192.168.2.3:8200");
//
//        /* 创建Vault连接用对象 */
//        // 还有就是这里的参数不能直接new VaultEndpoint(),然后再设置host或者port啥的，
//        // 因为VaultEndpoint默认的scheme为https,然后本地的服务是http的，所以访问不了的。
//        VaultTemplate vaultTemplate = new VaultTemplate(VaultEndpoint.from(uri),
//                new TokenAuthentication("hvs.nVK5W5n61K5UlsrRDt7DH2qR"));
//
//        /* 获取Vault登录用账户信息 */
//        //  * "database/creds/dbuser"：参照Vault配置时，config_server.sh中获取账户信息时使用的路径
//        VaultResponseSupport<CredentialDto> response = vaultTemplate.read("database/creds/dbuser", CredentialDto.class);
//        username = response.getData().getUsername();
//        password = response.getData().getPassword();
//        log.info("---- [DataSourceConfig.dataSourceOne] -- username: {}", username);
//        log.info("---- [DataSourceConfig.dataSourceOne] -- password: {}", password);
//
//        /* 生成数据源 */
//        return DataSourceBuilder.create()
//                .username(username)
//                .password(password)
//                .url("jdbc:mysql://localhost:3306/test_db?useUnicode=true&characterEncoding=utf-8&serverTimeZone=Asia/Shanghai&useSSL=true")
//                .driverClassName("com.mysql.cj.jdbc.Driver")
//                .build();
//    }
//}