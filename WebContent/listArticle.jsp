<%@page import="tzc.bean.User"%>
<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%  
String base=request.getContextPath()+"/";
//String path = request.getContextPath();  
//String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
//request.setAttribute("path", basePath);  
%>
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>文章一览</title>

    <link href="<%=base %>css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=base %>font-awesome/css/font-awesome.css" rel="stylesheet">

    <!-- Toastr style -->
    <link href="<%=base %>css/plugins/toastr/toastr.min.css" rel="stylesheet">

    <link href="<%=base %>css/animate.css" rel="stylesheet">
    <link href="<%=base %>css/style.css" rel="stylesheet">



</head>

<body>
<%	User user=(User)request.getSession().getAttribute("user");%>
    <div id="wrapper">

    <nav class="navbar-default navbar-static-side" role="navigation">
        <div class="sidebar-collapse">
            <ul class="nav metismenu" id="side-menu">
                <li class="nav-header">
                    <div class="dropdown profile-element"> <span>
                            <img alt="image" class="img-circle" src="<%=base %>img/profile_small.jpg" />
                             </span>
                        <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                            <span class="clear"> <span class="block m-t-xs"> <strong class="font-bold"><%//=user.getUsername()%></strong>
                             </span> <span class="text-muted text-xs block">Art Director <b class="caret"></b></span> </span> </a>
                        <ul class="dropdown-menu animated fadeInRight m-t-xs">
                            <li><a href="profile.html">Profile</a></li>
                            <li><a href="contacts.html">Contacts</a></li>
                            <li><a href="mailbox.html">Mailbox</a></li>
                            <li class="divider"></li>
                            <li><a href="login.html">Logout</a></li>
                        </ul>
                    </div>
                    <div class="logo-element">
                        IN+
                    </div>
                </li>               
                 <li>
                        <a href="<%=base %>admin/Fore"><i class="fa fa-diamond"></i> <span class="nav-label">首页</span></a>
                    </li>

                    <li>
                        <a href="<%=base %>admin/Category"><i class="fa fa-pie-chart"></i> <span class="nav-label">分类管理</span>  </a>
                    </li>

                    <li>
                        <a href="#"><i class="fa fa-desktop"></i> <span class="nav-label"></span>文章<span class="pull-right label label-primary">SPECIAL</span></a>
                        <ul class="nav nav-second-level collapse">
                            <li><a href="<%=base %>admin/Article">文章一览</a></li>
                            <li><a href="faq.html">FAQ</a></li>
                        </ul>
                    </li>
               
            </ul>

        </div>
    </nav>

        <div id="page-wrapper" class="gray-bg">
        <div class="row border-bottom">
        
        </div>
            <div class="row wrapper border-bottom white-bg page-heading">
                <div class="col-lg-10">
                    <h2>Blog</h2>
                    <ol class="breadcrumb">
                        <li>
                            <a href="index.html">Home</a>
                        </li>
                        <li>
                            <a>Miscellaneous</a>
                        </li>
                        <li class="active">
                            <strong>Blog</strong>
                        </li>
                    </ol>
                </div>
                <div class="col-lg-2">

                </div>
            </div>

        <div class="wrapper wrapper-content  animated fadeInRight blog">
            <div class="row">
                <div class="col-lg-4">  
                 <c:forEach items="${articles}" var="article">            
                    <div class="ibox">
                        <div class="ibox-content">
                            <a href="article.html" class="btn-link">
                                <h2>
                                    ${article.title}
                                </h2>
                            </a>
                            <div class="small m-b-xs">
                                <strong>${article.cid}</strong> <span class="text-muted"><i class="fa fa-clock-o"></i>${article.createDate}
                            </div>
                            <p>
                               ${article.content}
                            </p>                          
                            <div class="row">
                                <div class="col-md-6">
                                    <h5>Tags:</h5>
                                    <a href="<%=base %>admin/ArticleEdit?id=${article.id}"><button class="btn btn-white btn-xs" type="button">编辑</button></a>
                                    <a href="<%=base %>admin/ArticleDelete?id=${article.id}"><button class="btn btn-white btn-xs" type="button">删除</button></a>
                                </div>
                                <div class="col-md-6">
                                    <div class="small text-right">
                                        <h5>Stats:</h5>
                                        <div> <i class="fa fa-comments-o"> </i> 47 comments </div>
                                        <i class="fa fa-eye"> </i> 138 views
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
			</c:forEach>
                    </div>
                </div>
            </div>


        </div>


        </div>
        </div>



    <!-- Mainly scripts -->
    <script src="<%=base %>js/jquery-3.1.1.min.js"></script>
    <script src="<%=base %>js/bootstrap.min.js"></script>
    <script src="<%=base %>js/plugins/metisMenu/jquery.metisMenu.js"></script>
    <script src="<%=base %>js/plugins/slimscroll/jquery.slimscroll.min.js"></script>

    <!-- Custom and plugin javascript -->
    <script src="<%=base %>js/inspinia.js"></script>
    <script src="<%=base %>js/plugins/pace/pace.min.js"></script>

</body>

</html>
