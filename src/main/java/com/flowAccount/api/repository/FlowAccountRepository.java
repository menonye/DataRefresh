package com.flowAccount.api.repository;

import com.flowAccount.api.entity.Object_Master;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlowAccountRepository extends JpaRepository<Object_Master, Integer> {
}
