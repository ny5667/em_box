/**
  * Copyright 2020 bejson.com 
  */
package com.supcon.ao;
import java.io.Serializable;
import java.util.List;

/**
 * Auto-generated: 2020-12-22 17:5:4
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class SkillOutput implements Serializable {

    private boolean normal;
    private List<PersonsNotWearingHelmet> personsWearingHelmet;
    private List<PersonsNotWearingHelmet> personsNotWearingHelmet;
    public void setNormal(boolean normal) {
         this.normal = normal;
     }
     public boolean getNormal() {
         return normal;
     }


    public boolean isNormal() {
        return normal;
    }

    public List<PersonsNotWearingHelmet> getPersonsWearingHelmet() {
        return personsWearingHelmet;
    }

    public void setPersonsWearingHelmet(List<PersonsNotWearingHelmet> personsWearingHelmet) {
        this.personsWearingHelmet = personsWearingHelmet;
    }

    public void setPersonsNotWearingHelmet(List<PersonsNotWearingHelmet> personsNotWearingHelmet) {
         this.personsNotWearingHelmet = personsNotWearingHelmet;
     }
     public List<PersonsNotWearingHelmet> getPersonsNotWearingHelmet() {
         return personsNotWearingHelmet;
     }

}