package com.example.currencyconverter.repository;

import com.example.currencyconverter.userlogging.UserLogging;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserLoggingRepository extends CrudRepository<UserLogging, Long> {

}
