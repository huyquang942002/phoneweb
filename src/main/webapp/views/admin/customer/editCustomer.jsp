<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<c:url var="APIAdminUser" value="/api-admin-user"/>
<c:url var ="CustomerURL" value="/admin-customer"/>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
    <title>Document</title>
</head>
<body>
<div class="main-content">
	<div class="main-content-inner">
        <div class="page-content">

            <div style="font-family: Arial, Helvetica, sans-serif; font-size :2rem" class="page-header">         
                    ACCOUNT
            </div><!-- /.page-header -->
            <div class="form__wapper form__wapper-user-add">
            <c:if test="${not empty messageResponse}">
				<div class="alert alert-${alert}">
							${messageResponse}
				</div>
				<script>
			    window.addEventListener("alert",function(){
			         alert("${messageResponse}");
			    }
			    </script>
			</c:if>
                <form class="form" id="form-user">                 
                    <div class="form-item">
                        <label for="email">Email</label>
                        <input type="email" name="email" id="email" value='${USER.email}' required="required">
                    </div>
                    <div class="form-item">
                        <label for="fullName">Full Name</label>
                    <input type="text" name="fullName" id="fullName" value='${USER.fullName}' required="required">
                    </div>
                    <div class="form-item">
                        <label for="password">Password</label>
                        <input type="password" name="password" id="password" value='${USER.password}' required="required">
                    </div>            
                    <div class="form-item">
                        <label for="phone">Phone</label>
                        <input type="text" name="phone" id="phone" value='${USER.phone}' required="required">
                    </div>
                    <div class="form-item">
                        <label for="address">Address</label>
                        <input type="text" name="address" id="address" value='${USER.address}' required="required">
                    </div>
                    <div class="form-item">
                    <label for="role">Role</label>
                        <select class="form-control" id="roleId" name="roleId">
                               <c:if test="${empty USER.role}">
                               	<option>Choose one</option>
						        <c:forEach var="item" items="${role}">									
									<option value="${item.roleId}">${item.roleName}</option>										
								</c:forEach>
                                </c:if>
                                
                                <c:if test="${not empty USER.role}">                                    	
						        <option value="${USER.role.roleId}">${USER.role.roleName}</option>
								<c:forEach var="item" items="${role}">									
									<option value="${item.roleId}">${item.roleName}</option>										
								</c:forEach>
                               </c:if>									        
					    </select>
                    </div>
                    <div class="form-item">
                        
                        <c:if test="${not empty USER.userId}">
                        	<button class="form-btn" type="button" value="Update" id="btnAddOrUpdateUser">Update</button>                     
                        </c:if>
                        <c:if test="${empty USER.userId}">
                        	<button class="form-btn" type="button" value="Add" id="btnAddOrUpdateUser">Add</button>
                        </c:if>
                    </div>
                    <input type="hidden" value="${USER.userId}" id="userId" name="userId"/>
                </form>
            </div>
        </div>
    </div>
</div>
<script>
	$('#btnAddOrUpdateUser').click(function (e) {
	    e.preventDefault();
	    var data = {};
	    var formData = $('#form-user').serializeArray();
	    $.each(formData, function (i, v) {
	        data[""+v.name+""] = v.value;
	    });
	    
	    var userId = $('#userId').val();
	    if (userId == "") {
	        addUser(data);
	    } else {
	        updateUser(data);
	    }
	    
	});
	function addUser(data) {
        $.ajax({
            url: '${APIAdminUser}',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
            	window.location.href = "${CustomerURL}?type=edit&message=insert_success";
            },
            error: function (error) {
            	window.location.href = "${CustomerURL}?type=list&message=error_system";
            }
        });
    }
    function updateUser(data) {
        $.ajax({
            url: '${APIAdminUser}',
            type: 'PUT',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
            	window.location.href = "${CustomerURL}?type=edit&message=update_success";
            },
            error: function (error) {
            	window.location.href = "${CustomerURL}?type=list&message=error_system";
            }
        });
    }
</script>
</body>
</html>