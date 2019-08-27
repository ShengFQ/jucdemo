package com.example.datastructure.map;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 文件描述
 * LRUcache是缓存过期策略中的重要算法,没必要自己写一个实现,可以继承
 * @link LinkedHashMap实现
 *
 * @author fuqiang.sheng
 * @date 2019年08月17日 下午5:40
 */
public class LRUCache<K,V> extends LinkedHashMap<K,V> {
    private  int CACHE_SIZE=0;

    /**
     * true表示linkedHashMap按照访问顺序来进行排序,最近访问的放在头部,过期时间最久的放在尾部
     * */
    public LRUCache(int cacheSize){
        super((int)Math.ceil(cacheSize/0.75)+1,0.75f,true);
        CACHE_SIZE=cacheSize;
    }

    /**
     * 缓存删除策略,当map中的数据量大于指定的缓存个数的时候,就自动删除最久的数据.
     * */
    @Override
    protected boolean removeEldestEntry(Map.Entry<K,V> entry){
        return size()>CACHE_SIZE;
    }

}
