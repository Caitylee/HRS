<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>员工详细信息</title>

    <meta name="viewport" content="width=device-width, initial-scale=1.0" />

    <!-- bootstrap -->
    <link href="css/bootstrap/bootstrap.css" rel="stylesheet" />
    <link href="css/bootstrap/bootstrap-responsive.css" rel="stylesheet" />
    <link href="css/bootstrap/bootstrap-overrides.css" type="text/css" rel="stylesheet" />

    <!-- global styles -->
    <link rel="stylesheet" type="text/css" href="css/layout.css" />
    <link rel="stylesheet" type="text/css" href="css/elements.css" />
    <link rel="stylesheet" type="text/css" href="css/icons.css" />

    <!-- libraries -->
    <link rel="stylesheet" type="text/css" href="css/lib/font-awesome.css" />

    <!-- this page specific styles -->
    <link rel="stylesheet" href="css/compiled/personal-info.css" type="text/css" media="screen" />

    <!-- open sans font -->
    <link href='http://fonts.useso.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css' />

    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" /></head>
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

<!-- main container .wide-content is used for this layout without sidebar :)  -->
<div class="content wide-content">
    <div class="container-fluid">
        <div class="settings-wrapper" id="pad-wrapper">
            <!-- avatar column -->
            <div class="span3 avatar-box">
                <div class="personal-image">
                    <img src="images/${emp.photo}" alt="" class="avatar img-circle" />
                </div>
            </div>

            <!-- edit form column -->
            <div class="span7 personal-info">
                <h5 class="personal-title">员工信息</h5>

                <form />
                <div class="field-box">
                    <label>编号</label>
                    <input class="span5 inline-input" type="text" value="${emp.no}" readonly />
                </div>
                <div class="field-box">
                    <label>姓名</label>
                    <input class="span5 inline-input" type="text" value="${emp.name}" readonly/>
                </div>
                <div class="field-box">
                    <label>职位</label>
                    <input class="span5 inline-input" type="text" value="${emp.job}" readonly/>
                </div>
                <div class="field-box">
                    <label>性别</label>
                    <input class="span5 inline-input" type="text" value="${emp.sex?"男":"女"}" readonly/>
                </div>


                <div class="field-box">
                    <label>工资</label>
                    <input class="span5 inline-input" type="text" value="${emp.salary}" readonly/>
                </div>
                <div class="field-box">
                    <label>入职日期</label>
                    <input class="span5 inline-input" type="text" value="${emp.hireDate}" readonly/>
                </div>
                <div class="field-box">
                    <label>状态</label>
                    <input class="span5 inline-input" type="text" value="${emp.status?"在职":"离职"}" readonly/>
                </div>
                <div class="field-box">
                    <label>电话号码</label>
                    <input class="span5 inline-input" type="text" value="${emp.tel}" readonly/>
                </div>
                <div class="field-box">
                    <label>部门</label>
                    <input class="span5 inline-input" type="text" value="" readonly/>
                </div>
                </form>
            </div>
        </div>
    </div>
</div>
<!-- end main container -->


<!-- scripts -->
<script src="js/jquery-latest.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/theme.js"></script>

</body>
</html>