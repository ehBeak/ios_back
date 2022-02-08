package com.example.ios_back.controller;

import com.example.ios_back.controller.dto.ScheduleDTO;
import com.example.ios_back.controller.form.CreateMemoForm;
import com.example.ios_back.controller.form.CreateSubjectForm;
import com.example.ios_back.domain.Schedule;
import com.example.ios_back.domain.Subject;
import com.example.ios_back.repository.ScheduleRepository;
import com.example.ios_back.service.HomeworkService;
import com.example.ios_back.service.MemoService;
import com.example.ios_back.service.ScheduleService;
import com.example.ios_back.service.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@ResponseBody
public class HomeController {

    private final ScheduleService scheduleService;
    private final SubjectService subjectService;
    private final HomeworkService homeworkService;
    private final ScheduleRepository scheduleRepository;
    private final MemoService memoService;

    /*
     * 일정 조회 */
    @GetMapping("/schedule/date")
    //TODO: 2022.02.08. memo, subject, homework 예외처리(null)
    //TODO: 2022.02.08. dto다시 만들기
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

    /*
     * 일정 추가*/
    //TODO: 2022.02.08. 과목 null 이면 생성X
    @GetMapping("/schedule/date/new")
    public void addSchedule(@RequestParam String date) {
        LocalDate requestDate = LocalDate.parse(date);
        Schedule newSchedule = Schedule.createSchedule(requestDate);
        scheduleService.storeSchedule(newSchedule);
    }

    /*
     * 과목 추가*/
    @PostMapping("/schedule/subject/new")
    public void addSubject(@RequestBody CreateSubjectForm form) {
        Schedule schedule = scheduleService.findSchedule(LocalDate.parse(form.getDate()));
        subjectService.addSubject(schedule.getId(), form.getSubjectName());
    }

    /*
     * 메모 추가*/
    //TODO: 2022.02.08. 중복 처리
    @PostMapping("/schedule/memo/new")
    public void addMemo(@RequestBody CreateMemoForm form) {
        Schedule schedule = scheduleService.findSchedule(LocalDate.parse(form.getDate()));
        memoService.saveMemo(schedule.getId(), form.getContent());
    }


    /*
     * 일정 생성 - 과목추가, 메모추가 할 때 */
    public boolean isEmptySchedule(LocalDate localDate) {
        Optional<Schedule> optionalSchedule = scheduleRepository.findByDate(localDate);
        boolean isEmpty = optionalSchedule.isEmpty();
        return isEmpty;
    }

}
