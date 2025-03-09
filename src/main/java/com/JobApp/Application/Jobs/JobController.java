package com.JobApp.Application.Jobs;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JobController {
    JobService service ;

    public JobController(JobService service) {
        this.service = service;
    }

    @GetMapping("/jobs")
    public ResponseEntity<List<Job>> findAll() {
        return new ResponseEntity<>(this.service.findAll(),HttpStatus.OK);
    }

    @PostMapping("/jobs")
    public ResponseEntity<String> CreateJob (@RequestBody Job job) {

        // System.out.println("abhishek "+ job.getId());
        this.service.createJob(job);
        return new ResponseEntity<>("Job added succesfully" , HttpStatus.OK) ;
    }

    @GetMapping("/jobs/{id}")
    public ResponseEntity<Job> getJobById (@PathVariable Long id) {
        Job job = this.service.getJobById(id) ;
        if (job!=null){
            return new ResponseEntity<>(job , HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND) ;
    }

    @DeleteMapping ("/jobs/{id}")
    public ResponseEntity<String> deleteJobById (@PathVariable Long id) {
        if (this.service.deleteJobById(id)){
            return new ResponseEntity<>("Job deleted successfully" , HttpStatus.OK) ;
        }
        return new ResponseEntity<>("Job not found " , HttpStatus.NOT_FOUND);
    }

    @PutMapping ("/jobs/{id}")
    public ResponseEntity<String> updateJobById (@PathVariable Long id , @RequestBody Job updatedJob) {
        Boolean query = this.service.updateJob(id,updatedJob) ;
        if (query){
            return new ResponseEntity<>("Job updated successfully" , HttpStatus.OK) ;
        }
        return new ResponseEntity<>("Job not found " , HttpStatus.NOT_FOUND);
    }


}
