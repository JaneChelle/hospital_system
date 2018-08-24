package org.wlgzs.hospitalmanage.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.wlgzs.hospitalmanage.entity.DrugAttribute;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface DrugAttributeMapper extends Mapper<DrugAttribute> {
    @Select("SELECT * FROM tb_drug_attribute WHERE attribute_distinction = #{0}")
    List<DrugAttribute> getAttribute(int attribute_distinction);
    @Select("SELECT * FROM tb_drug_attribute WHERE attribute_name=#{attribute_name} and attribute_distinction = #{attribute_distinction} ")
    DrugAttribute findByname(@Param("attribute_name") String attribute_name,@Param("attribute_distinction")  int attribute_distinction);
    @Select("SELECT * FROM  tb_drug_attribute WHERE attribute_name  LIKE CONCAT('%',#{0},'%') and attribute_distinction =#{1} ")
    List<DrugAttribute> searchAttribute(String attribute_name,int distinction);
    @Select("SELECT * FROM  tb_drug_attribute WHERE attribute_name  LIKE CONCAT('%',#{0},'%') limit 10   ")
    List<DrugAttribute> keyword(String attribute_name);

}