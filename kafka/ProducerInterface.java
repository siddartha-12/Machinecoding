package kafka;

public interface ProducerInterface {
    public void publishMessage(Message message,String topic);
}
