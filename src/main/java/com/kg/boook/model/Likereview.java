package com.kg.boook.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Likereview {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long likeid;

    @Column

    private Long bookrewid;

    @Column

    private String Likestatus;

    @Column

    private Long userid;

    /**
     * 
     * @param likeid the likeid to set
     * 
     */

    public void setLikeid(Long likeid) {

        this.likeid = likeid;

    }

    /**
     * 
     * @return the likeid
     * 
     */

    public Long getLikeid() {

        return likeid;

    }

    /**
     * 
     * @param likestatus the likestatus to set
     * 
     */

    public void setLikestatus(String likestatus) {

        this.Likestatus = likestatus;

    }

    /**
     * 
     * @return the likestatus
     * 
     */

    public String getLikestatus() {

        return Likestatus;

    }

    /**
     * 
     * @param userid the userid to set
     * 
     */

    public void setUserid(Long userid) {

        this.userid = userid;

    }

    /**
     * 
     * @param bookrewid the bookrewid to set
     * 
     */

    public void setBookrewid(Long bookrewid) {

        this.bookrewid = bookrewid;

    }

    /**
     * 
     * @return the bookrewid
     * 
     */

    public Long getBookrewid() {

        return bookrewid;

    }

    /**
     * 
     * @return the userid
     * 
     */

    public Long getUserid() {

        return userid;

    }

    @Override

    public String toString() {

        return likeid + " " + Likestatus + " " + userid + " " + bookrewid;

    }

}