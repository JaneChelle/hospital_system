package org.wlgzs.hospitalmanage.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wlgzs.hospitalmanage.dao.*;
import org.wlgzs.hospitalmanage.entity.*;
import org.wlgzs.hospitalmanage.service.DrugInventoryService;
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

    @Resource
    PrescriptionDrugMapper prescriptionDrugMapper;

    @Autowired
    DrugInventoryService drugInventoryService;
    //添加记录
    @Override
    public Result addNote(Note note, String price_end, String timeStr,HttpSession session) throws ParseException {
        if (note != null) {
            BigDecimal bigDecimal = new BigDecimal(price_end);
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");    // 这里填写的是想要进行转换的时间格式
            Date date = format.parse(timeStr);
            System.out.println(note.getPatient_name());
            note.setPrice_end(bigDecimal);
            note.setNote_time(date);
            noteMapper.insert(note);
            //减少相应的库存
            List<PrescriptionDrug> prescriptionDrugList = prescriptionDrugMapper.findPrescriptionDrug(note.getPrescription_id());
            for(PrescriptionDrug aPrescriptionDrugList : prescriptionDrugList){
                String number = aPrescriptionDrugList.getNumber()+"";
                System.out.println(number);
                drugInventoryService.reduceInventories(aPrescriptionDrugList.getDrug_code(),number);
            }
            return new Result(ResultCode.SUCCESS);
        }
        return new Result(ResultCode.FAIL);
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
    public void modifyNote(Note note, String price_end) {
        if (note != null) {
            Note note1 = noteMapper.selectByPrimaryKey(note.getNote_id());
            BigDecimal bigDecimal = new BigDecimal(price_end);
            System.out.println("price_end===="+price_end);
            System.out.println("bigDecimal===="+bigDecimal);
            System.out.println("note===="+note);
            note1.setPrice_end(bigDecimal);
            noteMapper.updateByPrimaryKey(note1);
        }
    }

    //按用户搜索记录(findName是查找用户)
    @Override
    public List<Note> findNote(String findName, int page) {
        //查询用户表
        List<Patient> patientList = patientMapper.searchName(findName);
        List<Integer> listId = new ArrayList<>();
        for (int i = 0; i < patientList.size(); i++) {
//            System.out.println(patientList.get(i).getPatient_number());
            listId.add(patientList.get(i).getPatient_number());
        }
        //根据id查询
//        System.out.println(listId);
        List<Note> list = noteMapper.selectNoteByIds(listId);
        System.out.println(list);
        return list;
    }

    //按时间段查询记录和总价
    @Override
    public Result chargeNote(String time) {
        String time_start = time.substring(0,19);
        String time_end = time.substring(time.length() - 19,time.length());
        System.out.println(time_start);
        System.out.println(time_end);
        List<Note> noteList = noteMapper.chargeNote(time_start, time_end);
        System.out.println(noteList);
        BigDecimal totalPrice = new BigDecimal("0");
        for (Note aNoteList : noteList) {
            totalPrice = totalPrice.add(aNoteList.getPrice_end());
        }
        String total_price = totalPrice.toString();
        return new Result(ResultCode.SUCCESS, noteList, total_price);
    }

    //按时间查询某个药品的使用情况
    @Override
    public Result drugUsage(String time, String drugName) {
        //从记录查询出相依相应时间的处方id
        String time_start = time.substring(0,19);
        String time_end = time.substring(time.length() - 19,time.length());
        List<Integer> noteList = noteMapper.prescriptionNote(time_start, time_end);

        //处方id查询药品去重
        List<Integer> drugIdList = noteMapper.drugIdList(noteList);

        //存放结果
        List<DrugNumber> drugNumberList = new ArrayList<DrugNumber>();
        //循环查询
        for (int aDrugId : drugIdList) {
            DrugNumber priceAll = noteMapper.drugIdLists(noteList,aDrugId);
            drugNumberList.add(priceAll);
            System.out.println(priceAll);
        }
        return new Result(ResultCode.SUCCESS,drugNumberList);
    }

}
