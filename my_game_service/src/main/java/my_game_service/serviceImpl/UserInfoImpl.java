package my_game_service.serviceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import my_game_interface.bean.UserInfo;
import my_game_interface.service.IUserInfo;
import my_game_service.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;

@Service
public class UserInfoImpl implements IUserInfo{
    @Autowired
    public UserInfoMapper userInfoMapper;
    @Override
    public boolean loginCheck(UserInfo userInfo) {
//        int id = userInfoMapper.findUserInfo(userInfo.getuName(), userInfo.getPassWd());
        HashMap<String,String> paramMap=new HashMap<>();
        paramMap.put("uNama",userInfo.getuName());
        paramMap.put("passWd",userInfo.getPassWd());
        Integer id = userInfoMapper.findUserId(paramMap);
        if (id == null){
            return false;
        }else {
            return true;
        }
    }
}
