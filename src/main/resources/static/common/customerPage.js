var customer_address =["北京","天津","河北","山西","内蒙古","辽宁","吉林","黑龙江","上海","浙江","江苏","安徽","福建","江西","山东","河南","湖北","湖南","广东","广西"
,"海南","重庆","四川","贵州","云南","西藏","陕西","甘肃","青海","宁夏","新疆","香港","澳门"];
var registerList = ["初始","转注","均可"];
var idealist,sourcelist, titlelist,professionList,safeList;
var success = 0;

$(function () {
    $.ajax({
        type:"POST",
        url:"getSafe",
        success:function (data) {
            if(data.code == 200){
                safeList = eval(data.data)
            }else{
                layer.alert(data.msg);
            }
        }
    });
    getAllProfession();
    $.ajax({
        type:"POST",
        url:"getTitle",
        success:function (data) {
            if(data.code == 200){
                var html = "<a id='title_0' onclick='getTitle(0)'>不限</a>";
                $("#title").html();
                titlelist = eval(data.data);
                for(var i = 0; i < titlelist.length; i++){
                    html += "&nbsp;&nbsp;<a  id='title_" + titlelist[i].id + "' onclick='getTitle(" + titlelist[i].id + ", 0)'>" + titlelist[i].name + "</a>";
                }
                $("#title").html(html);
            }else{
                layer.alert(data.msg);
            }
        }
    });
    $.ajax({
        type: "POST",
        url: "getIdea",
        success: function (data) {
            if (data.code == 200) {
                var html = "<a id='idea_0' onclick='getIdea(0)'>不限</a>";
                $("#idea").html();
                idealist = eval(data.data);
                for (var i = 0; i < idealist.length; i++) {
                    html += "&nbsp;&nbsp;<a  id='idea_" + idealist[i].id + "' onclick='getIdea(" + idealist[i].id + ", 0)'>" + idealist[i].name + "</a>";
                    if(idealist[i].name.indexOf("成交") != -1){
                        success = idealist[i].id;
                    }
                }
                $("#idea").html(html);
            } else {
                layer.alert(data.msg);
            }
        }
    });
    $.ajax({
        type: "POST",
        url: "getSource",
        success: function (data) {
            if (data.code == 200) {
                var html = "<a id='source_0' onclick='getSource(0)'>不限</a>";
                $("#source").html();
                sourcelist = eval(data.data);
                for (var i = 0; i < sourcelist.length; i++) {
                    html += "&nbsp;&nbsp;<a  id='source_" + sourcelist[i].id + "' onclick='getSource(" + sourcelist[i].id + ", 0)'>" + sourcelist[i].name + "</a>";
                }
                $("#source").html(html);
            } else {
                layer.alert(data.msg);
            }
        }
    });
    var timeJob = setInterval(function(){
        if(idealist==undefined || sourcelist == undefined || titlelist == undefined || professionList == undefined || safeList == undefined){
            return false;
        }else{
            getTableInfo();
            clearInterval(timeJob)
        }
    },500);
});

function getAllProfession() {
    $.ajax({
        type: "POST",
        url: "getAllProfession",
        success: function (data) {
            if (data.code == 200) {
                professionList = eval(data.data);
            } else {
                layer.alert(data.msg);
            }
        }
    });
}

function getTableInfo(){
    layui.use('table', function(){
        var table = layui.table;

        table.render({
            even: false //开启隔行背景
            , elem: '#table_test'
            ,url:'getCustomerInfo'
            , method: 'post'
            , request: {
                pageName: 'pageNumber' //页码的参数名称，默认：page
                ,limitName: 'pageSize' //每页数据量的参数名，默认：limit
            }
            , parseData: function(res) { //res 即为原始返回的数据
                return {
                    "code": res.code, //解析接口状态
                    "msg": res.msg, //解析提示文本
                    "count": res.count, //解析数据长度
                    "data": res.rows //解析数据列表
                };
            }
            , page: {theme:"#009688"}
            , limits: [5, 10, 15]
            , limit: 5 //默认采用30
            , loading: true
            , cols: [[
                {field:'id', width: 80, title: '编号', sort: true}
                ,{field:'update', minWidth: 130, title: '更新日期', sort: true}
                ,{field:'detail', width: 90, title: '现有人员',templet: function(res){
                        var html = "<div><a href='javascript:void(0);' name='" + res.id + "' style='color: #007DDB' onclick='getDetail($(this))'>详情</a>";
                        html +="<span style='display: none;'>" + res.detail + "</span></div>";
                        return html;
                    }
                }
                ,{field:'register', width: 70, title: '注册',templet: function(res){
                        var html = "<div class='" + res.id + "'><select name='register' lay-filter='register_table' class='layui-form-select'>";
                        for (var i = 0; i < registerList.length; i++) {
                            if(res.register == registerList[i]){
                                html += "<option value='" + registerList[i] + "' selected='selected'>" + registerList[i] + "</option>";
                            }else{
                                html += "<option value='" + registerList[i] + "'>" + registerList[i] + "</option>";
                            }
                        }
                        html += "</select></div>";
                        return html;
                    }
                }
                ,{field:'book', title: '所需证书', minWidth: 150,templet: function(res){
                        var titleName = "";
                        var professionName = "";
                        for (var i = 0; i < titlelist.length; i++) {
                            if(titlelist[i].id == res.titleId){
                                titleName = titlelist[i].name;
                            }
                        }
                        for (var i = 0; i < professionList.length; i++) {
                            if(professionList[i].id == res.professionId){
                                professionName = professionList[i].name + "[" + professionList[i].num + "人]";
                            }
                        }
                        var html = "<div>" + titleName + " - " + professionName + "</div>"+
                            "<div><span style='display: none;'>"+res.titleId+"</span><span style='display: none;'>"+res.professionId+"</span><button  class='layui-btn layui-btn-sm' onclick='getBookInfo(this)' name='"+res.id+"'>修改所需证书</button></div>";
                        return html;
                    }
                }
                ,{field:'provinces', width: 80, title: '地区',templet: function(res){
                        var html = "<div class='" + res.id + "'><select name='provinces_table' id='provinces_table' lay-filter='provinces_table' class='layui-form-select'>";
                        for (var i = 0; i < customer_address.length; i++) {
                            if(res.provinces == customer_address[i]){
                                html += "<option value='" + customer_address[i] + "' selected='selected'>" + customer_address[i] + "</option>";
                            }else{
                                html += "<option value='" + customer_address[i] + "'>" + customer_address[i] + "</option>";
                            }
                        }
                        html += "</select></div>";
                        return html;
                    }
                }
                ,{field:'contact', width: 155, title: '联系方式',templet: function(res){
                        var html = "<div><div><span style='color: #009688;'>1.</span><span>" + res.contact + "</span><span style='color: darkred'>|</span><span>" + res.phone + "</span></div>"+
                            "<div><span style='color: #009688;'>2.</span><span style='width: 48px;'>——</span><span style='color: darkred'>|</span><span>" + res.phone1 + "</span></div>"+
                            "<div><span style='color: #009688;'>3.</span><span style='width: 48px;'>——</span><span style='color: darkred'>|</span><span>" + res.phone2 + "</span></div>"+
                            "<div><span style='color: #009688;'>电话：</span><span>" + res.call + "</span></div>"+
                            "<div><span style='color: #009688;'>QQ：</span><span>" + res.qq + "</span></div>"+
                            "<div><span style='color: #009688;'>邮箱：</span><span>" + res.email + "</span></div>"+
                            "<button  class='layui-btn layui-btn-xs' onclick='savePhone(this)' name='"+res.id+"'>修改联系方式</button></div>";
                        return html;
                    }
                }
                ,{field:'contact', width: 150, title: '企业信息',templet: function(res){
                        if(res.type == 1){
                            return "         ——";
                        }
                        var date = "";
                        var companySignday = "";
                        if(res.companyDate != null && res.companyDate.length > 10){
                            date = res.companyDate.substring(0,10);
                        }else{
                            date = res.companyDate;
                        }
                        if(res.companySignday != null && res.companySignday.length > 10){
                            companySignday = res.companySignday.substring(0,10);
                        }else{
                            companySignday = res.companySignday;
                        }
                        var html = "<div><div><span style='color: #009688;'>公司名称: </span><span>" + res.companyName + "</span></div>"+
                            "<div><span style='color: #009688;'>法人: </span><span>" + res.companyLegal + "</span></div>"+
                            "<div><span style='color: #009688;'>注册资金: </span><span>" + res.companyMoney + "</span></div>"+
                            "<div><span style='color: #009688;'>注册地址：</span><span>" + res.companyRegistAddress + "</span></div>"+
                            "<div><span style='color: #009688;'>办公地址：</span><span>" + res.companyAddress + "</span></div>"+
                            "<div><span style='color: #009688;'>成立时间：</span><span>" + date + "</span></div>"+
                            "<div><span style='color: #009688;'>安证：</span><span>" + res.safeId + "</span></div>"+
                            "<div><span style='color: #009688;'>签单日：</span><span>" +companySignday + "</span></div>"+
                            "<button  class='layui-btn layui-btn-xs' onclick='editCompanyInfo(this)' name='"+res.id+"'>修改企业信息</button></div>";
                        return html;
                    }
                }
                ,{field:'remark', minWidth: 180, title: '备注',templet: function(res){
                        var html = "<div><div style='width: 100%' class='scrollbar style-1 toLow'>";
                        var color = 'SteelBlue;';
                        if(res.ideaId == success){
                            color = 'red;';
                        }
                        for (var i = 0; i < res.remark.length; i++) {
                            html += "<div><span style='display: none'>" + res.id + "</span><span style='display: none'>" + res.remark[i].id + "</span><span style='color: #009688;'>" + res.remark[i].date + "</span><span style='color: "+color+";'>" + res.remark[i].content + "</span><a onclick='editRecord(this)'><i class=\"layui-icon\">&#xe642;</i></a></div>";
                        }
                        html += "</div><button  class='layui-btn layui-btn-xs' onclick='addRecored(this)' name='"+res.id+"' style='margin-left: 60%;'>添加</button></div>";
                        html += "<script>$('.toLow').scrollTop($('.toLow')[0].scrollHeight);</script>";
                        return html;
                    }
                }
                ,{field:'idea', width: 90, title: '意向|来源',templet: function(res){
                        var html = "<div class='" + res.id + "'><select name='idea_table' id='idea_table' lay-filter='idea_table' class='layui-form-select'>";
                        for (var i = 0; i < idealist.length; i++) {
                            if(res.ideaId == idealist[i].id){
                                html += "<option value='" + idealist[i].id + "' selected='selected'>" + idealist[i].name + "</option>";
                            }else{
                                html += "<option value='" + idealist[i].id + "'>" + idealist[i].name + "</option>";
                            }
                        }
                        html += "</select></div>";
                        html += "<div style='margin-top: 18px;' class='" + res.id + "'><select name='source_table' id='source_table' lay-filter='source_table' class='layui-form-select'>";
                        for (var i = 0; i < sourcelist.length; i++) {
                            if(res.sourceId == sourcelist[i].id){
                                html += "<option value='" + sourcelist[i].id + "' selected='selected'>" + sourcelist[i].name + "</option>";
                            }else{
                                html += "<option value='" + sourcelist[i].id + "'>" + sourcelist[i].name + "</option>";
                            }
                        }
                        html += "</select></div>";
                        return html;
                    }
                }
                ,{field:'user', width:80, title: '业务员'}
            ]]
        });
    });
}

function getDetail(res) {
    var index1 = layer.open({
        type:1,
        title:"详细",
        area: ['500px','250px'],
        content:$("#userModel").html(" <form class=\"layui-form\" action=\"\" style=\"margin-left: -80px;margin-top: 20px;margin-right: 20px;\">\n" +
            "        <div class=\"layui-form-item\" style='display: none'>\n" +
            "            <div class=\"layui-input-inline\">\n" +
            "                <input type=\"text\" name=\"id\" value='" + res[0].name + "' autocomplete=\"off\" class=\"layui-input\">\n" +
            "            </div>\n" +
            "        </div>\n" +
            "        <div class=\"layui-form-item layui-form-text\">\n" +
            "           <div class=\"layui-input-block\">\n" +
            "               <textarea name=\"detail\" placeholder=\"请输入内容\" class=\"layui-textarea\">" + res[0].parentNode.lastChild.innerHTML + "</textarea>\n"+
            "           </div>\n" +
            "        </div>\n" +
            "        <div class=\"layui-form-item\" style=\"float: right;margin-right: 20px;\">\n" +
            "            <div class=\"layui-input-block\">\n" +
            "                <button class=\"layui-btn layui-btn\" lay-submit=\"\" lay-filter=\"detailBtn\">提交</button>\n" +
            "                <button class=\"layui-btn layui-btn-primary\" id=\"quxiao1\">取消</button>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "    </form>")
    });

    layui.use(['form', 'table'], function () {
        var form = layui.form;
        var table = layui.table;

        form.on('submit(detailBtn)', function (data) {
            layer.confirm('您确认要修改细节？', {
                btn: ['确认','取消'] //按钮
            }, function(){
                $.ajax({
                    url: 'editDetail',
                    type: 'post',
                    data: JSON.stringify(data.field),
                    contentType : "application/json",
                    dataType: 'JSON',
                    success: function (res) {
                        layer.close(index1);
                        if (res.code == 200) {
                            layer.alert('修改成功！', {icon: 1});
                            table.reload('table_test', {
                                page: {
                                    curr: 1
                                }
                            });
                        }else {
                            layer.open({
                                title: '提示'
                                ,content: '修改失败！' + res.msg
                            });
                        }
                    },
                    error: function (data) {
                        layer.closeAll();
                        layer.open({
                            title: '提示'
                            ,content: '修改失败！未知原因，请联系管理员。'
                        });
                    }
                });
                $("#userModel").empty();
            }, function(){
                layer.msg('已取消..');
                $("#userModel").empty();
                return false;
            });
            $("#userModel").empty();
            return false;
        });
    })
    $("#quxiao1").click(function () {
        layer.close(index1);
    });
}

function getBookInfo(res) {
    $("#userModel").html("");
    var bookId = res.parentNode.childNodes[1].innerHTML;
    layui.use(['form', 'table'], function() {
        var form = layui.form
            , table = layui.table;

        var html="<form class='layui-form' action=''>"+
            "<div class='layui-form-item'><table class='layui-table' lay-filter='professionRadio' id='boo_table'><tbody>";

        for (var i = 0; i < titlelist.length; i++) {
            html += "<tr><td style='border-top-width: 0;border-left-width: 0;border-right-width: 0;border-bottom-color: #009688;'><label class='layui-form-label' style='color: #009688'>" + titlelist[i].name + "</label></td><td style='border-top-width: 0;border-left-width: 0;border-right-width: 0;border-bottom-color: #009688;'><div class='layui-input-block'>";
            for (var j = 0; j < professionList.length; j++) {
                if(professionList[j].titleId == titlelist[i].id){
                    if(professionList[j].id == bookId){
                        html += "<input type='radio' name='professionId' checked='checked' value='" + bookId + "_" + titlelist[i].id + "_" +professionList[j].id + "' title='" + professionList[j].name + "[" + professionList[j].num + "人]" + "'>";
                    }else{
                        html += "<input type='radio' name='professionId' value='" + bookId + "_" + titlelist[i].id + "_" +professionList[j].id + "' title='" + professionList[j].name + "[" + professionList[j].num + "人]" + "'>";
                    }
                }
            }
            html += "</div></td></tr>";
        }
        html +=  "</tbody></table></div><div class=\"layui-form-item\">\n" +
            "                    <div class=\"layui-input-block\">\n" +
            "                        <button class=\"layui-btn layui-btn\" lay-submit lay-filter=\"professionBtn\" id='professionBtn'>提交</button>\n" +
            "                        <button class=\"layui-btn layui-btn-primary\" id=\"quxiao2\">取消</button>\n" +
            "                    </div>\n" +
            "                </div></form>";
        $("#userModel").html(html);

        var index2 = layer.open({
            type: 1,
            content:$("#userModel").html(),
            title: "修改所需证书",
            area: ['90%', '90%']
        });
        form.render();

        form.on('submit(professionBtn)', function (data) {
            layer.confirm('您确认要修改所需证书？', {
                btn: ['确认','取消'] //按钮
            }, function(){
                $.ajax({
                    url: 'editTitleAndProfessionById',
                    type: 'post',
                    data: {
                        'id': res.name,
                        'bookId': data.field.professionId
                    },
                    dataType: 'JSON',
                    success: function (res) {
                        layer.close(index2);
                        if (res.code == 200) {
                            layer.alert('修改成功！', {icon: 1});
                            getAllProfession();
                            table.reload('table_test', {
                                page: {
                                    curr: 1
                                }
                            });
                        }else {
                            layer.open({
                                title: '提示'
                                ,content: '修改失败！' + res.msg
                            });
                        }
                    },
                    error: function (data) {
                        layer.closeAll();
                        layer.open({
                            title: '提示'
                            ,content: '修改失败！未知原因，请联系管理员。'
                        });
                    }
                });
                $("#userModel").empty();
            }, function(){
                layer.msg('已取消..');
                $("#userModel").empty();
                return false;
            });
            $("#userModel").empty();
            return false;
        });
    });
    $("#quxiao2").click(function () {
        layer.close(index2);
    });
}

function savePhone(res) {
    var person = res.parentNode.childNodes[0].childNodes[1].innerHTML;
    var phone = res.parentNode.childNodes[0].childNodes[3].innerHTML;
    var phone1 = res.parentNode.childNodes[1].childNodes[3].innerHTML;
    if(phone1 == "null"){
        phone1 ="";
    }
    var phone2 = res.parentNode.childNodes[2].childNodes[3].innerHTML;
    if(phone2 == "null"){
        phone2 ="";
    }
    var call = res.parentNode.childNodes[3].childNodes[1].innerHTML;
    var qq = res.parentNode.childNodes[4].childNodes[1].innerHTML;
    var email = res.parentNode.childNodes[5].childNodes[1].innerHTML;

    layui.use(['form', 'table'], function () {
        var form = layui.form;
        var table = layui.table;

        var index3 = layer.open({
            type: 1,
            title: "修改联系方式",
            area: ['550px', '420px'],
            content: $("#userModel").html(" <form class=\"layui-form\" action=\"\">\n" +
                "        <div class=\"layui-form-item\" style='display: none'>\n" +
                "            <div class=\"layui-input-inline\">\n" +
                "                <input type=\"text\" name=\"id\" value='" + res.name + "' autocomplete=\"off\" class=\"layui-input\">\n" +
                "            </div>\n" +
                "        </div>\n" +
                "        <div class=\"layui-form-item layui-form-text\" style='margin-top: 3px;'>\n" +
                "           <label class='layui-form-label'><span style='color:red'>*</span>联系人</label>\n" +
                "            <div class='layui-input-inline'>\n" +
                "                <input type='text' name='contact' lay-verify='required' placeholder='请输入联系人' value='"+person+"' autocomplete='off' class='layui-input'>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "        <div class=\"layui-form-item layui-form-text\">\n" +
                "           <label class='layui-form-label'><span style='color:red'>*</span>手机</label>\n" +
                "            <div class='layui-input-inline'>\n" +
                "                <input type='text' name='phone' lay-verify='phone' placeholder='请输入手机号' value='"+phone+"'  autocomplete='off' class='layui-input'>\n" +
                "            </div>\n" +
                "            <div class='layui-input-inline'>\n" +
                "                <input type='text' name='phone1' placeholder='' autocomplete='off' value='"+phone1+"'  class='layui-input'>\n" +
                "            </div>\n" +
                "            <div class='layui-input-inline' style='margin-left: 110px;margin-top: 5px;'>\n" +
                "                <input type='text' name='phone2'  placeholder='' value='"+phone2+"' autocomplete='off' class='layui-input'>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "        <div class=\"layui-form-item layui-form-text\">\n" +
                "           <label class='layui-form-label'>电话</label>\n" +
                "            <div class='layui-input-inline'>\n" +
                "                <input type='text' name='call' placeholder='请输入电话' value='"+call+"' autocomplete='off' class='layui-input'>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "        <div class=\"layui-form-item layui-form-text\">\n" +
                "           <label class='layui-form-label'>QQ</label>\n" +
                "            <div class='layui-input-inline'>\n" +
                "                <input type='text' name='qq' placeholder='请输入QQ' value='"+qq+"' autocomplete='off' class='layui-input'>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "        <div class=\"layui-form-item layui-form-text\">\n" +
                "           <label class='layui-form-label'>邮箱</label>\n" +
                "            <div class='layui-input-inline'>\n" +
                "                <input type='text' name='email' placeholder='请输入邮箱' value='"+email+"' autocomplete='off' class='layui-input'>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "        <div class=\"layui-form-item\" style=\"float: right;margin-right: 20px;\">\n" +
                "            <div class=\"layui-input-block\">\n" +
                "                <button class=\"layui-btn layui-btn\" lay-submit=\"\" lay-filter=\"phoneBtn\">提交</button>\n" +
                "                <button class=\"layui-btn layui-btn-primary\" id=\"quxiao3\">取消</button>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "    </form>")
        });

        form.on('submit(phoneBtn)', function (data) {
            layer.confirm('您确认要修改联系方式？', {
                btn: ['确认', '取消'] //按钮
            }, function () {
                $.ajax({
                    url: 'editPhoneInfo',
                    type: 'post',
                    data: JSON.stringify(data.field),
                    contentType: "application/json",
                    dataType: 'JSON',
                    success: function (res) {
                        layer.close(index3);
                        if (res.code == 200) {
                            layer.alert('修改成功！', {icon: 1});
                            table.reload('table_test', {
                                page: {
                                    curr: 1
                                }
                            });
                        } else {
                            layer.open({
                                title: '提示'
                                , content: '修改失败！' + res.msg
                            });
                        }
                    },
                    error: function (data) {
                        layer.close(index3);
                        layer.open({
                            title: '提示'
                            , content: '修改失败！未知原因，请联系管理员。'
                        });
                    }
                });
                $("#userModel").empty();
            }, function () {
                layer.msg('已取消..');
                $("#userModel").empty();
                return false;
            });
            $("#userModel").empty();
            return false;
        });
    })
    $("#quxiao3").click(function () {
        layer.close(index3);
    });
}

function editCompanyInfo(res) {
    var companyName = res.parentNode.childNodes[0].childNodes[1].innerHTML;
    var legal = res.parentNode.childNodes[1].childNodes[1].innerHTML;
    var money = res.parentNode.childNodes[2].childNodes[1].innerHTML;
    var regist_address = res.parentNode.childNodes[3].childNodes[1].innerHTML;
    var address = res.parentNode.childNodes[4].childNodes[1].innerHTML;
    var companyDate = res.parentNode.childNodes[5].childNodes[1].innerHTML;
    var safe = res.parentNode.childNodes[6].childNodes[1].innerHTML;
    var signDate = res.parentNode.childNodes[7].childNodes[1].innerHTML;
    if(legal == "null"){
        legal ="";
    }
    if(money == "null"){
        money ="";
    }
    if(regist_address == "null"){
        regist_address ="";
    }
    if(address == "null"){
        address ="";
    }
    if(companyDate == "null"){
        companyDate ="";
    }
    if(signDate == "null"){
        signDate ="";
    }
    var html = "";

    layui.use(['form', 'laydate', 'table'], function () {
        var form = layui.form;
        var laydate = layui.laydate;
        var table = layui.table;

        $("#userModel").empty();
        html += " <form class=\"layui-form\" action=\"\" style='margin-top: 20px;'>\n" +
            "        <div class=\"layui-form-item\" style='display: none'>\n" +
            "            <div class=\"layui-input-inline\">\n" +
            "                <input type=\"text\" name=\"id\" value='" + res.name + "' autocomplete=\"off\" class=\"layui-input\">\n" +
            "            </div>\n" +
            "        </div>\n" +
            "        <div class=\"layui-form-item layui-form-text\" style='margin-top: 3px;'>\n" +
            "           <label class='layui-form-label'><span style='color:red'>*</span>公司名称</label>\n"+
            "            <div class='layui-input-inline'>\n"+
            "                <input type='text' name='companyName' value='" + companyName + "' lay-verify='required' placeholder='请输入公司名称' autocomplete='off' class='layui-input'>\n"+
            "            </div>\n" +
            "           <label class='layui-form-label'><span style='color:red'>*</span>法人</label>\n"+
            "            <div class='layui-input-inline'>\n"+
            "                <input type='text' name='companyLegal' value='" + legal + "' lay-verify='required' placeholder='请输入法人' autocomplete='off' class='layui-input'>\n"+
            "            </div>\n" +
            "        </div>\n" +
            "        <div class=\"layui-form-item layui-form-text\">\n" +
            "           <label class='layui-form-label'><span style='color:red'>*</span>注册资金</label>\n"+
            "            <div class='layui-input-inline'>\n"+
            "                <input type='text' name='companyMoney' value='" + money + "' lay-verify='required' placeholder='请输入注册资金' autocomplete='off' class='layui-input'>\n"+
            "            </div>\n" +
            "           <label class='layui-form-label'><span style='color:red'>*</span>注册地址</label>\n"+
            "            <div class='layui-input-inline'>\n"+
            "                <input type='text' name='companyRegistAddress' value='" + regist_address + "' lay-verify='required' placeholder='请输入注册地址' autocomplete='off' class='layui-input'>\n"+
            "            </div>\n" +
            "        </div>\n" +
            "        <div class=\"layui-form-item layui-form-text\">\n" +
            "           <label class='layui-form-label'><span style='color:red'>*</span>办公地址</label>\n"+
            "            <div class='layui-input-inline'>\n"+
            "                <input type='text' name='companyAddress' value='" + address + "' lay-verify='required' placeholder='请输入办公地址' autocomplete='off' class='layui-input'>\n"+
            "            </div>\n" +
            "           <label class='layui-form-label'><span style='color:red'>*</span>成立时间</label>\n"+
            "            <div class='layui-input-inline'>\n"+
            "                <input type='text' class='layui-input date-item' name='companyDate' readonly='readonly' lay-verify='required' value='" + companyDate + "' id='companyDate' placeholder='yyyy-MM-dd'>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "        <div class=\"layui-form-item layui-form-text\">\n" +
            "           <label class='layui-form-label'>安证</label>\n"+
            "            <div class='layui-input-inline' style='width: 187px;'>\n"+
            "                <select name='safeId' id='safe' lay-filter='safe'>\n" +
            "                   <option value=''>不限</option>\n";
        if(safeList.length > 0){
            for (var i = 0; i < safeList.length; i++) {
                if(safe == safeList[i].id){
                    html += "<option value='" + safeList[i].id + "' selected='selected'>" + safeList[i].name + "</option>\n";
                }else{
                    html += "<option value='" + safeList[i].id + "'>" + safeList[i].name + "</option>\n";
                }
            }
        }
        html += "                </select>\n"+
            "            </div>\n" +
            "           <label class='layui-form-label'><span style='color:red'>*</span>签单日</label>\n"+
            "            <div class='layui-input-inline'>\n"+
            "                <input type='text' class='layui-input date-item' name='companySignday' readonly='readonly' lay-verify='required' value='" + signDate + "' id='companySignday' placeholder='yyyy-MM-dd'>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "        <div class=\"layui-form-item\" style=\"float: right;margin-right: 45px;\">\n" +
            "            <div class=\"layui-input-block\">\n" +
            "                <button class=\"layui-btn layui-btn\" lay-submit=\"\" lay-filter=\"companyInfoBtn\">提交</button>\n" +
            "                <button class=\"layui-btn layui-btn-primary\" lay-filter=\"quxiao4\">取消</button>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "    </form>";
        $("#userModel").html(html)
        var index4 = layer.open({
            type:1,
            title:"修改企业信息",
            area: ['650px','350px'],
            content: $("#userModel").html()
        });
        form.render();

        lay('.date-item').each(function(){
            laydate.render({
                elem: this
                ,trigger: 'click'
            });
        });

        form.on('submit(companyInfoBtn)', function (data) {
            layer.confirm('您确认要修改企业信息？', {
                btn: ['确认','取消'] //按钮
            }, function(){
                $.ajax({
                    url: 'editCompanyInfo',
                    type: 'post',
                    data: JSON.stringify(data.field),
                    contentType : "application/json",
                    dataType: 'JSON',
                    success: function (res) {
                        layer.close(index4);
                        if (res.code == 200) {
                            layer.alert('修改成功！', {icon: 1});
                            table.reload('table_test', {
                                page: {
                                    curr: 1
                                }
                            });
                        }else {
                            layer.open({
                                title: '提示'
                                ,content: '修改失败！' + res.msg
                            });
                        }
                    },
                    error: function (data) {
                        layer.close(index4);
                        layer.open({
                            title: '提示'
                            ,content: '修改失败！未知原因，请联系管理员。'
                        });
                    }
                });
                $("#userModel").empty();
            }, function(){
                layer.msg('已取消..');
                $("#userModel").empty();
                return false;
            });
            $("#userModel").empty();
            return false;
        });
    });
    $("#quxiao4").click(function () {
        layer.close(index4);
    });
}

function addRecored(res){
    var index5 = layer.open({
        type:1,
        title:"添加备注",
        area: ['500px','250px'],
        content:$("#userModel").html(" <form class=\"layui-form\" action=\"\" style=\"margin-left: -80px;margin-top: 20px;margin-right: 20px;\">\n" +
            "        <div class=\"layui-form-item\" style='display: none'>\n" +
            "            <div class=\"layui-input-inline\">\n" +
            "                <input type=\"text\" name=\"id\" value='" + res.name + "' autocomplete=\"off\" class=\"layui-input\">\n" +
            "            </div>\n" +
            "        </div>\n" +
            "        <div class=\"layui-form-item layui-form-text\">\n" +
            "           <div class=\"layui-input-block\">\n" +
            "               <textarea name=\"record\" placeholder=\"请输入内容\" lay-verify='required' class=\"layui-textarea\"></textarea>\n"+
            "           </div>\n" +
            "        </div>\n" +
            "        <div class=\"layui-form-item\" style=\"float: right;margin-right: 20px;\">\n" +
            "            <div class=\"layui-input-block\">\n" +
            "                <button class=\"layui-btn layui-btn\" lay-submit=\"\" lay-filter=\"addRecordBtn\">提交</button>\n" +
            "                <button class=\"layui-btn layui-btn-primary\" id=\"quxiao5\">取消</button>\n" +
            "            </div>\n" +
            "        </div>\n" +
        "    </form>")
    });

    layui.use(['form', 'table'], function () {
        var form = layui.form;
        var table = layui.table;

        form.on('submit(addRecordBtn)', function (data) {
            layer.confirm('您确认要添加此备注？', {
                btn: ['确认','取消'] //按钮
            }, function(){
                $.ajax({
                    url: 'addRecord',
                    type: 'post',
                    data: {
                        "id": data.field.id,
                        "record": data.field.record
                    },
                    dataType: 'JSON',
                    success: function (res) {
                        layer.close(index5);
                        if (res.code == 200) {
                            layer.alert('添加成功！', {icon: 1});
                            table.reload('table_test', {
                                page: {
                                    curr: 1
                                }
                            });
                        }else {
                            layer.open({
                                title: '提示'
                                ,content: '添加失败！' + res.msg
                            });
                        }
                    },
                    error: function (data) {
                        layer.closeAll();
                        layer.open({
                            title: '提示'
                            ,content: '添加失败！未知原因，请联系管理员。'
                        });
                    }
                });
                $("#userModel").empty();
            }, function(){
                layer.msg('已取消..');
                $("#userModel").empty();
                return false;
            });
            $("#userModel").empty();
            return false;
        });
    })
    $("#quxiao5").click(function () {
        layer.close(index5);
    });
}

layui.use(['form', 'table'], function () {
    var form = layui.form;
    var table = layui.table;
    form.on('select(register_table)', function(data){
        var id = data.elem.parentNode.className;
        layer.confirm('您确认要修改该用户注册信息？', {
            btn: ['确认','取消'] //按钮
        }, function() {
            $.ajax({
                type: "POST",
                url: "editRegister",
                data: {
                    "id": id,
                    "register": data.value
                },
                success: function (data) {
                    if (data.code == 200) {
                        layer.alert('修改成功！', {icon: 1});
                        table.reload('table_test', {
                            page: {
                                curr: 1
                            }
                        });
                    } else {
                        layer.alert(data.msg);
                    }
                }
            });
        }, function(){
            layer.msg('已取消..');
            return false;
        });
        return false;
    });
})
layui.use(['form', 'table'], function () {
    var form = layui.form;
    var table = layui.table;
    form.on('select(provinces_table)', function(data){
        var id = data.elem.parentNode.className;
        layer.confirm('您确认要修改地区？', {
            btn: ['确认','取消'] //按钮
        }, function() {
            $.ajax({
                type: "POST",
                url: "editAddress",
                data: {
                    "id": id,
                    "address": data.value
                },
                success: function (data) {
                    if (data.code == 200) {
                        layer.alert('修改成功！', {icon: 1});
                        table.reload('table_test', {
                            page: {
                                curr: 1
                            }
                        });
                    } else {
                        layer.alert(data.msg);
                    }
                }
            });
        }, function(){
            layer.msg('已取消..');
            return false;
        });
        return false;
    });
})
layui.use(['form', 'table'], function () {
    var form = layui.form;
    var table = layui.table;

    form.on('select(idea_table)', function(data){
        var id = data.elem.parentNode.className;
        layer.confirm('您确认要修改该客户的意愿？', {
            btn: ['确认','取消'] //按钮
        }, function() {
            $.ajax({
                type: "POST",
                url: "editCustomerIdea",
                data: {
                    "id": id,
                    "ideaId": data.value
                },
                success: function (data) {
                    if (data.code == 200) {
                        layer.alert('修改成功！', {icon: 1});
                        table.reload('table_test', {
                            page: {
                                curr: 1
                            }
                        });
                    } else {
                        layer.alert(data.msg);
                    }
                }
            });
        }, function(){
            layer.msg('已取消..');
            return false;
        });
        return false;
    });
})

layui.use(['form', 'table'], function () {
    var form = layui.form;
    var table = layui.table;

    form.on('select(source_table)', function(data){
        var id = data.elem.parentNode.className;
        layer.confirm('您确认要修改该客户的来源？', {
            btn: ['确认','取消'] //按钮
        }, function() {
            $.ajax({
                type: "POST",
                url: "editCustomerSource",
                data: {
                    "id": id,
                    "sourceId": data.value
                },
                success: function (data) {
                    if (data.code == 200) {
                        layer.alert('修改成功！', {icon: 1});
                        table.reload('table_test', {
                            page: {
                                curr: 1
                            }
                        });
                    } else {
                        layer.alert(data.msg);
                    }
                }
            });
        }, function(){
            layer.msg('已取消..');
            return false;
        });
        return false;
    });
})


function editRecord(res) {
    var customerId = res.parentNode.childNodes[0].innerHTML;
    var id = res.parentNode.childNodes[1].innerHTML;
    var date = res.parentNode.childNodes[2].innerHTML;
    var record = res.parentNode.childNodes[3].innerHTML;

    $("#userModel").empty();
    var html = "<form class=\"layui-form\" action=\"\" style=\"margin-left: -80px;margin-top: 20px;margin-right: 20px;\">\n" +
        "        <div class=\"layui-form-item layui-form-text\" style='margin-top: 10px;margin-left: 90px;'>\n" +
        "           <label class='layui-form-label'>" + date + "</label>\n"+
        "           <div class=\"layui-input-block\">\n" +
        "               <textarea name=\"record\" placeholder=\"请输入内容\" lay-verify='required' class=\"layui-textarea\">" + record + "</textarea>\n"+
        "           </div>\n" +
        "        </div>\n" +
        "        <div class=\"layui-form-item layui-form-text\" style='display: none'>\n" +
        "            <div class=\"layui-input-block\">\n" +
        "                <input type=\"text\" name=\"id\" value='" + id + "' autocomplete=\"off\" class=\"layui-input\">\n" +
        "            </div>\n" +
        "        </div>\n" +
        "        <div class=\"layui-form-item layui-form-text\" style='display: none'>\n" +
        "            <div class=\"layui-input-block\">\n" +
        "                <input type=\"text\" name=\"customerId\" value='" + customerId + "' autocomplete=\"off\" class=\"layui-input\">\n" +
        "            </div>\n" +
        "        </div>\n" +
        "        <div class=\"layui-form-item\" style=\"float: right;margin-right: 20px;margin-top: 20px;\">\n" +
        "            <div class=\"layui-input-block\">\n" +
        "                <button class=\"layui-btn layui-btn\" lay-submit=\"\" lay-filter=\"enterRecord\">提交</button>\n" +
        "                <button class=\"layui-btn layui-btn-primary\" id=\"quxiao6\">取消</button>\n" +
        "            </div>\n" +
        "        </div>\n" +
        "    </form>";
    $("#userModel").html(html)
    var index6 = layer.open({
        type:1,
        title:"修改客户备注信息",
        area: ['650px','300px'],
        content: $("#userModel").html()
    });

    layui.use(['form', 'table'], function () {
        var form = layui.form;
        var table = layui.table;

        form.on('submit(enterRecord)', function (data) {
            debugger;
            layer.confirm('您确认要修改该备注？', {
                btn: ['确认', '取消'] //按钮
            }, function () {
                $.ajax({
                    type: "POST",
                    url: "editRecord",
                    data: {
                        "id": data.field.id,
                        "record": data.field.record,
                        "customerId": data.field.customerId
                    },
                    success: function (data) {
                        if (data.code == 200) {
                            layer.close(index6)
                            layer.alert('修改成功！', {icon: 1});
                            table.reload('table_test', {
                                page: {
                                    curr: 1
                                }
                            });
                        } else {
                            layer.alert(data.msg);
                        }
                    }
                });
            }, function () {
                layer.msg('已取消..');
                return false;
            });
            return false;
        })
    })
    $("#quxiao6").click(function () {
        layer.close(index6);
    });
}

layui.use(['form', 'table'], function () {
    var form = layui.form;
    var table = layui.table;

    form.on('select(user_table)', function(data){
        var id = data.elem.parentNode.className;
        layer.confirm('您确认要指派给该员工吗？', {
            btn: ['确认','取消'] //按钮
        }, function() {
            $.ajax({
                type: "POST",
                url: "changeUserToCustomer",
                data: {
                    "id": id,
                    "userId": data.value
                },
                success: function (data) {
                    if (data.code == 200) {
                        layer.alert('修改成功！', {icon: 1});
                        table.reload('table_test', {
                            page: {
                                curr: 1
                            }
                        });
                    } else {
                        layer.alert(data.msg);
                    }
                }
            });
        }, function(){
            layer.msg('已取消..');
            return false;
        });
        return false;
    });
})

$("#enterFind").click(function () {
    debugger;
    var phoneNUM = "";
    var callNUM = "";
    if($("#phoneType").val() == 1){
        phoneNUM = $("#selectAll").val();
    }else{
        callNUM = $("#selectAll").val();
    }
    layui.use('table', function() {
        var table = layui.table;
        table.reload('table_test', {
            where:{
                type: type_num,
                titleId: title_num,
                professionId: profession_num,
                provinces: provinceName,
                register: registerName,
                manager: 0,
                ideaId: idea_num,
                sourceId: source_num,
                updateDate: $("#updateDate").val(),
                phone: phoneNUM,
                call: callNUM
            }
            ,page: {
                curr: 1
            }
        });
    })
});

