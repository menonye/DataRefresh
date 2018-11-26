package com.flowAccount.api.controller;

import com.flowAccount.api.entity.Object_Configuration;
import com.flowAccount.api.exception.CustomException;
import com.flowAccount.api.exception.CustomResponse;
import com.flowAccount.api.service.ConfigurationService;
import com.flowAccount.api.service.FlowAccountService;
import com.flowAccount.api.exception.CustomException;
import com.flowAccount.api.exception.CustomResponse;
import com.flowAccount.api.service.FlowAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/flowconfig")
public class ConfigurationsController {

        static String URI = "/api/flowconfig/";
        private final ConfigurationService configServices;
        @Autowired
        public ConfigurationsController(ConfigurationService configServices) {
            this.configServices = configServices;
        }

        //http://localhost:8080/api/flowConfigs/getallconfigs
        @GetMapping(path = "/getallconfigs", produces = MediaType.APPLICATION_JSON_VALUE)
        public List<Object_Configuration> getAllConfigs() {
            return configServices.getAllConfigs();
        }

        //http://localhost:8080/api/flowConfigs/2 --->works good
        //http://localhost:8080/api/flowConfigs/9 ----> well formated Error message
        @GetMapping(path = "/{object_id}", produces = MediaType.APPLICATION_JSON_VALUE)
        public Optional<Object_Configuration> getConfigById(@PathVariable("object_id") Integer object_id) throws CustomException {
            return Optional.of(configServices.getConfigById(object_id)
                    .orElseThrow(() -> new CustomException("Object_Master with Object_ID: '" + object_id + "' not found.")));
        }

        @PostMapping(
                produces = MediaType.APPLICATION_JSON_VALUE,
                consumes = MediaType.APPLICATION_JSON_VALUE)
        public Object_Configuration saveConfig(@RequestBody @Validated Object_Configuration configs) {
            return configServices.saveConfig(configs);
        }

        @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
        public Object_Configuration updateFlowAccount(@RequestBody @Validated Object_Configuration configs) throws CustomException {
            if (configServices.getConfigById(configs.getObject_id()).isPresent()) {
                return configServices.saveConfig(configs);
            } else {
                throw new CustomException("Object_Configuration with ID: '" + configs.getObject_id() + "' not found.");
            }
        }

        @DeleteMapping(path = "/{object_id}", produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<CustomResponse> removeConfig(@PathVariable("object_id") Integer object_id) {
            if (configServices.getConfigById(object_id).isPresent()) {
                this.configServices.removeConfig(object_id);
                return new ResponseEntity<>(
                        new CustomResponse(HttpStatus.OK.value(),
                                "Object_Configuration with Object_ID: '" + object_id + "' deleted."), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(
                        new CustomResponse(HttpStatus.NOT_FOUND.value(),
                                "Object_Configuration with Object_ID: '" + object_id + "' not found."), HttpStatus.NOT_FOUND);
            }
        }
}