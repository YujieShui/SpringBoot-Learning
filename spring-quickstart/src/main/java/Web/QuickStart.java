package Web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shui
 * @create 2019-01-27
 **/
@RestController
public class QuickStart {
    @RequestMapping("/")
    public String sayHello() {
        return "Hello,World!";
    }
}