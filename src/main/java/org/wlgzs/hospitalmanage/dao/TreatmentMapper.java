package org.wlgzs.hospitalmanage.dao;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.wlgzs.hospitalmanage.entity.Check;
import org.wlgzs.hospitalmanage.entity.Treatment;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface TreatmentMapper extends Mapper<Treatment> {

    //多条件模糊查询
    @Select("SELECT * FROM tb_treatment WHERE treatment_name LIKE '%${findName}%' or pinyin_code LIKE '%${findName}%'")
    List<Treatment> findTreatment(@Param("findName") String findName);

    //搜索提示
    @Select("SELECT * FROM tb_treatment WHERE treatment_name LIKE '%${search_word}%' or pinyin_code LIKE '%${search_word}%' limit 0,8")
    List<Treatment> findTreatmentByWord(@Param("search_word") String search_word);

    @Delete({"<script>",
            "DELETE FROM tb_treatment",
            "<where>",
            "treatment_id in",
            "<foreach item='item' index='index' collection='Ids' open='(' separator=',' close=')'>",
            "#{item}",
            "</foreach>",
            "</where>",
            "</script>"})
    @Results({
            @Result(column="treatment_id",property = "treatment_id",jdbcType = JdbcType.VARCHAR)
    })
    void deleteTreatmentByIds(@Param("Ids")int[] Ids);


}