package com.test.sample;
 
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.example.service.MessageService;
 
import org.testng.Assert;
 
public class MessageServiceTest {
 
    private MessageService messageService;
 
    @BeforeMethod
    public void setUp() {
        messageService = new MessageService();
    }
 
    @Test
    public void getMessage_ShouldReturnMessage() {
        Assert.assertEquals("Hello World!", messageService.getMessage());
    }
}