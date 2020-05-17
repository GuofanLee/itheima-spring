package com.itheima.pojo;

import java.util.*;

/**
 * 用于演示复杂类型注入
 *
 * @author GuofanLee
 * @date 2020-05-18 02:49
 */
public class CollectionBean {

    private String[] myArr;
    private List<String> myList;
    private Set<String> mySet;
    private Map<String, String> myMap;
    private Properties myProps;

    public String[] getMyArr() {
        return myArr;
    }

    public void setMyArr(String[] myArr) {
        this.myArr = myArr;
    }

    public List<String> getMyList() {
        return myList;
    }

    public void setMyList(List<String> myList) {
        this.myList = myList;
    }

    public Set<String> getMySet() {
        return mySet;
    }

    public void setMySet(Set<String> mySet) {
        this.mySet = mySet;
    }

    public Map<String, String> getMyMap() {
        return myMap;
    }

    public void setMyMap(Map<String, String> myMap) {
        this.myMap = myMap;
    }

    public Properties getMyProps() {
        return myProps;
    }

    public void setMyProps(Properties myProps) {
        this.myProps = myProps;
    }

    @Override
    public String toString() {
        return "CollectionBean{" +
                "myArr=" + Arrays.toString(myArr) +
                ", myList=" + myList +
                ", mySet=" + mySet +
                ", myMap=" + myMap +
                ", myProps=" + myProps +
                '}';
    }

}
