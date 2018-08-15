package org.wlgzs.hospitalmanage.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
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
        List<Check> checkList = checkService.selectAll(page);
        model.addAttribute("checkList", checkList);
        System.out.println(checkList.get(0));
        return new ModelAndView("check");
    }

    //删除
    @RequestMapping(value = "/check/{checkId}", method = RequestMethod.DELETE)
    public Result deleteCheck(@PathVariable("checkId") int checkId) {
        return checkService.deleteCheck(checkId);
    }

    //按id查询
    @RequestMapping(value = "/findCheckById/{checkId}", method = RequestMethod.GET)
    public Result findCheckById(@PathVariable("checkId") int checkId) {
        return checkService.findCheckById(checkId);
    }

    //修改检查
    @RequestMapping(value = "check", method = RequestMethod.POST)
    public ModelAndView modifyCheck(Check check){
        checkService.modifyCheck(check);
        return new ModelAndView("redirect:/check/1");
    }


}
