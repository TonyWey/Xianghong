package com.shxh.quartz;

import com.shxh.common.CustomerInfo;
import com.shxh.dao.impl.GetDataDaoImpl;

import java.util.Date;
import java.util.List;

/**
 * 定时器启动加载
 */
public class Updata {
    public int work(){

        long s = System.currentTimeMillis();
        System.out.println("开始调度："+new Date(s));
        GetDataDaoImpl data = new GetDataDaoImpl();
        //从his数据库得到数据
        List<CustomerInfo> list = data.getMedical();
        System.out.println("定时器中的:"+list);
        //判断取出数据为空则不插入数据
        if(list.size() == 0){
            return 0;
        }
        //插入数据到本地数据库
        data.insertData(list);
        System.out.println("插入成功!!");
        return 0;
    }

}
