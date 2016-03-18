package com.right.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.right.entity.FManager;
import com.right.entity.Function;
import com.right.entity.Manager;
import com.right.entity.Module;
import com.right.entity.Role;
import com.right.entity.User;
import com.right.service.CommonService;
import com.right.service.FunctionService;
import com.right.service.ToPageService;

@Controller
public class FunctionController {

	@Resource
	ToPageService toPage;
	@Resource
	FunctionService service;
	@Resource
	CommonService cs;
	@Resource
	HttpServletRequest request;
	@Resource
	HttpSession session;
	
	@RequestMapping(value = "function_edit")
	public ModelAndView toFunction_updatePage(HttpServletRequest request){
		List<Module> modules = toPage.getModuleList();
		request.setAttribute("modules", modules);
		return new ModelAndView("Function/function_edit");
	}
	
//	@RequestMapping("functionRight")
//	public ModelAndView ToRightPage(){
//		String loginId = String.valueOf(session.getAttribute("userId"));
//		int function_id = Integer.parseInt(request.getParameter("id"));
//		List<Integer> orgId = cs.getOrgId(loginId);
//		System.out.println("orgId   "+orgId);
//		
//		List<Integer> list = service.getId(orgId, loginId, function_id);
//		return null;
//	}
	@RequestMapping(value = "function_user")
	public ModelAndView toFunction_userPage(){
		String loginId = String.valueOf(session.getAttribute("userId"));
		Function function = (Function) session.getAttribute("function");
		int function_id = function.getFunction_id();
		System.out.println(function_id);
		List<Integer> org_id = cs.getOrg_id(loginId);
		System.out.println("+++++++++"+org_id);
		
		List<Integer> list = service.getUser_id(org_id,loginId,function_id);
		System.out.println("++++"+list);
		System.out.println(list.size());
		if (!list.isEmpty()) {
			List<User> name = service.getUser_name(list);
			request.setAttribute("name", name);
		}
			
		List<User> users = service.getUserList(org_id,list);
		System.out.println("++++"+users);
		request.setAttribute("users", users);
		return new ModelAndView("Function/function_user");
	}
	
	@RequestMapping(value = "function_manager")
	public ModelAndView toFunction_managerPage(){
		String loginId = String.valueOf(session.getAttribute("userId"));
		Function function = (Function) session.getAttribute("function");
		int function_id = function.getFunction_id();
		System.out.println("loginId"+loginId);
		System.out.println("function_id"+function_id);
		List<Integer> org_id = cs.getOrg_id(loginId);
		System.out.println("+++++++++"+org_id);
		
		List<Integer> list = service.getManager_id(org_id,loginId,function_id);
		System.out.println("list"+list);
			List<Manager> name = service.getManager_name(list);
				request.setAttribute("name", name);
				System.out.println("name"+name);
				List<Manager> managers = service.getManagerList(org_id,list);
				System.out.println("++++"+managers);
				request.setAttribute("managers", managers);
		return new ModelAndView("Function/function_manager");
	}
	@RequestMapping(value = "function_role")
	public ModelAndView toFunction_rolePage(){
		String loginId = String.valueOf(session.getAttribute("userId"));
		Function function = (Function) session.getAttribute("function");
		int function_id = function.getFunction_id();
		
		List<Integer> org_id = cs.getOrg_id(loginId);
		System.out.println("+++++++++"+org_id);
		
		List<Integer> list = service.getRole_id(org_id,loginId,function_id);
		System.out.println("++++"+list);
			List<Role> name = service.getRole_name(list);
			request.setAttribute("name", name);
				List<Role> roles = service.getRoleList(org_id,list);
				System.out.println("++++"+roles);
				request.setAttribute("roles", roles);
		return new ModelAndView("Function/function_role");
	}
	@RequestMapping(value = "function_add")
	public ModelAndView toFunction_addPage(){
		return new ModelAndView("Function/function_add");
	}
	
	@RequestMapping("functionAdd")
	public ModelAndView toReceivePage(Function function,HttpServletRequest request){
		System.out.println(function);
		int a = service.add(function);
		boolean result = false;
		if (a==-2147482646) {
			result = true;
		}
		request.setAttribute("result", result);
		System.out.println("++++++"+a);
		return new ModelAndView("Common/FormReceiveJSP");
	}
	
	@RequestMapping("functionUpdate")
	public ModelAndView toUpdatePage(Function function,HttpServletRequest request){
		System.out.println(function);
		int a = service.update(function);
		System.out.println("++++++"+a);
		boolean result = false;
		if (a==-2147482646) {
			result = true;
		}
		request.setAttribute("result", result);
		System.out.println("++++++"+a);
		return new ModelAndView("Common/FormReceiveJSP");
	}
	
	
//	@RequestMapping("FM")
//	public ModelAndView toRightPage(HttpServletRequest request){
//		Function function = (Function) session.getAttribute("function");
//		int function_id = function.getFunction_id();
//		
//		String[] manager_id = request.getParameterValues("manager_id");
//
//		
//			service.delete1(function_id);
//			service.add2(manager_id,function_id);
//		if (manager_id!=null) {
//			for (int i = 0; i < manager_id.length; i++) {
//				FManager fm = new FManager();
//				fm.setFunction_id(function_id);
//				fm.setManager_id(manager_id[i]);
//				fms.add(fm);
//			}
//			service.add1(fms);
//		}
//		System.out.println(fms);
//		for (int i = 0; i < fms.size(); i++) {
//			System.out.println(fms.get(i).getFunction_id());
//			System.out.println(fms.get(i).getManager_id());
//		}
//		
//		int a = 0;
//		System.out.println("++++++"+a);
//
//		boolean result = false;
//		if (a==-2147482646) {
//			result = true;
//		}
//		request.setAttribute("result", result);
//		System.out.println("++++++"+a);
//		return new ModelAndView("Common/FormReceiveJSP");
//	}
}
