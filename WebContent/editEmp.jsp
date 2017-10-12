<%@ page pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Detail Admin - New User Form</title>

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
    <link rel="stylesheet" href="css/compiled/new-user.css" type="text/css" media="screen" />

    <!-- open sans font -->
    <link href='http://fonts.useso.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css' />

    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" /></head>
<body>

<!-- navbar -->

<!-- end navbar -->

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

    <!-- settings changer -->
    <div class="skins-nav">
        <a href="#" class="skin first_nav selected">
            <span class="icon"></span><span class="text">Default</span>
        </a>
        <a href="#" class="skin second_nav" data-file="css/skins/dark.css">
            <span class="icon"></span><span class="text">Dark skin</span>
        </a>
    </div>

    <div class="container-fluid">
        <div id="pad-wrapper" class="new-user">
            <div class="row-fluid header">
                <h3>更新员工信息</h3>
            </div>

            <div class="row-fluid form-wrapper">
                <!-- left column -->
                <div class="span9 with-sidebar">
                    <div class="container">
                        <form class="new_user_form inline-input" action="editEmp" method="post" enctype="multipart/form-data" />
                        <input type="hidden" name="fun" value="update">
                        <div class="span12 field-box">
                            <label>员工编号</label>
                            <input type="text" name="no" value="${emp.no}" required  readonly>
                        </div>
                        <div class="span12 field-box">
                            <label>员工姓名</label>
                            <input type="text" name="name" required value="${emp.name}">
                        </div>
                        <div class="field-box">
                            <label>性别:</label>
                            <div class="span8">
                                <label class="radio">
                                    <input type="radio" name="sex" value="1" checked>男

                                </label>
                                <label class="radio">
                                    <input type="radio" name="sex" value="0">女

                                </label>
                            </div>
                        </div>
                        <div class="span12 field-box">
                            <label>职位</label>
                            <input type="text" name="job" required value="${emp.job}" >
                        </div>
                        <div class="span12 field-box">
                            <label>月薪</label>
                            <input type="text" name="salary" required value="${emp.salary}">
                        </div>
                        <div class="field-box">
                            <label>入职日期</label>
                            <input type="date" name="hiredate" required class="input-large datepicker">
                        </div>
                        <div class="span12 field-box">
                            <label>员工照片</label>
                            <input id="photo" type="file" name="photo" value="${emp.photo}">
                            <img id="photoPreview" src="" alt="">
                        </div>
                        <div class="span12 field-box">
                            <label>电话号码</label>

                            <input type="tel" name="tel"  value="${emp.tel}">

                        </div>
                        <div class="span12 field-box textarea" >
                            <label>部门</label>
                            <input type="text" name="dno" value="${param.dno}" required value="${emp.name}">
                        </div>
                        <div class="span11 field-box actions" >
                            <input type="submit" value="提交修改" >

                        </div>
                        </form>
                    </div>
                </div>

                <!-- side right column -->

            </div>
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
        $('#photo').on('change', function () {
            if (window.FileReader) {
                var file = this.files[0];
                if (/image\/\w+/.test(file.type)) {
                    var fr = new FileReader();
                    fr.onloadend = function (evt) {
                        $('#photoPreview').attr('src', evt.target.result);
                    };
                    fr.readAsDataURL(file);
                } else {
                    $(this).val('');
                    $('#photoPreview').attr('src', '');
                    alert("请选择图片文件");
                }
            } else {
                alert("浏览器不支持文件预览!");
            }
        });
    });
</script>

<script type="text/javascript">
    $(function () {

        // toggle form between inline and normal inputs
        var $buttons = $(".toggle-inputs button");
        var $form = $("form.new_user_form");

        $buttons.click(function () {
            var mode = $(this).data("input");
            $buttons.removeClass("active");
            $(this).addClass("active");

            if (mode === "inline") {
                $form.addClass("inline-input");
            } else {
                $form.removeClass("inline-input");
            }
        });
    });
</script>

</body>
</html>