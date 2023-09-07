package com.game.team1.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.game.team1.service.UserInfoService;
import com.game.team1.vo.UserInfoVO;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class UserInfoController {
    @Autowired
    private UserInfoService userService;
    
	@GetMapping("/user-infos")
	public List<UserInfoVO> getUserInfos(UserInfoVO user){

		return userService.getUserInfos(user);
	}
	@GetMapping("/user-infos/{uiNum}")
	public UserInfoVO getUserInfo(@PathVariable int uiNum) {
		log.info("uiNum=>{}", uiNum);
		return userService.getUserInfo(uiNum);
	}
    @PostMapping("/login")
    public String login(UserInfoVO user, Model m, HttpSession session){
        log.info("user=>{}", user);
        UserInfoVO loginUser = userService.login(user);
        m.addAttribute("msg", "아이디나 비번을 확인하세요");
        if(loginUser!=null){
            session.setAttribute("user", loginUser);
            //m
        }
        
        return "tmpl/user-info/login";
    }
}
