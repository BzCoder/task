package com.example.task.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @author BaoZhou
 * @date 2018/6/7
 */
@Service
public class TaskService {
    @Async
    public void AsyncTask()
    {
        try {
            Thread.sleep(3000);
        }catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        System.out.println("处理数据中");
    }

    //在周一到周五的每整分钟，15秒，30秒，45秒运行任务
    @Scheduled(cron = "0,15,30,45 * * * * Mon-Fri")
    //在周一到周五 0-4秒每秒运行任务
    @Scheduled(cron = "0-4 * * * * Mon-Fri")
    //在周一到周五 从0秒启动，每4秒运行一次任务
    @Scheduled(cron = "0/4 * * * * Mon-Fri")
    //在周一到周五 从0秒启动，每4秒运行一次任务
    @Scheduled(cron = "0/4 * * * * Mon-Fri")
    //
    public void SchedulingTask()
    {
        System.out.println("数据输出");
    }
}
