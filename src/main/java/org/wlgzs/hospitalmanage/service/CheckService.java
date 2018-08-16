package org.wlgzs.hospitalmanage.service;

import org.wlgzs.hospitalmanage.entity.Check;
import org.wlgzs.hospitalmanage.util.Result;

import java.util.List;

/**
 * @author:胡亚星
 * @createTime 2018-08-14 11:16
 * @description:
 **/
public interface CheckService {
    //新增
    Result addCheck(Check check);

    //查找全部分页
    List<Check> selectAll(int page);

    //按id删除
    Result deleteCheck(int checkId);

    //按id查询
    Result findCheckById(int checkId);

    //修改
    void modifyCheck(Check check);

    //搜索检查
    List<Check> findCheck(String findName,int page);

    //搜索提示
    Result findCheckByWord(String search_word);


}
