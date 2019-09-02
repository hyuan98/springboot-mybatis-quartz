package yuanian.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import yuanian.pojo.Usercode;
import yuanian.service.UsercodeService;
import yuanian.utils.MessageBean;

@CrossOrigin
@RestController
public class UsercodeController {
    @Autowired
    private UsercodeService usercodeService;

    public  void  addUser(Usercode usercode){
        this.usercodeService.insterUsercode(usercode);
    }

    @GetMapping("/findUserByid/{ucid}")
    public Usercode findUserByid(@PathVariable("ucid") Integer ucid){
        return  usercodeService.findUsercodeByid(ucid);
    }
}
