package wly.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import wly.entity.lh.Person;

import java.lang.reflect.Method;

/**
 * @ClassName MyFirstAspect
 * @Description 自定义注解的切面
 * @Author lvhao@cloudwalk.cn
 * @Date 2019/4/2 14:23
 * @Version 1.0
 **/
@Aspect
@Configuration
public class MyFirstAspect {

    private Logger LOGGER = LoggerFactory.getLogger(MyFirstAspect.class);

    @Pointcut("@annotation(wly.common.MyFirstAnnotation)")
    public void firstPointCut() {
    }

    /**
     * 环绕
     *
     * @param joinPoint
     */
    @Around("firstPointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        MyFirstAnnotation annotation = method.getAnnotation(MyFirstAnnotation.class);
        LOGGER.info("正在进行对类{}中方法{}进行增删改查开始", joinPoint.getTarget().getClass().getName(), method.getName());

        //
        Class<?>[]  groupsClass = annotation.groups();




        Object[] args = joinPoint.getArgs();
        Object arg = args[0];
        Person person = (Person)arg;
        // 返回所有的属性
        LOGGER.info(annotation.value());
        LOGGER.info("---人员姓名{}，人员年龄{}",person.getName(),person.getAge());
        return joinPoint.proceed();
    }



}