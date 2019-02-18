package com.dj.taotao.mapper;

import com.dj.taotao.pojo.TbOrderShipping;
import com.dj.taotao.pojo.TbOrderShippingExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbOrderShippingMapper {
    long countByExample(TbOrderShippingExample example);

    int deleteByExample(TbOrderShippingExample example);

    int insert(TbOrderShipping record);

    int insertSelective(TbOrderShipping record);

    List<TbOrderShipping> selectByExample(TbOrderShippingExample example);

    int updateByExampleSelective(@Param("record") TbOrderShipping record, @Param("example") TbOrderShippingExample example);

    int updateByExample(@Param("record") TbOrderShipping record, @Param("example") TbOrderShippingExample example);
}