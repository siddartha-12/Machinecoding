package cache.policies;

import cache.Exceptions.EmptyList;
import cache.doubleLinkedList.DoubleLinkedListNode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class FifoEvictionPolicy<Key,Value> implements EvictionPolicy<Key,Value>{
    private Queue<Key> queue;
    private Set<Key> availableKeys;

    public FifoEvictionPolicy(){
        queue = new LinkedList<>();
        availableKeys = new HashSet<>();
    }
    @Override
    public Key evictKey() {
        if(queue.isEmpty()){
            throw new EmptyList();
        }
        return queue.poll();
    }

    @Override
    public void accessKey(Key key) {
        if(!availableKeys.contains(key)) {
            queue.add(key);
        }
    }
}
