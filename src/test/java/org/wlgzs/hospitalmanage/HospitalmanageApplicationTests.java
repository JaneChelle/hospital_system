package org.wlgzs.hospitalmanage;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.wlgzs.hospitalmanage.dao.DiseaseMapper;
import org.wlgzs.hospitalmanage.entity.Disease;
import org.wlgzs.hospitalmanage.service.serviceImpl.DiseaseServiceImpl;

import javax.annotation.Resource;
import javax.sound.midi.Soundbank;

import java.sql.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HospitalmanageApplicationTests {

    @Resource
    private DiseaseMapper diseaseMapper;

    @Autowired
    private DiseaseServiceImpl diseaseService;

    @Test
    public void contextLoads() {
//        String  name = "发烧";
//        int id = 7;
//        Disease disease = diseaseService.findById(id);
//        System.out.println(disease+"12634566");

        System.out.println(new Date(123));

    }

    @Test
    public void test () {

        List<Disease> list = diseaseMapper.find();
        list.forEach(System.out::println);

        System.out.println("--"+
                diseaseMapper.findById(7)
        );
    }
}
