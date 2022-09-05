package jp.co.kano.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jp.co.kano.dto.CreateStudentFormModel;
import jp.co.kano.dto.StudentModel;
import jp.co.kano.service.CreateStudentService;

//http://localhost:8080/createStudent/inputPage.html

@Controller
public class CreateController {

    @Autowired
    private CreateStudentService createStudentService;

    @RequestMapping("/inputPage")
    public String show() {
        return "input";
    }

    //登録したいStudent情報をランダムで生成する
    @RequestMapping("/getStudent")
    public ModelAndView getStudentList() {

        //studentModelが返ってくる。
        StudentModel studentModel  = createStudentService.createStudent();
        
        return new ModelAndView("input", "studentModel", studentModel);//WEBINF/jsp/input.jsp
    }
      //画面の値を取得して登録する。
    @RequestMapping(path = "/register", method = RequestMethod.POST)
    public ModelAndView register(CreateStudentFormModel studentFormModel, HttpSession session,HttpServletRequest request) {
        //System.out.println(request.getParameter("name"));
        
        //入力値をstudentFormModelに格納する。
        try {
        session.setAttribute("sdtudentFormModel",studentFormModel);
        createStudentService.insert(studentFormModel);
        }catch(Exception e) {
            e.printStackTrace();
        }
        
        ModelAndView mav = new ModelAndView("input");
        return mav;
    }

}
