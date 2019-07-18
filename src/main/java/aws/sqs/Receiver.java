package aws.sqs;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.Message;

import java.util.List;

public class Receiver {

    public void receive(String url) {
        AmazonSQS sqs = AmazonSQSClientBuilder.standard().withRegion(Regions.US_EAST_2).build();
        List<Message> messages = sqs.receiveMessage(url).getMessages();

        for (Message m : messages) {
            System.out.println(m.getBody());
            sqs.deleteMessage(url, m.getReceiptHandle());

        }
    }
}
