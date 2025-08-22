package com.sasken.talentbridge.service;
import com.sasken.talentbridge.entity.JobApplication;
import com.sasken.talentbridge.repository.JobApplicationRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class JobApplicationService 
{

    private final JobApplicationRepository appRepo;

    public JobApplicationService(JobApplicationRepository appRepo) 
    {
        this.appRepo = appRepo;
    }

    public JobApplication apply(Long jobId, String name, String email, String resumeLink) 
    {
        JobApplication app = new JobApplication();
        app.setJobId(jobId);
        app.setName(name);
        app.setEmail(email);
        app.setResumeLink(resumeLink);
        return appRepo.save(app);
    }

    public List<JobApplication> getAllApplications() 
    {
        return appRepo.findAll();
    }

    public List<JobApplication> getApplicationsByJobId(Long jobId) 
    {
        return appRepo.findByJobId(jobId);
    }

    public List<JobApplication> getApplicationsByEmail(String email) 
    {
        return appRepo.findByEmail(email);
    }
}
