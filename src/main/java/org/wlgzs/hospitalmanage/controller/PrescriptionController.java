package org.wlgzs.hospitalmanage.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.wlgzs.hospitalmanage.base.BaseController;
import org.wlgzs.hospitalmanage.entity.Prescription;
import org.wlgzs.hospitalmanage.entity.PrescriptionDrug;
import org.wlgzs.hospitalmanage.util.Result;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author:胡亚星
 * @createTime 2018-08-13 22:12
 * @description:
 **/
@RestController
public class PrescriptionController extends BaseController {

    //跳转到新增处方
    @RequestMapping(value = "toAddPrescription")
    public ModelAndView toAddPrescription(){
        return new ModelAndView("addPrescription");
    }

    //新增处方
    @RequestMapping(value = "/prescription", method = RequestMethod.PUT)
    public ModelAndView addPrescription(Prescription prescription,HttpServletResponse response){
        prescriptionService.addPrescription(prescription,response);
        return new ModelAndView("addDrug");
    }

    //查看所有处方
    @RequestMapping(value = "/prescription/{page}", method = RequestMethod.GET)
    public ModelAndView selectAll(Model model, @PathVariable("page") int page) {
        List<Prescription> prescriptionList = prescriptionService.selectAll(page);
        model.addAttribute("prescriptionList", prescriptionList);
        System.out.println(prescriptionList);
        return new ModelAndView("prescription");
    }

    //删除
    @RequestMapping(value = "/prescription/{prescriptionId}", method = RequestMethod.DELETE)
    public Result deletePrescription(@PathVariable("prescriptionId") int prescriptionId) {
        return prescriptionService.deletePrescription(prescriptionId);
    }

    //按id查询
    @RequestMapping(value = "/findPrescription/{prescriptionId}", method = RequestMethod.GET)
    public Result findPrescriptionById(@PathVariable("prescriptionId") int prescriptionId) {
        return prescriptionService.findPrescriptionById(prescriptionId);
    }

    //修改处方
    @RequestMapping(value = "/prescription", method = RequestMethod.POST)
    public ModelAndView modifyPrescription(Prescription prescription){
        prescriptionService.modifyPrescription(prescription);
        return new ModelAndView("redirect:/prescription/1");
    }

    //添加药品明细
//    @RequestMapping(value = "/addDrug")
//    public Result addDrug(PrescriptionDrug prescriptionDrug){
//
//    }

    //跳转到添加检查
    @RequestMapping(value = "/toAddCheck")
    public ModelAndView toAddCheck(){
        return new ModelAndView("");
    }


}
