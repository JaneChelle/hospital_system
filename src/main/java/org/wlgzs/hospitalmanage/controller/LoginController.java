package org.wlgzs.hospitalmanage.controller;

/*
 * @author 武凯焱
 * @date 2018/8/19 15:47
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.wlgzs.hospitalmanage.base.BaseController;
import org.wlgzs.hospitalmanage.util.Result;
import org.wlgzs.hospitalmanage.util.ResultCode;
import org.wlgzs.hospitalmanage.util.UserProperties;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
//操作员登录
public class LoginController extends BaseController {
    @Autowired
    private UserProperties userProperties;
    @RequestMapping("/toLogin")
    public ModelAndView toLogin(){
        return new ModelAndView("login");
    }
    @RequestMapping("/login")
    public Result login(HttpSession session, @RequestParam("userAccount") String userAccount, @RequestParam("userPassword") String userPassword) {
        List<String> userAccounts = userProperties.getUserAccounts();
        List<String> userPasswords = userProperties.getUserPasswords();
       // List<String> userNames = userProperties.getUserNames();
        List<Integer> userCodes = userProperties.getOperatorCodes();
        for (int i = 0; i < userAccounts.size(); i++) {
            if (userAccount.equals(userAccounts.get(i))) {
                String password = userPasswords.get(i);
                if (password.equals(userPassword)) {
                    session.setAttribute("user", userAccount);
                    System.out.println("登录成功");
                    return new Result(ResultCode.SUCCESS, "登录成功");
                }
            }
        }
        return new Result(ResultCode.FAIL, "账号密码错误");
    }

    //首页
    @RequestMapping("/hospital/toHome")
    public ModelAndView toHome(){
        return new ModelAndView("adminIndex");
    }

    //首页
    @RequestMapping("/hospital/toHospital")
    public ModelAndView toHospital(){
        return new ModelAndView("hospital");
    }
    //退出登录
    @RequestMapping("/outLogin")
    public ModelAndView outLogin(){
        session.removeAttribute("user");
        return new ModelAndView("login");
    }
}
