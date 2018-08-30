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
    @DeleteMapping("/DrugInventory/{drugInventoryId}")
    public Result deleteDrugInventory(@PathVariable("drugInventoryId") int drugInventoryId) {
        drugInventoryService.deleteDrugInventory(drugInventoryId);
        return new Result(ResultCode.SUCCESS, "删除成功");
    }
    //批量删除药品库存
    @PostMapping("/DrugInventorys")
    public Result deleteDrugInventorys(@RequestParam("drugInventorys") int[] drugInventorys){

        drugInventoryService.deleteDrugInventories(drugInventorys);
        return new Result(ResultCode.SUCCESS,"批量删除成功");
    }
    //更新药品库存

    @PutMapping("/DrugInventory")
    public Result updateDrugInventory(DrugInventory drugInventory,@RequestParam("date") String dateStr ){
        drugInventoryService.updateDrugInventory(drugInventory,dateStr);
        return new  Result(ResultCode.SUCCESS);
    }
    //查看药品库存(总库存量)
    @GetMapping("/DrugInventory/{page}")
    public ModelAndView getDrugInventory(Model model,@PathVariable("page") int page ){
      List<DrugInventory> drugInventories =  drugInventoryService.getDrugInventory(model,page);
      model.addAttribute("drugInventories",drugInventories);
        model.addAttribute("isSearch",0);
      return new ModelAndView("drugStorage");
    }
    //查看药品库存(按有效期)
    @GetMapping("/DrugInventoryDate/{page}")
    public ModelAndView getDrugInventoryDate(Model model,@PathVariable("page") int page){
          model.addAttribute("drugInventories",drugInventoryService.getDrugInventoryDate(model,page));
        model.addAttribute("isSearch",0);
          return new ModelAndView("storageStock");
    }
    //查看有效期一个月内的清单
    @RequestMapping("/getMonthLimit")
    public ModelAndView delgetMonthLimit(Model model){
        model.addAttribute("drugInventories",drugInventoryService.getMonthLimit());
        return new ModelAndView("aMonth");
    }
    //查看未达到安全库存的清单
    @RequestMapping("/getUnsafeStorage/{page}")
    public ModelAndView getUnsafeStorage(Model model,@PathVariable("page") int page){
        model.addAttribute("drugInventories",drugInventoryService.getUnsafetyStock(model,page));
        return new ModelAndView("Below");
    }
    //搜索库存下拉框
    @PostMapping("/keyword")
    public Result keyword(String drugName){
        List<DrugInventory> drugInventories = drugInventoryService.keyword(drugName);
        return new Result(ResultCode.SUCCESS,drugInventories);
    }
    //搜索库存下拉框（按有效期）
    @PostMapping("/keywordDate")
    public Result keywordDate(String drugName){
        List<DrugInventory> drugInventories = drugInventoryService.keywordDate(drugName);
        return new Result(ResultCode.SUCCESS,drugInventories);
    }

    //搜索总库存
    @GetMapping("/searchStorage/{page}")
    public ModelAndView searchStorage(Model model, @RequestParam("drugName") String drugName,@PathVariable("page") int page){
         model.addAttribute("drugInventories",drugInventoryService.searchStorage(model,drugName,page));
        model.addAttribute("isSearch",1);
        model.addAttribute("drugName",drugName);
         return new ModelAndView("drugStorage");
    }
    //搜索库存(按有效期)
    @GetMapping("/searchStorageDate/{page}")
    public ModelAndView searchStorageDate(Model model, @RequestParam("drugName") String drugName,@PathVariable("page") int page){
        model.addAttribute("isSearch",1);
        model.addAttribute("drugInventories",drugInventoryService.searchStorageDate(model,drugName,page));
        model.addAttribute("drugName",drugName);
        return new ModelAndView("storageStock");
    }
    @GetMapping("storageLink/{storageId}")
    //点击下拉框链接查看数据
    public ModelAndView storageLink(Model model, @PathVariable("storageId") int storageId){
        model.addAttribute("drugInventories",drugInventoryService.storageLink(storageId));
        return new ModelAndView("drugStorage");

    }

}