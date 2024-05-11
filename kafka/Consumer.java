package kafka;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Consumer implements ConsumerInterface{
    private int id;
    private List<String> subscribedTopics;
    private Map<String,Integer>  topicsOffsetMapping;
    private KafkaMediator kafkaMediator;
    Consumer(int id)
    {
        this.id = id;
        subscribedTopics = new ArrayList<>();
        topicsOffsetMapping = new HashMap<>();
        kafkaMediator = KafkaMediator.getKafkaMediatorInstance();
        startConsuming();

    }
    @Override
    public void subscribeToTopic(String topic) {
        subscribedTopics.add(topic);
        topicsOffsetMapping.put(topic,0);
    }

    @Override
    public void unsubscribeToTopic(String topic) {
            subscribedTopics.remove(topic);
            topicsOffsetMapping.remove(topic);
    }
    private void startConsuming()
    {
        Thread consumerThread = new Thread(this::consume);
        consumerThread.start();
    }
    private void consume()
    {
        while(true)
        {
            for(String topic : subscribedTopics)
            {
                int currentOffset = topicsOffsetMapping.get(topic);
                Message message = kafkaMediator.getMessageFromTopic(topic,currentOffset);
                if(message != null)
                {
                    showMessage(message);
                    currentOffset+=1;
                }
                topicsOffsetMapping.put(topic,currentOffset);
            }
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException exception)
            {
                System.out.println(exception);
            }
        }
    }
    private void showMessage(Message message)
    {
        if(message == null)
            return;
        System.out.println("Consumer_"+this.id+" "+message.getMessage());
    }
}
