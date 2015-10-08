package com.softtanck.imchat.bean;

/**
 * @author : Tanck
 * @Description : TODO 联系人消息Bean
 * @date 10/8/2015
 */
public class ContractMsg {

    private String id;//id

    private String lastMsg;//最后一条消息

    private String name;//名字

    private Long time;//时间

    private String headUrl;//联系人头像地址

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLastMsg() {
        return lastMsg;
    }

    public void setLastMsg(String lastMsg) {
        this.lastMsg = lastMsg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public String getHeadUrl() {
        return headUrl;
    }

    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl;
    }
}
