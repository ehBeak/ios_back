package com.example.ios_back.controller;

import com.example.ios_back.controller.dto.ScheduleDTO;
import com.example.ios_back.domain.Schedule;
import com.example.ios_back.domain.Subject;
import com.example.ios_back.service.HomeworkService;
import com.example.ios_back.service.ScheduleService;
import com.example.ios_back.service.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequiredArgsConstructor
@ResponseBody
public class HomeController {

    private final ScheduleService scheduleService;
    private final SubjectService subjectService;
    private final HomeworkService homeworkService;

    /*
     * 일정 조회 */
    @GetMapping("/schedule/date")
    public ScheduleDTO getSchedule(@RequestParam String date) {//2017-11-21
        LocalDate requestDate = LocalDate.parse(date);
        ScheduleDTO scheduleDTO = new ScheduleDTO();

        Schedule schedule = scheduleService.findSchedule(requestDate);

        List<Subject> subjectList = schedule.getSubjectList();
        for (Subject subject : subjectList) {
            subject.getHomeworkList().stream().
                    forEach(homework -> scheduleDTO.getHomeworkMap().put(subject.getName(), homework));
        }
        scheduleDTO.setMemo(schedule.getMemo());

        return scheduleDTO;
    }
}
