package org.wlgzs.hospitalmanage.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.wlgzs.hospitalmanage.base.BaseController;
import org.wlgzs.hospitalmanage.entity.Disease;
import org.wlgzs.hospitalmanage.util.Result;

import java.util.List;

/**
 * @author:胡亚星
 * @createTime 2018-08-12 15:40
 * @description: 疾病管理控制层
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

    //查找所有疾病(分页)
    @RequestMapping(value = "/disease/{page}", method = RequestMethod.GET)
    public ModelAndView selectAll(Model model, @PathVariable("page") int page) {
        List<Disease> diseaseList = diseaseService.selectAll(page);
        model.addAttribute("diseaseList", diseaseList);
        return new ModelAndView("disease");
    }

    //搜索疾病(分页)
    @RequestMapping(value = "/findDisease/{page}")
    public ModelAndView findDisease(Model model,@PathVariable("page") int page,
                                    @RequestParam(value = "findName", defaultValue = "") String findName) {
        List<Disease> diseaseList = diseaseService.findDisease(findName,page);
        model.addAttribute("diseaseList",diseaseList);
        return new ModelAndView("disease");
    }

}
