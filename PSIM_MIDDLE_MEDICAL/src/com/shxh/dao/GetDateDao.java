package com.shxh.dao;

import com.shxh.common.CustomerInfo;

import java.util.List;

public interface GetDateDao {

    public List<CustomerInfo> getMedical();

    public void insertData(List<CustomerInfo> list);
}
