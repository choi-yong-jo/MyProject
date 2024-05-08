package com.cafe.api.common.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

// 1. 원격 프로그램으로 등록
@RestController
@RequestMapping(value = "/home")
public class HomeController {
    @RequestMapping("/")
    public String main() {
        System.out.println("Hello");
        return "Hello World";
    }

    @PostMapping("/loginProc")
    public String login(HttpServletRequest request, String id, String pwd, RedirectAttributes model) throws Exception{
        // 1. id, pwd를 확인
        if(loginCheck(id,pwd)) {
            // 2. 일치하면, userInfo.html
            model.addAttribute("id", id);
            model.addAttribute("pwd", pwd);
            return "member/userInfo" ;  // userInfo.html
        } else {
            String msg = "id 또는 pwd가 일치하지 않습니다.";
            model.addAttribute("msg", msg);
            model.addFlashAttribute("msg", "일회용 메세지");

            return "redirect:/home/login";
        }
    }

    private boolean loginCheck(String id, String pwd) {
        return id.equals("cyjo1207") && pwd.equals("yjchoi1207");
    }

}
