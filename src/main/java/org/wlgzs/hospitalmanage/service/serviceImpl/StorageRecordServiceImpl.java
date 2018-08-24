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
        PageHelper.startPage(page,10);
        List<StorageRecord> storageRecordList = storageRecordMapper.getAll();
        int count = storageRecordMapper.getcount();
        model.addAttribute("pages",Math.ceil(count/10.0));
        model.addAttribute("page",page);
        return storageRecordList;
    }
    //删除入库记录
    public void deleteStorage(int storageId){
        storageRecordMapper.deleteByPrimaryKey(storageId);
    }
    //批量删除库存记录
    public void deleteStorages(int[] storageIds){
        for (int i=0;i<storageIds.length;i++){
            deleteStorage(storageIds[i]);
        }
    }
    //搜索库存记录
    public List<StorageRecord> searchStorageRecord(String drug_name){
        return storageRecordMapper.search(drug_name);
    }
    //搜索库存记录下拉框
    public List<StorageRecord> keyword(String drug_name){
        return storageRecordMapper.keyword(drug_name);
    }
}
