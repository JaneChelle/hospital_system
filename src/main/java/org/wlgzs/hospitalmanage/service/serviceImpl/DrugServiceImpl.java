package org.wlgzs.hospitalmanage.service.serviceImpl;

import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.wlgzs.hospitalmanage.dao.DrugAttributeMapper;
import org.wlgzs.hospitalmanage.dao.DrugInventoryMapper;
import org.wlgzs.hospitalmanage.dao.DrugMapper;
import org.wlgzs.hospitalmanage.dao.StorageRecordMapper;
import org.wlgzs.hospitalmanage.entity.Drug;
import org.wlgzs.hospitalmanage.entity.DrugAttribute;
import org.wlgzs.hospitalmanage.entity.DrugInventory;
import org.wlgzs.hospitalmanage.entity.StorageRecord;
import org.wlgzs.hospitalmanage.service.DrugService;

import javax.annotation.Resource;
import javax.jws.WebParam;
import javax.servlet.http.HttpSession;
import javax.sound.midi.Soundbank;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author 武凯焱
 * @date 2018/8/14 21:27
 */
@Service
public class DrugServiceImpl implements DrugService {
    @Resource
    DrugMapper drugMapper;
    @Resource
    HttpSession session;
    @Resource
    DrugAttributeMapper drugAttributeMapper;
    @Resource
    DrugInventoryMapper drugInventoryMapper;
   public List<Drug> getDrugs(Model model,int page){
       PageHelper.startPage(page, 10);
       int count = drugMapper.getcount();
       int pages = (int) Math.ceil(count/10.0);
       model.addAttribute("page",page);
       model.addAttribute("pages",pages);
       List<Drug> drugList  = drugMapper.selectAll();
       return drugList;
    }
   public boolean addDrug(Drug drug){                 //添加药品
    Drug isDrug=drugMapper.jundgeName(drug.getDrug_name());
    if (isDrug==null){
        drugMapper.insert(drug);
        Drug currentDrug = drugMapper.jundgeName(drug.getDrug_name());
        int drug_code  = currentDrug.getDrug_code();
        DrugInventory drugInventory = new DrugInventory(drug_code,currentDrug.getDrug_name(),currentDrug.getPinyin_code(), new BigDecimal(0),null,0);
        drugInventoryMapper.insert(drugInventory);
        return true;
    }

    else {
        return false;
    }
   }
   public void updateDrug(Drug drug){
       Drug beforeDrug = drugMapper.selectByPrimaryKey(drug.getDrug_code());
       BigDecimal beforeAmount = beforeDrug.getSafety_stock();
       BigDecimal afterAmount = drug.getSafety_stock();
       if (beforeAmount.equals(afterAmount)) {
           drugMapper.updateDrug(drug);
       }else {
           DrugInventory drugInventory = drugInventoryMapper.increase(beforeDrug.getDrug_code());
           BigDecimal currentAmount = drugInventory.getStorage_amount();
           if (currentAmount.compareTo(afterAmount)<=0){
               drugInventory.setIs_safety_stock(0);
           }else {
               drugInventory.setIs_safety_stock(1);
           }
           drugInventoryMapper.update(drugInventory);
       }
   }
   public void deleteDrug(int drugCode){
       drugMapper.deleteByPrimaryKey(drugCode);
   }
   public List<Drug> keyword(@RequestParam("drugName") String drugName){
                List<Drug> drugList = drugMapper.keyWordName(drugName);
                return drugList;
   }
   public List searchDrug(Model model, @RequestParam("drugName") String drugName, int page){
       PageHelper.startPage(page,10);
       List<Drug> drugList = drugMapper.searchName(drugName);
       int count = drugMapper.getcount();
       model.addAttribute("pages",Math.ceil(count/10.0));
       model.addAttribute("page",page);
           return drugList;
   }
   public Drug toView(Model model, int drugId ) {
       Drug drug = drugMapper.selectByPrimaryKey(drugId);
       DrugAttribute categoryDrugAttribute = drugAttributeMapper.selectByPrimaryKey(drug.getDrug_category());
       DrugAttribute unitDrugAttribute = drugAttributeMapper.selectByPrimaryKey(drug.getDrug_unit());
       DrugAttribute dosageformDrugAttribute = drugAttributeMapper.selectByPrimaryKey(drug.getDosage_form());
       model.addAttribute("category",categoryDrugAttribute.getAttribute_name());
       model.addAttribute("unit",categoryDrugAttribute.getAttribute_name());
       model.addAttribute("dosageform",dosageformDrugAttribute.getAttribute_name());
       return drug;
   }
   //批量删除药物
   public void deleteDrugs(@RequestParam("drugCodes") int[] drugCodes ){
            for (int i=0;i<drugCodes.length;i++){
                drugMapper.deleteByPrimaryKey(drugCodes[i]);
            }
    }
}