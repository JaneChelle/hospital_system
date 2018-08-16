package org.wlgzs.hospitalmanage.service.serviceImpl;

import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.wlgzs.hospitalmanage.dao.DrugAttributeMapper;
import org.wlgzs.hospitalmanage.entity.DrugAttribute;
import org.wlgzs.hospitalmanage.service.DrugAttributeService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 武凯焱
 * @date 2018/8/16 10:51
 */
@Service
public class DrugAttributeServiceImpl implements DrugAttributeService {
    @Resource
    DrugAttributeMapper drugAttributeMapper;
   public List<DrugAttribute> getAttributes( int distinction,int page ){
       PageHelper.startPage(page, 10);
       List<DrugAttribute> drugAttributes = drugAttributeMapper.getAttribute(distinction);
       return drugAttributes;
   }
   public boolean addAttribute(DrugAttribute drugAttribute){
       return false;
   }
   }