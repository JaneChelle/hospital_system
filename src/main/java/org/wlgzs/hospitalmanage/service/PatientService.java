package org.wlgzs.hospitalmanage.service;

import org.wlgzs.hospitalmanage.entity.Patient;

import java.util.List;

/**
 * @author 武凯焱
 * @date 2018/8/13 15:04
 */

public interface PatientService {
     List<Patient> getPatients(int page);

    void savePatient(Patient patient);

    boolean deletePatient(int patientId);

    void updatePatient(Patient patient);

    List<Patient> keyWordsearchPatient (String patientPhone);

    List<Patient> searchPatient(String patientAttribute);




}
