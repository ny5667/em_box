package com.supcon.ao;

/**
 * @author zhangjunwei1
 */
public class EventNotify {

    private Long eventId;
    private Integer skillId;
    private String deviceToken;

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public Integer getSkillId() {
        return skillId;
    }

    public void setSkillId(Integer skillId) {
        this.skillId = skillId;
    }

    public String getDeviceToken() {
        return deviceToken;
    }

    public void setDeviceToken(String deviceToken) {
        this.deviceToken = deviceToken;
    }

    @Override
    public String toString() {
        return "EventNotify{" +
                "eventId=" + eventId +
                ", skillId=" + skillId +
                ", deviceToken='" + deviceToken + '\'' +
                '}';
    }
}
