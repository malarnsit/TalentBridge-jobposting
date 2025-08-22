package com.sasken.talentbridge.controller;

import com.sasken.talentbridge.repository.JobApplicationRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController 
{

    private final JobApplicationRepository repository;

    public DashboardController(JobApplicationRepository repository) 
    {
        this.repository = repository;
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) 
    {
        model.addAttribute("applications", repository.findAll());
        return "dashboard";
    }

    @GetMapping("/login")
    public String loginPage() 
    {
        return "login";
    }
}
