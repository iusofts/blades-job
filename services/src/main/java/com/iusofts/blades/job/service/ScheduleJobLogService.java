package com.iusofts.blades.job.service;

import com.iusofts.blades.job.common.page.PagingResult;
import com.iusofts.blades.job.common.util.ModelMapperUtil;
import com.iusofts.blades.job.dao.ScheduleJobLogDao;
import com.iusofts.blades.job.enums.DelFlagEnum;
import com.iusofts.blades.job.interfaces.ScheduleJobLogInterface;
import com.iusofts.blades.job.model.ScheduleJobLog;
import com.iusofts.blades.job.model.ScheduleJobLogExample;
import com.iusofts.blades.job.vo.QueryScheduleJobLogParamVo;
import com.iusofts.blades.job.vo.ScheduleJobLogVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 定时任务日志服务
 *
 * @author Ivan Shen
 */
@Service
public class ScheduleJobLogService implements ScheduleJobLogInterface {

	@Autowired
	private ScheduleJobLogDao scheduleJobLogDao;

	@Override
	public Long add(ScheduleJobLog scheduleJobLog) {
		scheduleJobLogDao.insertSelective(scheduleJobLog);
		return scheduleJobLog.getId();
	}

	@Override
	public void remove(Long logId) {
		ScheduleJobLog scheduleJobLog = new ScheduleJobLog();
		scheduleJobLog.setId(logId);
		scheduleJobLog.setDeleteFlag(DelFlagEnum.DELETED.getCode());
		this.scheduleJobLogDao.updateByPrimaryKeySelective(scheduleJobLog);
	}

	@Override
	public ScheduleJobLogVo getById(Long logId) {
		ScheduleJobLog scheduleJobLog = this.scheduleJobLogDao.selectByPrimaryKey(logId);
		if (scheduleJobLog != null) {
			return ModelMapperUtil.strictMap(scheduleJobLog, ScheduleJobLogVo.class);
		}
		return null;
	}

	@Override
	public ScheduleJobLogVo getByJobId(Long scheduleJobId) {
        ScheduleJobLogExample example = new ScheduleJobLogExample();
        example.createCriteria().andDeleteFlagEqualTo(DelFlagEnum.UN_DELETED.getCode()).andJobIdEqualTo(scheduleJobId);
        example.setOrderByClause("create_time desc");
        example.setLimitSize(1);
        List<ScheduleJobLog> scheduleJobLogList = this.scheduleJobLogDao.selectByExample(example);
        if(scheduleJobLogList.size()>0){
            return ModelMapperUtil.strictMap(scheduleJobLogList.get(0), ScheduleJobLogVo.class);
        }
		return null;
	}

	@Override
	public PagingResult<ScheduleJobLogVo> queryList(QueryScheduleJobLogParamVo paramVo) {
        PagingResult<ScheduleJobLogVo> pagingResult = new PagingResult<>();
        ScheduleJobLogExample example = new ScheduleJobLogExample();
		ScheduleJobLogExample.Criteria criteria = example.createCriteria();
		criteria.andDeleteFlagEqualTo(DelFlagEnum.UN_DELETED.getCode()).andJobIdEqualTo(paramVo.getJobId());
        if(paramVo.getStatus()!=null){
			criteria.andStatusEqualTo(paramVo.getStatus());
		}

        pagingResult.setTotalCount(this.scheduleJobLogDao.countByExample(example));
        pagingResult.setTotalPage(pagingResult.getTotalCount() / paramVo.getPagination().getPageSize());

        example.setLimitStart((paramVo.getPagination().getCurrentPage() - 1) * paramVo.getPagination().getPageSize());
        example.setLimitSize(paramVo.getPagination().getPageSize());
        example.setOrderByClause("create_time desc");

        List<ScheduleJobLog> scheduleJobs = scheduleJobLogDao.selectByExample(example);
        List<ScheduleJobLogVo> scheduleJobVoList = ModelMapperUtil.strictMapList(scheduleJobs, ScheduleJobLogVo.class);
        pagingResult.setDataList(scheduleJobVoList);
        return pagingResult;
	}
}
