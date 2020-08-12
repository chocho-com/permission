package edu.cuit.loop.titlejudge.mapper;

import edu.cuit.loop.titlejudge.entity.Module;
import tk.mybatis.mapper.common.Mapper;

import java.awt.event.MouseAdapter;
import java.util.List;

public interface ModuleMapper extends Mapper<Module> {
    Integer getMaxSort(String parentID);

    List<Module> selectByName(String name);

    List<Module> selectAlls();

    List<Module> selectByParent(String id);
}