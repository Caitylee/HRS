<%@ page pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>

    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>

    <!-- bootstrap -->
    <link href="css/bootstrap/bootstrap.css" rel="stylesheet"/>
    <link href="css/bootstrap/bootstrap-responsive.css" rel="stylesheet"/>
    <link href="css/bootstrap/bootstrap-overrides.css" type="text/css" rel="stylesheet"/>

    <!-- libraries -->
    <link href="css/lib/jquery-ui-1.10.2.custom.css" rel="stylesheet" type="text/css"/>
    <link href="css/lib/font-awesome.css" type="text/css" rel="stylesheet"/>

    <!-- global styles -->
    <link rel="stylesheet" type="text/css" href="css/layout.css"/>
    <link rel="stylesheet" type="text/css" href="css/elements.css"/>
    <link rel="stylesheet" type="text/css" href="css/icons.css"/>

    <!-- this page specific styles -->
    <link rel="stylesheet" href="css/compiled/index.css" type="text/css" media="screen"/>

    <!-- open sans font -->
    <link href='http://fonts.useso.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800'
          rel='stylesheet' type='text/css'/>

    <!-- lato font -->
    <link href='http://fonts.useso.com/css?family=Lato:300,400,700,900,300italic,400italic,700italic,900italic'
          rel='stylesheet' type='text/css'/>

    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
</head>
<body>
<!-- sidebar -->
<div id="sidebar-nav">
    <ul id="dashboard-menu">
        <li>
            <a href="dept">
                <i class="icon-home"></i>
                <span>部门</span>
            </a>
        </li>

        <li class="active">
            <div class="pointer">
                <div class="arrow"></div>
                <div class="arrow_border"></div>
            </div>
            <a class="dropdown-toggle" href="#">
                <i class="icon-group"></i>
                <span>导航</span>
                <i class="icon-chevron-down"></i>
            </a>
            <ul class="active submenu">
                <li><a href="add_emp.jsp">添加员工</a></li>
                <li><a href="add_dept.jsp" class="active">添加部门</a></li>

            </ul>
        </li>
    </ul>
</div>
<!-- end sidebar -->

<!-- main container -->
<div class="content">
    <div class="container-fluid">
        <div id="pad-wrapper" class="users-list">
            <div class="row-fluid header">
                <h3 align="center">${dept.name}员工信息部门</h3>
                <div class="span10 pull-right">
                    <a href="add_emp.jsp" class="btn-flat success pull-right">
                        <span>&#43;</span>
                        新增员工
                    </a>
                </div>
            </div>

            <!-- Users table -->
            <div class="row-fluid table">
                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th class="span4 sortable">
                            编号
                        </th>
                        <th class="span3 sortable">
                            <span class="line"></span>姓名
                        </th>
                        <th class="span2 sortable">
                            <span class="line"></span>性别
                        </th>
                        <th class="span3 sortable align-right">
                            <span class="line"></span>职位
                        </th>
                        <th class="span3 sortable align-right">
                            <span class="line"></span>状态
                        </th>
                        <th class="span3 sortable align-right">
                            <span class="line"></span>电话
                        </th>
                        <th class="span3 sortable align-right">
                            <span class="line"></span>部门
                        </th>
                        <th class="span3 sortable align-right">
                            <span class="line"></span>操作
                        </th>
                    </tr>
                    </thead>
                    <tbody id="empInfo" >

                    </tbody>

                </table>
                <div align="center">
                    <a id="first">首页</a>&nbsp;&nbsp;
                    <a id="prev">上一页</a>&nbsp;&nbsp;
                    <a id="next">下一页</a>&nbsp;&nbsp;
                    <a id="last">末页</a>
                </div>
            </div>
<%--            <div class="pagination pull-right">
                <ul>
                    <li><a href="#">&#8249;</a></li>
                    <li><a class="active" href="#">1</a></li>
                    <li><a href="#">2</a></li>
                    <li><a href="#">3</a></li>
                    <li><a href="#">4</a></li>
                    <li><a href="#">5</a></li>
                    <li><a href="#">&#8250;</a></li>
                </ul>
            </div>--%>
            <!-- end users table -->
        </div>
    </div>
</div>
<!-- end main container -->


<!-- scripts -->
<script src="js/jquery-latest.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/theme.js"></script>
<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<script>
    $(function () {
        loadDataModel(1);
    });

    function loadDataModel(page) {
        $.getJSON("emp", { 'page': page }, function(json) {
            var empList = json.dataModel;
            if (empList.size>0){
                var prevPage = json.currentPage - 1;
                var nextPage = json.currentPage + 1;
                var lastPage = json.totalPage;
                if (json.currentPage > 1) {
                    $("#first").attr("href", "javascript:loadDataModel(1)");
                    $("#prev").attr("href", "javascript:loadDataModel(" + prevPage + ")");
                } else {
                    $("#first").removeAttr("href");
                    $("#prev").removeAttr("href");
                }
                if (json.currentPage < json.totalPage) {
                    $("#next").attr("href", "javascript:loadDataModel(" + nextPage + ")")
                    $("#last").attr("href", "javascript:loadDataModel(" + lastPage + ")")
                } else {
                    $("#next").removeAttr("href");
                    $("#last").removeAttr("href");
                }
                $("#empInfo tr:gt(0)").remove();
                for (var i = 0; i < empList.length; ++i) {
                    var emp = empList[i];
                    var tr = $("<tr>").attr("id", "tr"+emp.no)
                        .append($("<td>").text(emp.no))
                        .append($("<td>").append($("<a>")
                            .text(emp.name).attr("href", "empinfo?no=" + emp.no)))
                        .append($("<td>").text(emp.sex))
                        .append($("<td>").text(emp.job))
                        .append($("<td>").text(emp.status))
                        .append($("<td>").text(emp.tel))
                        .append($("<td>").text(emp.deptName))
                        .append($("<td>")
                            .append($("<a>").text("编辑").attr("href", "editEmp?fun=edit&no=" + emp.no))
                            .append("&nbsp;&nbsp;")
                            .append($("<a>").text("删除").attr("href", "javascript:deleteEmp("+emp.no+")" ))
                        );

                    $("#empInfo").append(tr);
                }
            }else{
                var span=$("<span>").text("没有相关数据")
            }

        });
    }



    function deleteEmp(no) {
        if (confirm("确定要删除吗?")) {
            $.ajax({
                url: 'delEmp?no=' + no,
                success: function (data) {
                    if (data.indexOf('success') >= 0) {
                        $('#tr' + no).remove();
                    }
                }
            });
        }
    }
</script>
</body>
</html>