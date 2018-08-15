package org.wlgzs.hospitalmanage.service;

import org.wlgzs.hospitalmanage.entity.Disease;
import org.wlgzs.hospitalmanage.util.Result;

import java.util.List;

/**
 * @author:胡亚星
 * @createTime 2018-08-12 15:53
 * @description:
 **/
public interface DiseaseService {

    //添加疾病
    Result addDisease(Disease disease);

    //通过id删除
    Result deleteDiseaseById(int diseaseId);

    //查询所有
    List<Disease> selectAll(int page);

    //搜索疾病
    List<Disease> findDisease(String findName,int page);


}
