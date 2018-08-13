package org.wlgzs.hospitalmanage.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.wlgzs.hospitalmanage.base.BaseController;
import org.wlgzs.hospitalmanage.entity.Disease;
import org.wlgzs.hospitalmanage.util.Result;

import java.util.List;

/**
 * @author:胡亚星
 * @createTime 2018-08-12 15:40
 * @description:
 **/

@RestController
public class DiseaseController extends BaseController {

    //添加疾病
    @RequestMapping(value = "/disease", method = RequestMethod.PUT)
    public Result addDisease(Disease disease) {
        return diseaseService.addDisease(disease);
    }

    //删除疾病
    @RequestMapping(value = "/disease/{diseaseId}", method = RequestMethod.DELETE)
    public Result deleteDisease(@PathVariable("diseaseId") int diseaseId) {
        return diseaseService.deleteDiseaseById(diseaseId);
    }

    //查找所有
    @RequestMapping(value = "/disease",method = RequestMethod.GET)
    public ModelAndView selectAll(Model model){
        List<Disease> diseaseList = diseaseService.selectAll();
        model.addAttribute("diseaseList",diseaseList);
        return new ModelAndView("ascs");
    }

}
