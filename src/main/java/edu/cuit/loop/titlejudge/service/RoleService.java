package edu.cuit.loop.titlejudge.service;

import edu.cuit.loop.titlejudge.entity.Role;
import edu.cuit.loop.titlejudge.mapper.RoleMapper;
import edu.cuit.loop.titlejudge.mapper.RolemoduleMapper;
import edu.cuit.loop.titlejudge.mapper.UserroleMapper;
import edu.cuit.loop.titlejudge.utils.CommonUtils;
import edu.cuit.loop.titlejudge.utils.GetUserRole;
import edu.cuit.loop.titlejudge.vo.RoleWithModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Map;

/**
 * @author VX5
 * @Title: MJC
 * @ProjectName titlejudge
 * @Description: TODO
 * @date ${DAT}10:23
 */
@Service
@Transactional
public class RoleService {
    @Autowired
    RoleMapper roleMapper;
    @Autowired
    UserroleMapper userroleMapper;
    @Autowired
    RolemoduleMapper rolemoduleMapper;

    public void addRole(RoleWithModule role){
        String roleID = CommonUtils.getUUID();
        role.setRoleid(roleID);
        int count = roleMapper.getMaxNum() == null ? 0 : roleMapper.getMaxNum();
        role.setRoleordernum(count+1);
        roleMapper.insertSelective(role);
        rolemoduleMapper.insertForeach(GetUserRole.getRoleModuleList(role.getModules(),roleID));

    }

    public boolean updateRole(RoleWithModule role){
            if (roleMapper.selectByPrimaryKey(role.getRoleid()) != null) {
                if (role.getModules()!=null) {
                    if (role.getModules().equals("")) {//一个模块都没选的情况
                        rolemoduleMapper.deleteByRoleID(role.getRoleid());
                    }else {
                        rolemoduleMapper.deleteByRoleID(role.getRoleid());
                        rolemoduleMapper.insertForeach(GetUserRole.getRoleModuleList(role.getModules(), role.getRoleid()));
                    }
                }
                roleMapper.updateByPrimaryKeySelective(role);
                return true;
            } else {
                return false;
            }

    }

    public void deleteRole(String id){
        userroleMapper.deleteByRoleID(id);
        roleMapper.deleteByPrimaryKey(id);
    }

    public List<Role> selectByLike(Map<String,Object> map){
        List<Role> roles = roleMapper.selectByLike((String) map.get("roleName"));
        return roles;
    }

    public List<Role> seletAllRole(){
        return roleMapper.selectAll();
    }
}
