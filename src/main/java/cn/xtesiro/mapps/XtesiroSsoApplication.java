package cn.xtesiro.mapps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("cn.xtesiro.mapps.mapper")
public class XtesiroSsoApplication {

	public static void main(String[] args) {
		SpringApplication.run(XtesiroSsoApplication.class, args);
	}

}
