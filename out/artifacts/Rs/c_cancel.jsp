
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>撤销招聘信息</title>
    <link rel="stylesheet" href="css/base.css" />
    <link rel="stylesheet" href="css/info-mgt.css"/>
    <style type="text/css">
        a:link {
            font-size: 12px;
            color: #000000;
            text-decoration: none;
        }
        a:visited {
            font-size: 12px;
            color: #000000;
            text-decoration: none;
        }
        a:hover {
            font-size: 12px;
            color: #999999;
            text-decoration: none;
        }
    </style>
</head>
<body>
<div class="title"><h2>撤销招聘信息</h2></div>
<br/>
<div class="table-box">
    <table style="width:50%;font-size:small;font-weight: normal">
        <thead>
        <tr>
            <th class="num" style="font-weight:bolder">序号</th>
            <th class="node" style="font-weight:bolder">职位需求</th>
            <th class="node" style="font-weight:bolder">薪资</th>
            <th class="node" style="font-weight:bolder">操作</th>
        </tr>
        </thead>
        <tbody>
            <c:forEach items="${self_needs}" var="needs" varStatus="status">
            <tr>
                <td class="num">${status.count}</td>
                <td class="node" id="needs">${needs.needs}</td>
                <td class="node" id="salary">${needs.salary}</td>
                <td ><a style="color:blue" onclick="confirmDel()">撤销</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript">
    $("tbody").find("tr:odd").css("backgroundColor","#eff6fa");
    function confirmDel() {
        var res = confirm("您确定要撤销该记录吗？");
        if(res) {
            submitData();
        }
    }

    function submitData() {
        var $needs = $("#needs").text();
        $.ajax({
            url:"delNeeds",
            type:"get",
            dataType:"text",
            data:{needs:$needs},
            success:function(data){
                //window.location.reload(true);
                if(data == '成功') {
                    alert("撤销成功！");
                } else {
                    alert("撤销失败！");
                }
            }
        });
    }
</script>
</body>
</html>
