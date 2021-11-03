package com.ironhack.leadservice.service;

import com.ironhack.leadservice.dto.LeadCountBySalesRepDTO;
import com.ironhack.leadservice.repository.LeadRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {
  private final LeadRepository leadRepository;

  // ---------- Dependency Injection by constructor ----------
  public ReportServiceImpl(LeadRepository leadRepository) {
    this.leadRepository = leadRepository;
  }


  // -------------------- Methods --------------------
  public List<LeadCountBySalesRepDTO> getCountLeadsBySalesRepId() {
    List<Object[]> storedLeadCountBySalesRepList = leadRepository.findCountLeadsBySalesRepId();
    // Transform and return report as LeadCountBySalesRepDTO(salesRepId, count) list.
    List<LeadCountBySalesRepDTO> leadCountBySalesRepDTOList = new ArrayList<>();
    for (Object[] objects : storedLeadCountBySalesRepList) {
      leadCountBySalesRepDTOList.add(
          new LeadCountBySalesRepDTO((Long) objects[0], (Long) objects[1])
      );
    }
    return leadCountBySalesRepDTOList;
  }

}
