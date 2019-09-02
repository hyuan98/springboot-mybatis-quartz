package yuanian.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import yuanian.pojo.User;

@Mapper
public interface UserMapper {

	List<User> findAllUser();
	
    List<User> findUserBycode(Integer usercode);

    void insterUser(User user);
}
