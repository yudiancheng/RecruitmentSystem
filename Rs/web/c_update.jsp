<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="css/base.css" />
    <link rel="stylesheet" href="css/info-reg.css" />
    <title>网上招聘系统</title>
    <style type="text/css">
        .error{
            color:Red;
            font-size:13px;
            margin-left:5px;
            padding-left:16px;
        }
    </style>
</head>
<body>
<div class="title">
    <h2>企业信息修改(*为必填项)</h2>
</div>
<form id="frm">
    <div class="main">
        <p class="short-input ue-clear">
            <label>用户名：</label>
            <input name="username" type="text" value="${company.username }"/>
        </p>
        <p class="short-input ue-clear">
            <label>密码：</label>
            <input name="password" type="text" value="${company.password }"/>
        </p>
        <p class="short-input ue-clear">
            <label>*公司名称：</label>
            <input name="realName" type="text" value="${company.realName }"/>
        </p>
        <p class="short-input ue-clear">
            <label>*公司地址：</label>
            <input name="location" type="text" value="${company.location }"/>
        </p>
        <p class="long-input ue-clear">
            <label>*联系方式：</label>
            <input name="phone" type="text" value="${company.phone }"/>
        </p>
        <p class="long-input ue-clear">
            <label>电子邮箱：</label>
            <input name="email" type="text" value="${company.email }"/>
        </p>
        <p class="short-input ue-clear">
            <label>公司简介：</label>
            <textarea name="tip" style="height:150px">${company.tip }</textarea>
        </p>
        </div>
        <div class="btn ue-clear">
            <input style="height:50px;width:150px;background-color:#68B86C;color:white;border-radius:10px" type="button" value="修改" onclick="confirmSubmit()"/>
        </div>
    </div>
</form>
</body>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript" src="js/WdatePicker.js"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>
<script type="text/javascript">
    showRemind('input[type=text], textarea','placeholder');

    $( "#fm" ).validate({
        rules: {
            name: {
                required:true
            },
            location: {
                required:true
            },
            phone: {
                required:true
            }
        },
        messages: {
            name: {
                required: "*不能为空！"
            },
            location: {
                required: "*不能为空！"
            },
            phone: {
                required: "*不能为空！"
            }
        }
    });
    function confirmSubmit() {
        var $res = confirm("确认要修改您的信息吗？");
        if($res) {
            submitData();
        }
    }
    function submitData() {
        $.ajax({
            url:"updateComInfo",
            type:"get",
            dataType:"text",
            data:$("#frm").serialize(),
            success:function(data){
                if(data == "成功") {
                    alert("修改成功！");
                } else {
                    alert("修改失败！");
                }
            },
            error:function(data) {
                alert(data);
            }
        });
    }
</script>

</html>
