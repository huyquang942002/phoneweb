<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> -->
<script type="text/javascript">
	try { ace.settings.check('main-container', 'fixed') } catch (e) { }
</script>
<div id="sidebar" class="sidebar responsive">
	<script type="text/javascript">
		try {
			ace.settings.check('sidebar', 'fixed')
		} catch (e) {
		}
	</script>

	<ul class="nav nav-list">
		<li class="dashboard"><a href='<c:url value="/admin-dashboard"/>' style="cursor: pointer;"
			> <i class="fas fa-chart-bar menu-icon"></i>
				<span style="font-family: Arial, Helvetica, sans-serif;"
				class="menu-text"> Dashboard </span>
		</a> <b class="arrow"></b></li>
		
		<li class="customer">
		<a href='<c:url value="/admin-customer?type=list"/>' style="cursor: pointer; pointer-events: all;"
			> <i class="menu-icon fas fa-user"></i> <span
				style="font-family: Arial, Helvetica, sans-serif;" class="menu-text">
					Customer </span>
		</a> 
		<b class="arrow"></b></li>

		<li class="product"><a href='<c:url value="/admin-phone?type=list"/>' style="cursor: pointer;"
			> <i class="menu-icon fab fa-product-hunt"></i>
				<span style="font-family: Arial, Helvetica, sans-serif;"
				class="menu-text"> Product </span>
		</a> <b class="arrow"></b></li>
		
		<li class="brand"><a href='<c:url value="/admin-brand?type=list"/>' style="cursor: pointer;"
			> <i class="fas fa-building menu-icon"></i>
				<span style="font-family: Arial, Helvetica, sans-serif;"
				class="menu-text"> Brand </span>
		</a> <b class="arrow"></b></li>
		
		<li class="brand"><a href='<c:url value="/admin-image?type=list"/>' style="cursor: pointer;"
			> <i class="far fa-image menu-icon"></i>
				<span style="font-family: Arial, Helvetica, sans-serif;"
				class="menu-text"> Product Image </span>
		</a> <b class="arrow"></b></li>

		<li class="order"><a href='<c:url value="/admin-order?type=list"/>' > 
		<i class="fab fa-elementor menu-icon"></i> <span
				style="font-family: Arial, Helvetica, sans-serif;" class="menu-text">
					Order </span>
		</a> <b class="arrow"></b></li>

	</ul>

	<script type="text/javascript">
		try {
			ace.settings.check('sidebar', 'collapsed')
		} catch (e) {
		}
	</script>
</div>