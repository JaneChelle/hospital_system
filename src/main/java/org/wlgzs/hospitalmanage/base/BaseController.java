package org.wlgzs.hospitalmanage.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.wlgzs.hospitalmanage.service.DiseaseService;
import org.wlgzs.hospitalmanage.service.DrugAttributeService;
import org.wlgzs.hospitalmanage.service.DrugService;
import org.wlgzs.hospitalmanage.service.PatientService;
import org.wlgzs.hospitalmanage.service.*;

/**
 * @author:胡亚星
 * @createTime 2018-08-12 15:47
 * @description:
 **/
public class BaseController {

    @Autowired
    protected DiseaseService diseaseService;

    @Autowired
    protected PatientService patientService;

    @Autowired

    protected DrugService drugService;

    @Autowired
    protected DrugAttributeService drugAttributeService;

    @Autowired
    protected PrescriptionService prescriptionService;

    @Autowired
    protected CheckService checkService;

    @Autowired
    protected TreatmentService treatmentService;

    @Autowired
    protected NoteService noteService;
}
