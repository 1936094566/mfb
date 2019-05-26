package com.mc.mfb.admin.serivce.impl;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.mc.mfb.admin.dao.KeyDao;
import com.mc.mfb.admin.entity.ExcelModel.Key;
import com.mc.mfb.admin.serivce.KeyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 * @Created with IDEA
 * @author:麻超
 * @Date:2019/5/18
 * @Time:11:12
 **/
@Service
public class KeyServiceImpl implements KeyService {
    @Autowired
    private KeyDao keydao;
    int key = -1;
    @Override
    @Transactional(rollbackFor = NullPointerException.class)
    public void addKey(List<Key> keys) {
        key ++;
        try{
            int i = 1;
            for(Key key :keys){
                keydao.insert(key);
                i++;
                if(i == 5){
                    throw new NullPointerException();
                }
            }
        }catch(Exception ex){
            System.out.print("出错误了");
            System.out.println(key);

        }

    }
}
