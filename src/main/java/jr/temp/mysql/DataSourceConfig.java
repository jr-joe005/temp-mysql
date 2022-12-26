//package jr.temp.mysql;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.env.Environment;
//
//import javax.sql.DataSource;
//
///**
// * DB配置
// */
//@Slf4j
//@Configuration
//public class DataSourceConfig {
//
//
//    @Value("${username}")
//    String username = "root";
//
//    @Value("${password}")
//    String password = "password";
//
//    @Autowired
//    Environment env;
//
//    /**
//     * 创建可用数据源1
//     * @return 数据源
//     */
//    @Bean
//    public DataSource dataSourceOne() {
//
//
//        /********* 调试用代码 START ***********************************************************************************
//         ************************************************************************************************************ */
//        Object x0 = env.getProperty("test_db");
//        Object x1 = env.getProperty("username");
//        Object x2 = env.getProperty("password");
//        log.info("---- [DataSourceConfig.dataSourceOne] -- username     : {}", username);
//        log.info("---- [DataSourceConfig.dataSourceOne] -- password     : {}", password);
//        /********* 调试用代码 END ***********************************************************************************
//         ************************************************************************************************************ */
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