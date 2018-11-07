<%@ page import = "vo.BoardBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% BoardBean article=(BoardBean)request.getAttribute("article");
	String nowPage=(String)request.getAttribute("page");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MVC 게시판</title>
<style type="text/css">
#articleForm
{
	width:500px;
	height:500px;
	border:1px solid red;
	margin:auto;
}
h2{
	text-align:center;
}
#basicInfoArea{
	height:40px;
	text-align:center;
}
#articleContentArea{
	background:orange;
	margin-top:20px;
	height:350px;
	text-align:center;
	overflow:auto;
}
#commandList{
	margin:auto;
	width:500px;
	text-align:center;
}
</style>
</head>
<body>
	<!-- 게시판 수정 -->
	<section id="articleForm">
		<h2>글 내용 상세보기</h2>
		<section id="basicInfoArea">
			제목:
			<%=article.getBOARD_SUBJECT() %>
			첨부파일:
			<% if(!(article.getBOARD_FILE()==null)){ %>
				<a href="file_down?downFile=<%=article.getBOARD_FILE() %>"><%=article.getBOARD_FILE() %></a>
			<% } %>
		</section>
		<section id="articleContentArea">
			<%= article.getBOARD_CONTENT() %>
		</section>
		<section id="commandList">
			<a href="boardReplyForm.do?board_num=<%=article.getBOARD_NUM() %>&page=<%=nowPage%>">[답변]</a>
			<a href="boardModifyForm.do?board_num=<%=article.getBOARD_NUM() %>">[수정]</a>
			<a href="boardDeleteForm.do?board_num=<%=article.getBOARD_NUM() %>"&page=<%=nowPage %>>[삭제]</a>
			<a href="boardList.do?page=<%=nowPage %>">[목록]</a>
			&nbsp;&nbsp;
	</section>
</body>
</html>