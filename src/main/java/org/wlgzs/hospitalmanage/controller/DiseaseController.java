package org.wlgzs.hospitalmanage.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.wlgzs.hospitalmanage.base.BaseController;
import org.wlgzs.hospitalmanage.entity.Disease;
import org.wlgzs.hospitalmanage.util.Result;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author:胡亚星
 * @createTime 2018-08-12 15:40
 * @description: 疾病管理控制层
 **/

@RestController
@RequestMapping("/disease")
public class DiseaseController extends BaseController {

    //添加疾病
    @RequestMapping(value = "", method = RequestMethod.PUT)
    public Result addDisease(Disease disease) {
        return diseaseService.addDisease(disease);
    }

    //删除疾病
    @RequestMapping(value = "/{diseaseId}", method = RequestMethod.DELETE)
    public Result deleteDisease(@PathVariable("diseaseId") int diseaseId) {
        return diseaseService.deleteDiseaseById(diseaseId);
    }

    //查找所有疾病(分页)
    @RequestMapping(value = "/{page}", method = RequestMethod.GET)
    public ModelAndView selectAll(Model model, @PathVariable("page") int page) {
        List<Disease> diseaseList = diseaseService.selectAll(page,model);
        model.addAttribute("diseaseList", diseaseList);
        model.addAttribute("isSearch",0);
        return new ModelAndView("diseaseList");
    }

    //搜索疾病(分页)
    @RequestMapping(value = "/findDisease/{page}")
    public ModelAndView findDisease(Model model,
                                    @PathVariable("page") int page,
                                    @RequestParam(value = "findName", defaultValue = "") String findName) {
        List<Disease> diseaseList = diseaseService.findDisease(findName,page,model);
        model.addAttribute("diseaseList",diseaseList);
        model.addAttribute("findName",findName);
        model.addAttribute("isSearch",1);
        return new ModelAndView("diseaseList");
    }

    //疾病搜索提示
    @RequestMapping(value = "/searchWord")
    public Result searchWord(@RequestParam(value = "search_word") String search_word){
        return diseaseService.findDiseaseByWord(search_word);
    }


    //选择疾病存入session
    @RequestMapping("/selectDisease")
    public Result selectDisease(int disease_id,HttpSession session){
        return diseaseService.selectDisease(disease_id,session);
    }

    //批量删除
    @RequestMapping("/deleteDiseaseByIds")
    public Result deleteDiseaseByIds(String DiseaseIds){
        return diseaseService.deleteDiseaseByIds(DiseaseIds);
    }

}
