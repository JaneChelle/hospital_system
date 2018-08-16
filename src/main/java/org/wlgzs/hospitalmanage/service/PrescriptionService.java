package org.wlgzs.hospitalmanage.service;

import org.wlgzs.hospitalmanage.entity.Prescription;
import org.wlgzs.hospitalmanage.util.Result;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author:胡亚星
 * @createTime 2018-08-14 9:03
 * @description:
 **/
public interface PrescriptionService {

    //新增处方
    Result addPrescription(Prescription prescription,HttpServletResponse response);

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
}
