$(function () {
    getProfession();
    getIdea();
    getSource();
});
function getProfession(){
    $('#user_table').empty();
    layui.use('table', function() {
        var table = layui.table;

        var tableIns = table.render({
            even: true //开启隔行背景
            , elem: '#profession_table'
            , url: 'setProfession'
            , method: 'post'
            , parseData: function (res) { //res 即为原始返回的数据
                return {
                    "code": res.code, //解析接口状态
                    "msg": res.msg, //解析提示文本
                    "data": res.rows //解析数据列表
                };
            }
            , loading: true
            , cols: [[
                , {field: 'title', minWidth: 200, title: '职称分类'}
                , {field: 'profession', minWidth: 1000, title: '证书专业',templet: function(res){
                        var list = eval(res.professionList);
                        var html = "";
                        for (var i = 0; i < list.length; i++) {
                            if(i == (list.length-1)){
                                html += "<a class='"+list[i].id+"' href='#' onclick='editProfession(this)'>"+list[i].name+"</a>";
                            }else{
                                html += "<a class='"+list[i].id+"' href='#' onclick='editProfession(this)'>"+list[i].name+"</a>" + ", ";
                            }
                        }
                        return html;
                    }
                }
                , {fixed: 'right', minWidth: 200, title: '操作', toolbar: '#barDemo'}
            ]]
        });

        //监听行工具事件
        table.on('tool(profession_table)', function(obj){
            var data = obj.data;
            if(obj.event === 'add'){
                    layer.open({
                        type:1,
                        title:"添加证书专业",
                        area: ['350px','210px'],
                        content:$("#userModel").html(" <form class=\"layui-form\" action=\"\" style=\"margin-left: 60px;margin-top: 20px;\">\n" +
                            "        <div class=\"layui-form-item\" style='display: none'>\n" +
                            "            <div class=\"layui-input-inline\">\n" +
                            "                <input type=\"text\" name=\"id\" lay-verify=\"required\" value='"+data.id+"' autocomplete=\"off\" class=\"layui-input\">\n" +
                            "            </div>\n" +
                            "        </div>\n" +
                            "        <div class=\"layui-form-item\">\n" +
                            "            <div class=\"layui-input-inline\">\n" +
                            "                <input type=\"text\" name=\"profession\"  placeholder=\"请输入职称\" lay-verify=\"required\" autocomplete=\"off\" class=\"layui-input\">\n" +
                            "            </div>\n" +
                            "        </div>\n" +
                            "        <div class=\"layui-form-item\">\n" +
                            "            <div class=\"layui-input-block\">\n" +
                            "                <button class=\"layui-btn layui-btn\" lay-submit=\"\" lay-filter=\"addProfessionBtn\">提交</button>\n" +
                            "                <button class=\"layui-btn layui-btn\" lay-filter=\"quxiao\">取消</button>\n" +
                            "            </div>\n" +
                            "        </div>\n" +
                            "    </form>")
                    });
                    layui.use(['form', 'table'], function () {
                        var form = layui.form;
                        var table = layui.table;

                        form.on('submit(addProfessionBtn)', function (data) {
                            layer.confirm('您确认要添加证书？', {
                                btn: ['确认','取消'] //按钮
                            }, function(){
                                $.ajax({
                                    url: 'addProfession',
                                    type: 'post',
                                    data: {
                                        "id": data.field.id,
                                        "profession": data.field.profession
                                    },
                                    dataType: 'JSON',
                                    success: function (res) {
                                        layer.closeAll();
                                        if (res.code == 200) {
                                            layer.alert('添加成功！', {icon: 1});
                                            table.reload('profession_table', {
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
        });
    });
}

function getIdea(){
    $('#user_table').empty();
    layui.use('table', function() {
        var table = layui.table;

        var tableIns = table.render({
            even: true //开启隔行背景
            , elem: '#idea_table'
            , url: 'setIdea'
            , method: 'post'
            , parseData: function (res) { //res 即为原始返回的数据
                return {
                    "code": res.code, //解析接口状态
                    "msg": res.msg, //解析提示文本
                    "data": res.rows //解析数据列表
                };
            }
            , loading: true
            , cols: [[
                , {field: 'id', minWidth: 200, title: '编号'}
                , {field: 'name', minWidth: 1000, title: '名称'}
                , {fixed: 'right', minWidth: 200, title: '操作', toolbar: '#barDemo1'}
            ]]
        });

        //监听行工具事件
        table.on('tool(idea_table)', function(obj){
            var data = obj.data;
            if(obj.event === 'edit'){
                layer.open({
                    type:1,
                    title:"修改意向",
                    area: ['350px','210px'],
                    content:$("#userModel").html(" <form class=\"layui-form\" action=\"\" style=\"margin-left: 60px;margin-top: 20px;\">\n" +
                        "        <div class=\"layui-form-item\" style='display: none;'>\n" +
                        "            <div class=\"layui-input-inline\">\n" +
                        "                <input type=\"text\" name=\"id\" lay-verify=\"required\" value='"+data.id+"' autocomplete=\"off\" class=\"layui-input\">\n" +
                        "            </div>\n" +
                        "        </div>\n" +
                        "        <div class=\"layui-form-item\">\n" +
                        "            <div class=\"layui-input-inline\">\n" +
                        "                <input type=\"text\" name=\"idea\"  placeholder=\"请输入意向\" value='"+data.name+"' autocomplete=\"off\" class=\"layui-input\">\n" +
                        "            </div>\n" +
                        "        </div>\n" +
                        "        <div class=\"layui-form-item\">\n" +
                        "            <div class=\"layui-input-block\">\n" +
                        "                <button class=\"layui-btn layui-btn\" lay-submit=\"\" lay-filter=\"editIdeaBtn\">提交</button>\n" +
                        "                <button class=\"layui-btn layui-btn\" lay-filter=\"quxiao\">取消</button>\n" +
                        "            </div>\n" +
                        "        </div>\n" +
                        "    </form>")
                });

                layui.use(['form', 'table'], function () {
                    var form = layui.form;
                    var table = layui.table;

                    form.on('submit(editIdeaBtn)', function (data) {
                        layer.confirm('您确认要修改此意向吗？', {
                            btn: ['确认','取消'] //按钮
                        }, function(){
                            $.ajax({
                                url: 'editIdea',
                                type: 'post',
                                data: {
                                    "id": data.field.id,
                                    "idea": data.field.idea
                                },
                                dataType: 'JSON',
                                success: function (res) {
                                    layer.closeAll();
                                    if (res.code == 200) {
                                        layer.alert('修改成功！', {icon: 1});
                                        table.reload('idea_table', {
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
            }
        });
    });
}
function getSource(){
    $('#user_table').empty();
    layui.use('table', function() {
        var table = layui.table;

        var tableIns = table.render({
            even: true //开启隔行背景
            , elem: '#source_table'
            , url: 'setSource'
            , method: 'post'
            , parseData: function (res) { //res 即为原始返回的数据
                return {
                    "code": res.code, //解析接口状态
                    "msg": res.msg, //解析提示文本
                    "data": res.rows //解析数据列表
                };
            }
            , loading: true
            , cols: [[
                , {field: 'id', minWidth: 200, title: '编号'}
                , {field: 'name', minWidth: 1000, title: '名称'}
                , {fixed: 'right', minWidth: 200, title: '操作', toolbar: '#barDemo1'}
            ]]
        });

        //监听行工具事件
        table.on('tool(source_table)', function(obj){
            var data = obj.data;
            if(obj.event === 'edit'){
                layer.open({
                    type:1,
                    title:"修改来源",
                    area: ['350px','210px'],
                    content:$("#userModel").html(" <form class=\"layui-form\" action=\"\" style=\"margin-left: 60px;margin-top: 20px;\">\n" +
                        "        <div class=\"layui-form-item\" style='display: none;'>\n" +
                        "            <div class=\"layui-input-inline\">\n" +
                        "                <input type=\"text\" name=\"id\" lay-verify=\"required\" value='"+data.id+"' autocomplete=\"off\" class=\"layui-input\">\n" +
                        "            </div>\n" +
                        "        </div>\n" +
                        "        <div class=\"layui-form-item\">\n" +
                        "            <div class=\"layui-input-inline\">\n" +
                        "                <input type=\"text\" name=\"source\"  placeholder=\"请输入来源\" value='"+data.name+"' autocomplete=\"off\" class=\"layui-input\">\n" +
                        "            </div>\n" +
                        "        </div>\n" +
                        "        <div class=\"layui-form-item\">\n" +
                        "            <div class=\"layui-input-block\">\n" +
                        "                <button class=\"layui-btn layui-btn\" lay-submit=\"\" lay-filter=\"editSourceBtn\">提交</button>\n" +
                        "                <button class=\"layui-btn layui-btn\" lay-filter=\"quxiao\">取消</button>\n" +
                        "            </div>\n" +
                        "        </div>\n" +
                        "    </form>")
                });

                layui.use(['form', 'table'], function () {
                    var form = layui.form;
                    var table = layui.table;

                    form.on('submit(editSourceBtn)', function (data) {
                        layer.confirm('您确认要修改此来源吗？', {
                            btn: ['确认','取消'] //按钮
                        }, function(){
                            $.ajax({
                                url: 'editSource',
                                type: 'post',
                                data: {
                                    "id": data.field.id,
                                    "source": data.field.source
                                },
                                dataType: 'JSON',
                                success: function (res) {
                                    layer.closeAll();
                                    if (res.code == 200) {
                                        layer.alert('修改成功！', {icon: 1});
                                        table.reload('source_table', {
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
            }
        });
    });
}

$("#addTitle").click(function () {
    var index1 = layer.open({
        type:1,
        title:"添加职称",
        area: ['350px','210px'],
        content:$("#userModel").html(" <form class=\"layui-form\" action=\"\" style=\"margin-left: 60px;margin-top: 20px;\">\n" +
            "        <div class=\"layui-form-item\">\n" +
            "            <div class=\"layui-input-inline\">\n" +
            "                <input type=\"text\" name=\"title\"  placeholder=\"请输入职称\" lay-verify=\"required\" autocomplete=\"off\" class=\"layui-input\">\n" +
            "            </div>\n" +
            "        </div>\n" +
            "        <div class=\"layui-form-item\">\n" +
            "            <div class=\"layui-input-block\">\n" +
            "                <button class=\"layui-btn layui-btn\" lay-submit=\"\" lay-filter=\"tjbtn\">提交</button>\n" +
            "                <button class=\"layui-btn layui-btn\" lay-filter=\"quxiao\">取消</button>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "    </form>")
    });

    layui.use(['form', 'table'], function () {
        var form = layui.form;
        var table = layui.table;

        form.on('submit(tjbtn)', function (data) {
            layer.confirm('您确认要添加此职称吗？', {
                btn: ['确认','取消'] //按钮
            }, function(){
                $.ajax({
                    url: 'addTitle',
                    type: 'post',
                    data: {
                        "title": data.field.title
                    },
                    dataType: 'JSON',
                    success: function (res) {
                        layer.closeAll();
                        if (res.code == 200) {
                            layer.alert('添加成功！', {icon: 1});
                            table.reload('profession_table', {
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
});

$("#addIdea").click(function () {
    var index2 = layer.open({
        type:1,
        title:"添加意向",
        area: ['350px','210px'],
        content:$("#userModel").html(" <form class=\"layui-form\" action=\"\" style=\"margin-left: 60px;margin-top: 20px;\">\n" +
            "        <div class=\"layui-form-item\">\n" +
            "            <div class=\"layui-input-inline\">\n" +
            "                <input type=\"text\" name=\"idea\"  placeholder=\"请输入意向\" lay-verify=\"required\" autocomplete=\"off\" class=\"layui-input\">\n" +
            "            </div>\n" +
            "        </div>\n" +
            "        <div class=\"layui-form-item\">\n" +
            "            <div class=\"layui-input-block\">\n" +
            "                <button class=\"layui-btn layui-btn\" lay-submit=\"\" lay-filter=\"tjbtn\">提交</button>\n" +
            "                <button class=\"layui-btn layui-btn\" lay-filter=\"quxiao\">取消</button>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "    </form>")
    });

    layui.use(['form', 'table'], function () {
        var form = layui.form;
        var table = layui.table;
        form.on('submit(tjbtn)', function (data) {
            layer.confirm('您确认要添加此意向吗？', {
                btn: ['确认','取消'] //按钮
            }, function(){
                $.ajax({
                    url: 'addIdea',
                    type: 'post',
                    data: {
                        "idea": data.field.idea
                    },
                    dataType: 'JSON',
                    success: function (res) {
                        layer.closeAll();
                        if (res.code == 200) {
                            layer.alert('添加成功！', {icon: 1});
                            table.reload('idea_table', {
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
});

$("#addSource").click(function () {
    var index3 = layer.open({
        type:1,
        title:"添加来源",
        area: ['350px','210px'],
        content:$("#userModel").html(" <form class=\"layui-form\" action=\"\" style=\"margin-left: 60px;margin-top: 20px;\">\n" +
            "        <div class=\"layui-form-item\">\n" +
            "            <div class=\"layui-input-inline\">\n" +
            "                <input type=\"text\" name=\"source\"  placeholder=\"请输入来源\" lay-verify=\"required\" autocomplete=\"off\" class=\"layui-input\">\n" +
            "            </div>\n" +
            "        </div>\n" +
            "        <div class=\"layui-form-item\">\n" +
            "            <div class=\"layui-input-block\">\n" +
            "                <button class=\"layui-btn layui-btn\" lay-submit=\"\" lay-filter=\"tjbtn\">提交</button>\n" +
            "                <button class=\"layui-btn layui-btn\" lay-filter=\"quxiao\">取消</button>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "    </form>")
    });

    layui.use(['form', 'table'], function () {
        var form = layui.form;
        var table = layui.table;
        form.on('submit(tjbtn)', function (data) {
            layer.confirm('您确认要添加此来源吗？', {
                btn: ['确认','取消'] //按钮
            }, function(){
                $.ajax({
                    url: 'addSource',
                    type: 'post',
                    data: {
                        "source": data.field.source
                    },
                    dataType: 'JSON',
                    success: function (res) {
                        layer.closeAll();
                        if (res.code == 200) {
                            layer.alert('添加成功！', {icon: 1});
                            table.reload('source_table', {
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
                layer.close(index3);
                layer.msg('已取消..');
                $("#userModel").empty();
                return false;
            });
            $("#userModel").empty();
            return false;
        });
    })
});

function editProfession(obj){
    debugger;
    var id = obj.className;
    var name = obj.innerHTML;
    var index4 = layer.open({
        type:1,
        title:"修改证书专业",
        area: ['350px','210px'],
        content:$("#userModel").html(" <form class=\"layui-form\" action=\"\" style=\"margin-left: 60px;margin-top: 20px;\">\n" +
            "        <div class=\"layui-form-item\" style='display: none'>\n" +
            "            <div class=\"layui-input-inline\">\n" +
            "                <input type=\"text\" name=\"id\" value='"+id+"' autocomplete=\"off\" class=\"layui-input\">\n" +
            "            </div>\n" +
            "        </div>\n" +
            "        <div class=\"layui-form-item\">\n" +
            "            <div class=\"layui-input-inline\">\n" +
            "                <input type=\"text\" name=\"profession\"  placeholder=\"请输入职称\" value='"+name+"' autocomplete=\"off\" class=\"layui-input\">\n" +
            "            </div>\n" +
            "        </div>\n" +
            "        <div class=\"layui-form-item\">\n" +
            "            <div class=\"layui-input-block\">\n" +
            "                <button class=\"layui-btn layui-btn\" lay-submit=\"\" lay-filter=\"editProfessionBtn\">提交</button>\n" +
            "                <button class=\"layui-btn layui-btn\" lay-filter=\"quxiao\">取消</button>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "    </form>")
    });
    layui.use(['form', 'table'], function () {
        var form = layui.form;
        var table = layui.table;
        form.on('submit(editProfessionBtn)', function (data) {
            layer.confirm('您确认要修改此证书专业吗？', {
                btn: ['确认','取消'] //按钮
            }, function(){
                $.ajax({
                    url: 'editProfession',
                    type: 'post',
                    data: {
                        "id": data.field.id,
                        "profession": data.field.profession
                    },
                    dataType: 'JSON',
                    success: function (res) {
                        layer.close(index4);
                        if (res.code == 200) {
                            layer.alert('修改成功！', {icon: 1});
                            table.reload('profession_table', {
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
    })
}