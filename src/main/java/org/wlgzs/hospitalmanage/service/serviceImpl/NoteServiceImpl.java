package org.wlgzs.hospitalmanage.service.serviceImpl;

import org.springframework.stereotype.Service;
import org.wlgzs.hospitalmanage.dao.NoteMapper;
import org.wlgzs.hospitalmanage.dao.PrescriptionMapper;
import org.wlgzs.hospitalmanage.entity.Note;
import org.wlgzs.hospitalmanage.entity.Patient;
import org.wlgzs.hospitalmanage.entity.Prescription;
import org.wlgzs.hospitalmanage.service.NoteService;
import org.wlgzs.hospitalmanage.util.Result;
import org.wlgzs.hospitalmanage.util.ResultCode;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author:胡亚星
 * @createTime 2018-08-17 10:57
 * @description:
 **/
@Service
public class NoteServiceImpl implements NoteService {

    @Resource
    NoteMapper noteMapper;

    @Resource
    PrescriptionMapper prescriptionMapper;

    //添加记录
    @Override
    public boolean addNote(int prescription_id, HttpSession session) throws ParseException {
        if (session.getAttribute("patient") != null) {
            Prescription prescription = prescriptionMapper.selectByPrimaryKey(prescription_id);
            if(prescription != null){
                Patient patient = (Patient)session.getAttribute("patient");
                DateFormat format = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");    // 这里填写的是想要进行转换的时间格式
                Date date = new Date();
                String str = format.format(date);
                date = format.parse(str);
                System.out.println(date);
                Note note = new Note(patient.getPatient_number(),1,prescription_id,
                        prescription.getPrice_all(),date,patient.getPatient_name(),"");
                noteMapper.insert(note);
            }
            return true;
        }
        //患者没有选择
        return false;

    }

    //按id删除
    @Override
    public Result deleteNote(int noteId) {
        Note note = noteMapper.selectByPrimaryKey(noteId);
        if(note != null){
            noteMapper.delete(note);
            return new Result(ResultCode.SUCCESS);
        }
        return new Result(ResultCode.FAIL);
    }

    //修改记录
    @Override
    public void modifyNote(Note note) {
        if(note != null){
            noteMapper.updateByPrimaryKey(note);
        }
    }

    @Override
    public List<Note> findNote(String findName, int page) {
        return null;
    }


}
