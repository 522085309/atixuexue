package my_game_service.serviceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import my_game_interface.bean.Employee;
import my_game_interface.service.IEmployee;
import my_game_service.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class IEmployeeImpl implements IEmployee {
    @Autowired
    public EmployeeMapper employeeMapper;
    @Override
    public String findLastName(int id) {
        Employee employees = employeeMapper.getAllInfo();
        if(employees.getId()==id){
            return employees.getLastName();
        }
        return employees.getId().toString();
    }
}
