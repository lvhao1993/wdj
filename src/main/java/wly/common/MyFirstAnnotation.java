package wly.common;

import org.springframework.stereotype.Component;

import javax.validation.groups.Default;
import java.lang.annotation.*;

/**
 * 第一个自定义注解，用来打印LOG日志
 */
@Target({ ElementType.TYPE ,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface MyFirstAnnotation {
    String value() default "";
    int[] argsIndexs() default {0};
    Class<?>[] groups() default {Default.class};
}
