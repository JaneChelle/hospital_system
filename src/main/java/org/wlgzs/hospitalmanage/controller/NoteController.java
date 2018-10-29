package org.wlgzs.hospitalmanage.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.wlgzs.hospitalmanage.base.BaseController;
import org.wlgzs.hospitalmanage.entity.*;
import org.wlgzs.hospitalmanage.util.Result;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
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
    public ModelAndView toAddNote() {
        return new ModelAndView("addNote");
    }

    //添加记录
    @RequestMapping(value = "", method = RequestMethod.PUT)
    public Result addNote(Note note, String price_end,
                          String prescription_name, HttpSession session) throws ParseException {
        return noteService.addNote(note, price_end, prescription_name, session);
    }

    //查看记录详情(id查询)
    @RequestMapping("/detailsNote")
    public ModelAndView detailsNote(Model model, int note_id) {
        Note note = noteService.detailsNote(note_id);
        int prescriptionId = note.getPrescription_id();
        session.setAttribute("prescription_id", prescriptionId + "");
        Prescription prescription = prescriptionService.findPrescriptionById(prescriptionId);//处方
        List<PrescriptionDrug> prescriptionDrugList = prescriptionService.queryPrescriptionDrug(prescriptionId);
        List<PrescriptionCheck> prescriptionCheckList = prescriptionService.queryPrescriptionCheck(prescriptionId);
        List<PrescriptionTreatment> prescriptionTreatmentList = prescriptionService.queryPrescriptionTreatment(prescriptionId);
        model.addAttribute("prescriptionDrugList", prescriptionDrugList);
        model.addAttribute("prescriptionCheckList", prescriptionCheckList);
        model.addAttribute("prescriptionTreatmentList", prescriptionTreatmentList);
        model.addAttribute("prescription", prescription);
        model.addAttribute("note", note);
        return new ModelAndView("viewNote");
    }

    //删除记录
    @RequestMapping(value = "/{note_id}", method = RequestMethod.DELETE)
    public Result deleteNote(@PathVariable("note_id") int note_id) {
        return noteService.deleteNote(note_id);
    }

    //修改记录（添加价格，疾病id）
    @RequestMapping(value = "/modifyNote")
    public ModelAndView modifyNote(Note note, String price_end) {
        noteService.modifyNote(note, price_end);
        return new ModelAndView("redirect:/note/findNote");
    }

    //搜索记录
    @RequestMapping(value = "/findNote/{page}")
    public ModelAndView findPrescription(Model model, @PathVariable(value = "page") int page
            , @RequestParam(value = "findName", defaultValue = "") String findName) {
        System.out.println("findName" + findName);
        List<Note> noteList = noteService.findNote(findName, page, model);
        System.out.println(noteList);
        model.addAttribute("findName", findName);
        model.addAttribute("noteList", noteList);
        return new ModelAndView("detailsNote");
    }

    //跳转到查询价格页面
    @RequestMapping("/toChargeNote")
    public ModelAndView toChargeNote() {
        return new ModelAndView("chargeNote");
    }

    //按时间查询记录收费情况
    @RequestMapping("/chargeNote")
    public ModelAndView chargeNote(String time,Model model) {
        System.out.println(time);
        List<Note> noteList = noteService.chargeNote(time);
        BigDecimal totalPrice = new BigDecimal("0");
        for (Note aNoteList : noteList) {
            totalPrice = totalPrice.add(aNoteList.getPrice_end());
        }
        String total_price = totalPrice.toString();

        model.addAttribute("noteList",noteList);
        System.out.println(noteList);
        model.addAttribute("total_price",total_price);
        return new ModelAndView("chargeNote");
    }

    //跳转到查询价格页面
    @RequestMapping("/toDrugUsage")
    public ModelAndView toDrugUsage() {
        return new ModelAndView("DrugUsage");
    }



    //按时间查询某个药品的使用情况
    @RequestMapping("/drugUsage")
    public ModelAndView drugUsage(String time,Model model,
                            @RequestParam(value = "drugName", defaultValue = "") String drugName) {
        List<DrugNumber> drugNumberList = noteService.drugUsage(time, drugName);
        model.addAttribute("drugNumberList",drugNumberList);
        return new ModelAndView("");
    }

}
