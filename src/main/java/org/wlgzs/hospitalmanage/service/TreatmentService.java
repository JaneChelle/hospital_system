package org.wlgzs.hospitalmanage.service;

import org.wlgzs.hospitalmanage.entity.Treatment;
import org.wlgzs.hospitalmanage.util.Result;

import java.util.List;

/**
 * @author:胡亚星
 * @createTime 2018-08-14 15:24
 * @description:
 **/
public interface TreatmentService {

    //新增
    Result addTreatment(Treatment treatment);

    //查找全部分页
    List<Treatment> selectAll(int page);

    //按id删除
    Result deleteTreatment(int treatmentId);

    //按id查询
    Result findTreatmentById(int treatmentId);

    //修改
    Result modifyTreatment(Treatment treatment);

    //搜索治疗
    List<Treatment> findTreatment(String findName,int page);

    //搜索提示
    Result findTreatmentByWord(String search_word);

    //批量删除
    Result deleteTreatmentByIds(String treatmentIds);
}
