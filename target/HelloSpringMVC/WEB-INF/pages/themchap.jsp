<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="css/stylethemchap.css">
    <title>Document</title>
</head>
<body>
    <nav class="navbar">
        <div class="container-fluid">
          <div class="navbar-header">
            <a class="navbar-brand" href="#">WebSiteName</a>
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
            <li><a href="#"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
            <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
          </ul>
        </div>
    </nav>
    <div class="them-chap-content">
        <h3>Thêm chap</h3>
        <form method="post" action="themchapchinh?matr=${matr} " enctype= "multipart/form-data">
        <div>
            <label for="">Tên chap là:</label>
            <input type="text" name="txtname" placeholder="Nhập tên chap">
        </div>
        <div>
            <label for="">Chọn các ảnh:</label>
            <input type="file" name="txtfile" multiple="multiple">
        </div>
        <div>
            <input type="submit" value="Thêm chap">
        </div>
        </form>
        <span>${thongbao }</span>
    </div>
</body>
</html>