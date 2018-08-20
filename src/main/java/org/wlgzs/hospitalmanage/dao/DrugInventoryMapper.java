package org.wlgzs.hospitalmanage.dao;

import org.apache.ibatis.annotations.Select;
import org.wlgzs.hospitalmanage.entity.DrugInventory;
import org.wlgzs.hospitalmanage.entity.StorageRecord;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface DrugInventoryMapper extends Mapper<DrugInventory> {
    @Select("SELECT * FROM tb_storage_record WHERE valid_period==null and drug_code==#{drug_code}")
    DrugInventory increase(int drug_code) ;      //获得总库存数量那条数据
    @Select("SELECT * FROM tb_storage_record WHERE  valid_period!=null and drug_code==#{drug_code} ORDER BY(valid_period) DESC" )
    List<DrugInventory> reduceInventories(int drug_code);
}