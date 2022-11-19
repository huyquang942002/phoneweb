<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<c:url var="APIAdminBrand" value="/api-admin-brand"/>
<c:url var ="BrandURL" value="/admin-brand"/>
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
            	<a href='<c:url value="/admin-brand?type=edit"/>'>
                <div style="margin-right: 1rem; border-radius: 5px;" class="btn btn-app btn-xs btn-warning ace-settings-btn" id="add-user" >
                    <i class="ace-icon fas fa-plus bigger-130"></i>
                </div>
                </a>
            </div>
            <div style="font-family: Arial, Helvetica, sans-serif; font-size :2rem" class="page-header">         
                    BRAND
            </div>
          
            
            <div class="container__right-customer " >
                <div class="container__right-content">
                 <table style="font-family: Arial, Helvetica, sans-serif;" class="table">
                     <thead>
                         <th style="width: 20%" >ID</th>
                         <th style="width: 30%" >Logo</th>
                         <th style="width: 30%" >Brand Name</th>                         
                         <th style="width: 20%" >Action</th>
                     </thead>
                     <tbody>
                     	<c:forEach var="item" items="${model}">
                         <tr>
                             <td>${item.brandId}</td>
                             <td><img src='<c:url value="images/imageBrand/${item.logo}"/>'></td>
                             <td>${item.brandName}</td>                           
                             <td>
                             	<a href='<c:url value="/admin-brand?type=edit&brandId=${item.brandId}"/>'><i id="edit-brand" style="color: #438eb9;" class=" icon fas fa-edit"></i></a>                             
                                <a id="btnDeleteBrand" data-id="${item.brandId}" type="button" style="pointer-events: all;"> <i style="color: red;" class=" icon fas fa-trash-alt"></i></a>                        	                               
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
	const btnDeleteBrand = document.querySelectorAll(`#btnDeleteBrand`);
	btnDeleteBrand.forEach((item) => item.addEventListener("click", function(e) {
		e.preventDefault();
		const brandId = item.dataset.id;
	    var data = {};
		data['brandId'] = brandId;
		deleteBrand(data);
	}))
	function deleteBrand(data) {
        $.ajax({
            url: '${APIAdminBrand}',
            type: 'DELETE',
            contentType: 'application/json',
            data: JSON.stringify(data),
            success: function (result) {
            	window.location.href = "${BrandURL}?type=list&message=delete_success";
            },
            error: function (error) {
            	window.location.href = "${BrandURL}?type=list&message=error_system";
            }
        });
    }
</script>
</body>
</html>