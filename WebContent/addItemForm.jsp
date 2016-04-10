<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>  
<jsp:include page="loginCheck.jsp" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <title>Add Item | ebay </title>
      <script type="text/javascript">
         function goBack() {
             window.history.back();
         }
      </script>
      <style type="text/css">
         .errorMessage {
         font-weight: light;
         color: red;
         }
         .body {
         background-color: GhostWhite ;
         }
         .h3{
         font-weight:bold;
         color:grey	;
         }
         .sell{
         color:GhostWhite;
         }
         .h4{
         font-weight:bold;
         color:grey;
         }
         .h2{
         font-weight:bold;
         color:GhostWhite;
         }   
         .banner{
         width:100%;
         max-height:300px;
         }
         .jumbotron{
         background-color: DodgerBlue ;
         }
      </style>
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
      <script src="bootstrap/js/bootstrap.min.js"></script>
      <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
      <link href="bootstrap/css/owl.theme.css" rel="stylesheet" media="screen">
      <link href="bootstrap/css/owl.carousel.css" rel="stylesheet" media="screen">
      <script src="bootstrap/js/owl.carousel.js"></script>
      <script src="bootstrap/js/owl.carousel.min.js"></script>
      <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
      
  <link rel="stylesheet" href="https://code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
  <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
  <script src="https://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
  
      <script>
  $(document).ready(function(){
	  $("#start").prop('disabled',true);
      $("#end").prop('disabled',true);
      $("#cost").prop('disabled',true);
      $("#other").prop('disabled',true);
	    $('#add').on('change', function() {
	      if ( this.value == 'Y')
	      {
	        $("#start").removeAttr('disabled');
	        $("#end").removeAttr('disabled');
	        $("#cost").removeAttr('disabled');
	      }
	      else
	      {
	    	  $("#start").prop('disabled',true);
	        $("#end").prop('disabled',true);
	        $("#cost").prop('disabled',true);
	      }
	    });
	    $('#color').on('change', function() {
		      if ( this.value == 'others')
		      {
		        $("#othercolor").removeAttr('disabled');
		      }
		      else
		      {
		    	  $("#othercolor").prop('disabled',true);
		      }
		    });
	});

  
  </script>
   </head>
   <body>
      <div class="container">
         <s:action name="test" executeResult="true" />
         <br><br><br><br>
         <div class="col-sm-10">
            <div class="jumbotron">
               <h3>Add your item here</h3>
            </div>
            <hr>
            <div class="well">
               <s:form action="addItem" align="center" method="post"  enctype="multipart/form-data" style="text-align:right">
                  <table>
                     <tr>
                        <td>Item Id: </td>
                        <td>
                           <div class="col-sm-10">
                              <s:textfield id="itemId" name="itemId" disable="true" placeholder="Enter Item Id"/>
                           </div>
                           <s:fielderror>
                              <s:param>itemId</s:param>
                           </s:fielderror>
                        </td>
                     </tr>
                     <tr>
                        <td>Item Name: </td>
                        <td>
                           <div class="col-sm-10">
                              <s:textfield id="itemName" name="itemName" placeholder="Enter Item Name"/>
                           </div>
                           <s:fielderror>
                              <s:param>itemName</s:param>
                           </s:fielderror>
                        </td>
                     </tr>
                     <tr>
                        <td>Item Description: </td>
                        <td>
                           <div class="col-sm-10">
                              <s:textfield id="itemDesc" name="itemDesc" label="Item Description " placeholder="Enter Item Description"/>
                           </div>
                           <s:fielderror>
                              <s:param>itemDesc</s:param>
                           </s:fielderror>
                        </td>
                     </tr>
                     <tr>
                        <td>Picture: </td>
                        <td>
                           <s:file id="pic" label ="pic" name="pic"/>
                        </td>
                     </tr>
                     <tr>
                        <td>Seller Id: </td>
                        <td>
                           <div class="col-sm-10">
                              <s:textfield id="sellerId" label ="Seller Id" name="sellerId" placeholder="Enter Seller Id"/>
                           </div>
                           <s:fielderror>
                              <s:param>sellerId</s:param>
                           </s:fielderror>
                        </td>
                     </tr>
                     <tr>
                        <td>Quantity: </td>
                        <td>
                           <div class="col-sm-10">
                              <s:textfield placeholder="Enter Quantity" id="quantity" name="quantity"/>
                           </div>
                           <s:fielderror>
                              <s:param>sellerId</s:param>
                           </s:fielderror>
                        </td>
                     </tr>
                     <tr>
                        <td>Price: </td>
                        <td>
                           <div class="col-sm-10">
                              <s:textfield label ="Price" id="price" name="price" placeholder="Enter price"/>
                           </div>
                           <s:fielderror>
                              <s:param>price</s:param>
                           </s:fielderror>
                        </td>
                     </tr>
                     <tr>
                        <td>Advertising Item : </td>
                        <td>
                           <div class="col-sm-10">
                              <s:select label="AdvertisingItem" id="add"
		headerKey="-1" headerValue="select advertisement"
		list="#{'Y':'Yes', 'N':'No'}" 
		key="advCheck" 
		value="N" />
                           </div>
                        </td>
                     </tr>
                      <tr>
                        <td>Start Date </td>
                        <td>
                           <div class="col-sm-10">
                              <s:textfield name="startDate" id="start" placeholder="Start Date" cssClass="datepicker"/>
                           </div>
                        </td>
                     </tr>
                      <tr>
                        <td>End Date </td>
                        <td>
                           <div class="col-sm-10">
                              <s:textfield name="endDate" id="end" placeholder="End Date" cssClass="datepicker"/>
                           </div>
                        </td>
                     </tr>
                      <tr>
                        <td>Advertisement Cost </td>
                        <td>
                           <div class="col-sm-10">
                              <s:textfield name="adv_Cost" id="cost" placeholder="Adv Cost"/>
                           </div>
                        </td>
                     </tr>
                     <tr>
                        <td> Category</td>
                        <td>
                           <s:select list="categoryList" id="categoryId" name="categoryId"
                              listValue="catName" listKey="catId"
                              headerKey="0" headerValue="Select Category "  onChange="changeIt(this)"
                              ></s:select>
                           <script type="text/javascript">
                              $(document).ready(function() {
                              	   $('#categoryId').change(function(event) {
                              	          var categories = $("select#categoryId").val();
                              	          $.getJSON('ajaxAction', {
                              	            categoryName : categories
                              	          }, function(jsonResponse) {
                              	            var select = $('#subCatId');
                              	            select.find('option').remove();
                              	            $.each(jsonResponse.subCategoryMap, function(key, value) {
                              	              $('<option>').val(key).text(value).appendTo(select);
                              	            }
                              	            );
                              	          });
                              	         })
                              });
                              
                              
                              	
                           </script>			    
                           <!--<s:fielderror>
                              <s:param>item</s:param>
                              </s:fielderror>-->
                        </td>
                     </tr>
                     <tr>
                        <td>Sub Category: </td>
                        <td>
                           <div class="col-sm-10">
                              <s:select list="subCatList" name="subCatId" id="subCatId"
                                 listKey="key" listValue="value" 
                                 headerKey="0" headerValue="Select Sub Category"></s:select>
                           </div>
                        </td>
                     </tr>
                     <tr>
                        <td>Additional Field 1: </td>
                        <td>
                           <div class="col-sm-10">
                              <s:textfield name="addField1" id="addField1" placeholder="Additional Field 1"/>
                           </div>
                        </td>
                     </tr>
                     <tr>
                        <td>Additional Field 2: </td>
                        <td>
                           <div class="col-sm-10">
                              <s:textfield name="addField2" id="addField2" placeholder="Additional Field 2"/>
                           </div>
                        </td>
                     </tr>
                     <tr>
                        <td>Deal:</td>
                        <td>
                           <div class="col-sm-10">
                              <s:select name="dealCheck"  label="Deal?" id="dealFlag" 
                                 headerKey="0" headerValue="Is it Deal"
                                 list="#{'Y':'Yes', 'N':'No'}" />
                                 
                           </div>
                        </td>
                     </tr>
                     <tr>
                        <td>Discount: </td>
                        <td>
                           <div class="col-sm-10">
                              <s:textfield name="discount" placeholder="Discount"/>
                           </div>
                        </td>
                     </tr>
                     
                     <tr>
                        <td>Expiry On </td>
                        <td>
                           <div class="col-sm-10">
                              <s:textfield name="expireOn" id="expireOn" placeholder="expireOn"/>
                           </div>
                        </td>
                     </tr>
                     <tr>
                        <td>Warranty </td>
                        <td>
                           <div class="col-sm-10">
                              <s:textfield name="warranty" id="warranty" placeholder="Warranty Period"/>
                           </div>
                        </td>
                     </tr>
                     <tr>
                        <td>Color </td>
                        <td>
                           <div class="col-sm-10">
                              <s:select name="color" id="color" label="select color" 
                                 headerKey="0" headerValue="Select color"
                                 list="colorItem" value="others"/>
                           </div>
                        </td>
                     </tr>
                     <tr>
                        <td>Weight </td>
                        <td>
                           <div class="col-sm-10">
                              <s:textfield name="weight" id="weight" placeholder="weight"/>
                           </div>
                        </td>
                     </tr>
                     <tr>
                        <td>Brand </td>
                        <td>
                           <div class="col-sm-10">
                             <s:select name="brand"  id="brandFlag" 
                                 headerKey="0" headerValue="Select Brand"
                                 list="#{'Reebook':'Reebok','Nike':'Nike','Titan':'Titan','Mufti':'Mufti'}" />
                           </div>
                        </td>
                     </tr>
                     <tr>
                        <td>Condition of Item </td>
                        <td>
                           <div class="col-sm-10">
                              <s:textfield name="condition" id="condition" placeholder="Condition of item"/>
                           </div>
                        </td>
                     </tr>
                  </table>
                  <div align="center">
                     <br>
                     <input type="button" value="Previous" class="btn btn-primary" onclick="goBack()"/>
                     <s:submit value="Submit" action="addItem" class="btn btn-primary"></s:submit>
                     <s:submit value="Home" action="homePageAction" class="btn btn-primary"></s:submit>
                  </div>
               </s:form>
            </div>
         </div>
      </div>
   </body>
</html>