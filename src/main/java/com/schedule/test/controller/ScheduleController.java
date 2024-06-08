package com.schedule.test.controller;


import com.schedule.test.dto.ScheduleDto;
import com.schedule.test.entity.Schedule;
import com.schedule.test.service.ScheduleService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@AllArgsConstructor
@RestController
@RequestMapping("/api/schedule")
public class ScheduleController {

    private ScheduleService scheduleService;

    @PostMapping
    public ResponseEntity<ScheduleDto> createSchedule(@RequestBody ScheduleDto scheduleDto) {
        ScheduleDto savedSchedule = scheduleService.createSchedule(scheduleDto);
        return new ResponseEntity<>(savedSchedule, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<ScheduleDto> getScheduleById(@PathVariable("id") Long scheduleId)
    {
        ScheduleDto schedule = scheduleService.getScheduleById(scheduleId);
        return ResponseEntity.ok(schedule);
    }

    @GetMapping
    public ResponseEntity<List<ScheduleDto>> getAllSchedules() {
        List<ScheduleDto> schedules = scheduleService.getAllSchedules();
        return ResponseEntity.ok(schedules);
    }

    @PutMapping("{id}")
    public ResponseEntity<ScheduleDto> updateSchedule(@PathVariable("id") Long scheduleId,
                                                      @RequestBody ScheduleDto updatedSchedule) {
        ScheduleDto schedule = scheduleService.updateSchedule(scheduleId, updatedSchedule);
        return ResponseEntity.ok(schedule);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteSchedule(@PathVariable("id") Long scheduleId) {
        scheduleService.deleteSchedule(scheduleId);
        return ResponseEntity.ok("Schedule record deleted successfully");
    }
}
