package org.wlgzs.hospitalmanage.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.wlgzs.hospitalmanage.entity.PrescriptionTreatment;
import org.wlgzs.hospitalmanage.entity.PrescriptionTreatmentExample;
import tk.mybatis.mapper.common.Mapper;

@org.apache.ibatis.annotations.Mapper
public interface PrescriptionTreatmentMapper extends Mapper<PrescriptionTreatment> {

}