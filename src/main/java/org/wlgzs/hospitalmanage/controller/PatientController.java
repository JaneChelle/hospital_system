package org.wlgzs.hospitalmanage.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.wlgzs.hospitalmanage.base.BaseController;
import org.wlgzs.hospitalmanage.entity.Patient;
import org.wlgzs.hospitalmanage.util.Result;
import org.wlgzs.hospitalmanage.util.ResultCode;

import java.util.List;


/**
 * @author 武凯焱
 * @date 2018/8/13 9:56
 */
@RestController
@RequestMapping("patient")
public class PatientController extends BaseController {

    @GetMapping("/patient/{page}")            //查看所有患者
    public Result getPatients(Model model, @PathVariable("page") int page) {
        List<Patient> patients =  patientService.getPatients(page);
        return new Result(ResultCode.SUCCESS,patients);

    }
    @PostMapping("/patient")           //添加患者
    public Result addPatient(Model model,Patient patient){
        System.out.println(patient);
        patientService.savePatient(patient);
        return new Result(ResultCode.SUCCESS,"添加成功");
    }
    @DeleteMapping("/patient/{patientId}")        //删除患者
    public Result deletePatient(@PathVariable("patientId") int patientId){
        if (patientService.deletePatient(patientId)){
            return new Result(ResultCode.SUCCESS,"删除成功");
        }else {
            return new Result(ResultCode.FAIL,"该用户不存在");
        }
    }

}
