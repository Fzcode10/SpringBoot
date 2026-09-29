package com.example.TranstionDemo.Repository;


import com.example.TranstionDemo.Model.AccountDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<AccountDetails, Long> {
}
