package org.wlgzs.hospitalmanage.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wlgzs.hospitalmanage.dao.DiseaseMapper;
import org.wlgzs.hospitalmanage.entity.Disease;
import org.wlgzs.hospitalmanage.service.DiseaseService;

import javax.annotation.Resource;

/**
 * @author:胡亚星
 * @createTime 2018-08-12 15:57
 * @description:
 **/
@Service
public class DiseaseServiceImpl implements DiseaseService {

    @Resource
    private DiseaseMapper diseaseMapper;

    //添加疾病
    @Override
    public void addDisease(Disease disease) {
        diseaseMapper.insert(disease);
    }


}
