package org.wlgzs.hospitalmanage.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.mvc.method.annotation.ViewNameMethodReturnValueHandler;
import org.wlgzs.hospitalmanage.base.BaseController;
import org.wlgzs.hospitalmanage.entity.DrugAttribute;
import org.wlgzs.hospitalmanage.util.Result;
import org.wlgzs.hospitalmanage.util.ResultCode;

import java.lang.ref.SoftReference;
import java.util.List;

/**
 * @author 武凯焱
 * @date 2018/8/16 8:29
 */
@RestController
@RequestMapping("/attribute")
public class DrugAttributeController extends BaseController {
    //查询对应的药品属性的全部（ distinction=1药品类别  =2药品单位 =3药品剂型）
    @GetMapping("/attribute/{distinction}/{page}")
    public ModelAndView getAttributes(Model model, @PathVariable("distinction") int distinction, @PathVariable("page") int page) {
        model.addAttribute("attributes", drugAttributeService.getAttributes(model, distinction, page));
        model.addAttribute("isSearch", 0);
        if (distinction == 1) {
            return new ModelAndView("drugCategory");
        } else if (distinction == 2) {
            return new ModelAndView("drugUnit");
        } else {
            return new ModelAndView("drugDosageSorm");
        }
    }

    //添加药品属性（药品类别/药品单位/药品剂型）
    @PostMapping("/attribute")
    public Result addAttribute(DrugAttribute drugAttribute) {
        System.out.println(drugAttribute);
        boolean isAdd = drugAttributeService.addAttribute(drugAttribute);
        System.out.println(isAdd);
        if (isAdd) {
            return new Result(ResultCode.SUCCESS, "添加成功");
        } else {
            return new Result(ResultCode.FAIL, "名字重复，添加失败");
        }
    }

    //删除药品属性
    @DeleteMapping("/attribute/{attributeId}")
    public Result deleteAttribute(@PathVariable("attributeId") int attributeId) {
        boolean isDelelte = drugAttributeService.deleteAttribute(attributeId);
        System.out.println(isDelelte);
        if (isDelelte) {
            return new Result(ResultCode.SUCCESS, "删除成功");
        } else {
            System.out.println("fdfgdgfdg");
            return new Result(ResultCode.FAIL, "删除失败，有药品与此类型关联");
        }
    }

    //搜索药品属性
    @GetMapping("/searchAttribute/{distinction}/{page}")
    public ModelAndView searchAttribute(Model model, @PathVariable("page") int page, @PathVariable("distinction") int distinction, String attributeName) {
        List<DrugAttribute> drugAttributes = drugAttributeService.searchAttribute(model, distinction, attributeName, page);
        model.addAttribute("attributes", drugAttributes);
        model.addAttribute("isSearch", 1);
        System.out.println(drugAttributes);
        System.out.println(distinction);
        if (distinction == 1) {
            model.addAttribute("attributeName", attributeName);
            return new ModelAndView("drugCategory");
        } else if (distinction == 2) {
            model.addAttribute("attributeName", attributeName);
            return new ModelAndView("drugUnit");
        } else {
            System.out.println(attributeName + "--------");
            model.addAttribute("attributeName", attributeName);
            return new ModelAndView("drugDosageSorm");
        }
    }

    //搜索药品下拉框
    @PostMapping("/keyword")
    public Result keyword(String attributeName) {
        List<DrugAttribute> drugAttributes = drugAttributeService.keyword(attributeName);
        return new Result(ResultCode.SUCCESS, drugAttributes);
    }

    //更新药品属性
    @PutMapping("/attribute")
    public Result updateAttribute(DrugAttribute drugAttribute) {
        drugAttributeService.updateAttribute(drugAttribute);
        return new Result(ResultCode.SUCCESS, "更改成功");
    }

    //下拉框数据链接
    @RequestMapping("/drugAttributeView/{drugAttributeId}")
    public ModelAndView drugAttributeView(Model model, @PathVariable("drugAttributeId") int drugAttributeId) {
        DrugAttribute drugAttribute = drugAttributeService.getDrugAttribute(drugAttributeId);
        model.addAttribute("attributes", drugAttribute);
        return new ModelAndView("drugCategory");
    }
}
