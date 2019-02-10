# SpringBoot Quickstart

```
pom.xml
|
|---spring-quickstart
        |
        |---pom.xml
        |
        |---main.java.web
            |
            |---Application.java
            |---QuickStart.java

```

# pom.xml

```
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <parent>
        <artifactId>spring-learning</artifactId>
        <groupId>com.shuiyujie</groupId>
        <version>1.0-SNAPSHOT</version>
    </parent>
    <modelVersion>4.0.0</modelVersion>

    <artifactId>spring-quickstart</artifactId>

    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
            <version>RELEASE</version>
            <scope>compile</scope>
        </dependency>
    </dependencies>

</project>
```

# Application.java

```java
package Web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author shui
 * @create 2019-01-27
 **/
@SpringBootApplication
public class Application {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
}

```

SpringBoot 启动类不能直接放在 java 目录下，需要放在 java 目录下的包里面，不然要报错。

# QuickStart.java

```java
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
```

# SpringBoot Junit 进行单元测试示例

添加依赖

```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-test</artifactId>
    <scope>test</scope>
</dependency>
```

建立测试类

```java
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
```

@SpringBootTest(classes = QuickStart.class) - 要测试哪一个类
@RunWith(SpringJUnit4ClassRunner.class) - 用 SpringBoot 的 Junit 来测试(和一般 Junit 测试不一样)
@WebAppConfiguration - 表示以一个 Web 应用的方式启动