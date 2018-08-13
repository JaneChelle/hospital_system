package org.wlgzs.hospitalmanage.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.wlgzs.hospitalmanage.base.BaseController;
import org.wlgzs.hospitalmanage.entity.Disease;

/**
 * @author:胡亚星
 * @createTime 2018-08-12 15:40
 * @description:
 **/

@RestController
@RequestMapping("/disease")
public class DiseaseController extends BaseController {

    //添加疾病
    @RequestMapping(value = "addDisease",method = RequestMethod.PUT)
    public ModelAndView addDisease(Disease disease){
        diseaseService.addDisease(disease);
        return new ModelAndView("index");
    }

}
