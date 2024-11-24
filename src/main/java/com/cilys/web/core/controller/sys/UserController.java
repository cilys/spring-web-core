package com.cilys.web.core.controller.sys;

import com.cilys.web.core.controller.BaseController;
import com.cilys.web.core.service.CommonService;
import com.cilys.web.core.service.UserService;
import com.cilys.web.core.utils.MapKit;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2024/11/20.
 */
@Controller
@RequestMapping("/sys/user")
public class UserController extends BaseController{

    @Resource
    UserService userService;

    @RequestMapping("/login")
    @ResponseBody
    public Map<String, Object> login(String userName, String pwd
            , @RequestParam(value = "vCode", required = false) String vCode) {
        userService.login(userName, pwd);

        return new MapKit<Object>().add("userName", userName)
            .add("pwd", pwd).add("vCode", vCode).build();
    }

}
