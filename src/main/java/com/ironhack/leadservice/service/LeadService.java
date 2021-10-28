package com.ironhack.leadservice.service;

import com.ironhack.leadservice.dto.LeadDTO;
import com.ironhack.leadservice.dto.NewLeadDTO;

import java.util.List;

public interface LeadService {

  List<LeadDTO> getAll();

  LeadDTO getById(long id);

  LeadDTO create(NewLeadDTO newLead);

  LeadDTO delete(long id);

}
