package cache;

import cache.Factory.Factory;
import cache.Factory.LruPolicyFactory;
import cache.Factory.PolicyFactory;
import cache.doubleLinkedList.DoubleLinkedList;
import cache.doubleLinkedList.DoubleLinkedListNode;
import cache.policies.EvictionPolicy;
import cache.policies.FifoEvictionPolicy;
import cache.policies.LruEvictionPolicy;
import cache.storage.HashMapStorage;
import cache.storage.Storage;

public class Client {
    public static void main(String[] args) {
//        EvictionPolicy<Integer,Integer> evictionPolicy = new LruEvictionPolicy<>();
//        Storage<Integer,Integer> storage = new HashMapStorage<>(3);
//        CacheSystem<Integer,Integer> cacheSystem = new CacheSystem<>(storage,evictionPolicy);
//        cacheSystem.add(1,3);
//        cacheSystem.add(2,5);
//        cacheSystem.add(3,6);
//        System.out.println(cacheSystem.get(2));
//        cacheSystem.add(4,10);
//        System.out.println(cacheSystem.get(4));
//        System.out.println(cacheSystem.get(1));
//        System.out.println(cacheSystem.get(3));
//        System.out.println(cacheSystem.get(2));
//        cacheSystem.add(4,10);
//        System.out.println(cacheSystem.get(1));
//        System.out.println(cacheSystem.get(3));
//        System.out.println(cacheSystem.get(2));
//        System.out.println(cacheSystem.get(4));
        Factory factory = new LruPolicyFactory<Integer,Integer>();
        PolicyFactory policyFactory = new PolicyFactory(factory);
        EvictionPolicy<Integer,Integer> evictionPolicy = policyFactory.getPolicy();
        Storage<Integer,Integer> storage = new HashMapStorage<>(3);
        CacheSystem<Integer,Integer> cacheSystem = new CacheSystem<>(storage,evictionPolicy);
        cacheSystem.add(1,3);
        cacheSystem.add(2,5);
        cacheSystem.add(3,6);
        cacheSystem.add(4,10);
        System.out.println(cacheSystem.get(1));
        System.out.println(cacheSystem.get(4));

    }
}
