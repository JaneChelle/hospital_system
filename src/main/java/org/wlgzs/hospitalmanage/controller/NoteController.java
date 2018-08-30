package org.wlgzs.hospitalmanage.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.wlgzs.hospitalmanage.base.BaseController;
import org.wlgzs.hospitalmanage.entity.Note;
import org.wlgzs.hospitalmanage.util.Result;
import org.wlgzs.hospitalmanage.util.ResultCode;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.util.List;

/**
 * @author: 胡亚星
 * @createTime 2018-08-15 21:15
 * @description: 就诊记录控制层
 **/
@RestController
@RequestMapping("/note")
public class NoteController extends BaseController {

    //跳转到添加一条记录
    @RequestMapping("/toAddNote")
    public ModelAndView toAddNote(){
        return new ModelAndView("addNote");
    }

    //添加记录
    @RequestMapping(value = "", method = RequestMethod.PUT)
    public ModelAndView addNote(Note note,
                                String price_end,HttpSession session) throws ParseException {
        noteService.addNote(note,price_end,session);
        //添加成功
        return new ModelAndView("redirect:/note/findNote");
    }

    //查看记录详情(id查询)
    @RequestMapping("/detailsNote")
    public ModelAndView detailsNote(Model model,int note_id){
        Note note = noteService.detailsNote(note_id);
        model.addAttribute("note",note);
        return new ModelAndView("viewNote");
    }

    //删除记录
    @RequestMapping(value = "/{note_id}", method = RequestMethod.DELETE)
    public Result deleteNote(@PathVariable("note_id") int note_id) {
        return noteService.deleteNote(note_id);
    }

    //修改记录（添加价格，疾病id）
    @RequestMapping(value = "/modifyNote")
    public ModelAndView modifyNote(Note note,String price_end) {
        noteService.modifyNote(note,price_end);
        return new ModelAndView("redirect:/note/findNote");
    }

    //搜索记录
    @RequestMapping(value = "/findNote")
    public ModelAndView findPrescription(Model model, @RequestParam(value = "page", defaultValue = "0") int page
            , @RequestParam(value = "findName", defaultValue = "") String findName) {
        System.out.println("findName"+findName);
        List<Note> noteList = noteService.findNote(findName, page);
        model.addAttribute("findName", findName);
        model.addAttribute("noteList", noteList);
        return new ModelAndView("detailsNote");
    }

    //跳转到查询价格页面
    @RequestMapping("/toChargeNote")
    public ModelAndView toChargeNote(){
        return new ModelAndView("chargeNote");
    }

    //按时间查询记录收费情况
    @RequestMapping("/chargeNote")
    public Result chargeNote(String time){
        System.out.println(time);
        return noteService.chargeNote(time);
    }

    //按时间查询某个药品的使用情况
    @RequestMapping("/drugUsage")
    public Result drugUsage(String time,
                            @RequestParam(value = "drugName",defaultValue = "") String drugName){
        return noteService.drugUsage(time,drugName);
    }


}
