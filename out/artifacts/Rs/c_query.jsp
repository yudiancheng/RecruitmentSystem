<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="css/base.css" />
    <link rel="stylesheet" href="css/info-mgt.css" />
    <link rel="stylesheet" href="css/WdatePicker.css" />
    <title>网上招聘系统</title>
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

<div class="title"><h2>人才库信息</h2></div>
<div class="query">
    <form id="frm">
        <div class="query-conditions ue-clear">
            <div class="conditions name ue-clear">
                <label>专业：</label>
                <select name="major" style="width:200px;height:28px;border:1px solid #C5D6E0">
                    <option value="">不限</option>
                    <c:forEach items="${selectList.majorList}" var="majorList">
                        <option value="${majorList}" <c:if test="${majorList == major}">selected="selected"</c:if>>${majorList}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="conditions operate-time ue-clear">
                <label>薪资范围：</label>
                <div class="select-wrap">
                    <select name="salary" style="width:200px;height:28px;border:1px solid #C5D6E0">
                        <option value="">不限</option>
                        <c:forEach items="${selectList.salaryList}" var="salaryList">
                            <option value="${salaryList}" <c:if test="${salaryList == c_salary}">selected="selected"</c:if>>${salaryList}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="conditions name ue-clear">
                <label>学校：</label>
                <input style="width:195px;height:25px;border:1px solid #C5D6E0" name="school" type="text" value="${school}">
            </div>
        </div>
        <div class="query-btn ue-clear">
            <input style="background-color:#68B86C;color:white;border-radius:10px" type="button" value="查询" onclick="submitData()"/>
            <input style="background-color:#EFF6FA;color:black;border-radius:10px" type="reset" value="清空"/>
        </div>
    </form>
</div>
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
            <th class="node">操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${c_pageInfo.data}" var ="person"  begin="0">
            <tr>
                <td class="num">${person.id}</td>
                <td class="name">${person.realName}</td>
                <td class="node">${person.major}</td>
                <td class="node">${person.school}</td>
                <td class="node">${person.salary}</td>
                <td class="node">${person.phone}</td>
                <td class="node"><a style="color:blue" href="showDetail?id=${person.id}">详细信息</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<div class="pagination ue-clear" style="margin: auto;text-align: center" ><a <c:if test="${c_pageInfo.pageNumber>1}">onclick="lastPage()"</c:if>>上一页</a> <a <c:if test="${c_pageInfo.pageNumber<c_pageInfo.count}">onclick="nextPage()"</c:if>>下一页</a> 当前在第<c:out value="${c_pageInfo.pageNumber}">0</c:out>页  共<c:out value="${c_pageInfo.count}">0</c:out>页   共<c:out value="${c_pageInfo.total}">0</c:out>条数据</div>
</body>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript" src="js/WdatePicker.js"></script>
<!--  <script type="text/javascript" src="js/jquery.pagination.js"></script>-->
<!--<script type="text/javascript">
 $('.pagination').pagination(100,{
	callback: function(page){
	},
	display_msg: true,
	setPageNo: true
});-->
<script type="text/javascript">
    $("tbody").find("tr:odd").css("backgroundColor","#eff6fa");
    showRemind('input[type=text], textarea','placeholder');
    
    function showDetail() {
        
    }

    function lastPage() {
        var $major = $("select[name=major]").val();
        var $salary = $("select[name=salary]").val();
        var $school = $("input[name=school]").val();
        window.location.href="showAllPeopleByPage?major="+$major+"&salary="+$salary+"&school="+$school+"&pageNumber=${c_pageInfo.pageNumber-1}&pageSize=${c_pageInfo.pageSize}";
    }

    function nextPage() {
        var $major = $("select[name=major]").val();
        var $salary = $("select[name=salary]").val();
        var $school = $("input[name=school]").val();
        window.location.href="showAllPeopleByPage?major="+$major+"&salary="+$salary+"&school="+$school+"&pageNumber=${c_pageInfo.pageNumber+1}&pageSize=${c_pageInfo.pageSize}";
    }

    function submitData() {
        $.ajax({
            url:"showAllPeople",
            type:"get",
            dataType:"json",
            data:$("#frm").serialize(),
            success:function(){
                window.location.reload(true);
            }
        });
    }
</script>
</html>
