package kafka;

public interface KafkaInterface {
    public void createTopic(String topicName);
    public void publishMessageToTopic(String topicName, Message message);
    public Message getMessageFromTopic(String topicName, int offset);
}
