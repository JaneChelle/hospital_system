package org.wlgzs.hospitalmanage.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.wlgzs.hospitalmanage.entity.Check;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface CheckMapper extends Mapper<Check> {

    //多调价模糊查询
    @Select("SELECT * FROM tb_check WHERE check_name LIKE '%${findName}%' or pinyin_code LIKE '%${findName}%'")
    List<Check> findCheck(@Param("findName") String findName);

    //搜索提示
    @Select("SELECT * FROM tb_check WHERE check_name LIKE '%${search_word}%' or pinyin_code LIKE '%${search_word}%' limit 0,8")
    List<Check> findCheckByWord(@Param("search_word") String search_word);

}