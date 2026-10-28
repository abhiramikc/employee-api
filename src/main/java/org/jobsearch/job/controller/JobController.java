package org.jobsearch.job.controller;

import org.jobsearch.job.model.JobPost;
import org.jobsearch.job.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins = "http://")
@CrossOrigin(origins = {"http://localhost:5173", "http://127.0.0.1:5173"})
public class JobController {

    @Autowired
    private JobService jobService;

    @GetMapping({"/", "home"})
    public String home() {
        return "home";
    }

    @GetMapping("addjob")
    public String addJob() {
        return "addjob";
    }

    @PostMapping("viewalljobs")
    public JobPost handleForm(@RequestBody JobPost jobPost) {
        jobService.addJob(jobPost);
        return jobPost;
    }

    @GetMapping("viewalljobs")
    public List<JobPost> viewAllJobs() {
        List<JobPost> jobPosts = jobService.getAllJobs();
        return jobPosts;
    }

    @GetMapping("viewalljobs/{postId}")
    public JobPost getJobById(@PathVariable("postId") int postId) {
        return jobService.getJob(postId);
    }

    @PutMapping("viewalljobs")
    public JobPost updateJob(@RequestBody JobPost jobPost) {
        jobService.updateJob(jobPost);
        return jobService.getJob(jobPost.getPostId());
    }


    @DeleteMapping("viewalljobs/{postId}")
    public String deleteJobById(@PathVariable("postId") int postId) {

        jobService.deleteJob(postId);
        return "DELETED";
    }

    @GetMapping("load")
    public String loadData() {
        jobService.load();
        return "Success";
    }


    @GetMapping("viewalljobs/keyword/{keyword}")
    public List<JobPost> searchByKeyword(@PathVariable("keyword") String keyword) {
        return jobService.searchByKeyword(keyword);
    }
























}
