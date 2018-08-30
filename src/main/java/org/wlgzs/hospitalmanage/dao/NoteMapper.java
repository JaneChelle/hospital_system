package org.wlgzs.hospitalmanage.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;
import org.wlgzs.hospitalmanage.entity.DrugNumber;
import org.wlgzs.hospitalmanage.entity.Note;
import org.wlgzs.hospitalmanage.entity.PrescriptionDrug;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface NoteMapper extends Mapper<Note> {

    //根据id查询
    @Select({"<script>",
             "select * from tb_note",
             "<where>",
             "patient_id in",
             "<foreach item='item' index='index' collection='listId' open='(' separator=',' close=')'>",
             "#{item}",
             "</foreach>",
             "</where>",
             "</script>"
    })
    @Results({
            @Result(column="note_id",property = "note_id",jdbcType = JdbcType.VARCHAR)
    })
    List<Note> selectNoteByIds(@Param("listId") List<Integer> listId);

    //按时间段查询记录和总价
    @Select("SELECT * FROM tb_note WHERE note_time between #{time_start}and #{time_end}")
    List<Note> chargeNote(@Param("time_start") String time_start,@Param("time_end") String time_end);

    //按时间段查询记录和总价
    @Select("SELECT prescription_id FROM tb_note WHERE note_time between #{time_start}and #{time_end}")
    List<Integer> prescriptionNote(@Param("time_start") String time_start,@Param("time_end") String time_end);

    //根据处方id查询药品id并去重
    @Select({"<script>",
            "select DISTINCT(drug_code) from prescription_drug",
            "<where>",
            "prescription_id in",
            "<foreach item='item' index='index' collection='listId' open='(' separator=',' close=')'>",
            "#{item}",
            "</foreach>",
            "</where>",
            "</script>"
    })
    List<Integer> drugIdList(@Param("listId") List<Integer> listId);

    //根据药品id查询总价
    @Select({"<script>",
            "select drug_code,SUM(number) as number,drug_name from prescription_drug",
            "<where>",
            "prescription_id in",
            "<foreach item='item' index='index' collection='listId' open='(' separator=',' close=')'>",
            "#{item}",
            "</foreach>",
            "and drug_code = #{drug_code}",
            "</where>",
            "</script>"
    })
    DrugNumber drugIdLists(@Param("listId") List<Integer> listId, @Param("drug_code")int drug_code);

}