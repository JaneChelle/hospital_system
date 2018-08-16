package org.wlgzs.hospitalmanage.dao;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.wlgzs.hospitalmanage.entity.Patient;
import tk.mybatis.mapper.common.Mapper;
import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface PatientMapper extends Mapper<Patient>{
    @Update("UPDATE tb_patient SET patient_name=#{patientName},pinyin_code=#{pinyinCode},patient_gender=#{patientGender}, patient_age=#{patientAge},patient_phone=#{patientPhone},home_address=#{homeAddress} WHERE patient_number=#{patientNumber}" )
    void update(Patient patient);
    @Select("SELECT * FROM tb_patient WHERE patient_phone LIKE CONCAT('%',#{0},'%') limit 8 ")
    List<Patient> phoneKeyWord(String patientPhone);
    @Select("SELECT * FROM tb_patient WHERE  patient_name LIKE CONCAT('%',#{0},'%') limit 8 ")
    List<Patient> nameKeyWord(String patientName);
    @Select("SELECT * FROM tb_patient WHERE  pinyin_code LIKE CONCAT('%',#{0},'%')")
    List<Patient> searchpinyinCode(String pinyinCode);
    @Select("SELECT * FROM tb_patient WHERE patient_phone LIKE CONCAT('%',#{0},'%')  ")
    List<Patient> searchPhone(String patientPhone);
    @Select("SELECT * FROM tb_patient WHERE  patient_name LIKE CONCAT('%',#{0},'%')  ")
    List<Patient> searchName(String patientName);
}