import com.shuiyujie.StartSpringBootMain;
import com.shuiyujie.controller.MessageController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;

/**
 * @author shui
 * @create 2019-02-11
 **/
@SpringBootTest(classes = StartSpringBootMain.class)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class TestMessageController {
    @Resource
    private MessageController messageController;
    @Test
    public void testEcho() {
        System.out.println(this.messageController.echo("shuiyujie"));
    }
}
