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
public class JsonRootBean {

    private int error_code;
    private long log_id;
    private String trace_id;
    private Result result;
    public void setError_code(int error_code) {
         this.error_code = error_code;
     }
     public int getError_code() {
         return error_code;
     }

    public void setLog_id(long log_id) {
         this.log_id = log_id;
     }
     public long getLog_id() {
         return log_id;
     }

    public void setTrace_id(String trace_id) {
         this.trace_id = trace_id;
     }
     public String getTrace_id() {
         return trace_id;
     }

    public void setResult(Result result) {
         this.result = result;
     }
     public Result getResult() {
         return result;
     }

    @Override
    public String toString() {
        return "JsonRootBean{" +
                "error_code=" + error_code +
                ", log_id=" + log_id +
                ", trace_id='" + trace_id + '\'' +
                ", result=" + result +
                '}';
    }
}