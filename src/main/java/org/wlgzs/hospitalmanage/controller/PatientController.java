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
public class PatientController extends BaseController {
    //查看所有患者
    @GetMapping("/patient/{page}")
    public ModelAndView getPatients(Model model, @PathVariable("page") int page) {
        List<Patient> patients = patientService.getPatients(page);
        model.addAttribute("patients",patients);
        return new ModelAndView();

    }
    //添加患者
    @PostMapping("/patient")
    public Result addPatient(Model model, Patient patient,HttpSession session){
        patientService.savePatient(patient,session);
        return new Result(ResultCode.SUCCESS, "添加成功");
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
    public Result updatePatient(Patient patient, @RequestParam("patientName") String patientName) {
        patientService.updatePatient(patient);
        return new Result(ResultCode.SUCCESS, "更改成功");
    }

    //搜索患者下拉框提示
    @PostMapping("/keyword")
    public Result keyword(@RequestParam("patientAttribute") String patientAttribute) {
        return new Result(ResultCode.SUCCESS, patientService.keyWordsearchPatient(patientAttribute));
    }
    //搜索患者
    @PostMapping("/searchpatient/{page}")
    public ModelAndView searchPatient(Model model,@RequestParam("page") int page, @RequestParam("patientAttribute") String patientAttribute) {
        model.addAttribute("patients",patientService.searchPatient(model,patientAttribute,page));
        return new ModelAndView();
    }
}