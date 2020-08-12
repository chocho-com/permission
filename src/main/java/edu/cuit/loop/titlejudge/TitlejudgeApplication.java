package edu.cuit.loop.titlejudge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;


@SpringBootApplication
@MapperScan("edu.cuit.loop.titlejudge.mapper")
public class TitlejudgeApplication {

    public static void main(String[] args) {
        SpringApplication.run(TitlejudgeApplication.class, args);
    }
}
