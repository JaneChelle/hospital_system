package org.wlgzs.hospitalmanage.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.wlgzs.hospitalmanage.entity.PrescriptionCheck;
import org.wlgzs.hospitalmanage.entity.PrescriptionCheckExample;

public interface PrescriptionCheckMapper {
    long countByExample(PrescriptionCheckExample example);

    int deleteByExample(PrescriptionCheckExample example);

    int deleteByPrimaryKey(Integer detailId);

    int insert(PrescriptionCheck record);

    int insertSelective(PrescriptionCheck record);

    List<PrescriptionCheck> selectByExample(PrescriptionCheckExample example);

    PrescriptionCheck selectByPrimaryKey(Integer detailId);

    int updateByExampleSelective(@Param("record") PrescriptionCheck record, @Param("example") PrescriptionCheckExample example);

    int updateByExample(@Param("record") PrescriptionCheck record, @Param("example") PrescriptionCheckExample example);

    int updateByPrimaryKeySelective(PrescriptionCheck record);

    int updateByPrimaryKey(PrescriptionCheck record);
}