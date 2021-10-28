package com.ironhack.leadservice.controller;

import com.ironhack.leadservice.dto.LeadCountBySalesRepDTO;
import com.ironhack.leadservice.dto.LeadDTO;
import com.ironhack.leadservice.dto.NewLeadDTO;

import java.util.List;

public interface LeadController {

  List<LeadDTO> getAllLeads();

  LeadDTO getLeadById(long id);

  LeadDTO createLead(NewLeadDTO newLead);

  LeadDTO deleteLeadById(long id);

  List<LeadCountBySalesRepDTO> getCountLeadsBySalesRepId();

}
