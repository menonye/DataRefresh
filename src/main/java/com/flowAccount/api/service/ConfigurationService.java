package com.flowAccount.api.service;

import com.flowAccount.api.entity.Object_Configuration;

import java.util.List;
import java.util.Optional;

public interface ConfigurationService {

    List<Object_Configuration> getAllConfigs();
    Optional<Object_Configuration> getConfigById(Integer id);
    Object_Configuration saveConfig(Object_Configuration config);
    //Object_Configuration updateConfig(Object_Configuration config);
    void removeConfig(Integer id);
}
