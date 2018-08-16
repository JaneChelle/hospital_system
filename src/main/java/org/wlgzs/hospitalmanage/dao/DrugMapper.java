package org.wlgzs.hospitalmanage.dao;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.wlgzs.hospitalmanage.entity.Drug;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface DrugMapper extends Mapper<Drug> {
    @Select("SELECT * FROM tb_drug WHERE drug_name = #{drugName}")
    Drug jundgeName(String drug);
    @Update("UPDATE tb_drug set drug_category=#{drug_category},pinyin_code=#{pinyin_code},specification_content=#{specification_content},drug_unit=#{drug_unit},dosage_form=#{dosage_form},manufacturer=#{manufacturer},approval_number=#{approval_number},safety_stock=#{safety_stock},unit_price=#{unit_price},healthcare_code=#{healthcare_code},healthcare_name=#{healthcare_name},drug_name=#{drug_name} WHERE drug_code = #{drug_code} ")
    void updateDrug(Drug drug);
    @Select("SELECT * FROM tb_drug WHERE drug_name LIKE CONCAT('%',#{0},'%') limit 10")
    List<Drug> keyWordName(String drugName);                     //搜索框提示词
    @Select("SELECT * FROM tb_drug WHERE drug_name LIKE CONCAT('%',#{0},'%') ")
    List<Drug> searchName(String drugName);                    //搜索药品名字结果
    @Select("SELECT * FROM tb_drug WHERE drug_code LIKE CONCAT('%',#{0},'%') ")
    List<Drug> searchDrugCode(String drugName);                  //搜索药品编码结果



}