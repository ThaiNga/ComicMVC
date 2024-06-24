<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.7/css/all.css">
    <link rel="stylesheet" type="text/css" href="css/styledn.css">
    <title>Comic</title>
</head>
<body>
    <nav class="navbar">
        <div class="container-fluid">
          <div class="navbar-header">
            <a class="navbar-brand" href="home?mn=true">Truyện tranh comic</a>
          </div>
          <ul class="nav navbar-nav">
            <li class="active"><a href="home?mn=true">Home</a></li>
               <c:if test="${sessionScope.admin!=null }">
        	<li><a href="admin">Admin</a></li>
        </c:if>
            <c:choose>
      		<c:when test="${sessionScope.un!=null }">
        		<li><a href="lichsu">Lịch sử đọc truyện</a></li>
        	</c:when>
      		<c:otherwise>
      			<li><a href="dangnhap">Lịch sử đọc truyện</a></li>
      		</c:otherwise>
      	</c:choose>
          </ul>
          <form class="navbar-form navbar-left" action="home">
            <div class="input-group">
              <input type="text" class="form-control" placeholder="Search" name="txttk">
              <div class="input-group-btn">
                <button class="btn btn-default" type="submit">
                  <i class="glyphicon glyphicon-search"></i>
                </button>
              </div>
            </div>
          </form>
          <ul class="nav navbar-nav navbar-right">
            <li><a href="dangky"><span class="glyphicon glyphicon-user"></span> Đăng ký</a></li>
            <!-- <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li> -->
          </ul>
        </div>
    </nav>
    <div class="form-login">
		<form action="">
		    <div class="content">
			    <span>Đăng nhập</span>
		    </div>
		    <div class="input-login">
		        <label class="remind" for="email">Email/Username:</label>
		        <input class="input-info" type="text" name="txtun" placeholder="Email/Username">
		        <label class="remind" for="password">Mật khẩu:</label>
		        <input class="input-info" type="password" name="txtmk" placeholder="Mật khẩu">
                <div><a class="signup-new" href="dangky">Đăng kí mới</a></div>
		        <input class="submit-dang-nhap" type="submit" name="dangnhap" value="Đăng nhập">
		    </div>
		    <span style="color: red">${thongbao }</span>
	    </form>
	</div>
</body>
</html>