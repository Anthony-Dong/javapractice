package com.javase.day07.annotations;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Repository;

import java.lang.annotation.*;

/**
 * ClassName:MyAnnotation
 * Package:com.javase.day07.annotations
 * Description:
 *
 * @date:2019/7/13 0:55
 * @author: 574986060@qq.com
 */


@Repeatable(MyAnnotations.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.TYPE})
public @interface MyAnnotation {

    String value();

}
