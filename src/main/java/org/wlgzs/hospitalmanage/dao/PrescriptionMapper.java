package org.wlgzs.hospitalmanage.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.wlgzs.hospitalmanage.entity.Prescription;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface PrescriptionMapper extends Mapper<Prescription> {

    //多调价模糊查询
    @Select("SELECT * FROM tb_prescription WHERE prescription_name LIKE '%${findName}%' or pinyin_code LIKE '%${findName}%'")
    List<Prescription> findPrescription(@Param("findName") String findName);

    //搜索提示
    @Select("SELECT * FROM tb_prescription WHERE prescription_name LIKE '%${search_word}%' or pinyin_code LIKE '%${search_word}%' limit 0,8")
    List<Prescription> findPrescriptionByWord(@Param("search_word") String search_word);

    @Select("SELECT * FROM tb_prescription WHERE prescription_name #{disease_name}")
    Prescription checkPrescription(String disease_name);

    //查询所有处方
    @Select("SELECT * FROM tb_prescription WHERE is_show = 1")
    List<Prescription> selectAllPrescription();
}