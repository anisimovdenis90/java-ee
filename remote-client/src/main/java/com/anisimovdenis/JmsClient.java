package com.anisimovdenis;

import com.anisimovdenis.service.ProductDto;

import javax.ejb.MessageDriven;
import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Properties;

@MessageDriven
public class JmsClient {

    public static void main(String[] args) throws IOException, NamingException {
        Context context = createInitialContext();

        ConnectionFactory factory = (ConnectionFactory) context.lookup("jms/RemoteConnectionFactory");
        JMSContext jmsContext = factory.createContext("jmsUser", "12345");

        Destination dest = (Destination) context.lookup("jms/productQueue");

        JMSProducer producer = jmsContext.createProducer();

        ObjectMessage objectMessage = jmsContext.createObjectMessage(
                new ProductDto(null, "Product from JMS", "Product from JMS", new BigDecimal(100), 1L, null));

        producer.send(dest, objectMessage);
    }

    public static Context createInitialContext() throws IOException, NamingException {
        final Properties env = new Properties();
        env.load(EjbClient.class.getResourceAsStream("/wildfly-jndi.properties"));
        return new InitialContext(env);
    }
}
