package org.wlgzs.hospitalmanage.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.wlgzs.hospitalmanage.entity.DrugInventory;
import org.wlgzs.hospitalmanage.entity.DrugInventoryExample;

public interface DrugInventoryMapper {
    long countByExample(DrugInventoryExample example);

    int deleteByExample(DrugInventoryExample example);

    int deleteByPrimaryKey(Integer stockNumber);

    int insert(DrugInventory record);

    int insertSelective(DrugInventory record);

    List<DrugInventory> selectByExample(DrugInventoryExample example);

    DrugInventory selectByPrimaryKey(Integer stockNumber);

    int updateByExampleSelective(@Param("record") DrugInventory record, @Param("example") DrugInventoryExample example);

    int updateByExample(@Param("record") DrugInventory record, @Param("example") DrugInventoryExample example);

    int updateByPrimaryKeySelective(DrugInventory record);

    int updateByPrimaryKey(DrugInventory record);
}