package com.schedule.test.reporsitory;

import com.schedule.test.entity.Schedule;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> { }
