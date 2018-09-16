package org.wlgzs.hospitalmanage.service.serviceImpl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.wlgzs.hospitalmanage.dao.DiseaseMapper;
import org.wlgzs.hospitalmanage.entity.Check;
import org.wlgzs.hospitalmanage.entity.Disease;
import org.wlgzs.hospitalmanage.service.DiseaseService;
import org.wlgzs.hospitalmanage.util.IdsUtil;
import org.wlgzs.hospitalmanage.util.Result;
import org.wlgzs.hospitalmanage.util.ResultCode;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
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

    //查询所有
    @Override
    public List<Disease> selectAll(int page,Model model) {
        Page page2 = PageHelper.startPage(page, 8, true);
        List<Disease> diseaseList = diseaseMapper.selectAll();
        System.out.println(page2);
        System.out.println(page2.getPages());
        System.out.println(page);
        model.addAttribute("TotalPages",page2.getPages() );//查询的总页数
        model.addAttribute("Number", page);//查询的当前第几页
        System.out.println(diseaseList);
        return diseaseList;
    }

    //搜索疾病
    @Override
    public List<Disease> findDisease(String findName,int page,Model model) {
        Page page2 = PageHelper.startPage(page, 8, true);
        List<Disease> diseaseList = diseaseMapper.findDisease(findName);
        System.out.println(page2);
        System.out.println(page2.getPages());
        System.out.println(page);
        model.addAttribute("TotalPages",page2.getPages() );//查询的总页数
        model.addAttribute("Number", page);//查询的当前第几页
        System.out.println(diseaseList);
        return diseaseList;
    }

    @Override
    public Result findDiseaseByWord(String search_word) {
        if(search_word != null && !search_word.equals("")){
            List<Disease> checkList = diseaseMapper.findDiseaseByWord(search_word);
            for(int i = 0;i < checkList.size();i++){
                System.out.println(checkList.get(i));
            }
            if(checkList.size() > 0){
                return new Result(ResultCode.SUCCESS,checkList);
            }
            return new Result(ResultCode.FAIL);
        }
        return new Result(ResultCode.FAIL);
    }

    //选择疾病存入session
    @Override
    public Result selectDisease(int disease_id, HttpSession session) {
        Disease disease = diseaseMapper.selectByPrimaryKey(disease_id);
        if(disease != null){
            session.setAttribute("disease",disease);
            return new Result(ResultCode.SUCCESS);
        }
        return new Result(ResultCode.FAIL);
    }

    @Override
    public Result deleteDiseaseByIds(String DiseaseIds) {
        IdsUtil idsUtil = new IdsUtil();
        int[] Ids = idsUtil.IdsUtils(DiseaseIds);
        diseaseMapper.deleteDiseaseByIds(Ids);
        return new Result(ResultCode.SUCCESS);
    }

    @Override
    public Result checkDisease(String disease_name) {
        Disease disease = diseaseMapper.findByName(disease_name);
        if (disease != null) {
            return new Result(ResultCode.SUCCESS, "存在！");
        } else {
            return new Result(ResultCode.FAIL, "不存在！");


        }
    }
//    public Disease findByName (String name) {
//        return diseaseMapper.findByName(name);
//    }
}
