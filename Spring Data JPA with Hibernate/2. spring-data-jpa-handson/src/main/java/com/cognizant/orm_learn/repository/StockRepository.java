package com.cognizant.orm_learn.repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cognizant.orm_learn.model.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Integer> {
    
    // Scenario 1: FB stock details in September 2019
    List<Stock> findByCodeAndDateBetween(String code, Date startDate, Date endDate);
    
    // Scenario 2: Google stock details where close price > 1250
    List<Stock> findByCodeAndCloseGreaterThan(String code, BigDecimal closePrice);
    
    // Scenario 3: Top 3 dates with highest volume of transactions
    List<Stock> findTop3ByOrderByVolumeDesc();
    
    // Scenario 4: Three dates when Netflix stocks close price were the lowest
    List<Stock> findTop3ByCodeOrderByCloseAsc(String code);
}
