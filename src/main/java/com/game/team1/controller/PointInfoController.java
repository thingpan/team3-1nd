package com.game.team1.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.game.team1.service.PointInfoService;
import com.game.team1.vo.MsgVO;
import com.game.team1.vo.PointInfoVO;
import com.game.team1.vo.UserInfoVO;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController
public class PointInfoController {
    @Autowired
    PointInfoService pointInfoService;

    @PostMapping("/game-infos")
    public MsgVO insertPointInfo(@RequestBody PointInfoVO point, MsgVO msg) {
        int result = pointInfoService.insertPointInfo(point);
        msg.setMsg("점수 등록 실패!");
        if (result != 0) {
            msg.setMsg("점수 등록 성공!");
            msg.setUrl("/");
            msg.setSuccess(true);
        }
        return msg; 
    }

    @GetMapping("/point-infos/max")//그 게임에 대해 나의 베스트 점수 
    public PointInfoVO getMaxPointInfoVO(PointInfoVO point, HttpSession session) {
        log.info("이건 멕스포인트=>{}", point);
        UserInfoVO user = (UserInfoVO) session.getAttribute("user");
        point.setUiNum(user.getUiNum());
        return pointInfoService.selectMaxPoint(point);
    }

    @GetMapping("/point-infos/rank")//1위부터 10위까지 게임에 대한 점수 별로 정렬 
    public List<PointInfoVO> getPointInfoRank(PointInfoVO point) {
        return pointInfoService.selectPointRank(point);
    }

}
