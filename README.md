# onboarding-back
> 백엔드 개발 온보딩 과제(Java)  
기간 : 2024.10.08 ~

### 요구사항
1. Spring Security를 이용한 로그인 / 회원가입 구현
    * 회원가입 - /signup
        * Request Message
           ```
           {
               "username": "JIN HO",
               "password": "12341234",
               "nickname": "Mentos"
           }
            ```
        * Response Message
           ```
           {
               "username": "JIN HO",
               "nickname": "Mentos",
               "authorities": [
                   {
                       "authorityName": "ROLE_USER"
                   }
               ]		
           }
           ```
        * 로그인 - /sign
            * Request Message
          ```
           {
              "username": "JIN HO",
              "password": "12341234"
           }
          ```
            * Response Message
          ```
           {
              "token": "eKDIkdfjoakIdkfjpekdkcjdkoIOdjOKJDFOlLDKFJKL"
           }
          ```
2. JWT 이용하기
3. Access / Refresh Token 발행과 검증에 관한 테스트 시나리오 작성
4. Junit을 이용한 JWT Unit 테스트 코드 작성
5. AWS EC2에 배포하기
6. Swagger UI로 접속 가능하게 하기
7. PR 사용하기
