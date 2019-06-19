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
<html lang="en">
<head>
<%//	User user=(User)request.getSession().getAttribute("user");%>
    <meta charset="utf-8">
    <title>主页</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width">

    <!-- Bootstrap styles -->
    <link rel="stylesheet" href="<%=base %>blog/css/bootstrap.min.css">
   
    <!-- Font-Awesome -->
    <link rel="stylesheet" href="<%=base %>blog/css/font-awesome/css/font-awesome.min.css">

    <!-- Google Webfonts -->
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,600|PT+Serif:400,400italic' rel='stylesheet' type='text/css'>

    <!-- Styles -->
    <link rel="stylesheet" href="<%=base %>blog/css/style.css" id="theme-styles">

    <!--[if lt IE 9]>      
        <script src="js/vendor/google/html5-3.6-respond-1.1.0.min.js"></script>
    <![endif]-->
    
</head>
<body>
    <header>
        <div class="widewrapper masthead">
            <div class="container">
                <a href="index.html" id="logo">
                    <img src="<%=base %>blog/img/logo.png" alt="clean Blog">
                </a>

                <div id="mobile-nav-toggle" class="pull-right">
                    <a href="#" data-toggle="collapse" data-target=".clean-nav .navbar-collapse">
                        <i class="fa fa-bars"></i>
                    </a>
                </div>

                <nav class="pull-right clean-nav">
                    <div class="collapse navbar-collapse">
                        <ul class="nav nav-pills navbar-nav">
                          
                            <li>
                                <a href="index.html">Home</a>
                            </li>
                            <li>
                                <a href="about.html">About</a>
                            </li>
                                <li>${user.username}</li> 
                                <c:if test="${user.username eq'admin'}">
								  
								<li><a href="<%=base %>index.jsp">后台管理</a></li>   
								</c:if>
                                
                                                 
                        </ul>
                    </div>
                </nav>        

            </div>
        </div>

        <div class="widewrapper subheader">
            <div class="container">
                <div class="clean-breadcrumb">
                    <a href="#">Blog</a>
                </div>

                <div class="clean-searchbox">
                    <form action="<%=base %>admin/ArticleFind" method="post" accept-charset="utf-8">
                        <input class="searchfield" id="searchbox" type="text" name="title" placeholder="Search">
                        <button class="searchbutton" type="submit" name="submit">
                            <i class="fa fa-search"></i>
                        </button>
                    </form>
                </div>
                <%String error=(String)request.getAttribute("error");
if (error!=null&&!"".equals(error))%>
<p style="color:red"><%=error==null?"":error %></p>
            </div>
        </div>
    </header>

    <div class="widewrapper main">
        <div class="container">
            <div class="row">
                <div class="col-md-8 blog-main">
                    <div class="row">
                    <c:forEach items="${blogs}" var="blog">
                        <div class="col-md-6 col-sm-6">
                            <article class=" blog-teaser">
                                <header>
                                    <img src="<%=base %>blog/img/1.jpg" alt="">
                                    <h3><a href="single.html">${blog.username}</a></h3>
                                    <span class="meta">${blog.createDate}</span>
                                    <hr>
                                </header>
                                <div class="body">
                                    ${blog.content}
                                </div>
                                <div class="clearfix">
                                    <a href="single.html" class="btn btn-clean-one">Read more</a>
                                </div>
                            </article>
                        </div>
                        </c:forEach>
                    </div>
                    
                    <div class="copyrights">Collect from <a href="http://www.cssmoban.com/" >手机网站模板</a></div>

                    <div class="row">
                        <div class="col-md-6 col-sm-6">
                            <article class="blog-teaser">
                                <header>
                                    <img src="<%=base %>blog/img/4.jpg" alt="">
                                   <h3><a href="single.html">Yellow - HTML5 Template</a></h3>
                                    <span class="meta">19 August 2015, John Doe</span>
                                    <hr>
                                </header>
                                <div class="body">
                                    Lorem ipsum dolor sit amet, consectetur adipisicing elit. Voluptatum, sit. Doloribus dolores neque eos. Velit eveniet, necessitatibus aut sit tenetur perferendis! Commodi pariatur dignissimos, quis sequi odit iusto cumque quod!
                                </div>
                                <div class="clearfix">
                                    <a href="single.html" class="btn btn-clean-one">Read more</a>
                                </div>
                            </article>
                        </div>
                    </div>

                    <div class="paging">
                        <a href="#" class="older">Older Post</i></a>
                    </div>
                </div>
                <aside class="col-md-4 blog-aside">
                    <c:forEach items="${categorys}" var="category">
                    <div class="aside-widget">
                        <header>
                            <h3>${category.name}</h3>
                        </header>
                        <div class="body">
                            <ul class="clean-list">
                            <c:forEach items="${category.articles}" var="article">
                                <li><a href="<%=base %>admin/ArticleGet?id=${article.id}">${article.title}</a></li>
                                </c:forEach>
                            </ul>
                        </div>
                    </div>
                </c:forEach>

                    <div class="aside-widget">
                        <header>
                            <h3>分类大全</h3>
                        </header>
                        <div class="body clearfix">
                            <ul class="tags">
                            <c:forEach items="${categorys}" var="category">
                                <li><a href="#">${category.name}</a></li>  
                                </c:forEach>                       
                            </ul>
                        </div>
                    </div>
                </aside>
            </div>
        </div>
    </div>

    <footer>
        <div class="widewrapper footer">
            <div class="container">
                <div class="row">
                    <div class="col-md-4 footer-widget">
                        <h3> <i class="fa fa-user"></i>About</h3>

                       <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ab animi laboriosam nostrum consequatur fugiat at, labore praesentium modi, quasi dolorum debitis reiciendis facilis, dolor saepe sint nemo, earum molestias quas.</p>
                       <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Dolorum, error aspernatur assumenda quae eveniet.</p>
                    </div>

                    <div class="col-md-4 footer-widget">
                        <h3> <i class="fa fa-pencil"></i> Recent Post</h3>
                        <ul class="clean-list">
                            <li><a href="">Clean - Responsive HTML5 Template</a></li>
                            <li><a href="">Responsive Pricing Table</a></li>
                            <li><a href="">Yellow HTML5 Template</a></li>
                            <li><a href="">Blackor Responsive Theme</a></li>
                            <li><a href="">Portfolio Bootstrap Template</a></li>
                            <li><a href="">Clean Slider Template</a></li>
                        </ul>
                    </div>

                    <div class="col-md-4 footer-widget">
                        <h3> <i class="fa fa-envelope"></i>Contact Me</h3>

                        <p>Lorem ipsum dolor sit amet Lorem ipsum dolor sit amet.</p>
                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Nihil fugiat, cupiditate veritatis excepturi tempore explicabo.</p>
                         <div class="footer-widget-icon">
                            <i class="fa fa-facebook"></i><i class="fa fa-twitter"></i><i class="fa fa-google"></i>
                        </div>
                    </div>
                   
                </div>
            </div>
        </div>
        <div class="widewrapper copyright">
                Copyright 2015 More Templates <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a> - Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a>
        </div>
    </footer>
    
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
    <script src="<%=base %>blog/js/bootstrap.min.js"></script>
    <script src="<%=base %>blog/js/modernizr.js"></script>

</body>
</html>