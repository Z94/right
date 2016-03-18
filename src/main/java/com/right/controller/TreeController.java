package com.right.controller;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.right.entity.Org;
import com.right.entity.TreeNode;
import com.right.service.TreeService;

@Controller
public class TreeController {
	
	@Resource
	TreeService tree;
	
	
	
	@RequestMapping("funcationTree")
	public ModelAndView toTree(HttpServletRequest request,HttpSession session){  	  
		String userId = (String) session.getAttribute("userId");
		String userType=String.valueOf(session.getAttribute("userType")); //用户类型
		  String userName=(String)session.getAttribute("userName");	 //用户名
		  String userOrgId=String.valueOf( session.getAttribute("userDep"));	  //部门id
		  String userOrgName = tree.getOrgName(userOrgId);	  //部门名
		  
//		  Org org = tree.getOrg("6");
//		  String name = org.getOrg_name();
//		  String userRightControl=(String)session.getAttribute("userRightControl");	

		  if(userType.equals("0")){  //是普通用户
		    tree.repaire_for_comuser(userId,userType);
		  }else{                      //是管理员
		    tree.repaire_for_manager(userId,userOrgName,userType);
		  }  
		request.setAttribute("userId", userId); 
		request.setAttribute("userName", userName);  
		request.setAttribute("tree", tree.beginTrack(tree.getRoot(false)));
		System.out.println("userType"+userType);
		System.out.println("userDepId"+userOrgId);
		System.out.println("userOrgName"+userOrgName);
		return new ModelAndView("funcationTree");
//		if(userType.equals("0"))  //是普通用户
//			tree.repaire_for_comuser(userId);
//		else                      //是管理员
//			tree.repaire_for_manager(userId,userDepName);
//		tree.beginTrack(tree.getRoot(false));
//		Vector vec = (Vector)(tree.repaire_for_manager());
//		Iterator iterator = vec.iterator(); 
//		while(iterator.hasNext()){ 
//			TreeNode treenode = (TreeNode)iterator.next();
//			request.setAttribute("treenode", treenode);
//		}
//		request.setAttribute("vec", vec);
		
//		List<Map<String, Object>> moduleMaps = tree.getModuleHashMap();
//		Object[][] array = new Object[moduleMaps.size()][6];
//		for (int i = 0; i < moduleMaps.size(); i++) {
//
//			Map<String, Object> map = moduleMaps.get(i);
//			Set<String> set =  map.keySet();
//			Iterator<String> it = set.iterator();
//			for (int j = 0; j < 6; j++) {
//				array[i][j]= map.get(it.next());
//				System.out.println("  "+array[i][j]);
//			}
//		}
//		
//		String[][] aStrings= new String[moduleMaps.size()][6]; 
//		for (int i = 0; i < moduleMaps.size(); i++) {
//			for (int j = 0; j < 6; j++) {
//				aStrings[i][j]=(String) array[i][j];
//				System.out.println("aaa"+aStrings[i][j]);
//			}
//		}
//		request.setAttribute("moduleMaps", moduleMaps);
//		return new ModelAndView("funcationTree");
		
//		for (Map<String,Object> map : moduleMaps) {
//			for(int i=0;i<6;i++){
//			for (String k : map.keySet()) {
//			        array[0][i] = k;
//			        System.out.println(i+"  "+array[0][i]);
//			    }
//			}
//			Set<String> set =  map.keySet();
//			Iterator<String> it = set.iterator();
			
//			for (int i = 0; i < array.length; i++) {
//				System.out.println("aaa"+it.next());
//				System.out.println("bbb"+map.get(it.next()));
//				array[0][i] = it.next();
//				for (int j = 0; j < 6; j++) {
//					array[0][j]= map.get(it.next());
//					System.out.println("  "+array[0][j]);
//				}
				
				
				
//			}
//			for (int i = 0; i < array.length; i++) {
//				for (int j = 0; j < 6; j++) {
//					System.out.println(array[i][j]);
//				}
//			}
			
		}
		
//		System.out.println("asa"+array[0][0]);
//		System.out.println("asa"+array[0][1]);
//		System.out.println("asa"+array[1][0]);
//		System.out.println("asa"+array[1][1]);
//	    for(int i=0;i<moduleMaps.size();i++){
//	        array[i] = moduleMaps.get(i).values().toArray();
//	        System.out.println(array[i]);
//	    }
//		Set<String> set =  moduleMaps.keySet();
//		  Iterator<String> it = set.iterator();
//		  String[][] ss = new String[moduleMaps.size()][2];
//		  for (int i = 0; i < moduleMaps.size(); i++) {
//		   ss[i][0] = it.next();
////		   ss[i][1] = (String)moduleMaps.get(ss[i][0]);
//		   System.out.println(ss[i][0]);
//		  }
//		  for (int i = 0; i < ss.length; i++) {
//		   for (int j = 0; j < ss[i].length; j++) {
//		    System.out.print(ss[i][j]+"\t");
//		   }
//		   System.out.println();
//		  }
//		String[][] ss = new String[moduleMaps.size()][2];
//		for (Map<String, Object> module : moduleMaps) {
//		    for (String k : module.keySet()) {
//		    	for (int i = 0; i < moduleMaps.size(); i++) {
//		 		   ss[i][0] = k.next();
////		 		   ss[i][1] = (String)moduleMaps.get(ss[i][0]);
//		 		   System.out.println(ss[i][0]);
//		 		  }
//		        System.out.println(k + " : " + module.get(k));
//		        System.out.println("           "+aStrings[0][0]);
//		    }
//		}
//		for (int i = 0; i < aStrings.length; i++) {
//			for (int j = 0; j < aStrings.length; j++) {
//				System.out.println("dadasd"+aStrings[i][j]);
//			}
//		}
//		request.setAttribute("moduleMaps", moduleMaps);
//		return new ModelAndView("funcationTree");
//		
//	}
}
