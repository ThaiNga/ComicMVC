<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" href='css/stylechinhsua.css'/>
<title>Insert title here</title>
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
      	<c:choose>
      		<c:when test="${sessionScope.un!=null }">
      			<li><a><span class="glyphicon"></span>Xin chào: ${ sessionScope.un }</a></li>
      			<li><a href="dangxuat"><span class="glyphicon glyphicon-log-out"></span> Đăng xuất</a></li>
      		</c:when>
      		<c:otherwise>
       			<li><a href="dangky"><span class="glyphicon glyphicon-user"></span> Đăng ký</a></li>
        		<li><a href="dangnhap"><span class="glyphicon glyphicon-log-in"></span> Đăng nhập</a></li>
        	</c:otherwise>
       
        </c:choose>
      </ul>
    </div>
	</nav>
<form method="post" action="chinhsuatam?matr=${truyen.getMaTruyen()} " enctype= "multipart/form-data">
<table class="table table-bordered">
        <thead>
          <tr>
            <th>Tên truyện</th>
            <th>Tác giả</th>
            <th>Ảnh bìa</th>
            <th>Giới thiệu</th>
           <!--  <th>Thể loại</th> -->
          </tr>
        </thead>
        <tbody>
          <tr>
            <td><input type="text" name="txtname" value="${truyen.getTenTruyen() }"></td>
            <td><input type="text" name="txttacgia" value="${truyen.getTacGia() }"></td>
            <td>
                <img class="avatar" src="${truyen.getAvatar() }" alt="">
                <input type="file" name="txtfile">
            </td>
            <td><textarea class="gioi-thieu" name="txtgioithieu" type="text">${truyen.getGioiThieu() }</textarea></td>
            <!-- <td>
                <Select class="chontheloai" name="chap" id="chap">
                    <Option value="TL1">Hành động</Option>
                </Select>
            </td> -->
      
        </tbody>
      </table>
      <input type="submit" name="xacnhan" value="Xác nhận">
      </form> 
      <span>${thongbao }</span>
</body>
</html>