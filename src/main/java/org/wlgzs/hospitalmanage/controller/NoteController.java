package org.wlgzs.hospitalmanage.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.wlgzs.hospitalmanage.base.BaseController;
import org.wlgzs.hospitalmanage.entity.Note;
import org.wlgzs.hospitalmanage.util.Result;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.util.List;

/**
 * @author: 胡亚星
 * @createTime 2018-08-15 21:15
 * @description: 就诊记录控制层
 **/
@RestController
public class NoteController extends BaseController {

    //添加记录
    @RequestMapping(value = "/note",method = RequestMethod.PUT)
    public ModelAndView addNote(int prescription_id, HttpSession session) throws ParseException {
        if(noteService.addNote(prescription_id,session)){
            //添加成功（跳转到修改）
            return new ModelAndView("");
        }
        return new ModelAndView("sac");
    }

    //删除记录
    @RequestMapping(value = "/note/{noteId}",method = RequestMethod.DELETE)
    public Result deleteNote(@PathVariable("noteId") int noteId){
        return noteService.deleteNote(noteId);
    }

    //修改记录
    @RequestMapping(value = "/note", method = RequestMethod.POST)
    public ModelAndView modifyPrescription(Note note){
        noteService.modifyNote(note);
        return new ModelAndView("redirect:/prescription/1");
    }

    //搜索记录
    @RequestMapping(value = "/note/findNote")
    public ModelAndView findPrescription(Model model,@RequestParam(value = "page", defaultValue = "0") int page
                                         ,@RequestParam(value = "findName", defaultValue = "") String findName){
        List<Note> noteList = noteService.findNote(findName,page);
        model.addAttribute("findName",findName);
        model.addAttribute("noteList",noteList);
        return new ModelAndView("note");
    }

}
