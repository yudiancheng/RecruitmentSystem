<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="css/base.css"/>
    <link rel="stylesheet" href="css/info-mgt.css"/>
    <link rel="stylesheet" href="css/WdatePicker.css"/>
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
<div class="title"><h2>应聘者名单</h2></div>
<div class="table-box">
    <table>
        <thead>
        <tr>
            <th class="num">序号</th>
            <th class="name">姓名</th>
            <th class="node">专业</th>
            <th class="node">毕业学校</th>
            <th class="node">薪资要求</th>
            <th class="node">联系方式</th>
            <th class="node">应聘岗位</th>
            <th class="node">操作</th>
            <th class="node">当前状态</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${c_employs}" var="employs">
            <c:forEach items="${employs.peoples}" var="people" varStatus="status">
                <tr>
                    <td class="num">${status.count}</td>
                    <td class="name">${people.realName}</td>
                    <td class="node">${people.major}</td>
                    <td class="node">&nbsp;${people.school}</td>
                    <td class="node">${people.salary}</td>
                    <td class="node">${people.phone}</td>
                    <td class="node" id="position">${employs.position}</td>
                    <td class="node">
                        <a style="color:blue" href="showDetail?id=${people.id}">详细信息</a>&nbsp;&nbsp;&nbsp;
                        <a style="color:red" onclick="confirmSubmit(${people.id},1)">同意</a>&nbsp;&nbsp;&nbsp;
                        <a style="color:red" onclick="confirmSubmit(${people.id},0)">拒绝</a>
                    </td>
                    <td style="text-align: center">
                        <c:choose>
                            <c:when test="${employs.status == 0}">
                                未处理
                            </c:when>
                            <c:when test="${employs.status == 1}">
                                已同意
                            </c:when>
                            <c:otherwise>
                                已回绝
                            </c:otherwise>
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
    $('.pagination').pagination(100, {
        callback: function (page) {
        },
        display_msg: true,
        setPageNo: true
    });

    $("tbody").find("tr:odd").css("backgroundColor", "#eff6fa");

    showRemind('input[type=text], textarea', 'placeholder');

    function confirmSubmit(pid, isAgree) {
        var $position = $("#position").text();
        alert(pid);
        var res = confirm("真的要修改当前求职者的求职状态吗？");
        if (res) {
            $.ajax({
                url: "agreeOrDis",
                type: "get",
                dataType: "text",
                data: {pid: pid, isAgree: isAgree, position: $position},
                success: function (data) {
                    if (data == "成功") {
                        alert("修改成功");
                    } else {
                        alert("修改失败");
                    }
                }
            });
        }
    }
</script>
</html>
