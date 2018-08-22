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
public class StorageRecordController extends BaseController {
    //查看入库记录
    @GetMapping("/StorageRecord/{page}")
    public ModelAndView getStorageRecord(Model model, @RequestParam("page") int page){
      model.addAttribute("storageList",storageRecordService.getStorageRecord(model,page));
      return  new ModelAndView();
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
    
}
