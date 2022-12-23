package jr.temp.mysql;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * DB配置
 */
@Slf4j
@Configuration
public class DataSourceConfig {


    @Value("${username}")
    String username = "xxxx";

    @Value("${password}")
    String password = "yyyy";

    /**
     * 创建可用数据源1
     * @return 数据源
     */
    @Bean
    public DataSource dataSourceOne() {


        /********* 调试用代码 START ***********************************************************************************
         ************************************************************************************************************ */


        /********* 调试用代码 END ***********************************************************************************
         ************************************************************************************************************ */

        /* 生成数据源 */
        return DataSourceBuilder.create()
                .username(username)
                .password(password)
                .url("jdbc:mysql://localhost:3306/test_db?useUnicode=true&characterEncoding=utf-8&serverTimeZone=Asia/Shanghai&useSSL=true")
                .driverClassName("com.mysql.cj.jdbc.Driver")
                .build();
    }
}