package com.sasken.talentbridge.service;
import com.sasken.talentbridge.entity.JobPosting;
import com.sasken.talentbridge.repository.JobPostingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobPostingService 
{

    private final JobPostingRepository jobRepo;

    public JobPostingService(JobPostingRepository jobRepo) 
    {
        this.jobRepo = jobRepo;
    }
    public List<JobPosting> getAllJobs() 
    {
        return jobRepo.findAll();
    }
    public JobPosting getJobById(Long id) 
    {
        return jobRepo.findById(id).orElse(null);
    }
    public JobPosting saveJob(JobPosting job) 
    {
        return jobRepo.save(job);
    }

    public void deleteJobById(Long id) 
    {
        jobRepo.deleteById(id);
    }
}
