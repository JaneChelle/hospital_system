package org.wlgzs.hospitalmanage.dao;

import org.apache.ibatis.annotations.Select;
import org.wlgzs.hospitalmanage.entity.StorageRecord;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface StorageRecordMapper extends Mapper<StorageRecord> {
    @Select("SELECT * FROM tb_storage_record ORDER BY(inbound_date) DESC")
    List<StorageRecord> getAll();
    @Select(" SELECT COUNT(*) FROM   tb_storage_record")
    int getcount();

}