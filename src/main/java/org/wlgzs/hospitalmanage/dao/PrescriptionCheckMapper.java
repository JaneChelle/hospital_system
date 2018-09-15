package org.wlgzs.hospitalmanage.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.wlgzs.hospitalmanage.entity.PrescriptionCheck;
import org.wlgzs.hospitalmanage.entity.PrescriptionDrug;
import org.wlgzs.hospitalmanage.entity.PrescriptionTreatment;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface PrescriptionCheckMapper extends Mapper<PrescriptionCheck> {

    //查询当前处方的检查记录
    @Select("SELECT * FROM prescription_check WHERE prescription_id = #{prescription_id}")
    List<PrescriptionCheck> findPrescriptionCheck(@Param("prescription_id") int prescription_id);

    //查询当前处方添加的检查是否已存在
    @Select("SELECT * FROM prescription_check WHERE prescription_id = #{prescription_id} AND check_id = #{check_id}")
    PrescriptionCheck findPrescriptionChe(@Param("prescription_id") int prescription_id,@Param("check_id") int check_id);

    //搜索检查是否被使用
    @Select("SELECT * FROM prescription_check WHERE check_id = #{check_id}")
    List<PrescriptionCheck> TakeUpCheck(@Param("check_id") int check_id);

}