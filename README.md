# 🃏 블랙잭 미션

## 실행 예시

---

```
게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)
pobi,jason

딜러와 pobi, jason에게 2장의 나누었습니다.
딜러: 3다이아몬드
pobi카드: 2하트, 8스페이드
jason카드: 7클로버, K스페이드

pobi는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)
y
pobi카드: 2하트, 8스페이드, A클로버
pobi는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)
n
jason은 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)
n
jason카드: 7클로버, K스페이드

딜러는 16이하라 한장의 카드를 더 받았습니다.

딜러 카드: 3다이아몬드, 9클로버, 8다이아몬드 - 결과: 20
pobi카드: 2하트, 8스페이드, A클로버 - 결과: 21
jason카드: 7클로버, K스페이드 - 결과: 17

## 최종 승패
딜러: 1승 1패
pobi: 승
jason: 패
```

## 기능 목록

---

- [x]  게임에 참여할 플레이어의 이름을 입력받는다.
    - [x]  플레이어의 이름은 “, ” 로 구분된다.
    - [x]  플레이어의 이름은 공백 또는 빈 칸일 수 없다.

- [x]  게임이 시작되면 모든 참여자에게 카드를 두 장씩 분배한다.
    - [x]  받은 카드를 출력한다. 단, 딜러는 한 장의 카드만 출력한다.

- [x]  플레이어가 카드를 더 받을 수 있는 상황에서 받기를 원한다면 추가로 받는다.
    - [x]  “y” 혹은 “n” 만 사용하여 추가 의사를 받는다.
    - [x]  카드를 추가로 받았을 경우 현재 카드패를 출력한다.
    - [x]  카드를 추가로 받을 수 없을 경우 다음 플레이어에게 의사를 묻는다.

- [x]  딜러는 추가로 카드를 받을 수 있을 경우, 카드를 받는다.
    - [x]  딜러가 카드를 추가로 받았을 경우 안내문을 출력한다.

- [x]  모든 참여자의 카드패와 게임의 결과를 출력한다.
    - [x]  플레이어의 점수가 딜러의 점수보다 높을 경우 승리한다.
    - [x]  플레이어의 점수가 딜러의 점수보다 낮을 경우 패배한다.
    - [x]  플레이어만 버스트한 경우 패배한다.
    - [x]  딜러만 버스트한 경우 승리한다.
    - [x]  플레이어와 딜러 모두 버스트한 경우 패배한다.
    - [x]  플레이어와 딜러의 점수가 같을 경우 비긴다.
    - [x]  플레이어와 딜러의 모든 승패를 비교하여 최종 승패를 출력한다.

## 객체 목록

---

### Number

- 카드의 숫자는 A 부터 ~ K 까지 존재한다.
- J, Q, K 는 10으로 계산한다.

### Kind

- 카드의 문양은 스페이드, 다이아몬드, 클로버, 하트로 이루어져 있다.

### Card

- 카드 숫자와 문양을 알고 있다.
- 자신이 A 인지 판단할 수 있다.

### Cards

- 카드들을 소지하고 있고 추가할 수 있다.
- `[ERROR]` 현재 소유중인 카드들과 추가될 카드들 중 중복이 있다면 예외를 발생한다.

### CardDeck

- 순서가 섞인 52가지의 카드를 갖고 생성된다.
- 갖고 있는 카드를 분배할 수 있다.
- `[ERROR]` 현재 소유중인 카드들보다 많은 카드 분배를 요청할 경우 예외를 발생한다.

### Result

- `WIN` - 플레이어가 버스트 되지 않고 딜러보다 점수가 높을 경우
- `DRAW` - 플레이어가 버스트 되지 않고 딜러와 점수가 같을 경우
- `LOSE` - 플레이어가 버스트 하거나 딜러보다 점수가 낮을 경우

### Name

- 이름을 가질 수 있다.
- `[ERROR]` 이름은 공백이거나 빈 칸일 수 없다.

### Participant

- 참여자는 자신의 점수를 판단하여 카드를 더 받을 수 있는 상태인지 판단할 수 있다.
- 참여자는 카드를 추가로 수령할 수 있다.

### Dealer

- 딜러는 카드 한장을 숨길 수 있다.
- 가지고 있는 카드의 점수 합이 16이하면 반드시 한장을 뽑고 17이상이면 받을 수 없다.
- A 를 소지한 상태로 버스트 된 경우 A 를 1 로 계산한다.

### Player

- 가지고 있는 카드의 점수 합이 21 이하일 경우 원하는 만큼 카드를 받을 수 있다.
- A 를 1 또는 11 로 계산할 수 있다.
- 버스트 된 경우 자동으로 패배한다.

### Players

- 플레이어들의 승패 결과를 확인 하고 반환한다.
