package com.taskflow.backend.controller;

import com.taskflow.backend.dto.TaskRequestDTO;
import com.taskflow.backend.dto.TaskResponseDTO;
import com.taskflow.backend.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @PostMapping
    public TaskResponseDTO create(@RequestBody TaskRequestDTO dto) {
        return taskService.createTask(dto);
    }

    @GetMapping
    public List<TaskResponseDTO> getMyTasks() {
        return taskService.getMyTasks();
    }

    @PutMapping("/{id}")
    public TaskResponseDTO update(@PathVariable Long id,
                                  @RequestBody TaskRequestDTO dto) {
        return taskService.updateTask(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        taskService.deleteTask(id);
    }
}
