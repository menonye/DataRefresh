package com.flowAccount.api.repository;

import com.flowAccount.api.entity.Object_Configuration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConfigurationRepository extends JpaRepository<Object_Configuration, Integer> {
}
