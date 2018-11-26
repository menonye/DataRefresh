package com.flowAccount.api.service.impl;

import com.flowAccount.api.entity.Object_Master;
import com.flowAccount.api.repository.FlowAccountRepository;
import com.flowAccount.api.service.FlowAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlowAccountServiceImpl implements FlowAccountService {
    private final FlowAccountRepository accountRepository;

    @Autowired
    public FlowAccountServiceImpl(FlowAccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public List<Object_Master> getAllFlowAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public Optional<Object_Master> getFlowById(Integer id) {
        return accountRepository.findById(id);
    }

    @Override
    public Object_Master saveFlow(Object_Master account) {
        return accountRepository.save(account);
    }

    @Override
    public void removeFlowAccount(Integer id) {
        this.accountRepository.deleteById(id);
    }
}
