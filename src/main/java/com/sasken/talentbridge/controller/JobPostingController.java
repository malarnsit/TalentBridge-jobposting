package com.sasken.talentbridge.controller;

import com.sasken.talentbridge.entity.JobPosting;
import com.sasken.talentbridge.service.JobPostingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;

@Controller
@RequestMapping("/jobs")
public class JobPostingController 
{

    private final JobPostingService jobService;

    public JobPostingController(JobPostingService jobService) 
    {
        this.jobService = jobService;
    }

    
    @GetMapping
    public String listJobs(Model model) 
    {
        model.addAttribute("jobs", jobService.getAllJobs());
        return "jobs"; 
    }

   
    @GetMapping("/new")
    public String showJobForm(Model model) 
    {
        JobPosting job = new JobPosting();
        job.setPostedDate(LocalDate.now()); 
        model.addAttribute("job", job);
        return "job_form"; 
    }

    
    @PostMapping
    public String saveJob(@ModelAttribute("job") JobPosting job,
                          RedirectAttributes redirectAttributes) 
                          {
        try {
            if (job.getPostedDate() == null) 
            {
                job.setPostedDate(LocalDate.now()); 
            }
            jobService.saveJob(job);
            redirectAttributes.addFlashAttribute("successMessage", "Job saved successfully!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Error saving job: " + e.getMessage());
            return "redirect:/jobs/new";
        }
        return "redirect:/jobs";
    }

    
    @GetMapping("/edit/{id}")
    public String editJob(@PathVariable Long id, Model model,
                          RedirectAttributes redirectAttributes) 
                          {
        JobPosting existingJob = jobService.getJobById(id); 
        if (existingJob == null) {
            redirectAttributes.addFlashAttribute("errorMessage", "Job not found!");
            return "redirect:/jobs";
        }
        model.addAttribute("job", existingJob);
        return "job_form";
    }

    
    @GetMapping("/delete/{id}")
    public String deleteJob(@PathVariable Long id,
                            RedirectAttributes redirectAttributes) 
                            {
        try {
            jobService.deleteJobById(id); 
            redirectAttributes.addFlashAttribute("successMessage", "Job deleted successfully!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Error deleting job: " + e.getMessage());
        }
        return "redirect:/jobs";
    }
}
