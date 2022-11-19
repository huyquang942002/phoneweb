<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<c:url var="APIAdminProduct" value="/api-admin-phone"/>
<c:url var ="PhoneURL" value="/admin-phone"/>
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
            <div class="ace-settings-container" id="ace-settings-container">
               
                
            </div>

            <div style="font-family: Arial, Helvetica, sans-serif; font-size :2rem" class="page-header">           
                    PRODUCT           
            </div><!-- /.page-header -->
            <div class="form__wapper form__wapper-product-add">
            <c:if test="${not empty messageResponse}">
				<div class="alert alert-${alert}">
							${messageResponse}
				</div>
			</c:if>
                <form class="form form-add" id="form-product" ENCTYPE="multipart/form-data">
          
                    <div class="form-item">
                        <h4 class="title">INFORMATION</h4>
                    </div>
                    <div class="form-item">
                        <label for="productName">Product Name</label>
                        <input type="text" name="productName" id="productName" value="${PRODUCT.productName}" required="required">
                    </div>
                    <div class="form-item select ">
                        <label>Categoty</label>
	                    <select id="categoryId" name="categoryId">
	                        <c:if test="${empty PRODUCT.categoryId}">
                              	<option>Choose one</option>
					        <c:forEach var="item" items="${category}">									
								<option value="${item.categoryId}">${item.categoryName}</option>										
							</c:forEach>
                               </c:if>
                               
                               <c:if test="${not empty PRODUCT.categoryId}">                                    	
							        <option value="${PRODUCT.categoryId.categoryId}">${PRODUCT.categoryId.categoryName}</option>
									<c:forEach var="item" items="${category}">
										<c:if test="${PRODUCT.categoryId.categoryId != item.categoryId}">									
											<option value="${item.categoryId}">${item.categoryName}</option>	
										</c:if>									
									</c:forEach>
                              </c:if>
	                    </select>
                    </div>
                    <div class="form-item select">
                        <label>Brand</label>
                        <select id="brandId" name="brandId">
                            <c:if test="${empty PRODUCT.brandId}">
                              	<option>Choose one</option>
					        <c:forEach var="item" items="${brand}">									
								<option value="${item.brandId}">${item.brandName}</option>										
							</c:forEach>
                               </c:if>
                               
                               <c:if test="${not empty PRODUCT.brandId}">                                    	
							        <option value="${PRODUCT.brandId.brandId}">${PRODUCT.brandId.brandName}</option>
									<c:forEach var="item" items="${brand}">
										<c:if test="${PRODUCT.brandId.brandId != item.brandId}">								
											<option value="${item.brandId}">${item.brandName}</option>
										</c:if>								
									</c:forEach>
                              </c:if>
                        </select>
                    </div>
                    <div class="form-item">
                        <label for="price">Price</label>
                        <input type="text" name="price" id="price" value="${PRODUCT.price}" required="required">
                    </div>
                    <div class="form-item">
                        <label for="description">Description</label>
                        <input type="text" name="description" id="description" value="${PRODUCT.description}" required="required">
                    </div>
                    
                    <br>
                    
                    <div class="form-item">
                        <h4 class="title">INFORMATION DETAILS</h4>
                    </div>
                    <div class="form-item">
                        <label for="camera">Camera</label>
                        <input type="text" name="camera" value="${PRODUCT.infoId.camera}" required="required">
                    </div>
                    <div class="form-item">
                        <label for="cameraSelfie">Camera selfie</label>
                        <input type="text" name="cameraSelfie" value="${PRODUCT.infoId.cameraSelfie}" required="required">
                    </div>
                    <div class="form-item">
                        <label for="cell">Cell</label>
                        <input type="text" name="cell" value="${PRODUCT.infoId.cell}" required="required">
                    </div>
                    <div class="form-item">
                        <label for="cpu">CPU</label>
                        <input type="text" name="cpu" value="${PRODUCT.infoId.cpu}" required="required">
                    </div>
                    <div class="form-item">
                        <label for="gpu">GPU</label>
                        <input type="text" name="gpu" value="${PRODUCT.infoId.gpu}" required="required">
                    </div>
                    <div class="form-item">
                        <label for="memory">Memory</label>
                        <input type="text" name="memory" value="${PRODUCT.infoId.memory}" required="required">
                    </div>
                    <div class="form-item">
                        <label for="os">OS</label>
                        <input type="text" name="os" value="${PRODUCT.infoId.os}" required="required">
                    </div>
                    <div class="form-item">
                        <label for="ram">Ram</label>
                        <input type="text" name="ram" value="${PRODUCT.infoId.ram}" required="required">
                    </div>
                    <div class="form-item">
                        <label for="screen">Screen</label>
                        <input type="text" name="screen" value="${PRODUCT.infoId.screen}" required="required">
                    </div>
                    <div class="form-item">
                        <label for="sim">Sim</label>
                        <input type="text" name="sim" value="${PRODUCT.infoId.sim}" required="required">
                    </div>


                    <br>
                   <div class="form-item select ">
                        <label>Image</label>
	                    <select id="imageId" name="imageId">
	                        <c:if test="${empty PRODUCT.productId}">
                              	<option>Choose one</option>
						        <c:forEach var="item" items="${image}">									
									<option value="${item.imageId}">${item.imageId}</option>										
								</c:forEach>
                               </c:if>
                               
                               <c:if test="${not empty PRODUCT.productId}">
                                    <c:forEach var="item" items="${image}">
										<c:if test="${item.imageId == PRODUCT.imageId.imageId}">									
											<option value="${item.imageId}">${item.imageId}</option>	
										</c:if>									
									</c:forEach>	
									<c:forEach var="item" items="${image}">
										<c:if test="${item.imageId != PRODUCT.imageId.imageId}">									
											<option value="${item.imageId}">${item.imageId}</option>		
										</c:if>									
									</c:forEach>
                              </c:if>
	                    </select>
                    </div>
                    <div class="form-item">
                    	<c:if test="${not empty PRODUCT.productId}">
                        	<button class="form-btn" type="button" value="Update" id="btnAddOrUpdateProduct">Update</button>                     
                        </c:if>
                        <c:if test="${empty PRODUCT.productId}">
                        	<button class="form-btn" type="button" value="Add" id="btnAddOrUpdateProduct">Add</button>
                        </c:if>
            
                    </div>
                    <input type="hidden" value="${PRODUCT.productId}" id="productId" name="productId"/>
                    <input type="hidden" value="${PRODUCT.infoId.infoId}" id="infoId" name="infoId"/>
                </form>
            </div>                
        </div>
        <c:if test="${not empty PRODUCT.productId}">
	        <div class="image">
	        	<div class="img_small">
	                <p>Small Image</p>
	                <img src='<c:url value="images/imageProduct/${PRODUCT.imageId.imageSmall}"/>' alt="">
	            </div>
	            <div class="img_big">
	                <p>Big Image</p>
	                <img src='<c:url value="images/imageProduct/${PRODUCT.imageId.imageBig}"/>'>
	            </div>
	        </div>
        </c:if>
    </div>
    
   </div>
<script>
	$('#btnAddOrUpdateProduct').click(function (e) {
	    e.preventDefault();
	    var data = {};
	    var formData = $('#form-product').serializeArray();
	    $.each(formData, function (i, v) {
	        data[""+v.name+""] = v.value;
	    });
	    var productId = $('#productId').val();
	    if (productId == "") {
	        addProduct(data);
	    } else {
	        updateProduct(data);
	    }
	    
	});
	function addProduct(data) {
        $.ajax({
            url: '${APIAdminProduct}',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
            	window.location.href = "${PhoneURL}?type=edit&message=insert_success";
            },
            error: function (error) {
            	window.location.href = "${PhoneURL}?type=list&message=error_system";
            }
        });
    }
    function updateProduct(data) {
        $.ajax({
            url: '${APIAdminProduct}',
            type: 'PUT',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
            	window.location.href = "${PhoneURL}?type=edit&message=update_success";
            },
            error: function (error) {
            	window.location.href = "${PhoneURL}?type=list&message=error_system";
            }
        });
    }
</script>
</body>
</html>