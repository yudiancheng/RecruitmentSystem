<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="css/base.css" />
    <link rel="stylesheet" href="css/info-reg.css" />
    <title>网上招聘系统</title>
</head>

<body>
<div class="title"><h2>公司基本信息</h2></div>
<div class="main">
    <p class="short-input ue-clear newstyle">
        <label>公司名称：</label><input name="name" type="text" readonly="readonly" style="border:0;background:transparent;"  value="${c_detailed.realName}"/>
    </p>
    <p class="short-input ue-clear newstyle">
        <label>公司地址：</label><input name="name" type="text" readonly="readonly" style="border:0;background:transparent;"  value="${c_detailed.location}"/>
    </p>
    <p class="long-input ue-clear newstyle">
        <label>联系方式：</label><input name="phone" type="text" readonly="readonly" style="border:0;background:transparent;" value="${c_detailed.phone}">
    </p>
    <p class="short-input ue-clear newstyle">
        <label>电子邮箱：</label><input name="email" type="text" readonly="readonly" style="border:0;background:transparent;" value="${c_detailed.email}"/>
    </p>
    <p class="short-input ue-clear newstyle">
        <label>公司简介：</label><textarea name="tip" readonly="readonly" style="height:150px;border:0;background:transparent;">${c_detailed.tip}</textarea>
    </p>

    <p class="short-input ue-clear newstyle">
        <label>公司在招职位：</label>
        <br/>
        <c:forEach items="${c_detailed.needs}" var="needs">
            <input name="trade" type="text" readonly="readonly" style="border:0;background:transparent;" value="${needs.needs}"/>
            <label>薪资：</label>
            <input name="trade" type="text" readonly="readonly" style="border:0;background:transparent;" value="${needs.salary}"/>
            <br/>
        </c:forEach>
    </p>
</div>

</body>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript" src="js/WdatePicker.js"></script>
<script type="text/javascript">
    showRemind('input[type=text], textarea','placeholder');
</script>
</html>
