package com.spanish.english.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.spanish.english.form.Admin;
import com.spanish.english.form.Establishment;
import com.spanish.english.form.Operator;
import com.spanish.english.form.Technician;
import com.spanish.english.services.AdminServices;
import com.spanish.english.services.EstablishmentServices;
import com.spanish.english.services.OperatorServices;
import com.spanish.english.services.TechnicianServices;

@Controller
@SessionAttributes
public class ContactController {

	@Autowired
	AdminServices adminServices;

	@Autowired
	OperatorServices operatorServices;

	@Autowired
	EstablishmentServices establishmentServices;

	@Autowired
	TechnicianServices technicianServices;

	public static HashMap<String, Long> adminMap = new HashMap<String, Long>();

	@RequestMapping(value = "/addContact", method = RequestMethod.POST)
	public String addContact(@ModelAttribute("admin") Admin admin,
			BindingResult result, HttpServletRequest request,
			HttpServletResponse response) {

		System.out.println("User Name:" + admin.getAdminUsername()
				+ "Password :" + admin.getAdminPassword());

		if (adminServices.login(admin.getAdminUsername(),
				admin.getAdminPassword())) {

			// adminMap.put(sessionId, sessionId);
			Admin admin1 = adminServices.getAdminByUsername(admin
					.getAdminUsername());
			long strI = admin1.getId();

			adminMap.put("adminId", strI);
			return "dashboard";
		} else {
			return "redirect:contacts.html";
		}
	}

	@RequestMapping("/contacts")
	public ModelAndView showContacts() {

		return new ModelAndView("admin", "command", new Admin());
	}

	@RequestMapping(value = "/dashboard")
	public String dashboard() {

		return "dashboard";
	}

	@RequestMapping(value = "/logout")
	public ModelAndView logoutMethod() {

		return new ModelAndView("logout", "command", new Admin());
	}

	@RequestMapping(value = "/login")
	public ModelAndView login() {

		return new ModelAndView("logout", "command", new Admin());
	}

	@RequestMapping(value = "/error")
	public String error(Model model) {

		model.addAttribute("command", new Admin());
		model.addAttribute("error", "1");
		return "logout";
	}

	@RequestMapping(value = "/default")
	public String defaultMethod() {

		String userName = SecurityContextHolder.getContext()
				.getAuthentication().getName();

		Admin loggedAdmin = adminServices.getAdminByUsername(userName);
		Operator loggedOperator = operatorServices
				.getOperatorByUsername(userName);
		Establishment loggedEstablishment = establishmentServices
				.getEstablishmentByUsername(userName);
		Technician loggedTechnician = technicianServices
				.getTechnicianByUsername(userName);
		if (loggedAdmin != null) {

			return "dashboard";
		} else if (loggedOperator != null) {
			return "operatordashboard";
		} else if (loggedEstablishment != null) {
			return "establishmentdashboard";
		} else if (loggedTechnician != null) {
			return "techniciandashboard";
		} else {
			return null;
		}

	}

	public HashMap<String, Long> getAdminmap() {
		return adminMap;
	}
}
