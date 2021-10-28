package com.ironhack.leadservice.service;

import com.ironhack.leadservice.dto.LeadCountBySalesRepDTO;

import java.util.List;

public interface ReportService {

  List<LeadCountBySalesRepDTO> getCountLeadsBySalesRepId();

}
