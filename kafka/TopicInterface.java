package kafka;

public interface TopicInterface {
    public void publishMessage(Message message);
    public Message getMessage(int offset);
}
