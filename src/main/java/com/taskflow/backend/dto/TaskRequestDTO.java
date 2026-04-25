package com.taskflow.backend.dto;

import com.taskflow.backend.entity.TaskPriority;
import com.taskflow.backend.entity.TaskStatus;

import java.time.LocalDateTime;

public record TaskRequestDTO(

        String title,
        String description,
        TaskPriority priority,
        TaskStatus status,
        LocalDateTime dueDate

) {
}
