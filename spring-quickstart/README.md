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

