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


자바 17 설치 방법

설치:
sudo apt update
sudo apt install openjdk-17-jdk

경로 설정:
export JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64
export PATH=$JAVA_HOME/bin:$PATH

확인:
java -version
javac -version
./gradlew -version



nano ~/.bashrc

맨 아래에 추가
export JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64
export PATH=$JAVA_HOME/bin:$PATH
3️⃣ 적용
source ~/.bashrc

