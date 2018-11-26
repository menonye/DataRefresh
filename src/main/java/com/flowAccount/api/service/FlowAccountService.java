package com.flowAccount.api.service;

import com.flowAccount.api.entity.Object_Master;

import java.util.List;
import java.util.Optional;

public interface FlowAccountService {

    List<Object_Master> getAllFlowAccounts();
    Optional<Object_Master> getFlowById(Integer id);
    Object_Master saveFlow(Object_Master member);
   // Object_Master updateFlowAccount(Object_Master member);
    void removeFlowAccount(Integer id);
}
