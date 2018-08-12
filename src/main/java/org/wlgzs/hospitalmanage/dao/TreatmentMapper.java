package org.wlgzs.hospitalmanage.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.wlgzs.hospitalmanage.entity.Treatment;
import org.wlgzs.hospitalmanage.entity.TreatmentExample;

public interface TreatmentMapper {
    long countByExample(TreatmentExample example);

    int deleteByExample(TreatmentExample example);

    int deleteByPrimaryKey(Integer treatmentId);

    int insert(Treatment record);

    int insertSelective(Treatment record);

    List<Treatment> selectByExample(TreatmentExample example);

    Treatment selectByPrimaryKey(Integer treatmentId);

    int updateByExampleSelective(@Param("record") Treatment record, @Param("example") TreatmentExample example);

    int updateByExample(@Param("record") Treatment record, @Param("example") TreatmentExample example);

    int updateByPrimaryKeySelective(Treatment record);

    int updateByPrimaryKey(Treatment record);
}