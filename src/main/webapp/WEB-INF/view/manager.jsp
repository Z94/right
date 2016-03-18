<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="wrap fullwidth">
	<div id="content" style="width: auto;">
	<div id="post-2" class="post-2 page type-page status-publish hentry">
		<div class="entry entry-content">
			<blockquote style="font-style:normal;">
				<p><b style="font-size: 14px;">你们的代理IP是怎么获取到的？</b></p>
				<p>① 全网代理IP使用5台4核ECS服务器，运行分布式IP与端口扫描系统，每天扫描IP量几十万条。</p>
				<p>② 我们不间断的运行着IP验证系统，精确地检测每一个代理IP的匿名度、响应时间、数据传输速度、地域、运营商，每秒钟都在验证，保证网站的IP都是高度可用的。</p>
				<p>③ 我们提供了极其丰富的代理筛选和API接口，每次提取的IP不相同，只为更便捷地提取、更便捷的开发。</p>
			</blockquote>
		</div>
		<div class="clear"></div>
		<div class="entry entry-content">
			<div class="entry-title">最新100个可用免费高速HTTP代理IP</div>
				 
				<div id="list">
					<table class="table">
						<thead>
							<tr>
								<th>IP</th>
								<th>PORT</th>
								<th>${count  } ${manager }</th>
								<th>国家</th>
								<th>省市</th>
								<th>运营商</th>
								<th>录入时间</th>
								<th>${managers }</th>
							</tr>
						</thead>
						<tbody>
						<tr>
					</tr>
							<c:forEach items="${managers }" var="item">
							<tr>
								<td>${item}</td>
								<td>${item.getManager_id()}</td>
								<td>${item.getManager_name()}</td>
								<td>${item.getManager_order()}</td>
								<td>${item.getManager_control()}</td>
							</tr>							
							</c:forEach>

						</tbody>
					</table>
					<p class="message">注：表中响应速度是中国测速服务器的测试数据，仅供参考。响应速度根据你机器所在的地理位置不同而有差异。</p>
					<div class="wp-pagenavi">
						<span>第</span>
						<span>页</span>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>