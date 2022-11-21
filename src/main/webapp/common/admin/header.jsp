<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!-- ----------------------------------------------------------------------------------Header -->
<!-- ----------------------------------------------------------------------------Header-Banner-->
<div id="navbar" class="navbar navbar-default">
	<script type="text/javascript">
		try {
			ace.settings.check('navbar', 'fixed')
		} catch (e) {
		}
	</script>

	<div class="navbar-container" id="navbar-container">
		<button type="button" class="navbar-toggle menu-toggler pull-left"
			id="menu-toggler" data-target="#sidebar">
			<span class="sr-only">Toggle sidebar</span> <span class="icon-bar"></span>

			<span class="icon-bar"></span> <span class="icon-bar"></span>
		</button>

		<div class="navbar-header pull-left">
			<a href="" class="navbar-brand"> <small> <i
					class="fa fa-leaf"></i> ADMIN
			</small>
			</a>
		</div>
            
                <div class="navbar-header pull-left">
			<a href="<%=request.getContextPath()%>/trang-chu" class="navbar-brand"> <small> <i
					class="fa fa-leaf"></i> HomePage
			</small>
			</a>
		</div>

		<div class="navbar-buttons navbar-header pull-right" role="navigation">
			<ul l class="nav ace-nav">
				<li class="light-blue"><a data-toggle="dropdown" href="#"
					class="dropdown-toggle"> <!-- <img class="nav-user-photo" src="assets/avatars/user.jpg" alt="Jason's Photo" /> -->
						<span class="user-info"> <small>Welcome,</small>
							${USERMODEL.fullName}
					</span> <i class="ace-icon fa fa-caret-down"></i>
				</a>

					<ul
						class="user-menu dropdown-menu-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
						<!-- <li>
								<a href="#">
									<i class="ace-icon fa fa-cog"></i>
									Settings
								</a>
							</li> -->

						<!-- <li>
								<a href="profile.html">
									<i class="ace-icon fa fa-user"></i>
									Profile
								</a>
							</li> -->

						<!-- <li class="divider"></li> -->

						<li>
						<a href="<c:url value='/logout?action=logout'/>"> 
						<i class="fas fa-power-off"></i>Đăng xuất</a>
						</li>
					</ul></li>
			</ul>
		</div>
	</div>
	<!-- /.navbar-container -->
</div>