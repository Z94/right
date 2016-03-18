package com.right.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.right.entity.Manager;
import com.right.entity.Module;
import com.right.entity.Role;
import com.right.entity.User;
import com.right.service.CommonService;
import com.right.service.ModuleService;

@Controller
public class ModuleController {

	@Resource
	CommonService cs;
	@Resource
	ModuleService service;
	
	
	@RequestMapping(value = "module_user")
	public ModelAndView toModule_userPage(HttpServletRequest request,HttpSession session){
		String loginId = String.valueOf(session.getAttribute("userId"));
		Module module = (Module) session.getAttribute("module");
		int module_id = module.getModule_id();
		
		List<Integer> org_id = cs.getOrg_id(loginId);
		System.out.println("+++++++++"+org_id);
		
		List<String> list = service.getUser_id(org_id,loginId,module_id);
		System.out.println("++++"+list);
		System.out.println(list.size());
		if (!list.isEmpty()) {
			List<User> name = service.getUser_name(list);
			request.setAttribute("name", name);
		}
		List<User> users = service.getUserList(org_id,list);
		System.out.println("++++"+users);
		request.setAttribute("users", users);
		return new ModelAndView("Module/module_user");
	}
	
	@RequestMapping(value = "module_manager")
	public ModelAndView toModule_managerPage(HttpSession session,HttpServletRequest request){
		String loginId = String.valueOf(session.getAttribute("userId"));
		Module module = (Module) session.getAttribute("module");
		int module_id = module.getModule_id();
		
		List<Integer> org_id = cs.getOrg_id(loginId);
		System.out.println("+++++++++"+org_id);
		
		
		List<String> list = service.getManager_id(org_id,loginId,module_id);
		System.out.println("++++"+list);
		if (!list.isEmpty()) {
			List<Manager> name = service.getManager_name(list);
			request.setAttribute("name", name);
		}
		
		
		List<Manager> managers = service.getManagerList(org_id,list);
		System.out.println("++++"+managers);
		request.setAttribute("managers", managers);
		return new ModelAndView("Module/module_manager");
	}
	@RequestMapping(value = "module_role")
	public ModelAndView toModule_rolePage(HttpSession session,HttpServletRequest request){
		String loginId = String.valueOf(session.getAttribute("userId"));
		Module module = (Module) session.getAttribute("module");
		int module_id = module.getModule_id();
		
		List<Integer> org_id = cs.getOrg_id(loginId);
		System.out.println("+++++++++"+org_id);
		
		List<String> list = service.getRole_id(org_id,loginId,module_id);
		System.out.println("++++"+list);
		System.out.println(list.size());
		if (!list.isEmpty()) {
			List<Role> name = service.getRole_name(list);
			request.setAttribute("name", name);
		}

		List<Role> roles = service.getRoleList(org_id,list);
		System.out.println("++++"+roles);
		request.setAttribute("roles", roles);
		return new ModelAndView("Module/module_role");
	}
	@RequestMapping(value = "module_add")
	public ModelAndView toModule_addPage(){
		return new ModelAndView("Module/module_add");
	}
	@RequestMapping(value = "module_edit")
	public ModelAndView toModule_editPage(){
		return new ModelAndView("Module/module_edit");
	}
	
	@RequestMapping("moduleAdd")
	public ModelAndView toReceivePage(Module module,HttpServletRequest request){
		int a = service.add(module);
		boolean result = false;
		if (a==-2147482646) {
			result = true;
		}
		request.setAttribute("result", result);
		System.out.println("++++++"+a);
		return new ModelAndView("Common/FormReceiveJSP");
	}
	
	@RequestMapping("moduleUpdate")
	public ModelAndView toUpdatePage(Module module,HttpServletRequest request){
		int a = service.update(module);
		boolean result = false;
		if (a==-2147482646) {
			result = true;
		}
		request.setAttribute("result", result);
		System.out.println("++++++"+a);
		return new ModelAndView("Common/FormReceiveJSP");
	}
	
}
