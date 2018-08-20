package org.wlgzs.hospitalmanage.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.wlgzs.hospitalmanage.dao.DrugInventoryMapper;
import org.wlgzs.hospitalmanage.entity.DrugInventory;
import org.wlgzs.hospitalmanage.entity.StorageRecord;
import org.wlgzs.hospitalmanage.service.DrugInventoryService;
import org.wlgzs.hospitalmanage.service.StorageRecordService;
import org.wlgzs.hospitalmanage.util.Result;
import org.wlgzs.hospitalmanage.util.ResultCode;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author 武凯焱
 * @date 2018/8/19 11:14
 */
@Service
public class DrugInventoryServiceImpl implements DrugInventoryService {
    @Resource
    DrugInventoryMapper drugInventoryMapper;
    @Autowired
    HttpSession session;
    @Autowired
    StorageRecordService storageRecordService;

    //添加药品库存
    public Result addDrugInventory(DrugInventory drugInventory) {
        boolean isAdd;
        try {
            drugInventoryMapper.insert(drugInventory);
            isAdd = true;
        } catch (Exception e) {
            isAdd = false;
        }
        if (isAdd) {
            BigDecimal storageAmount = drugInventory.getStorage_amount();
            int drugCode = drugInventory.getDrug_code();
            Date validPeriodDate = drugInventory.getValid_period();
            Date currentDate = new Date();
            /*if (session.getAttribute("user") == null) {
                return new Result(ResultCode.FAIL, "请先登录");
            }*/
            int operator_code = (int) session.getAttribute("user");
            if (storageAmount.compareTo(new BigDecimal("0")) <= 0 && validPeriodDate == null) {
                return new Result(ResultCode.FAIL, "请将信息填写正确");
            }
            StorageRecord storageRecord = new StorageRecord(drugCode, operator_code, storageAmount.intValue(), currentDate, validPeriodDate);
            storageRecordService.record(storageRecord);
            DrugInventory currentDrugInventory = drugInventoryMapper.increase(drugCode);
            BigDecimal receipt = drugInventory.getStorage_amount();
            BigDecimal currentReceipt = currentDrugInventory.getStorage_amount().add(receipt);
            currentDrugInventory.setStorage_amount(currentReceipt);
            drugInventoryMapper.updateByPrimaryKey(currentDrugInventory);   //更新库存数量

            return new Result(ResultCode.SUCCESS, "添加成功");

        } else {
            return new Result(ResultCode.FAIL, "添加失败，药品编码错误");
        }
    }

    public void deleteDrugInventory(@RequestParam("drugInventory") int drugInventory) {
        drugInventoryMapper.deleteByPrimaryKey(drugInventory);
    }

    public boolean updateDrugInventory(DrugInventory drugInventory) {
        return true;
    }

    public boolean reduceInventories(int drugCode, String num) {
        BigDecimal drugAmount = new BigDecimal("num"); //处方要减数量
        DrugInventory drugInventory = drugInventoryMapper.increase(drugCode); //总库存量
        List<DrugInventory> drugInventories = drugInventoryMapper.reduceInventories(drugCode); //按有效期的分库存量
        if (drugInventory.getStorage_amount().compareTo(drugAmount) < 0) {
            return false;
        }
        drugInventory.setStorage_amount(drugInventory.getStorage_amount().subtract(drugAmount));
        drugInventoryMapper.updateByPrimaryKey(drugInventory); //将减过的总数库存对象存到数据库
        for (DrugInventory Inventory : drugInventories) {
            BigDecimal temp = Inventory.getStorage_amount();
            if (temp.compareTo(drugAmount) >= 0) {
                BigDecimal currentAmount = temp.subtract(drugAmount);
                Inventory.setStorage_amount(currentAmount);
                drugInventoryMapper.updateByPrimaryKey(Inventory);
                break;
            } else {
                drugAmount = drugAmount.subtract(temp);
                Inventory.setStorage_amount(new BigDecimal(0));
                drugInventoryMapper.updateByPrimaryKey(Inventory);
            }
        }
        return true;
    }
}
