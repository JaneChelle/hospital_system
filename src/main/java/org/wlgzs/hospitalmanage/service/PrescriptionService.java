package org.wlgzs.hospitalmanage.service;

import org.wlgzs.hospitalmanage.entity.Prescription;
import org.wlgzs.hospitalmanage.entity.PrescriptionCheck;
import org.wlgzs.hospitalmanage.entity.PrescriptionDrug;
import org.wlgzs.hospitalmanage.entity.PrescriptionTreatment;
import org.wlgzs.hospitalmanage.util.Result;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
    Prescription findPrescriptionById(int prescriptionId);

    //修改
    void modifyPrescription(Prescription prescription);

    //添加药品明细
    void addDrug(PrescriptionDrug prescriptionDrug, HttpServletRequest request);

    //搜索已添加的处方药品
    List<PrescriptionDrug> queryPrescriptionDrug(HttpSession session);

    //搜索已添加的处方药品
    List<PrescriptionDrug> queryPrescriptionDrug(int prescriptionId);

    //添加检查明细
    void addCheck(PrescriptionCheck prescriptionCheck, HttpSession session);

    //搜索已添加的处方检查
    List<PrescriptionCheck> queryPrescriptionCheck(HttpSession session);

    //搜索已添加的处方检查
    List<PrescriptionCheck> queryPrescriptionCheck(int prescriptionId);

    //添加治疗明细
    void addTreatment(PrescriptionTreatment prescriptionTreatment, HttpSession session);

    //搜索已添加的处方治疗
    List<PrescriptionTreatment> queryPrescriptionTreatment(HttpSession session);

    //搜索已添加的处方治疗
    List<PrescriptionTreatment> queryPrescriptionTreatment(int prescriptionId);

    //计算总价格
    void totalPrice(HttpSession session);

    //搜索处方
    List<Prescription> findPrescription(String findName,int page);

    //搜索提示
    Result findPrescriptionByWord(String search_word);
}
