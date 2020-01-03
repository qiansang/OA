var array;
var form = layui.form;
$(function () {
    getRole();
});

function getRole(){
    $.ajax({
        type:"POST",
        url:"getRole",
        success:function (data) {
            if(data.code == 200){
                array = eval(data.data);
                getUser();
            }else{
                layer.alert(data.msg);
            }
        }
    });
}

function getUser(){
    $('#user_table').empty();
    layui.use(['table', 'form'], function(){
        var table = layui.table;
        var form = layui.form;

        table.render({
           even: true //开启隔行背景
            , elem: '#user_table'
            , url:'getUserInfo'
            , method: 'post'
            , request: {
                pageName: 'pageNumber' //页码的参数名称，默认：page
                ,limitName: 'pageSize' //每页数据量的参数名，默认：limit
            }
            , where: {
               "name": $('#name').val()
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
            , limits: [15, 30, 60]
            , limit: 15 //默认采用30
            , loading: true
            , cols: [[
                {field:'id', width: 100, title: '编号', sort: true}
                ,{field:'username', width: 140, title: '用户'}
                ,{field:'name', width: 140, title: '姓名'}
                , {field: 'roleId', width: 140, title: '角色',templet: function(res){
                        for (var i = 0; i < array.length; i++) {
                            if(res.roleId == array[i].id){
                                return array[i].remarks;
                            }
                        }
                    }
                }
                , {field: 'login', width: 140, title: '状态',templet: function(res){
                        if(res.login == 0){
                            return " <input type='checkbox' name='close' lay-skin='switch' value='"+res.id+"' lay-filter='status' lay-text='锁定|未锁定'/>";
                        }else{
                            return " <input type='checkbox' name='open' checked lay-skin='switch' value='"+res.id+"' lay-filter='status' lay-text='锁定|未锁定'/>";
                        }
                    }
                }
                ,{fixed: 'right', minWidth: 150, title:'操作', toolbar: '#barDemo'}
            ]]
        });

        form.on('switch(status)', function(data) {
            debugger;
            var login = 0;
            if(data.elem.checked){
                login = 1;
            }
                $.ajax({
                    url: 'lockUser',
                    type: 'post',
                    data: {
                        "id": data.value,
                        "login": login
                    },
                    dataType: 'JSON',
                    success: function (res) {
                        if (res.code == 200) {
                            layer.msg('状态：'+ (login == 1 ? '用户被锁定' : '用户解锁'), {
                                offset: '6px'
                            });
                            table.reload('user_table', {
                                page: {
                                    curr: 1
                                }
                            });
                        }else {
                            layer.open({
                                title: '提示'
                                ,content: '修改用户状态失败！' + res.msg
                            });
                            table.reload('user_table', {
                                page: {
                                    curr: 1
                                }
                            });
                        }
                    },
                    error: function (data) {
                        layer.open({
                            title: '提示'
                            ,content: '删除失败！未知原因，请联系管理员。' + data.msg
                        });
                    }
                });
        });
            //监听行工具事件
        table.on('tool(user_table)', function(obj){
            var data = obj.data;
            if(obj.event === 'del'){
                layer.confirm('确定删除?', function(index){
                    $.ajax({
                        url: 'deleteUser',
                        type: 'post',
                        data: {
                            "id": data.id
                        },
                        dataType: 'JSON',
                        success: function (res) {
                            if (res.code == 200) {
                                layer.alert('删除成功！', {icon: 1});
                                table.reload('user_table', {
                                    page: {
                                        curr: 1
                                    }
                                });
                            }else {
                                layer.open({
                                    title: '提示'
                                    ,content: '删除失败！' + res.msg
                                });
                            }
                        },
                        error: function (data) {
                            layer.open({
                                title: '提示'
                                ,content: '删除失败！未知原因，请联系管理员。' + data.msg
                            });
                        }
                    });
                    layer.close(index);
                });
            } else if(obj.event === 'edit'){
                getEditPage(data);

            } else if(obj.event === 'reset'){
                layer.confirm('确定重置密码?', function(index){
                    $.ajax({
                        url: 'reSetPwd',
                        type: 'post',
                        data: {
                            "id": data.id
                        },
                        dataType: 'JSON',
                        success: function (res) {
                            if (res.code == 200) {
                                layer.alert('重置成功！', {icon: 1});
                            }else {
                                layer.open({
                                    title: '提示'
                                    ,content: '重置失败！' + res.msg
                                });
                            }
                        },
                        error: function (data) {
                            layer.open({
                                title: '提示'
                                ,content: '重置失败！未知原因，请联系管理员。'
                            });
                        }
                    });
                    layer.close(index);
                });
            }
        });
    });
}

$("#formSelect").click(function () {//find user
    getUser();
});

$("#addUser").click(function () {//add user
    layer.open({
        type:1,
        title:"添加用户",
        area: ['500px','350px'],
        content:$("#userModel").html(" <form class=\"layui-form\" action=\"\" style=\"margin-left: 60px;margin-top: 20px;\">\n" +
            "        <div class=\"layui-form-item\">\n" +
            "            <label class=\"layui-form-label\"><span style=\"color:red\">*</span>用户名</label>\n" +
            "            <div class=\"layui-input-inline\">\n" +
            "                <input type=\"text\" name=\"username\"  placeholder=\"请输入用户名\" lay-verify=\"required\" autocomplete=\"off\" class=\"layui-input\">\n" +
            "            </div>\n" +
            "        </div>\n" +
            "        <div class=\"layui-form-item\">\n" +
            "            <label class=\"layui-form-label\"><span style=\"color:red\">*</span>姓名</label>\n" +
            "            <div class=\"layui-input-inline\">\n" +
            "                <input type=\"text\" name=\"name\"  placeholder=\"请输入姓名\" lay-verify=\"required\" autocomplete=\"off\" class=\"layui-input\">\n" +
            "            </div>\n" +
            "        </div>\n" +
            "        <div class=\"layui-form-item\">\n" +
            "            <label class=\"layui-form-label\"><span style=\"color:red\">*</span>角色</label>\n" +
            "            <div class=\"layui-input-inline\">\n" +
            "                <select name=\"roleId\" id=\"role\" lay-verify=\"required\">\n" +
            "                </select>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "        <div class=\"layui-form-item\" style=\"margin-left: 50px;\">\n" +
            "            <div class=\"layui-input-block\">\n" +
            "                <button class=\"layui-btn layui-btn\" lay-submit=\"\" lay-filter=\"tjbtn\">提交</button>\n" +
            "                <button class=\"layui-btn layui-btn\" lay-filter=\"quxiao\">取消</button>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "    </form>")
    });
    getRoleOption();
});


function getRoleOption(){
    layui.use(['form', 'table'], function () {
        var form = layui.form;
        var table = layui.table;

        var html = "<option value=''>请选择</option>";
        $("#role").empty();
        for (var i = 0; i < array.length; i++) {
            html += "<option value='" + array[i].id + "'>" + array[i].remarks + "</option>";
        }
        $("#role").append(html);
        form.render('select');

        form.on('submit(tjbtn)', function (data) {
            layer.confirm('您确认要添加此用户吗？', {
                btn: ['确认','取消'] //按钮
            }, function(){
                $.ajax({
                    url: 'addUser',
                    type: 'post',
                    data: JSON.stringify(data.field),
                    contentType : "application/json",
                    dataType: 'JSON',
                    success: function (res) {
                        layer.closeAll();
                        if (res.code == 200) {
                            layer.alert('添加成功！', {icon: 1});
                            table.reload('user_table', {
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
}

$("#quxiao").click(function () {
    layer.closeAll();
});

function getEditPage(data){
    layer.open({
        type:1,
        title:"修改用户",
        area: ['500px','350px'],
        content:$("#userModel").html(" <form class=\"layui-form\" action=\"\" style=\"margin-left: 60px;margin-top: 20px;\">\n" +
            "        <div class=\"layui-form-item\" style='display: none'>\n" +
            "            <label class=\"layui-form-label\"><span style=\"color:red\">*</span>id</label>\n" +
            "            <div class=\"layui-input-inline\">\n" +
            "                <input type=\"text\" name=\"id\"  placeholder=\"请输入id\" lay-verify=\"required\" value='" + data.id + "' autocomplete=\"off\" class=\"layui-input\">\n" +
            "            </div>\n" +
            "        </div>\n" +
            "        <div class=\"layui-form-item\">\n" +
            "            <label class=\"layui-form-label\"><span style=\"color:red\">*</span>用户名</label>\n" +
            "            <div class=\"layui-input-inline\">\n" +
            "                <input type=\"text\" name=\"username\"  placeholder=\"请输入用户名\" lay-verify=\"required\" value='" + data.username + "' autocomplete=\"off\" class=\"layui-input\">\n" +
            "            </div>\n" +
            "        </div>\n" +
            "        <div class=\"layui-form-item\">\n" +
            "            <label class=\"layui-form-label\"><span style=\"color:red\">*</span>姓名</label>\n" +
            "            <div class=\"layui-input-inline\">\n" +
            "                <input type=\"text\" name=\"name\"  placeholder=\"请输入姓名\" lay-verify=\"required\" value='" + data.name + "' autocomplete=\"off\" class=\"layui-input\">\n" +
            "            </div>\n" +
            "        </div>\n" +
            "        <div class=\"layui-form-item\">\n" +
            "            <label class=\"layui-form-label\"><span style=\"color:red\">*</span>角色</label>\n" +
            "            <div class=\"layui-input-inline\">\n" +
            "                <select name=\"roleId\" id=\"role\" lay-verify=\"required\">\n" +
            "                </select>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "        <div class=\"layui-form-item\" style=\"margin-left: 50px;\">\n" +
            "            <div class=\"layui-input-block\">\n" +
            "                <button class=\"layui-btn layui-btn\" lay-submit=\"\" lay-filter=\"editBtn\">提交</button>\n" +
            "                <button class=\"layui-btn layui-btn\" lay-filter=\"quxiao\">取消</button>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "    </form>")
    });
    editUserAfter(data);
}

function editUserAfter(data) {
    layui.use(['form', 'table'], function () {
        var form = layui.form;
        var table = layui.table;

        var html = "";
        $("#role").empty();
        for (var i = 0; i < array.length; i++) {
            if(array[i].id == data.roleId){
                html += "<option value='" + array[i].id + "' selected='selected'>" + array[i].remarks + "</option>";
            }else{
                html += "<option value='" + array[i].id + "'>" + array[i].remarks + "</option>";
            }
        }
        $("#role").append(html);
        form.render('select');

        form.on('submit(editBtn)', function (data) {
            layer.confirm('您确认要修改此用户吗？', {
                btn: ['确认','取消'] //按钮
            }, function(){
                $.ajax({
                    url: 'editUser',
                    type: 'post',
                    data: JSON.stringify(data.field),
                    contentType : "application/json",
                    dataType: 'JSON',
                    success: function (res) {
                        layer.closeAll();
                        if (res.code == 200) {
                            layer.alert('修改成功！', {icon: 1});
                            table.reload('user_table', {
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
}

