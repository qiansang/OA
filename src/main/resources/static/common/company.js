var idealist,sourcelist, titlelist,professionList;
var success = 0;

$(function () {
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
                alert(data.msg);
            }
        }
    });

    getAllProfession();

    $.ajax({
        type:"POST",
        url:"getIdea",
        success:function (data) {
            if(data.code == 200){
                var html = "<a id='idea_0' onclick='getIdea(0)'>不限</a>";
                $("#idea").html();
                idealist = eval(data.data);
                for(var i = 0; i < idealist.length; i++){
                    html += "&nbsp;&nbsp;<a  id='idea_" + idealist[i].id + "' onclick='getIdea(" + idealist[i].id + ", 0)'>" + idealist[i].name + "</a>";
                    if(idealist[i].name.indexOf("成交") != -1){
                        success = idealist[i].id;
                    }
                }
                $("#idea").html(html);
            }else{
                alert(data.msg);
            }
        }
    });
    $.ajax({
        type:"POST",
        url:"getSource",
        success:function (data) {
            if(data.code == 200){
                var html = "<a id='source_0' onclick='getSource(0)'>不限</a>";
                $("#source").html();
                sourcelist = eval(data.data);
                for(var i = 0; i < sourcelist.length; i++){
                    html += "&nbsp;&nbsp;<a  id='source_" + sourcelist[i].id + "' onclick='getSource(" + sourcelist[i].id + ", 0)'>" + sourcelist[i].name + "</a>";
                }
                $("#source").html(html);
            }else{
                alert(data.msg);
            }
        }
    });
    var timeJob = setInterval(function(){
        if(idealist==undefined || sourcelist == undefined || titlelist == undefined || professionList == undefined){
            return false;
        }else{
            getTableInfo();
            clearInterval(timeJob)
        }
    },500);
})

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

function getTableInfo() {
    layui.use('table', function () {
        var table = layui.table;

        table.render({
            even: false //开启隔行背景
            , elem: '#table_test'
            , toolbar: '#toolbarDemo'
            , url: 'getCustomerInfoForAllUser'
            , method: 'post'
            , request: {
                pageName: 'pageNumber' //页码的参数名称，默认：page
                , limitName: 'pageSize' //每页数据量的参数名，默认：limit
            }
            , parseData: function (res) { //res 即为原始返回的数据
                return {
                    "code": res.code, //解析接口状态
                    "msg": res.msg, //解析提示文本
                    "count": res.count, //解析数据长度
                    "data": res.rows //解析数据列表
                };
            }
            , page: {theme: "#009688"}
            , limits: [5, 10, 15]
            , limit: 5 //默认采用30
            , loading: true
            , cols: [[
                {field: 'id', width: 80, title: '编号', sort: true}
                , {field: 'update', minWidth: 130, title: '更新日期', sort: true}
                , {
                    field: 'ideaId', width: 70, title: '意向', templet: function (res) {
                        for (var i = 0; i < idealist.length; i++) {
                            if (idealist[i].id == res.ideaId) {
                                return idealist[i].name;
                            }
                        }
                        return "未知";
                    }
                }
                , {field: 'contact', width: 90, title: '联系人'}
                , {
                    field: 'titleId', title: '所需证书', minWidth: 130, templet: function (res) {
                        var titleName = "";
                        var professionName = "";
                        for (var i = 0; i < titlelist.length; i++) {
                            if (titlelist[i].id == res.titleId) {
                                titleName = titlelist[i].name;
                            }
                        }
                        for (var i = 0; i < professionList.length; i++) {
                            if (professionList[i].id == res.professionId) {
                                professionName = professionList[i].name + "[" + professionList[i].num + "人]";
                            }
                        }
                        return titleName + " - " + professionName;
                    }
                }
                , {field: 'register', width: 70, title: '注册'}
                , {field: 'provinces', width: 80, title: '地区'}
                , {
                    field: 'source', width: 70, title: '来源', templet: function (res) {
                        for (var i = 0; i < sourcelist.length; i++) {
                            if (sourcelist[i].id == res.sourceId) {
                                return sourcelist[i].name;
                            }
                        }
                        return "未知";
                    }
                }
                , {field: 'user', width: 80, title: '业务员'}
                , {
                    field: 'remark', minWidth: 180, title: '备注', templet: function (res) {
                        var html = "<div style='width: 100%' class='scrollbar style-1 toLow'>";
                        var color = 'SteelBlue;';
                        if(res.ideaId == success){
                            color = 'red;';
                        }
                        for (var i = 0; i < res.remark.length; i++) {
                            html += "<div><span style='color: #009688;'>" + res.remark[i].date + "</span><span style='color: "+color+"'>" + res.remark[i].content + "</span></div>";
                        }
                        html += "</div>";
                        html += "<script>$('.toLow').scrollTop($('.toLow')[0].scrollHeight);</script>";
                        return html;
                    }
                }
            ]]
        });
    });
}

$("#enterFind").click(function () {
    getAllProfession();
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
                manager: userId,
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

