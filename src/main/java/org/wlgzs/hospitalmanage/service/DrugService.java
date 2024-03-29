package org.wlgzs.hospitalmanage.service;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.wlgzs.hospitalmanage.entity.Drug;

import java.util.List;

/**
 * @author 武凯焱
 * @date 2018/8/14 21:25
 */
public interface DrugService {
    List<Drug> getDrugs(Model model, int page);

    boolean addDrug(Drug drug);

    void updateDrug(Drug drug);

    void deleteDrug(int drugCode);

    List<Drug> keyword(@RequestParam("drugName") String drugName);

    List searchDrug(Model model, @RequestParam("drugName") String drugName, int page);

    Drug toView(Model model, int drugId);

    void deleteDrugs(@RequestParam("drugCodes") int[] drugCodes);

}
