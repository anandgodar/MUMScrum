package com.scrum.portal.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.scrum.portal.dto.Product;
import com.scrum.portal.dto.User;
import com.scrum.portal.services.ProductService;
import com.scrum.portal.services.UserService;

@Controller
@SessionAttributes("userInfo")
public class LoginController {
 
	@Autowired
	private UserService userService;
	@Autowired
	private ProductService productservice;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String dashboard(Model model, HttpSession session) {
		if (session.getAttribute("userInfo") == null) {
			return "redirect:/login";
		}
		
		String suffix;
		
		int roleId= (Integer) session.getAttribute("roleId");
		System.out.println("Role ID "+roleId);
		switch (roleId) {
		case 1:
			suffix = "Developer";
			break;
		case 2:
			suffix = "Tester";
			break;
		case 3:
			suffix = "ScrumMaster";
			break;
		case 4:
			suffix = "ScrumMaster";
			
			
			break;
			
		case 8: //change developer number 
			suffix = "Developer";
			break;

		default:

			
			List<Product> products = productservice.listAllProduct();
			model.addAttribute("listproduct", products);
			
			suffix = "ScrumMaster";
			break;

		}

		model.addAttribute("page", "Dashboard-" +suffix);
		
		return "Container";
	}

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login(HttpSession session) {

		if (session.getAttribute("userInfo") != null) {

			return "redirect:/";
		}
		return "Login";
	}

	@RequestMapping(value = "verify", method = RequestMethod.POST)
	public String verify(@ModelAttribute("user") User user, Model model, HttpSession session) {

		User loginUser = userService.findByUserNameAndPassword(user.getUserName(), user.getPassword());
		System.out.println("employee id from user"+loginUser.getEmployee().getId());
		if (loginUser != null) {
		
			session.setAttribute("roleId", loginUser.getRoleID());
			session.setAttribute("userInfo", loginUser);
			model.addAttribute("userObject", loginUser);

			return "redirect:/";
		}
		model.addAttribute("errorMessage", "Invalid Username or Password");
		model.addAttribute("page", "Login");
		return "Login";

	}

	@RequestMapping(value = "success", method = RequestMethod.GET)
	public String success(@ModelAttribute("user") User userModel) {

		System.out.println("Success controller " + userModel.getUserName());
		userService.save(userModel);
		return "Success";
	}

	/**
	 * Redirects to home page after logout success
	 * 
	 * @return
	 */
	@RequestMapping("/dologout")
	public String doLogout(HttpSession session, SessionStatus status) {
		status.setComplete();
		session.removeAttribute("userInfo"); //only remove attribute
		return "redirect:/login";
	}

}
