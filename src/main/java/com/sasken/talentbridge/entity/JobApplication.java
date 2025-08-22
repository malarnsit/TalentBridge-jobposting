package com.sasken.talentbridge.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class JobApplication 
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long jobId;
    private String name;
    private String email;
    private String resumeLink;

    public JobApplication() {}

    public JobApplication(Long jobId, String name, String email, String resumeLink) {
        this.jobId = jobId;
        this.name = name;
        this.email = email;
        this.resumeLink = resumeLink;
    }

    public Long getId() 
    {
        return id;
    }

    public Long getJobId() 
    {
        return jobId;
    }

    public void setJobId(Long jobId) 
    {
        this.jobId = jobId;
    }

    public String getName() 
    {
        return name;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public String getEmail() 
    {
        return email;
    }

    public void setEmail(String email)
     {
        this.email = email;
    }

    public String getResumeLink() 
    {
        return resumeLink;
    }

    public void setResumeLink(String resumeLink) 
    {
        this.resumeLink = resumeLink;
    }
}
