package org.wlgzs.hospitalmanage.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.wlgzs.hospitalmanage.entity.PrescriptionDrug;
import org.wlgzs.hospitalmanage.entity.PrescriptionTreatment;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface PrescriptionDrugMapper extends Mapper<PrescriptionDrug> {

    //查询当前处方的药品记录
    @Select("SELECT * FROM prescription_drug WHERE prescription_id = #{prescription_id}")
    List<PrescriptionDrug> findPrescriptionDrug(@Param("prescription_id") int prescription_id);

    //查询当前处方添加的药品是否已存在
    @Select("SELECT * FROM prescription_drug WHERE prescription_id = #{prescription_id} AND drug_code = #{drug_code}")
    PrescriptionDrug findPrescriptionDru(@Param("prescription_id") int prescription_id,@Param("drug_code") int drug_code);

    //搜索药品是否被使用
    @Select("SELECT * FROM prescription_drug WHERE drug_code = #{drug_code}")
    List<PrescriptionDrug> TakeUpDrug(@Param("drug_code") int drug_code);

}