package com.game.team1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.game.team1.mapper.PointInfoMapper;
import com.game.team1.vo.PointInfoVO;
@Service
public class PointInfoService {
    @Autowired
    PointInfoMapper pointInfoMapper;

    public int insertPointInfo(PointInfoVO point){
        return pointInfoMapper.insertPointInfo(point);
    }
    public PointInfoVO selectMaxPoint(PointInfoVO point){
        return pointInfoMapper.selectMaxPoint(point);
    }
    public List<PointInfoVO> selectPointRank(PointInfoVO point ){
        return pointInfoMapper.selectPointRank(point);
    }
}
