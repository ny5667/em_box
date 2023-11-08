/**
  * Copyright 2020 bejson.com 
  */
package com.supcon.ao;

/**
 * Auto-generated: 2020-12-22 17:5:4
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class SkillInput {

    private Ext ext;
    private long requestTime;
    private int skillId;
    private boolean debug;
    private Resource resource;
    private String appId;
    private CustomParameter customParameter;
    private String userId;
    private String deviceToken;
    public void setExt(Ext ext) {
         this.ext = ext;
     }
     public Ext getExt() {
         return ext;
     }

    public void setRequestTime(long requestTime) {
         this.requestTime = requestTime;
     }
     public long getRequestTime() {
         return requestTime;
     }

    public void setSkillId(int skillId) {
         this.skillId = skillId;
     }
     public int getSkillId() {
         return skillId;
     }

    public void setDebug(boolean debug) {
         this.debug = debug;
     }
     public boolean getDebug() {
         return debug;
     }

    public void setResource(Resource resource) {
         this.resource = resource;
     }
     public Resource getResource() {
         return resource;
     }

    public void setAppId(String appId) {
         this.appId = appId;
     }
     public String getAppId() {
         return appId;
     }

    public void setCustomParameter(CustomParameter customParameter) {
         this.customParameter = customParameter;
     }
     public CustomParameter getCustomParameter() {
         return customParameter;
     }

    public void setUserId(String userId) {
         this.userId = userId;
     }
     public String getUserId() {
         return userId;
     }

    public void setDeviceToken(String deviceToken) {
         this.deviceToken = deviceToken;
     }
     public String getDeviceToken() {
         return deviceToken;
     }

}