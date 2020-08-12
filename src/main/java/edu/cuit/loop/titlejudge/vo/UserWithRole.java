package edu.cuit.loop.titlejudge.vo;

import edu.cuit.loop.titlejudge.entity.Users;

import java.util.List;

/**
 * @author VX5
 * @Title: MJC
 * @ProjectName titlejudge
 * @Description: TODO
 * @date ${DAT}23:03
 */
public class UserWithRole extends Users {
    private String roles;
    private String rolename;
    private String[] roleNames;

    public String[] getRoleNames() {
        return roleNames;
    }

    public void setRoleNames(String[] roleNames) {
        this.roleNames = roleNames;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }
}
