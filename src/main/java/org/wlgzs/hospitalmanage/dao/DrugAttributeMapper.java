package org.wlgzs.hospitalmanage.dao;

import org.apache.ibatis.annotations.Select;
import org.wlgzs.hospitalmanage.entity.DrugAttribute;
import org.wlgzs.hospitalmanage.entity.Patient;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface DrugAttributeMapper extends Mapper<DrugAttribute> {
    @Select("SELECT * FROM tb_drug_attribute WHERE attribute_distinction = #{0}")
    List<DrugAttribute> getAttribute(int attribute_distinction);

}