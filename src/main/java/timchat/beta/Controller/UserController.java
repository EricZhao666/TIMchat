package timchat.beta.Controller;

import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import timchat.beta.Mapper.UserMapper;
import timchat.beta.entiy.User;
import timchat.beta.component.JsonUtils;
import java.util.List;


@Controller
@Api
public class UserController {

    @Autowired
    UserMapper userMapper;


    @ApiOperation("登录功能")
    @RequestMapping(value = "/login", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Object login(@RequestParam("name") String name,@RequestParam("password") String pwd){
        User user=userMapper.findByName(name);
        if (user!=null){
            if (pwd.equals(user.getPassword())){
                return JSON.toJSONString(new JsonUtils(0,"登录成功"));
            }
            else{
                return JSON.toJSONString(new JsonUtils(-1,"密码错误"));
            }
        }
        else {
            return  JSON.toJSONString(new JsonUtils(-1,"用户名不存在"));
        }

    }

    @ResponseBody
    @ApiOperation("注册功能")
    @PostMapping("/regist")
    public Object regist(@RequestParam("name") String name,@RequestParam("pwd")String pwd) {

        User user=new User(name,pwd);
        User findUser=userMapper.findByName(name);
        if (findUser!=null){
            return JSON.toJSONString(new JsonUtils(-1,"用户名已被占用"));
        }
        else {
            userMapper.save(user);
            return JSON.toJSONString(new JsonUtils(0,"注册成功"));
        }


    }

    @RequestMapping(value = "/alluser", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<User> findAll(){
        List<User> list = userMapper.findAll();
        return list;
    }




    }
