# 구현 기능
- [ ]  게시글 작성 기능
    - `제목`, `작성자명`, `비밀번호`, `작성 내용`, `작성일`을 저장할 수 있습니다.
    - 저장된 게시글의 정보를 반환 받아 확인할 수 있습니다.
        - 반환 받은 게시글의 정보에 `비밀번호`는 제외 되어있습니다.
- [ ]  선택한 게시글 조회 기능
    - 선택한 게시글의 정보를 조회할 수 있습니다.
        - 반환 받은 게시글의 정보에 `비밀번호`는 제외 되어있습니다.
- [ ]  게시글 목록 조회 기능
    - 등록된 게시글 전체를 조회할 수 있습니다.
        - 반환 받은 게시글의 정보에 `비밀번호`는 제외 되어있습니다.
    - 조회된 게시글 목록은 작성일 기준 내림차순으로 정렬 되어있습니다.
- [ ]  선택한 게시글 수정 기능
    - 선택한 게시글의 `제목`, `작성자명`, `작성 내용`을 수정할 수 있습니다.
        - 서버에 게시글 수정을 요청할 때 `비밀번호`를 함께 전달합니다.
        - 선택한 게시글의 `비밀번호`와 요청할 때 함께 보낸 `비밀번호`가 일치할 경우에만 수정이 가능합니다.
    - 수정된 게시글의 정보를 반환 받아 확인할 수 있습니다.
        - 반환 받은 게시글의 정보에 `비밀번호`는 제외 되어있습니다.
- [ ]  선택한 게시글 삭제 기능
    - 선택한 게시글을 삭제할 수 있습니다.
        - 서버에 게시글 삭제를 요청할 때 `비밀번호`를 함께 전달합니다.
        - 선택한 게시글의 `비밀번호`와 요청할 때 함께 보낸 `비밀번호`가 일치할 경우에만 삭제가 가능합니다.

# Use Case Diagram
[![image](https://github.com/Seungmi97/spring-lv1/assets/132995507/dbe7e22c-60ee-471d-9ffa-9a22b11f95f7)](https://raw.githubusercontent.com/Seungmi97/spring-lv1/0ea7e0b4e83ca10f98667eeb410c845d014f3d9b/Use%20Case%20Diagram.svg)


# API 설계

| **기능** | **Method** | **URL** | **request** | **response** |
| --- | --- | --- | --- | --- |
| 게시글 작성 | POST | /api/post | {'title':title,  <br>'author':author,  <br>'password':password,  <br>'contents':contents} | {'id':id,  <br>'title':title,  <br>'author':author,  <br>'contents':contents,  <br>'createdAt':createdAt} |
| 선택한 게시글 조회 | GET | /api/post/{id} | {'id':id} | {'id':id,  <br>'title':title,  <br>'author':author,  <br>'contents':contents,  <br>'createdAt':createdAt} |
| 게시글 목록 조회 | GET | /api/post |  | 리스트 |
| 선택한 게시글 수정 | PUT | /api/post/{id} | {'id':id,  <br>'title':title,  <br>'author':author,  <br>'contents':contents,  <br>'password':password} | {'id':id,  <br>'title':title,  <br>'author':author,  <br>'contents':contents,  <br>'createdAt':createdAt} |
| 선택한 게시글 삭제 | DELETE | /api/post/{id} | {'id':id,  <br>'password':password} | {'id':id} |

# ERD
![image](https://raw.githubusercontent.com/Seungmi97/spring-lv1/bd5ea16d7b604f6fd6d39466b72cf578d775a995/ERD.svg)
