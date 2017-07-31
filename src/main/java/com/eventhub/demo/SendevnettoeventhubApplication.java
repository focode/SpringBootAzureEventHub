package com.eventhub.demo;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import java.io.Console;
import java.io.IOException;
import java.nio.charset.*;
import java.util.*;
import java.util.concurrent.ExecutionException;

import com.microsoft.azure.eventhubs.*;
import com.microsoft.azure.servicebus.*;

public class SendevnettoeventhubApplication {

	public static void main(String[] args) throws Exception {
		
		final String namespaceName = "arunesh-event-bus";
	    final String eventHubName = "arunesheventhub01";
	    final String sasKeyName = "RootManageSharedAccessKey";
	    final String sasKey = "yR0fbAJY2atXRNYUZtg1VaoFHgxYbDOVf4l9mXpjke4=";
	    ConnectionStringBuilder connStr = new ConnectionStringBuilder(namespaceName, eventHubName, sasKeyName, sasKey);
	    
	    byte[] payloadBytes = "Test AMQP message from JMS".getBytes("UTF-8");
	    EventData sendEvent = new EventData(payloadBytes);

	    EventHubClient ehClient = EventHubClient.createFromConnectionStringSync(connStr.toString());
	    ehClient.sendSync(sendEvent);
	    System.out.printf("Message sent");
	    }
	}

