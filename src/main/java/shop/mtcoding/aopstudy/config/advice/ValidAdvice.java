package shop.mtcoding.aopstudy.config.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import shop.mtcoding.aopstudy.config.exception.MyValidationException;

import java.util.HashMap;
import java.util.Map;

@Aspect
@Component
public class ValidAdvice {

    @Pointcut("@annotation(org.springframework.web.bind.annotation.PostMapping)")
    public void postMapping() {
    }

    @Pointcut("@annotation(org.springframework.web.bind.annotation.PutMapping)")
    public void putMapping() {
    }

    @Before("postMapping() || putMapping()")
    public void validationAdvice(JoinPoint jp) throws Throwable {
        Object[] args = jp.getArgs();
        for (Object arg : args) {
            if (arg instanceof BindingResult) {
                Errors errors = (Errors) arg;

                if (errors.hasErrors()) {
                    Map<String, String> errorMap = new HashMap<>();

                    for (FieldError error : errors.getFieldErrors()) {
                        errorMap.put(error.getField(), error.getDefaultMessage());
                    }
                    throw new MyValidationException(errorMap);
                }
            }
        }
    }
}
