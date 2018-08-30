package org.wlgzs.hospitalmanage.service.serviceImpl;

import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.wlgzs.hospitalmanage.dao.PatientMapper;
import org.wlgzs.hospitalmanage.entity.Patient;
import org.wlgzs.hospitalmanage.service.PatientService;
import org.wlgzs.hospitalmanage.util.Result;
import org.wlgzs.hospitalmanage.util.ResultCode;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author 武凯焱
 * @date 2018/8/13 15:07
 */
@Service
public class PatientServiceImpl implements PatientService {
    @Resource
    PatientMapper patientMapper;

    //查询患者
    public List<Patient> getPatients(Model model, int page) {
        PageHelper.startPage(page, 8);
        List<Patient> patients = patientMapper.selectAll();
        int count = patientMapper.getcount();
        int pages = (int) Math.ceil(count/8.0);
        model.addAttribute("Number",page);
        model.addAttribute("TotalPages",pages);

        System.out.println(patients);

        return patients;
    }

    //注册患者
    public void
    savePatient(Patient patient,HttpSession session) {
        if(patient != null){
            session.setAttribute("patient",patient);
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
    public void deletePatients(int[] patients){
          for (int i=0;i<patients.length;i++){
              patientMapper.deleteByPrimaryKey(patients[i]);
          }
    }

    @Override
    public Result choicePatient(int patient_number, HttpSession session) {
        Patient patient = patientMapper.selectByPrimaryKey(patient_number);
        if(patient != null){
            session.setAttribute("patient",patient);
            return new Result(ResultCode.SUCCESS);
        }
        return new Result(ResultCode.FAIL);
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
        PageHelper.startPage(page,8);
        List<Patient> drugList = patientMapper.searchName(patientAttribute);
        int count = patientMapper.searchNameCount(patientAttribute);
        model.addAttribute("Number",page);
        int pages = (int) Math.ceil(count/8.0);
        model.addAttribute("TotalPages",pages);
        return drugList;

    }

}
