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
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.7/css/all.css">
    <link rel="stylesheet" href='css/stylemenu8.css'/>
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
      <form class="navbar-form navbar-left" action="home" method="post">
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
    <div class="content">
        <h2 class="websitename">Truyện tranh comic</h2>
        <span class="guide">Thể loại</span>
        <div class="theloai">
        	<c:forEach items="${dstl }" var="theloai">
            <a class="theloai-item" href="?matl=${theloai.getMaTheLoai() }"><i class='theloai-icon fas fa-angle-right ' width="10"></i>${theloai.getTenTheLoai() }</a>
            </c:forEach>
        </div>
       <c:if test="${tentl!=null }"><div><h3 style="color: rgba(2, 132, 2, 0.955);">Thể loại ${tentl }</h3></div></c:if>
    </div>
    <div class="dstruyen">
    	<c:if test="${key==null }">
        <div class="truyen-input">
            <a href="?mn=true&matl=${matl }">Mới nhất</a>
            <a href="?xnn=true&matl=${matl }">Xem nhiều nhất</a>
        </div>
        </c:if>
        <c:if test="${key!=null }">
        	<h3>Đang tìm kiếm từ khóa: ${key }</h3>
        </c:if>
        <c:if test="${ds.size()==0 }">
        	<div style="background-color: pink; padding: 5px">
        		<h4>Không tìm thấy truyện nào!</h4>
        	</div>
        </c:if>
        <div class="truyen-wrapper">
        	<c:forEach items="${ds}" var="truyen">
            <div class="truyen-item">
                <img height="200" width="200" src="${truyen.getAvatar() }" alt="">
                <a class="tentruyen" href="info?matr=${truyen.getMaTruyen() }">${truyen.getTenTruyen() }</a>
                <span>Lượt xem:${truyen.getTongLuotXem() }</span>
                <div class="chaptruyen">
                	<c:if test="${truyen.getTenChapMoi()==null}">
                    <span>Chưa có chap</span>
                    </c:if>
                    <c:if test="${truyen.getTenChapMoi()!=null}">
                    <a class="chapmoi" href="read?machap=${truyen.getMaChapMoi() }">${truyen.getTenChapMoi()}</a>
                    <span class="thoigian">${truyen.getNgayDangMoi() }</span>
                    </c:if>
                </div>
            </div>
            </c:forEach>
        </div>
        <c:if test="${key==null&&tongsotrang!=0 }">
        <div class="phan-trang">
        	<c:if test="${sotrang!=1 }">
          		<a href="home?sotrang=${sotrang-1 }&key=${key}&matl=${matl}&xnn=${xnn}" class="phan-trang-item"><i class="fa fa-angle-double-left"></i></a>
          	</c:if>
          	<c:if test="${sotrang<tongsotrang-2 }">
          		<c:forEach var = "i" begin = "${sotrang }" end = "${sotrang+2 }">
          			<a href="home?sotrang=${i }&key=${key}&matl=${matl}&xnn=${xnn}" class="phan-trang-item">${i }</a>
          		</c:forEach>
          	</c:if>
          	<c:choose>
          		<c:when test="${sotrang==tongsotrang-2 }">
          			<c:forEach var = "i" begin = "${sotrang }" end = "${sotrang+2 }">
          				<a href="home?sotrang=${i }&key=${key}&matl=${matl}&xnn=${xnn}" class="phan-trang-item">${i }</a>
          			</c:forEach>
          		</c:when>
          		<c:when test="${sotrang==tongsotrang-1 }">
          			<c:forEach var = "i" begin = "${sotrang }" end = "${sotrang+1 }">
          				<a href="home?sotrang=${i }&key=${key}&matl=${matl}&xnn=${xnn}" class="phan-trang-item">${i }</a>
          			</c:forEach>
          		</c:when>
          		<c:otherwise>
          			<c:if test="${tongsotrang!=1&&tongsotrang!=0}">
          				<a class="phan-trang-item"><i class="fa fa-ellipsis-h"></i></a>
          			</c:if>
          		<a href="home?sotrang=${tongsotrang }&key=${key}&matl=${matl}&xnn=${xnn}" class="phan-trang-item">${tongsotrang }</a>
          		</c:otherwise>
          	</c:choose>
          	<c:if test="${sotrang!=tongsotrang }">
          		<a href="home?sotrang=${sotrang+1 }&key=${key}&matl=${matl}&xnn=${xnn}" class="phan-trang-item"><i class="fa fa-angle-double-right"></i></a>
          	</c:if>
        </div>
        </c:if>
    </div>
</body>
</html>