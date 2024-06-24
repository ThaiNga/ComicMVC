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
    <link rel="stylesheet" href="css/styleadmin1.css">
    <title>Document</title>
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
          <form class="navbar-form navbar-left" action="admin" method="post">
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
    <c:if test="${ds.size()==0 }">
        	<div style="background-color: pink; padding: 5px">
        		<h4>Không tìm thấy truyện nào!</h4>
        	</div>
       </c:if>
    <table class="table table-bordered">
        <thead>
          <tr>
            <th>Tên truyện</th>
            <th>Tác giả</th>
            <th>Ảnh bìa</th>
            <th>Giới thiệu</th>
          <!--   <th>Thể loại</th> -->
            <th></th>
          </tr>
        </thead>
        <tbody>
        <c:forEach items="${ds }" var="truyen">
          <tr>
            <td><a href="info?matr=${truyen.getMaTruyen() }">${truyen.getTenTruyen() }</a></td>
            <td>${truyen.getTacGia() }</td>
            <td><img class="avatar" src="${truyen.getAvatar() }" alt=""></td>
            <td>${truyen.getGioiThieu() }</td>
           <!--  <td>Hành động, Lãng mạn</td> -->
            <td>
              <div>
              <a href="chinhsua?matr=${truyen.getMaTruyen() }">Chỉnh sửa</a>
              <a href="themchap?matr=${truyen.getMaTruyen() }">Thêm chap</a>
              </div>
            </td>
          </tr>
          </c:forEach>
        </tbody>
      </table>
      <form action="chinhsua">
      <c:if test="${ key==null}">
      <div class="phan-trang">
        	<c:if test="${sotrang!=1 }">
          		<a href="admin?sotrang=${sotrang-1 }&key=${key}&matl=${matl}&xnn=${xnn}" class="phan-trang-item"><i class="fa fa-angle-double-left"></i></a>
          	</c:if>
          	<c:if test="${sotrang<tongsotrang-2 }">
          		<c:forEach var = "i" begin = "${sotrang }" end = "${sotrang+2 }">
          			<a href="admin?sotrang=${i }&key=${key}&matl=${matl}&xnn=${xnn}" class="phan-trang-item">${i }</a>
          		</c:forEach>
          	</c:if>
          	<c:choose>
          		<c:when test="${sotrang==tongsotrang-2 }">
          			<c:forEach var = "i" begin = "${sotrang }" end = "${sotrang+2 }">
          				<a href="admin?sotrang=${i }&key=${key}&matl=${matl}&xnn=${xnn}" class="phan-trang-item">${i }</a>
          			</c:forEach>
          		</c:when>
          		<c:when test="${sotrang==tongsotrang-1 }">
          			<c:forEach var = "i" begin = "${sotrang }" end = "${sotrang+1 }">
          				<a href="admin?sotrang=${i }&key=${key}&matl=${matl}&xnn=${xnn}" class="phan-trang-item">${i }</a>
          			</c:forEach>
          		</c:when>
          		<c:otherwise>
          		<a class="phan-trang-item"><i class="fa fa-ellipsis-h"></i></a>
          		<a href="admin?sotrang=${tongsotrang }&key=${key}&matl=${matl}&xnn=${xnn}" class="phan-trang-item">${tongsotrang }</a>
          		</c:otherwise>
          	</c:choose>
          	<c:if test="${sotrang!=tongsotrang }">
          		<a href="admin?sotrang=${sotrang+1 }&key=${key}&matl=${matl}&xnn=${xnn}" class="phan-trang-item"><i class="fa fa-angle-double-right"></i></a>
          	</c:if>
        </div>
        </c:if>
      <input type="submit" value="Thêm truyện">
      </form>
</script>
</body>
</html>