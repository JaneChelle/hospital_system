package org.wlgzs.hospitalmanage.service.serviceImpl;

import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.wlgzs.hospitalmanage.dao.PrescriptionMapper;
import org.wlgzs.hospitalmanage.entity.Prescription;
import org.wlgzs.hospitalmanage.service.PrescriptionService;
import org.wlgzs.hospitalmanage.util.Result;
import org.wlgzs.hospitalmanage.util.ResultCode;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author:胡亚星
 * @createTime 2018-08-14 9:04
 * @description:
 **/
@Service
public class PrescriptionServiceImpl implements PrescriptionService {

    @Resource
    PrescriptionMapper prescriptionMapper;

    @Override
    public Result addPrescription(Prescription prescription,HttpServletResponse response) {
        if(prescription != null){
            prescriptionMapper.insert(prescription);
            String prescription_id = prescription.getPrescription_id()+"";
            Cookie cookie = new Cookie("prescription_id",prescription_id);
            System.out.println(cookie.getValue());
            cookie.setMaxAge(10 * 60);
            response.addCookie(cookie);
            return new Result(ResultCode.SUCCESS);
        }
        return new Result(ResultCode.FAIL);
    }

    @Override
    public List<Prescription> selectAll(int page) {
        PageHelper.startPage(page,10);
        List<Prescription> list = prescriptionMapper.selectAll();
        return list;
    }

    @Override
    public Result deletePrescription(int prescriptionId) {
        System.out.println(prescriptionId);
        Prescription prescription = prescriptionMapper.selectByPrimaryKey(prescriptionId);
        System.out.println(prescription);
        if(prescription != null){
            System.out.println("存在");
            prescriptionMapper.delete(prescription);
            return new Result(ResultCode.SUCCESS);
        }
        return new Result(ResultCode.FAIL);
    }

    @Override
    public Result findPrescriptionById(int prescriptionId) {
        Prescription prescription = prescriptionMapper.selectByPrimaryKey(prescriptionId);
        if(prescription != null){
            return new Result(ResultCode.SUCCESS,prescription);
        }
        return new Result(ResultCode.FAIL);
    }

    @Override
    public void modifyPrescription(Prescription prescription) {
        if(prescription != null){
            prescriptionMapper.updateByPrimaryKeySelective(prescription);
        }
    }
}
