package org.wlgzs.hospitalmanage.service.serviceImpl;

import org.springframework.stereotype.Service;
import org.wlgzs.hospitalmanage.dao.DiseaseMapper;
import org.wlgzs.hospitalmanage.dao.NoteMapper;
import org.wlgzs.hospitalmanage.dao.PatientMapper;
import org.wlgzs.hospitalmanage.dao.PrescriptionMapper;
import org.wlgzs.hospitalmanage.entity.Disease;
import org.wlgzs.hospitalmanage.entity.Note;
import org.wlgzs.hospitalmanage.entity.Patient;
import org.wlgzs.hospitalmanage.entity.Prescription;
import org.wlgzs.hospitalmanage.service.NoteService;
import org.wlgzs.hospitalmanage.util.Result;
import org.wlgzs.hospitalmanage.util.ResultCode;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

    @Resource
    PatientMapper patientMapper;

    @Resource
    DiseaseMapper diseaseMapper;

    //添加记录
    @Override
    public void addNote(Note note,String price_end,HttpSession session) throws ParseException {
            if (note != null) {
                BigDecimal bigDecimal = new BigDecimal(price_end);
                DateFormat format = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");    // 这里填写的是想要进行转换的时间格式
                Date date = new Date();
                String str = format.format(date);
                date = format.parse(str);
                System.out.println(note.getPatient_name());
                note.setPrice_end(bigDecimal);
                note.setNote_time(date);
                noteMapper.insert(note);
            }
    }

    //查看记录详情(id查询)
    @Override
    public Note detailsNote(int note_id) {
        return noteMapper.selectByPrimaryKey(note_id);
    }

    //按id删除
    @Override
    public Result deleteNote(int noteId) {
        Note note = noteMapper.selectByPrimaryKey(noteId);
        if (note != null) {
            noteMapper.delete(note);
            return new Result(ResultCode.SUCCESS);
        }
        return new Result(ResultCode.FAIL);
    }

    //修改记录
    @Override
    public void modifyNote(Note note,String price_end) {
        if (note != null) {
            Note note1 = noteMapper.selectByPrimaryKey(note.getNote_id());
            note.setNote_time(note1.getNote_time());
            BigDecimal bigDecimal = new BigDecimal(price_end);
            note.setPrice_end(bigDecimal);
            noteMapper.updateByPrimaryKey(note);
        }
    }

    //按用户搜索记录(findName是查找用户)
    @Override
    public List<Note> findNote(String findName, int page) {
        //查询用户表
        List<Patient> patientList = patientMapper.searchName(findName);
        List<Integer> listId = new ArrayList<>();
        for(int i = 0;i < patientList.size();i++) {
            listId.add(patientList.get(i).getPatient_number());
        }
        //根据id查询
        List<Note> list =  noteMapper.selectNoteByIds(listId);
        System.out.println(list);
        return list;
    }

    //按时间段查询记录和总价
    @Override
    public Result chargeNote(String time_start, String time_end) {
        List<Note> noteList = noteMapper.chargeNote(time_start,time_end);
        System.out.println(noteList);
        BigDecimal totalPrice = new BigDecimal("0");
        for(Note aNoteList : noteList){
            totalPrice = totalPrice.add(aNoteList.getPrice_end());
        }
        String total_price = totalPrice.toString();
        return new Result(ResultCode.SUCCESS,noteList,total_price);
    }

}
