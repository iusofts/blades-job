package com.iusofts.blades.job.service;

import com.iusofts.blades.job.interfaces.ScheduleJobInterface;
import com.iusofts.blades.job.BaseTest;
import com.iusofts.blades.job.common.page.PagingResult;
import com.iusofts.blades.job.common.util.JsonUtils;
import com.iusofts.blades.job.vo.AddRepeatJobParamVo;
import com.iusofts.blades.job.vo.ScheduleJobVo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Ivan Shen on 2017/11/5.
 */
public class ScheduleJobServiceTest extends BaseTest{

    @Autowired
    private ScheduleJobInterface scheduleJobInterface;

    @Test
    public void initScheduleJob() throws Exception {
    }

    @Test
    public void insert() throws Exception {
        AddRepeatJobParamVo scheduleJobVo = new AddRepeatJobParamVo();
        scheduleJobVo.setJobName("test1");
        scheduleJobVo.setJobGroup("test");
        scheduleJobVo.setAliasName("测试任务");
        scheduleJobVo.setCronExpression("0 0/1 * * * ?");
        scheduleJobVo.setIsSync(1);
        scheduleJobVo.setUrl("www.baidu.com");
        scheduleJobVo.setRequestParam("{id:01}");
		this.scheduleJobInterface.addRepeatJob(scheduleJobVo);
    }

    @Test
    public void insert2() throws Exception {
        for (int i = 1; i <= 10; i++) {
            AddRepeatJobParamVo scheduleJobVo = new AddRepeatJobParamVo();
            scheduleJobVo.setJobName("test"+i);
            scheduleJobVo.setJobGroup("test");
            scheduleJobVo.setAliasName("测试任务"+i);
            scheduleJobVo.setCronExpression("0 0/10 * * * ?");
            scheduleJobVo.setIsSync(1);
            scheduleJobVo.setUrl("www.baidu.com");
            scheduleJobVo.setRequestParam("{id:01}");
            this.scheduleJobInterface.addRepeatJob(scheduleJobVo);
            System.out.println(i);
        }
    }

    @Test
    public void update() throws Exception {

    }

    @Test
    public void delUpdate() throws Exception {
    }

    @Test
    public void delete() throws Exception {
    }

    @Test
    public void runOnce() throws Exception {
    }

    @Test
    public void pauseJob() throws Exception {
    }

    @Test
    public void resumeJob() throws Exception {
        this.scheduleJobInterface.resumeJob(1L);
    }

    @Test
    public void get() throws Exception {
    }

    @Test
    public void queryList() throws Exception {
        PagingResult<ScheduleJobVo> scheduleJobVoList = this.scheduleJobInterface.queryList(null);
        System.out.println(JsonUtils.obj2json(scheduleJobVoList));
    }

    @Test
    public void queryExecutingJobList() throws Exception {
    }

}