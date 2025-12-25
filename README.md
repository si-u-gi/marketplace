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


----------------------------------------------------------------------


2025/11/24
    return "/upload/" + filename; + WebConfig.java에 대해 공부

    
    상품을 누르면 상품의 상세 정보와 리뷰를 작성할 수 있는 페이지 만들기
    상품 등록할 때 "기준년도"라는 항목 만들어서 사진이 언제 추억인지 날짜 넣기
    리뷰 테이블 만들어서 연동하기
    정렬 만들기(인기순, 가격순 등등)
    장바구니, 구매 만들기

    만약 앱으로 만든다면
        1년을 기준으로 같은 날짜에 추억을 띄워주는 서비스 제공.