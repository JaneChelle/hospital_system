package org.wlgzs.hospitalmanage.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.wlgzs.hospitalmanage.base.BaseController;
import org.wlgzs.hospitalmanage.entity.Patient;
import org.wlgzs.hospitalmanage.util.Result;
import org.wlgzs.hospitalmanage.util.ResultCode;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author 武凯焱
 * @date 2018/8/13 9:56
 */
@RestController
@RequestMapping("patient")
public class PatientController extends BaseController{
    //查看所有患者
    @GetMapping("/patient/{page}")
    public ModelAndView getPatients(Model model,
                                    @PathVariable("page") int page,@RequestParam(value = "sign",defaultValue = "") String sign) {
        List<Patient> patients = patientService.getPatients(model,page);
        System.out.println(patients.get(0));
        model.addAttribute("patients",patients);
        model.addAttribute("sign",sign);
        model.addAttribute("isSearch",0);
        return new ModelAndView("patientManagement");
    }
    //添加患者
    @PostMapping("/patient")
    public Result addPatient(Model model, Patient patient){
       boolean isTrue = patientService.savePatient(patient,session);
       if(isTrue)
        return new Result(ResultCode.SUCCESS, "添加成功");
       else
           return new Result(ResultCode.FAIL,"添加失败");
    }
    //删除患者
    @DeleteMapping("/patient/{patientId}")
    public Result deletePatient(@PathVariable("patientId") int patientId) {
        if (patientService.deletePatient(patientId)) {
            return new Result(ResultCode.SUCCESS, "删除成功");
        } else {
            return new Result(ResultCode.FAIL, "该用户不存在");
        }
    }
    //批量删除患者
    @PostMapping("/deletePatients")
    public Result deletePatients(@RequestParam("patients") int[] patients){
        patientService.deletePatients(patients);
        return new Result(ResultCode.SUCCESS,"批量删除成功");
    }
    //修改患者消息
    @PutMapping("/patient")
    public Result updatePatient(Patient patient) {
        patientService.updatePatient(patient);
        return new Result(ResultCode.SUCCESS, "更改成功");
    }

    //搜索患者下拉框提示
    @PostMapping("/keyword")
    public Result keyword(@RequestParam("patientAttribute") String patientAttribute) {
        List<Patient> patients = patientService.keyWordsearchPatient(patientAttribute);
        if(patients.size() == 0){
            return new Result(ResultCode.FAIL);
        }
        return new Result(ResultCode.SUCCESS, patients);
    }
    //搜索患者下拉框提示(就诊页面)
    @PostMapping("/keywordPage")
    public Result keywordPage(@RequestParam("patientAttribute") String patientAttribute) {
        List<Patient> patients = patientService.keyWordsearchPatient(patientAttribute);
        if(patients.size() == 0){
            return new Result(ResultCode.FAIL);
        }
        return new Result(ResultCode.SUCCESS, patients);
    }
    //搜索患者
    @GetMapping("/searchpatient/{page}")
    public ModelAndView searchPatient(Model model,@PathVariable("page") int page, @RequestParam("patientAttribute") String patientAttribute) {
        model.addAttribute("patients",patientService.searchPatient(model,patientAttribute,page));
        System.out.println(patientService.searchPatient(model,patientAttribute,page));
        model.addAttribute("isSearch",1);
        model.addAttribute("patientAttribute",patientAttribute);
        return new ModelAndView("patientManagement");
    }

    //患者下拉框数据连接
    @GetMapping("/patientLink/{patientId}")
    public ModelAndView patinetLink(Model model,@PathVariable("patientId") int patientId){
        model.addAttribute("patients",patientService.patinetLink(patientId));
        return new ModelAndView("patientManagement");
    }


    //选择患者
    @RequestMapping("/choicePatient")
    public Result choicePatient(int patient_number,HttpSession session){
        return patientService.choicePatient(patient_number,session);
    }

    //查看某个患者是否存在
    @RequestMapping("/checkPatient")
    public Result checkPatient(String patient_name){
        return patientService.checkPatient(patient_name);
    }
    //查看某个患者是否同名
    @RequestMapping("/check")
    public Result check(String patient_name){
    boolean isTrue = patientService.check(patient_name);
    if (isTrue==true){
        return new Result(ResultCode.FAIL,"该患者与以往患者同名，请加以区别");
    }
        return new Result(ResultCode.SUCCESS);
    }
}