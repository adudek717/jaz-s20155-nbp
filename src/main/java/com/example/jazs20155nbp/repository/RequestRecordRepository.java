package com.example.jazs20155nbp.repository;

import com.example.jazs20155nbp.model.RequestRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestRecordRepository extends JpaRepository<RequestRecord, Long> {
}
