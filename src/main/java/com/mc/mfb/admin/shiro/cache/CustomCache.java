package com.mc.mfb.admin.shiro.cache;

import com.mc.mfb.admin.util.Constant;
import com.mc.mfb.admin.util.JwtUtil;
import com.mc.mfb.admin.util.RedisUtil;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.Set;


/**
 * 重写Shiro的Cache保存读取
 */
public class CustomCache<K,V> implements Cache<K,V> {


    @Autowired
    private RedisUtil redisUtil;

    /**
     * 缓存的key名称获取为shiro:cache:account
     */
    private String getKey(Object key) {
        return Constant.PREFIX_SHIRO_CACHE + JwtUtil.getClaim(key.toString(), Constant.ACCOUNT);
    }

    /**
     * 获取缓存
     */
    @Override
    public Object get(Object key) throws CacheException {
        if(!redisUtil.isHaveKey(this.getKey(key))){
            return null;
        }
        return redisUtil.get(this.getKey(key));
    }

    /**
     * 保存缓存
     */
    @Override
    public Object put(Object key, Object value) throws CacheException {
        // 设置Redis的Shiro缓存
        return redisUtil.set(this.getKey(key), value,Constant.EXRP_MINUTE);
    }

    /**
     * 移除缓存
     */
    @Override
    public Object remove(Object key) throws CacheException {
        if(!redisUtil.isHaveKey(this.getKey(key))){
            return null;
        }
        redisUtil.del(this.getKey(key));
        return null;
    }

    /**
     * 清空所有缓存
     */
    @Override
    public void clear() throws CacheException {
        redisUtil.del();
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Set<K> keys() {
        return null;
    }

    @Override
    public Collection<V> values() {
        return null;
    }
}
