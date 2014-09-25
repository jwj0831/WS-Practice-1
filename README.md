# 2014년 가을학기 Web Service 실습 1
---

# 실습조교: 조우진
# 메일주소: jwj0831@gmail.com
## 상세한 문의나 궁금한 점은 아래 온라인 구글 워드로 들어가서 이미지를 캡처하시거나 하시면 제가 보고 답변드리겠습니다. 최대한 소스코드를 받아서 각자 개인 개발환경에서 구동해 보시기를 권장합니다.
## http://bit.ly/ws-practice-board
 
---
## 들어가기 전에

* 다 할것은 아님
* http://bit.ly/ws-practice-1

## 실습 목표
* 개발환경 & 도구
* XML 파싱
* JSON 파싱
* HTTP 라이브러리 활용


### 이클립스 기본 활용
* http://eclipse.org/home/index.php
* 인디고(3.7) 이상 권장하지만 그냥 최신으로 깔자
* (추후 REST 서비스 개발 위해서) EE로 깔자
* 인코딩 설정
 * Eclipse.ini 수정
 * -Dfile.encoding=utf-8
 * (Heap 사이즈 조정)
* Java Project 생성
* 퍼스펙티브, 프로젝트 Properties(JDK, Heap Status)
* (생략) 기본적인 단축키
 * Content Assist Ctrl + Space
 * Delete Line Ctrl + D
 * Move Line Alt + 화살표
 * Indent Ctrl + I
 * Git으로 소스 땡겨오기
* 실행 할 때 Argument 넣는 법

### 메이븐 활용법
* http://maven.apache.org/
* Java 기반 프로젝트 빌드 도구 (Ant, Gradle..)
* http://tutorials.jenkov.com/maven/maven-tutorial.html
* 기존 프로젝트를 메이븐 기반으로 변경하기
 * Configure --> Convert to Maven Project
* pom.xml
* 의존라이브러리 삽입
 * http://mvnrepository.com/
 * http://mvnrepository.com/artifact/org.jdom/jdom2/2.0.5
* Maven Clean 할 경우
 * eclipse:clean eclipse:eclipse


### XML Handling
#### 읽어볼만한 자료
* http://sulemi.egloos.com/viewer/1133994
* http://blog.bagesoft.com/727
* http://www.w3schools.com/dom/default.asp

#### XML 개념 간단요약!
* DOM VS SAX
* 우리는 DOM -> JDOM 사용
* JDOM은 자바 기본 라이브러리 아님
* 외부 라이브러리 받는 법은?

#### JDOM2
* 실행 매개변수
 * ./xml/Employee.xml ./xml/Fruit.xml
* XML 파싱
* XML 파일 생성
* 직접 실습해보기 1
 * JDOM 의존 라이브러리 POM.xml 설정
 * xml 파일 옮기기
 * MyPracticeMain.java 생성
 * public static void parseXML(String filePath) 메서드 구현 

### JSON Handling
#### JSON 기본 개념
* http://json.org/json-ko.html
* http://ko.wikipedia.org/wiki/JSON
* JSON 이쁘게보기 
 * http://chris.photobooks.com/json/
 * http://www.jsoneditoronline.org/

#### Jackson JSON
* Google Image Search
 * jackson json performance comparison
 * http://rick-hightower.blogspot.kr/2014/04/new-json-serialization-benchmark.html
* 의존 라이브러리 삽입 
 * https://github.com/FasterXML/jackson-core 
* 참고: http://arisu1000.tistory.com/27710
* 참고: http://stove99.tistory.com/12 
* 매개변수 추가 ./json/Employee.json ./json/Employee2.json ./json/Fruits.json
* ArrayList로 파싱
* Tree로 파싱
* Create JSON
* 직접 실습해보기 2
 * Jackson JSON 의존 라이브러리 설정
 * Fruits.json 파일 옮기기
 * public static void parseJSON(String filePath) 메서드 구현 

### HTTP 라이브러리
* 의존 라이브러리 삽입
 * http://mvnrepository.com/artifact/org.glassfish.jersey.core
* https://jersey.java.net/documentation/latest/client.html
* TEST http://developer.naver.com/wiki/pages/News
* 간단한 방법
* 복잡하지만 유연한 방법
* XML파싱과 같이 실행해보자
* 직접 실습해 보기 3
 * http://www.w3schools.com/xml/simple.xml
 * http://www.w3schools.com/xml/plant_catalog.xml
 * public static void getHTTP(String domain, String path) 메서드 구현
 * xml 파싱과 연계실습까지! 






