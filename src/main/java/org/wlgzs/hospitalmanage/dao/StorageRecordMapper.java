package org.wlgzs.hospitalmanage.dao;

import org.apache.ibatis.annotations.Delete;
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
    @Select(" SELECT COUNT(*) FROM  tb_storage_record WHERE drug_name  LIKE CONCAT('%',#{0},'%') ")
    int getcountByDrugName(String drug_name);
    @Select("SELECT * FROM tb_storage_record WHERE drug_name  LIKE CONCAT('%',#{0},'%') limit 10")
    List<StorageRecord> keyword(String drug_name );
    @Select("SELECT * FROM tb_storage_record WHERE drug_name  LIKE CONCAT('%',#{0},'%') limit 10")
    List<StorageRecord> search(String drug_name );
    @Delete("DELETE FROM tb_storage_record WHERE record_number=#{0}")
    void deleteInventory(int record_number);
    @Select("SELECT * FROM tb_storage_record WHERE record_number=#{0}")
    StorageRecord selectStorage(int record_number);

}