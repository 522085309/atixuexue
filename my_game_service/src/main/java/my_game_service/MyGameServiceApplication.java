package my_game_service;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(value = "my_game_service.mapper")
@EnableDubbo
@SpringBootApplication
public class MyGameServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyGameServiceApplication.class, args);
	}

}
