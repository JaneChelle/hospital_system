package org.wlgzs.hospitalmanage.service;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.wlgzs.hospitalmanage.entity.DrugInventory;
import org.wlgzs.hospitalmanage.util.Result;

import java.util.List;

/**
 * @author 武凯焱
 * @date 2018/8/19 11:14
 */
public interface DrugInventoryService {
    Result addDrugInventory(DrugInventory drugInventory, String dateStr);

    void deleteDrugInventory(@RequestParam("drugInventory") int drugInventory);

    boolean updateDrugInventory(DrugInventory drugInventory);

    List<DrugInventory> getDrugInventory(Model model, int page);

    List<DrugInventory> getMonthLimit();

    List<DrugInventory> getUnsafetyStock(Model model, int page);

    void updateDrugInventory(DrugInventory drugInventory, String dateStr);

    List<DrugInventory>  searchStorage(Model model, String drugName,int page);

    List<DrugInventory> searchStorageDate(Model model,String drugName,int page);

    List<DrugInventory> keyword(String drugName);

    boolean reduceInventories(int drugCode, String num);

    List<DrugInventory> getDrugInventoryDate(Model model,int page);

    void deleteDrugInventories(int[] drugInventories);

     List<DrugInventory> keywordDate(String drugName);

     DrugInventory storageLink(int storageId);


}
