package com.iusofts.blades.job.dao;

import com.iusofts.blades.job.model.ScheduleJobLog;
import com.iusofts.blades.job.model.ScheduleJobLogExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleJobLogDao {
    int countByExample(ScheduleJobLogExample example);

    int deleteByExample(ScheduleJobLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ScheduleJobLog record);

    int insertSelective(ScheduleJobLog record);

    List<ScheduleJobLog> selectByExample(ScheduleJobLogExample example);

    ScheduleJobLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ScheduleJobLog record, @Param("example") ScheduleJobLogExample example);

    int updateByExample(@Param("record") ScheduleJobLog record, @Param("example") ScheduleJobLogExample example);

    int updateByPrimaryKeySelective(ScheduleJobLog record);

    int updateByPrimaryKey(ScheduleJobLog record);
}