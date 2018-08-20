package org.wlgzs.hospitalmanage.service;

import org.springframework.web.bind.annotation.RequestParam;
import org.wlgzs.hospitalmanage.entity.DrugInventory;
import org.wlgzs.hospitalmanage.util.Result;

/**
 * @author 武凯焱
 * @date 2018/8/19 11:14
 */
public interface DrugInventoryService {
    Result addDrugInventory(DrugInventory drugInventory);

    void deleteDrugInventory(@RequestParam("drugInventory") int drugInventory);

    boolean  updateDrugInventory(DrugInventory drugInventory);


}
