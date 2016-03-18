package com.right.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.mysql.jdbc.UpdatableResultSet;
import com.right.entity.Function;
import com.right.entity.Manager;
import com.right.entity.Module;
import com.right.entity.Role;
import com.right.entity.User;
import com.right.service.UserService;

@Controller
public class UserController {
	@Resource
	HttpServletRequest request;
	@Resource
	HttpSession session;
	@Resource
	UserService service;
	@RequestMapping(value = "user_update")
	public ModelAndView toUser_updatePage(){
		return new ModelAndView("User/user_update");
	}
	@RequestMapping(value = "user_function")
	public ModelAndView toUser_functionPage(){
		
		String loginId = String.valueOf(session.getAttribute("userId"));
		User user = (User) session.getAttribute("user");
		int user_id = Integer.parseInt(String.valueOf(user.getUser_id()));
		List<String> list = service.getFunctionList(user_id);
		System.out.println("++++list++++"+list);
			List<Function> name = service.getFunction_name(list);
			request.setAttribute("name", name); 
			
			List<String> function_id = service.getFunction_id(loginId,list);
			List<Function> function_name = service.getFunction_name(function_id);
			request.setAttribute("function_name", function_name);
		return new ModelAndView("User/user_function");
	}
	@RequestMapping(value = "user_module")
	public ModelAndView toUser_modulePage(){
		String loginId = String.valueOf(session.getAttribute("userId"));
		User user = (User) session.getAttribute("user");
		int user_id = Integer.parseInt(String.valueOf(user.getUser_id()));
		
		List<String> list = service.getModuleList(user_id);
		System.out.println("++++list++++"+list);
			List<Module> name = service.getModule_name(list);
			request.setAttribute("name", name); 
		List<String> module_id = service.getModule_id(loginId,list);
		System.out.println("++++"+module_id);
		
		List<Module> module_name = service.getModule_name(module_id);
		System.out.println("++++"+module_name);
		request.setAttribute("module_name", module_name);
		return new ModelAndView("User/user_module");
	}
	@RequestMapping(value = "user_role")
	public ModelAndView toUser_rolePage(){
		User user = (User) session.getAttribute("user");
		int user_id = Integer.parseInt(String.valueOf(user.getUser_id()));
		List<String> list = service.getRoleList(user_id);
		System.out.println("++++list++++"+list);
			List<Role> name = service.getRole_name1(list);
			request.setAttribute("name", name); 
			
		List<Integer> org_id = service.getOrg_id(user_id);
		List<Integer> role_id = service.getRole_id(list,org_id);
		List<Role> role_name = service.getRole_name(role_id);
		request.setAttribute("role_name", role_name);
		return new ModelAndView("User/user_role");
	}
	
	
	@RequestMapping(value = "user_select")
	public ModelAndView toUser_selectPage(){
		return new ModelAndView("User/user_select");
	}
	
	@RequestMapping(value = "user_photo")
	public ModelAndView toUser_photoPage(){
		return new ModelAndView("User/user_photo");
	}
	@RequestMapping("Up")
	public String UpdatableResultSet(@RequestParam("imageFile") MultipartFile imageFile,HttpServletRequest request){
		
		String upLoadUrl = request.getSession().getServletContext().getRealPath("/") + "upload\\";
		String fileName = imageFile.getOriginalFilename();
		File dir = new File(upLoadUrl);
		if (!dir.exists()) {
			dir.mkdirs();
		}
		String fileUrl = upLoadUrl + fileName;
		System.out.println(upLoadUrl);
		System.out.println("文件上传到："+ fileUrl);
		
		File targetFile = new File(upLoadUrl+fileName);
		if (!targetFile.exists()) {
			try {
				targetFile.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		try {
			imageFile.transferTo(targetFile);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("fileUrl", fileUrl);
		return "User/user_photo";
	}
	@RequestMapping("userAdd")
	public ModelAndView toReceivePage(User user,HttpServletRequest request){
		System.out.println(user);
		int a = service.add(user);
		boolean result = false;
		if (a==-2147482646) {
			result = true;
		}
		request.setAttribute("result", result);
		System.out.println("++++++"+a);
		return new ModelAndView("Common/FormReceiveJSP");
	}
	
	@RequestMapping("userUpdate")
	public ModelAndView toUpdatePage(User user,HttpServletRequest request){
		System.out.println(user);
		int a = service.update(user);
		boolean result = false;
		if (a==-2147482646) {
			result = true;
		}
		request.setAttribute("result", result);
		System.out.println("++++++"+a);
		return new ModelAndView("Common/FormReceiveJSP");
	}
}
