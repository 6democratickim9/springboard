<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>spring ajax</title>
</head>
<body>
	SpringBoot Home
	<br>
	<br>
	<a href="getTotalDepartmentCount">부서수</a>
	<%--
			DepartmentController -- DepartmentMapper 
				|
				views/department/dept-count.jsp
				
 --%>

	<table border="1" width="900px">
		<tr>
			<td>중고거래 카테고리</td>
		</tr>

		<c:forEach var="category" items="${list}">
			<tr>
				<td><form
						action="${path}/board/list/${board.boardId}/${category.categoryId}"
						method="get">
						
						<button type="submit">${category.categoryName} 커뮤니티</button>
					</form></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>

