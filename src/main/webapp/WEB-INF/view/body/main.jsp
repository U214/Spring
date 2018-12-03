<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- main.jsp start -->
<div id="section">
	<div class="container">
		<c:choose>
			<c:when test="${param.pcList == null}">
			<div id="step1">
				<div class="col-sm-4 wow fadeInDown" data-wow-duration="1000ms"
					data-wow-delay="300ms">
					<div class="download-info">
						<b>STEP1 : 서버등록</b>
						<p>
						<h4>1. 서버등록 버튼을 클릭해주세요.</h4>
						</p>
						<div class="service"></div>
					</div>
					<div class="download-info">
						<p>
						<h4>2. 관리대상 서버의 IP와 MAC주소를 기입하여 서버를 등록해주세요.</h4>
						</p>
						<br>
						<div class="server"></div>
					</div>
				</div>
				<div class="col-sm-4 wow fadeInDown" data-wow-duration="2000ms"
					data-wow-delay="350ms">
					<div class="download-info">
						<b>STEP2 : 서비스 설치</b>
						<p>
						<h4>3. 아래의 설치파일을 관리대상서버에 받아주세요.</h4>
						<p>
					</div>
					<br>
					<br>
					<table class="text-center our-step">
						<tr>
							<td>
								<div class="col-sm-4 wow fadeInDown" data-wow-duration="4000ms"
									data-wow-delay="500ms" onclick="location='../down/downZIP.jsp'">
									<div class="download-icon" id="left">
										<p></p>
										<i class="fa fa-desktop"></i>
										<div class="download-info">
											<h4>SRM.zip</h4>
										</div>
									</div>
								</div>
							</td>
							<td>
								<div class="col-sm-4 wow fadeInDown" data-wow-duration="4000ms"
									data-wow-delay="550ms"
									onclick="window.open('https://chrome.google.com/webstore/detail/ie-tab/hehijbfgiekmjfkfjpbkbammjbdenadd?hl=ko', '_blank')">
									<div class="download-icon" id="right">
										<p></p>
										<i class="fa fa-internet-explorer"></i>
										<div class="download-info">
											<h4>IE&nbsp;tab</h4>
										</div>
									</div>
								</div>
							</td>
						</tr>
					</table>
					<br>
					<br>
					<br>
					<br>
					<br>
					<div class="download-info">
						<p>
						<h4>4. 설치파일 중 SRM.exe와 remote.exe는 C드라이브 바로 아래에 넣어주세요.</h4>
						<br>
						<div class="exe"></div>
						</p>
					</div>
					<br>
					<br>
					<div class="download-info">
						<p>
						<h4>5. SRMInstaller.exe을 실행시켜 서비스를 설치해주세요.</h4>
						<br>
						<div class="install"></div>
						</p>
					</div>
				</div>
			</div>
			</c:when>
			
			<c:when test="${pcInfo == null}">
			<div id="step1">
				<div class="col-sm-4 wow fadeInDown" data-wow-duration="2000ms"
					data-wow-delay="350ms">
					<div class="download-info">
						<b>STEP2 : 서비스 설치</b>
						<br>
						<p>
						<h4>
							<br>1. 아래의 설치파일을 관리대상서버에 받아주세요.
						</h4>
						<p>
					</div>
					<br>
					<table class="text-center our-step">
						<tr>
							<td>
								<div class="col-sm-4 wow fadeInDown" data-wow-duration="4000ms"
									data-wow-delay="500ms" onclick="location='../down/downZIP.jsp'">
									<div class="download-icon">
										<p></p>
										<i class="fa fa-desktop"></i>
										<div class="download-info">
											<h4>SRM.zip</h4>
										</div>
									</div>
								</div>
							</td>
							<td>
								<div class="col-sm-4 wow fadeInDown" data-wow-duration="4000ms"
									data-wow-delay="550ms"
									onclick="window.open('https://chrome.google.com/webstore/detail/ie-tab/hehijbfgiekmjfkfjpbkbammjbdenadd?hl=ko', '_blank')">
									<div class="download-icon">
										<p></p>
										<i class="fa fa-internet-explorer"></i>
										<div class="download-info">
											<h4>IE&nbsp;tab</h4>
										</div>
									</div>
								</div>
							</td>
						</tr>
					</table>
					<br>
					<br>
					<br>
					<div class="download-info">
						<p>
						<h4>2. 설치파일 중 SRM.exe와 remote.exe는 C드라이브 바로 아래에 넣어주세요.</h4>
						<br>
						<div class="exe">
						</p>
					</div>
						<br>
						<br>
					<div class="download-info">
						<p>
						<h4>3. SRMInstaller.exe을 실행시켜 서비스를 설치해주세요.</h4>
						<br>
						<div class="install"></div>
						</p>
					</div>
					</div>
				</div>
			</div>
			</c:when>
			
			<c:otherwise>
				<h1>${ pcname}</h1>
				<br>
				<table class="table table-striped">
				<thead>
					<tr>
						<th>분류</th>
						<th>내용</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><b>제조사</b></td>
						<td>${ pcname}</td>
					</tr>
					<tr>
						<td><b>모델명</b></td>
						<td>${ pcname}</td>
					</tr>
					<tr>
						<td><b>운영체제</b></td>
						<td>${ pcname}</td>
					</tr>
					<tr>
						<td><b>BIOS</b></td>
						<td>${ pcname}</td>
					</tr>
					<tr>
						<td><b>운영체제 버전</b></td>
						<td>${ pcname}</td>
					</tr>
					<tr>
						<td><b>Processor</b></td>
						<td>${ pcname}</td>
					</tr>
					<tr>
						<td><b>서버 ID</b></td>
						<td>${ pcname}</td>
					</tr>
					<tr>
						<td><b>디스크 용량</b></td>
						<td>${ pcname} GB</td>
					</tr>
					<tr>
						<td><b>메모리</b></td>
						<td>${ pcname} GB</td>
					</tr>
					<tr>
						<td><b>가상 메모리</b></td>
						<td>${ pcname} GB</td>
					</tr>
					<tr>
						<td><b>설치일</b></td>
						<td>${ pcname}</td>
					</tr>
				</tbody>
			</table>
			</c:otherwise>
		</c:choose>
	</div>
</div>
<!-- main.jsp end -->