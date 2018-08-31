package org.wlgzs.hospitalmanage.service.serviceImpl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.wlgzs.hospitalmanage.dao.TreatmentMapper;
import org.wlgzs.hospitalmanage.entity.Check;
import org.wlgzs.hospitalmanage.entity.Treatment;
import org.wlgzs.hospitalmanage.service.TreatmentService;
import org.wlgzs.hospitalmanage.util.IdsUtil;
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

    //新增
    @Override
    public Result addTreatment(Treatment treatment) {
        if(treatment != null){
            treatmentMapper.insert(treatment);
            return new Result(ResultCode.SUCCESS);
        }
        return new Result(ResultCode.FAIL);
    }

    //查找全部分页
    @Override
    public List<Treatment> selectAll(int page,Model model) {
        Page page2 = PageHelper.startPage(page, 8, true);
        List<Treatment> list = treatmentMapper.selectAll();
        System.out.println(page2);
        System.out.println(page2.getPages());
        System.out.println(page);
        model.addAttribute("TotalPages",page2.getPages() );//查询的总页数
        model.addAttribute("Number", page);//查询的当前第几页
        return list;
    }

    //按id删除
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

    //按id查询
    @Override
    public Result findTreatmentById(int treatmentId) {
        Treatment treatment = treatmentMapper.selectByPrimaryKey(treatmentId);
        if(treatment != null){
            return new Result(ResultCode.SUCCESS,treatment);
        }
        return new Result(ResultCode.FAIL);
    }

    //修改
    @Override
    public Result modifyTreatment(Treatment treatment) {
        if(treatment != null){
            treatmentMapper.updateByPrimaryKeySelective(treatment);
            return new Result(ResultCode.SUCCESS);
        }
        return new Result(ResultCode.FAIL);
    }

    //搜索治疗
    @Override
    public List<Treatment> findTreatment(String findName, int page,Model model) {
        Page page2 = PageHelper.startPage(page, 8, true);
        List<Treatment> treatmentList = treatmentMapper.findTreatment(findName);
        System.out.println(page2);
        System.out.println(page2.getPages());
        System.out.println(page);
        model.addAttribute("TotalPages",page2.getPages() );//查询的总页数
        model.addAttribute("Number", page);//查询的当前第几页
        System.out.println(treatmentList);
        return treatmentList;
    }

    //搜索提示
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

    //批量删除
    @Override
    public Result deleteTreatmentByIds(String treatmentIds) {
        IdsUtil idsUtil = new IdsUtil();
        int[] Ids = idsUtil.IdsUtils(treatmentIds);
        treatmentMapper.deleteTreatmentByIds(Ids);
        return new Result(ResultCode.SUCCESS);
    }

}
