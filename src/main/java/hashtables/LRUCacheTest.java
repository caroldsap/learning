package hashtables;

public class LRUCacheTest {

    public static void main(String args[]){
        LRUCache lruCache = new LRUCache(3);
        System.out.println(lruCache.get(1));
        lruCache.put(1,100);
        System.out.println(lruCache.get(1));
        lruCache.put(2,200);
        lruCache.put(3,300);
        lruCache.put(4,400);
        System.out.println(lruCache.get(1));
    }
}
