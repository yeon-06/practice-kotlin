# 자동차 경주 게임

> 요구사항은 우테코 4기 때 진행한 자동차 경주 게임(Java)를 참고했습니다.

<br/>

### 구현할 기능 리스트

입력 관련

- [x] 자동차 목록 생성
    - 자동차 이름 목록은 쉼표로 구분해서 입력 받음  
      (ex: 자동차1,자동차2,자동차3)
    - 이름 중복 불가능
    - 5자 이하
    - 빈 값, 공백 불가능
- [x] 레이싱 시도 횟수
    - 0 이상의 자연수만 입력 가능

게임 진행

- [x] 랜덤값 생성 (0 <= 랜덤값 < 10)
- [x] 랜덤값이 4 이상이면 자동차 전진
- [x] 매 시도마다 진행 상태 출력

게임 결과

- [x] 우승자 계산
    - 가장 많은 거리를 이동한 자동차가 우승
    - 공동 우승 가능
- [x] 우승자 출력
    - 공동 우승은 ,로 구분해 출력  
      (ex: ㅇㅇ, ㅁㅁ가 최종 우승했습니다.)

<br/>

### 기능 요구사항

- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4 이상일 경우 전진하고, 3 이하의 값이면 멈춘다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.

<br/>

### 출력 예제

```
경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).
pobi,crong,honux
시도할 회수는 몇회인가요?
5
실행 결과
pobi : -
crong : -
honux : -
pobi : --
crong : -
honux : --
pobi : ---
crong : --
honux : ---
pobi : ----
crong : ---
honux : ----
pobi : -----
crong : ----
honux : -----
pobi : -----
crong : ----
honux : -----
pobi, honux가 최종 우승했습니다.
```
