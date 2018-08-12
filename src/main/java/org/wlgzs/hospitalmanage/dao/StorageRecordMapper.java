package org.wlgzs.hospitalmanage.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.wlgzs.hospitalmanage.entity.StorageRecord;
import org.wlgzs.hospitalmanage.entity.StorageRecordExample;

public interface StorageRecordMapper {
    long countByExample(StorageRecordExample example);

    int deleteByExample(StorageRecordExample example);

    int deleteByPrimaryKey(Integer recordNumber);

    int insert(StorageRecord record);

    int insertSelective(StorageRecord record);

    List<StorageRecord> selectByExample(StorageRecordExample example);

    StorageRecord selectByPrimaryKey(Integer recordNumber);

    int updateByExampleSelective(@Param("record") StorageRecord record, @Param("example") StorageRecordExample example);

    int updateByExample(@Param("record") StorageRecord record, @Param("example") StorageRecordExample example);

    int updateByPrimaryKeySelective(StorageRecord record);

    int updateByPrimaryKey(StorageRecord record);
}