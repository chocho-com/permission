webpackJsonp([5],{iq27:function(e,r){},uHjg:function(e,r,t){"use strict";Object.defineProperty(r,"__esModule",{value:!0});var a=t("Xxa5"),s=t.n(a),o=t("exGp"),n=t.n(o),l=t("//Fk"),i=t.n(l),u={name:"userEdit",props:{form:{type:Object,default:function(){return{userid:"",loginphone:"",userpassword:"",userrealname:"",userstatus:"",roles:[],password:"",repassword:""}}}},data:function(){var e=this,r=function(e,r,t){r.trim()?t():t(new Error("该项内容不能为空"))};return{checked:!1,loading:!1,disabled:!0,roleOptions:[],departmentOptions:[],remarkOptions:[],isChangePassword:!1,formRules:{loginphone:[{required:!0,trigger:"blur",validator:r}],userrealname:[{required:!0,trigger:"blur",validator:r}],password:[{required:!0,trigger:"blur",validator:function(e,r,t){""===r?t(new Error("请输入密码")):t()}}],repassword:[{required:!0,trigger:"blur",validator:function(r,t,a){""===t?a(new Error("请输入再次密码")):t!==e.form.password?a(new Error("两次输入密码不一致!")):a()}}]}}},computed:{userStatus:function(){return"1"===this.form.userstatus}},mounted:function(){this.getAllRoles()},watch:{"form.userid":{handler:function(e,r){var t=this;this.$nextTick(function(){t.isChangePassword=!1})}},$route:{handler:function(e,r){i.a.all([this.fetchData(),this.getAllRoles()])},deep:!0}},methods:{switchChange:function(){},roleschange:function(){},back:function(){this.$emit("closeDialog")},handleChangeDate:function(e){this.form.userbirthday=formatEasyTime(e)},getAllRoles:function(){var e=this;return n()(s.a.mark(function r(){return s.a.wrap(function(r){for(;;)switch(r.prev=r.next){case 0:return r.next=2,e.$api.get("http://47.107.120.160:8081//role/all",{},{autoAlert:!1,returnAll:!0}).then(function(r){e.roleOptions=r.data.msg});case 2:case"end":return r.stop()}},r,e)}))()},handleStatusChange:function(e){this.form.userstatus=e?"1":"0"},onSubmit:function(){var e,r=this;this.$refs.form.validate((e=n()(s.a.mark(function e(t){var a;return s.a.wrap(function(e){for(;;)switch(e.prev=e.next){case 0:if(!t){e.next=22;break}if(e.prev=1,r.loading=!0,a=null,!r.form.userid){e.next=11;break}return""!==r.form.password&&(r.form.userpassword=r.form.password),e.next=8,r.$api.put("http://47.107.120.160:8081//user",{userid:r.form.userid,loginphone:r.form.loginphone,userpassword:r.form.userpassword,userrealname:r.form.userrealname,userstatus:r.form.userstatus,roles:r.form.roles.join(",")},{autoAlert:!1,returnAll:!0});case 8:a=e.sent,e.next=14;break;case 11:return e.next=13,r.$api.post("http://47.107.120.160:8081//user",{userid:r.form.userid,loginphone:r.form.loginphone,userpassword:r.form.userpassword,userrealname:r.form.userrealname,userstatus:r.form.userstatus,roles:r.form.roles.join(",")},{autoAlert:!1,returnAll:!0});case 13:a=e.sent;case 14:200==+a.code?(r.loading=!1,r.$emit("fetchData"),r.back()):r.$message.error(a.data.data.msg||"更新失败"),e.next=20;break;case 17:e.prev=17,e.t0=e.catch(1),r.$message.error("更新失败");case 20:e.next=24;break;case 22:return r.$message.error("请检查表单是否输入正确"),e.abrupt("return",!1);case 24:case"end":return e.stop()}},e,r,[[1,17]])})),function(r){return e.apply(this,arguments)}))}}},c={render:function(){var e=this,r=e.$createElement,t=e._self._c||r;return t("el-form",{staticClass:"app-container"},[t("el-card",{directives:[{name:"loading",rawName:"v-loading",value:e.loading,expression:"loading"}],attrs:{"element-loading-text":"拼命加载中","element-loading-spinner":"el-icon-loading",header:e.form.userid?"编辑用户":"新建用户",shadow:"always"}},[t("el-form",{staticClass:"form-container"},[t("el-row",[t("el-col",{attrs:{span:24}},[t("el-form",{ref:"form",attrs:{model:e.form,"label-width":"100px",rules:e.formRules}},[t("el-form-item",{attrs:{label:"用户角色",prop:"roles"}},[t("el-checkbox-group",{model:{value:e.form.roles,callback:function(r){e.$set(e.form,"roles",r)},expression:"form.roles"}},e._l(e.roleOptions.filter(function(e){return 1==e.rolestatus}),function(r){return t("el-checkbox",{key:r.roleid,attrs:{label:r.roleid+"",checked:e.checked},on:{change:function(r){e.checked=!e.checked,e.roleschange()}}},[e._v(e._s(r.rolename))])}),1)],1),e._v(" "),t("div",{staticClass:"flex-input"},[t("el-form-item",{staticStyle:{width:"45%"},attrs:{prop:"loginphone",label:"登录手机"}},[t("el-input",{attrs:{clearable:"",placeholder:"请输入用户名"},model:{value:e.form.loginphone,callback:function(r){e.$set(e.form,"loginphone",r)},expression:"form.loginphone"}})],1),e._v(" "),t("el-form-item",{staticStyle:{width:"45%"},attrs:{prop:"userrealname",label:"姓名"}},[t("el-input",{attrs:{clearable:"",placeholder:"请输入用户姓名"},model:{value:e.form.userrealname,callback:function(r){e.$set(e.form,"userrealname",r)},expression:"form.userrealname"}})],1),e._v(" "),e.form.userid?e._e():t("el-form-item",{staticStyle:{width:"45%"},attrs:{prop:"userrealname",label:"用户密码"}},[t("el-input",{attrs:{clearable:"",placeholder:"请输入用户密码"},model:{value:e.form.userpassword,callback:function(r){e.$set(e.form,"userpassword",r)},expression:"form.userpassword"}})],1),e._v(" "),e.form.userid?t("el-form-item",{staticStyle:{width:"100%"},attrs:{prop:"isChangePassword",label:"修改密码"}},[t("el-switch",{attrs:{"active-text":"开启"},model:{value:e.isChangePassword,callback:function(r){e.isChangePassword=r},expression:"isChangePassword"}})],1):e._e(),e._v(" "),e.isChangePassword?t("el-form-item",{staticStyle:{width:"45%"},attrs:{prop:"password",label:"密码"}},[t("el-input",{attrs:{type:"password",clearable:"",placeholder:"请输入密码"},model:{value:e.form.password,callback:function(r){e.$set(e.form,"password",r)},expression:"form.password"}})],1):e._e(),e._v(" "),e.isChangePassword?t("el-form-item",{staticStyle:{width:"45%"},attrs:{prop:"repassword",label:"确认密码"}},[t("el-input",{attrs:{type:"password",clearable:"",placeholder:"请再次输入密码"},model:{value:e.form.repassword,callback:function(r){e.$set(e.form,"repassword",r)},expression:"form.repassword"}})],1):e._e(),e._v(" "),t("el-form-item",{staticStyle:{width:"45%"},attrs:{prop:"userstatus",label:"用户状态"}},[t("el-switch",{attrs:{value:e.userStatus,"active-text":"启用"},on:{change:e.handleStatusChange}})],1)],1)],1)],1)],1),e._v(" "),t("el-row",{staticStyle:{"margin-top":"150px"},attrs:{type:"flex",justify:"end"}},[t("el-col",{attrs:{span:4}},[t("el-button",{attrs:{plain:"",type:"primary"},on:{click:e.onSubmit}},[e._v(e._s(e.form.userid?"确认更新":"确认添加"))]),e._v(" "),t("el-button",{on:{click:e.back}},[e._v("取消")])],1)],1)],1)],1)],1)},staticRenderFns:[]};var d=t("VU/8")(u,c,!1,function(e){t("iq27")},"data-v-613d938c",null);r.default=d.exports}});
//# sourceMappingURL=5.a96673aa3758c0fc6619.js.map