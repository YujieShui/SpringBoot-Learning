# springboot 错误处理，数据校验错误

SpringBoot 错误处理有三种情况
- 数据验证错误
- 错误页指派
- 全局异常处理

比如说在提交表单信息的时候，有些信息没填，有些信息有规范的格式，如果不符合要求就是数据校验错误。

我们需要对这些数据的格式进行校验，不符合要求不能接受且要提示错误信息。

SpringBoot 有数据校验的默认支持，该支持由 Hibernate 开发框架提供。

错误信息统一配置在`ValidationMessages.properties`文件中。

![验证注解](http://image.shuiyujie.com/2019-02-12-15-48-04.png)

这种方式每个 VO 类在`ValidationMessages.properties`文件中配置对应的错误信息，并且在 VO 类的属性上添加上错误注解，过程繁琐。不推荐使用，更推荐使用反射和拦截器的方式处理错误信息。

但是我们还是要会使用这种方式处理数据验证错误，写了一个小 Demo，再接下来简单记录一下使用过程。

# 添加错误信息配置文件

`src/main/resources`目录中建立`ValidationMessages.properties`文件。文件中配置错误信息

```
member.mid.notnull.error=邮箱不允许为空
member.mid.email.error=邮箱格式错误
member.mid.length.error=邮箱长度错误
member.age.notnull.error=年龄不允许为空
member.age.digits.error=年龄格式错误
member.salary.notnull.error=工资不允许为空
member.salary.digits.error=工资格式错误
member.birthday.notnull.error=生日不允许为空
```

# VO 类添加注解

```java
SuppressWarnings("serial")
public class Member implements Serializable {
    @NotNull(message="{member.mid.notnull.error}")
    @Email(message="{member.mid.email.error}")
    @Length(min=6,message="{member.mid.length.error}")
    private String mid ;
    @NotNull(message="{member.age.notnull.error}")
    @Digits(integer=3,fraction=0,message="{member.age.digits.error}")
    private Integer age ;
    @NotNull(message="{member.salary.notnull.error}")
    @Digits(integer=20,fraction=2,message="{member.salary.digits.error}")
    private Double salary ;
    @NotNull(message="{member.birthday.notnull.error}")
    private Date birthday ;

}
```

# 控制器配置校验

```java
@RequestMapping(value = "/add", method = RequestMethod.POST)
@ResponseBody
public Object add(@Valid Member vo, BindingResult result) {
    if (result.hasErrors()) {
        Iterator<ObjectError> iterator = result.getAllErrors().iterator();
        while (iterator.hasNext()) {
            ObjectError error = iterator.next();
            System.out.println("【错误信息】code = " + error.getCode() + "，message = " + error.getDefaultMessage());
        }
        return result.getAllErrors();
    } else {
        return vo;
    }
}
```