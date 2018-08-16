package org.wlgzs.hospitalmanage.service.serviceImpl;

import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.wlgzs.hospitalmanage.dao.TreatmentMapper;
import org.wlgzs.hospitalmanage.entity.Treatment;
import org.wlgzs.hospitalmanage.service.TreatmentService;
import org.wlgzs.hospitalmanage.util.Result;
import org.wlgzs.hospitalmanage.util.ResultCode;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author:胡亚星
 * @createTime 2018-08-14 15:24
 * @description:
 **/
@Service
public class TreatmentServiceImpl implements TreatmentService {

    @Resource
    TreatmentMapper treatmentMapper;

    @Override
    public Result addTreatment(Treatment treatment) {
        if(treatment != null){
            treatmentMapper.insert(treatment);
            return new Result(ResultCode.SUCCESS);
        }
        return new Result(ResultCode.FAIL);
    }

    @Override
    public List<Treatment> selectAll(int page) {
        PageHelper.startPage(page,10);
        List<Treatment> list = treatmentMapper.selectAll();
        return list;
    }

    @Override
    public Result deleteTreatment(int treatmentId) {
        System.out.println(treatmentId);
        Treatment treatment = treatmentMapper.selectByPrimaryKey(treatmentId);
        System.out.println(treatment);
        if(treatment != null){
            System.out.println("存在");
            treatmentMapper.delete(treatment);
            return new Result(ResultCode.SUCCESS);
        }
        return new Result(ResultCode.FAIL);
    }

    @Override
    public Result findTreatmentById(int treatmentId) {
        Treatment treatment = treatmentMapper.selectByPrimaryKey(treatmentId);
        if(treatment != null){
            return new Result(ResultCode.SUCCESS,treatment);
        }
        return new Result(ResultCode.FAIL);
    }

    @Override
    public void modifyTreatment(Treatment treatment) {
        if(treatment != null){
            treatmentMapper.updateByPrimaryKeySelective(treatment);
        }
    }

    @Override
    public List<Treatment> findTreatment(String findName, int page) {
        PageHelper.startPage(page,10);
        List<Treatment> treatmentList = treatmentMapper.findTreatment(findName);
        System.out.println(treatmentList);
        return treatmentList;
    }

    @Override
    public Result findTreatmentByWord(String search_word) {
        if(search_word != null && !search_word.equals("")){
            List<Treatment> treatmentList = treatmentMapper.findTreatmentByWord(search_word);
            List<String> list = new ArrayList<String>();
            for (Treatment aTreatmentList : treatmentList) {
                list.add(aTreatmentList.getTreatment_name());
            }
            return new Result(ResultCode.SUCCESS,list);
        }
        return new Result(ResultCode.FAIL);
    }
}
