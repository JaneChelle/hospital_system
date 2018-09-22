package org.wlgzs.hospitalmanage.service.serviceImpl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
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
    public Result addNote(Note note, String price_end, String prescription_name,HttpSession session) throws ParseException {
        if (note != null) {
            //查询患者id是否存在
            if(note.getPatient_id() == null){
                List<Patient> patients = patientMapper.checkPatient(note.getPatient_name());
                if(patients.size() > 1){
                    return new Result(ResultCode.FAIL,"该患者可能重名，可以根据手机号查询！");
                }else if(patients.size() == 1){
                    //根据名字查询患者id
                    note.setPatient_id(patients.get(0).getPatient_number());
                }
            }

            //查询疾病id是否存在
            if(note.getDisease_id() == null){
                Disease disease = diseaseMapper.findByName(note.getDisease_name());
                note.setDisease_id(disease.getDisease_id());
            }

            //查询处方id是否存在
            if(note.getPrescription_id() == null){
                //根据名字查询处方
                Prescription prescription = prescriptionMapper.checkPrescription(prescription_name);
                note.setPrescription_id(prescription.getPrescription_id());
            }

            BigDecimal zero = new BigDecimal("0");
            if(note.getPrice_end().compareTo(zero) == -1){
                //欠账
                Patient patient = patientMapper.selectByPrimaryKey(note.getPatient_id());
                System.out.println(patient);
                System.out.println("欠账");
                //修改患者状态，并记录价钱
                patient.setIs_money(1);
                patient.setOwe_money(patient.getOwe_money().add(note.getPrice_end()));
                patientMapper.updateByPrimaryKey(patient);
            }

            //生成记录，修改处方的状态（一对一）
            Prescription prescription = prescriptionMapper.selectByPrimaryKey(note.getPrescription_id());
            System.out.println(note);
            prescription.setIs_show(0);
            prescriptionMapper.updateByPrimaryKey(prescription);
            BigDecimal bigDecimal = new BigDecimal(price_end);
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");    // 这里填写的是想要进行转换的时间格式
            Date date = new Date();
            note.setPrice_end(bigDecimal);
            note.setNote_time(date);
            noteMapper.insert(note);
            //减少相应的库存
            List<PrescriptionDrug> prescriptionDrugList = prescriptionDrugMapper.findPrescriptionDrug(note.getPrescription_id());
                drugInventoryService.reduce(prescriptionDrugList);

            return new Result(ResultCode.SUCCESS,"成功");
        }
        return new Result(ResultCode.FAIL,"添加失败！");
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
            note1.setPrice_end(bigDecimal);
            noteMapper.updateByPrimaryKey(note1);
        }
    }

    //按用户搜索记录(findName是查找用户)
    @Override
    public List<Note> findNote(String findName, int page,Model model) {
        //查询用户表
        List<Patient> patientList = patientMapper.searchName(findName);
        List<Integer> listId = new ArrayList<>();
        for (int i = 0; i < patientList.size(); i++) {
            listId.add(patientList.get(i).getPatient_number());
        }
        //根据id查询
        Page page2 = PageHelper.startPage(page, 8, true);
        List<Note> list = noteMapper.selectNoteByIds(listId);
        model.addAttribute("TotalPages",page2.getPages() );//查询的总页数
        model.addAttribute("Number", page);//查询的当前第几页
        return list;
    }

    //按时间段查询记录和总价
    @Override
    public Result chargeNote(String time) {
        String time_start = time.substring(0,19);
        String time_end = time.substring(time.length() - 19,time.length());
        List<Note> noteList = noteMapper.chargeNote(time_start, time_end);
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
            DrugNumber drugNumber;
            if(!drugName.equals("") && drugName != null){
                drugNumber = noteMapper.drugIds(noteList,aDrugId,drugName);
            }else{
                drugNumber = noteMapper.drugIdLists(noteList,aDrugId);
            }
            drugNumberList.add(drugNumber);
        }
        return new Result(ResultCode.SUCCESS,drugNumberList);
    }

}
