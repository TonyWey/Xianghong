package com.shxh.common;

public class User {

    private int name;

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    private String age;

    @Override
    public String toString() {
        return "User{" +
                "name=" + name +
                ", age=" + age +
                '}';
    }

    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(obj == null){
            return false;
        }
        if(getClass() != obj.getClass()){
            return false;
        }
        User other = (User)obj;
        if(other.getAge() == null){
            return false;
        }

        if(age ==null){
            if(other.age != null){
                return false;
            }
        }else  if(age.equals(other.age)){
            return false;
        }
        return true;
    }
}
