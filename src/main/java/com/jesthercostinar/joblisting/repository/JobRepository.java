package com.jesthercostinar.joblisting.repository;

import com.jesthercostinar.joblisting.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JobRepository extends JpaRepository<Job, Long> {
    
}
