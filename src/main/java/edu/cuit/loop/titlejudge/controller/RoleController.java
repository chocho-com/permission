package edu.cuit.loop.titlejudge.controller;

import edu.cuit.loop.titlejudge.service.RoleModuleService;
import edu.cuit.loop.titlejudge.service.RoleService;
import edu.cuit.loop.titlejudge.utils.Msg;
import edu.cuit.loop.titlejudge.vo.RoleWithModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    RoleService roleService;
    @Autowired
    RoleModuleService roleModuleService;

    /**
     * 根据角色名称模糊查询
     * @param map
     * @return
     */
    @PostMapping("/get")
    public Msg selectByLike(@RequestBody Map<String,Object> map){
        return Msg.success().add("msg",roleService.selectByLike(map));
    }

    /**
     * 添加角色信息
     * @param role
     * @return
     */
    @PostMapping
    public Msg addRole(@RequestBody RoleWithModule role){
        if ((role.getRolename()!=null&&!role.getRolename().equals(""))&&(role.getModules()!=null&&!role.getModules().equals(""))){
            roleService.addRole(role);
            return Msg.success().add("msg","添加成功");
        }else {
            return Msg.fail().add("msg","添加失败请确认信息填写完整");
        }
    }

    /**
     * 编辑角色信息
     * @param role
     * @return
     */
    @PutMapping
    public Msg update(@RequestBody RoleWithModule role){
        if ((role.getRolename()!=null&&!role.getRolename().equals(""))&&
                (role.getRoleid()!=null&&!role.getRoleid().equals(""))){
            roleService.updateRole(role);
            return Msg.success().add("msg","更新成功");
        }else {
            return Msg.fail().add("msg","更新失败请确认信息填写完整");
        }
    }

    /**
     * 删除角色信息
     * @param id
     * @return
     */
    @DeleteMapping
    public Msg delete(@RequestParam String id){
        roleService.deleteRole(id);
        return Msg.success().add("msg","删除成功");
    }

    /**
     * 获取所有角色列表
     * @return
     */
    @GetMapping("/all")
    public Msg selectAll(){
        return Msg.success().add("msg",roleService.seletAllRole());
    }

    /**
     * 获取角色对应的模块ID
     * @param id
     * @return
     */
    @GetMapping("/module")
    public Msg selectAllModule(@RequestParam String id){
        return Msg.success().add("msg",roleModuleService.selectByRoles(id));
    }


}
