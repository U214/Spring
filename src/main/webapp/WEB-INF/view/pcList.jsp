<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- pcList.jsp start -->
<div id="nav">
	<div class="sidebar-holder">
		<ul class="nav  nav-list">
			<!-- 네비 왼쪽 -->
			<br>
			<li class="nav-toggle">
				<fieldset data-icon="fa">
					&nbsp;&nbsp;
					<button type="button" class="btn btn-info btn-lg"
						data-toggle="modal" data-target="#server-add">서버 등록</button>
					<button class="btn btn-info btn-lg"
						onclick="window.open('../detail/state.jsp', '_blank','width=370px, height=600px, left=1200px, top=200px')">
						오류 정보
						<span class="badge bg-primary pull-right" id="count"></span>
					</button>
					<span id="warning"></span>
				</fieldset>
			</li>
			<br>
			<li class="list-subheading">
			<c:choose>
			<c:when test="${param.pcList != null}">
			 <div class="gw-sidebar">
     			 <div id="gw-sidebar" class="gw-sidebar">
        		 <div class="nano-content">
           			 <ul class="gw-nav gw-nav-list">
           			 <c:forEach var="pc" items="${param.pcList}">
           			 	<li class="init-arrow-down">
           			 	<a href="javascript:void(0)">
	           			 	<span id="${pc.pcName}"></span>&nbsp;&nbsp;
	                      	<span class="pcname">${pc.pcName}</span> 
	                      	<span class="ip" style='float: right'>${pc.ipAddress}</span> 
	                      	<b class="gw-arrow"></b>
               			</a>
	                  	<ul class="gw-submenu">
	                     	<li><a href="${contextPath}/main?code=${pc.pcCode}">
	                     	<i class="fa fa-desktop"></i> Information</a></li>
	                     	<li><a href="${contextPath}/detail?code=${pc.pcCode}">
	                     	<i class="fa fa-file-text"></i> Detail</a></li>
	                     	<li><a href="${contextPath}/remote?code=${pc.pcCode}">
	                     	<i class="fa fa-toggle-on"></i> Remote</a></li>
	                  </ul></li>
	                  </c:forEach>
            		</ul>
        		 </div>
      			</div>
   			</div>
			</c:when>
			<c:otherwise>
			<div class="gw-sidebar">
		      <h4 align="center">
		         <b>서버를 등록해주세요.</b>
		      </h4>
		   </div>
			</c:otherwise>
			</c:choose>
			</li>
		</ul>
	</div>
</div>

	
<!-- --pc 등록 -->
<div class="modal fade" id="server-add" role="dialog">
	<div class="modal-dialog modal-sm">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title">서버 등록 하기</h4>

			</div>
			<div class="modal-body">
				<p>
				<form class="cd-form" id="cd-pc" action="../main/insertPC.jsp"
					method="post">
					<p class="fieldset">
						<label class="cd-pcname" for="pcname"><h4>Server
								name</h4></label> <input class="full-width has-padding has-border"
							id="pcname" name="pcname" type="text" placeholder="Server name">
						<span class="cd-error-message">[Error]:: 입력 해 주세요</span>
					</p>
					<p class="fieldset">
						<label class="cd-ip" for="ip"><h4>IP Address</h4></label> <input
							class="full-width has-padding has-border" id="ip" name="ip"
							type="text" placeholder="ex) 123.456.789.0"> <span
							class="cd-error-message">[Error]:: 입력 해 주세요</span>
					</p>
					<p class="fieldset">
						<label class="cd-mac" for="mac"><h4>MAC Address</h4></label> <input
							class="full-width has-padding has-border" id="mac" name="mac"
							type="text" placeholder="ex) A1:B2:C3:D4:E5:F6"> <span
							class="cd-error-message">[Error]:: 입력 해 주세요</span>
					</p>

					<p class="fieldset">
						<input class="full-width" type="submit" value="등록하기">
					</p>
				</form>

			</div>

		</div>
	</div>
</div>

<!-- pcList.jsp end -->