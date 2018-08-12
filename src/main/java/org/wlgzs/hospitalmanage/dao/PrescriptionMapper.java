package org.wlgzs.hospitalmanage.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.wlgzs.hospitalmanage.entity.Prescription;
import org.wlgzs.hospitalmanage.entity.PrescriptionExample;
import tk.mybatis.mapper.common.Mapper;

@org.apache.ibatis.annotations.Mapper
public interface PrescriptionMapper extends Mapper<Prescription> {

}