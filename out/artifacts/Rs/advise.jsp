<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="css/base.css" />
    <link rel="stylesheet" href="css/info-mgt.css" />
    <link rel="stylesheet" href="css/WdatePicker.css" />
    <title>网上招聘系统</title>
    <script type="text/javascript" src="js/jquery.js"></script>
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
<div class="title"><h2>我的通知</h2></div>
<br/>
<br/>
<div class="table-box">
    <table>
        <thead>
        <tr>
            <th class="num">序号</th>
            <th class="name">公司名称</th>
            <th class="node">职位名称</th>
            <th class="node">联系方式</th>
            <th class="node">状态</th>
        </tr>
        </thead>
        <tbody>
            <c:forEach items="${employs}"  var="employs">
                <c:forEach items="${employs.companies}" var="company" varStatus="status">
            <td class="num">${status.count}</td>
            <td class="name">${company.realName}</td>
            <td class="node">${employs.position}</td>
            <td class="node">${company.phone}</td>
            <td class="node">
                <c:choose>
                    <c:when test="${employs.status == 0}">未回应</c:when>
                    <c:when test="${employs.status == 1}">已通过</c:when>
                    <c:otherwise>已回绝</c:otherwise>
                </c:choose>
            </td>
        </tr>
        </c:forEach>
            </c:forEach>
        </tbody>
    </table>
</div>
</body>

<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript" src="js/WdatePicker.js"></script>
<script type="text/javascript" src="js/jquery.pagination.js"></script>
<script type="text/javascript">
    $('.pagination').pagination(100,{
        callback: function(page){
        },
        display_msg: true,
        setPageNo: true
    });

    $("tbody").find("tr:odd").css("backgroundColor","#eff6fa");

    showRemind('input[type=text], textarea','placeholder');
</script>
</html>
