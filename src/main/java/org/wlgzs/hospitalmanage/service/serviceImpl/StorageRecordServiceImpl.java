package org.wlgzs.hospitalmanage.service.serviceImpl;

import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.wlgzs.hospitalmanage.dao.StorageRecordMapper;
import org.wlgzs.hospitalmanage.entity.StorageRecord;
import org.wlgzs.hospitalmanage.service.StorageRecordService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 武凯焱
 * @date 2018/8/19 11:10
 */
@Service
public class StorageRecordServiceImpl implements StorageRecordService {
    @Resource
    StorageRecordMapper storageRecordMapper;
    public void record(StorageRecord storageRecord){   //对入库进行记录
        System.out.println(storageRecord);
        storageRecordMapper.insert(storageRecord);

    }
    //查询所有入库记录
    public List<StorageRecord> getStorageRecord(Model model,int page){
        PageHelper.startPage(page,8);
        List<StorageRecord> storageRecordList = storageRecordMapper.getAll();
        int count = storageRecordMapper.getcount();
        model.addAttribute("TotalPages",(int)(Math.ceil(count/8.0)));
        model.addAttribute("Number",page);
        return storageRecordList;
    }
    //删除入库记录
    public void deleteStorage(int storageId){
        storageRecordMapper.deleteInventory(storageId);
    }
    //批量删除库存记录
    public void deleteStorages(int[] storageIds){
        for (int i=0;i<storageIds.length;i++){
            deleteStorage(storageIds[i]);
        }
    }
    //搜索库存记录
    public List<StorageRecord> searchStorageRecord(Model model,int page,String drug_name){
        PageHelper.startPage(page, 8);
        List<StorageRecord> storageRecordList = storageRecordMapper.search(drug_name);
        int count = storageRecordMapper.getcountByDrugName(drug_name);
        model.addAttribute("TotalPages",(int)(Math.ceil(count/8.0)));
        model.addAttribute("Number",page);
        return storageRecordList;
    }

    //搜索库存记录下拉框
    public List<StorageRecord> keyword(String drug_name){
        return storageRecordMapper.keyword(drug_name);
    }

    public StorageRecord recordLink( int recordId){
        System.out.println("cfdf"+recordId);
        StorageRecord storageRecord = storageRecordMapper.selectStorage(recordId);
        return storageRecord;
    }
}
