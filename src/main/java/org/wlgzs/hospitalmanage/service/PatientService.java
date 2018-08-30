package org.wlgzs.hospitalmanage.service;

import org.springframework.ui.Model;
import org.wlgzs.hospitalmanage.entity.Patient;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author 武凯焱
 * @date 2018/8/13 15:04
 */

public interface PatientService {
     List<Patient> getPatients(int page);

    void savePatient(Patient patient, HttpSession session);

    boolean deletePatient(int patientId);

    void updatePatient(Patient patient);

    List<Patient> keyWordsearchPatient (String patientPhone);

    List<Patient> searchPatient(Model model, String patientAttribute, int page);

    void deletePatients(int[] patients);

    Patient patinetLink(int patientId);




}
