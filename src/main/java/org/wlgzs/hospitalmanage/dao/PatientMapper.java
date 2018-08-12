package org.wlgzs.hospitalmanage.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.wlgzs.hospitalmanage.entity.Patient;
import org.wlgzs.hospitalmanage.entity.PatientExample;
import tk.mybatis.mapper.common.Mapper;

@org.apache.ibatis.annotations.Mapper
public interface PatientMapper extends Mapper<Patient> {

}