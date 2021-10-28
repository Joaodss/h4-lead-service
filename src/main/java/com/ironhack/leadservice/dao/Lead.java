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

  //  @ManyToOne
  //  @JoinColumn(name = "sales_rep_id", referencedColumnName = "id")
  @Column(name = "sales_rep_id")
  private Long salesRepId;


  // -------------------- Constructors --------------------
  public Lead(String name, String phoneNumber, String email, String companyName) {
    this.name = name;
    this.phoneNumber = phoneNumber;
    this.email = email;
    this.companyName = companyName;
  }

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


  // -------------------- Getters & Setters (TODO with validation?) --------------------
 /*
  public void setName(String name) throws NameContainsNumbersException, EmptyStringException, ExceedsMaxLength {
    if (name.isEmpty()) {
      throw new EmptyStringException("No name input. Please try again.");
    }
    else if(!name.matches("[a-zA-Z\\u00C0-\\u00FF\\s]+")){
      throw new NameContainsNumbersException( "Name can not contain numbers. Please try again.");
    } else if(name.length()>43){
      throw new ExceedsMaxLength("Exceeds maximum value of 43 characters. Please try again.");
    }

    this.name = name;
  }

  public void setPhoneNumber(String phoneNumber) throws EmptyStringException, PhoneNumberContainsLettersException, ExceedsMaxLength {

    if (phoneNumber.isEmpty()) {
      throw new EmptyStringException("No Phone Number input. Please try again.");
    }
    else if(!phoneNumber.matches("[0-9]+")) {
      throw new PhoneNumberContainsLettersException("The phone number must only contain numbers. Please try again.");
    } else if(phoneNumber.length()>20) {
      throw new ExceedsMaxLength("Exceeds maximum value of 20 characters. Please try again.");
    }
    this.phoneNumber = phoneNumber;
  }


  public void setEmail(String email) throws EmailNotValidException, EmptyStringException, ExceedsMaxLength {
    if (email.isEmpty()) {
      throw new EmptyStringException("No email input. Please, try again.");
    }
    else if (!EmailValidator.getInstance().isValid(email)){
      throw new EmailNotValidException("The email should follow the format \"***@***.**\". Please, try again.");
    } else if (email.length()>40){
      throw new ExceedsMaxLength("Exceeds maximum value of 40 characters. Please, try again.");
    }
    this.email = email;
  }


  public void setCompanyName(String companyName) throws EmptyStringException, ExceedsMaxLength {
    if (companyName.isEmpty()) {
      throw new EmptyStringException("No company name input. Please, try again.");
    } else if (companyName.length()>43){
      throw new ExceedsMaxLength("Exceeds maximum value of 43 characters. Please, try again.");
    }
    this.companyName = companyName;
  }
*/
}
