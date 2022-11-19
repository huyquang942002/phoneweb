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
                    BRAND
            </div><!-- /.page-header -->
            <div class="form__wapper form__wapper-user-add">
            <c:if test="${not empty messageResponse}">
				<div class="alert alert-${alert}">
							${messageResponse}
				</div>
			</c:if>
                <form class="form" id="form-brand" action='<c:url value="/admin-brand" />' method="post" enctype="multipart/form-data">
                    <div class="form-item">
                        <label for="brandName">Brand Name</label>
                        <input type="text" name="brandName" id="brandName" value='${Brand.brandName}' required="required">
                    </div>
                    <div class="form-item">
                        <label for="logo">Logo</label>
                    	<input type="file" name="logo" id="logo">
                    </div>
                    
                    <div class="form-item">
                        
                        <c:if test="${not empty Brand.brandId}">
                        	<button class="form-btn" type="submit" value="Update">Update</button>                     
                        </c:if>
                        <c:if test="${empty Brand.brandId}">
                        	<button class="form-btn" type="submit" value="Add">Add</button>
                        </c:if>
                    </div>
                    <input type="hidden" value="${Brand.brandId}" id="brandId" name="brandId"/>
                </form>
            </div>
        </div>
        <c:if test="${not empty Brand.brandId}">
	        <div class="image">
	            <div class="img_big">
	                <p>Logo</p>
	                <img src='<c:url value="images/imageBrand/${Brand.logo}"/>' alt="">
	            </div>
	        </div>
        </c:if>
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