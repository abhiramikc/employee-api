package org.jobsearch.job.repository;

import jakarta.transaction.Transactional;
import org.jobsearch.job.model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JobRepo extends JpaRepository<JobPost, Integer> {


    Optional<JobPost> findByPostId(int postId);

    @Transactional
    void deleteByPostId(int postId);


    List<JobPost> findByPostProfileContainingIgnoreCaseOrPostDescriptionContainingIgnoreCase(String postProfile, String keyword);
}

//List<JobPost> jobPosts = new ArrayList<>(
//        Arrays.asList(
//                new JobPost(1, "Java Developer", "Must have 3+ years of experience in Java development", 3, List.of("Java", "Spring Boot", "Hibernate")),
//                new JobPost(2, "Front End Developer", "Must have 3.5+ years of experience building modern web UIs", 4, List.of("HTML", "CSS", "JavaScript", "React")),
//                new JobPost(3, "React Developer", "Must have 5 years of experience with React and related tooling", 5, List.of("React", "Redux", "TypeScript", "Node.js")),
//                new JobPost(4, "Senior Developer", "Must have 6+ years of experience leading full-stack projects", 6, List.of("Java", "React", "AWS", "Docker"))
//        )
//);
//
//public List<JobPost> getAllJobs() {
//    System.out.println("in repo"+jobPosts);
//    return jobPosts;
//}
//public void addJob(JobPost jobPost) {
//    jobPosts.add(jobPost);
//}
//
//public JobPost getJob(int postId) {
//    for (JobPost jobPost : jobPosts) {
//        if(jobPost.getPostId() == postId) {
//            return jobPost;
//        }
//    }
//    return null;
//}
//
//public void updateJob(JobPost jobPost) {
//    for (JobPost jobPost2 : jobPosts) {
//        if(jobPost2.getPostId() == jobPost.getPostId()) {
//            jobPost2.setPostProfile(jobPost.getPostProfile());
//            jobPost2.setPostDescription(jobPost.getPostDescription());
//            jobPost2.setReqExperience(jobPost.getReqExperience());
//            jobPost2.setPostTechStack(jobPost.getPostTechStack());
//        }
//    }
//}
//
//public void deleteJob(int postId) {
////        jobPosts.removeIf(jobPost -> jobPost.getPostId() == postId);
//    for (JobPost jobPost : jobPosts) {
//        if(jobPost.getPostId() == postId) {
//            jobPosts.remove(jobPost);
//        }
//    }
//}