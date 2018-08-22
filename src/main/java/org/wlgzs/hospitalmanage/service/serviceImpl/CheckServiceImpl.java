package org.wlgzs.hospitalmanage.service.serviceImpl;

import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.wlgzs.hospitalmanage.dao.CheckMapper;
import org.wlgzs.hospitalmanage.entity.Check;
import org.wlgzs.hospitalmanage.service.CheckService;
import org.wlgzs.hospitalmanage.util.IdsUtil;
import org.wlgzs.hospitalmanage.util.Result;
import org.wlgzs.hospitalmanage.util.ResultCode;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author:胡亚星
 * @createTime 2018-08-14 11:16
 * @description:
 **/
@Service
public class CheckServiceImpl implements CheckService {
    @Resource
    CheckMapper checkMapper;

    //新增
    @Override
    public Result addCheck(Check check) {
        if(check != null){
            checkMapper.insert(check);
            return new Result(ResultCode.SUCCESS);
        }
        return new Result(ResultCode.FAIL);
    }

    //查找全部分页
    @Override
    public List<Check> selectAll(int page) {
        PageHelper.startPage(page,10);
        List<Check> list = checkMapper.selectAll();
        return list;
    }

    //按id删除
    @Override
    public Result deleteCheck(int checkId) {
        System.out.println(checkId);
        Check check = checkMapper.selectByPrimaryKey(checkId);
        System.out.println(check);
        if(check != null){
            System.out.println("存在");
            checkMapper.delete(check);
            return new Result(ResultCode.SUCCESS);
        }
        return new Result(ResultCode.FAIL);
    }

    //按id查询
    @Override
    public Result findCheckById(int checkId) {
        Check check = checkMapper.selectByPrimaryKey(checkId);
        if(check != null){
            return new Result(ResultCode.SUCCESS,check);
        }
        return new Result(ResultCode.FAIL);
    }

    //修改
    @Override
    public void modifyCheck(Check check) {
        if(check != null){
            checkMapper.updateByPrimaryKeySelective(check);
        }
    }

    //搜索检查
    @Override
    public List<Check> findCheck(String findName, int page) {
        PageHelper.startPage(page,10);
        List<Check> checkList = checkMapper.findCheck(findName);
        System.out.println(checkList);
        return checkList;
    }

    //搜索提示
    @Override
    public Result findCheckByWord(String search_word) {
        if(search_word != null && !search_word.equals("")){
            List<Check> checkList = checkMapper.findCheckByWord(search_word);
            List<String> list = new ArrayList<String>();
            for (Check aCheckList : checkList) {
                list.add(aCheckList.getCheck_name());
            }
            return new Result(ResultCode.SUCCESS,list);
        }
        return new Result(ResultCode.FAIL);
    }

    //批量删除
    @Override
    public Result deleteCheckByIds(String checkIds) {
        IdsUtil idsUtil = new IdsUtil();
        int[] Ids = idsUtil.IdsUtils(checkIds);
        checkMapper.deleteCheckByIds(Ids);
        return new Result(ResultCode.SUCCESS);
    }


}
