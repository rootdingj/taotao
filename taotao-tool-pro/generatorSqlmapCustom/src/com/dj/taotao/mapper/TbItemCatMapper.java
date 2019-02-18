package com.dj.taotao.mapper;

import com.dj.taotao.pojo.TbItemCat;
import com.dj.taotao.pojo.TbItemCatExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbItemCatMapper {
    long countByExample(TbItemCatExample example);

    int deleteByExample(TbItemCatExample example);

    int insert(TbItemCat record);

    int insertSelective(TbItemCat record);

    List<TbItemCat> selectByExample(TbItemCatExample example);

    int updateByExampleSelective(@Param("record") TbItemCat record, @Param("example") TbItemCatExample example);

    int updateByExample(@Param("record") TbItemCat record, @Param("example") TbItemCatExample example);
}