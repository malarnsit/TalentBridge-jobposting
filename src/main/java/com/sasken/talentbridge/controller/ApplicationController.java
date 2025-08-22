package com.sasken.talentbridge.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sasken.talentbridge.entity.JobApplication;
import com.sasken.talentbridge.service.JobApplicationService;

@RestController
@RequestMapping("/api/applications")
public class ApplicationController 
{

    @Autowired
    private JobApplicationService applicationService;

  
    @PostMapping("/apply")
    public ResponseEntity<JobApplication> apply(
            @RequestParam Long jobId,
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String resumeLink) 
            {
        JobApplication application = applicationService.apply(jobId, name, email, resumeLink);
        return ResponseEntity.ok(application);
    }

  
    @GetMapping("/all")
    public ResponseEntity<List<JobApplication>> getAll() 
    {
        return ResponseEntity.ok(applicationService.getAllApplications());
    }

   
    @GetMapping("/by-job/{jobId}")
    public ResponseEntity<List<JobApplication>> getByJob(@PathVariable Long jobId) 
    {
        return ResponseEntity.ok(applicationService.getApplicationsByJobId(jobId));
    }

    
    @GetMapping("/by-email/{email}")
    public ResponseEntity<List<JobApplication>> getByEmail(@PathVariable String email) 
    {
        return ResponseEntity.ok(applicationService.getApplicationsByEmail(email));
    }
}
