package org.wlgzs.hospitalmanage.service.serviceImpl;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
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

    public List<DrugAttribute> getAttributes(Model model,int distinction, int page) {
        PageHelper.startPage(page, 8);
        List<DrugAttribute> drugAttributes = drugAttributeMapper.getAttribute(distinction);
        int count = drugAttributeMapper.getAttributeCount(distinction);
        model.addAttribute("TotalPages",(int)(Math.ceil(count/8.0)));
        model.addAttribute("Number",page);
        return drugAttributes;
    }
    public List<DrugAttribute> getAttribute(int distinction) { //不分页查看全部
        List<DrugAttribute> drugAttributes = drugAttributeMapper.getAttribute(distinction);
        return drugAttributes;
    }
    public List<DrugAttribute> searchAttribute(Model model,int distinction, String attributeName , int page ){  //搜索属性名字
        PageHelper.startPage(page,8);
        List<DrugAttribute> drugAttributeList = drugAttributeMapper.searchAttribute(attributeName,distinction);
        int count = drugAttributeMapper.getAttributeCount(distinction);
        model.addAttribute("TotalPages",(int)(Math.ceil(count/8.0)));
        model.addAttribute("Number",page);;
        model.addAttribute("name",attributeName);
        return drugAttributeList;
    }
    public List<DrugAttribute> keyword(String attributeName){
        List<DrugAttribute> drugAttributes = drugAttributeMapper.keyword(attributeName);
        return drugAttributes;
    }
    public boolean addAttribute(DrugAttribute drugAttribute) {
        DrugAttribute attribute = drugAttributeMapper.findByname(drugAttribute.getAttribute_name(), drugAttribute.getAttribute_distinction());
        if (attribute == null) {
            drugAttributeMapper.insert(drugAttribute);
            return true;
        } else {
            return false;
        }
    }
    public boolean deleteAttribute(int drugAttributeId){
      try {
          drugAttributeMapper.deleteByPrimaryKey(drugAttributeId);
      }catch (Exception e){
          return false;
      }
      return true;
    }
    public DrugAttribute getDrugAttribute(int attributeId){
       DrugAttribute drugAttribute =  drugAttributeMapper.selectByPrimaryKey(attributeId);
       return drugAttribute;
    }

    public void updateAttribute(DrugAttribute drugAttribute){
        drugAttributeMapper.updateByPrimaryKey(drugAttribute);
    }
}
