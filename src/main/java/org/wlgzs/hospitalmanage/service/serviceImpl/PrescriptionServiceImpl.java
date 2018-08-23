package org.wlgzs.hospitalmanage.service.serviceImpl;

import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.wlgzs.hospitalmanage.dao.*;
import org.wlgzs.hospitalmanage.entity.*;
import org.wlgzs.hospitalmanage.service.PrescriptionService;
import org.wlgzs.hospitalmanage.util.Result;
import org.wlgzs.hospitalmanage.util.ResultCode;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.ArrayList;
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
    @Resource
    CheckMapper checkMapper;
    @Resource
    TreatmentMapper treatmentMapper;
    @Resource
    PrescriptionCheckMapper prescriptionCheckMapper;
    @Resource
    PrescriptionDrugMapper prescriptionDrugMapper;
    @Resource
    PrescriptionTreatmentMapper prescriptionTreatmentMapper;
    @Resource
    DrugMapper drugMapper;

    //新增处方
    @Override
    public Result addPrescription(Prescription prescription, HttpSession session) {
        System.out.println("21484645654");
        if (prescription != null) {
            prescriptionMapper.insert(prescription);
            String prescription_id = prescription.getPrescription_id() + "";
            session.setAttribute("prescription_id", prescription_id);
            return new Result(ResultCode.SUCCESS);
        }
        return new Result(ResultCode.FAIL);
    }

    //查找全部分页
    @Override
    public List<Prescription> selectAll(int page) {
        PageHelper.startPage(page, 10);
        List<Prescription> list = prescriptionMapper.selectAll();
        return list;
    }

    //按id删除
    @Override
    public Result deletePrescription(int prescriptionId) {
        System.out.println(prescriptionId);
        Prescription prescription = prescriptionMapper.selectByPrimaryKey(prescriptionId);
        System.out.println(prescription);
        if (prescription != null) {
            System.out.println("存在");
            prescriptionMapper.delete(prescription);
            return new Result(ResultCode.SUCCESS);
        }
        return new Result(ResultCode.FAIL);
    }

    //按id查询
    @Override
    public Prescription findPrescriptionById(int prescriptionId) {
        Prescription prescription = prescriptionMapper.selectByPrimaryKey(prescriptionId);
        return prescription;
    }

    //修改
    @Override
    public void modifyPrescription(Prescription prescription) {
        if (prescription != null) {
            prescriptionMapper.updateByPrimaryKeySelective(prescription);
        }
    }

    //添加药品明细
    @Override
    public Result addDrug(PrescriptionDrug prescriptionDrug, HttpSession session) {
        if (prescriptionDrug != null) {
            Drug drug = drugMapper.selectByPrimaryKey(prescriptionDrug.getDrug_code());
            BigDecimal bigDecimal2 = new BigDecimal(prescriptionDrug.getNumber());//数量
            BigDecimal bigDecimal1 = drug.getSafety_stock();//库存
            int a = bigDecimal1.compareTo(bigDecimal2);
            if (a != -1) {
                int prescription_id;
                if (session.getAttribute("prescription_id") != null) {
                    String prescriptionId = (String)session.getAttribute("prescription_id");
                    prescription_id = Integer.parseInt(prescriptionId);
                    System.out.println(prescription_id);
                    prescriptionDrug.setPrescription_id(prescription_id);
                    //修改处方表
                    Prescription prescription = prescriptionMapper.selectByPrimaryKey(prescription_id);
                    if (prescription.getIs_drug() == 0) {
                        prescription.setIs_drug(1);
                        prescriptionMapper.updateByPrimaryKey(prescription);
                    }
                } else {
                    return new Result(ResultCode.FAIL, "请选择一个处方!");
                }
            }else{
                return new Result(ResultCode.FAIL, "数量不应大于库存！");
            }
            //查询检查表，添加价格
            BigDecimal temp = new BigDecimal(prescriptionDrug.getNumber());
            BigDecimal bigDecimal = drug.getUnit_price().multiply(temp);
            prescriptionDrug.setPrice_one(bigDecimal);
            prescriptionDrug.setDrug_name(drug.getDrug_name());
            System.out.println("===============");
            prescriptionDrugMapper.insert(prescriptionDrug);
            System.out.println("-----------------");
        }
        return new Result(ResultCode.SUCCESS,"成功！");
    }

    //搜索已添加的处方药品
    @Override
    public List<PrescriptionDrug> queryPrescriptionDrug(HttpSession session) {
        List<PrescriptionDrug> prescriptionDrugList = null;
        int prescription_id;
        if (session.getAttribute("prescription_id") != null) {
            String prescriptionId = (String)session.getAttribute("prescription_id");
            prescription_id = Integer.parseInt(prescriptionId);
            prescriptionDrugList = prescriptionDrugMapper.findPrescriptionDrug(prescription_id);
        }
        return prescriptionDrugList;
    }

    //搜索已添加的处方药品
    @Override
    public List<PrescriptionDrug> queryPrescriptionDrug(int prescriptionId) {
        return prescriptionDrugMapper.findPrescriptionDrug(prescriptionId);
    }

    //添加检查明细
    @Override
    public Result addCheck(PrescriptionCheck prescriptionCheck, HttpSession session) {
        if (prescriptionCheck != null && session.getAttribute("prescription_id") != null) {
            Check check = checkMapper.selectByPrimaryKey(prescriptionCheck.getCheck_id());
            int prescription_id;
            String prescriptionId = (String)session.getAttribute("prescription_id");
            prescription_id = Integer.parseInt(prescriptionId);
            System.out.println(prescription_id);
            prescriptionCheck.setPrescription_id(prescription_id);
            //修改处方表
            Prescription prescription = prescriptionMapper.selectByPrimaryKey(prescription_id);
            if (prescription.getIs_check() == 0) {
                prescription.setIs_check(1);
                prescriptionMapper.updateByPrimaryKey(prescription);
            }
            //查询检查表，添加价格
            BigDecimal temp = new BigDecimal(prescriptionCheck.getNumber());
            BigDecimal bigDecimal = check.getCheck_price().multiply(temp);
            prescriptionCheck.setPrice_one(bigDecimal);
            prescriptionCheck.setCheck_name(check.getCheck_name());
            prescriptionCheckMapper.insert(prescriptionCheck);
            return new Result(ResultCode.SUCCESS);
        } else {
            return new Result(ResultCode.FAIL);
        }
    }

    //搜索已添加的处方检查
    @Override
    public List<PrescriptionCheck> queryPrescriptionCheck(HttpSession session) {
        List<PrescriptionCheck> prescriptionCheckList = null;
        int prescription_id;
        if (session.getAttribute("prescription_id") != null) {
            String prescriptionId = (String)session.getAttribute("prescription_id");
            prescription_id = Integer.parseInt(prescriptionId);
            prescriptionCheckList = prescriptionCheckMapper.findPrescriptionCheck(prescription_id);
        }
        return prescriptionCheckList;
    }

    //搜索已添加的处方检查
    @Override
    public List<PrescriptionCheck> queryPrescriptionCheck(int prescriptionId) {
        return prescriptionCheckMapper.findPrescriptionCheck(prescriptionId);
    }

    //添加治疗明细
    @Override
    public Result addTreatment(PrescriptionTreatment prescriptionTreatment, HttpSession session) {
        if (prescriptionTreatment != null && session.getAttribute("prescription_id") != null) {
            Treatment treatment = treatmentMapper.selectByPrimaryKey(prescriptionTreatment.getTreatment_id());
            int prescription_id;
            String prescriptionId = (String)session.getAttribute("prescription_id");
            prescription_id = Integer.parseInt(prescriptionId);
            System.out.println(prescription_id);
            prescriptionTreatment.setPrescription_id(prescription_id);
            //修改处方表
            Prescription prescription = prescriptionMapper.selectByPrimaryKey(prescription_id);
            if (prescription.getIs_treatment() == 0) {
                prescription.setIs_treatment(1);
                prescriptionMapper.updateByPrimaryKey(prescription);
            }
            //查询检查表，添加价格
            BigDecimal temp = new BigDecimal(prescriptionTreatment.getNumber());
            BigDecimal bigDecimal = treatment.getTreatment_price().multiply(temp);
            prescriptionTreatment.setPrice_one(bigDecimal);
            prescriptionTreatment.setTreatment_name(treatment.getTreatment_name());
            prescriptionTreatmentMapper.insert(prescriptionTreatment);
            return new Result(ResultCode.SUCCESS);
        } else {
            return new Result(ResultCode.FAIL);
        }
    }

    //搜索已添加的处方治疗
    @Override
    public List<PrescriptionTreatment> queryPrescriptionTreatment(HttpSession session) {
        List<PrescriptionTreatment> prescriptionTreatmentList = null;
        int prescription_id;
        if (session.getAttribute("prescription_id") != null) {
            String prescriptionId = (String)session.getAttribute("prescription_id");
            prescription_id = Integer.parseInt(prescriptionId);
            prescriptionTreatmentList = prescriptionTreatmentMapper.findPrescriptionTreatment(prescription_id);
        }
        return prescriptionTreatmentList;
    }

    //搜索已添加的处方治疗
    @Override
    public List<PrescriptionTreatment> queryPrescriptionTreatment(int prescriptionId) {
        return prescriptionTreatmentMapper.findPrescriptionTreatment(prescriptionId);
    }

    //计算总价格
    @Override
    public void totalPrice(HttpSession session) {
        int prescription_id;
        if (session.getAttribute("prescription_id") != null) {
            String prescriptionId = (String)session.getAttribute("prescription_id");
            prescription_id = Integer.parseInt(prescriptionId);
            System.out.println("prescription_id:" + prescription_id);
            Prescription prescription = prescriptionMapper.selectByPrimaryKey(prescription_id);

            BigDecimal priceDrug = BigDecimal.ZERO;
            List<PrescriptionDrug> prescriptionDrugList = prescriptionDrugMapper.findPrescriptionDrug(prescription_id);
            for (int i = 0; i < prescriptionDrugList.size(); i++) {
                priceDrug = priceDrug.add(prescriptionDrugList.get(i).getPrice_one());
                System.out.println(prescriptionDrugList.get(i).getPrice_one());
                System.out.println("priceDrug:" + priceDrug);
            }

            BigDecimal priceCheck = BigDecimal.ZERO;
            List<PrescriptionCheck> prescriptionCheckList = prescriptionCheckMapper.findPrescriptionCheck(prescription_id);
            for (int i = 0; i < prescriptionCheckList.size(); i++) {
                priceCheck = priceCheck.add(prescriptionCheckList.get(i).getPrice_one());
                System.out.println(prescriptionCheckList.get(i).getPrice_one());
                System.out.println("priceCheck:" + priceCheck);
            }

            BigDecimal priceTreatment = BigDecimal.ZERO;
            List<PrescriptionTreatment> prescriptionTreatmentList = prescriptionTreatmentMapper.findPrescriptionTreatment(prescription_id);
            for (int i = 0; i < prescriptionTreatmentList.size(); i++) {

                priceTreatment = priceTreatment.add(prescriptionTreatmentList.get(i).getPrice_one());
            }
            System.out.println("priceDrug:" + priceDrug);

            System.out.println("priceTreatment:" + priceTreatment);

            BigDecimal priceAll = priceDrug.add(priceCheck).add(priceTreatment);
            prescription.setPrice_all(priceAll);
            System.out.println("priceAll:" + priceAll);
            prescriptionMapper.updateByPrimaryKey(prescription);
        }
    }

    //搜索处方
    @Override
    public List<Prescription> findPrescription(String findName, int page) {
        PageHelper.startPage(page, 10);
        List<Prescription> list = prescriptionMapper.findPrescription(findName);
        System.out.println(list);
        if (list != null) {
            return list;
        }
        return null;
    }

    //搜索提示
    @Override
    public Result findPrescriptionByWord(String search_word) {
        if (search_word != null && !search_word.equals("")) {
            List<Prescription> prescriptionList = prescriptionMapper.findPrescriptionByWord(search_word);
            List<String> list = new ArrayList<String>();
            for (Prescription aPrescriptionList : prescriptionList) {
                list.add(aPrescriptionList.getPrescription_name());
            }
            return new Result(ResultCode.SUCCESS, list);
        }
        return new Result(ResultCode.FAIL);
    }

}
