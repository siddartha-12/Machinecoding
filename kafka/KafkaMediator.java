package kafka;
import java.util.HashMap;
import java.util.Map;

public class KafkaMediator implements KafkaInterface {
    private Map<String,Topic> topicObjectsMapping;
    public static KafkaMediator kafkaMediatorInstance = null;
    private KafkaMediator()
    {
        topicObjectsMapping = new HashMap<>();
    }
    @Override
    public void createTopic(String topicName) {
        if(!topicObjectsMapping.containsKey(topicName))
        {
            topicObjectsMapping.put(topicName,new Topic(topicName));
        }
    }

    @Override
    public void publishMessageToTopic(String topicName, Message message) {
        if(topicObjectsMapping.containsKey(topicName))
        {
            topicObjectsMapping.get(topicName).publishMessage(message);
        }
        else {
            System.out.println("Topic "+topicName+" Not Found.");
        }
    }

    @Override
    public Message getMessageFromTopic(String topicName, int offset) {
        if(topicObjectsMapping.containsKey(topicName))
        {
            return topicObjectsMapping.get(topicName).getMessage(offset);
        }
        else {
            System.out.println("Topic "+topicName+" Not Found.");
            return null;
        }
    }

    public static KafkaMediator getKafkaMediatorInstance() {

       if(kafkaMediatorInstance == null)
       {
           synchronized (KafkaMediator.class)
           {
               if(kafkaMediatorInstance == null)
               {
                   kafkaMediatorInstance = new KafkaMediator();
               }
           }
       }
       return kafkaMediatorInstance;
    }
}
