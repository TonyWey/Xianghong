package com.shxh.common;

public class Show {

    private String srvGroup;
    private String doctorName;
    private String holdNum;
    private String totalNum;

    public String getSrvGroup() {
        return srvGroup;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public String getHoldNum() {
        return holdNum;
    }

    public String getTotalNum() {
        return totalNum;
    }

    public void setSrvGroup(String srvGroup) {
        this.srvGroup = srvGroup;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public void setHoldNum(String holdNum) {
        this.holdNum = holdNum;
    }

    public void setTotalNum(String totalNum) {
        this.totalNum = totalNum;
    }

    @Override
    public String toString() {
        return "Show{" +
                "srvGroup='" + srvGroup + '\'' +
                ", doctorName='" + doctorName + '\'' +
                ", holdNum=" + holdNum +
                ", totalNum=" + totalNum +
                '}';
    }
}
