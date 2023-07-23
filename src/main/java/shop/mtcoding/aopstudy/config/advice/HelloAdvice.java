package shop.mtcoding.aopstudy.config.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class HelloAdvice {

    // 포인트 컷을 어노테이션에 적용
    @Pointcut("@annotation(shop.mtcoding.aopstudy.config.annotation.Hello)")
    public void hello(){}

    // JoinPoint 적용
    @Before("hello()")
    public void helloAdvice(JoinPoint jp) throws Throwable {
        Object[] args = jp.getArgs();
        if(args.length < 1){
            System.out.println("아무개님 안녕");
        }
        else{
            for (Object arg : args) {
                if(arg instanceof String){
                    String username = (String) arg;
                    System.out.println(username+"님 안녕");
                }
            }
        }
    }
}
