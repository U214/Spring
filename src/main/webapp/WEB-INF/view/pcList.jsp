<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

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
						오류 정보<span class="badge bg-primary pull-right" id="count"></span>
					</button>
					<span id="warning"></span>
				</fieldset>
			</li>
			<br>
			<li class="list-subheading">

				<!-- pcList자리 -->
			</li>

		</ul>
	</div>
</div>