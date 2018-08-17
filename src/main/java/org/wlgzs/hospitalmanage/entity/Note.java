package org.wlgzs.hospitalmanage.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name = "tb_note")
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class Note implements Serializable {
    private static final long serialVersionUID = -1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "note_id")
    private Integer note_id;                //编号

    @Column(name = "patient_id")
    private Integer patient_id;             //患者编号

    @Column(name = "disease_id")
    private Integer disease_id;             //疾病编号

    @Column(name = "prescription_id")
    private Integer prescription_id;        //处方编号

    @Column(name = "price_end")
    private BigDecimal price_end;           //收费

    @Column(name = "note_time")
    private Date note_time;                 //就诊日期

    @Column(name = "patient_name")
    private String patient_name;            //患者名称

    @Column(name = "disease_name")
    private String disease_name;            //疾病名称

    public Note(Integer patient_id, Integer disease_id, Integer prescription_id, BigDecimal price_end, Date note_time, String patient_name, String disease_name) {
        this.patient_id = patient_id;
        this.disease_id = disease_id;
        this.prescription_id = prescription_id;
        this.price_end = price_end;
        this.note_time = note_time;
        this.patient_name = patient_name;
        this.disease_name = disease_name;
    }
}