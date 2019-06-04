package my_game_service.mapper;


import com.alibaba.dubbo.config.annotation.Service;
import my_game_interface.bean.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

public interface EmployeeMapper {
     Employee getAllInfo();
}
