package org.wlgzs.hospitalmanage.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.wlgzs.hospitalmanage.entity.Check;
import org.wlgzs.hospitalmanage.entity.CheckExample;
import tk.mybatis.mapper.common.Mapper;

@org.apache.ibatis.annotations.Mapper
public interface CheckMapper extends Mapper<Check> {

}