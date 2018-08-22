package org.wlgzs.hospitalmanage.service;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.wlgzs.hospitalmanage.entity.DrugAttribute;

import java.util.List;

/**
 * @author 武凯焱
 * @date 2018/8/16 10:50
 */
public interface DrugAttributeService {
    List<DrugAttribute> getAttributes( int distinction,int page );
    boolean addAttribute(DrugAttribute drugAttribute);
    boolean deleteAttribute(int drugAttributeId);
    void updateAttribute(DrugAttribute drugAttribute);
    List<DrugAttribute> getAttribute(int distinction);
    List<DrugAttribute> searchAttribute(Model model, String attributeName , int page);
    List<DrugAttribute> keyword(String attributeName);
    DrugAttribute  getDrugAttribute(int AttributeId);


}
