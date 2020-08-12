package edu.cuit.loop.titlejudge.mapper;

import edu.cuit.loop.titlejudge.entity.Rolemodule;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface RolemoduleMapper extends Mapper<Rolemodule> {
    void insertForeach(List<Rolemodule> list);

    void deleteByRoleID(String roleID);

    List<String> selectByRoles(String roleid);
}