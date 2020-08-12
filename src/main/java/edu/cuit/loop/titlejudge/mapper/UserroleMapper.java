package edu.cuit.loop.titlejudge.mapper;

import edu.cuit.loop.titlejudge.entity.Userrole;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface UserroleMapper extends Mapper<Userrole> {
    void deleteByUserID(String userid);

    void insertForeach(List<Userrole> userroles);

    void deleteByRoleID(String roleid);

    List<String> selectByLoginName(String loginphone);
}