# 任务重试机制说明

## 重试时间间隔
预定义重试间隔（单位：秒），分为10个间隔：
{1 \*60, 5\*60, 10\*60, 30\*60, 60\*60, 2\*3600, 5\*3600, 10\*600, 15\*3600, 24\*3600}

nextFireTime(下次重试时间) = intervalTime（本次重试间隔） - preIntervalTime（上次重试间隔）

## 一次性任务重试机制
- 调用方可以指定重试次数，0代表不重试，最大为10次
- 每次重建一次性任务会自动清除重试的任务

## 重复任务重试机制
- 调用方可以指定重试次数，0代表不重试，最大努力重试次数为10次
- 如果重复任务的下一次周期小于下次重试时间，将取消重试任务，另外如果重复任务的重试周期不大于1分钟则不启动重试机制
- 每次重建重复任务会自动清除重试的任务

## monitor
![monitor](http://blades.img.iusofts.com/job/job-monitor.png)
## index
![index](http://blades.img.iusofts.com/job/job-index.png)
## list
![list](http://blades.img.iusofts.com/job/job-list.png)
## add
![add](http://blades.img.iusofts.com/job/job-add.png)
## detail
![detail](http://blades.img.iusofts.com/job/job-detail.png)
## log
![log](http://blades.img.iusofts.com/job/job-log.png)
