package edu.cuit.loop.titlejudge.utils;
/*
 * Author: lht
 * Date: 2019/7/23 17:14
 * Content:
 */

import edu.cuit.loop.titlejudge.entity.Module;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ModelTreeUtil {

    public static Map<String,Object> mapArray = new LinkedHashMap<>();
    public List<Module> menuCommon;
    public List<Object> list = new ArrayList<Object>();

    public  List<Object> menuList(List<Module> menu){
        this.menuCommon = menu;
        for (Module module:menu){
            Map<String,Object> mapArr = new LinkedHashMap<>();
            if (module.getParentmoduleid().trim().equals("0")){
                mapArr.put("moduleID",module.getModuleid());
                mapArr.put("moduleName",module.getModulename());
                mapArr.put("path",module.getModuleurl());
                mapArr.put("componet",module.getModulecomponet());
                mapArr.put("status",module.getModulestatus());
                mapArr.put("name",module.getName());
                mapArr.put("moduleOrderNum",module.getModuleordernum());
                mapArr.put("parentModuleId",module.getParentmoduleid());
                mapArr.put("child",menuChild(module.getModuleid()));
                list.add(mapArr);
            }
        }
        return list;
    }

    public List menuChild(String code){
        List<Object> lists = new ArrayList<Object>();
        //子集查询遍历
        for (Module module:menuCommon){
            Map<String,Object> childArray = new LinkedHashMap<String,Object>();
            if (module.getParentmoduleid().equals(code)){     //如果有子节点ID = 父节点ID
                childArray.put("moduleID",module.getModuleid());
                childArray.put("moduleName",module.getModulename());
                childArray.put("path",module.getModuleurl());
                childArray.put("componet",module.getModulecomponet());
                childArray.put("status",module.getModulestatus());
                childArray.put("name",module.getName());
                childArray.put("moduleOrderNum",module.getModuleordernum());
                lists.add(childArray);
            }
        }
        return lists;
    }
}
