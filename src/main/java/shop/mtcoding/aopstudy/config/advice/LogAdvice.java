package shop.mtcoding.aopstudy.config.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAdvice {

    @Around("execution(* shop.mtcoding.aopstudy.controller.UserController.*(..))")
    public Object logAdvice(ProceedingJoinPoint jp) throws Throwable {
        Object result = jp.proceed();
        System.out.println(result+"리턴됨");
        return result;
    }
}
