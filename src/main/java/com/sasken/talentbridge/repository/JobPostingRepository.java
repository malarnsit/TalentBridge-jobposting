package com.sasken.talentbridge.repository;

import com.sasken.talentbridge.entity.JobPosting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobPostingRepository extends JpaRepository<JobPosting, Long> {
}
