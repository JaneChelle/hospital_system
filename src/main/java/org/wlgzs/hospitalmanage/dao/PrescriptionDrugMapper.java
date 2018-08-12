package org.wlgzs.hospitalmanage.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.wlgzs.hospitalmanage.entity.PrescriptionDrug;
import org.wlgzs.hospitalmanage.entity.PrescriptionDrugExample;
import tk.mybatis.mapper.common.Mapper;

@org.apache.ibatis.annotations.Mapper
public interface PrescriptionDrugMapper extends Mapper<PrescriptionDrug> {

}