package org.wlgzs.hospitalmanage.service;

import org.wlgzs.hospitalmanage.entity.Prescription;
import org.wlgzs.hospitalmanage.entity.PrescriptionCheck;
import org.wlgzs.hospitalmanage.entity.PrescriptionTreatment;
import org.wlgzs.hospitalmanage.util.Result;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author:胡亚星
 * @createTime 2018-08-14 9:03
 * @description:
 **/
public interface PrescriptionService {

    //新增处方
    void addPrescription(Prescription prescription,HttpServletResponse response);

    //查找全部分页
    List<Prescription> selectAll(int page);

    //按id删除
    Result deletePrescription(int prescriptionId);

    //按id查询
    Result findPrescriptionById(int prescriptionId);

    //修改
    void modifyPrescription(Prescription prescription);

    //添加药品明细
//    Result addDrug

    //添加检查明细
    void addCheck(PrescriptionCheck prescriptionCheck, HttpServletRequest request);

    //搜索已添加的处方检查
    List<PrescriptionCheck> queryPrescriptionCheck(HttpServletRequest request);

    //添加检查明细
    void addTreatment(PrescriptionTreatment prescriptionTreatment, HttpServletRequest request);

    //搜索已添加的处方治疗
    List<PrescriptionTreatment> queryPrescriptionTreatment(HttpServletRequest request);

    //计算总价格
    void totalPrice(HttpServletRequest request);

    //搜索处方
    List<Prescription> findPrescription(String findName,int page);

}
