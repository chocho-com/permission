package edu.cuit.loop.titlejudge.entity;

import javax.persistence.*;

@Table(name = "userRole")
public class Userrole {
    @Id
    @Column(name = "UserRoleID")
    @GeneratedValue(generator = "JDBC")
    private String userroleid;

    @Column(name = "RoleID")
    private String roleid;

    @Column(name = "UserID")
    private String userid;

    /**
     * @return UserRoleID
     */
    public String getUserroleid() {
        return userroleid;
    }

    /**
     * @param userroleid
     */
    public void setUserroleid(String userroleid) {
        this.userroleid = userroleid;
    }

    /**
     * @return RoleID
     */
    public String getRoleid() {
        return roleid;
    }

    /**
     * @param roleid
     */
    public void setRoleid(String roleid) {
        this.roleid = roleid;
    }

    /**
     * @return UserID
     */
    public String getUserid() {
        return userid;
    }

    /**
     * @param userid
     */
    public void setUserid(String userid) {
        this.userid = userid;
    }
}