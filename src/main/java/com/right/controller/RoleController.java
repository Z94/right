package com.right.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.right.entity.Function;
import com.right.entity.Manager;
import com.right.entity.Module;
import com.right.entity.Role;
import com.right.entity.User;
import com.right.service.RoleService;

@Controller
public class RoleController {
	@Resource
	HttpServletRequest request;
	@Resource
	HttpSession session;
	@Resource
	RoleService service;
	
	@RequestMapping(value = "role_edit")
	public ModelAndView toRole_editPage(){
		return new ModelAndView("Role/role_edit");
	}
	
	@RequestMapping(value = "role_user")
	public ModelAndView toRole_userPage(){
		Role role = (Role) session.getAttribute("role");
		int role_id = Integer.parseInt(String.valueOf(role.getRole_id()));
		List<String> list = service.getUserList(role_id);
		System.out.println("++++list++++"+list);
		if (!list.isEmpty()) {
			List<User> name = service.getUser_name(list);
			request.setAttribute("name", name); 
		}
			
		List<Integer> org_id = service.getOrg_id(role_id);
		List<String> user_id = service.getUser_id(list,org_id);
		List<User> user_name = service.getUser_name(user_id);
		request.setAttribute("user_name", user_name);
		return new ModelAndView("Role/role_user");
	}
	
	@RequestMapping(value = "role_function")
	public ModelAndView toRole_functionPage(){
		String loginId = String.valueOf(session.getAttribute("userId"));
		Role role = (Role) session.getAttribute("role");
		int role_id = Integer.parseInt(String.valueOf(role.getRole_id()));
		List<String> list = service.getFunctionList(role_id);
		System.out.println("++++list++++"+list);
		if (!list.isEmpty()) {
			List<Function> name = service.getFunction_name(list);
			request.setAttribute("name", name);
		} 
			
			List<String> function_id = service.getFunction_id(loginId,list);
			List<Function> function_name = service.getFunction_name(function_id);
			request.setAttribute("function_name", function_name);
		return new ModelAndView("Role/role_function");
	}
	@RequestMapping(value = "role_module")
	public ModelAndView toRole_modulePage(){
		String loginId = String.valueOf(session.getAttribute("userId"));
		Role role = (Role) session.getAttribute("role");
		int role_id = Integer.parseInt(String.valueOf(role.getRole_id()));
		List<Integer> list = service.getModuleList(role_id);
		System.out.println("++++list++++"+list);
		if (!list.isEmpty()) {
			List<Module> name = service.getModule_name(list);
			request.setAttribute("name", name); 
		}
		List<Integer> module_id = service.getModule_id(loginId,list);
		System.out.println("++++"+module_id);
		
		List<Module> module_name = service.getModule_name(module_id);
		System.out.println("++++"+module_name);
		request.setAttribute("module_name", module_name);
		return new ModelAndView("Role/role_module");
	}
	
	@RequestMapping("roleAdd")
	public ModelAndView toReceivePage(Role role,HttpServletRequest request){
		System.out.println(role);
		int a = service.add(role);
		boolean result = false;
		if (a==-2147482646) {
			result = true;
		}
		request.setAttribute("result", result);
		System.out.println("++++++"+a);
		return new ModelAndView("Common/FormReceiveJSP");
	}
	
	@RequestMapping("roleUpdate")
	public ModelAndView toUpdatePage(Role role,HttpServletRequest request){
		System.out.println(role);
		int a = service.update(role);
		boolean result = false;
		if (a==-2147482646) {
			result = true;
		}
		request.setAttribute("result", result);
		System.out.println("++++++"+a);
		return new ModelAndView("Common/FormReceiveJSP");
	}
}
