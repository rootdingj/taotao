package com.dj.taotao.mapper;

import com.dj.taotao.pojo.TbItemDesc;
import com.dj.taotao.pojo.TbItemDescExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbItemDescMapper {
    long countByExample(TbItemDescExample example);

    int deleteByExample(TbItemDescExample example);

    int insert(TbItemDesc record);

    int insertSelective(TbItemDesc record);
    
    TbItemDesc selectByPrimaryKey(Long itemId);

    List<TbItemDesc> selectByExampleWithBLOBs(TbItemDescExample example);

    List<TbItemDesc> selectByExample(TbItemDescExample example);

    int updateByExampleSelective(@Param("record") TbItemDesc record, @Param("example") TbItemDescExample example);

    int updateByExampleWithBLOBs(@Param("record") TbItemDesc record, @Param("example") TbItemDescExample example);

    int updateByExample(@Param("record") TbItemDesc record, @Param("example") TbItemDescExample example);
}