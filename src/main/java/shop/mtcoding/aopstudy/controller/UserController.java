package shop.mtcoding.aopstudy.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import shop.mtcoding.aopstudy.config.annotation.LoginUserAop;
import shop.mtcoding.aopstudy.config.annotation.LoginUserResolver;
import shop.mtcoding.aopstudy.model.User;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final HttpSession session;

    @GetMapping("/login")
    public String login(){
        User user = new User(1, "ssar", "1234", "0102222");
        session.setAttribute("loginUser", user);
        return "login ok";
    }

    @GetMapping("/user/1") // 인증 필요 없음
    public String userInfo(User user){
        System.out.println(user.getUsername());
        return "user ok";
    }

    @GetMapping("/auth/1")
    public String authInfo(@LoginUserAop User user){ // 인증 필요함
        System.out.println(user.getUsername());
        return "auth ok";
    }

    @GetMapping("/auth/resolve/1")
    public String authInfo22(@LoginUserResolver User user){ // 인증 필요함
        System.out.println(user.getUsername());
        return "auth ok";
    }
}
