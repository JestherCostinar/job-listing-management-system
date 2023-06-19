package com.jesthercostinar.joblisting.service.impl;

import com.jesthercostinar.joblisting.dto.JobDto;
import com.jesthercostinar.joblisting.entity.Job;
import com.jesthercostinar.joblisting.repository.JobRepository;
import com.jesthercostinar.joblisting.service.JobService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class JobServiceImpl implements JobService {

    private JobRepository jobRepository;
    private ModelMapper modelMapper;

    @Override
    public List<JobDto> finAllJobs() {
        List<Job> jobs = jobRepository.findAll();
        return jobs.stream()
                .map(job -> modelMapper.map(job, JobDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public JobDto findJobById(Long id) {
        return modelMapper.map(jobRepository.findById(id).get(), JobDto.class);
    }

    @Override
    public void createJob(JobDto jobDto) {
        jobRepository.save(modelMapper.map(jobDto, Job.class));
    }

    @Override
    public void updateJob(JobDto jobDto) {
        jobRepository.save(modelMapper.map(jobDto, Job.class));
    }
}
