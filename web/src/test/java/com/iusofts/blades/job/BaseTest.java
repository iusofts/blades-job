package com.iusofts.blades.job;

import com.iusofts.blades.job.root.Application;
import com.iusofts.blades.job.root.DatabaseConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = Application.class)
@Import({DatabaseConfig.class})
@ComponentScan(basePackages={"com.iusofts.blades.job"})
public class BaseTest {

    @Test
    public void testStart(){

    }

}