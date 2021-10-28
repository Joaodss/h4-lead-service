package com.ironhack.leadservice.repository;

import com.ironhack.leadservice.dao.Lead;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeadRepository extends JpaRepository<Lead, Long> {

  List<Lead> findBySalesRepId(long id);

  //Report Lead by SalesRep (count grouped by salesRepId)
  @Query("SELECT l.salesRepId, COUNT(l) FROM Lead l GROUP BY l.salesRepId")
  List<Object[]> findCountLeadsBySalesRepId();

}
