package org.wlgzs.hospitalmanage.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.wlgzs.hospitalmanage.base.BaseController;
import org.wlgzs.hospitalmanage.entity.Check;
import org.wlgzs.hospitalmanage.util.Result;

import java.util.List;

/**
 * @author:胡亚星
 * @createTime 2018-08-14 11:05
 * @description:
 **/
@RestController
public class CheckController extends BaseController {

    //新增检查
    @RequestMapping(value = "/check", method = RequestMethod.PUT)
    public Result addCheck(Check check) {
        return checkService.addCheck(check);
    }

    //查看所有检查
    @RequestMapping(value = "/check/{page}", method = RequestMethod.GET)
    public ModelAndView selectAll(Model model, @PathVariable("page") int page) {
        List<Check> checkList = checkService.selectAll(page,model);
        model.addAttribute("checkList", checkList);
        model.addAttribute("isSearch",1);
        return new ModelAndView("check");
    }

    //删除
    @RequestMapping(value = "/check/{checkId}", method = RequestMethod.DELETE)
    public Result deleteCheck(@PathVariable("checkId") int checkId) {
        return checkService.deleteCheck(checkId);
    }

    //按id查询
    @RequestMapping(value = "/check/findCheckById/{checkId}", method = RequestMethod.GET)
    public Result findCheckById(@PathVariable("checkId") int checkId) {
        return checkService.findCheckById(checkId);
    }

    //修改检查
    @RequestMapping(value = "/check", method = RequestMethod.POST)
    public Result modifyCheck(Check check){
        return checkService.modifyCheck(check);
    }

    //搜索检查
    @RequestMapping(value = "/check/findCheck/{page}")
    public ModelAndView findCheck(Model model,
                                  @RequestParam(value = "findName", defaultValue = "") String findName,
                                  @PathVariable("page") int page){
        List<Check> checkList = checkService.findCheck(findName,page,model);
        model.addAttribute("findName",findName);
        model.addAttribute("checkList",checkList);
        model.addAttribute("isSearch",1);
        return new ModelAndView("check");
    }

    //搜索提示
    @RequestMapping(value = "/check/searchWord")
    public Result searchWord(@RequestParam(value = "search_word") String search_word){
        return checkService.findCheckByWord(search_word);
    }

    //批量删除
    @RequestMapping("/check/deleteCheckByIds")
    public Result deleteCheckByIds(String checkIds){
        return checkService.deleteCheckByIds(checkIds);
    }

    //查看检查是否被占用
    @RequestMapping("/check/TakeUpCheck")
    public Result TakeUpCheck(@RequestParam("check_id")int check_id){
        return prescriptionService.TakeUpCheck(check_id);
    }

}
