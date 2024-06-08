package com.schedule.test.mapper;

import com.schedule.test.dto.ScheduleDto;
import com.schedule.test.entity.Schedule;

public class ScheduleMapper {
    public static ScheduleDto mapToScheduleDto(Schedule schedule) {
        return new ScheduleDto(
                schedule.getId(),
                schedule.getClassName(),
                schedule.getDate(),
                schedule.getProfessor()
        );
    }
    public static Schedule mapToSchedule(ScheduleDto scheduleDto) {
        return new Schedule(
                scheduleDto.getId(),
                scheduleDto.getClassName(),
                scheduleDto.getDate(),
                scheduleDto.getProfessor()
        );
    }
}
