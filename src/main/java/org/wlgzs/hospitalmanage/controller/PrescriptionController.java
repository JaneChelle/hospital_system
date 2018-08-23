package org.wlgzs.hospitalmanage.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.wlgzs.hospitalmanage.base.BaseController;
import org.wlgzs.hospitalmanage.entity.*;
import org.wlgzs.hospitalmanage.util.Result;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author: 胡亚星
 * @createTime 2018-08-13 22:12
 * @description:
 **/
@RestController
public class PrescriptionController extends BaseController {

    //跳转到新增处方
    @RequestMapping(value = "/prescription/toAddPrescription")
    public ModelAndView toAddPrescription(){
        return new ModelAndView("addPrescription");
    }

    //新增处方
    @RequestMapping(value = "/prescription", method = RequestMethod.PUT)
    public ModelAndView addPrescription(Prescription prescription,HttpServletResponse response){
        System.out.println(prescription);
        prescriptionService.addPrescription(prescription,response);
        return new ModelAndView("addDrug");
    }

    //查看所有处方
    @RequestMapping(value = "/prescription/{page}", method = RequestMethod.GET)
    public ModelAndView selectAll(Model model, @PathVariable("page") int page){
        List<Prescription> prescriptionList = prescriptionService.selectAll(page);
        model.addAttribute("prescriptionList", prescriptionList);
        System.out.println(prescriptionList);
        return new ModelAndView("prescriptionList");
    }

    //删除处方
    @RequestMapping(value = "/prescription/{prescriptionId}", method = RequestMethod.DELETE)
    public Result deletePrescription(@PathVariable("prescriptionId") int prescriptionId) {
        return prescriptionService.deletePrescription(prescriptionId);
    }

    //按id查询(修改和查看详情)
    @RequestMapping(value = "/prescription/findPrescription/{prescriptionId}", method = RequestMethod.GET)
    public ModelAndView findPrescriptionById(Model model,@PathVariable("prescriptionId") int prescriptionId) {

        Prescription prescription = prescriptionService.findPrescriptionById(prescriptionId);//处方
        List<PrescriptionDrug> prescriptionDrugList = prescriptionService.queryPrescriptionDrug(prescriptionId);
        List<PrescriptionCheck> prescriptionCheckList = prescriptionService.queryPrescriptionCheck(prescriptionId);
        List<PrescriptionTreatment> prescriptionTreatmentList = prescriptionService.queryPrescriptionTreatment(prescriptionId);
        model.addAttribute("prescriptionDrugList",prescriptionDrugList);
        model.addAttribute("prescriptionCheckList",prescriptionCheckList);
        model.addAttribute("prescriptionTreatmentList",prescriptionTreatmentList);
        model.addAttribute("prescription",prescription);

        return new ModelAndView("prescriptionDetails");
    }

    //修改处方
    @RequestMapping(value = "/prescription", method = RequestMethod.POST)
    public ModelAndView modifyPrescription(Prescription prescription){
        prescriptionService.modifyPrescription(prescription);
        return new ModelAndView("redirect:/prescription/findPrescription");
    }

    //跳转到添加药品明细(搜索)
    @RequestMapping(value = "/prescription/toAddDrug")
    public ModelAndView toAddDrug(Model model,HttpSession session,
                                  @RequestParam(value = "findName", defaultValue = "") String findName){
        List<Drug> drugList = drugService.searchDrug(model,findName ,0);

        //搜索已经加入的药品
        List<PrescriptionDrug> prescriptionDrugList = prescriptionService.queryPrescriptionDrug(session);
        System.out.println("prescriptionDrugList"+prescriptionDrugList);
        model.addAttribute("prescriptionDrugList",prescriptionDrugList);
        model.addAttribute("findName",findName);
        System.out.println("drugList"+drugList);
        System.out.println("findName"+findName);
        model.addAttribute("drugList",drugList);
        return new ModelAndView("addDrug");
    }

    //添加药品明细
    @RequestMapping(value = "/prescription/addDrug")
    public ModelAndView addDrug(PrescriptionDrug prescriptionDrug,HttpServletRequest request){
        prescriptionService.addDrug(prescriptionDrug,request);
        return new ModelAndView("redirect:/prescription/toAddDrug");
    }

    //跳转到添加检查明细(搜索)
    @RequestMapping(value = "/prescription/toAddCheck")
    public ModelAndView toAddCheck(Model model,HttpSession session,
                                   @RequestParam(value = "findName", defaultValue = "") String findName){
        List<Check> checkList = checkService.findCheck(findName,0);
        //搜索已经加入的检查
        List<PrescriptionCheck> prescriptionCheckList = prescriptionService.queryPrescriptionCheck(session);
        System.out.println("prescriptionCheckList"+prescriptionCheckList);
        model.addAttribute("prescriptionCheckList",prescriptionCheckList);
        model.addAttribute("findName",findName);
        System.out.println("checkList"+checkList);
        System.out.println("findName"+findName);
        model.addAttribute("checkList",checkList);
        return new ModelAndView("addCheck");
    }

    //添加检查明细
    @RequestMapping(value = "/prescription/addCheck")
    public ModelAndView addCheck(PrescriptionCheck prescriptionCheck,HttpSession session){
        prescriptionService.addCheck(prescriptionCheck,session);
        return new ModelAndView("redirect:/prescription/toAddCheck");
    }

    //跳转到添加治疗方案(搜索)
    @RequestMapping(value = "/prescription/toAddTreatment")
    public ModelAndView toAddTreatment(Model model,HttpSession session,
                                   @RequestParam(value = "findName", defaultValue = "") String findName){
        List<Treatment> treatmentList = treatmentService.findTreatment(findName,0);
        //搜索已经加入的治疗
        List<PrescriptionTreatment> prescriptionTreatmentList = prescriptionService.queryPrescriptionTreatment(session);
        System.out.println("prescriptionCheckList"+prescriptionTreatmentList);
        model.addAttribute("prescriptionCheckList",prescriptionTreatmentList);
        model.addAttribute("findName",findName);
        System.out.println("treatmentList"+treatmentList);
        System.out.println("findName"+findName);
        model.addAttribute("treatmentList",treatmentList);
        return new ModelAndView("addTreatment");
    }

    //添加治疗明细
    @RequestMapping(value = "/prescription/addTreatment")
    public ModelAndView addTreatment(PrescriptionTreatment prescriptionTreatment, HttpSession session){
        prescriptionService.addTreatment(prescriptionTreatment,session);
        return new ModelAndView("redirect:/prescription/toAddTreatment");
    }

    //完成时计算总价
    @RequestMapping(value = "/prescription/totalPrice")
    public ModelAndView totalPrice(HttpSession session){
        prescriptionService.totalPrice(session);
        return new ModelAndView("redirect:/prescription/1");
    }

    //搜索所有处方
    @RequestMapping(value = "/prescription/findPrescription")
    public ModelAndView findPrescription(Model model,
                                         @RequestParam(value = "findName", defaultValue = "") String findName){
        List<Prescription> prescriptionList = prescriptionService.findPrescription(findName,0);
        model.addAttribute("findName",findName);
        model.addAttribute("prescriptionList",prescriptionList);
        return new ModelAndView("prescriptionList");
    }

    //搜索提示
    @RequestMapping("/prescription/searchWord")
    public Result searchWord(@RequestParam(value = "search_word") String search_word){
        return prescriptionService.findPrescriptionByWord(search_word);
    }

}
