package com.yueqiangu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 启动程序
 *
 * @author yueqiangu
 */
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class ProjectBudgetApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(ProjectBudgetApplication.class, args);
    }
}
