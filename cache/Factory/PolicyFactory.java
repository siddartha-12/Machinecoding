package cache.Factory;

import cache.policies.EvictionPolicy;

public class PolicyFactory {
    Factory factory;
    public PolicyFactory(Factory factory){
        this.factory = factory;
    }
    public EvictionPolicy getPolicy(){
        return this.factory.getInstance();
    }
}
