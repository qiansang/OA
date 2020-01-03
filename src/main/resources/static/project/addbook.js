$(function(){
    layui.use(['layer', 'form'], function () {
        var layer = layui.layer;
        var form = layui.form;

        $.ajax({
            type: "POST",
            url: "getTitle",
            success: function (data) {
                if (data.code == 200) {
                    var html = "<option value=''>请选择</option>";
                    $("#bookType").empty();
                    var list = eval(data.data);
                    for (var i = 0; i < list.length; i++) {
                        html += "<option value='" + list[i].id + "'>" + list[i].name + "</option>";
                    }
                    $("#bookType").append(html);
                    form.render('select');
                } else {
                    layer.open({
                        title: '提示'
                        ,content: '证书类型获取失败：'+data.msg
                    });
                }
            }
        });

        $.ajax({
            type: "POST",
            url: "getIdea",
            success: function (data) {
                if (data.code == 200) {
                    var html = "<option value=''>请选择</option>";
                    $("#idea").empty();
                    var list = eval(data.data);
                    for (var i = 0; i < list.length; i++) {
                        html += "<option value='" + list[i].id + "'>" + list[i].name + "</option>";
                    }
                    $("#idea").append(html);
                    form.render('select');
                } else {
                    layer.open({
                        title: '提示'
                        ,content: '意向获取失败：'+data.msg
                    });
                }
            }
        });

        $.ajax({
            type: "POST",
            url: "getSource",
            success: function (data) {
                if (data.code == 200) {
                    var html = "<option value=''>请选择</option>";
                    $("#source").empty();
                    var list = eval(data.data);
                    for (var i = 0; i < list.length; i++) {
                        html += "<option value='" + list[i].id + "'>" + list[i].name + "</option>";
                    }
                    $("#source").append(html);
                    form.render('select');
                } else {
                    layer.open({
                        title: '提示'
                        ,content: '来源获取失败：'+data.msg
                    });
                }
            }
        });

        form.on('select(bookType)', function(data){
            $.ajax({
                type: "POST",
                url: "getProfessionByTitleId",
                data: {
                    "titleId": data.value
                },
                success: function (data) {
                    if (data.code == 200) {
                        var html = "<option value=''>请选择</option>";
                        $("#bookPro").empty();
                        var list = eval(data.data);
                        for (var i = 0; i < list.length; i++) {
                            html += "<option value='" + list[i].id + "'>" + list[i].name + "</option>";
                        }
                        $("#bookPro").append(html);
                        form.render('select');
                    } else {
                        layer.open({
                            title: '提示'
                            ,content: '证书专业获取失败：'+data.msg
                        });
                    }
                }
            });
        });

        form.on('submit(formInsert)', function (data) {
            layer.confirm('您确认要添加此证书吗？', {
                btn: ['确认','取消'] //按钮
            }, function(){
                $.ajax({
                    url: 'addCustomer',
                    type: 'post',
                    data: JSON.stringify(data.field),
                    contentType : "application/json",
                    dataType: 'JSON',
                    success: function (res) {
                        if (res.code == 200) {
                            layer.alert('添加成功！', {icon: 1});
                            $("#reset").trigger('click');
                        }else {
                            layer.open({
                                title: '提示'
                                ,content: '添加失败！' + res.msg
                            });
                        }
                    },
                    error: function (data) {
                        layer.open({
                            title: '提示'
                            ,content: '添加失败！未知原因，请联系管理员。'
                        });
                    }
                });
            }, function(){
                layer.msg('已取消..');
                return false;
            });
            return false;
        });
    });
});