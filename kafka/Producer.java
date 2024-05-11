package kafka;

public class Producer implements ProducerInterface{
    private KafkaMediator kafkaMediator;
    Producer()
    {
        kafkaMediator = KafkaMediator.getKafkaMediatorInstance();
    }
    @Override
    public void publishMessage(Message message, String topic) {
        kafkaMediator.publishMessageToTopic(topic,message);
    }
}
