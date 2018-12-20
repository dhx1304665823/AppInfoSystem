<%--
  Created by IntelliJ IDEA.
  User: 你爷
  Date: 2018/12/17
  Time: 14:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>开发者登录窗口</title>
    <link href="../statics/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="../statics/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="../statics/css/nprogress.css" rel="stylesheet">
    <!-- Animate.css -->
    <link href="../statics/css/animate.min.css" rel="stylesheet">

    <!-- Custom Theme Style -->
    <link href="../statics/css/custom.min.css" rel="stylesheet">
</head>

<body class="login">
<div>
    <a class="hiddenanchor" id="signup"></a>
    <a class="hiddenanchor" id="signin"></a>

    <div class="login_wrapper">
        <div class="animate form login_form">
            <section class="login_content">
                <form action="logins">
                    <h1>开发者登录</h1>
                    <div>
                        <input type="text" class="form-control" placeholder="Username" required="" name="devCode"/>
                    </div>
                    <div>
                        <input type="password" class="form-control" placeholder="Password" required="" name="devPassoword"/>
                    </div>
                    <span style="color: red">${ex}</span>
                    <div>

                        <input class="btn btn-default submit" type="submit" value="登录">
                        <input class="btn btn-default submit" type="reset" value="清空">
                        <a class="reset_pass" href="#">忘记密码?</a>
                    </div>

                    <div class="clearfix"></div>

                    <div class="separator">

                        <div class="clearfix"></div>
                        <%-- <p class="change_link">New to site?
                            <a href="#signup" class="to_register"> Create Account </a>
                        </p>
--%>
                        <br />

                        <div>
                            <h1><i class="fa fa-paw"></i> AppInfo</h1>
                            <p>©2016 All Rights Reserved. Gentelella Alela! is a Bootstrap 3 template. Privacy and Terms</p>
                        </div>
                    </div>
                </form>
            </section>
        </div>


    </div>
</div>
</body>
</html>
