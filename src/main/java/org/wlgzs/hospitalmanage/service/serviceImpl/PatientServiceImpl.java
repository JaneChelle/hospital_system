package org.wlgzs.hospitalmanage.service.serviceImpl;

import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.wlgzs.hospitalmanage.dao.BillNoteMapper;
import org.wlgzs.hospitalmanage.dao.PatientMapper;
import org.wlgzs.hospitalmanage.entity.BillNote;
import org.wlgzs.hospitalmanage.entity.Patient;
import org.wlgzs.hospitalmanage.service.PatientService;
import org.wlgzs.hospitalmanage.util.Result;
import org.wlgzs.hospitalmanage.util.ResultCode;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author 武凯焱
 * @date 2018/8/13 15:07
 */
@Service
public class PatientServiceImpl implements PatientService {
    @Resource
    PatientMapper patientMapper;

    @Resource
    BillNoteMapper billNoteMapper;
    //查询患者
    public List<Patient> getPatients(Model model, int page) {
        PageHelper.startPage(page, 8);
        List<Patient> patients = patientMapper.selectAll();
        int count = patientMapper.getcount();
        int pages = (int) Math.ceil(count / 8.0);
        model.addAttribute("Number", page);
        model.addAttribute("TotalPages", pages);

        System.out.println(patients);

        return patients;
    }

    //注册患者
    public void
    savePatient(Patient patient, HttpSession session) {
        if (patient != null) {
            session.setAttribute("patient", patient);
            //session.setMaxInactiveInterval(30 *60);
            patientMapper.insert(patient);
        }
    }

    //删除患者
    public boolean deletePatient(int patientId) {
        Patient patient = (Patient) patientMapper.selectByPrimaryKey(patientId);
        if (patient == null) {
            return false;
        } else {
            patientMapper.deleteByPrimaryKey(patientId);
            return true;
        }
    }

    //批量删除患者
    public void deletePatients(int[] patients) {
        for (int i = 0; i < patients.length; i++) {
            patientMapper.deleteByPrimaryKey(patients[i]);
        }
    }

    @Override
    public Result choicePatient(int patient_number, HttpSession session) {
        Patient patient = patientMapper.selectByPrimaryKey(patient_number);
        if (patient != null) {
            session.setAttribute("patient", patient);
            return new Result(ResultCode.SUCCESS);
        }
        return new Result(ResultCode.FAIL);
    }

    @Override
    public Result checkPatient(String patient_name) {
        List<Patient> patients = patientMapper.checkPatient(patient_name);
        if (patients.size() > 0) {
            return new Result(ResultCode.SUCCESS, "存在！");
        } else {
            return new Result(ResultCode.FAIL, "不存在！");
        }
    }

    //查询欠费的患者
    @Override
    public List<Patient> billsPatient() {
        return patientMapper.billsPatient();
    }

    //还账
    @Override
    public Result payback(int patient_id, String price) {
        Patient patient = patientMapper.getPatient(patient_id);
        BigDecimal bigDecimal = new BigDecimal(price);
        BigDecimal zero = BigDecimal.ZERO;
        if (bigDecimal.compareTo(zero) == -1 || bigDecimal.compareTo(zero) == 0) {//还账不能为负
            return new Result(ResultCode.FAIL,"还账不能为负或为0！");
        }else{//为正时
            BigDecimal owe_money = patient.getOwe_money().add(bigDecimal);
            patient.setOwe_money(owe_money);
            if(owe_money.compareTo(zero) == 0){
                patient.setIs_money(0);
            }
            patientMapper.updateByPrimaryKey(patient);//更新患者信息
            //添加还账记录
            Date date = new Date();
            BillNote billNote = new BillNote(patient_id,patient.getPatient_name(),bigDecimal,date);
            billNoteMapper.insert(billNote);
            return new Result(ResultCode.SUCCESS,"还账成功！");
        }
    }

    //变更患者信息
    public void updatePatient(Patient patient) {
        System.out.println(patient);
        patientMapper.update(patient);
    }

    //患者下拉框提示
    public List<Patient> keyWordsearchPatient(String patientAttribute) {
        return patientMapper.nameKeyWord(patientAttribute);
    }

    //根据条件模糊搜索患者
    public List<Patient> searchPatient(Model model, String patientAttribute, int page) {
        PageHelper.startPage(page, 8);
        List<Patient> drugList = patientMapper.searchName(patientAttribute);
        int count = patientMapper.searchNameCount(patientAttribute);
        model.addAttribute("Number", page);
        int pages = (int) Math.ceil(count / 8.0);
        model.addAttribute("TotalPages", pages);
        return drugList;

    }

    public Patient patinetLink(int patientId) {
        Patient patient = patientMapper.getPatient(patientId);
        BigDecimal one = new BigDecimal("-1");
        BigDecimal bigDecimal = patient.getOwe_money().multiply(one);
        patient.setOwe_money(bigDecimal);
        return patient;
    }


}
