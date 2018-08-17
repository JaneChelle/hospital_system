package org.wlgzs.hospitalmanage.service.serviceImpl;

import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.wlgzs.hospitalmanage.dao.PatientMapper;
import org.wlgzs.hospitalmanage.entity.Patient;
import org.wlgzs.hospitalmanage.service.PatientService;

import javax.annotation.Resource;
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
    public List<Patient> getPatients(int page) {
        PageHelper.startPage(page, 10);
        List<Patient> patients = patientMapper.selectAll();
        System.out.println(patients);

        return patients;
    }

    //注册患者
    public void savePatient(Patient patient) {
        patientMapper.insert(patient);
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
    public List<Patient> searchPatient(String patientAttribute) {
            return patientMapper.searchName(patientAttribute);

    }

}
