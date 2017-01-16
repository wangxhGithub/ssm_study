package com.hjwang.controller;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hjwang.model.User;
import com.hjwang.service.UserServiceI;

@Controller
@RequestMapping("/userController")
public class UserController {

	private UserServiceI userService;

	public UserServiceI getUserService() {
		return userService;
	}

	@Autowired
	public void setUserService(UserServiceI userService) {
		this.userService = userService;
	}
	
	@RequestMapping(value="/listUser")
	public String listUser(HttpServletRequest request) {
		
		List <User> list = userService.getAll();
		request.setAttribute("userlist", list);
		return "listUser";
	}
	
	@RequestMapping(value="/toAddUser")
	public String toAdd(){
		return "addUser";
	}
	
	@RequestMapping(value="/addUser")
	public String addUser(User user) {
			
		String id = UUID.randomUUID().toString();
		user.setId(id);
		userService.insert(user);
		return "redirect:/userController/listUser.do";
	}
	
	@RequestMapping(value="/deleteUser")
	public String deleteUser(String id) {
		
		userService.delete(id);
		return "redirect:/userController/listUser.do";
	}
	
	@RequestMapping(value="/updateUserUI")
	public String updateUserUI(String id, HttpServletRequest request) {
		
		User user = userService.selectByPrimaryKey(id);
		request.setAttribute("user", user);
		return "updateUser";
	}
	
	@RequestMapping(value="/updateUser")
	public String updateUser(User muser) {
		
		userService.update(muser);
		return "redirect:/userController/listUser.do";
	}
	
	@ResponseBody
	@RequestMapping(value="/toJson")
	public User toJson(String id){
		User user = userService.selectByPrimaryKey(id);
		return user;
	}
}
