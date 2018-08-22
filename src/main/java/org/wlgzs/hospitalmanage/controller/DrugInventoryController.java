package org.wlgzs.hospitalmanage.controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.wlgzs.hospitalmanage.base.BaseController;
import org.wlgzs.hospitalmanage.entity.DrugInventory;
import org.wlgzs.hospitalmanage.util.Result;
import org.wlgzs.hospitalmanage.util.ResultCode;

import java.util.List;

/*
 * @author 武凯焱
 * @date 2018/8/19 11:02
 */
@RestController
@RequestMapping("/DrugInventory")
public class DrugInventoryController extends BaseController {
    //添加药品库存
    @PostMapping("/DrugInventory")
    public Result addDrugInventory(DrugInventory drugInventory ,@RequestParam("date") String dateStr) {
        Result result = drugInventoryService.addDrugInventory(drugInventory,dateStr);
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
    public Result updateDrugInventory(DrugInventory drugInventory,@RequestParam("date") String dateStr ){
        drugInventoryService.updateDrugInventory(drugInventory,dateStr);
        return new Result(ResultCode.SUCCESS);
    }
    //查看药品库存(总库存量)
    @GetMapping("/DrugInventory/{page}")
    public ModelAndView getDrugInventory(Model model,@PathVariable("page") int page ){
      List<DrugInventory> drugInventories =  drugInventoryService.getDrugInventory(page);
      model.addAttribute("drugInventories",drugInventories);
      return new ModelAndView();
    }
    //查看有效期一个月内的清单
    @GetMapping("/getMonthLimit")
    public ModelAndView getMonthLimit(Model model){
        model.addAttribute("drugInventories",drugInventoryService.getMonthLimit());
        return new ModelAndView();
    }
    //查看未达到安全库存的清单
    @GetMapping("/getUnsafeStorage/{page}")
    public ModelAndView getUnsafeStorage(Model model,@PathVariable("page") int page){
        model.addAttribute("drugInventories",drugInventoryService.getUnsafetyStock(model,page));
        return new ModelAndView();
    }
    //搜索库存下拉框
    @PostMapping
    public Result keyword(String drugName){
        List<DrugInventory> drugInventories = drugInventoryService.keyword(drugName);
        return new Result(ResultCode.SUCCESS,drugInventories);
    }
    //搜索库存
    @GetMapping("/searchStorage/{page}")
    public ModelAndView searchStorage(Model model, @RequestParam("drugName") String drugName,@PathVariable("page") int page){
         model.addAttribute("storages",drugInventoryService.searchStorage(model,drugName,page));
         return new ModelAndView();
    }
}