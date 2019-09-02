package yuanian.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yuanian.mapper.UserMapper;
import yuanian.pojo.User;
import yuanian.service.UserService;
import yuanian.utils.MessageBean;
import yuanian.utils.PageVo;


@Service
public class UserServiceImpl implements UserService {

	
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public MessageBean<User> findAllUser() {
		
		return new MessageBean<>("1", "数据已找到", userMapper.findAllUser());
	}
	@Override
	public MessageBean<User> findUserBycode(Integer usercode) {

		return new MessageBean<>("1", "数据已找到", userMapper.findUserBycode(usercode));
	}
	@Override
	public 	void insterUser(User user){
		this.userMapper.insterUser(user);
	}
}
