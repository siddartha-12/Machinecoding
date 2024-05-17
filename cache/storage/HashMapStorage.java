package cache.storage;


import cache.Exceptions.KeyNotFound;
import cache.Exceptions.StorageFull;

import java.util.HashMap;
import java.util.Map;

public class HashMapStorage <Key,Value> implements Storage<Key,Value> {
    Map<Key,Value> keyValueMap ;
    private final Integer capacity;

    public HashMapStorage(Integer capacity){
        this.capacity = capacity;
        keyValueMap = new HashMap<>();
    }

    @Override
    public void add(Key key, Value value) {
        if(keyValueMap.containsKey(key)){
            keyValueMap.put(key,value);
        }
        else{
            if(isStorageFull()) {
                throw new StorageFull();
            }
            else {
                keyValueMap.put(key,value);
            }
        }
    }

    @Override
    public Value get(Key key) {
        try {
            Value value = keyValueMap.get(key);
            return value;
        }
        catch (KeyNotFound keyNotFound){
            throw new KeyNotFound();
        }
    }

    @Override
    public void remove(Key key) {
        if(keyValueMap.containsKey(key)){
            keyValueMap.remove(key);
        }
        else {
            throw new KeyNotFound();
        }
    }

    private boolean isStorageFull(){
        return capacity== keyValueMap.size();
    }
}
