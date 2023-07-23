package shop.mtcoding.aopstudy.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import shop.mtcoding.aopstudy.config.annotation.Hello;

@RestController
public class HelloController {

    // HelloAdvice Test
    @GetMapping("/hello/v1")
    public String v1(){
        return "v1";
    }

    // HelloAdvice Test
    // http://localhost:8080/hello/v2?username=ssar
    @Hello
    @GetMapping("/hello/v2")
    public String v2(String username){
        return "v2";
    }

    // HelloAdvice Test
    @Hello
    @GetMapping("/hello/v3")
    public String v3(){
        return "v3";
    }
}
