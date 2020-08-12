package edu.cuit.loop.titlejudge.controller;

import edu.cuit.loop.titlejudge.entity.Module;
import edu.cuit.loop.titlejudge.service.ModuleService;
import edu.cuit.loop.titlejudge.utils.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/module")
public class ModuleController {
    @Autowired
    ModuleService moduleService;

    /**
     * 新增模块
     * @param module
     * @return
     */
    @PostMapping
    public Msg addModule(@RequestBody Module module){
        if (moduleService.addModule(module)) {
            return Msg.success().add("msg", "添加成功");
        }else {
            return Msg.fail().add("msg", "添加失败，请确定输入内容正确");
        }
    }

    /**
     * 更新模块
     * @param module
     * @return
     */
    @PutMapping
    public Msg updateModule(@RequestBody Module module){
        if (moduleService.updateModule(module)){
            return Msg.success().add("msg","更新成功");
        }else {
            return Msg.fail().add("msg","更新失败，请确定输入内容正确");
        }
    }

    /**
     * 删除模块
     * @param id
     * @return
     */
    @DeleteMapping
    public Msg deleteModule(@RequestParam String id){
        moduleService.deleteModule(id);
        return Msg.success().add("msg","删除成功");
    }

    /**
     *根据模块名称查询模块信息
     * @param modulename
     * @return
     */
    @GetMapping("/get")
    public Msg selectByName(@RequestParam String modulename){
        return Msg.success().add("msg",moduleService.selectByName(modulename));
    }

    /**
     * 获取模块树
     * @return
     */
    @GetMapping
    public Msg getModuleTree(){
       return Msg.success().add("msg",moduleService.getModuleTree());
    }


    /**
     * 根据父模块ID查询模块信息
     * @param parenID
     * @return
     */
    @GetMapping("/parent")
    public Msg getByParent(@RequestParam String parenID){
        return Msg.success().add("msg",moduleService.selectByParent(parenID));
    }
}
