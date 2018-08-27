package org.wlgzs.hospitalmanage.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.wlgzs.hospitalmanage.entity.PrescriptionCheck;
import org.wlgzs.hospitalmanage.entity.PrescriptionTreatment;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface PrescriptionTreatmentMapper extends Mapper<PrescriptionTreatment> {

    //查询当前处方的治疗记录
    @Select("SELECT * FROM prescription_treatment WHERE prescription_id = #{prescription_id}")
    List<PrescriptionTreatment> findPrescriptionTreatment(@Param("prescription_id") int prescription_id);

    //查询当前处方添加的检查是否已存在
    @Select("SELECT * FROM prescription_treatment WHERE prescription_id = #{prescription_id} AND treatment_id = #{treatment_id}")
    PrescriptionTreatment findPrescriptionTreat(@Param("prescription_id") int prescription_id, @Param("treatment_id") int treatment_id);

}