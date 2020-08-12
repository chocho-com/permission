package edu.cuit.loop.titlejudge.entity;

import javax.persistence.*;

@Table(name = "role")
public class Role {
    @Id
    @Column(name = "RoleID")
    @GeneratedValue(generator = "JDBC")
    private String roleid;

    @Column(name = "RoleName")
    private String rolename;

    @Column(name = "RoleStatus")
    private String rolestatus;

    @Column(name = "RoleOrderNum")
    private Integer roleordernum;

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
     * @return RoleName
     */
    public String getRolename() {
        return rolename;
    }

    /**
     * @param rolename
     */
    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    /**
     * @return RoleStatus
     */
    public String getRolestatus() {
        return rolestatus;
    }

    /**
     * @param rolestatus
     */
    public void setRolestatus(String rolestatus) {
        this.rolestatus = rolestatus;
    }

    /**
     * @return RoleOrderNum
     */
    public Integer getRoleordernum() {
        return roleordernum;
    }

    /**
     * @param roleordernum
     */
    public void setRoleordernum(Integer roleordernum) {
        this.roleordernum = roleordernum;
    }
}