package com.app.todoapp.controller;

import com.app.todoapp.model.Task;
import com.app.todoapp.services.TaskServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private final TaskServices taskServices;

    public TaskController(TaskServices taskServices) {
        this.taskServices = taskServices;
    }

    @GetMapping
    public String getTasks(Model model){
        List<Task> tasks = taskServices.getAllTasks();
        model.addAttribute("tasks", tasks);
        System.out.println(tasks);
        return "tasks";
    }

    @PostMapping
    public String createTask(@RequestParam String title){
        taskServices.createTask(title);
        return "redirect:/tasks";
    }

    @GetMapping("/{id}/delete")
    public String deletetask(@PathVariable Long id){
        taskServices.deletetask(id);
        return "redirect:/tasks";
    }

    @GetMapping("/{id}/toggle")
    public String toggletask(@PathVariable Long id) {
        taskServices.toggletask(id);
        return "redirect:/tasks";
    }

}
