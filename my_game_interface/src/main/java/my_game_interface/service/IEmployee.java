package my_game_interface.service;


import my_game_interface.bean.Employee;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

public interface IEmployee {
    public String findLastName(int id);
}
