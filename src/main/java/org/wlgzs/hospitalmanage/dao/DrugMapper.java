package org.wlgzs.hospitalmanage.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.wlgzs.hospitalmanage.entity.Drug;
import org.wlgzs.hospitalmanage.entity.DrugExample;

public interface DrugMapper {
    long countByExample(DrugExample example);

    int deleteByExample(DrugExample example);

    int deleteByPrimaryKey(Integer drugCode);

    int insert(Drug record);

    int insertSelective(Drug record);

    List<Drug> selectByExampleWithBLOBs(DrugExample example);

    List<Drug> selectByExample(DrugExample example);

    Drug selectByPrimaryKey(Integer drugCode);

    int updateByExampleSelective(@Param("record") Drug record, @Param("example") DrugExample example);

    int updateByExampleWithBLOBs(@Param("record") Drug record, @Param("example") DrugExample example);

    int updateByExample(@Param("record") Drug record, @Param("example") DrugExample example);

    int updateByPrimaryKeySelective(Drug record);

    int updateByPrimaryKeyWithBLOBs(Drug record);

    int updateByPrimaryKey(Drug record);
}