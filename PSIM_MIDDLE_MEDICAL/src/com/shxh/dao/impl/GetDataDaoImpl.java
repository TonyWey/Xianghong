package com.shxh.dao.impl;

import com.shxh.common.ConnectionFactory;
import com.shxh.common.CustomerInfo;
import com.shxh.common.User;
import com.shxh.dao.GetDateDao;
import oracle.jdbc.OracleTypes;

import java.sql.*;
import java.util.*;

/**
 * 数据逻辑处理
 */
public class GetDataDaoImpl implements GetDateDao {

    /**
     * 从联众获取数据进行处理
     * @return
     */
    @Override
    public List<CustomerInfo> getMedical() {

        List<CustomerInfo> list1 = new ArrayList<>();
        List<CustomerInfo> list = new ArrayList<>();
        Connection hisConn = null;
        Connection conn = null;
        CustomerInfo cf = null;
        try {
            //先查询本机数据库
            conn = ConnectionFactory.getConnection();
            String sql = "select WS_ID,QUEUE_NO,CUSTOMER_NAME,CUSTOMER_TYPE from BASIC_MEDICALROOM";
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                cf = new CustomerInfo();
                cf.setWsId(rs.getString(1));
                cf.setQueueNo(rs.getString(2));
                cf.setCustomerName(rs.getString(3));
                cf.setCustomerType(rs.getString(4));
                list1.add(cf);
            }
            System.out.println("查询出来的值:"+list1);
            //查询联众的数据库
            hisConn = ConnectionFactory.getHisConnection();
            //sqlserve数据库的结果集
            CallableStatement cs = hisConn.prepareCall("{call proc_mz_get_dept74_qno}");
            ResultSet hisRs = cs.executeQuery();

            //利用oracle游标来调用多行结果集
            /*CallableStatement cs = hisConn.prepareCall("{call proc_mz_get_dept74_qno(?)}");
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.execute();*/
            //调用oracle单行结果集的存储过程
            /*cs.registerOutParameter(1,Types.VARCHAR);
            cs.registerOutParameter(2,Types.VARCHAR);
            cs.registerOutParameter(3,Types.VARCHAR);*/

          //  ResultSet hisRs = (ResultSet) cs.getObject(1);
            while(hisRs.next()){
               CustomerInfo cf1 = new CustomerInfo();
                cf1.setWsId(hisRs.getString(1));
                cf1.setQueueNo(hisRs.getString(2));
                cf1.setCustomerName(hisRs.getString(3));
                cf1.setCustomerType("0");
                System.out.println("查出来的cf1："+cf1);
                System.out.println("lol:"+list1.contains(cf1));
                System.out.println("第一次的list1:"+list1);
                System.out.println("lo2"+!list1.contains(cf1));
                if(!list1.contains(cf1)){
                    System.out.println("开始添加");
                    list.add(cf1);
                }

            }
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            ConnectionFactory.close(hisConn);
            ConnectionFactory.close(conn);
        }

        return list;
    }

    /**
     * 将获取到联众数据处理好后插入PSIM_WGK_ZJ库
     * @param list
     */
    @Override
    public void insertData(List<CustomerInfo> list) {
        Connection conn = null;
        try {
            conn = ConnectionFactory.getConnection();
            String sql = "insert into BASIC_MEDICALROOM (WS_ID,QUEUE_NO,CUSTOMER_NAME,CUSTOMER_TYPE) values (?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            for(int i=list.size()-1;i>=0;i--){
                ps.setString(1,list.get(i).getWsId());
                ps.setString(2,list.get(i).getQueueNo());
                ps.setString(3,list.get(i).getCustomerName());
                ps.setString(4,list.get(i).getCustomerType());
                ps.addBatch();
                list.remove(i);
            }
           ps.executeBatch();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            ConnectionFactory.close(conn);
        }
    }


    public static void main(String[] args) {
        int a = 5;
        List<Integer> list1 = new ArrayList<Integer>(5);
        list1.add(3);
        list1.add(2);
        list1.add(1);
        System.out.println("list1的值:"+list1);
        List list = new ArrayList(list1);
        System.out.println("list==的值:"+list);

    }
}
