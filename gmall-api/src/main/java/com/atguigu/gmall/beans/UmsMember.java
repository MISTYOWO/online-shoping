package com.atguigu.gmall.beans;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

public class UmsMember implements Serializable {
    private String birthday;
    private String city;
    private Date createTime;
    private int gender;

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getGrowth() {
        return growth;
    }

    public void setGrowth(int growth) {
        this.growth = growth;
    }

    public int getHistoryIntegration() {
        return historyIntegration;
    }

    public void setHistoryIntegration(int historyIntegration) {
        this.historyIntegration = historyIntegration;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getIntegration() {
        return integration;
    }

    public void setIntegration(int integration) {
        this.integration = integration;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getLuckeyCount() {
        return luckeyCount;
    }

    public void setLuckeyCount(int luckeyCount) {
        this.luckeyCount = luckeyCount;
    }

    public String getMemberLevelId() {
        return memberLevelId;
    }

    public void setMemberLevelId(String memberLevelId) {
        this.memberLevelId = memberLevelId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPersonalizedSignature() {
        return personalizedSignature;
    }

    public void setPersonalizedSignature(String personalizedSignature) {
        this.personalizedSignature = personalizedSignature;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getSourceType() {
        return sourceType;
    }

    public void setSourceType(int sourceType) {
        this.sourceType = sourceType;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private int growth;
    private int historyIntegration;
    private String icon;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private int integration;
    private String job;
    private int luckeyCount;
    private String memberLevelId;
    private String nickname;
    private String password;
    private String personalizedSignature;
    private String phone;
    private int sourceType;
    private int status;
    private String username;



}
