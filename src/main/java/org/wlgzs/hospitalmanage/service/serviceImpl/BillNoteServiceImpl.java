package org.wlgzs.hospitalmanage.service.serviceImpl;

import org.springframework.stereotype.Service;
import org.wlgzs.hospitalmanage.dao.BillNoteMapper;
import org.wlgzs.hospitalmanage.entity.BillNote;
import org.wlgzs.hospitalmanage.service.BillNoteService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author:胡亚星
 * @createTime 2018-09-27 16:09
 * @description:
 **/
@Service
public class BillNoteServiceImpl implements BillNoteService {

    @Resource
    BillNoteMapper billNoteMapper;

    //按患者查询还账记录
    @Override
    public List<BillNote> selectBillNoteById(int patient_id) {
        List<BillNote> billNotes = billNoteMapper.selectBillNoteById(patient_id);
        return billNotes;
    }
}
