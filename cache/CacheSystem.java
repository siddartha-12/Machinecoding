package cache;

import cache.Exceptions.EmptyList;
import cache.Exceptions.KeyNotFound;
import cache.Exceptions.StorageFull;
import cache.policies.EvictionPolicy;
import cache.storage.Storage;

public class CacheSystem<Key,Value>{

    private Storage<Key,Value> storage;
    private EvictionPolicy<Key,Value> evictionPolicy;
    public CacheSystem(Storage<Key,Value> storage, EvictionPolicy<Key,Value> evictionPolicy){
        this.storage = storage;
        this.evictionPolicy = evictionPolicy;
    }
    public void add(Key key,Value value){
        try {
            storage.add(key, value);
            evictionPolicy.accessKey(key);
        }
        catch (StorageFull storageFull){
            System.out.println("storage is full");
            try {
                Key deletedKey = evictionPolicy.evictKey();
                storage.remove(deletedKey);
                storage.add(key,value);
                evictionPolicy.accessKey(key);
            }
            catch (EmptyList emptyList){
                System.out.println("List capacity is 0");
            }
            catch (KeyNotFound keyNotFound){
                System.out.println("Key not found in Memory");
            }
        }

    }
    public Value get(Key key){
        try {
            Value value = storage.get(key);
            evictionPolicy.accessKey(key);
            return value;
        }
        catch (KeyNotFound keyNotFound){
            System.out.println("Key not Found");
        }
        return null;
    }
    public static

}
