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
public class Resource {

    private long requestTime;
    private String path;
    private List<Object> areas;
    private String type;

    public void setRequestTime(long requestTime) {
        this.requestTime = requestTime;
    }

    public long getRequestTime() {
        return requestTime;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void setAreas(List<Object> areas) {
        this.areas = areas;
    }

    public List<Object> getAreas() {
        return areas;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

}