package com.example.TranstionDemo.Repository;

import com.example.TranstionDemo.Model.TransferRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferRepository extends JpaRepository<TransferRecord, Long> {
}
