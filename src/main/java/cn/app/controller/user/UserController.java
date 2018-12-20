package cn.app.controller.user;

import cn.app.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("admin")
    public String admin(){
        return "adminLogin";
    }


    @RequestMapping("login")
    public String login(@RequestParam("userCode") String userCode,@RequestParam("userPassoword") String userPassword, HttpSession session){
        if (userService.login(userCode,userPassword)!=null){
            session.removeAttribute("ex");
            session.setAttribute("user",userService.login(userCode,userPassword));
            return "index";
        }else{
            session.setAttribute("ex","*账号或密码错误");
            return "adminLogin";
        }

    }

    @RequestMapping("loginout")
    public String loginout(HttpSession session){
        session.invalidate();
        return "adminLogin";
    }
}
