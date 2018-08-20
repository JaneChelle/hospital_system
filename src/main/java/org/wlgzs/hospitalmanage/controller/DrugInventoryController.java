package org.wlgzs.hospitalmanage.controller;

import org.springframework.web.bind.annotation.*;
import org.wlgzs.hospitalmanage.base.BaseController;
import org.wlgzs.hospitalmanage.entity.DrugInventory;
import org.wlgzs.hospitalmanage.util.Result;
import org.wlgzs.hospitalmanage.util.ResultCode;

/**
 * @author 武凯焱
 * @date 2018/8/19 11:02
 */
@RestController
@RequestMapping("/DrugInventory")
public class DrugInventoryController extends BaseController {
    //添加药品库存
    @PostMapping("/DrugInventory")
    public Result addDrugInventory(DrugInventory drugInventory) {
        Result result = drugInventoryService.addDrugInventory(drugInventory);
        return result;
    }
    //删除药品库存
    @DeleteMapping("/DrugInventory")
    public Result deleteDrugInventory(@RequestParam("drugInventory") int drugInventory) {
        drugInventoryService.deleteDrugInventory(drugInventory);
        return new Result(ResultCode.SUCCESS, "删除成功");
    }
    //更新药品库存
    @PutMapping("/DrugInventory")
    public Result updateDrugInventory(DrugInventory drugInventory) {
        return new Result(ResultCode.SUCCESS);
    }
}
