package com.ironhack.leadservice.sample_data;

import com.ironhack.leadservice.dto.NewLeadDTO;
import com.ironhack.leadservice.service.LeadService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SampleDataLoader implements CommandLineRunner {
  private final LeadService leadService;

  // -------------------- Constructor Injection --------------------
  public SampleDataLoader(LeadService leadService) {
    this.leadService = leadService;
  }


  // -------------------- Starter run method --------------------
  @Override
  public void run(String... args) throws Exception {
    leadService.create(
        new NewLeadDTO("Randall Burns", "9999999999", "rburns@mail.com", "Burns", 1L));
    leadService.create(
        new NewLeadDTO("Beth West", "9999999998", "bwest@mail.com", "West&West", 1L));
    leadService.create(
        new NewLeadDTO("Pearl Simmons", "9999999977", "psimmmons@mail.com", "Simmmons", 2L));
    leadService.create(
        new NewLeadDTO("Catherine Fisher", "9999999666", "cfisher@mail.com", "The Fishers", 3L));
    leadService.create(
        new NewLeadDTO("Leslie Gordon", "9999995555", "lgordon@mail.com", "Gordons", 4L));
    leadService.create(
        new NewLeadDTO("Mike Garrett", "9999944444", "mgarrett@mail.com", "Garrett", 3L));
  }

}
