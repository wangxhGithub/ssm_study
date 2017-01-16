package com.hjwang.service;

import java.util.List;

import com.hjwang.model.User;

public interface UserServiceI {
	List<User> getAll();
	
	User selectByPrimaryKey(String id);
	
    int insert(User muser);
    
    int update(User muser);
    
    int delete(String id);
}
