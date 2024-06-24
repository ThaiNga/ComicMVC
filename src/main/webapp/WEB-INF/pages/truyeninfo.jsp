<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
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
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="css/styleinfo3.css"/>
    <title>Comic</title>
</head>
<body>
	<c:set var="xemThem" value="${false }"></c:set>
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
    <table class="table info">
        <tr>
        <td height="310"><img width="300" height="300" src="${truyen.getAvatar() }" alt=""></td>
        <td width="100%">
            <table class="table">
                <tr>
                	<td>
                		<h1 style="text-transform: capitalize;">${truyen.getTenTruyen() }</h1>
                	</td>
                </tr>
                <tr>
                	<td>Lượt xem:${truyen.getTongLuotXem() }</td>
                </tr>
                <tr>
                	<td>
                		<b>Tác giả:</b> ${truyen.getTacGia() }
                	</td>
                </tr>
                <tr>
                	<td>
                		<b>Thể loại:</b> 
                		<c:forEach items="${dstl }" var="theloai" varStatus="loop">
                			<c:if test="${loop.index!=0 }">, </c:if>
                			 <a style="text-transform: capitalize;" href="home?matl=${theloai.getMaTheLoai() }">${theloai.getTenTheLoai() }</a>
                		 </c:forEach> 
                	</td>
                </tr>
                <tr>
                	<td>
                	<%-- 	<c:set var="luotLike" value="${truyen.getLuotLike() }"></c:set>
                		<c:set var="textthich" value="${thich }"></c:set> --%>
                		<c:choose>
                			<c:when test="${sessionScope.un==null }">
                				<a href="dangnhap" class="lk" style="color: white;">
                					<i class="fa fa-thumbs-up"></i> Thích(${ truyen.getLuotLike()})
                				</a>
                			</c:when>
                			<c:otherwise>
                				<c:if test="${!thich }">
                				<a href="info?matr=${truyen.getMaTruyen() }&luot=1" class="lk" style="color: white;">
                					<i class="fa fa-thumbs-up"></i> Thích(${truyen.getLuotLike() })
                				</a>
                				</c:if>
                				<c:if test="${thich }">
                				<a href="info?matr=${truyen.getMaTruyen() }&luot=-1"  class="lk" style="color: white;">
                					<i class="fa fa-thumbs-up"></i> Đã Thích(${truyen.getLuotLike() })
                				</a>
                				</c:if>
                			</c:otherwise>
                		</c:choose>
                	</td>
                </tr>
            </table>
        </td>
        </tr>
        <c:if test="${dschap.size()!=0 }">
        <form action="read">
        <td><button class="chuyenchap" type="submit" name="machap" value="${chapdau }">Đọc từ đầu</button></td>
        <td><button class="chuyenchap" type="submit" name="machap" value="${chapmoi }">Chap mới nhất</button></td>
        </form>
        </c:if>
    </table>
    <table class="center">
      <tr><td><h3>Giới thiệu truyện</h3></td></tr>
      <tr>
      	<td>
      		<p style="text-transform: capitalize;">Tên Truyện: ${truyen.getTenTruyen() }</p>
      	</td>
      </tr>
      <tr>
      	<td>
      		<c:set var="gioiThieu" value="${truyen.getGioiThieu() }"></c:set>
      		<c:set var="gioiThieuThuGon" value="${fn:substring(gioiThieu, 0, 200)}"></c:set>
      		Nội Dung: <p class="gioi-thieu">${gioiThieu }</p>
      		<span class="xem-them-btn"></span>
      	</td>
	  </tr>  
	 </table>    	
    <table class="center">
        <tr><td><h3>Danh sách chap</h3></td></tr>
            <c:if test="${dschap.size()==0 }"><td><span class="thongbao">Chưa có chap nào!</span></td></c:if>
             <td>
                <table class="table">
                	<c:forEach items="${dschap }" var="chaptruyen">
                   	 <tr><td width="60%" style="text-transform: capitalize;"><a href="read?machap=${chaptruyen.getMaChap() }&matr=${truyen.getMaTruyen() }">${chaptruyen.getTenChap() }</a></td>
                         <td>Lượt xem:${chaptruyen.getLuotXem() }</td>
                         <td>Ngày đăng:${chaptruyen.getNgayDang() }</td>
                     </tr>
                    </c:forEach>
                </table>
            </td> 
    </table>
    <script>
    	const xemThemBtn = document.querySelector('.xem-them-btn');
    	const gioiThieuWrapper = document.querySelector('.gioi-thieu');
    	const gioiThieuValue = "${gioiThieu}";
    	const gioiThieuThuGonValue = "${gioiThieuThuGon}";
    	const renderGioiThieu = () => {
    		const xemThemBtnText = xemThemBtn.innerText;
    		if (xemThemBtnText == "__Xem Thêm__") {
	    		xemThemBtn.innerText = "__Thu Gọn__";    	
	    		gioiThieuWrapper.innerText = gioiThieuValue;
    		}
    		else {
    			xemThemBtn.innerText = "__Xem Thêm__";
    			gioiThieuWrapper.innerText = gioiThieuThuGonValue;
    		}    		
    	}
    	if (gioiThieuValue.length > gioiThieuThuGonValue.length) {
    		renderGioiThieu();
    	}
    	xemThemBtn.addEventListener('click', renderGioiThieu);
    	function loadDoc() {
    		  const xhttp = new XMLHttpRequest();
    		  xhttp.onload = function() {
    		    document.getElementById("demo"). = this.responseText;
    		    }
    		  xhttp.open("GET", "ajax_info.txt", true);
    		  xhttp.send();
    		}
    </script>
</body>
	

</html>