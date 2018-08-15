package org.wlgzs.hospitalmanage.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
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
        List<Treatment> treatmentList = treatmentService.selectAll(page);
        model.addAttribute("treatmentList", treatmentList);
        System.out.println(treatmentList.get(0));
        return new ModelAndView("treatment");
    }

    //删除
    @RequestMapping(value = "/treatment/{treatmentId}", method = RequestMethod.DELETE)
    public Result deleteTreatment(@PathVariable("treatmentId") int treatmentId) {
        return treatmentService.deleteTreatment(treatmentId);
    }

    //按id查询
    @RequestMapping(value = "/findCheckById/{treatmentId}", method = RequestMethod.GET)
    public Result findTreatmentById(@PathVariable("treatmentId") int treatmentId) {
        return treatmentService.findTreatmentById(treatmentId);
    }

    //修改治疗
    @RequestMapping(value = "treatment", method = RequestMethod.POST)
    public ModelAndView modifyCheck(Treatment treatment){
        treatmentService.modifyTreatment(treatment);
        return new ModelAndView("redirect:/treatment/1");
    }

}
