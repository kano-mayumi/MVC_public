package jp.co.kano.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//http://localhost:8080/MVCFinalKadai01_user_Kano/show.html
//かえた。
@Controller
public class UserController {

	@RequestMapping("/show")
	public String show() {
		return "userjsp/LOG101";
	}

}
