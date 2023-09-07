package com.game.team1.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.game.team1.vo.TestVO;

@Controller
public class TestController {
    @GetMapping("/test")
    public void goTest(Model m){
        m.addAttribute("name", "test");
        m.addAttribute("age", "30");
    }

}
