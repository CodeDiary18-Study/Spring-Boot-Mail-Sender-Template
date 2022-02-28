# Spring Boot Mail Sender Template
Spring Boot로 **이메일 전송 기능** 구현  
<br><br>  

## Development Environment
- OS : Windows
- IDE : IntelliJ IDEA Ultimate
- Language : Java 8(openjdk 1.8)
- Framework : Spring Boot
- Build Tool : Gradle
- WAS : Apache Tomcat 9.0.56
<br><br>  
  
## API Introduction
- 메일 전송
  - **URL** : ```/mail/send```
  - **Method** : POST
  - **Request**
    - **Content-Type** : application/json
    - **Body**
      | Name | Type | Mandatory | Example | Description |
      | :---: | :---: | :---: | :----: | :------------: |
      | toAddress | String | Y | test@gmail.com | 메일 받을 이메일 주소 |
      | title | String | Y | 제목 | 메일 제목 |
      | content | String | Y | 내용 | 메일 본문 |

      - example
        ```json
        {
          "toAddress":"test@gmail.com",
          "title":"제목",
          "content":"내용"
        }
        ```
  - **Response**
    - **Content-Type** : application/json
    - **Body**
      | Name | Type | Mandatory | Example | Description |
      | :---: | :---: | :---: | :----: | :------------: |
      | isSuccess | Boolean | Y | true | 요청 성공 여부 |
      | message | Object | Y | 메일 전송에 성공했습니다! | 요청 처리 결과 관련 메시지 |
        
      - example  
        ▷ success case  
        ```json
        {
          "isSuccess" : true,
          "message" : "메일 전송에 성공했습니다!"
        }
        ```  
        ▷ fail case
        ```json
        {
          "isSuccess" : false,
          "message" : "이메일 전송하는 과정에서 문제가 발생했습니다."
        }
        ```  
        ```json
        {
          "isSuccess": false,
          "message":
          {
            "toAddress": "올바른 형식의 이메일 주소여야 합니다",
            "content": "공백일 수 없습니다"
          }
        }
        ```  
