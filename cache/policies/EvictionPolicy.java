package cache.policies;

public interface EvictionPolicy<Key,Value> {
    public Key evictKey();
    public void accessKey(Key key);

}
