# hanghaeW3Assignment

Blog 라는스프링 프로젝트에는 크게 3가지 layer 가 존재합니다: client 의 request 를 받는 controller, controller 의 request 를 실행하는 service, 그리고 DB 에 데이터를 작성/수정/삭제 하는 repository layer 가 있습니다. 각 layer 끼리 소통할때는 PostRequestDto 또는 PasswordRequestDto 를 사용해, 직접적인 파라미터를 전달하는 일이 없도록 하였습니다. 그리고 Dto (Data Transfer Object) 를 사용하여, 여러 파라미터 (title, author, password) 를 한번에 전달할수 있어서, 코드가 훨씬 간단하게 구현할수 있었습니다. 제 코드에서의 Bean 은 @RestController, @Service, @AllArgsConstructor 등을 사용하였습니다.

밑에는 제가 구현한 API 명세서입니다. 4번째 칼럼에는 Response 대신, 자바에서 반환하는 return type 을 적어, 입문자분들이 보고 간편하게 이해할수 있게 명세서를 작성하였습니다.

| Method | URL | Request | Return Type |
| --- | --- | --- | --- |
| GET | /api/posts | - | List of Posts |
| POST | /api/write | { "title":title, "author":author, "password":password } | Post |
| GET | /api/posts/{id} | - | Post  |
| POST | api/posts/{id} | {"password":password} | Boolean |
| PUT | api/posts/{id} | { "title":title, "author":author, "password":password } | Long |
| DELETE | api/posts/{id} | - | Long |
