package org.wlgzs.hospitalmanage.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.wlgzs.hospitalmanage.entity.PrescriptionCheck;
import org.wlgzs.hospitalmanage.entity.PrescriptionCheckExample;
import tk.mybatis.mapper.common.Mapper;

@org.apache.ibatis.annotations.Mapper
public interface PrescriptionCheckMapper extends Mapper<PrescriptionCheck> {

}