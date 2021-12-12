package br.com.rafaelchagasb.ibmmq;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;
import javax.jms.ConnectionFactory;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import com.ibm.msg.client.jms.JmsConnectionFactory;
import com.ibm.msg.client.jms.JmsConstants;
import com.ibm.msg.client.jms.JmsFactoryFactory;
import com.ibm.msg.client.wmq.WMQConstants;
import com.ibm.msg.client.wmq.common.CommonConstants;

import io.quarkus.arc.DefaultBean;

@ApplicationScoped
@DefaultBean
public class IbmMqFactory {

	String hostname = "localhost";

	String hostport = "1414";

	String userid = "app";

	String password = "passw0rd";

	String channel = "DEV.APP.SVRCONN";

	String queuemanager = "QM1";

	@Produces
	@Named("IbmMqConnectionFactory")
	ConnectionFactory factory() throws Exception {
		try {
			JmsFactoryFactory ff = JmsFactoryFactory.getInstance(JmsConstants.WMQ_PROVIDER);
			JmsConnectionFactory factory = ff.createConnectionFactory();

			factory.setIntProperty(CommonConstants.WMQ_CONNECTION_MODE, CommonConstants.WMQ_CM_CLIENT);

			factory.setStringProperty(CommonConstants.WMQ_HOST_NAME, hostname);
			factory.setIntProperty(CommonConstants.WMQ_PORT, Integer.parseInt(hostport));
			factory.setStringProperty(WMQConstants.USERID, userid);
			factory.setStringProperty(WMQConstants.PASSWORD, password);
			factory.setStringProperty(CommonConstants.WMQ_CHANNEL, channel);
			factory.setStringProperty(CommonConstants.WMQ_QUEUE_MANAGER, queuemanager);
			factory.setIntProperty(WMQConstants.WMQ_READ_AHEAD_ALLOWED, WMQConstants.WMQ_READ_AHEAD_ALLOWED_ENABLED);
			
			return factory;
		} catch (Exception e) {
			throw e;
		}

	}

}
