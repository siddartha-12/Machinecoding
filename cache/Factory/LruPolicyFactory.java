package cache.Factory;

import cache.policies.EvictionPolicy;
import cache.policies.LruEvictionPolicy;

public class LruPolicyFactory<Key,Value> implements Factory{
    @Override
    public EvictionPolicy<Key,Value> getInstance() {
        return new LruEvictionPolicy<Key,Value>();
    }
}
