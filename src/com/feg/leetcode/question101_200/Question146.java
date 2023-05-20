package leetcode.question101_200;

import java.util.LinkedHashMap;

/**
 * LRU算法
 * @author Feg
 * @version 1.0
 */
public class Question146 {
    class LRUCache {
        LinkedHashMap<Integer,Integer> cache = new LinkedHashMap<>();
        int capacity;

        public LRUCache(int capacity) {
            this.capacity = capacity;
        }

        public int get(int key) {
            if (cache.containsKey(key)) {
                setRecently(key);
                return cache.get(key);
            }
            return -1;
        }

        public void put(int key, int value) {
            if (cache.containsKey(key)) {
                cache.put(key, value);
                setRecently(key);
                return;
            }
            if (cache.size() >= capacity) {
                cache.remove(cache.keySet().iterator().next());
            }
            cache.put(key, value);
        }

        private void setRecently(int key) {
            Integer remove = cache.remove(key);
            cache.put(key, remove);
        }
    }
}
