[Spring] 도서 관리 API

목표 : Spring Boot로 기본적인 CRUD REST API 구현

사전 준비
JDK 17 이상 설치
IntelliJ IDEA 또는 VS Code + Spring 확장 설치
Spring Initializr(https://start.spring.io)에서 프로젝트 생성
Dependencies: Spring Web, Spring Data JPA, H2 Database

요구사항
도서(Book) 엔티티 구성
id : Long (자동 생성)
title : String (도서 제목)
author : String (저자)
isbn : String (ISBN)
publishedDate : LocalDate (출판일)

API 엔드포인트:
GET /api/books : 전체 도서 목록 조회
GET /api/books/{id} : 특정 도서 조회
POST /api/books : 도서 추가
PUT /api/books/{id} : 도서 정보 수정
DELETE /api/books/{id} : 도서 삭제
프로젝트 구조src/main/java/com/example/bookapi/ <br/>
├── controller/ <br/>
│   └── BookController.java <br/>
├── service/ <br/>
│   └── BookService.java <br/>
├── repository/ <br/>
│   └── BookRepository.java <br/>
├── entity/ <br/>
│   └── Book.java <br/>
└── BookApiApplication.java <br/>

관련 학습 내용
Spring Boot 기본 구조
Controller, Service, Repository 패턴
JPA 기본 CRUD
테스트 방법
Postman 또는 curl을 사용하여 API 테스트
H2 Console(http://localhost:8080/h2-console)에서 데이터 확인

제출물
GitHub 저장소 링크
Postman 테스트 결과 캡처 또는 API 테스트 문서
학습 문서
