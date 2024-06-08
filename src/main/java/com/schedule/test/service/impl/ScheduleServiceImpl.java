package com.schedule.test.service.impl;

import com.schedule.test.dto.ScheduleDto;
import com.schedule.test.entity.Schedule;
import com.schedule.test.exception.ResourceNotFoundException;
import com.schedule.test.mapper.ScheduleMapper;
import com.schedule.test.reporsitory.ScheduleRepository;
import com.schedule.test.service.ScheduleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class ScheduleServiceImpl implements ScheduleService {

    private ScheduleRepository scheduleRepository;

    @Override
    public ScheduleDto createSchedule(ScheduleDto scheduleDto) {
        Schedule schedule = ScheduleMapper.mapToSchedule(scheduleDto);
        Schedule savedSchedule = scheduleRepository.save(schedule);
        return ScheduleMapper.mapToScheduleDto(savedSchedule);
    }

    @Override
    public ScheduleDto getScheduleById(Long scheduleId) {
        Schedule schedule = scheduleRepository.findById(scheduleId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Schedule record is not exist with given id : " + scheduleId));
        return ScheduleMapper.mapToScheduleDto(schedule);
    }

    @Override
    public List<ScheduleDto> getAllSchedules() {
        List<Schedule> schedules = scheduleRepository.findAll();
        return schedules.stream().map((schedule) -> ScheduleMapper.mapToScheduleDto(schedule))
                .collect(Collectors.toList());
    }

    @Override
    public ScheduleDto updateSchedule(Long scheduleId, ScheduleDto updatedSchedule) {
        Schedule schedule = scheduleRepository.findById(scheduleId).orElseThrow(
                () -> new ResourceNotFoundException("Schedule record is not exist with given id : " + scheduleId)
        );
        schedule.setClassName(updatedSchedule.getClassName());
        schedule.setDate(updatedSchedule.getDate());
        schedule.setProfessor(updatedSchedule.getProfessor());

        Schedule updatedScheduleObj = scheduleRepository.save(schedule);
        return ScheduleMapper.mapToScheduleDto(updatedScheduleObj);
    }

    @Override
    public void deleteSchedule(Long scheduleId) {
        Schedule schedule = scheduleRepository.findById(scheduleId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Schedule record is not exist with given id : " + scheduleId));
        scheduleRepository.deleteById(scheduleId);
    }
}
