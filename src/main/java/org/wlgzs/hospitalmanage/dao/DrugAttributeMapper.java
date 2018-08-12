package org.wlgzs.hospitalmanage.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.wlgzs.hospitalmanage.entity.DrugAttribute;
import org.wlgzs.hospitalmanage.entity.DrugAttributeExample;

public interface DrugAttributeMapper {
    long countByExample(DrugAttributeExample example);

    int deleteByExample(DrugAttributeExample example);

    int deleteByPrimaryKey(Integer attributeNumber);

    int insert(DrugAttribute record);

    int insertSelective(DrugAttribute record);

    List<DrugAttribute> selectByExample(DrugAttributeExample example);

    DrugAttribute selectByPrimaryKey(Integer attributeNumber);

    int updateByExampleSelective(@Param("record") DrugAttribute record, @Param("example") DrugAttributeExample example);

    int updateByExample(@Param("record") DrugAttribute record, @Param("example") DrugAttributeExample example);

    int updateByPrimaryKeySelective(DrugAttribute record);

    int updateByPrimaryKey(DrugAttribute record);
}