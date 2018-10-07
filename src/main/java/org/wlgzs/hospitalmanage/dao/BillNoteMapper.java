package org.wlgzs.hospitalmanage.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.wlgzs.hospitalmanage.entity.BillNote;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author:胡亚星
 * @createTime 2018-09-27 16:11
 * @description:
 **/
@org.apache.ibatis.annotations.Mapper
public interface BillNoteMapper extends Mapper<BillNote> {

    //按患者查询还账记录
    @Select("SELECT * FROM tb_bill_note WHERE patient_id = #{patient_id}")
    List<BillNote> selectBillNoteById(@Param("patient_id") int patient_id);

}
