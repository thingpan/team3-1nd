package com.game.team1.mapper;

import java.util.List;

import com.game.team1.vo.PointInfoVO;

public interface PointInfoMapper {
    int insertPointInfo(PointInfoVO point);

    PointInfoVO selectMaxPoint(PointInfoVO point);

    List<PointInfoVO>selectPointRank(PointInfoVO point);
}
