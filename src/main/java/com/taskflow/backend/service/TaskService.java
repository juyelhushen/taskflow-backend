package com.taskflow.backend.service;

import com.taskflow.backend.dto.TaskRequestDTO;
import com.taskflow.backend.dto.TaskResponseDTO;
import com.taskflow.backend.entity.Task;
import com.taskflow.backend.entity.User;
import com.taskflow.backend.respository.TaskRepository;
import com.taskflow.backend.security.SecurityUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;
    private final SecurityUtils securityUtils;

    public TaskResponseDTO createTask(TaskRequestDTO dto) {

        User user = securityUtils.getCurrentUser();

        Task task = Task.builder()
                .title(dto.title())
                .description(dto.description())
                .priority(dto.priority())
                .status(dto.status())
                .dueDate(dto.dueDate())
                .user(user)
                .build();

        Task saved = taskRepository.save(task);

        return mapToDTO(saved);
    }

    public List<TaskResponseDTO> getMyTasks() {

        User user = securityUtils.getCurrentUser();

        return taskRepository.findByUserId(user.getId())
                .stream()
                .map(this::mapToDTO)
                .toList();
    }

    public TaskResponseDTO updateTask(Long id, TaskRequestDTO dto) {

        User user = securityUtils.getCurrentUser();

        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        // 🔥 SECURITY CHECK
        if (!task.getUser().getId().equals(user.getId())) {
            throw new RuntimeException("Unauthorized");
        }

        task.setTitle(dto.title());
        task.setDescription(dto.description());
        task.setPriority(dto.priority());
        task.setStatus(dto.status());
        task.setDueDate(dto.dueDate());

        return mapToDTO(taskRepository.save(task));
    }

    public void deleteTask(Long id) {

        User user = securityUtils.getCurrentUser();

        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        // 🔥 SECURITY CHECK
        if (!task.getUser().getId().equals(user.getId())) {
            throw new RuntimeException("Unauthorized");
        }

        taskRepository.delete(task);
    }

    private TaskResponseDTO mapToDTO(Task task) {
        return TaskResponseDTO.builder()
                .id(task.getId())
                .title(task.getTitle())
                .description(task.getDescription())
                .priority(task.getPriority())
                .status(task.getStatus())
                .dueDate(task.getDueDate())
                .build();
    }
}
