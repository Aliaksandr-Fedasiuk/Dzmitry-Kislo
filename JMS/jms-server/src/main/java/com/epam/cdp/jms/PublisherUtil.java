package com.epam.cdp.jms;

import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Properties;

public class PublisherUtil {

    public static final String USERNAME = "realm";
    public static final String PASSWORD = "realm1realm!1";
    public static final String CONNECTION_FACTORY = "jms/RemoteConnectionFactory";
    public static final String TOPIC_NAME = "jms/topic/test";
    public static final String PROVIDER_URL = "remote://localhost:4447";
    public static final String INITIAL_CONTEXT_FACTORY = "org.jboss.naming.remote.client.InitialContextFactory";

    private static TopicSession topicSession;
    private static TopicPublisher topicPublisher;

    private static Properties getProperties() {
        final Properties properties = new Properties();
        properties.put(Context.INITIAL_CONTEXT_FACTORY, INITIAL_CONTEXT_FACTORY);
        properties.put(Context.PROVIDER_URL, PROVIDER_URL);
        properties.put(Context.SECURITY_PRINCIPAL, USERNAME);
        properties.put(Context.SECURITY_CREDENTIALS, PASSWORD);

        return properties;
    }

    private static void setUpPublisher() throws NamingException, JMSException {
        InitialContext context = new InitialContext(getProperties());

        TopicConnectionFactory tcf = (TopicConnectionFactory) context.lookup(CONNECTION_FACTORY);
        TopicConnection topicConnection = tcf.createTopicConnection(USERNAME, PASSWORD);
        Topic topic = (Topic) context.lookup(TOPIC_NAME);
        topicSession = topicConnection.createTopicSession(false, TopicSession.AUTO_ACKNOWLEDGE);
        topicConnection.start();

        topicPublisher = topicSession.createPublisher(topic);
    }

    public static TopicPublisher getTopicPublisher() throws JMSException, NamingException {
        if (topicPublisher == null) {
            setUpPublisher();
        }

        return topicPublisher;
    }

    public static TopicSession getTopicSession() throws JMSException, NamingException {
        if (topicSession == null) {
            setUpPublisher();
        }

        return topicSession;
    }

}
