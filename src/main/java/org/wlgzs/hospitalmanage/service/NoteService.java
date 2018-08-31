package org.wlgzs.hospitalmanage.service;

import org.springframework.ui.Model;
import org.wlgzs.hospitalmanage.entity.Note;
import org.wlgzs.hospitalmanage.util.Result;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.util.List;

/**
 * @author: 胡亚星
 * @createTime 2018-08-17 10:58
 * @description:
 *
 **/
public interface NoteService {

    //添加记录
    Result addNote(Note note,String price_end,String timeStr,HttpSession session) throws ParseException;

    //查看记录详情(id查询)
    Note detailsNote(int note_id);

    //按id删除
    Result deleteNote(int noteId);

    //修改记录
    void modifyNote(Note note,String price_end);

    //按用户搜索记录
    List<Note> findNote(String findName,int page,Model model);

    //按时间段查询记录和总价
    Result chargeNote(String time);

    //按时间查询某个药品的使用情况
    Result drugUsage(String time,String drugName);
}
