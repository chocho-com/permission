package edu.cuit.loop.titlejudge.vo;

import edu.cuit.loop.titlejudge.entity.Role;

/**
 * @author VX5
 * @Title: MJC
 * @ProjectName titlejudge
 * @Description: TODO
 * @date ${DAT}16:51
 */
public class RoleWithModule extends Role {
    private String modules;

    public String getModules() {
        return modules;
    }

    public void setModules(String modules) {
        this.modules = modules;
    }
}
