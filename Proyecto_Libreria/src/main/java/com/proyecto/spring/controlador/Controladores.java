package com.proyecto.spring.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Controladores {
    
    @GetMapping("/")
    public String login() {
        return "login";
    }
    
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }
    
    @GetMapping("/index")
    public String index() {
        return "index";
    }
}
