package edu.cuit.loop.titlejudge.mapper;

import edu.cuit.loop.titlejudge.entity.Userrole;
import edu.cuit.loop.titlejudge.entity.Users;
import edu.cuit.loop.titlejudge.vo.UserWithRole;
import edu.cuit.loop.titlejudge.vo.UserWithRoleID;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface UsersMapper extends Mapper<Users> {
    List<Users> selectByLike(Map<String,Object> map);

    List<UserWithRole> selectRoleByID(String id);

    Users selectPassWord(String name);

    List<UserWithRoleID> selectRoleIdByID(String id);

    void updatePassword(Map<String,String> map);
}