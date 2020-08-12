package edu.cuit.loop.titlejudge.entity;

import javax.persistence.*;

@Table(name = "module")
public class Module {
    @Id
    @Column(name = "ModuleID")
    @GeneratedValue(generator = "JDBC")
    private String moduleid;

    @Column(name = "ModuleName")
    private String modulename;

    @Column(name = "ModuleURL")
    private String moduleurl;

    @Column(name = "ModuleIcon")
    private String moduleicon;

    @Column(name = "ParentModuleID")
    private String parentmoduleid;

    @Column(name = "ModuleStatus")
    private String modulestatus;

    @Column(name = "ModuleOrderNum")
    private Integer moduleordernum;

    @Column(name = "ModuleComponet")
    private String modulecomponet;

    @Column(name = "name")
    private String name;

    @Column(name = "redirect")
    private String redirect;

    public String getRedirect() {
        return redirect;
    }

    public void setRedirect(String redirect) {
        this.redirect = redirect;
    }

    /**
     * @return ModuleID
     */
    public String getModuleid() {
        return moduleid;
    }

    /**
     * @param moduleid
     */
    public void setModuleid(String moduleid) {
        this.moduleid = moduleid;
    }

    /**
     * @return ModuleName
     */
    public String getModulename() {
        return modulename;
    }

    /**
     * @param modulename
     */
    public void setModulename(String modulename) {
        this.modulename = modulename;
    }

    /**
     * @return ModuleURL
     */
    public String getModuleurl() {
        return moduleurl;
    }

    /**
     * @param moduleurl
     */
    public void setModuleurl(String moduleurl) {
        this.moduleurl = moduleurl;
    }

    /**
     * @return ModuleIcon
     */
    public String getModuleicon() {
        return moduleicon;
    }

    /**
     * @param moduleicon
     */
    public void setModuleicon(String moduleicon) {
        this.moduleicon = moduleicon;
    }

    /**
     * @return ParentModuleID
     */
    public String getParentmoduleid() {
        return parentmoduleid;
    }

    /**
     * @param parentmoduleid
     */
    public void setParentmoduleid(String parentmoduleid) {
        this.parentmoduleid = parentmoduleid;
    }

    /**
     * @return ModuleStatus
     */
    public String getModulestatus() {
        return modulestatus;
    }

    /**
     * @param modulestatus
     */
    public void setModulestatus(String modulestatus) {
        this.modulestatus = modulestatus;
    }

    /**
     * @return ModuleOrderNum
     */
    public Integer getModuleordernum() {
        return moduleordernum;
    }

    /**
     * @param moduleordernum
     */
    public void setModuleordernum(Integer moduleordernum) {
        this.moduleordernum = moduleordernum;
    }

    /**
     * @return ModuleComponet
     */
    public String getModulecomponet() {
        return modulecomponet;
    }

    /**
     * @param modulecomponet
     */
    public void setModulecomponet(String modulecomponet) {
        this.modulecomponet = modulecomponet;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
}