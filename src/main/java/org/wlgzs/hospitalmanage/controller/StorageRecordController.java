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
    public ModelAndView getStorageRecord(Model model, @RequestParam("page") int page){
      model.addAttribute("storageList",storageRecordService.getStorageRecord(model,page));
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
    @PostMapping("/searchStorageRecord")
    public ModelAndView searchStorageRecord(Model model,@RequestParam("drugName") String drugName){
            model.addAttribute("stroages",storageRecordService.searchStorageRecord(drugName));
        return new ModelAndView("");
    }
    //搜索库存记录下拉框
    @PostMapping("/keyword")
    public Result keyword(@RequestParam("drugName") String drugName){
        return new Result(ResultCode.SUCCESS,storageRecordService.keyword(drugName));
    }
    //数据下拉框链接
    @RequestMapping("/recordLink/{recordId}")
    public ModelAndView recordLink(Model model, @RequestParam("recordId") int recordId){
         model.addAttribute("storageList",storageRecordService.recordLink(recordId));
         return new ModelAndView();
    }
}
