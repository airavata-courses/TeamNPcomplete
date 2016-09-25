package com.milestone1.DbService;

/**
 * Created by soumya on 9/24/16.
 */
/**
 * Created by soumya on 9/24/16.
 */
public class Message {

    Message(){

    }
    private String userId;

    private int reqId;

    private String serviceId;

    private String text;

    public String getUserId() {
        return this.userId;
    }
    public int getReqId() {
        return this.reqId;
    }

    public String getServiceId(){
        return this.serviceId;
    }

    public String getText(){
        return this.text;
    }

    public void setUserId(String id){
        this.userId = id;
    }
    public void setServiceId(String id){
        this.serviceId = id;
    }
    public void setReqId(int id){
        this.reqId = id;
    }
    public void setText(String text){
        this.text = text;
    }
}
