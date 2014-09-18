# Web Service Practice 1
---
## 들어가기 전에
* 다 할것은 아님
* http://bit.ly/ws-practice-1

## 이클립스 기본 활용
* 인디고(3.7) 이상 권장하지만 그냥 최신으로 깔자
* (추후 REST 서비스 개발 위해서) EE로 깔자
* 인코딩 설정
 * Eclipse.ini 수정
 * -Dfile.encoding=utf-8
*  기본적인 단축키
 * Content Assist ^ + Space
 * Delete Line ^ + D
 * Move Line @ + 화살표
 * Indent ^ + I
 * Git으로 소스 땡겨오기
* 실행 할 때 Argument 넣는 법

## 메이븐 활용법
* pom.xml
* 의존라이브러리 삽입
 * http://mvnrepository.com/
* Maven Clean 할 경우
 * eclipse:clean eclipse:eclipse

## XML Handling
### 읽어볼만한 자료
* http://sulemi.egloos.com/viewer/1133994
* http://blog.bagesoft.com/727
* http://www.w3schools.com/dom/default.asp

### XML 개념 간단요약!
* DOM VS SAX
* 우리는 DOM -> JDOM 사용
* JDOM은 자바 기본 라이브러리 아님
* 외부 라이브러리 받는 법은?

### JDOM2
* 실행 매개변수
 * ./xml/Employee.xml ./xml/Fruit.xml
* XML 파싱
* XML 파일 생성

## JSON Handling
* 의존 라이브러리 삽입 
 * https://github.com/FasterXML/jackson-core 
 * 참고
* http://arisu1000.tistory.com/27710
* http://stove99.tistory.com/12 
* 매개변수 추가 ./json/Employee.json ./json/Employee2.json ./json/Fruits.json
* ArrayList로 파싱
* Tree로 파싱
* Create JSON

## HTTP 라이브러리
* 의존 라이브러리 삽입
 * http://mvnrepository.com/artifact/org.glassfish.jersey.core
* https://jersey.java.net/documentation/latest/client.html
* TEST http://developer.naver.com/wiki/pages/News
* 간단한 방법
* 복잡하지만 유연한 방법
* XML파싱과 같이 실행해보자






