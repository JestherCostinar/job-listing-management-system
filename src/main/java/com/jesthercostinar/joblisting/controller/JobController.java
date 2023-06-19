package com.jesthercostinar.joblisting.controller;

import com.jesthercostinar.joblisting.dto.JobDto;
import com.jesthercostinar.joblisting.service.JobService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@AllArgsConstructor
public class JobController {

    private JobService jobService;

    @GetMapping("/")
    public String jobs(Model model) {
        List<JobDto> jobs = jobService.finAllJobs();
        model.addAttribute("jobs", jobs);

        return "index";
    }

    @GetMapping("job/{id}")
    public String findJobById(@PathVariable("id") Long id,
                              Model model) {
        JobDto job = jobService.findJobById(id);
        model.addAttribute("job", job);

        return "job";
    }
}
