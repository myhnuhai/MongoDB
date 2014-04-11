package org.myhnuhai.controller.mvc;

import org.myhnuhai.controller.BaseController;
import org.myhnuhai.domain.User;
import org.myhnuhai.service.impl.UserService;
import org.myhnuhai.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.SyncTaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 14-1-16.
 */
@Controller
@RequestMapping("/userController")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @RequestMapping("/find.html")
    @ResponseBody
    public Result getUser(){

        User u = userService.findUserByUserName("myh2");
        System.out.println(u);
       addAttr("user",u);
       addAttr("status","加载成功！");
        return result;
    }

    @RequestMapping("/save")
    @ResponseBody
    public void saveUser(){
        for (int i = 0; i < 10; i++) {
             User u = new User();
            u.setPassword("myhnuhai" + i);
            u.setUserid("123" + i);
            u.setUsername("myh" + i);

            User user = userService.saveUser(u);
            System.out.println(user);
        }

    }
}
