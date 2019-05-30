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

<div class="title"><h2>职位搜索</h2></div>
<div class="query">
<form id="frm">
	<div class="query-conditions ue-clear">
        <div class="conditions name ue-clear">
            <label>职位类别：</label>
            <select name="trade" style="width:200px;height:28px;border:1px solid #C5D6E0">
                <option value="">不限</option>
                <c:forEach items="${selectList.tradeList}" var="trade">
                    <option value="${trade}" <c:if test="${trade == position}">selected="selected"</c:if>>${trade}</option>
                </c:forEach>
                    <!--	<option value="软件工程师">软件工程师</option>
            	<option value="会计">会计</option>
            	<option value="文员">文员</option>
            	<option value="客户经理">客户经理</option>
            	<option value="网站策划">网站策划</option>
            	<option value="平面设计师">平面设计师</option>
				<option value="java后端">java后端</option>
				<option value="web前端">web前端</option>
				<option value="UI设计">UI设计</option> -->

            </select>
        </div>

        <!--<input name="type" type="hidden" value="个人">-->
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
                <th class="name">公司名称</th>
                <th class="process">公司地点</th>
                <th class="node">职位需求</th>
                <th class="node">薪资</th>
                <th class="node">联系方式</th>
            </tr>
        </thead>
	<c:if test="${not empty pageInfo.data}">
        <tbody>
			<c:forEach items="${pageInfo.data}" var ="company"  begin="0">
				<tr>
            		<td class="num" id="cid">${company.id}</td>
                	<td class="name">${company.realName}</td>
                	<td class="node">${company.location}</td>
                    <td class="node">
                <c:forEach items="${company.needs}" var="needs">
                        ${needs.needs}<br/>
                       <!-- <td class="node"></td>-->
                </c:forEach>
                    </td>
                    <td class="node">
                        <c:forEach items="${company.needs}" var="needs">
                           ${needs.salary}<br/>
                            <!-- <td class="node"></td>-->
                        </c:forEach>
                    </td>
					<td class="node">${company.phone}</td>
                	<td class="node" onmouseleave="elementHidden(this)">
        				<a style="color:blue" href="showComInfo?id=${company.id }">详细信息</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                		<a style="color:red" onmouseover="apply(this)">我要申请</a>
                        <select style="visibility: hidden;width: 70%">
                            <option value="">请选择要申请的岗位</option>
                            <c:forEach items="${company.needs}" var="needs">
                                <option value="${needs.needs}">${needs.needs}</option>
                            </c:forEach>
                        </select><a style="color:blue;visibility: hidden" onclick="confirmSubmit(this)">确定</a>
                	</td>
            	</tr>
      		</c:forEach>  
        </tbody>
	</c:if>
    </table>
</div>

<div class="pagination ue-clear" style="margin: auto;text-align: center" ><a <c:if test="${pageInfo.pageNumber>1}">onclick="lastPage()"</c:if>>上一页</a> <a <c:if test="${pageInfo.pageNumber<pageInfo.count}">onclick="nextPage()"</c:if>>下一页</a> 当前在第<c:out value="${pageInfo.pageNumber}">0</c:out>页  共<c:out value="${pageInfo.count}">0</c:out>页   共<c:out value="${pageInfo.total}">0</c:out>条数据</div>
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
});
</script>-->
<script type="text/javascript">
$("tbody").find("tr:odd").css("backgroundColor","#eff6fa");

showRemind('input[type=text], textarea','placeholder');

function submitData() {
	$.ajax({
		url:"showComByParam",
		type:"get",
		dataType:"json",
		data:$("#frm").serialize(),
		success:function(){
			window.location.reload(true);
		}
	});
}

function  apply(bq) {
    var parent = bq.parentElement;
    var select =  parent.getElementsByTagName("select")[0];
    var btn = parent.lastElementChild;
    btn.style.visibility="visible";
    select.style.visibility="visible";
}

function confirmSubmit(bq) {
    var parent = bq.parentElement;
    var select = parent.getElementsByTagName("select")[0];
    if(select.value =="") {
        alert("请选择一个有效岗位！");
        return;
    }
   var con = confirm("确定要申请此岗位吗？");
   if(con) {
       var position = select.value;
       var $cid = $("#cid").text();
       $.ajax({
           url:"applyPosition",
           type:"get",
           dataType:"text",
           data:{cid:$cid,position:position},
           success:function(data){
               if(data == "成功") {
                   alert("申请成功！");
               } else {
                   alert("申请失败！");
               }
           }
       });

   }
}

function  elementHidden(bq) {
    var select = bq.getElementsByTagName("select")[0];
    var btn = bq.lastElementChild;
    select.style.visibility="hidden";
    btn.style.visibility="hidden";
}
function lastPage() {
	var $trade = $("select[name=trade]").val();
	location.href="printPage?pageSize=${pageInfo.pageSize}&pageNumber=${pageInfo.pageNumber-1}&trade="+$trade;
}

function nextPage() {
	var $trade = $("select[name=trade]").val();
	location.href="printPage?pageSize=${pageInfo.pageSize}&pageNumber=${pageInfo.pageNumber+1}&trade="+$trade;
}
</script>
</html>
