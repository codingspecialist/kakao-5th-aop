package shop.mtcoding.aopstudy.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class HelloAdvice {

    // 깃발에 별칭주기
    @Pointcut("@annotation(shop.mtcoding.aopstudy.config.annotation.Hello)")
    public void hello(){}

    @Around("hello()")
    public Object helloAdvice(ProceedingJoinPoint jp) throws Throwable {
        Object[] args = jp.getArgs();

        for (Object arg : args) {
            if(arg instanceof String){
                String username = (String) arg;
                System.out.println(username+"님 안녕");
            }
        }
        return jp.proceed();
    }
}
