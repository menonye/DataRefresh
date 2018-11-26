package com.flowAccount.api.controller;

import com.flowAccount.api.entity.Object_Master;
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
@RequestMapping("/api/jsonValidate")
public class FlowAccountsController {

    static String URI = "/api/jsonValidate/";

    private final FlowAccountService flowServices;

    @Autowired
    public FlowAccountsController(FlowAccountService flowService) {
        this.flowServices = flowService;
    }

    //http://localhost:8080/api/jsonValidate/getallflows
    @GetMapping(path = "/getallflows", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Object_Master> fetchAllAccounts() {
        return flowServices.getAllFlowAccounts();
    }

    //http://localhost:8080/api/jsonValidate/2 --->works good
    //http://localhost:8080/api/jsonValidate/9 ----> well formated Error message
    @GetMapping(path = "/{object_id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Object_Master> findAccountById(@PathVariable("object_id") Integer object_id) throws CustomException {
        return Optional.of(flowServices.getFlowById(object_id)
                .orElseThrow(() -> new CustomException("Object_Master with Object_ID: '" + object_id + "' not found.")));
    }

    @PostMapping(
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Object_Master saveAccount(@RequestBody @Validated Object_Master account) {
        return flowServices.saveFlow(account);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public Object_Master updateFlowAccount(@RequestBody @Validated Object_Master account) throws CustomException {
        if (flowServices.getFlowById(account.getObject_id()).isPresent()) {
            return flowServices.saveFlow(account);
        } else {
            throw new CustomException("Object_Master with ID: '" + account.getObject_id() + "' not found.");
        }
    }

    @DeleteMapping(path = "/{object_id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CustomResponse> removeFlowAccount(@PathVariable("object_id") Integer object_id) {
        if (flowServices.getFlowById(object_id).isPresent()) {
            this.flowServices.removeFlowAccount(object_id);
            return new ResponseEntity<>(
                    new CustomResponse(HttpStatus.OK.value(),
                            "Object_Master with Object_ID: '" + object_id + "' deleted."), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(
                    new CustomResponse(HttpStatus.NOT_FOUND.value(),
                            "Object_Master with Object_ID: '" + object_id + "' not found."), HttpStatus.NOT_FOUND);
        }
    }
}
