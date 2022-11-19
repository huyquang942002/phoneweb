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
                    IMAGE
            </div><!-- /.page-header -->
            <div class="form__wapper form__wapper-user-add">
            <c:if test="${not empty messageResponse}">
				<div class="alert alert-${alert}">
							${messageResponse}
				</div>
			</c:if>
                <form class="form" id="form-image" action='<c:url value="/admin-image" />' method="post" enctype="multipart/form-data">
                    <c:if test="${not empty IMAGE}">
	                    <div class="form-item select ">
	                        <label>Product</label>
		                    <select id="productId" name="productId">
		                        <c:if test="${empty IMAGE}">
	                              	<option>Choose one</option>
							        <c:forEach var="item" items="${PRODUCT}">									
										<option value="${item.productId}">${item.productId} - ${item.productName}</option>										
									</c:forEach>
	                               </c:if>
	                               
	                               <c:if test="${not empty IMAGE}">
	                                    <c:forEach var="item" items="${PRODUCT}">
											<c:if test="${item.imageId.imageId == IMAGE.imageId}">									
												<option value="${item.productId}">${item.productId} - ${item.productName}</option>	
											</c:if>									
										</c:forEach>	
										<c:forEach var="item" items="${PRODUCT}">
											<c:if test="${item.imageId.imageId != IMAGE.imageId}">									
												<option value="${item.productId}">${item.productId} - ${item.productName}</option>		
											</c:if>									
										</c:forEach>
	                              </c:if>
		                    </select>
	                    </div>
                    </c:if>
                    <div class="form-item">
                        <label for="imageBig">Big Image</label>
                    	<input type="file" name="imageBig" id="imageBig">
                    </div>
                    
                    <div class="form-item">
                        <label for="imageSmall">Small Image</label>
                    	<input type="file" name="imageSmall" id="imageSmall">
                    </div>
                    
                    <div class="form-item">
                        
                        <c:if test="${not empty IMAGE}">
                        	<button class="form-btn" type="submit" value="Update">Update</button>                     
                        </c:if>
                        <c:if test="${empty IMAGE}">
                        	<button class="form-btn" type="submit" value="Add">Add</button>
                        </c:if>
                    </div>
                    <input type="hidden" value="${IMAGE.imageId}" id="imageId" name="imageId"/>
                </form>
            </div>
            
        </div>
        <c:if test="${not empty IMAGE.imageId}">
	        <div class="image">
	        	<div class="img_small">
	                <p>Small Image</p>
	                <img src='<c:url value="images/imageProduct/${IMAGE.imageSmall}"/>' alt="">
	            </div>
	            <div class="img_big">
	                <p>Big Image</p>
	                <img src='<c:url value="images/imageProduct/${IMAGE.imageBig}"/>'>
	            </div>
	        </div>
        </c:if>
    </div>
</div>
</body>
</html>