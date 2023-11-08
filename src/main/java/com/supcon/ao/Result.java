/**
 * Copyright 2020 bejson.com
 */
package com.supcon.ao;

import java.util.List;

/**
 * Auto-generated: 2020-12-22 17:5:4
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class Result {

    private int eventId;
    private String title;
    private String deviceToken;
    private String deviceName;
    private int skillId;
    private String skillName;
    private int mediaType;
    private long requestTime;
    private long createTime;
    private String originResourceFileKey;
    private String originImageFileKey;
    private String renderImageFileKey;
    private String renderResourceFileKey;
    private SkillInput skillInput;
    private SkillOutput skillOutput;

    public SkillOutput getSkillOutput() {
        return skillOutput;
    }

    public void setSkillOutput(SkillOutput skillOutput) {
        this.skillOutput = skillOutput;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public int getEventId() {
        return eventId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setDeviceToken(String deviceToken) {
        this.deviceToken = deviceToken;
    }

    public String getDeviceToken() {
        return deviceToken;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setSkillId(int skillId) {
        this.skillId = skillId;
    }

    public int getSkillId() {
        return skillId;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setMediaType(int mediaType) {
        this.mediaType = mediaType;
    }

    public int getMediaType() {
        return mediaType;
    }

    public void setRequestTime(long requestTime) {
        this.requestTime = requestTime;
    }

    public long getRequestTime() {
        return requestTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setOriginResourceFileKey(String originResourceFileKey) {
        this.originResourceFileKey = originResourceFileKey;
    }

    public String getOriginResourceFileKey() {
        return originResourceFileKey;
    }

    public void setOriginImageFileKey(String originImageFileKey) {
        this.originImageFileKey = originImageFileKey;
    }

    public String getOriginImageFileKey() {
        return originImageFileKey;
    }

    public void setRenderImageFileKey(String renderImageFileKey) {
        this.renderImageFileKey = renderImageFileKey;
    }

    public String getRenderImageFileKey() {
        return renderImageFileKey;
    }

    public void setRenderResourceFileKey(String renderResourceFileKey) {
        this.renderResourceFileKey = renderResourceFileKey;
    }

    public String getRenderResourceFileKey() {
        return renderResourceFileKey;
    }

    public void setSkillInput(SkillInput skillInput) {
        this.skillInput = skillInput;
    }

    public SkillInput getSkillInput() {
        return skillInput;
    }



    @Override
    public String toString() {
        return "Result{" +
                "eventId=" + eventId +
                ", title='" + title + '\'' +
                ", deviceToken='" + deviceToken + '\'' +
                ", deviceName='" + deviceName + '\'' +
                ", skillId=" + skillId +
                ", skillName='" + skillName + '\'' +
                ", mediaType=" + mediaType +
                ", requestTime=" + requestTime +
                ", createTime=" + createTime +
                ", originResourceFileKey='" + originResourceFileKey + '\'' +
                ", originImageFileKey='" + originImageFileKey + '\'' +
                ", renderImageFileKey='" + renderImageFileKey + '\'' +
                ", renderResourceFileKey='" + renderResourceFileKey + '\'' +
                ", skillInput=" + skillInput +
                ", skillOutput=" + skillOutput +
                '}';
    }
}