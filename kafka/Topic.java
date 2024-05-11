package kafka;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class Topic implements TopicInterface{
    private String name;
    private List<Message> messages;
    ReentrantLock lock ;
    Topic(String name)
    {
        this.name = name;
        messages = new ArrayList<>();
        lock = new ReentrantLock(true);
    }

    @Override
    public void publishMessage(Message message) {
        lock.lock();
        messages.add(message);
        lock.unlock();
    }

    @Override
    public Message getMessage(int offset) {
        if(offset<messages.size())
        {
            return messages.get(offset);
        }
        return null;
    }
}
