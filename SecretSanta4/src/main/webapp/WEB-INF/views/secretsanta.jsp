<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>  
<html>  
<head>  
<meta charset="UTF-8">  
<title>Paulo's Secret Santa Name Generator</title>
<script src="${pageContext.request.contextPath}/alerts.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css.css"/>
</head>  
<img src="./images//Logo.png" width=600px height = 175px>
<style><%@include file="/WEB-INF/views/css.css"%></style>
<div class="snowflakes" aria-hidden="true">
  <div class="snowflake">
  ❅
  </div>
  <div class="snowflake">
  ❅
  </div>
  <div class="snowflake">
  ❆
  </div>
  <div class="snowflake">
  ❄
  </div>
  <div class="snowflake">
  ❅
  </div>
  <div class="snowflake">
  ❆
  </div>
  <div class="snowflake">
  ❄
  </div>
  <div class="snowflake">
  ❅
  </div>
  <div class="snowflake">
  ❆
  </div>
  <div class="snowflake">
  ❄
  </div>
</div>
<div class="all">
<div class="header">
	<h1>Welcome!</h1>
	<h3>Please enter your party's names and respective emails in the boxes below! Names will be drawn randomly and emails sent out to each participant.</h3>
</div>
<div class="body">
<form method="post">
	<div class="txtArea">
		<textArea class="txtBox" id="nameTxt" name="nameTxt" placeholder="Enter names here..." ></textArea>
	</div>
	<div class="txtArea">
		<textArea class="txtBox" id="emailTxt" name="emailTxt" placeholder="Enter emails here..."></textArea>
	</div>
		<textArea class="msgBox" id="msgTxt" name="msgTxt" placeholder="Enter custom message to your friends here..."></textArea>
	<p class="msg" id="statusMsg"></p>
		<button class="submit" type="submit" onclick="validateInput()">Draw!</button>
</form>
</div>

</div>

</html>  