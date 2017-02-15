package com.record.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.record.shop.model.Record;

public interface RecordRepository extends JpaRepository<Record, Long> {

}
