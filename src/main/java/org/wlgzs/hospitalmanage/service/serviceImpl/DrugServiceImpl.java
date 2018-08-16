package org.wlgzs.hospitalmanage.service.serviceImpl;

import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.wlgzs.hospitalmanage.dao.DrugMapper;
import org.wlgzs.hospitalmanage.entity.Drug;
import org.wlgzs.hospitalmanage.service.DrugService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 武凯焱
 * @date 2018/8/14 21:27
 */
@Service
public class DrugServiceImpl implements DrugService {
    @Resource
    DrugMapper drugMapper;
   public List<Drug> getDrugs(int page){
       PageHelper.startPage(page, 10);
       List<Drug> drugList  = drugMapper.selectAll();
       return drugList;
    }
   public boolean addDrug(Drug drug){
    Drug isDrug=drugMapper.jundgeName(drug.getDrug_name());
    if (isDrug==null){
        drugMapper.insert(drug);
        return true;
    }
    else {
        return false;
    }
   }
   public void updateDrug(Drug drug){
       drugMapper.updateDrug(drug);
   }
   public void deleteDrug(int drugCode){
       drugMapper.deleteByPrimaryKey(drugCode);
   }
   public List<Drug> keyword(@RequestParam("drugName") String drugName, @RequestParam("identify") int identify){
            if(identify==1){
                List<Drug> drugList = drugMapper.keyWordName(drugName);
                return drugList;
            }else {
                return null;
            }
   }
   public List searchDrug(@RequestParam("drugName") String drugName,@RequestParam("identify") int identify){
       List<Drug> drugList = new ArrayList<>();
       if (identify==1){
          drugList = drugMapper.searchName(drugName);
           return drugList;
       }
       else if (identify==2){
          drugList = drugMapper.searchDrugCode(drugName);
           return drugList;
       }else {
           return null;
       }
   }

}