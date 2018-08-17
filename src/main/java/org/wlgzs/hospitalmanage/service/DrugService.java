package org.wlgzs.hospitalmanage.service;

import org.springframework.web.bind.annotation.RequestParam;
import org.wlgzs.hospitalmanage.entity.Drug;

import java.util.List;

/**
 * @author 武凯焱
 * @date 2018/8/14 21:25
 */
public interface DrugService {
    List<Drug> getDrugs(int page);
    boolean addDrug(Drug drug);
    void updateDrug(Drug drug);
    void deleteDrug(int drugCode);
    List<Drug> keyword(@RequestParam("drugName") String drugName);
    List searchDrug(@RequestParam("drugName") String drugName);
}
