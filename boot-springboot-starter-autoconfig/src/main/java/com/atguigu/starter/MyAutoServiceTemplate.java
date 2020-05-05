package com.atguigu.starter;

/**
 * @author sunbaojin
 * @date 2020/5/5 8:49
 */
public class MyAutoServiceTemplate {

    private MyAutoProperties myAutoProperties;

    public String sayHello(String name){
        return myAutoProperties.getPrefix()+"=="+name+"==========="+myAutoProperties.getEndfix();
    }

    public MyAutoProperties getMyAutoProperties() {
        return myAutoProperties;
    }

    public void setMyAutoProperties(MyAutoProperties myAutoProperties) {
        this.myAutoProperties = myAutoProperties;
    }
}
