package org.wlgzs.hospitalmanage.service;

import org.wlgzs.hospitalmanage.entity.BillNote;

import java.util.List;

/**
 * @author:胡亚星
 * @createTime 2018-09-27 16:09
 * @description:
 **/
public interface BillNoteService {

    //按患者查询还账记录
    List<BillNote> selectBillNoteById(int patient_id);


}
