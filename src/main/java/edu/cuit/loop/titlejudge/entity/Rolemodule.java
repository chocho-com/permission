package edu.cuit.loop.titlejudge.entity;

import javax.persistence.*;

@Table(name = "roleModule")
public class Rolemodule {
    @Id
    @Column(name = "RoleModuleID")
    @GeneratedValue(generator = "JDBC")
    private String rolemoduleid;

    @Column(name = "RoleID")
    private String roleid;

    @Column(name = "ModuleID")
    private String moduleid;

    /**
     * @return RoleModuleID
     */
    public String getRolemoduleid() {
        return rolemoduleid;
    }

    /**
     * @param rolemoduleid
     */
    public void setRolemoduleid(String rolemoduleid) {
        this.rolemoduleid = rolemoduleid;
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
     * @return ModuleID
     */
    public String getModuleid() {
        return moduleid;
    }

    /**
     * @param moduleid
     */
    public void setModuleid(String moduleid) {
        this.moduleid = moduleid;
    }
}