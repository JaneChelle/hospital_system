package org.wlgzs.hospitalmanage.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.wlgzs.hospitalmanage.entity.DrugInventory;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface DrugInventoryMapper extends Mapper<DrugInventory> {
    //获得总库存数量那条数据
    @Select("SELECT * FROM tb_drug_inventory WHERE valid_period is null and drug_code=#{drug_code}")
    DrugInventory increase(int drug_code);

    @Select("SELECT * FROM tb_drug_inventory WHERE  valid_period is not null and drug_code=#{drug_code} ORDER BY(valid_period) DESC")
    List<DrugInventory> reduceInventories(int drug_code);

    //获取未达到安全库存的清单
    @Select("SELECT * FROM tb_drug_inventory WHERE valid_period is null and  is_safety_stock = 0 ")
    List<DrugInventory> getUnsafetyStock();

    //获取总库存数据
    @Select("SELECT * FROM tb_drug_inventory WHERE valid_period is null")
    List<DrugInventory> getAll();

    //获取总库存数据(有效不为空的)
    @Select("SELECT * FROM tb_drug_inventory WHERE valid_period is not null")
    List<DrugInventory> getAllnotnull();

    //获取总库存数据的数量
    @Select(" SELECT COUNT(*) FROM  tb_drug_inventory WHERE valid_period is null ")
    int getcount();

    //获取分库存数据的数量
    @Select(" SELECT COUNT(*) FROM  tb_drug_inventory WHERE valid_period is null ")
    int getcountDate();

    @Delete("DELETE FROM tb_drug_inventory WHERE stock_number=#{0} and valid_period is not null ")
    void deleteInventory(int stock_number);

    @Select("SELECT COUNT(*) FROM tb_drug_inventory WHERE is_safety_stock=0")
    int getUnsafeCount();


    //更新库存和是否安全库存
    @Update("UPDATE tb_drug_inventory set storage_amount=#{storage_amount},is_safety_stock=#{is_safety_stock}  WHERE stock_number =#{stock_number}")
    void updatenIventory(DrugInventory drugInventory);

    //更新库存和是否安全库存和有效日期
    @Update("UPDATE tb_drug_inventory set storage_amount=#{storage_amount},is_safety_stock=#{is_safety_stock},valid_period=#{valid_period}  WHERE stock_number =#{stock_number} and valid_period is not null ")
    void update(DrugInventory drugInventory);

    //搜索总的药品库存
    @Select("SELECT * FROM tb_drug_inventory WHERE ( drug_name LIKE CONCAT('%',#{0},'%') or pinyin_code  LIKE CONCAT('%',#{0},'%')) and valid_period is  null ")
    List<DrugInventory> searchStroage(String drugName);

    //搜索总的药品库存总数
    @Select("SELECT COUNT(*) FROM tb_drug_inventory WHERE ( drug_name LIKE CONCAT('%',#{0},'%') or pinyin_code  LIKE CONCAT('%',#{0},'%')) and valid_period is  null ")
    int searchStroageCount(String drugName);

    //搜索药品库存(有效期)
    @Select("SELECT * FROM tb_drug_inventory WHERE  (drug_name LIKE CONCAT('%',#{0},'%') or pinyin_code  LIKE CONCAT('%',#{0},'%')) and valid_period is not null  ")
    List<DrugInventory> searchStroageDate(String drugName);

    //搜索药品库存(有效期)总数
    @Select("SELECT * FROM tb_drug_inventory WHERE  (drug_name LIKE CONCAT('%',#{0},'%') or pinyin_code  LIKE CONCAT('%',#{0},'%')) and valid_period is not null  ")
    int searchStroageDateCount(String drugName);

    @Select("SELECT * FROM tb_drug_inventory WHERE ( drug_name LIKE CONCAT('%',#{0},'%') or pinyin_code  LIKE CONCAT('%',#{0},'%')) and valid_period is  null  limit 10")
    List<DrugInventory> keyword(String drugName);

    @Select("SELECT * FROM tb_drug_inventory WHERE ( drug_name LIKE CONCAT('%',#{0},'%') or pinyin_code  LIKE CONCAT('%',#{0},'%')) and valid_period is not null  limit 10")
    List<DrugInventory> keywordDate(String drugName);

    @Select("SELECT * FROM tb_drug_inventory WHERE stock_number = #{stock_number} ")
    DrugInventory selectOneDrugInventory(int stock_number);
    //更新药品名字------库存
    @Update("UPDATE FROM  tb_drug_inventory set drug_name=#{drug_name},pinyin_code=#{pinyin_code} WHERE drug_code=#{drug_code}")
    void getDrugInventoryByDrug_code(int drug_code,String drug_name,String pinyin_code);
}