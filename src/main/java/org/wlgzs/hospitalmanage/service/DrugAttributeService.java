package org.wlgzs.hospitalmanage.service;

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


}
