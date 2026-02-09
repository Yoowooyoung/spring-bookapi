package com.example.bookapi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // 주의: @RestController가 아닙니다!
public class ViewController {

    @GetMapping("/main")
    public String mainPage() {
        // "main"이라는 문자열을 반환하면 templates/main.html을 찾습니다.
        return "main";
    }
}