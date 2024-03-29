<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>    

<%@ include file="../includes/header.jsp" %>
	<style>
		.btn-primary{background:orange;border:orange !important;}
	</style>

	<div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">Board</h1>
        </div>
        <!-- /.col-lg-12 -->
    </div>
    <!-- /.row -->
    
    <div class="row">
         <div class="col-lg-12">
             <div class="panel panel-default">
                 <div class="panel-heading">
                     Modify
                 </div>
                 <!-- /.panel-heading -->
                 <div class="panel-body">
                 
	                 <form action="/board/modify" method="post">
	                    <div class="form-group">
	                    	<lable>no</lable>
	                    	<input class="form-control" name="bno" value='<c:out value="${board.bno}"/>' readonly>
	                    </div> 
	                   	<div class="form-group">
	                   		<label>Title</label>
	                   		<input class="form-control" name="title" value='<c:out value="${board.title}"/>'>
	                   	</div>
	                   	<div class="form-group">
	                   		<label>Content</label>
	                   		<textarea class="form-control" rows="10" name="content"><c:out value="${board.content}"/></textarea>
	                   	</div>
	                   	<div class="form-group">
	                   		<label>Writer</label>
	                   		<input class="form-control" name="writer" value='<c:out value="${board.writer}"/>'>
	                   	</div>
	                   	<div class="form-group">
	                   		<label>RegDate</label>
	                   		<input class="form-control" name="regDate" value='<fmt:formatDate pattern="yyyy/MM/dd" value="${board.regdate}" />' readonly>
	                   	</div>
	                    <div class="form-group">
	                   		<label>updateDate</label>
	                   		<input class="form-control" name="updateDate" value='<fmt:formatDate pattern="yyyy/MM/dd" value="${board.updateDate}" />' readonly>
	                   	</div>
	                   	
	                   	<button data-oper="modify" class="btn btn-default btn-primary">Modify</button>
	                   	<button data-oper='remove' class="btn btn-default btn-primary">Delete</button>                   	
	                   	<button data-oper="list" class="btn btn-default btn-primary">List</button>                   	
                   	</form>
                    
                 </div>
                 <!-- /.panel-body -->
             </div>
             <!-- /.panel -->
         </div>
         <!-- /.col-lg-12 -->
     </div>
    
    <script>
    	$(document).ready(function(){
    		var formOBj=$("form") // 먼저 form 태그 찾기
    		$("button").on("click", function(e){
    			e.preventDefault(); // 기본값이 submit이기 때문에, 누르면 바로 전송됨.
    			//하지만 modify,remove,list 기능에 따라 달리 작동해야하기 때문에,
    			//일단 전송이 바로 안되게 막는 preventDefault()코드를 사용함 
    			var operation=$(this).data("oper");
    			console.log(operation); // data-oper값이 정상적으로 들어오는 지 확인하고자, 콘솔로그로 확인
    			return;
    			if(operation==='remove'){
    				formObj.attr("action","/board/remove"); // 삭제처리
    			}else if(operation==='list'){
    				formObj.attr("action","/board/list").attr("method","get"); // 목록으로
    				// 28라인을 보면 post로 보내고 있음. 따라서, 한번 더 바꿔줘서 78라인 코드에서 .attr코드를 써서, method를 get으로 갈 수 있게끔 바꿔줌
    				
    				//hidden 태그를 복제해 둔다.
    				var pageNumTag=$("input[name='pageNum']").clone();
    				var amountTag=$("input[name='amount']").clone();
    				var keywordTag=$("input[name='keyword']").clone();
    				var typeTag=$("input[name='type']").clone();
    				
    				//form태그의 모든 태그를 삭제한다.
    				formObj.empty();
    				
    				//form태그에 복제해 둔 hidden태그를 다시 추가
    				formObj.append(pageNumTag);
    				formObj.append(amountTag);
    				formObj.append(keywordTag);
    				formObj.append(typeTag);
    			}
    			formObj.submit(); // 전송
    		});
    	})
    </script>

<%@ include file="../includes/footer.jsp" %>