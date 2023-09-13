package com.game.team1.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.game.team1.service.PointInfoService;
import com.game.team1.vo.MsgVO;
import com.game.team1.vo.PointInfoVO;

import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class PointInfoController {
    @Autowired
    PointInfoService pointInfoService;

    @PostMapping("/game-insert")
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
    
}
