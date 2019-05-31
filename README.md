# template_backend_springboot_001
Springboot, Spring Security, JPA 기반 템플릿

# 서버기동
Application.java - 우클릭 - Spring Boot App

# 사용법
MainController.java 함수를 이용

## /main

MainTemplate
get 호출 확인용

request : get
reponse : 200, Hello World!-MainController-main

## /auth

AuthTemplate
post 호출, JPA save 확인용

request : post
body 내용 :
{
"TEMPLATE_USER_ID" : "authAdmin",
"TEMPLATE_USER_PW" : "authAdmin",
"TEMPLATE_USER_TYPE" : "authAdmin"
}
response : 
"username": "authAdmin",
"authorities":[
{
"authority": "authAdmin"
}
],

## /data

MyBatisTemplate
properties MariaDB로 설정, H2Runner run 메소드 내용 주석처리 후 테스트
post 호출, MariaDB, Mybatis 확인용

```/data```
respon~~~
"TEST": "SUCCESS"

## /datajpa
post 호출, JPA find 확인용

## /exception
Custom exception 확인용
