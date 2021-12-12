package br.com.rafaelchagasb.ibmmq;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/message")
public class MessageResource {

	@Inject
	MessageSenderService service;

	@GET
	@Path(value = "/{content}")
	@Produces(MediaType.TEXT_PLAIN)
	public String send(@PathParam("content") String content) {
		
		service.send("DEV.QUEUE.1", content);
		
		return "Message sent";
	}

	
}