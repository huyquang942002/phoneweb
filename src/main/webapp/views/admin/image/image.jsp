<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<c:url var="APIAdminImage" value="/api-admin-image"/>
<c:url var ="ImageURL" value="/admin-image"/>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
    <title>Document</title>
</head>
<body>
<div class="main-content">
	<div class="main-content-inner">
        <div class="page-content home-page">
            
            <c:if test="${not empty messageResponse}">
				<div class="alert alert-${alert}">
							${messageResponse}
				</div>
			</c:if>
			<div class="ace-settings-container" id="ace-settings-container">
            	<a href='<c:url value="/admin-image?type=edit"/>'>
                <div style="margin-right: 1rem; border-radius: 5px;" class="btn btn-app btn-xs btn-warning ace-settings-btn" id="add-user" >
                    <i class="ace-icon fas fa-plus bigger-130"></i>
                </div>
                </a>
            </div>
            <div style="font-family: Arial, Helvetica, sans-serif; font-size :2rem" class="page-header">         
                   IMAGE
            </div><!-- /.page-header -->
          
            
            <div class="container__right-customer " >
                <div class="container__right-content">
                 <table style="font-family: Arial, Helvetica, sans-serif;" class="table">
                     <thead>
                         <th style="width: 5%" >ID</th>
                         <th style="width: 25%" >Image Big</th>
                         <th style="width: 25%" >Image Small</th>
                         <th style="width: 10%" >Product ID</th>
                         <th style="width: 20%" >Product Name</th>                    
                         <th style="width: 15%" >Action</th>
                     </thead>
                     <tbody>
                     	<c:forEach var="item" items="${model}">
                         <tr>
                             <td>${item.imageId}</td>                            
                             <td><img src='<c:url value="images/imageProduct/${item.imageBig}"/>'></td>                          
                             <td><img src='<c:url value="images/imageProduct/${item.imageSmall}"/>'></td>              
                             <td>
                             <c:forEach var="product" items="${PRODUCT}">
                             	<c:if test="${product.imageId.imageId == item.imageId}"> ${product.productId}</c:if>                                            	
	                         </c:forEach>
	                         </td>
	                         <td>
                             <c:forEach var="product" items="${PRODUCT}">
                             	<c:if test="${product.imageId.imageId == item.imageId}"> ${product.productName}</c:if>                            	                            	
	                         </c:forEach>
	                         </td>
                             <td>
                             	<a href='<c:url value="/admin-image?type=edit&imageId=${item.imageId}"/>'><i id="edit-image" style="color: #438eb9;" class=" icon fas fa-edit"></i></a>                             
                                <a id="btnDeleteImage" data-id="${item.imageId}" type="button" style="pointer-events: all;"> <i style="color: red;" class=" icon fas fa-trash-alt"></i></a>                        	                               
                             </td>             
                         </tr>
                         </c:forEach>
                     </tbody>
                 </table>
                </div>
            </div>                 
        </div>
    </div>
</div>
<script>
	const btnDeleteImage = document.querySelectorAll(`#btnDeleteImage`);
	btnDeleteImage.forEach((item) => item.addEventListener("click", function(e) {
		e.preventDefault();
		const imageId = item.dataset.id;
	    var data = {};
		data['imageId'] = imageId;
		deleteImage(data);
	}))
	function deleteImage(data) {
        $.ajax({
            url: '${APIAdminImage}',
            type: 'DELETE',
            contentType: 'application/json',
            data: JSON.stringify(data),
            success: function (result) {
            	window.location.href = "${ImageURL}?type=list&message=delete_success";
            },
            error: function (error) {
            	window.location.href = "${ImageURL}?type=list&message=error_system";
            }
        });
    }
</script>
</body>
</html>