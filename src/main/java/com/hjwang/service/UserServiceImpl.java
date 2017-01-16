package com.hjwang.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hjwang.dao.UserMapper;
import com.hjwang.model.User;

@Service("userService")
public class UserServiceImpl implements UserServiceI {

	private UserMapper userMapper;

	public UserMapper getuserMapper() {
		return userMapper;
	}

	@Autowired
	public void setuserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}
	
	@Override
	public List<User> getAll() {
		
		return userMapper.getAll();
	}

	@Override
	public int insert(User User) {
		
		return userMapper.insert(User);
	}

	@Override
	public int update(User User) {
		
		return userMapper.updateByPrimaryKey(User);
	}

	@Override
	public int delete(String id) {
	
		return userMapper.deleteByPrimaryKey(id);
	}

	@Override
	public User selectByPrimaryKey(String id) {
		
		return userMapper.selectByPrimaryKey(id);
	}

}
