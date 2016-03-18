package com.right.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.right.entity.Module;
import com.right.entity.Org;
import com.right.service.ToPageService;

@Controller
public class DepController {
	
	@Resource
	ToPageService toPage;
	
	@RequestMapping(value = "dep_add")
	public ModelAndView toDep_addPage(){
		return new ModelAndView("Dep/dep_add");
	}
	
	@RequestMapping(value = "dep_update")
	public ModelAndView toDep_updatePage(HttpServletRequest request,HttpSession session){
		List<Org> orgs = toPage.getOrgList();
		session.setAttribute("orgs", orgs);
		return new ModelAndView("Dep/dep_update");
	}
	
	@RequestMapping(value = "manager_add")
	public ModelAndView toManager_addPage(){
		return new ModelAndView("Manager/manager_add");
	}
	
	@RequestMapping(value = "user_add")
	public ModelAndView toUser_addPage(){
		return new ModelAndView("User/user_add");
	}
	
	@RequestMapping(value = "role_add")
	public ModelAndView toRole_addPage(){
		return new ModelAndView("Role/role_add");
	}
	
	@RequestMapping("orgAdd")
	public ModelAndView toReceivePage(Org org,HttpServletRequest request){
		System.out.println(org);
		int a = toPage.add(org);
		boolean result = false;
		if (a==-2147482646) {
			result = true;
		}
		request.setAttribute("result", result);
		System.out.println("++++++"+a);
		return new ModelAndView("Common/FormReceiveJSP");
	}
	
	@RequestMapping("orgUpdate")
	public ModelAndView toUpdatePage(Org org,HttpServletRequest request){
		System.out.println(org);
		int a = toPage.update(org);
		System.out.println("++++++"+a);
		boolean result = false;
		if (a==-2147482646) {
			result = true;
		}
		request.setAttribute("result", result);
		System.out.println("++++++"+a);
		return new ModelAndView("Common/FormReceiveJSP");
	}
}
