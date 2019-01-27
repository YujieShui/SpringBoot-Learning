package Web;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;

/**
 * @author shui
 * @create 2019-01-27
 **/

@SpringBootTest(classes = QuickStart.class)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class TestQuickStart {

    @Resource
    private QuickStart quickStart;

    @Test
    public void testSayHello(){
        TestCase.assertEquals(this.quickStart.sayHello(),"Hello,World!");
    }
}
