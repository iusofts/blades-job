package com.iusofts.blades.job.event;

import com.iusofts.blades.job.interfaces.ScheduleJobInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * 定时任务初始化
 */
@Component
public class ScheduleJobInit {

    /** 日志对象 */
    private static final Logger LOG = LoggerFactory.getLogger(ScheduleJobInit.class);

    /** 定时任务service */
    @Autowired
    private ScheduleJobInterface scheduleJobService;

    /**
     * 项目启动时初始化
     */
    @PostConstruct
    public void init() {

        if (LOG.isInfoEnabled()) {
            LOG.info("init");
        }

        //scheduleJobService.initScheduleJob();

        if (LOG.isInfoEnabled()) {
            LOG.info("end");
        }
    }

}
