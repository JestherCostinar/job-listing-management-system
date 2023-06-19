package com.jesthercostinar.joblisting.controller;

import com.jesthercostinar.joblisting.dto.JobDto;
import com.jesthercostinar.joblisting.entity.Job;
import com.jesthercostinar.joblisting.service.JobService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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

    @GetMapping("job/create")
    public String pageForCreateJob(Model model) {
        JobDto job = new JobDto();
        model.addAttribute("job", job);

        return "create_job";
    }

    @PostMapping("job/save")
    public String saveJob(@Valid @ModelAttribute("job") JobDto job,
                          Model model,
                          BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute("job", job);

            return "create_job";
        }

        jobService.createJob(job);

        return "redirect:/";
    }

    @GetMapping("job/{id}/edit")
    public String viewEditJob(@PathVariable("id") Long id, Model model) {
        JobDto job = jobService.findJobById(id);
        model.addAttribute("job", job);

        return "edit_job";
    }

    @PostMapping("job/{id}")
    public String updateJob(@PathVariable Long id,
                            @Valid @ModelAttribute("job") JobDto job,
                            BindingResult result,
                            Model model) {
        if (result.hasErrors()) {
            model.addAttribute("job", job);

            return "edit_job";
        }

        job.setId(id);
        jobService.updateJob(job);

        return "redirect:/";
    }
}
