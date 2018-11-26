package com.flowAccount.api.service;

import com.flowAccount.api.entity.Object_Master;
import com.flowAccount.api.repository.FlowAccountRepository;
import com.flowAccount.api.service.impl.FlowAccountServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class FlowAccountServiceTest {

    @Mock
    private FlowAccountRepository flowaccountRepository;

    @InjectMocks
    private FlowAccountServiceImpl flowAccountServiceImp;

    private Object_Master A1 = new Object_Master("NEWCAST_LAG_LOS","FLOW",false);
    private Object_Master A2 = new Object_Master("NEWCAST_BRUSSL_NY", "FLOW", false);
    private Object_Master A3 = new Object_Master("GATW_LAG_BOST","FLOW", false);

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        A1.setObject_id(1);
        A2.setObject_id(2);
        A3.setObject_id(3);
    }

    @Test
    public void testGetAllMembers() {
        //given
        given(flowaccountRepository.findAll()).willReturn(Arrays.asList(A1, A2, A3));

        //calling method under the test
        List<Object_Master> result = flowAccountServiceImp.getAllFlowAccounts();

        //assert respond has 3 objects
        assertThat(result).hasSize(3);

        //assert
        assertAccountFields(result.get(0));

        //verify that repository was called
        verify(flowaccountRepository, times(1)).findAll();
    }

    //@Test
    public void testGetAccountById() {
        //given
        given(flowaccountRepository.findById(1)).willReturn(Optional.of(A1));

        //calling method under the test
        Optional<Object_Master> result = flowAccountServiceImp.getFlowById(1);

        //assert
        assertThat(result.isPresent()).isTrue();

        //assert
        assertAccountFields(result.orElseGet(null));

        //verify that repository was called
        verify(flowaccountRepository, times(1)).findById(1);
    }

    //@Test
    public void testInsertAccount() {
        //given
        given(flowaccountRepository.save(A1)).willReturn(A1);

        //calling method under the test
        Object_Master result = flowAccountServiceImp.saveFlow(A1);

        //assert
        assertAccountFields(result);

        //verify that repository was called
        verify(flowaccountRepository, times(1)).save(A1);
    }

    //@Test
    public void testRemoveAccount() {
        flowAccountServiceImp.removeFlowAccount(1);

        //verify that repository was called
        verify(flowaccountRepository, times(1)).deleteById(1);
    }

    //verify that Object_Master 'a1' object have same fields
    private void assertAccountFields(Object_Master objectMaster) {
        assertThat(objectMaster.getObject_id()).isInstanceOf(Integer.class);
        assertThat(objectMaster.getObject_id()).isEqualTo(1);
        assertThat(objectMaster.getFlow_name()).isEqualTo("NEWCAST_LAG_LOS");
        assertThat(objectMaster.getFlow_type()).isEqualTo("FLOW");
        assertThat(objectMaster.isIs_deleted()).isEqualTo(false);

    }

}