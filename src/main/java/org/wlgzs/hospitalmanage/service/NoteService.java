package org.wlgzs.hospitalmanage.service;

import org.wlgzs.hospitalmanage.entity.Note;
import org.wlgzs.hospitalmanage.util.Result;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.util.List;

/**
 * @author:胡亚星
 * @createTime 2018-08-17 10:58
 * @description:
 **/
public interface NoteService {

    //添加记录
    boolean addNote(int prescription_id,HttpSession session) throws ParseException;

    //按id删除
    Result deleteNote(int noteId);

    //修改记录
    void modifyNote(Note note);

    //按用户搜索记录
    List<Note> findNote(String findName,int page);

}
