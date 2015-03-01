package com.epam.cdp.msg.socket;


import com.epam.cdp.msg.MessageProducer;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by dima on 2.3.15.
 */
public class MessageProducerSocketImpl implements MessageProducer {

    public static final int DEFAULT_PORT = 6075;
    public static final int TIMEOUT = 1000000;

    private static MessageProducerSocketImpl messageProducer;

    private ServerSocket serverSocket;
    private Socket socket;

    private MessageProducerSocketImpl() throws IOException {
        this.serverSocket = new ServerSocket(DEFAULT_PORT);
        serverSocket.setSoTimeout(TIMEOUT);
        startServer();
    }

    public void startServer() {
        try {
            socket = serverSocket.accept();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static MessageProducerSocketImpl getMessageProducer() {
        if (messageProducer == null) {
            try {
                messageProducer = new MessageProducerSocketImpl();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return messageProducer;
    }

    @Override
    public void send(String message) throws IOException {
        try {
            DataOutputStream out =
                    new DataOutputStream(socket.getOutputStream());
            out.writeUTF(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
