package org.wlgzs.hospitalmanage.service;

import org.springframework.ui.Model;
import org.wlgzs.hospitalmanage.entity.Patient;
import org.wlgzs.hospitalmanage.util.Result;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author 武凯焱
 * @date 2018/8/13 15:04
 */

public interface PatientService {
    List<Patient> getPatients(Model model, int page);

    Boolean check(String patient_name);

    boolean savePatient(Patient patient, HttpSession session);

    boolean deletePatient(int patientId);

    void updatePatient(Patient patient);

    List<Patient> keyWordsearchPatient(String patientPhone);

    List<Patient> searchPatient(Model model, String patientAttribute, int page);

    void deletePatients(int[] patients);

    Patient patinetLink(int patientId);

    //选择患者
    Result choicePatient(int patient_number, HttpSession session);

    //判断患者是否存在
    Result checkPatient(String patient_name);

    //查询欠费的患者
    List<Patient> billsPatient();

    //还账
    Result payback(int patient_id,String price);
}
