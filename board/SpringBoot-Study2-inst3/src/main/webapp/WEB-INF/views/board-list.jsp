<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
 <button type="button" class="btn btn-primary" onclick="location.href='/';">메인페이지</button>
	<h1>${board.boardName}<br>
	${category.categoryName}게시판</h1>
	<button type="button" id="btnWrite">글쓰기</button>
	<table border="1" width="900px">
		<tr>

			<td>작성자</td>
			<td>제목</td>

			<td>날짜</td>
			<td>조회수</td>

		</tr>

		<c:forEach var="dto" items="${list}">
			<tr>
				<td>${dto.memberDTO.nickname}</td>
				<td><a href="<c:url value='/board/${dto.postId}' />">
						${dto.title} </a></td>
				<td>${dto.regdate}</td>
				<td>${dto.hits}</td>

			</tr>
		</c:forEach>




	</table>
</body>
</html>