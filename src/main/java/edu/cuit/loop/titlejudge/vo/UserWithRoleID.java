package edu.cuit.loop.titlejudge.vo;

import edu.cuit.loop.titlejudge.entity.Users;
import org.apache.tomcat.jni.User;

/**
 * @author VX5
 * @Title: MJC
 * @ProjectName titlejudge
 * @Description: TODO
 * @date ${DAT}16:42
 */
public class UserWithRoleID extends Users {
    private String roleid;

    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid;
    }
}
