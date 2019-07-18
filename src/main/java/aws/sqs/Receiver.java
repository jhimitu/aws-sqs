package aws.sqs;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.Message;

import java.util.List;

public class Receiver {

    public void receive(String url) {
        AmazonSQS sqs = AmazonSQSClientBuilder.defaultClient();
        List<Message> messages = sqs.receiveMessage(url).getMessages();

        for (Message m : messages) {
            sqs.deleteMessage(url, m.getReceiptHandle());
        }
    }
}
