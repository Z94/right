package com.right.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.right.entity.Manager;
import com.right.entity.User;
import com.right.service.LoginService;

@Controller
public class LoginController {

	@Resource
	LoginService service;
	@RequestMapping("index")
	public ModelAndView toLoginPage(){
		return new ModelAndView("login");
	}
	
	
//	@RequestMapping("login")
//	public ModelAndView toLoginSuccessPage(HttpServletRequest request){
//		String userName = request.getParameter("userName");
//		String password = request.getParameter("password");
//		
//		if(userName == null || "".equals(userName)){
//			return new ModelAndView("login","error","用户名不能为空!");
//		}
//		if(password == null || "".equals(password)){
//			return new ModelAndView("login","error","密码不能为空!");
//		}
//		
//		if (userName.startsWith("_")) {
//			List<Manager> managers = service.getManagerList(userName);
//			Manager m = service.getManager(userName);
//			if (password.equals(m.getManagerPwd())) {
//				return new ModelAndView("loginSuccess");
//			}
//			if (!managers.isEmpty()) {
//				for (Manager manager : managers) {
//					String upassword = manager.getManagerPwd();
//					if (password.equals(upassword)){
//						return new ModelAndView("loginSuccess");
//					}else {
//						return new ModelAndView("login","error","密码错误");
//					}
//				}
//			}else {
//					return new ModelAndView("login","error","当前用户名不存在");
//			}
//		}else {
//			List<User> users = service.getUserList(userName);
//			User u = service.getUser(userName);
//			if (password.equals(u.getPassword())) {
//				return new ModelAndView("loginSuccess");
//			}
//			if (!users.isEmpty()) {
//				for (User user : users) {   
//					String upassword = user.getPassword();
//					if (password.equals(upassword)) {
//						return new ModelAndView("loginSuccess");
//					}else {
//						return new ModelAndView("login","error","密码错误");
//					}
//				}
//			}else {
//				return new ModelAndView("login","error","当前用户名不存在");
//			}
//			
//		}
//		return new ModelAndView("login");
//	}
	
//	@RequestMapping("login")
//	public ModelAndView toLogin(HttpServletRequest request){
//		List<Map<String, Object>> moduleMaps = service.getMap();
//		request.setAttribute("moduleMaps", moduleMaps);
//		return new ModelAndView("aaa");
//	}
	@RequestMapping("login")
	public ModelAndView toLoginSuccessPage(HttpServletRequest request,HttpSession session){
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		
		if(userName == null || "".equals(userName)){
			return new ModelAndView("login","error","用户名不能为空!");
		}
		if(password == null || "".equals(password)){
			return new ModelAndView("login","error","密码不能为空!");
		}
		
		if (userName.startsWith("_")) {
			Manager manager = service.getManager(userName);
			if (manager!=null) {
				String pwd = manager.getManager_pwd();
				if (password.equals(pwd)) {
					
					List<Manager> managers = service.getManagerList();
					request.setAttribute("managers", managers);
					request.setAttribute("manager", manager);
					
					session.setAttribute("userType",1);//denglu用户类型          
					session.setAttribute("userId",manager.getManager_id());//denglu用户id
					session.setAttribute("userName",manager.getManager_name());//denglu用户名
					session.setAttribute("userDep",manager.getOrg_id());//denglu用户所在部门
					session.setAttribute("userRightControl",manager.getManager_control());//为用户是否受权限表控制	
					
					return new ModelAndView("loginSuccess");
				}else {
					return new ModelAndView("login","error","密码错误");
				}
			}else {
				return new ModelAndView("login","error","当前用户名不存在");
			}
		}else {
			User user = service.getUser(userName);
			if (user!=null) {
				String pwd = user.getPassword();
				if (password.equals(pwd)) {
					request.setAttribute("user", user);
					
					session.setAttribute("userType",0);//denglu用户类型          
					session.setAttribute("userId",user.getUser_id());//denglu用户id
					session.setAttribute("userName",user.getUser_name());//denglu用户名
					session.setAttribute("userDep",user.getOrg_id());//denglu用户所在部门
					
					return new ModelAndView("loginSuccess");
				}else {
					return new ModelAndView("login","error","密码错误");
				}
			}else {
				return new ModelAndView("login","error","当前用户名不存在");
			}
		}

	}
}
