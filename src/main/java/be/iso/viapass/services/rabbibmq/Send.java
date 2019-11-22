package be.iso.viapass.services.rabbibmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

@Service
public class Send {

        private final static String QUEUE_NAME = "hello";

        public void sendRequest() throws Exception{
                ConnectionFactory factory = new ConnectionFactory();
                factory.setHost("localhost");
                try (Connection connection = factory.newConnection();
                     Channel channel = connection.createChannel()) {
                        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
                        String message = "Hello World!";
                        channel.basicPublish("", QUEUE_NAME, null, message.getBytes(StandardCharsets.UTF_8));
                        System.out.println(" [x] Sent '" + message + "'");
                } catch (IOException e) {
                        e.printStackTrace();
                } catch (TimeoutException e) {
                        e.printStackTrace();
                }
        }
}