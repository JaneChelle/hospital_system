package org.wlgzs.hospitalmanage.service;


import org.springframework.ui.Model;
import org.wlgzs.hospitalmanage.entity.StorageRecord;

import java.util.List;

/**
 * @author 武凯焱
 * @date 2018/8/19 11:10
 */

public interface StorageRecordService {
    void record(StorageRecord storageRecord);
    List<StorageRecord> getStorageRecord(Model model,int page);
    void deleteStorage(int storageId);
    void deleteStorages(int[] storageIds);
    List<StorageRecord> searchStorageRecord(String drug_name);
    List<StorageRecord> keyword(String drug_name);
    StorageRecord recordLink( int recordId);
}
