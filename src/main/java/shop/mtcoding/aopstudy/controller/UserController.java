package shop.mtcoding.aopstudy.controller;

import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import shop.mtcoding.aopstudy.dto.JoinDTO;

import javax.validation.Valid;

@RestController
public class UserController {

    // LogAdvice Test
    @GetMapping("/user/v1")
    public String v1(){
        return "v1";
    }

    // LogAdvice Test
    @GetMapping("/user/v2")
    public String v2(){
        return "v2";
    }

    // ValidAdvice Test
    @PostMapping("/valid")
    public String join(@RequestBody @Valid JoinDTO joinDTO, Errors errors){
        return "ok";
    }
}
