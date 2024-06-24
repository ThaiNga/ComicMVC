<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
 <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="css/styletam.css">
    <title>Document</title>
</head>
<body>
	<nav class="navbar">
    <div class="container-fluid">
      <div class="navbar-header">
        <a class="navbar-brand" href="#">Truyện tranh comic</a>
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
    <div class="readmanga">
        <div class="content">
            <h1 class="tentruyen" style="text-transform: capitalize;">${truyen.getTenTruyen() }</h1>
            <h3 style="text-transform: capitalize;">${tenchap }</h3>
            <div class="input">
                <div class="input_left">
                	<form action="?matr=${ truyen.getMaTruyen()}" id="form-chuyen-chap">
                    <select class="chonchap" name="machap" id="chap" onchange='(()=>{
                    	const form = document.querySelector("#form-chuyen-chap");
                    	form.submit();
                    	
                    })()'>
                    	<c:forEach items="${dschap }" var="chaptruyen">
                    		<c:if test="${chaptruyen.getMaChap()==machap }">
                    			<option selected="selected" value="${chaptruyen.getMaChap() }" style="text-transform: capitalize;">${chaptruyen.getTenChap() }</option>
                    		</c:if>
                    		<c:if test="${chaptruyen.getMaChap()!=machap }">
                        	<option value="${chaptruyen.getMaChap() }" style="text-transform: capitalize;">${chaptruyen.getTenChap() }</option>
                        	</c:if>
                        </c:forEach>
                    </select>
                    </form>
                </div>
                <div class="input_right">
                	<c:if test="${!machap.equals(chapdau) }">
                    	<a class="input_item" href="read?machap=${machap }&chuyentruoc=true" style="color: white;"><i class="fa fa-arrow-left"></i> Trước</button>
                    </c:if>
                    <c:if test="${machap.equals(chapmoi) }">
                    	<a class="input_item" href="info?matr=${truyen.getMaTruyen() }" style="color: white;">Manga Info <i class="fa fa-arrow-right"></i></a>
                    </c:if>
                     <c:if test="${!machap.equals(chapmoi) }">
                     	<a class="input_item" href="read?machap=${machap }&chuyentiep=true" style="color: white;">Tiếp <i class="fa fa-arrow-right"></i></a>
                     </c:if>
                </div>
            </div>
        </div>
        <div class="imagemanga">
        	<c:forEach items="${dsanh }" var="anhchap">
            <img width="1000" height="auto" src="${anhchap.getFileAnh() }" alt="">
            </c:forEach>
        </div>
        <div class="input_right">
          <c:if test="${!machap.equals(chapdau) }">
              <a class="input_item" href="read?machap=${machap }&chuyentruoc=true" style="color: white;"><i class="fa fa-arrow-left"></i> Trước</button>
          </c:if>
          <c:if test="${machap.equals(chapmoi) }">
              <a class="input_item" href="info?matr=${truyen.getMaTruyen() }" style="color: white;">Manga Info <i class="fa fa-arrow-right"></i></a>
          </c:if>
          <c:if test="${!machap.equals(chapmoi) }">
              <a class="input_item" href="read?machap=${machap }&chuyentiep=true" style="color: white;">Tiếp <i class="fa fa-arrow-right"></i></a>
          </c:if>
      </div>
    </div>
</body>
</html>