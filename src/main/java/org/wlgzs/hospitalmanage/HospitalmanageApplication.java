package org.wlgzs.hospitalmanage;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@MapperScan(basePackages= {"org.wlgzs.hospitalmanage.dao"})
public class HospitalmanageApplication {

    public static void main(String[] args) {
        SpringApplication.run(HospitalmanageApplication.class, args);
    }
}
