package com.JobApp.Application.Jobs;

import java.util.List;

public interface JobService {

    public void createJob (Job job) ;
    public List<Job> findAll () ;

    public Job getJobById(Long id);

    public Boolean deleteJobById(Long id);

    Boolean updateJob(Long id , Job updatedJob);
}
