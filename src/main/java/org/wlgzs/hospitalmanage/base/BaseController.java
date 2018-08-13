package org.wlgzs.hospitalmanage.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.wlgzs.hospitalmanage.service.DiseaseService;

import javax.annotation.Resource;

/**
 * @author:胡亚星
 * @createTime 2018-08-12 15:47
 * @description:
 **/
public class BaseController {

    @Autowired
    protected DiseaseService diseaseService;
}
