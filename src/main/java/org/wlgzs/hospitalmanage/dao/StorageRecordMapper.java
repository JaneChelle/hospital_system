package org.wlgzs.hospitalmanage.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.wlgzs.hospitalmanage.entity.StorageRecord;
import org.wlgzs.hospitalmanage.entity.StorageRecordExample;
import tk.mybatis.mapper.common.Mapper;

@org.apache.ibatis.annotations.Mapper
public interface StorageRecordMapper extends Mapper<StorageRecord> {

}