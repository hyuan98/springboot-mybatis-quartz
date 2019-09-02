package yuanian.service;

import yuanian.pojo.User;
import yuanian.utils.MessageBean;
import yuanian.utils.PageVo;

public interface UserService {

	MessageBean<User> findAllUser();

	MessageBean<User>  findUserBycode(Integer usercode);

	void insterUser(User user);

}
