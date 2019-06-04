package my_game_service.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.Map;

public interface UserInfoMapper {
    //多参数通过@param注解，或者map传递
    public Integer findUserInfo(@Param(value ="uName") String uName,@Param(value ="passWd") String passWd);
    public Integer findUserId(Map paramMap);
}
