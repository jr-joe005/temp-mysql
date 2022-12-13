package jr.temp.mysql.index;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 测试用画面Controller
 */
@Controller
public class IndexController {

    /** Index页 */
    @GetMapping("/")
    public String index(){

        return "index";
    }
}