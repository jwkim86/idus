- 회원 가입 : 									post /user/{id}
- 회원 로그인(인증) : 							post /login
- 회원 로그아웃 : 								post /logout

- 단일 회원 상세 정보 조회 : 						get /user/{id}
- 단일 회원의 주문 목록 조회 : 					get /user/{id}/order
- 여러 회원 목록 조회 : 							get /user ?start= ,pageSize=, name= ,email=
    - 페이지네이션으로 일정 단위로 조회합니다.			
    - 이름, 이메일을 이용하여 검색 기능이 필요합니다.	
    - 각 회원의 마지막 주문 정보			


http://localhost:8080/swagger-ui.html