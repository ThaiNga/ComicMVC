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
            <td><input class="gioi-thieu" name="txtgioithieu" type="text" value="${truyen.getGioiThieu() }"></td>
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