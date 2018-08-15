package org.wlgzs.hospitalmanage.service.serviceImpl;

import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.wlgzs.hospitalmanage.dao.CheckMapper;
import org.wlgzs.hospitalmanage.entity.Check;
import org.wlgzs.hospitalmanage.service.CheckService;
import org.wlgzs.hospitalmanage.util.Result;
import org.wlgzs.hospitalmanage.util.ResultCode;

import javax.annotation.Resource;
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

    @Override
    public Result addCheck(Check check) {
        if(check != null){
            checkMapper.insert(check);
            return new Result(ResultCode.SUCCESS);
        }
        return new Result(ResultCode.FAIL);
    }

    @Override
    public List<Check> selectAll(int page) {
        PageHelper.startPage(page,10);
        List<Check> list = checkMapper.selectAll();
        return list;
    }

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

    @Override
    public Result findCheckById(int checkId) {
        Check check = checkMapper.selectByPrimaryKey(checkId);
        if(check != null){
            return new Result(ResultCode.SUCCESS,check);
        }
        return new Result(ResultCode.FAIL);
    }

    @Override
    public void modifyCheck(Check check) {
        if(check != null){
            checkMapper.updateByPrimaryKeySelective(check);
        }
    }
}
