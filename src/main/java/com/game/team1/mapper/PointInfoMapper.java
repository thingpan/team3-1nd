package com.game.team1.mapper;

import com.game.team1.vo.PointInfoVO;

public interface PointInfoMapper {
    int insertPointInfo(PointInfoVO point);

    PointInfoVO selectMaxPoint(PointInfoVO point);

    
}
