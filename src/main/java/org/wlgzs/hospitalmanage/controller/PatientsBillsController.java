package org.wlgzs.hospitalmanage.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.wlgzs.hospitalmanage.base.BaseController;
import org.wlgzs.hospitalmanage.entity.BillNote;
import org.wlgzs.hospitalmanage.entity.Note;
import org.wlgzs.hospitalmanage.entity.Patient;
import org.wlgzs.hospitalmanage.util.Result;

import java.util.List;

/**
 * @author:胡亚星
 * @createTime: 2018-09-22 9:02
 * @description:
 **/
@RestController
@RequestMapping("/bills")
public class PatientsBillsController extends BaseController {

    //查看欠费的患者
    @RequestMapping(value = "/billsPatient",method = RequestMethod.GET)
    public ModelAndView billsPatient(Model model){
        List<Patient> patientList = patientService.billsPatient();
        model.addAttribute("patientList",patientList);
        return new ModelAndView("billsPatient");
    }

    //查看欠费患者详情
    @RequestMapping(value = "/billsDetails")
    public ModelAndView billsDetails(Model model,@RequestParam("patient_id") int patient_id){
        Patient patient = patientService.patinetLink(patient_id);
        List<Note> noteList = noteService.billsDetails(patient_id);
        //查询还账记录
        List<BillNote> billNotes = billNoteService.selectBillNoteById(patient_id);
        model.addAttribute("patient",patient);
        model.addAttribute("noteList",noteList);
        model.addAttribute("billNotes",billNotes);
        return new ModelAndView("billsDetails");
    }

    //还账
    @RequestMapping(value = "/payback")
    public Result payback(@RequestParam("patient_id") int patient_id,
                          @RequestParam("price") String price){
        return patientService.payback(patient_id,price);
    }

}
