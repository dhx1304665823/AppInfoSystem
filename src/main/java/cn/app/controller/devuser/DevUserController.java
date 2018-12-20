package cn.app.controller.devuser;

import cn.app.service.devuser.DevUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/dev")
public class DevUserController {

    @Resource
    private DevUserService devUserService;

    @RequestMapping("login")
    private String deng(){
        return "login";
    }

    @RequestMapping("logins")
    public String login(@RequestParam("devCode") String devCode,@RequestParam("devPassoword") String devPassoword, Model model, HttpSession session){

        if (null!=devUserService.getCode(devCode)){
               if (devUserService.getPaw(devCode,devPassoword)!=null){
                  session.setAttribute("user",devUserService.getPaw(devCode,devPassoword));
                  session.removeAttribute("ex");
                   return "appIndex";
               }else{
                   session.setAttribute("ex","*密码错误");
                   return "redirect:/dev/login";
               }
        }else{
            model.addAttribute("ex","*用户名不存在");
            return "redirect:/dev/login";
        }
    }
    @RequestMapping("loginout")
    public String loginout(HttpSession session){
            session.invalidate();
        return "redirect:/index.jsp";
    }
}
