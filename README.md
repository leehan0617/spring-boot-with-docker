# spring-boot-with-docker

- Language: Java (11)
- Build: Gradle (6.3)
- Container: Docker (19.03.8)
- Framework: SpringBoot (2.3.4.RELEASE)

* 목표: Docker를 활용해서 스프링 서버를 실행해보자.<br>

1. build 설정
    - build.gradle 설정
    - build.gradle에서 중요한것은 bootJar이라는 task를 사용하기 위해 spring boot 관련 플러그인 설정을 꼭 해야한다.
    
2. Dockerfile 설정
    - 특별한 내용은 없고 Dockerfile을 확인해 jar 파일명 및 포트 설정

3. jar 파일 생성
    - bootJar task를 실행한다. (낮은 gradle 버전에서는 작동안하니 버전 체크.)
    - 정상적으로 작동했다면, build 디렉토리에 libs 디렉토리안에 jar파일이 생성된걸 확인.
 
4. Docker Image 생성
    - 터미널에서 <code> docker image build -t 'spring-boot-example:0.1' '.' </code> 실행
    - spring-boot-example은 docker image 목록에 보여질 이름이고, 0.1은 버전관리를 위한 tag 이다. (사용자 임의로 설정)
    - 뒤에 '.'은 Dockerfile 경로이다. (위 코드는 Dockerfile이 있는 위치에서 실행한 명령어)
    - 정상적으로 실행했다면 <code> docker images </code> 실행뒤 image 이름 및 tag가 노출되면 정상.
    
5. Docker 실행
    - <code> docker run -p 10625:10625 spring-boot-example</code> 실행
    - 포트 설정은 유동적으로 한다. (앞에 부분이 외부접속 포트, 뒷부분을 수정하려면 Dockerfile을 수정) 
    - (주의) <code>-p 10625:10625</code> 이 명령어를 생략하면 default로 바인딩 될거 같지만 안되므로 꼭 사용하자.
    - 정상적으로 실행된 여부는 <code>docker ps</code> 명령어로 현재 실행중인 container 목록을 확인하면 된다. 

* 서버 내에서 외부 통신이 필요한 경우 with/mysql 브랜치를 참고 (mysql 연동예제 작성)