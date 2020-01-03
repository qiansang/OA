function getStyle(num) {
    $("#type_" + type_num).css('background','');
    $("#type_" + type_num).css('color','');
    $("#type_" + num).css('background','#009688');
    $("#type_" + num).css('color','#FFFFFF');
    type_num = num;
    $("#enterFind").trigger("click");
}
function getTitle(num, type) {
    profession_num = 0;
    $("#title_" + title_num).css('background', '');
    $("#title_" + title_num).css('color', '');
    $("#title_" + num).css('background', '#009688');
    $("#title_" + num).css('color', '#FFFFFF');
    title_num = num;
    if (type != 1) {
        $("#enterFind").trigger("click");
    }
    if(num != 0){
        var tag = false;
        var html = "<a  id='profession_0' onclick='getProfession(0, 0)' style='display: none'>不限</a>";
        for (var i = 0; i < professionList.length; i++) {
            if(num == professionList[i].titleId){
                tag = true;
                html += "&nbsp;&nbsp;<a  id='profession_" + professionList[i].id + "' onclick='getProfession(" + professionList[i].id + ", 0)'>" + professionList[i].name + "[" + professionList[i].num + "]</a>";
            }
        }
        $("#profession").html(html);
        if(tag){
            layer.open({
                title: "专业证书",
                type: 1,
                offset: '20px',
                content: $("#professionDiv").html()
            });
        }
    }else{
        $("#professionDiv").hide();
        layer.closeAll();
        getProfession(0, 0);
    }
}
function getProfession(num, type) {
    $("#profession_" + profession_num).css('background','');
    $("#profession_" + profession_num).css('color','');
    $("#profession_" + num).css('background','#009688');
    $("#profession_" + num).css('color','#FFFFFF');
    profession_num = num;
    if(type != 1){
        $("#enterFind").trigger("click");
    }
    layer.closeAll();
}
function getProvinces(num, type) {
    $("#provinces_" + provinces_num).css('background','');
    $("#provinces_" + provinces_num).css('color','');
    $("#provinces_" + num).css('background','#009688');
    $("#provinces_" + num).css('color','#FFFFFF');
    provinceName = $("#provinces_" + num)[0].innerHTML;
    provinces_num = num;
    if(type != 1){
        $("#enterFind").trigger("click");
    }
}
function getRegister(num, type) {
    $("#register_" + register_num).css('background','');
    $("#register_" + register_num).css('color','');
    $("#register_" + num).css('background','#009688');
    $("#register_" + num).css('color','#FFFFFF');
    registerName = $("#register_" + num)[0].innerHTML;
    register_num = num;
    if(type != 1){
        $("#enterFind").trigger("click");
    }
}
function getSource(num, type) {
    debugger
    $("#source_" + source_num).css('background','');
    $("#source_" + source_num).css('color','');
    $("#source_" + num).css('background','#009688');
    $("#source_" + num).css('color','#FFFFFF');
    source_num = num;
    if(type != 1){
        $("#enterFind").trigger("click");
    }
}
function getIdea(num, type) {
    debugger;
    $("#idea_" + idea_num).css('background','');
    $("#idea_" + idea_num).css('color','');
    $("#idea_" + num).css('background','#009688');
    $("#idea_" + num).css('color','#FFFFFF');
    idea_num = num;
    if(type != 1){
        $("#enterFind").trigger("click");
    }
}
/*function getToDate(num) {
    $("#toDate_" + toDate_num).css('background','');
    $("#toDate_" + toDate_num).css('color','');
    $("#toDate_" + num).css('background','#009688');
    $("#toDate_" + num).css('color','#FFFFFF');
    toDate_num = num;
}*/
function getDate(num) {
    $("#date_" + date_num).css('background','');
    $("#date_" + date_num).css('color','');
    $("#date_" + num).css('background','#009688');
    $("#date_" + num).css('color','#FFFFFF');
    date_num = num;
    if(num == 0){
        $("#updateDate1").val = "";
        $("#updateDate2").val = "";
    }
}

function getUserId(num, type) {
    $("#user_" + userId).css('background','');
    $("#user_" + userId).css('color','');
    $("#user_" + num).css('background','#009688');
    $("#user_" + num).css('color','#FFFFFF');
    userId = num;
    if(type != 1){
        $("#enterFind").trigger("click");
    }
}

$("#resetFind").click(function () {
    $("#updateDate").val("")
    $("#selectAll").val("");
    getTitle(0,1);
    getProvinces(0,1);
    getRegister(0,1);
    getSource(0,1);
    getIdea(0,1);
    getDate(0);
    getUserId(0,1);
    getStyle(0);
});