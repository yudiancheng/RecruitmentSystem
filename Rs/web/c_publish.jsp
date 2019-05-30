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
<div class="title"><h2>发布招聘信息</h2></div>
<div class="main">
    <form id="frm">
        <div class="query-conditions ue-clear">
            <label>岗位需求：</label>
            <select name="needs" style='width:200px;height:30px;border:1px solid #C5D6E0'>
                <c:forEach items="${selectList.tradeList}" var="tradeList">
                    <option value="${tradeList}">${tradeList}</option>
                </c:forEach>
            </select>

            <label>薪资：</label>
            <select name="salary" style='width:200px;height:30px;border:1px solid #C5D6E0'>
                <c:forEach items="${selectList.salaryList}" var="salaryList">
                    <option value="${salaryList}">${salaryList}</option>
                </c:forEach>
            </select>
        </div>
        <br/><br/>
        <div class="btn" style="display: inline; border: none">
            <input style="height:50px;width:150px;background-color:#68B86C;color:white;border-radius:5px" type="button" value="发布" onclick="publish()"/>
        </div>
    </form>
</div>

</body>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript" src="js/WdatePicker.js"></script>
<script type="text/javascript">
    showRemind('input[type=text], textarea','placeholder');

    function publish() {
        var $res = confirm("确定要发布简历吗？");
        if($res) {
            submitData();
        }
    }

    function submitData() {
        $.ajax({
            url:"insNeeds",
            type:"get",
            dataType:"text",
            data:$("#frm").serialize(),
            success:function(data){
                console.info(data);
                if(data=='成功') {
                    alert("发布成功！");
                }
            },
            error:function() {
                alert("发布失败");
            }
        });
    }
</script>
</html>
