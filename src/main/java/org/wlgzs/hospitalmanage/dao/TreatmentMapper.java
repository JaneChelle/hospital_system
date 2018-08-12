package org.wlgzs.hospitalmanage.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.wlgzs.hospitalmanage.entity.Treatment;
import org.wlgzs.hospitalmanage.entity.TreatmentExample;
import tk.mybatis.mapper.common.Mapper;

@org.apache.ibatis.annotations.Mapper
public interface TreatmentMapper extends Mapper<Treatment> {

}