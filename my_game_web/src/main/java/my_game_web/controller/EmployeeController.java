package my_game_web.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import my_game_interface.bean.UserInfo;
import my_game_interface.service.IEmployee;
import my_game_interface.service.IUserInfo;
import my_game_interface.untils.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmployeeController {
    @Reference
    public IEmployee iEmployee;
    @Reference
    public IUserInfo iUserInfo;
    //测试
    @GetMapping(value = "/findEmp/{id}")
    @ResponseBody
    public String findEmp(@PathVariable(value = "id")Integer id){
        return iEmployee.findLastName(id);
    }

    /**
     * 登录
     */
    @RequestMapping(value = "/loginInfo")
    @ResponseBody
    public Result loginInfo(UserInfo userInfo){
        Result result=new Result();
        if(iUserInfo.loginCheck(userInfo)){
            result.setCode("0");
            result.setMsg("登录成功");
        }else {
            result.setCode("1");
            result.setMsg("erro");
        }
        return result;
    }
}
