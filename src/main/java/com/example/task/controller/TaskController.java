package com.example.task.controller;

import com.example.task.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author BaoZhou
 * @date 2018/6/7
 */
@RestController
public class TaskController {
    @Autowired
    TaskService taskService;
    @GetMapping("/async")
    public String AsyncTask()
    {
        taskService.AsyncTask();
        return "处理完成";
    }
}
