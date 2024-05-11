package kafka;

public interface ConsumerInterface {
    public void subscribeToTopic(String topic);
    public void unsubscribeToTopic(String topic);
}
