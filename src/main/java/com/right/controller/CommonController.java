package com.right.controller;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.right.entity.FManager;
import com.right.entity.Function;
import com.right.entity.Module;
import com.right.entity.UserFun;
import com.right.service.CommonService;

@Controller
public class CommonController {

	@Resource
	CommonService service;
	@Resource
	HttpServletRequest request;
	@Resource
	HttpSession session;
	@RequestMapping(value = "FormReceiveJSP")
	public ModelAndView toReceivePage(Module module){

		System.out.println(module.getModule_name());
		System.out.println(module.getModule_control());
		System.out.println(module.getModule_id());
		return new ModelAndView("Common/FormReceiveJSP");
	}
	
	@RequestMapping("right")
	public ModelAndView right(){
		String[] ids = request.getParameterValues("ids");
		String tableName = request.getParameter("tableName");
		String deleteName = request.getParameter("deleteName");
		int id = Integer.parseInt(request.getParameter("id"));
		
		if (ids!=null) {
			for (int i = 0; i < ids.length; i++) {
				System.out.println("ids   "+ids[i]);
			}
		}
		
		boolean result = toRight(tableName,deleteName,ids,id);

		request.setAttribute("result", result);
		return new ModelAndView("Common/FormReceiveJSP");
	}
	public boolean toRight(String tableName, String deleteName, String[] ids, int id){
		int a = 0;
		a = service.delete(tableName,id,deleteName);
		if (ids!=null) {
			a = service.add(ids,tableName,id,deleteName);
		}
		System.out.println("++++++"+a);

		boolean result = false;
		if (a==-2147482646) {
			result = true;
		}
		System.out.println("++++++"+a);
		return result;
	}
	
//	@RequestMapping("right")
//	public ModelAndView toRightPage(){
//		String tableName = request.getParameter("tableName");
//		int id;
//		String[] ids;
//		int a = 0;
//		String deleteName = null;
//		if (tableName.equals("FM")) {
//			tableName = "d_r_fun_manager";
//			deleteName = "function_id";
//			Function function = (Function) session.getAttribute("function");
//			id = function.getFunction_id();
//			ids = request.getParameterValues("manager_id");
//			List<FManager> list = new ArrayList<>();
//
//			a = service.delete1(tableName,id,deleteName);
//			if (ids!=null) {
//				for (int i = 0; i < ids.length; i++) {
//					FManager fm = new FManager();
//					fm.setFunction_id(id);
//					fm.setManager_id(ids[i]);
//					list.add(fm);
//				}
//				a = service.add(list,tableName);
//				System.out.println(list);
//			}
//		}
//		
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
