package com.cafe.mall.common.controller;

import com.cafe.mall.common.model.User;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;

// 1. 원격 프로그램으로 등록
@Controller
@RequestMapping(value = "/home")
public class HomeController {
    // 2. URL과 메서드를 연결
    @RequestMapping("/")
    public String main() {
        return "layouts/mainLayout";
    }

    @GetMapping("/login")
    public String showLogin() {
        return "member/login"; // login.html을 화면에 보여줌
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

    @GetMapping(value="/test")
    public String test(Model model, HttpServletRequest req) {
        req.setAttribute("year", 2024);

        HttpSession session = req.getSession(); //요창으로부터 session 객체 저장
        session.setAttribute("id", "cyjo1207");

        ServletContext application = session.getServletContext();
        application.setAttribute("email", "cyjo1207@gmail.com");

        model.addAttribute("lastName", "Choi");
        model.addAttribute("firstName", "YongJo");
        model.addAttribute("list", Arrays.asList("aaa","bbb","ccc","ddd","eee"));
        model.addAttribute("bno", 1);
        model.addAttribute("user", new User("aaa", 30));
        return "test";
    }

}
