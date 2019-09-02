package yuanian.quartz;


import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import net.sf.json.JSONObject;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import yuanian.controller.UserController;
import yuanian.controller.UsercodeController;
import yuanian.pojo.User;
import yuanian.pojo.Usercode;
import yuanian.service.UserService;
import yuanian.service.UsercodeService;
import yuanian.utils.MessageBean;

import java.util.Date;
import java.util.List;

/**
 * Job类
 *
 *
 */
@CrossOrigin
@RestController
public class QuartzDemo implements Job {
	
	@Autowired
	private UserService userService;
	@Autowired
	private UsercodeService usercodeService;
	@Autowired
	private UserController userController;
	@Autowired
	private UsercodeController usercodeController;
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		System.out.println("Execute...."+new Date().toLocaleString());

		String myuser = restTemplate.getForObject("http://192.168.51.153:8080/findAllUser", String.class);
		JSONObject jsonObject = JSONObject.fromObject(myuser);
		String data = jsonObject.getString("dataList");
		Gson gson = new Gson();
		List<User> users = null;
		try {
			users = gson.fromJson(data, new TypeToken<List<User>>(){}.getType());
		} catch (Exception e) {

		}
		String result = gson.toJson(users);
		System.out.println("xixi"+result);


//		MessageBean<User> msg=this.userService.findAllUser();
//		System.out.println(msg.getDataList());

		String postusers=this.postuser();
		System.out.println("haha"+postusers);
        List<User> list = JSON.parseArray(postusers, User.class);
        for (User user:list) {
			MessageBean<User> userbean=this.userService.findUserBycode(user.getUsercode());

			List<User> dataList = userbean.getDataList();
			if (dataList.size()==0){
				//没有数据执行插入
				this.userController.addUser(user);
			}
			 Usercode usercode=this.usercodeService.findUsercodeByid(user.getUsercode());
			 if (usercode == null){
			 	Usercode usercode1=new Usercode();
			 	usercode1.setUsercode(user.getUsercode());
				 this.usercodeController.addUser(usercode1);
			 }
        }



	}
    @PostMapping("/postHisUser")
	public String postuser( ){
		MultiValueMap<String, Object> postParameters = new LinkedMultiValueMap<>();
		String user= restTemplate.postForObject("http://192.168.51.56:8080/user/findUserAll",
				postParameters, String.class);

		return user;
	}
	@GetMapping("/HAHA")
	public String postuser1( ){
		MultiValueMap<String, Object> postParameters = new LinkedMultiValueMap<>();
		String user= restTemplate.getForObject("http://192.168.51.56:8080/user/findUserAll",
				String.class);

		return user;
	}
}
