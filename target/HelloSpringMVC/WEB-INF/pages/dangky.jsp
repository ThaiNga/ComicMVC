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
    <link rel="stylesheet" type="text/css" href="css/styledangky.css">
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
        <li><a href="#">Page 1</a></li>
        <li><a href="#">Page 2</a></li>
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
        <!-- <li><a href="#"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li> -->
        <li><a href="dangnhap"><span class="glyphicon glyphicon-log-in"></span> Đăng nhập</a></li>
      </ul>
    </div>
</nav>
<div class="div-body">
    <div id="content">
        <span>Đăng kí</span>
    </div>
    <form action="dangky" method="post">
    <div id="signup_acc">
        <p class="remind">Nhập thông tin người dùng:</p>
        <div id="input_profile">
                <input type="text" name="txtun" placeholder="Nhập Username" size="90"><br>
                <input type="email" name="txtemail" placeholder="Nhập địa chỉ Email" size="90"><br>
            <!--     <input name="txt" type="text" placeholder="Nhập họ và tên" size="90"><br> -->
            <div class="input-password">
                <input type="password" name="txtpass" placeholder="Nhập Mật khẩu" size="40"><br>
                <input type="password" name="txtunrepass" placeholder="Nhập lại mật khẩu" size="40"><br>
            </div>
               
                
                <!-- <select name="b_date" id="b_date">
                    <option value="ngày sinh">Ngày sinh</option>
                </select>
                <select name="b_month" id="b_month">
                    <option value="tháng sinh">Tháng sinh</option>
                </select>
                <select name="b_year" id="b_year">
                    <option value="năm sinh">Năm sinh</option>
                </select><br> -->
                <!-- <select name="city" id="city">
                    <option value="tỉnh/tp">Tỉnh/TP</option>
                </select><br> -->
               <!--  <img src="simpleCaptcha.jpg" /> -->
                <!-- <input type="text" name="answer" id="captcha" placeholder="Nhập mã xác nhận"> -->
                <%-- <c:if test="${kt }"> --%>
                	<span style="color: red">${kt }</span>
                <%-- </c:if> --%>
        </div>
    </div>
    <input class="submit-dang-ky" type="submit" name="dk" value="Đăng ký">
    </form>
</div>
</body>
</html>