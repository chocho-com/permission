webpackJsonp([3,6],{"7ikG":function(e,t){},NonO:function(e,t){},oBu8:function(e,t,o){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var r=o("Xxa5"),a=o.n(r),n=o("exGp"),l=o.n(n),i=o("//Fk"),u=o.n(i),s=o("szPp"),c=o("DIwM"),m={name:"moduleManage",components:{moduleDialog:s.default},data:function(){return{rules:c.default,loading:!1,moduleName1:"",moduleId1:"",tableOptions:{stripe:!0},tableCols:[{label:"模块名称",colKey:"modulename",align:"center","min-width":"150"},{label:"链接地址",colKey:"moduleurl",align:"center","min-width":"150"},{label:"父级模块",colKey:"parentmoduleid",align:"center","min-width":"150"}],totalCount:0,currentPage:1,currentSize:10,treeData:[],dialogTitle:"",moduleName:"",tableData:[],moduleData:null,visible:!1,defaultProps:{children:"child",label:"moduleName"},nameDialog:!1,propForm:null,moduleoOptions:[]}},created:function(){var e=[this.fetchTableData(),this.fetchTree()];u.a.all(e)},methods:{onRefresh:function(e){this.moduleData?this.chooseModule({moduleID:e}):this.fetchTableData(),this.fetchTree()},openDig1:function(e){this.nameDialog=!0,this.moduleName1=e.CuitMoon_ModuleName,this.moduleId1=e.moduleID},openDig:function(e){var t=this;return l()(a.a.mark(function o(){return a.a.wrap(function(o){for(;;)switch(o.prev=o.next){case 0:return t.dialogTitle=e?"编辑模块":"添加模块",o.next=3,t.$api.get("http://47.107.120.160:8081//module/parent?parenID=0",{},{autoAlert:!1,returnAll:!0}).then(function(o){t.moduleoOptions=o.data.msg,t.propForm=e,t.visible=!0});case 3:case"end":return o.stop()}},o,t)}))()},fetchTableData:function(){var e=this;return l()(a.a.mark(function t(){return a.a.wrap(function(t){for(;;)switch(t.prev=t.next){case 0:return t.prev=0,e.loading=!0,t.next=4,e.$api.get("http://47.107.120.160:8081//module/parent?parenID=0",{},{autoAlert:!1,returnAll:!0}).then(function(t){e.tableData=t.data.msg,e.moduleoOptions=t.data.msg});case 4:t.next=9;break;case 6:t.prev=6,t.t0=t.catch(0),console.log(t.t0);case 9:return t.prev=9,e.loading=!1,t.finish(9);case 12:case"end":return t.stop()}},t,e,[[0,6,9,12]])}))()},fetchTree:function(){var e=this;return l()(a.a.mark(function t(){return a.a.wrap(function(t){for(;;)switch(t.prev=t.next){case 0:return t.prev=0,t.next=3,e.$api.get("http://47.107.120.160:8081//module",{},{autoAlert:!1,returnAll:!0}).then(function(t){e.treeData=t.data.msg});case 3:t.next=8;break;case 5:t.prev=5,t.t0=t.catch(0),console.log(t.t0);case 8:case"end":return t.stop()}},t,e,[[0,5]])}))()},delModule:function(e){var t=this;return l()(a.a.mark(function o(){return a.a.wrap(function(o){for(;;)switch(o.prev=o.next){case 0:try{t.$confirm("此操作将永久删除该模块, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(l()(a.a.mark(function o(){return a.a.wrap(function(o){for(;;)switch(o.prev=o.next){case 0:return o.next=2,t.$api.delete("http://47.107.120.160:8081//module?id="+e.moduleid);case 2:o.sent,t.chooseModule({moduleID:e.parentmoduleid},1),t.fetchTree();case 5:case"end":return o.stop()}},o,t)})))}catch(e){console.log(e)}case 1:case"end":return o.stop()}},o,t)}))()},chooseModule:function(e){var t=this;return l()(a.a.mark(function o(){var r;return a.a.wrap(function(o){for(;;)switch(o.prev=o.next){case 0:return o.prev=0,t.loading=!0,t.moduleData=e,t.moduleData.moduleID!==e.moduleID&&(t.moduleData=e),o.next=6,t.$api.get("http://47.107.120.160:8081//module/parent?parenID="+e.moduleID,{},{autoAlert:!1,returnAll:!0});case 6:r=o.sent,t.tableData=r.data.msg,t.totalCount=r.data.msg,o.next=14;break;case 11:o.prev=11,o.t0=o.catch(0),console.log(o.t0);case 14:return o.prev=14,t.loading=!1,o.finish(14);case 17:case"end":return o.stop()}},o,t,[[0,11,14,17]])}))()}}},d={render:function(){var e=this,t=e.$createElement,o=e._self._c||t;return o("div",{staticStyle:{padding:"15px"}},[o("el-row",{attrs:{gutter:20}},[o("el-col",{staticStyle:{height:"100vh","overflow-y":"scroll"},attrs:{span:4}},[o("h3",{staticStyle:{margin:"0",color:"#606266"}},[e._v("请选择模块")]),e._v(" "),o("el-button",{staticStyle:{margin:"10px 0"},attrs:{size:"mini",plain:"",type:"success"},on:{click:function(t){return e.openDig(null)}}},[e._v("新增")]),e._v(" "),o("el-button",{staticStyle:{margin:"10px 0"},attrs:{size:"mini",plain:"",type:"primary"},on:{click:function(t){return e.fetchTableData()}}},[e._v("主页")]),e._v(" "),o("el-tree",{ref:"tree",attrs:{data:e.treeData,props:e.defaultProps,accordion:""},on:{"node-click":function(t){return e.chooseModule(t,1)}}})],1),e._v(" "),o("el-col",{attrs:{span:20}},[o("el-row",[o("el-col",{attrs:{span:21}}),e._v(" "),o("el-col",{staticStyle:{"margin-top":"1.6em"},attrs:{span:24}},[o("el-table",{directives:[{name:"loading",rawName:"v-loading",value:e.loading,expression:"loading"}],attrs:{stripe:"",border:"",data:e.tableData}},[e._l(e.tableCols,function(e,t){return o("el-table-column",{key:t,attrs:{prop:e.colKey,label:e.label,"min-width":e["min-width"],align:e.align}})}),e._v(" "),o("el-table-column",{attrs:{label:"状态","min-width":"100",align:"center"},scopedSlots:e._u([{key:"default",fn:function(t){return[o("span",[e._v(e._s("1"===t.row.modulestatus?"启用":"禁用"))])]}}])}),e._v(" "),o("el-table-column",{attrs:{label:"操作","min-width":"260",fixed:"right",align:"center"},scopedSlots:e._u([{key:"default",fn:function(t){return[o("el-button",{attrs:{plain:"",type:"primary"},on:{click:function(o){return e.openDig(t.row)}}},[e._v("编辑")]),e._v(" "),o("el-button",{attrs:{plain:"",type:"danger"},on:{click:function(o){return e.delModule(t.row)}}},[e._v("删除")])]}}])})],2)],1)],1)],1)],1),e._v(" "),o("module-dialog",{attrs:{"prop-form":e.propForm,auth:e.moduleoOptions,visible:e.visible,title:e.dialogTitle},on:{refreshTable:e.onRefresh,closeDialog:function(){e.visible=!1,e.propForm={}}}})],1)},staticRenderFns:[]};var p=o("VU/8")(m,d,!1,function(e){o("7ikG")},"data-v-190629f0",null);t.default=p.exports},szPp:function(e,t,o){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var r=o("Xxa5"),a=o.n(r),n=o("Dd8w"),l=o.n(n),i=o("exGp"),u=o.n(i),s=o("DIwM"),c={props:{visible:{type:Boolean,default:!1},auth:Array,title:{type:String,default:"添加模块"},propForm:{type:Object,default:null}},name:"addModuleDialog",data:function(){return{rules:s.default,form:{modulename:"",moduleurl:"",moduleicon:"",moduleparentid:"",modulestatus:"",moduledescription:"",moduleremarks:"",name:"",componet:"",redirect:"",moduleid:""},newArray:[]}},methods:{onCloseDialog:function(){this.$emit("closeDialog")},onSubmit:function(){var e=this;return u()(a.a.mark(function t(){var o;return a.a.wrap(function(t){for(;;)switch(t.prev=t.next){case 0:if(t.prev=0,o={modulename:e.form.modulename||"",moduleurl:e.form.moduleurl||"",parentmoduleid:e.form.moduleparentid||"",modulestatus:e.form.modulestatus||"",modulecomponet:e.form.component||"",name:e.form.modulename||"",redirect:e.form.redirect||""},!e.propForm){t.next=8;break}return t.next=5,e.$api.put("http://47.107.120.160:8081//module",l()({},o,{moduleid:e.form.moduleid}),{autoAlert:!1,returnAll:!0});case 5:t.t0=t.sent,t.next=11;break;case 8:return t.next=10,e.$api.post("http://47.107.120.160:8081//module",o,{autoAlert:!1,returnAll:!0});case 10:t.t0=t.sent;case 11:if("200"!==t.t0.code){t.next=17;break}e.$emit("refreshTable",e.form.moduleparentid),e.onCloseDialog(),t.next=18;break;case 17:throw"fail";case 18:t.next=23;break;case 20:t.prev=20,t.t1=t.catch(0),console.log(t.t1);case 23:case"end":return t.stop()}},t,e,[[0,20]])}))()}},watch:{propForm:function(e){e&&(this.form={redirect:e.redirect,component:e.modulecomponet,moduleid:e.moduleid,modulename:e.modulename,moduleurl:e.moduleurl,moduleicon:e.moduleicon,moduleparentid:e.parentmoduleid,modulestatus:e.modulestatus,moduleordernum:e.moduleordernum})},visible:function(e){var t=this;e&&setTimeout(function(){t.$refs.moduleForm.resetFields()},0),this.propForm||(this.form={modulename:"",moduleurl:"",moduleicon:"",moduleparentid:"",modulestatus:"1",moduledescription:"",moduleremarks:"",name:"",hidden:"",componet:"",redirect:"",breadcrumb:"",props:"",activemenu:""})}}},m={render:function(){var e=this,t=e.$createElement,o=e._self._c||t;return e.visible?o("div",[o("el-dialog",{attrs:{"before-close":e.onCloseDialog,title:e.title,visible:e.visible},on:{"update:visible":function(t){e.visible=t}}},[o("el-form",{ref:"moduleForm",attrs:{rules:e.rules.sysModule,"label-width":"120px",model:e.form}},[o("el-form-item",{attrs:{label:"模块名称",prop:"modulename"}},[o("el-input",{model:{value:e.form.modulename,callback:function(t){e.$set(e.form,"modulename",t)},expression:"form.modulename"}})],1),e._v(" "),o("el-form-item",{attrs:{label:"path"}},[o("el-input",{model:{value:e.form.moduleurl,callback:function(t){e.$set(e.form,"moduleurl",t)},expression:"form.moduleurl"}})],1),e._v(" "),o("el-form-item",{attrs:{label:"父级模块",prop:"moduleparentid"}},[o("el-select",{staticStyle:{width:"100%"},model:{value:e.form.moduleparentid,callback:function(t){e.$set(e.form,"moduleparentid",t)},expression:"form.moduleparentid"}},[o("el-option",{staticStyle:{color:"#67C23A"},attrs:{label:"主模块",value:"0"}}),e._v(" "),e._l(e.auth,function(e){return o("el-option",{key:e.moduleid,attrs:{label:e.modulename,value:e.moduleid}})})],2)],1),e._v(" "),o("el-form-item",{attrs:{label:"redirect"}},[o("el-input",{model:{value:e.form.redirect,callback:function(t){e.$set(e.form,"redirect",t)},expression:"form.redirect"}})],1),e._v(" "),o("el-form-item",{attrs:{label:"component"}},[o("el-input",{model:{value:e.form.component,callback:function(t){e.$set(e.form,"component",t)},expression:"form.component"}})],1),e._v(" "),o("el-form-item",{attrs:{label:"模块状态",prop:"modulestatus"}},[o("el-switch",{attrs:{"active-value":"1","inactive-value":"0","active-text":"启用"},model:{value:e.form.modulestatus,callback:function(t){e.$set(e.form,"modulestatus",t)},expression:"form.modulestatus"}})],1)],1),e._v(" "),o("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[o("el-button",{on:{click:e.onCloseDialog}},[e._v("取 消")]),e._v(" "),o("el-button",{attrs:{type:"primary"},on:{click:e.onSubmit}},[e._v("确 定")])],1)],1)],1):e._e()},staticRenderFns:[]};var d=o("VU/8")(c,m,!1,function(e){o("NonO")},"data-v-48ae002c",null);t.default=d.exports}});
//# sourceMappingURL=3.fb707eaf7c7782027e77.js.map