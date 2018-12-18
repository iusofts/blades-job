package com.iusofts.blades.job.root;

import com.iusofts.blades.job.listener.ScheduleJobListener;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.matchers.EverythingMatcher;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.util.Properties;

/**
 * 配置任务调度中心
 * [QRTZ_JOB_DETAILS], [QRTZ_TRIGGERS] and [QRTZ_CRON_TRIGGERS]
 */
@Configuration
public class QuartzConfig {


    @Value("${quartz.datasource.driver}")
    String driver;
    @Value("${quartz.datasource.url}")
    String url;
    @Value("${quartz.datasource.username}")
    String username;
    @Value("${quartz.datasource.password}")
    String password;
    @Value("${quartz.datasource.maxconnections}")
    String maxConnections;


    @Bean
    public Scheduler scheduler() throws IOException, SchedulerException {
        SchedulerFactory schedulerFactory = new StdSchedulerFactory(quartzProperties());
        Scheduler scheduler = schedulerFactory.getScheduler();
        scheduler.start();
        // 绑定监听器
        scheduler.getListenerManager().addJobListener(new ScheduleJobListener(), EverythingMatcher.allJobs());
        return scheduler;
    }

    /**
     * 设置quartz属性
     *
     * @throws IOException
     */
    public Properties quartzProperties() throws IOException {
        Properties prop = new Properties();
        prop.put("quartz.scheduler.instanceName", "ServerScheduler");
        prop.put("org.quartz.scheduler.instanceId", "AUTO");
        prop.put("org.quartz.scheduler.skipUpdateCheck", "true");
        prop.put("org.quartz.scheduler.instanceId", "NON_CLUSTERED");
        prop.put("org.quartz.scheduler.jobFactory.class", "org.quartz.simpl.SimpleJobFactory");
        prop.put("org.quartz.jobStore.class", "org.quartz.impl.jdbcjobstore.JobStoreTX");
        prop.put("org.quartz.jobStore.driverDelegateClass", "org.quartz.impl.jdbcjobstore.StdJDBCDelegate");
        prop.put("org.quartz.jobStore.dataSource", "quartzDataSource");
        prop.put("org.quartz.jobStore.tablePrefix", "QRTZ_");
        prop.put("org.quartz.jobStore.isClustered", "true");
        prop.put("org.quartz.threadPool.class", "org.quartz.simpl.SimpleThreadPool");
        prop.put("org.quartz.threadPool.threadCount", "5");
        prop.put("org.quartz.jobStore.misfireThreshold", "60000");

        prop.put("org.quartz.dataSource.quartzDataSource.driver", driver);
        prop.put("org.quartz.dataSource.quartzDataSource.URL", url);
        prop.put("org.quartz.dataSource.quartzDataSource.user", username);
        prop.put("org.quartz.dataSource.quartzDataSource.password", password);
        prop.put("org.quartz.dataSource.quartzDataSource.maxConnections", maxConnections);

        return prop;
    }
}