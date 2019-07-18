package aws.sqs;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.SendMessageRequest;

public class Sender {

    AmazonSQS sqs = AmazonSQSClientBuilder.defaultClient();

    public void send(String url, String message) {
        SendMessageRequest sendMessageRequest = new SendMessageRequest()
                .withQueueUrl(url)
                .withMessageBody(message)
                .withDelaySeconds(5);
        sqs.sendMessage(sendMessageRequest);
    }
}
