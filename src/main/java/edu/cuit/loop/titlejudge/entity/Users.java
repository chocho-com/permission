package edu.cuit.loop.titlejudge.entity;

import javax.persistence.*;
import java.util.Objects;

@Table(name = "users")
public class Users {
    @Id
    @Column(name = "UserID")
    @GeneratedValue(generator = "JDBC")
    private String userid;

    @Column(name = "LoginPhone")
    private String loginphone;

    @Column(name = "UserPassWord")
    private String userpassword;

    @Column(name = "UserRealName")
    private String userrealname;

    @Column(name = "UserStatus")
    private String userstatus;


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

    /**
     * @return LoginPhone
     */
    public String getLoginphone() {
        return loginphone;
    }

    /**
     * @param loginphone
     */
    public void setLoginphone(String loginphone) {
        this.loginphone = loginphone;
    }

    /**
     * @return UserPassWord
     */
    public String getUserpassword() {
        return userpassword;
    }

    /**
     * @param userpassword
     */
    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    /**
     * @return UserRealName
     */
    public String getUserrealname() {
        return userrealname;
    }

    /**
     * @param userrealname
     */
    public void setUserrealname(String userrealname) {
        this.userrealname = userrealname;
    }

    /**
     * @return UserStatus
     */
    public String getUserstatus() {
        return userstatus;
    }

    /**
     * @param userstatus
     */
    public void setUserstatus(String userstatus) {
        this.userstatus = userstatus;
    }
}