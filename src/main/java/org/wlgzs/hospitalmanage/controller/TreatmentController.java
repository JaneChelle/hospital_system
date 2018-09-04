package org.wlgzs.hospitalmanage.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.wlgzs.hospitalmanage.base.BaseController;
import org.wlgzs.hospitalmanage.entity.Treatment;
import org.wlgzs.hospitalmanage.util.Result;

import java.util.List;

/**
 * @author:胡亚星
 * @createTime 2018-08-14 15:20
 * @description:
 **/
@RestController
public class TreatmentController extends BaseController {

    //新增治疗
    @RequestMapping(value = "/treatment", method = RequestMethod.PUT)
    public Result addTreatment(Treatment treatment) {
        return treatmentService.addTreatment(treatment);
    }

    //查看所有治疗
    @RequestMapping(value = "/treatment/{page}", method = RequestMethod.GET)
    public ModelAndView selectAll(Model model, @PathVariable("page") int page) {
        List<Treatment> treatmentList = treatmentService.selectAll(page,model);
        model.addAttribute("treatmentList", treatmentList);
        model.addAttribute("isSearch",0);
        return new ModelAndView("treatment");
    }

    //删除
    @RequestMapping(value = "/treatment/{treatmentId}", method = RequestMethod.DELETE)
    public Result deleteTreatment(@PathVariable("treatmentId") int treatmentId) {
        return treatmentService.deleteTreatment(treatmentId);
    }

    //按id查询
    @RequestMapping(value = "/treatment/findTreatmentById/{treatmentId}", method = RequestMethod.GET)
    public Result findTreatmentById(@PathVariable("treatmentId") int treatmentId) {
        return treatmentService.findTreatmentById(treatmentId);
    }

    //修改治疗
    @RequestMapping(value = "/treatment", method = RequestMethod.POST)
    public Result modifyTreatment(Treatment treatment){
        return treatmentService.modifyTreatment(treatment);
    }

    //搜索治疗
    @RequestMapping(value = "/treatment/findTreatment/{page}")
    public ModelAndView findTreatment(Model model,
                                      @PathVariable("page") int page,
                                  @RequestParam(value = "findName", defaultValue = "") String findName){
        List<Treatment> treatmentList = treatmentService.findTreatment(findName,page,model);
        model.addAttribute("findName",findName);
        model.addAttribute("treatmentList",treatmentList);
        model.addAttribute("isSearch",1);
        return new ModelAndView("treatment");
    }

    //搜索提示
    @RequestMapping(value = "/treatment/searchWord")
    public Result searchWord(@RequestParam(value = "search_word") String search_word){
        return treatmentService.findTreatmentByWord(search_word);
    }

    //批量删除
    @RequestMapping("/check/deleteByIds")
    public Result deleteCheckByIds(String treatmentIds){
        return treatmentService.deleteTreatmentByIds(treatmentIds);
    }

}
