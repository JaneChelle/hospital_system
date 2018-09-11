package org.wlgzs.hospitalmanage.dao;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.wlgzs.hospitalmanage.entity.Check;
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

    @Select("SELECT * FROM tb_disease WHERE disease_name LIKE '%${findName}%'")
    List<Disease> findDisease(@Param("findName") String findName);

    @Delete({"<script>",
            "DELETE FROM tb_disease",
            "<where>",
            "disease_id in",
            "<foreach item='item' index='index' collection='Ids' open='(' separator=',' close=')'>",
            "#{item}",
            "</foreach>",
            "</where>",
            "</script>"})
    @Results({
            @Result(column="disease_id",property = "disease_id",jdbcType = JdbcType.VARCHAR)
    })
    void deleteDiseaseByIds(@Param("Ids")int[] Ids);

    @Select("SELECT * FROM tb_disease WHERE disease_name LIKE '%${search_word}%' limit 0,8")
    List<Check> findDiseaseByWord(@Param("search_word") String search_word);
}
