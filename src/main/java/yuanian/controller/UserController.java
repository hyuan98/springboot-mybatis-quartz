package yuanian.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.client.RestTemplate;
import yuanian.pojo.User;
import yuanian.service.UserService;
import yuanian.utils.MessageBean;

import java.util.ArrayList;
import java.util.List;


@CrossOrigin
@RestController
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
    private RestTemplate restTemplate;
    @RequestMapping({ "/", "/index" })
    public String TestDemo() {
    	
    	System.out.println("ssss");
    	return "home";
    }
    //get请求调用自己服务器
@RequestMapping("/user2")
public String user2() {
    String user = restTemplate.getForObject("http://192.168.51.153:8080/findUserBycode/1", String.class);
    JSONObject jsonObject = JSONObject.fromObject(user);
    String data = jsonObject.getString("dataList");
    Gson gson = new Gson();
    List<User> users = null;
    try {
        users = gson.fromJson(data, new TypeToken<List<User>>(){}.getType());
    } catch (Exception e) {

    }
   String result = gson.toJson(users);
        return result;
  }
  //post请求调用他人服务器
    @PostMapping("/postotheruser")
    public String postotheruser( Integer usercode){
        MultiValueMap<String, Object> postParameters = new LinkedMultiValueMap<>();
        postParameters.add("usercode", usercode);


        String user= restTemplate.postForObject("http://192.168.51.124:8080/findEmployees",
                postParameters, String.class);
        return user;
    }
    //post请求调用自己服务器
  @PostMapping("/postuser")
     public String postuser( Integer usercode){
      MultiValueMap<String, Object> postParameters = new LinkedMultiValueMap<>();
      postParameters.add("usercode", usercode);
      String user= restTemplate.postForObject("http://192.168.51.153:8080/findUserBycodePost",
              postParameters, String.class);
      JSONObject jsonObject = JSONObject.fromObject(user);
      String data = jsonObject.getString("dataList");
      Gson gson = new Gson();
      List<User> users = null;
      try {
          users = gson.fromJson(data, new TypeToken<List<User>>(){}.getType());
      } catch (Exception e) {
      }
      String result = gson.toJson(users);
      return result;
  }
    @GetMapping("/findAllUser")
    public MessageBean<User> findAllUser() {

    	return userService.findAllUser();
    }
    @PostMapping("/findAllUser1")
    public MessageBean<User> findAllUser1() {

        return userService.findAllUser();
    }

   @GetMapping("/findUserBycode/{usercode}")
    public MessageBean<User> findUserBycode(@PathVariable("usercode") Integer usercode){
        return  userService.findUserBycode(usercode);
   }

   @PostMapping("/findUserBycodePost")
    public MessageBean<User> findUserBycode1 (Integer usercode){

        return  userService.findUserBycode(usercode);
    }
   public  void  addUser(User user){
        this.userService.insterUser(user);
   }
}
