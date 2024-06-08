package com.schedule.test.service;

import com.schedule.test.dto.ScheduleDto;

import java.util.List;

public interface ScheduleService {
    ScheduleDto createSchedule(ScheduleDto scheduleDto);
    ScheduleDto getScheduleById(Long scheduleId);
    List<ScheduleDto> getAllSchedules();
    ScheduleDto updateSchedule(Long scheduleId, ScheduleDto updatedSchedule);
    void deleteSchedule(Long scheduleId);
}
