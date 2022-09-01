package jp.co.opst.jdbc.service;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import jp.co.opst.jdbc.model.QuestionFormModel;

@Service
public class ValidationService {

    public ModelAndView validation(QuestionFormModel model) {

        ModelAndView mav = new ModelAndView();

        // 名字チェック
        String lstName = model.getLstName();
        if ("".equals(lstName)) {
            mav.addObject("lstNameErrMsg", "名字を入力してください");
        } else if (lstName.length() > 20) {
            mav.addObject("lstNameErrMsg", "名字は20文字以内で入力してください");
        }

        // 名前チェック
        String fstName = model.getFstName();
        if ("".equals(fstName)) {
            mav.addObject("fstNameErrMsg", "名前を入力してください");
        } else if (fstName.length() > 20) {
            mav.addObject("fstNameErrMsg", "名前は20文字以内で入力してください");
        }

        //性別チェック
        String gender = model.getGender();
        if (gender == null) {
            mav.addObject("genderErrMsg", "性別を選択してください");
        }

        //年齢チェック(パターン1)
        String age = model.getAge();
        if (!age.matches("[0-9]+$")) {
            mav.addObject("ageErrMsg", "年齢は半角数値で入力してください");
        }

        //	年齢チェック(パターン2)
        //	try {
        //		Integer.parseInt(age);
        //	} catch (NumberFormatException e) {
        //		mav.addObject("ageErrMsg", "年齢は半角数値で入力してください");
        //	}

        String[] important = model.getImportant();
        if (important == null || important.length < 2) {
            mav.addObject("importantErrMsg", "「重視すること」は２つ以上選択してください");
        }

        if (mav.isEmpty()) {
            return null;
        }
        mav.setViewName("QuestionForm");
        mav.addObject("questionFormModel", model);
        return mav;

    }

}
