package com.sasken.talentbridge.repository;
import com.sasken.talentbridge.entity.JobApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface JobApplicationRepository extends JpaRepository<JobApplication, Long> 
{
    List<JobApplication> findByJobId(Long jobId);
    List<JobApplication> findByEmail(String email);
}
