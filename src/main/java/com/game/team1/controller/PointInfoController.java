package com.game.team1.controller;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.game.team1.service.PointInfoService;
import com.game.team1.vo.MsgVO;
import com.game.team1.vo.PointInfoVO;
import com.game.team1.vo.UserInfoVO;

import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class PointInfoController {
    @Autowired
    PointInfoService pointInfoService;

    @PostMapping("/game-infos")
    public MsgVO insertPointInfo(@RequestBody PointInfoVO point, MsgVO msg) {
        int result = pointInfoService.insertPointInfo(point);
        msg.setMsg("점수 등록 실패!");
        if(result != 0){
            msg.setMsg("점수 등록 성공!");
            msg.setUrl("/");
            msg.setSuccess(true);
        }
        return msg;
    }
    @GetMapping("/point-infos/max")
    public PointInfoVO getMaxPointInfoVO(PointInfoVO point,HttpSession session){
        UserInfoVO user =(UserInfoVO)session.getAttribute("user");
        point.setUiNum(user.getUiNum());
        
        return pointInfoService.selectMaxPoint(point);
    }
    
}
