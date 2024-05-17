package cache.policies;

import cache.Exceptions.EmptyList;
import cache.Exceptions.KeyNotFound;
import cache.doubleLinkedList.DoubleLinkedList;
import cache.doubleLinkedList.DoubleLinkedListNode;

import java.util.HashMap;
import java.util.Map;

public class LruEvictionPolicy<Key,Value> implements EvictionPolicy<Key,Value>{
    private DoubleLinkedList<Key> doubleLinkedList;
    private Map<Key,DoubleLinkedListNode<Key>>  keyDoubleLinkedListNodeMap;

    public LruEvictionPolicy(){
        doubleLinkedList = new DoubleLinkedList<>();
        keyDoubleLinkedListNodeMap = new HashMap<>();
    }

    @Override
    public Key evictKey() {
        try {
            DoubleLinkedListNode<Key> doubleLinkedListNode = doubleLinkedList.removeLastNode();
            keyDoubleLinkedListNodeMap.remove(doubleLinkedListNode.value);
            return doubleLinkedListNode.value;
        }
        catch (EmptyList emptyList){
            System.out.println("List is Empty");
        }
        return null;
    }

    @Override
    public void accessKey(Key key) {
        if(!keyDoubleLinkedListNodeMap.containsKey(key)){
            DoubleLinkedListNode<Key> doubleLinkedListNode = new DoubleLinkedListNode<>(key);
            keyDoubleLinkedListNodeMap.put(key,doubleLinkedListNode);
            doubleLinkedList.addNewNode(doubleLinkedListNode);
        }
        doubleLinkedList.addAtFirst(keyDoubleLinkedListNodeMap.get(key));

    }
}
