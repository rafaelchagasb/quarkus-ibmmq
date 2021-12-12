package br.com.rafaelchagasb.ibmmq;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class MessageSenderServiceTest {

	@Inject
	MessageSenderService service;

	@Test
	public void send() {
		service.send("DEV.QUEUE.1", "Lorem Ipsum is simply dummy text of the printing and typesetting industry");
	}
	
}
