CREATE TABLE `blades_schedule_job` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '任务ID',
  `sys_code` varchar(255) DEFAULT NULL COMMENT '系统代码',
  `job_type` int(11) DEFAULT NULL COMMENT '任务类型（1.一次性任务 2.重复任务）',
  `job_name` varchar(255) DEFAULT NULL COMMENT '任务名称',
  `alias_name` varchar(255) DEFAULT NULL COMMENT '任务别名',
  `job_group` varchar(255) DEFAULT NULL,
  `job_trigger` varchar(255) DEFAULT NULL,
  `status` varchar(255) NOT NULL DEFAULT '1' COMMENT '任务状态( 1 正常 2 暂停 3 完成 4 错误 5 阻塞 ）',
  `cron_expression` varchar(255) DEFAULT NULL,
  `execute_time` datetime DEFAULT NULL,
  `is_sync` int(11) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `request_param` varchar(255) DEFAULT NULL,
  `request_method` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `max_retry_num` int(11) DEFAULT NULL COMMENT '最大重试次数（0代表不重试）',
  `retried_num` int(11) DEFAULT NULL,
  `retry_status` int(11) DEFAULT NULL COMMENT '重试状态（0未重试 1重试中 2重试结束）',
  `total_run_num` int(11) DEFAULT NULL,
  `total_failed_num` int(11) DEFAULT NULL,
  `last_start_time` datetime(3) DEFAULT NULL,
  `last_end_time` datetime(3) DEFAULT NULL,
  `next_fire_time` bigint(20) DEFAULT NULL COMMENT '下次执行时间(毫秒数，-1表示无下次)',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `delete_flag` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) COMMENT='任务表';

CREATE TABLE `blades_schedule_job_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `job_id` bigint(20) NOT NULL COMMENT '任务ID',
  `url` varchar(255) DEFAULT NULL,
  `request_param` varchar(255) DEFAULT NULL,
  `request_method` varchar(255) DEFAULT NULL,
  `response` text,
  `status` varchar(255) DEFAULT NULL,
  `error_type` varchar(255) DEFAULT NULL,
  `error_msg` text,
  `start_time` datetime(3) DEFAULT NULL,
  `end_time` datetime(3) DEFAULT NULL,
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `delete_flag` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) COMMENT='任务日志表';