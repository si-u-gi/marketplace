# marketplace
물건을 사고 팔 수 있는 사이트입니다.

빌드, 실행하는 법
./gradlew clean build
cd build/libs
java -jar marketplace-0.0.1-SNAPSHOT.jar

h2 DB 실행하는 법
cd ~/h2
./h2.sh
jdbc:h2:tcp://localhost/~/test

:8080 오류 생기면
applicaion.properties에 server.forward-headers-strategy=framework 추가