package kafka;

public class Client {
    public static void main(String[] args) {
        Producer producer1 = new Producer();
        Producer producer2 = new Producer();
        Consumer consumer1 = new Consumer(1);
        Consumer consumer2 = new Consumer(2);
        KafkaMediator kafkaMediator = KafkaMediator.getKafkaMediatorInstance();
        kafkaMediator.createTopic("Topic1");
//        kafkaMediator.createTopic("Topic2");
//        kafkaMediator.createTopic("Topic3");
        consumer1.subscribeToTopic("Topic1");
//        consumer1.subscribeToTopic("Topic2");
//        consumer2.subscribeToTopic("Topic3");
        consumer2.subscribeToTopic("Topic1");
        producer1.publishMessage(new Message("Hello this is producer1_Topic1"), "Topic1");
//        producer1.publishMessage(new Message("Hello this is producer1_Topic2"), "Topic2");
//        producer1.publishMessage(new Message("Hello this is producer1_Topic3"), "Topic3");
        producer2.publishMessage(new Message("Hello this is producer2_Topic1"), "Topic1");
//        producer2.publishMessage(new Message("Hello this is producer2_Topic3"), "Topic3");

    }

}
