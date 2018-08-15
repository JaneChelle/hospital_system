package org.wlgzs.hospitalmanage.service.serviceImpl;

import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.wlgzs.hospitalmanage.dao.DiseaseMapper;
import org.wlgzs.hospitalmanage.entity.Disease;
import org.wlgzs.hospitalmanage.service.DiseaseService;
import org.wlgzs.hospitalmanage.util.Result;
import org.wlgzs.hospitalmanage.util.ResultCode;

import javax.annotation.Resource;
import java.util.List;

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
    public Result addDisease(Disease disease) {
        if(disease != null){
            diseaseMapper.insert(disease);
            return new Result(ResultCode.SUCCESS);
        }
        return new Result(ResultCode.FAIL);
    }

    //删除疾病
    @Override
    public Result deleteDiseaseById(int diseaseId) {
        System.out.println(diseaseId);
        Disease disease = diseaseMapper.findById(diseaseId);
        /*Disease disease = diseaseMapper.selectByPrimaryKey(8);*/
        System.out.println(disease);
        if(disease != null){
            System.out.println("存在");
            diseaseMapper.delete(disease);
            return new Result(ResultCode.SUCCESS);
        }
        return new Result(ResultCode.FAIL);
    }

    @Override
    public List<Disease> selectAll(int page) {
        PageHelper.startPage(page,10);
        List<Disease> diseaseList = diseaseMapper.selectAll();
        System.out.println(diseaseList);
        return diseaseList;
    }

    @Override
    public List<Disease> findDisease(String findName,int page) {
        PageHelper.startPage(page,10);
        List<Disease> diseaseList = diseaseMapper.findDisease(findName);
        System.out.println(diseaseList);
        return diseaseList;
    }

    public Disease findByName (String name) {
        return diseaseMapper.findByName(name);
    }
}
