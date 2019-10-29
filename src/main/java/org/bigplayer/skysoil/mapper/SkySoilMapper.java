package org.bigplayer.skysoil.mapper;


import org.bigplayer.skysoil.common.dto.DoubleVo;
import org.bigplayer.skysoil.common.dto.ThreeVo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SkySoilMapper {
    Integer insertBlackBatch (List<DoubleVo> vo);


    Integer insertThreeBlackBatch (List<ThreeVo> vo);

    List<DoubleVo>  selectSome();

    int updateById(DoubleVo vo);
}