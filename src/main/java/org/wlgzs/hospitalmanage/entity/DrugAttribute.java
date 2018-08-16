package org.wlgzs.hospitalmanage.entity;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Data
@Entity
@Table(name = "tb_drug_attribute")
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class DrugAttribute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attribute_number")
    private Integer attribute_number;
    @Column(name = "attribute_name")
    private String attribute_name;
    @Column(name = "attribute_distinction")
    private Integer attribute_distinction;  //属性识别 1药品类别 2药品单位 3药品剂型
}