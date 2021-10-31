package com.ironhack.leadservice.controller;

import com.ironhack.leadservice.dto.LeadCountBySalesRepDTO;
import com.ironhack.leadservice.dto.LeadDTO;
import com.ironhack.leadservice.dto.NewLeadDTO;
import com.ironhack.leadservice.service.LeadService;
import com.ironhack.leadservice.service.ReportService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.NoSuchElementException;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/leads")
public class LeadControllerImpl implements LeadController {
  private final LeadService leadService;
  private final ReportService reportService;

  // ---------- Dependency Injection by constructor ----------
  public LeadControllerImpl(LeadService leadService, ReportService reportService) {
    this.leadService = leadService;
    this.reportService = reportService;
  }


  @GetMapping
  @ResponseStatus(OK)
  public List<LeadDTO> getAllLeads() {
    try {
      return leadService.getAll();
    } catch (Exception e) {
      throw new ResponseStatusException(INTERNAL_SERVER_ERROR, e.getMessage());
    }
  }

  @GetMapping("/{id}")
  @ResponseStatus(OK)
  public LeadDTO getLeadById(@PathVariable long id) {
    try {
      return leadService.getById(id);
    } catch (NoSuchElementException e1) {
      throw new ResponseStatusException(NOT_FOUND, e1.getMessage());
    } catch (Exception e) {
      throw new ResponseStatusException(INTERNAL_SERVER_ERROR, e.getMessage());
    }
  }

  @GetMapping("/by-sales-rep/{id}")
  @ResponseStatus(OK)
  public List<LeadDTO> getLeadBySalesRepId(@PathVariable long id) {
    try {
      return leadService.getBySalesRepId(id);
    } catch (Exception e) {
      throw new ResponseStatusException(INTERNAL_SERVER_ERROR, e.getMessage());
    }
  }

  @PostMapping
  @ResponseStatus(CREATED)
  public LeadDTO createLead(@RequestBody NewLeadDTO newLead) {
    try {
      return leadService.create(newLead);
    } catch (Exception e) {
      throw new ResponseStatusException(INTERNAL_SERVER_ERROR, e.getMessage());
    }
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(OK)
  public LeadDTO deleteLeadById(@PathVariable long id) {
    try {
      return leadService.delete(id);
    } catch (NoSuchElementException e1) {
      throw new ResponseStatusException(NOT_FOUND, e1.getMessage());
    } catch (Exception e) {
      throw new ResponseStatusException(INTERNAL_SERVER_ERROR, e.getMessage());
    }
  }

  @GetMapping("/report/count-by-sales-rep")
  @ResponseStatus(OK)
  public List<LeadCountBySalesRepDTO> getCountLeadsBySalesRepId() {
    try {
      return reportService.getCountLeadsBySalesRepId();
    } catch (Exception e) {
      throw new ResponseStatusException(INTERNAL_SERVER_ERROR, e.getMessage());
    }
  }
}
