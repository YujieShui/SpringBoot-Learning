package com.shuiyujie.VO;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * @author shui
 * @create 2019-02-12
 **/
@SuppressWarnings("serial")
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

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Member{" +
                "mid='" + mid + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", birthday=" + birthday +
                '}';
    }
}

