package jr.temp.mysql.index;

import com.zaxxer.hikari.HikariDataSource;
import jr.temp.mysql.cmn.entity.Person;
import jr.temp.mysql.cmn.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.sql.DataSource;

/**
 * 测试用画面Controller
 */
@Slf4j
@Controller
public class IndexController {

    /** 测试用表Repository */
    @Autowired
    PersonRepository personRepository;

    @Autowired
    DataSource datasource;

    /** Index页 */
    @GetMapping("/")
    public String index(){

        try {
            /* 查看DB连接信息 */
            HikariDataSource hikariDataSource = (HikariDataSource)datasource;
            String username = hikariDataSource.getUsername();
            String password = hikariDataSource.getPassword();
            log.info("---- [IndexController.index] -- DB_username: {}", username);
            log.info("---- [IndexController.index] -- DB_password: {}", password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        /* 获取DB数据 */
        Person person = personRepository.getReferenceById(100002);
        log.info("---- [IndexController.index] -- id         : {}", person.getId());
        log.info("---- [IndexController.index] -- name       : {}", person.getName());
        log.info("---- [IndexController.index] -- age        : {}", person.getAge());
        log.info("---- [IndexController.index] -- address    : {}", person.getAddress());

        return "index";
    }
}