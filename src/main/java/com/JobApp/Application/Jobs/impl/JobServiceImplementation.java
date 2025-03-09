package com.JobApp.Application.Jobs.impl;

import com.JobApp.Application.Jobs.Job;
import com.JobApp.Application.Jobs.JobRepository;
import com.JobApp.Application.Jobs.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class JobServiceImplementation implements JobService {
    // private List<Job> jobs = new ArrayList<>();
    JobRepository jobRepository ;

    public JobServiceImplementation(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public void createJob(Job job) {
        System.out.println("inside impl " + job);
        job.setId(null);
        System.out.println("inside impl after null " + job);
        jobRepository.save(job) ;
    }

    @Override
    public List<Job> findAll() {
        return jobRepository.findAll() ;
    }

    @Override
    public Job getJobById(Long id) {
        return jobRepository.findById(id).orElse(null) ;
    }

    @Override
    public Boolean deleteJobById(Long id) {
        try{
            jobRepository.deleteById(id);
            return true;
        } catch (Exception e){
            return false ;
        }
    }

    @Override
    public Boolean updateJob(Long id , Job updatedJob) {
        Optional<Job> optionalJob = jobRepository.findById(id) ;
        System.out.println("job to be updated "+optionalJob);
        if (optionalJob.isPresent()){
            System.out.println("is updating");
            Job job = optionalJob.get();
            job.setDescription(updatedJob.getDescription());
            job.setLocation(updatedJob.getLocation());
            job.setMaxSalary(updatedJob.getMaxSalary());
            job.setMinSalary(updatedJob.getMinSalary());
            job.setTitle(updatedJob.getTitle());
            jobRepository.save(job);
            return true ;
        }

        return false ;
    }
}
