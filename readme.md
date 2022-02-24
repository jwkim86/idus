# DB 구성
1) 최초 로그인을 위해 tableCreateScript.sql를 실행해 주세요. 
   스크립트에 최초 로그인 ID가 들어있습니다.
2) 리소스 폴더의 application.properties를 구성된 DB에 맞게 변경해주세요.
	idusread는 읽기전용, iduswrite는 쓰기전용 입니다.   
   
# IDE에서 실행
2) 메인 클래스 'com.jwkim.idus.IdusApplication'를 실행해 주세요.
2) http://localhost:8080/ 로 접속한후 로그인 합니다. id: admin, pw: test1314


# 커맨드라인 실행
1) runable jar를 얻기위해 gradle로 bootJar 테스크를 실행해 주세요. build.gradle은 프로젝트 root에 있습니다.
2) ${projectRoot}\build\libs 에 생성된 idus-0.0.1-SNAPSHOT.jar를 실행해 주세요. ex. $ java -jar idus-0.0.1-SNAPSHOT.jar
2) http://localhost:8080/ 로 접속한후 로그인 합니다. id: admin, pw: test1314