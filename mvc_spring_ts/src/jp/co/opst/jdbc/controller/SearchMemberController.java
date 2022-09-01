package jp.co.opst.jdbc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jp.co.opst.jdbc.model.QuestionFormModel;
import jp.co.opst.jdbc.model.UserInfoModel;
import jp.co.opst.jdbc.service.QuestionFormService;
import jp.co.opst.jdbc.service.ValidationService;

@Controller
public class SearchMemberController {

    @Autowired
    private QuestionFormService questionFormService;

    @Autowired
    private ValidationService validationService;

    @RequestMapping("/form")//引数の中に使用したいスコープを指定できる
    public ModelAndView showMemberForm(HttpSession session) {
        UserInfoModel uiModel = questionFormService.allfind();
        session.setAttribute("userInfo", uiModel);
        ModelAndView mav = new ModelAndView("QuestionForm");
        return mav;
    }
//メソッドの引数でsessionを取得できる
    //こっちにスコープ指定をもってくることもできる
    @RequestMapping(path = "/conf", method = RequestMethod.POST)
    public ModelAndView showOrderForm(QuestionFormModel model, HttpSession session, HttpServletRequest request) {

        System.out.println("SpringでもHttpServletRequestからgetParameterできる：" + request.getParameter("lstName")
                + request.getParameter("fstName"));

        ModelAndView mav = null;

        // BeanValidationを使用しないバリデーション
        mav = validationService.validation(model);
        if (mav != null) {
            return mav;
        }

        session.setAttribute("questionForm", model);
        mav = new ModelAndView("QuestionFormConf");
        mav.addObject("arraySize", model.getImportant().length);
        return mav;
    }

    @RequestMapping(path = "/register", method = RequestMethod.POST)
    public ModelAndView register(HttpSession session) {
        try {
            QuestionFormModel model = (QuestionFormModel) session.getAttribute("questionForm");
            questionFormService.insert(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
        UserInfoModel uiModel = questionFormService.allfind();
        session.setAttribute("userInfo", uiModel);
        ModelAndView mav = new ModelAndView("QuestionForm");
        return mav;
    }
}
