/*
 * Controllerクラス
 *　2022年9月9日
 */

package jp.co.kano.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jp.co.kano.model.MemberModel;
import jp.co.kano.service.UserService;

//http://localhost:8080/MVCFinalKadai01_user_Kano/
//welcomepage　→　menu.html

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	//初期表示の画面
	@RequestMapping("/menu")
	public String menu_show() {
		return "userjsp/MEN101";
	}

	//ログイン画面
	@RequestMapping("/*login")
	public String login_show(HttpServletRequest request) {

		//初期値をエラー画面に設定
		String viewName="ERR101";

		//デフォルトの遷移
		if (request.getRequestURI().contains("default")) {
			viewName = "userjsp/MEN101";
		}
		//買い物かごから遷移
		if (request.getRequestURI().contains("BasketCheck")) {
			viewName = "userjsp/KGO102";
		}
		//ユーザメニューからの遷移
		if (request.getRequestURI().contains("UserMenu")) {
			viewName = "userjsp/MEM201";
		}
			//ログイン後の画面
			return viewName;
	}

	//ログイン完了後画面

	//新規会員登録画面
	@RequestMapping("/newMemberRegistration")
	public String newMemberRegistration_show() {
		return "userjsp/MEM101";
	}

	//会員登録修正・削除画面
	@RequestMapping("/memberInfomationEditAndDelete")
	public String memberInfomationEditAndDelete_show() {
		//ログイン判定
		boolean loginFlag = false;
		String viewName = "userjsp/LOG101";

			viewName = "userjsp/MEM201";

		return viewName;
	}

	//商品検索画面
	@RequestMapping("/productSearch")
	public String productSearch_show() {
		return "userjsp/MEM201";
	}

	//お買い物かご画面
	@RequestMapping("/basket")
	public String basket_show() {
		return "userjsp/SHO101";
	}

	//新規会員登録_確認処理
	@RequestMapping("/newMemberRegistrationConfilm")
	public ModelAndView newMemberRegistrationConfilm(MemberModel model, HttpSession session) {
		session.setAttribute("memberModel", model);

		//バリデーション

		//遷移→確認画面
		return new ModelAndView("userjsp/MEM102");
	}

	//新規会員登録_登録処理
	@RequestMapping("/newMemberRegister")
	public ModelAndView newMemberRegister(HttpSession session) {
		try {
			MemberModel memberModel = (MemberModel) session.getAttribute("memberModel");
			userService.insertMember(memberModel);
		} catch (Exception e) {
			e.printStackTrace();
		}

		Integer memberNo = userService.getMemberNo();
		return new ModelAndView("MEM103");
	}

}
//http://localhost:8080/jsp/userjsp/MEM101.html