package com.taskflow.backend.dto;

import com.taskflow.backend.entity.TaskPriority;
import com.taskflow.backend.entity.TaskStatus;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record TaskResponseDTO(

        Long id,
        String title,
        String description,
        TaskPriority priority,
        TaskStatus status,
        LocalDateTime dueDate

) {
}
