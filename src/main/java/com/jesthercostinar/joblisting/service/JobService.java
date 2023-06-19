package com.jesthercostinar.joblisting.service;

import com.jesthercostinar.joblisting.dto.JobDto;

import java.util.List;

public interface JobService {
    List<JobDto> finAllJobs();
    JobDto findJobById(Long id);
    void createJob(JobDto jobDto);
    void updateJob(JobDto jobDto);
    void deleteJob(Long id);
}
