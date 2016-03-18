package com.right.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Request;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.right.entity.Function;
import com.right.entity.Manager;
import com.right.entity.Module;
import com.right.entity.Org;
import com.right.entity.Role;
import com.right.entity.User;
import com.right.service.ToPageService;

@Controller
public class ToPageController {

	@Resource
	ToPageService toPage;

	
	
	@RequestMapping(value = "dep",method = RequestMethod.GET)
	public ModelAndView toDepPage(HttpServletRequest request,HttpSession session){
		String id = request.getParameter("depid");
		Org org = toPage.getOrg(id);
		session.setAttribute("org", org);
		return new ModelAndView("Dep/dep");
	}
	
	@RequestMapping(value = "module")
	public ModelAndView toModulePage(HttpServletRequest request,HttpSession session){
		String id = request.getParameter("moduleId");
		Module module = toPage.getModule(id);
		session.setAttribute("module", module);
		return new ModelAndView("Module/module");
	}
	
	@RequestMapping(value = "function")
	public ModelAndView toFunctionPage(HttpServletRequest request,HttpSession session){
		String id = request.getParameter("functionId");
		Function function = toPage.getFunction(id);
		session.setAttribute("function", function);
		return new ModelAndView("Function/function");
	}
	
	@RequestMapping(value = "manager")
	public ModelAndView toManagerPage(HttpServletRequest request,HttpSession session){
		String id = request.getParameter("managerId");
		Manager manager = toPage.getManager(id);
		session.setAttribute("manager", manager);
		System.out.println("manager"+manager);
		return new ModelAndView("Manager/manager");
	}
	
	@RequestMapping(value = "user")
	public ModelAndView toUserPage(HttpServletRequest request,HttpSession session){
		String id = request.getParameter("userId");
		User user = toPage.getUser(id);
		session.setAttribute("user",user);
		return new ModelAndView("User/user");
	}
	
	@RequestMapping(value = "role")
	public ModelAndView toRolePage(HttpServletRequest request,HttpSession session){
		String id = request.getParameter("roleId");
		Role role = toPage.getRole(id);
		session.setAttribute("role", role);
		return new ModelAndView("Role/role");
	}
	
	
	
}
