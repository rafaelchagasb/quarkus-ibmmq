package br.com.rafaelchagasb.ibmmq;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSProducer;
import javax.jms.TextMessage;

@ApplicationScoped
public class MessageSenderService {

	@Inject
	@Named("IbmMqConnectionFactory")
	ConnectionFactory connectionFactory;
	
	public String send(String queue, String content) {

		try (JMSContext context = connectionFactory.createContext()) {

			TextMessage textMessage = context.createTextMessage(content);
			JMSProducer producer = context.createProducer();
			producer.send(context.createQueue(queue), textMessage);

			String correlationId = textMessage.getJMSMessageID();

			System.out.println("[QUEUE][SUCCESS] message sent successfully. Correlation:" + correlationId);

			return correlationId;

		} catch (Exception e) {
			System.err.println("[QUEUE][FAIL] failed to send message: " + queue + " Message:" + e.getMessage());
		}

		return null;
	}
	
}
