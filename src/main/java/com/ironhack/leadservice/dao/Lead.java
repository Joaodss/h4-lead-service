package com.ironhack.leadservice.dao;

import com.ironhack.leadservice.dto.NewLeadDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "leads")
public class Lead {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "contact_name")
  private String name;

  @Column(name = "phone_number")
  private String phoneNumber;

  private String email;

  @Column(name = "company_name")
  private String companyName;

  @Column(name = "sales_rep_id")
  private Long salesRepId;


  // -------------------- Constructors --------------------
  public Lead(String name, String phoneNumber, String email, String companyName, Long salesRepId) {
    this.name = name;
    this.phoneNumber = phoneNumber;
    this.email = email;
    this.companyName = companyName;
    this.salesRepId = salesRepId;
  }

  // -------------------- Constructor from DTO --------------------
  public Lead(NewLeadDTO newLeadDTO) {
    this.name = newLeadDTO.getName();
    this.phoneNumber = newLeadDTO.getPhoneNumber();
    this.email = newLeadDTO.getEmail();
    this.companyName = newLeadDTO.getCompanyName();
    this.salesRepId = newLeadDTO.getSalesRep();
  }

}
