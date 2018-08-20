package org.wlgzs.hospitalmanage.util;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import java.util.List;

/**
 * @author 武凯焱
 * @date 2018/8/19 15:08
 */
@Component
@Data
@ConfigurationProperties(prefix = "my")
@PropertySource("classpath:my.properties")//这是属性文件路径
public class UserProperties {
    private List<Integer> operatorCodes;
    private List<String> userNames;
    private List<String> userAccounts;
    private List<String> userPasswords;
    private String userName;
    private String userAccount;
    private String userPassword;

}
