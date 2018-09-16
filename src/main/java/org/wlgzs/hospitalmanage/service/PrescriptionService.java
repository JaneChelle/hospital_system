package org.wlgzs.hospitalmanage.service;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
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
    Result addPrescription(Prescription prescription,HttpSession session);

    //查找全部分页
    List<Prescription> selectAll(int page,Model model);

    //按id删除
    Result deletePrescription(int prescriptionId);

    //按id查询
    Prescription findPrescriptionById(int prescriptionId);

    //修改
    Result modifyPrescription(Prescription prescription);

    //添加药品明细
    Result addDrug(PrescriptionDrug prescriptionDrug, HttpSession session,String isModify);

    //搜索已添加的处方药品
    List<PrescriptionDrug> queryPrescriptionDrug(HttpSession session);

    //删除已添加的处方药品
    Result deleteDrug(int detailId);

    //修改已添加的处方药品（数量）
    Result modifyPrescriptionDrug(int detail_id,String number);

    //搜索已添加的处方药品
    List<PrescriptionDrug> queryPrescriptionDrug(int prescriptionId);

    //添加检查明细
    Result addCheck(PrescriptionCheck prescriptionCheck, HttpSession session,String isModify);

    //搜索已添加的处方检查
    List<PrescriptionCheck> queryPrescriptionCheck(HttpSession session);

    //搜索已添加的处方检查
    List<PrescriptionCheck> queryPrescriptionCheck(int prescriptionId);

    //删除已添加的处方检查
    Result deleteCheck(int detailId);

    //修改已添加的处方检查（数量）
    Result modifyPrescriptionCheck(int detail_id, String number);

    //添加治疗明细
    Result addTreatment(PrescriptionTreatment prescriptionTreatment, HttpSession session,String isModify);

    //搜索已添加的处方治疗
    List<PrescriptionTreatment> queryPrescriptionTreatment(HttpSession session);

    //搜索已添加的处方治疗
    List<PrescriptionTreatment> queryPrescriptionTreatment(int prescriptionId);

    //删除已添加的处方治疗
    Result deleteTreatment(int detailId);

    //修改已添加的处方治疗（数量）
    Result modifyPrescriptionTreatment(int detail_id, String number);

    //计算总价格
    void totalPrice(int prescription_id);

    //搜索处方
    List<Prescription> findPrescription(String findName,int page,Model model);

    //搜索提示
    Result findPrescriptionByWord(String search_word);

    //选择处方
    Result choicePrescription(int prescription_id,HttpSession session);

    //搜索药品是否被使用
    Result TakeUpDrug(int drug_code);

    //搜索检查是否被使用
    Result TakeUpCheck(int check_id);

    //搜索治疗是否被使用
    Result TakeUpTreatment(int treatment_id);

    //查看某个处方是否存在
    Result checkPrescription(String prescription_name);
}
