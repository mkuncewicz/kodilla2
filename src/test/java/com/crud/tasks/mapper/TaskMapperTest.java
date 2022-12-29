package com.crud.tasks.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskMapperTest {

    private final TaskMapper taskMapper = new TaskMapper();


    @Test
    void DtoToDomain(){

        //Given
        TaskDto taskDto = new TaskDto(5L,"titleTest","conTest");

        //When
        Task task = taskMapper.mapToTask(taskDto);

        //Then
        assertEquals(5L,task.getId());
        assertEquals("titleTest",task.getTitle());
        assertEquals("conTest",task.getContent());
    }

    @Test
    void DomainToDto(){

        //Given
        Task task = new Task(5L,"test2","cos");
        List<Task> list = new ArrayList<>();
        list.add(task);

        //When
        TaskDto taskDto = taskMapper.mapToTaskDto(task);
        List<TaskDto> listDto = taskMapper.mapToTaskDtoList(list);

        //Then
        String title = listDto.get(0).getTitle();
        assertEquals(5L,taskDto.getId());
        assertEquals("test2", title);
    }
}
