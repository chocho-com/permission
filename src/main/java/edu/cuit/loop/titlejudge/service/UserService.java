package edu.cuit.loop.titlejudge.service;

import edu.cuit.loop.titlejudge.entity.Userrole;
import edu.cuit.loop.titlejudge.entity.Users;
import edu.cuit.loop.titlejudge.mapper.UserroleMapper;
import edu.cuit.loop.titlejudge.mapper.UsersMapper;
import edu.cuit.loop.titlejudge.utils.BaseUtils;
import edu.cuit.loop.titlejudge.utils.CommonUtils;
import edu.cuit.loop.titlejudge.utils.GetUserRole;
import edu.cuit.loop.titlejudge.vo.UserWithRole;
import edu.cuit.loop.titlejudge.vo.UserWithRoleID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author VX5
 * @Title: MJC
 * @ProjectName titlejudge
 * @Description: TODO
 * @date ${DAT}10:17
 */
@Service
@Transactional
public class UserService {
    @Autowired
    UsersMapper userMapper;
    @Autowired
    UserRoleService userRoleService;
    @Autowired
    UserroleMapper userroleMapper;

    public boolean addUser(Users user,String roles)throws Exception {
        if (userMapper.selectPassWord(user.getLoginphone())==null) {
            user.setUserid(CommonUtils.getUUID());
            List<Userrole> userroles = GetUserRole.getUserRoleList(roles, user.getUserid());//添加多对多中表的信息
            user.setUserpassword(BaseUtils.baseEncode(user.getUserpassword()));
            userMapper.insertSelective(user);
            userRoleService.addList(userroles);

            return true;
        }else {
            return false;
        }
    }

    public void updateUser(Users user,String roles) throws Exception{
        user.setUserpassword(BaseUtils.baseEncode(user.getUserpassword().trim()));//密码加密
        userRoleService.deleteByUserID(user.getUserid());//先清空该用户的所有角色信息（重置用户角色信息)
        userRoleService.addList(GetUserRole.getUserRoleList(roles,user.getUserid()));//通过工具类获取角色信息并且添加到多对多表中
        userMapper.updateByPrimaryKeySelective(user);
    }

    public void deleteUser(String id){
        userRoleService.deleteByUserID(id);
        userMapper.deleteByPrimaryKey(id);
    }

    //根据用户名以及用户真实姓名进行模糊查询
    public List<UserWithRole> selectByLike(Map<String,Object> map){
        List<Users> users = userMapper.selectByLike(map);
        List<UserWithRole> userWithRoleList = new ArrayList<>();
        UserWithRole userWithRole = new UserWithRole();
        for (Users user:users){
            List<UserWithRole> userWithRoles = userMapper.selectRoleByID(user.getUserid());//每个用户对的角色名称
            if (userWithRoles.get(0)!=null) {
                String[] roleNames = new String[userWithRoles.size()];//当前角色的角色名称数组
                for (int i = 0; i < userWithRoles.size(); i++){
                    roleNames[i] = userWithRoles.get(i).getRolename();
                }
                userWithRole = GetUserRole.addUserInUserWithRole(user);//将User的信息赋值给UserWithRole
                userWithRole.setRoleNames(roleNames);
            }else {
                userWithRole = GetUserRole.addUserInUserWithRole(user);
                String[] error = {"暂无对应角色"};
                userWithRole.setRoleNames(error);
            }
            userWithRoleList.add(userWithRole);
        }
        return userWithRoleList;
    }

    public Map<String,Object> selectById(String id){
       Users users = userMapper.selectByPrimaryKey(id);
       users.setUserpassword(BaseUtils.convertBase(users.getUserpassword().trim()));
        List<UserWithRoleID> userWithRoles = userMapper.selectRoleIdByID(id);
        Map<String, Object> map = new HashMap<>();
        if (users==null){
            map.put("user","查无此用户");
        }else {
            map.put("user",users);
        }
        if (userWithRoles.size()>0) {
            if (userWithRoles.get(0) != null) {
                String[] roles = new String[userWithRoles.size()];
                for (int i = 0; i < userWithRoles.size(); i++) {
                    roles[i] = userWithRoles.get(i).getRoleid();
                }
                map.put("roles", roles);
            } else {
                map.put("roles", "暂无对应角色");
            }
        }else {
            map.put("roles", "暂无对应角色");
        }
        map.put("token",BaseUtils.baseEncode(users.getLoginphone()));//返回token
        return map;
    }

    public Users selectByUserName(String name){
        return userMapper.selectPassWord(name);
    }

    public List<String> getRolesByLoginPhone(String loginPhone){
        return userroleMapper.selectByLoginName(loginPhone);
    }

    public boolean updatePassword(Map<String,String> map){
        Users users = userMapper.selectByPrimaryKey(map.get("userid").trim());
        if (users!=null) {
            String userpassword = BaseUtils.baseEncode(map.get("password"));
            map.put("userpassword", userpassword);
            userMapper.updatePassword(map);
            return true;
        }else {
            return false;
        }
    }
}
