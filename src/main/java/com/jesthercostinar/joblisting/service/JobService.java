package com.jesthercostinar.joblisting.service;

import com.jesthercostinar.joblisting.dto.JobDto;

import java.util.List;

public interface JobService {
    List<JobDto> finAllJobs();
}