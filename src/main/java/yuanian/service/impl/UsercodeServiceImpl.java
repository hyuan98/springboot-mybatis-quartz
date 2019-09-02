package yuanian.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yuanian.mapper.UsercodeMapper;
import yuanian.pojo.Usercode;
import yuanian.service.UsercodeService;
@Service
public class UsercodeServiceImpl  implements UsercodeService {
    @Autowired
    private UsercodeMapper usercodeMapper;
    @Override
    public 	void insterUsercode(Usercode usercode){
        this.usercodeMapper.insterUsercode(usercode);
    }
    public  Usercode findUsercodeByid(Integer ucid){
      return this.usercodeMapper.findUsercodeByid(ucid) ;
    }
}
