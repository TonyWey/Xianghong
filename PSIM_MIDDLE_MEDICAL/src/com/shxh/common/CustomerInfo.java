package com.shxh.common;

import java.util.Objects;

/**
 * 换药室病人信息的实体类
 */
public class CustomerInfo {
    private String wsId;
    private String queueNo;
    private String customerName;
    private String customerType;

    public String getWsId() {
        return wsId;
    }

    public void setWsId(String wsId) {
        this.wsId = wsId;
    }

    public String getQueueNo() {
        return queueNo;
    }

    public void setQueueNo(String queueNo) {
        this.queueNo = queueNo;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    @Override
    public String toString() {
        return "CustomerInfo{" +
                "wsId='" + wsId + '\'' +
                ", queueNo='" + queueNo + '\'' +
                ", customerName='" + customerName + '\'' +
                ", customerType='" + customerType + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CustomerInfo)) return false;
        CustomerInfo that = (CustomerInfo) o;
        return Objects.equals(getWsId(), that.getWsId()) &&
                Objects.equals(getQueueNo(), that.getQueueNo()) &&
                Objects.equals(getCustomerName(), that.getCustomerName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getWsId(), getQueueNo(), getCustomerName());
    }

/*    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(obj == null){
            return false;
        }
        if(getClass() != obj.getClass()){
            return false;
        }
        CustomerInfo other = (CustomerInfo) obj;
        if(other.getQueueNo() == null){
            return false;
        }

        if(queueNo ==null){
            if(other.queueNo != null){
                return false;
            }
        }else  if(queueNo.equals(other.queueNo)){
            return false;
        }
        return true;
    }*/

}
