/*全局配置*/
var host = '/blades-job';
var ctx = ''

// 任务列表接口
var jobListApi = host+ '/scheduleJob/queryList'
// 任务详情接口
var getJobDetailApi = host+ '/scheduleJob/getDetail'
// 任务运行一次接口
var runOnceApi = host+ '/scheduleJob/runOnce'
// 任务删除接口
var getJobRemoveApi = host+ '/scheduleJob/remove'
// 一次性任务添加接口
var addOnceJobApi = host+ '/scheduleJob/addOnceJob'
// 重复任务添加接口
var addRepeatJobApi = host+ '/scheduleJob/addRepeatJob'
// 重建一次性任务接口
var recreateOnceJobApi = host+ '/scheduleJob/recreateOnceJob'
// 重建重复任务接口
var recreateRepeatJobApi = host+ '/scheduleJob/recreateRepeatJob'
// 任务暂停接口
var pauseJobApi = host+ '/scheduleJob/pauseJob'
// 任务恢复接口
var resumeJobApi = host+ '/scheduleJob/resumeJob'
// 任务统计接口
var countApi = host+ '/scheduleJob/count'



// 任务日志列表接口
var jobLogListApi = host+ '/scheduleJobLog/queryList'
// 任务日志删除接口
var jobLogremoveApi = host+ '/scheduleJobLog/remove'