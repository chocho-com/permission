package edu.cuit.loop.titlejudge.utils;

import com.fasterxml.jackson.databind.ser.Serializers;
import edu.cuit.loop.titlejudge.entity.Rolemodule;
import edu.cuit.loop.titlejudge.entity.Userrole;
import edu.cuit.loop.titlejudge.entity.Users;
import edu.cuit.loop.titlejudge.vo.UserWithRole;

import java.util.ArrayList;
import java.util.List;

/**
 * @author VX5
 * @Title: MJC
 * @ProjectName titlejudge
 * @Description: TODO
 * @date ${DAT}20:13
 */
public class GetUserRole {

    public static List<Userrole> getUserRoleList(String role,String id){
        String[] roles = role.split(",");
        List<Userrole> userroles = new ArrayList<>();
        for (String roleid : roles){
            Userrole userrole = new Userrole();
            userrole.setRoleid(roleid);
            userrole.setUserid(id);
            userrole.setUserroleid(CommonUtils.getUUID());
            userroles.add(userrole);
        }
        return userroles;
    }

    public static List<Rolemodule> getRoleModuleList(String module,String id){
        String[] modules = module.split(",");
        List<Rolemodule> rolemodules = new ArrayList<>();
        for (String moduleID:modules){
            Rolemodule rolemodule = new Rolemodule();
            rolemodule.setRolemoduleid(CommonUtils.getUUID());
            rolemodule.setModuleid(moduleID);
            rolemodule.setRoleid(id);
            rolemodules.add(rolemodule);
        }
        return rolemodules;
    }

    public static UserWithRole addUserInUserWithRole(Users users){
        UserWithRole userWithRole = new UserWithRole();
        userWithRole.setLoginphone(users.getLoginphone());
        userWithRole.setUserid(users.getUserid());
        String password = BaseUtils.convertBase(users.getUserpassword().trim());//解密
        userWithRole.setUserpassword(password);//解密MD5
        userWithRole.setUserrealname(users.getUserrealname());
        userWithRole.setUserstatus(users.getUserstatus());
        return userWithRole;
    }
}
