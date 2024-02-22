//line 6의 (function(){})(); 은 즉시실행함수
//function(){}는 본래 이름 없으면 호출 불가.
//다만, function 전체를 괄호로 묶으면 호출이 가능. 이를 익명함수 or 즉시실행함수라고 함
//ex) (function(){})(); 이런 식... 자기를 ()로 묶고, 자기 스스로를 호출하는 ();를 끝에 추가하면 됨.

var replyService=(function(){
	function add(reply, callback, error){
		
		$.ajax({
			type : 'post', // 전송방식
			url : '/replies/new', // 서버 주소
			data : JSON.stringify(reply), // (reply)를 작성하면 이것을 JSON형태로 전송하겠다.
			contentType : "application/json; charset=utf-8", // 서버로 전송되는 데이터의 형식
			success : function(result, status, xhr) {
				// 성공했을 때 할 일. 외부에서 함수로 정의한 후, 함수의 이름을 callback에 전달
				if (callback) { 
					callback(result); // 함수 호출
				}
			},
			error : function(xhr, status, er) {
				// 에러났을 때 할 일. 외부에서 함수로 정의한 후, 함수의 이름을 error에 전달. 여기선 사용X
				if (error) {
					error(er); //함수호출
				}
			}
		})
	
	}
	
	function getList(param, callback, error){
		var bno = param.bno;
		var page = param.page || -1;
		
	    $.getJSON("/replies/pages/" + bno + "/" + page + ".json", function(data) {
	          if (callback) {
	            callback(data.replyCnt, data.list); //댓글 숫자와 목록을 가져오는 경우 
	          }
        }).fail(function(xhr, status, err) {
	      if (error) {
	        error();
	      }
	    });
	}
	
	function displayTime(timeValue){
		var today = new Date(); // 현재 날짜시간
		var gap = today.getTime() - timeValue; // 현재시간 - 작성시간 = 갭
		var dateObj = new Date(timeValue); // 작성일을 date형식으로 변환
		var str = "";
		
		//gap(작성한 지)이 24시간 미만이면 시:분:초 형식으로 출력
		if (gap < (1000 * 60 * 60 * 24)) {
			var hh = dateObj.getHours();
			var mi = dateObj.getMinutes();
			var ss = dateObj.getSeconds();

			return [ (hh > 9 ? '' : '0') + hh, ':', (mi > 9 ? '' : '0') + mi,
					':', (ss > 9 ? '' : '0') + ss ].join(''); // .join('') -> 배열의 요소를 전부 연결해주는 함수. []안에 있는 배열 값을 나열해주는 역할.

		} else {
			var yy = dateObj.getFullYear();
			var mm = dateObj.getMonth() + 1; // getMonth() is zero-based
			var dd = dateObj.getDate();

			return [ yy, '/', (mm > 9 ? '' : '0') + mm, '/',
					(dd > 9 ? '' : '0') + dd ].join('');
		}		
	}
	
	function get(rno, callback, error){
		$.get("/replies/" + rno + ".json", function(result) {

			if (callback) {
				callback(result);
			}

		}).fail(function(xhr, status, err) {
			if (error) {
				error();
			}
		});	
	}
	
	function update(reply, callback, error) {
		$.ajax({
			type : 'put',
			url : '/replies/' + reply.rno,
			data : JSON.stringify(reply),
			contentType : "application/json; charset=utf-8",
			success : function(result, status, xhr) {
				// 성공했을 때 할 일. 외부에서 함수로 정의한 후, 함수의 이름을 callback에 전달
				if (callback) {
					callback(result);
				}
			},
			error : function(xhr, status, er) {
			// 에러났을 때 할 일. 외부에서 함수로 정의한 후, 함수의 이름을 error에 전달. 여기선 사용X			
				if (error) {
					error(er);
				}
			}
		});
	}
	
	function remove(rno, callback, error) {
		$.ajax({
			type : 'delete', // 전송 방식
			url : '/replies/' + rno, // 서버 주소
			success : function(deleteResult, status, xhr) {
				// 성공했을 때 할 일. 외부에서 함수로 정의한 후, 함수의 이름을 callback에 전달
				if (callback) {
					callback(deleteResult);
				}
			},
			error : function(xhr, status, er) {
			// 에러났을 때 할 일. 외부에서 함수로 정의한 후, 함수의 이름을 error에 전달. 여기선 사용X			
				if (error) {
					error(er);
				}
			}
		});
	}
	
	return{ // 객체를 리턴
		add:add,
		getList:getList,
		displayTime:displayTime,
		get:get,
		update:update,
		remove:remove
	}; 
})();