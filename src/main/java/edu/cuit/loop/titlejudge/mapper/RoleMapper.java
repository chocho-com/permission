package edu.cuit.loop.titlejudge.mapper;

import edu.cuit.loop.titlejudge.entity.Role;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface RoleMapper extends Mapper<Role> {
    List<Role> selectByLike(String name);

    Integer getMaxNum();


}