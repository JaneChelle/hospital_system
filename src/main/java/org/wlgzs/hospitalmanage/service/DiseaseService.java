package org.wlgzs.hospitalmanage.service;

import org.springframework.ui.Model;
import org.wlgzs.hospitalmanage.entity.Disease;
import org.wlgzs.hospitalmanage.util.Result;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author:胡亚星
 * @createTime 2018-08-12 15:53
 * @description:
 **/
public interface DiseaseService {

    //添加疾病
    Result addDisease(Disease disease,HttpSession session);

    //通过id删除
    Result deleteDiseaseById(int diseaseId);

    //查询所有
    List<Disease> selectAll(int page,Model model);

    //搜索疾病
    List<Disease> findDisease(String findName,int page,Model model);

    Result findDiseaseByWord(String search_word);

    //选择疾病存入session
    Result selectDisease(int disease_id, HttpSession session);

    //批量删除
    Result deleteDiseaseByIds(String DiseaseIds);

    //按名字查询疾病是否存在
    Result checkDisease(String disease_name);
}
