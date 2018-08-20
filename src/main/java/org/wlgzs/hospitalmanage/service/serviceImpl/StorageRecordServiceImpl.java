package org.wlgzs.hospitalmanage.service.serviceImpl;

import org.springframework.stereotype.Service;
import org.wlgzs.hospitalmanage.dao.StorageRecordMapper;
import org.wlgzs.hospitalmanage.entity.StorageRecord;
import org.wlgzs.hospitalmanage.service.StorageRecordService;

import javax.annotation.Resource;

/**
 * @author 武凯焱
 * @date 2018/8/19 11:10
 */
@Service
public class StorageRecordServiceImpl implements StorageRecordService {
    @Resource
    StorageRecordMapper storageRecordMapper;
    public void record(StorageRecord storageRecord){   //对入库进行记录
        storageRecordMapper.insert(storageRecord);

    }
}
