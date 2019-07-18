package aws.sqs;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.SendMessageRequest;

public class Sender {

    AmazonSQS sqs = AmazonSQSClientBuilder.standard().withRegion(Regions.US_EAST_2).build();

    public void send(String url, String message) {
        SendMessageRequest sendMessageRequest = new SendMessageRequest()
                .withQueueUrl(url)
                .withMessageBody(message)
                .withDelaySeconds(5);
        sqs.sendMessage(sendMessageRequest);
    }
}
