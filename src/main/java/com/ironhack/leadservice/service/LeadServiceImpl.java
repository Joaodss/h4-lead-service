package com.ironhack.leadservice.service;

import com.ironhack.leadservice.dao.Lead;
import com.ironhack.leadservice.dto.LeadDTO;
import com.ironhack.leadservice.dto.NewLeadDTO;
import com.ironhack.leadservice.repository.LeadRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class LeadServiceImpl implements LeadService {
  private final LeadRepository leadRepository;

  // ---------- Dependency Injection by constructor ----------
  public LeadServiceImpl(LeadRepository leadRepository) {
    this.leadRepository = leadRepository;
  }


  // -------------------- Methods --------------------
  public List<LeadDTO> getAll() {
    var storedList = leadRepository.findAll();
    // Transform and return leads as LeadDTO list.
    var leadDTOList = new ArrayList<LeadDTO>();
    for (Lead storedLead : storedList)
      leadDTOList.add(new LeadDTO(storedLead));
    return leadDTOList;
  }

  public LeadDTO getById(long id) {
    var storedLead = leadRepository.findById(id);
    // TODO: JA - should it return null or throw an exception? How are we going to handle exceptions?
    // If present it will create a lead with itself. If not present throw error?
    return storedLead.map(LeadDTO::new).orElseThrow(() -> new NoSuchElementException("Lead Not found"));
  }

  public List<LeadDTO> getBySalesRepId(long salesRepId) {
    var storedList = leadRepository.findBySalesRepId(salesRepId);
    var leadDTOList = new ArrayList<LeadDTO>();
    for (Lead storedLead : storedList)
      leadDTOList.add(new LeadDTO(storedLead));
    return leadDTOList;
  }

  public LeadDTO create(NewLeadDTO newLeadDTO) {
    var savedLead = leadRepository.save(new Lead(newLeadDTO));
    return getById(savedLead.getId());
  }

  public LeadDTO delete(long id) {
    var deletedLead = getById(id);
    leadRepository.deleteById(id);
    return deletedLead;
  }

}
