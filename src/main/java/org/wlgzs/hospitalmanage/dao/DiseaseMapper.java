package org.wlgzs.hospitalmanage.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.wlgzs.hospitalmanage.entity.Disease;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
//@Repository
public interface DiseaseMapper extends Mapper<Disease> {

    //按id查询疾病
    @Select("SELECT * FROM tb_disease WHERE disease_id = #{id}")
    Disease findById(@Param("id") int id);

    @Select("SELECT * FROM tb_disease WHERE disease_name = #{name}")
    Disease findByName(@Param("name") String name);

    @Select("SELECT * FROM tb_disease")
    List<Disease> find();

}
