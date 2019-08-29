# template_backend_springboot_001_mybatis_cloud
MyBatis - Springboot, Spring Security, MyBayis 기반 템플릿(Cloud Ver)

# 작업환경 설정
* Git 설치
* Java JDK 설치
* STS 설치

# 프로젝트 실행하기
## 소스 다운로드
* cmd창 혹은 git bash 혹은 에디터의 터미널 창을 열고 원하는 폴더 위치로 이동합니다.  
* 해당 폴더 위치에서 템플릿 프로젝트 GitHub에서 소스를 clone하여 다운 받습니다.  
  `git clone https://github.com/hitechinfo/template_backend_springboot_001_mybatis_cloud.git`
  * Tip) Git bash를 사용하셔도 좋지만 sourcetree 등과 같은 Git Client Tool을 사용하시면 소스를 관리하기 편리합니다.   
## 서버기동 방법
Application.java - 우클릭 - Spring Boot App
## Swagger URL
http://localhost:{Port}/swagger-ui.html#

# 사용방법 및 기능 설명
MainController.java 함수를 사용  
rest url 추가 할때마다 common/security/SecurityConfig.java 파일의 configure function에 해당 url 추가 (authorized)

## /main

MainTemplate  
get 호출 확인용

request : get  
reponse : 200, Hello World!-MainController-main  

## /data

MyBatisTemplate  
properties MariaDB로 설정, H2Runner run 메소드 내용 주석처리 후 테스트  
post 호출, MariaDB, Mybatis 확인용  

request : post  
response :  
{  
"rows":[  
{  
"TEST": "SUCCESS"  
}  
]  
}  

## /exception

ExceptionTemplate  
Custom exception 확인용  

request : post  
response :  
{  
"status": "BAD_REQUEST",  
"message": "Exception Test Error!"  
}
