package com.flowAccount.api.service.impl;

import com.flowAccount.api.entity.Object_Configuration;
import com.flowAccount.api.service.ConfigurationService;

import java.util.List;
import java.util.Optional;

import com.flowAccount.api.repository.ConfigurationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConfigurationServiceImpl implements ConfigurationService {
    private final ConfigurationRepository configAccountRepository;

    @Autowired
    public ConfigurationServiceImpl(ConfigurationRepository configAccountRepository) {
        this.configAccountRepository = configAccountRepository;
    }

    @Override
    public List<Object_Configuration> getAllConfigs() {
        return configAccountRepository.findAll();
    }

    @Override
    public Optional<Object_Configuration> getConfigById(Integer id) {
        return configAccountRepository.findById(id);
    }

    @Override
    public Object_Configuration saveConfig(Object_Configuration account) {
        return configAccountRepository.save(account);
    }

    @Override
    public void removeConfig(Integer id) {
        this.configAccountRepository.deleteById(id);
    }


}
