<%@page import="Bean.khachhangbean"%>
<%@page import="Bo.giohangbo"%>
<%@page import="Bean.giohangbean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Bean.sachbean"%>
<%@page import="Bean.loaibean"%>
<%@page import="Bo.sachbo"%>
<%@page import="Bo.loaibo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hiển thị giỏ hàng</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

		<!-- //khachhangbean kh =(khachhangbean) session.getAttribute("dn");
		//giohangbo sl= (giohangbo)session.getAttribute("gh");
		// Để lấy số lượng từ session hiển thị ở icon giỏ hàng
		//giohangbo sl = (giohangbo) session.getAttribute("gh"); -->

	
	<nav class="navbar navbar-inverse">
	  <div class="container-fluid">
	    <div class="navbar-header">
	      <a class="navbar-brand" href="sachController">Trang chủ</a>
	    </div>
	    <ul class="nav navbar-nav">
	    <c:choose>
	     	<c:when test="${sessioneScope.gh==null}">
	    		<li><a href="giohangController">Giỏ hàng (0)</a></li>
	    	</c:when>
	    	<c:otherwise>
	    		<li><a href="giohangController">Giỏ hàng (${sessioneScope.gh.ds.size()})</a></li>
	    	</c:otherwise>
	    </c:choose>
	   
	      
	      <li><a href="thanhtoan.jsp">Thanh toán</a></li>
	      <li><a href="lichsumuahangController">Lịch sử mua hàng</a></li>
	    </ul>
	     <ul class="nav navbar-nav navbar-right">
	     <li><a href="dangkyController"><span class="glyphicon glyphicon-user"></span> Đăng ký</a></li>
	      <c:choose>
	      	<c:when test="${sessioneScope.dn == null }">
	      		<li><a href="dangnhapController"><span class="glyphicon glyphicon-log-in"></span> Đăng nhập</a></li>
	      	</c:when>
	      	<c:otherwise>
	      	<!-- Lúc này dn là kiểu khachhangbean nên có thể dùng dn để gọi hàm getHoten() -->
	      		<li><a href="#"><span class="glyphicon" ></span> Xin chào: ${dn.getHoten()}</a></li>
	      	<li><a href="dangxuat.jsp"><span class="glyphicon glyphicon-log-out"></span> Đăng xuất</a></li>
	      	</c:otherwise>
	      </c:choose>
	      	
	   </ul>
	  </div>
	</nav>
	<%
		//loaibo lbo = new loaibo();
		//sachbo sbo = new sachbo();
		//chỉnh cấu hình dữ liệu gửi đi-về utf-8
		
	%>
	
	<table class="table"> 
		<tr>
			<td width="200" valign="top">
				<table class="table table-hover">
					<c:forEach items="${dsloai}" var="loai">
						<tr>
							<td>
								<a href="sachController?ml=${loai.getMaloai() }">
									<c:out value="${loai.getTenloai()}"></c:out>
								</a>							
							</td>
						</tr>
					</c:forEach>
				</table> 
			</td>
			<td  width="860" valign="top">	
			
				<!-- //String ms = request.getParameter("ms");
				//String ts = request.getParameter("ts");
				//String gia = request.getParameter("gia");
				//String anh = request.getParameter("anh");
				
				//Hiển thị ds hàng trong session: gh -->
				
				<c:choose>
				
				
				<c:when test="${sessioneScope.gh == null }">
					Giỏ hàng đang trống! Mời bạn <button style="padding: 8px 16px; font-size: 16px;"><a href="sachController">Chọn mua hàng</a></button>
				</c:when>
				<c:otherwise>
					<!-- giohangbo gh = new giohangbo();
					gh = (giohangbo) session.getAttribute("gh");
		 			int sh=gh.ds.size(); -->

				<h3><b>GIỎ HÀNG CỦA BẠN</b> </h3><br>
				<form style="display: inline-block;" action="suaxoaController" method="post">
						<table class="table table-hover">
								<!-- for(int i=0; i<sh; i++){
									giohangbean h =(giohangbean) gh.ds.get(i) -->
							
							<c:forEach items="${sessioneScope.gh.ds()}" var="hang">
									<tr >
									<td>
									<input type='checkbox' name='c1' value="${hang.getMasach()}">
									</td>
										<td>
											<img height="150" width="140" alt="" src="${hang.getAnh()}"> 
											<div style="display: inline-block; padding:10px;"  >
												<b>${hang.getTensach()}</b> <br> <br><br>
												<div>
													Giá bán: ${hang.getGia()} x 
														<input style="width: 50px" type='number' name="${hang.getMasach()}" min="1" value="${hang.getSoluongmua()}">
												 		<button style=" font-size: 15px" type="submit" name="but1" value="${hang.getMasach()}">Cập nhật</button> |
													
													<a style=" font-size: 15px" href='suaxoaController?ms=${hang.getMasach()}'>Trả lại</a>
												</div>	
											</div>
										</td>
									</tr>
								</c:forEach>
							<tr>
								<td>
									<button type="submit" value="Xoa" class="btn btn-danger" style="margin: 20px"> Xóa</button>
								</td>
							
							</tr>
						</table> 
					 </form>
					 <div style="margin-right: 30px; font-size: 18px;"><b>Tổng tiền: </b>  ${sessioneScope.gh.Tongtien()}</div> <br><br>
							<div align="center">
								<button style="padding: 8px 16px; font-size: 16px;"><a href="traallsachController">Trả lại toàn bộ</a></button> 
								<button style="padding: 8px 16px; font-size: 16px;"><a href="sachController">Tiếp tục mua hàng</a></button> 
								<button style="padding: 8px 16px; font-size: 16px;"><a href="sachController">Thanh toán</a></button> 
							</div>
					
						<form method='post' action ='XacNhanController'>
					 	<input name="xn" type="submit" value="Xác nhận đặt mua">
					 </form>
				</c:otherwise>	
			</c:choose>
			</td>
			<td>
				<form method='post' action ='sachController'>
				 <input type='text' name='txttk'><br>
				 <input type='submit' class="btn btn-success" name='tk' value='Search'>
				</form>
			</td>
		</tr>
	</table>
</body>
</html>