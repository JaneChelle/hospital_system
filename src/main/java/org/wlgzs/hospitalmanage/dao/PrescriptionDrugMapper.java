package org.wlgzs.hospitalmanage.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.wlgzs.hospitalmanage.entity.PrescriptionDrug;
import org.wlgzs.hospitalmanage.entity.PrescriptionDrugExample;

public interface PrescriptionDrugMapper {
    long countByExample(PrescriptionDrugExample example);

    int deleteByExample(PrescriptionDrugExample example);

    int deleteByPrimaryKey(Integer detailId);

    int insert(PrescriptionDrug record);

    int insertSelective(PrescriptionDrug record);

    List<PrescriptionDrug> selectByExample(PrescriptionDrugExample example);

    PrescriptionDrug selectByPrimaryKey(Integer detailId);

    int updateByExampleSelective(@Param("record") PrescriptionDrug record, @Param("example") PrescriptionDrugExample example);

    int updateByExample(@Param("record") PrescriptionDrug record, @Param("example") PrescriptionDrugExample example);

    int updateByPrimaryKeySelective(PrescriptionDrug record);

    int updateByPrimaryKey(PrescriptionDrug record);
}