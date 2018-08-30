package org.wlgzs.hospitalmanage.controller;

import org.springframework.http.HttpRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.wlgzs.hospitalmanage.base.BaseController;
import org.wlgzs.hospitalmanage.entity.*;
import org.wlgzs.hospitalmanage.util.Result;
import org.wlgzs.hospitalmanage.util.ResultCode;

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
    public ModelAndView toAddPrescription() {
        return new ModelAndView("addAPrescription");
    }

    //新增处方
    @RequestMapping(value = "/prescription", method = RequestMethod.PUT)
    public Result addPrescription(Prescription prescription, HttpSession session) {
        System.out.println(prescription);
        return prescriptionService.addPrescription(prescription, session);
    }

    //查看所有处方
    @RequestMapping(value = "/prescription/{page}", method = RequestMethod.GET)
    public ModelAndView selectAll(Model model, @PathVariable("page") int page) {
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
    @RequestMapping(value = "/prescription/findPrescriptionById")
    public ModelAndView findPrescriptionById(Model model, @RequestParam("prescriptionId") int prescriptionId, HttpSession session) {
        session.setAttribute("prescription_id", prescriptionId + "");
        Prescription prescription = prescriptionService.findPrescriptionById(prescriptionId);//处方
        List<PrescriptionDrug> prescriptionDrugList = prescriptionService.queryPrescriptionDrug(prescriptionId);
        List<PrescriptionCheck> prescriptionCheckList = prescriptionService.queryPrescriptionCheck(prescriptionId);
        List<PrescriptionTreatment> prescriptionTreatmentList = prescriptionService.queryPrescriptionTreatment(prescriptionId);
        model.addAttribute("prescriptionDrugList", prescriptionDrugList);
        model.addAttribute("prescriptionCheckList", prescriptionCheckList);
        model.addAttribute("prescriptionTreatmentList", prescriptionTreatmentList);
        model.addAttribute("prescription", prescription);

        return new ModelAndView("prescriptionDetails");
    }

    //修改处方
    @RequestMapping(value = "/prescription", method = RequestMethod.POST)
    public ModelAndView modifyPrescription(Prescription prescription) {
        prescriptionService.modifyPrescription(prescription);
        return new ModelAndView("redirect:/prescription/findPrescription");
    }

    //跳转到添加药品明细(搜索)
    @RequestMapping(value = "/prescription/toAddDrug")
    public ModelAndView toAddDrug(Model model, HttpSession session,
                                  @RequestParam(value = "findName", defaultValue = "") String findName,
                                  @RequestParam(value = "isModify", defaultValue = "") String isModify) {
        List<Drug> drugList = drugService.searchDrug(model, findName, 0);

        //搜索已经加入的药品
        List<PrescriptionDrug> prescriptionDrugList = prescriptionService.queryPrescriptionDrug(session);
        System.out.println("prescriptionDrugList" + prescriptionDrugList);
        model.addAttribute("prescriptionDrugList", prescriptionDrugList);
        model.addAttribute("findName", findName);
        System.out.println("drugList" + drugList);
        System.out.println("findName" + findName);
        model.addAttribute("drugList", drugList);
        System.out.println("isModify"+isModify);
        model.addAttribute("isModify", isModify);
        return new ModelAndView("prescriptionDrugs");
    }

    //添加药品明细
    @RequestMapping(value = "/prescription/addDrug")
    public Result addDrug(PrescriptionDrug prescriptionDrug, HttpSession session) {
//        prescriptionService.addDrug(prescriptionDrug,session);
        return prescriptionService.addDrug(prescriptionDrug, session);
    }

    //删除药品明细
    @RequestMapping(value = "/prescription/deleteDrug")
    public Result deleteDrug(int detailId) {
        return prescriptionService.deleteDrug(detailId);
    }

    //修改已添加的处方药品（数量）
    @RequestMapping("/prescription/modifyPrescriptionDrug")
    public Result modifyPrescriptionDrug(int detail_id, String number) {
        return prescriptionService.modifyPrescriptionDrug(detail_id, number);
    }

    //跳转到添加检查明细(搜索)
    @RequestMapping(value = "/prescription/toAddCheck")
    public ModelAndView toAddCheck(Model model, HttpSession session,
                                   @RequestParam(value = "findName", defaultValue = "") String findName,
                                   @RequestParam(value = "isModify", defaultValue = "") String isModify) {
        List<Check> checkList = checkService.findCheck(findName, 0);
        //搜索已经加入的检查
        List<PrescriptionCheck> prescriptionCheckList = prescriptionService.queryPrescriptionCheck(session);
        System.out.println("prescriptionCheckList" + prescriptionCheckList);
        model.addAttribute("prescriptionCheckList", prescriptionCheckList);
        model.addAttribute("findName", findName);
        System.out.println("checkList" + checkList);
        System.out.println("findName" + findName);
        model.addAttribute("checkList", checkList);
        model.addAttribute("isModify", isModify);
        return new ModelAndView("prescriptionCheck");
    }

    //添加检查明细
    @RequestMapping(value = "/prescription/addCheck")
    public Result addCheck(PrescriptionCheck prescriptionCheck, HttpSession session) {
        return prescriptionService.addCheck(prescriptionCheck, session);
//        return new ModelAndView("redirect:/prescription/toAddCheck");
    }

    //删除检查明细
    @RequestMapping(value = "/prescription/deleteCheck")
    public Result deleteCheck(int checkId) {
        return prescriptionService.deleteCheck(checkId);
    }

    //修改已添加的处方检查（数量）
    @RequestMapping("/prescription/modifyPrescriptionCheck")
    public Result modifyPrescriptionCheck(int detail_id, String number) {
        return prescriptionService.modifyPrescriptionCheck(detail_id, number);
    }

    //跳转到添加治疗方案(搜索)
    @RequestMapping(value = "/prescription/toAddTreatment")
    public ModelAndView toAddTreatment(Model model, HttpSession session,
                                       @RequestParam(value = "findName", defaultValue = "") String findName,
                                       @RequestParam(value = "isModify", defaultValue = "") String isModify) {
        List<Treatment> treatmentList = treatmentService.findTreatment(findName, 0);
        //搜索已经加入的治疗
        List<PrescriptionTreatment> prescriptionTreatmentList = prescriptionService.queryPrescriptionTreatment(session);
        System.out.println("prescriptionCheckList" + prescriptionTreatmentList);
        model.addAttribute("prescriptionCheckList", prescriptionTreatmentList);
        model.addAttribute("findName", findName);
        System.out.println("treatmentList" + treatmentList);
        System.out.println("findName" + findName);
        model.addAttribute("treatmentList", treatmentList);
        model.addAttribute("isModify", isModify);
        return new ModelAndView("prescriptionTherapy");
    }

    //添加治疗明细
    @RequestMapping(value = "/prescription/addTreatment")
    public Result addTreatment(PrescriptionTreatment prescriptionTreatment, HttpSession session) {
        return prescriptionService.addTreatment(prescriptionTreatment, session);
//        return new ModelAndView("redirect:/prescription/toAddTreatment");
    }

    //删除治疗明细
    @RequestMapping(value = "/prescription/deleteTreatment")
    public Result deleteTreatment(int treatmentId) {

        return prescriptionService.deleteTreatment(treatmentId);
    }

    //修改已添加的处方治疗（数量）
    @RequestMapping("/prescription/modifyPrescriptionTreatment")
    public Result modifyPrescriptionTreatment(int detail_id, String number) {
        return prescriptionService.modifyPrescriptionTreatment(detail_id, number);
    }

    //完成时计算总价
    @RequestMapping(value = "/prescription/totalPrice")
    public Result totalPrice(HttpSession session,
                             @RequestParam(value = "isModify", defaultValue = "") String isModify) {
        int prescription_id = Integer.parseInt((String) session.getAttribute("prescription_id"));
        prescriptionService.totalPrice(prescription_id);
        System.out.println("isModify=="+isModify);
        if(isModify.equals("is")){
            System.out.println("prescription_id"+prescription_id);
            return new Result(ResultCode.isModify,prescription_id);
        }
        return new Result(ResultCode.SUCCESS);
//        return new ModelAndView("redirect:/prescription/findPrescriptionById?prescription_id="+prescription_id);
    }

    //搜索所有处方
    @RequestMapping(value = "/prescription/findPrescription")
    public ModelAndView findPrescription(Model model,
                                         @RequestParam(value = "findName", defaultValue = "") String findName) {
        List<Prescription> prescriptionList = prescriptionService.findPrescription(findName, 0);
        model.addAttribute("findName", findName);
        model.addAttribute("prescriptionList", prescriptionList);
        return new ModelAndView("prescriptionList");
    }

    //搜索提示
    @RequestMapping("/prescription/searchWord")
    public Result searchWord(@RequestParam(value = "search_word") String search_word) {
        return prescriptionService.findPrescriptionByWord(search_word);
    }

}
