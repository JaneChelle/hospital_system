package org.wlgzs.hospitalmanage.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.wlgzs.hospitalmanage.base.BaseController;
import org.wlgzs.hospitalmanage.entity.DrugAttribute;
import org.wlgzs.hospitalmanage.util.Result;
import org.wlgzs.hospitalmanage.util.ResultCode;

/**
 * @author 武凯焱
 * @date 2018/8/16 8:29
 */
@RestController
@RequestMapping("/attribute")
public class DrugAttributeController extends BaseController {
    @GetMapping("/attribute/{distinction}/{page}")
    public ModelAndView getAttributes(Model model,@PathVariable("distinction") int distinction,@PathVariable("page") int page ){
          model.addAttribute(drugAttributeService.getAttributes(distinction,page));
          return new ModelAndView();
    }
    @PostMapping("/attribute")
    public Result addAttribute(DrugAttribute drugAttribute){
       return new Result(ResultCode.SUCCESS);
    }


}
