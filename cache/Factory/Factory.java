package cache.Factory;

import cache.policies.EvictionPolicy;

public interface Factory {
    public EvictionPolicy getInstance();
}
