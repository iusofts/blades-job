package com.iusofts.blades.job.root;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * 配置mapper的bean，数据库操作
 */
@Configuration
@MapperScan("com.iusofts.blades.job.dao")
public class DatabaseConfig {
}
