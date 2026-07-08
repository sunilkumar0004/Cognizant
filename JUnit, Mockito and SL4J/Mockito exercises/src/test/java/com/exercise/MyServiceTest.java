package com.exercise;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

public class MyServiceTest {

    // Exercise 1: Mocking and Stubbing
    @Test
    public void testExternalApi() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        when(mockApi.getData()).thenReturn("Mock Data");
        
        MyService service = new MyService(mockApi);
        String result = service.fetchData();
        
        assertEquals("Mock Data", result);
    }

    // Exercise 2: Verifying Interactions
    @Test
    public void testVerifyInteraction() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        
        MyService service = new MyService(mockApi);
        service.fetchData();
        
        verify(mockApi).getData();
    }

    // Exercise 3: Argument Matching
    @Test
    public void testArgumentMatching() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        when(mockApi.getRecord(anyInt())).thenReturn("Record Found");

        MyService service = new MyService(mockApi);
        String result = service.getRecord(10);

        assertEquals("Record Found", result);
        verify(mockApi).getRecord(eq(10));
        verify(mockApi).getRecord(anyInt());
    }

    // Exercise 4: Handling Void Methods
    @Test
    public void testHandlingVoidMethods() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        doNothing().when(mockApi).saveData(anyString());

        MyService service = new MyService(mockApi);
        service.saveData("Hello Mockito");

        verify(mockApi).saveData("Hello Mockito");
    }

    // Exercise 5: Mocking and Stubbing with Multiple Returns
    @Test
    public void testMockingMultipleReturns() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        when(mockApi.getData()).thenReturn("First Call", "Second Call");

        MyService service = new MyService(mockApi);
        
        String firstResult = service.fetchData();
        String secondResult = service.fetchData();

        assertEquals("First Call", firstResult);
        assertEquals("Second Call", secondResult);
    }

    // Exercise 6: Verifying Interaction Order
    @Test
    public void testVerifyingInteractionOrder() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);

        MyService service = new MyService(mockApi);
        service.fetchSecureData();

        InOrder inOrder = inOrder(mockApi);
        inOrder.verify(mockApi).authenticate();
        inOrder.verify(mockApi).getData();
    }

    // Exercise 7: Handling Void Methods with Exceptions
    @Test
    public void testVoidMethodWithExceptions() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        doThrow(new IllegalArgumentException("Invalid ID")).when(mockApi).deleteData(eq("invalid-id"));

        MyService service = new MyService(mockApi);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            service.deleteData("invalid-id");
        });

        assertEquals("Invalid ID", exception.getMessage());
        verify(mockApi).deleteData("invalid-id");
    }
}
