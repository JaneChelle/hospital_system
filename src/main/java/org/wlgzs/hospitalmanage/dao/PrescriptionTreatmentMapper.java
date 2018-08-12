package org.wlgzs.hospitalmanage.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.wlgzs.hospitalmanage.entity.PrescriptionTreatment;
import org.wlgzs.hospitalmanage.entity.PrescriptionTreatmentExample;

public interface PrescriptionTreatmentMapper {
    long countByExample(PrescriptionTreatmentExample example);

    int deleteByExample(PrescriptionTreatmentExample example);

    int deleteByPrimaryKey(Integer detailId);

    int insert(PrescriptionTreatment record);

    int insertSelective(PrescriptionTreatment record);

    List<PrescriptionTreatment> selectByExample(PrescriptionTreatmentExample example);

    PrescriptionTreatment selectByPrimaryKey(Integer detailId);

    int updateByExampleSelective(@Param("record") PrescriptionTreatment record, @Param("example") PrescriptionTreatmentExample example);

    int updateByExample(@Param("record") PrescriptionTreatment record, @Param("example") PrescriptionTreatmentExample example);

    int updateByPrimaryKeySelective(PrescriptionTreatment record);

    int updateByPrimaryKey(PrescriptionTreatment record);
}