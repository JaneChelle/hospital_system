package org.wlgzs.hospitalmanage.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.wlgzs.hospitalmanage.base.BaseController;
import org.wlgzs.hospitalmanage.util.Result;
import org.wlgzs.hospitalmanage.util.ResultCode;

/**
 * @author 武凯焱
 * @date 2018/8/19 11:03
 */
@RestController
@RequestMapping("/StorageRecord")
public class StorageRecordController extends BaseController {
    //查看入库记录
    @GetMapping("/StorageRecord/{page}")
    public ModelAndView getStorageRecord(Model model, @PathVariable("page") int page){
      model.addAttribute("storageList",storageRecordService.getStorageRecord(model,page));
        model.addAttribute("isSearch",0);
      return  new ModelAndView("drugStorageRecord");
    }
    //删除入库记录
    @DeleteMapping("/StorageRecord/{storageId}")
    public Result deleteStorage(@PathVariable("storageId") int storageId){
        storageRecordService.deleteStorage(storageId);
        return new Result(ResultCode.SUCCESS,"删除成功");
    }
    //批量删除入库记录
    @PostMapping("/StorageRecord")
    public Result  deleteStorage(@RequestParam("storageIds") int[] storageIds){
        storageRecordService.deleteStorages(storageIds);
        return new Result(ResultCode.SUCCESS,"批量删除成功");
    }
    //搜索库存记录
    @GetMapping("/searchStorageRecord/{page}")
    public ModelAndView searchStorageRecord(Model model,@PathVariable("page")int page,@RequestParam("drugName") String drugName){
            model.addAttribute("storageList",storageRecordService.searchStorageRecord(model,page,drugName));
            model.addAttribute("drugName",drugName);
            model.addAttribute("isSearch",1);
        return new ModelAndView("drugStorageRecord");
    }
    //搜索库存记录下拉框
    @PostMapping("/keyword")
    public Result keyword(@RequestParam("drugName") String drugName){
        System.out.println(storageRecordService.keyword(drugName));
        return new Result(ResultCode.SUCCESS,storageRecordService.keyword(drugName));
    }
    //数据下拉框链接
    @RequestMapping("/recordLink/{recordId}")
    public ModelAndView recordLink(Model model, @PathVariable("recordId") int recordId){
        System.out.println(storageRecordService.recordLink(recordId));
         model.addAttribute("storageList",storageRecordService.recordLink(recordId));
         return new ModelAndView("drugStorageRecord");
    }
}
