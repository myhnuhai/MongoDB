package org.myhnuhai.controller.mvc;

import org.myhnuhai.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Helloworld")
public class HelloController extends BaseController {

    @RequestMapping("/hello.html")
    public String printWelcome(ModelMap model) {
        model.addAttribute("message", "Hello world!");
        return "/index";
    }
}