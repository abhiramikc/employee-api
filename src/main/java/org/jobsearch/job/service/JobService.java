package org.jobsearch.job.service;

import org.jobsearch.job.model.JobPost;
import org.jobsearch.job.repository.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepo  jobRepo;

    public void addJob(JobPost jobPost) {
        jobRepo.save(jobPost);
    }

    public List<JobPost> getAllJobs() {
        return jobRepo.findAll();
    }

    public JobPost getJob(int i) {
        return jobRepo.findByPostId(i).orElse(new JobPost());
    }

    public void updateJob(JobPost jobPost) {
         jobRepo.save(jobPost);
    }

    public void deleteJob(int postId) {
         jobRepo.deleteByPostId(postId);
    }

    public void load() {
        List<JobPost> jobPosts = new ArrayList<>(
        Arrays.asList(
                new JobPost(1, "Java Developer", "Must have 3+ years of experience in Java development", 3, List.of("Java", "Spring Boot", "Hibernate")),
                new JobPost(2, "Front End Developer", "Must have 3.5+ years of experience building modern web UIs", 4, List.of("HTML", "CSS", "JavaScript", "React")),
                new JobPost(3, "React Developer", "Must have 5 years of experience with React and related tooling", 5, List.of("React", "Redux", "TypeScript", "Node.js")),
                new JobPost(4, "Senior Developer", "Must have 6+ years of experience leading full-stack projects", 6, List.of("Java", "React", "AWS", "Docker"))
        ));
        jobRepo.saveAll(jobPosts);
    }

    public List<JobPost> searchByKeyword(String keyword) {
        return jobRepo.findByPostProfileContainingIgnoreCaseOrPostDescriptionContainingIgnoreCase(keyword,keyword);
    }
}
