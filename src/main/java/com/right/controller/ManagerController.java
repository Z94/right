package com.right.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Request;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.right.entity.Function;
import com.right.entity.Manager;
import com.right.entity.Module;
import com.right.service.ManagerService;

@Controller
public class ManagerController {

	@Resource
	HttpSession session;
	@Resource
	HttpServletRequest request;
	@Resource
	ManagerService service;
	@RequestMapping(value = "manager_update")
	public ModelAndView toManager_updatePage(){
		return new ModelAndView("Manager/manager_update");
	}
	@RequestMapping(value = "manager_function")
	public ModelAndView toManager_functionPage(){
		String loginId = String.valueOf(session.getAttribute("userId"));
		
		System.out.println("loginId   "+loginId);
		Manager manager = (Manager) session.getAttribute("manager");
		System.out.println(manager);
		int manager_id = Integer.parseInt(String.valueOf(manager.getManager_id()));
		System.out.println("manager_id "+manager_id);
		List<Integer> list = service.getFunctionList(manager_id);
		System.out.println("++++list++++"+list);
		if (!list.isEmpty()) {
			List<Function> name = service.getFunction_name(list);
			request.setAttribute("name", name); 
		}
			
		List<Integer> function_id = service.getFunction_id(loginId,list);
		System.out.println("function_id  "+function_id);
		List<Function> function_name = service.getFunction_name(function_id);
		request.setAttribute("function_name", function_name);
		
		return new ModelAndView("Manager/manager_function");
	}
	@RequestMapping(value = "manager_module")
	public ModelAndView toManager_modulePage(){
		String loginId = String.valueOf(session.getAttribute("userId"));
		Manager manager = (Manager) session.getAttribute("manager");
		String manager_id = String.valueOf(manager.getManager_id());
		List<String> list = service.getModuleList(manager_id);
		System.out.println("++++list++++"+list);
			List<Module> name = service.getModule_name(list);
			request.setAttribute("name", name); 
		List<String> module_id = service.getModule_id(loginId,list);
		System.out.println("++++"+module_id);
		
		List<Module> module_name = service.getModule_name(module_id);
		System.out.println("++++"+module_name);
		request.setAttribute("module_name", module_name);
		
		return new ModelAndView("Manager/manager_module");
	}
	@RequestMapping(value = "manager_select")
	public ModelAndView toManager_selectPage(){
		return new ModelAndView("Manager/manager_select");
	}
	
	@RequestMapping("managerAdd")
	public ModelAndView toReceivePage(Manager manager,HttpServletRequest request){
		System.out.println(manager);
		int a = service.add(manager);
		boolean result = false;
		if (a==-2147482646) {
			result = true;
		}
		request.setAttribute("result", result);
		System.out.println("++++++"+a);
		return new ModelAndView("Common/FormReceiveJSP");
	}
	
	@RequestMapping("managerUpdate")
	public ModelAndView toUpdatePage(Manager manager,HttpServletRequest request){
		System.out.println(manager);
		int a = service.update(manager);
		boolean result = false;
		if (a==-2147482646) {
			result = true;
		}
		request.setAttribute("result", result);
		System.out.println("++++++"+a);
		return new ModelAndView("Common/FormReceiveJSP");
	}
}
