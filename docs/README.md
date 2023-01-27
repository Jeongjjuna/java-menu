## 🚀 기능 목록

### contants

### Controller

- MenuController
  - [x] 잘 실행 하는지 - run()
  
  
### Model
- Category(Enum) - 카테고리 보관
- Food(Enum) - 카테고리에 따른 음식 보관
- Coach - 코치 정보를 담고있음(이름, 못먹는 음식, 추천받은 메뉴들)
- RandomGeneratorImpl
  - [x] 1~5랜덤 번호 생성 - generateRandomNumber()
- Recommender
  - [x] 카테고리 추천하기 - recommendCategory(RandomGenerator generator)
  - [x] 카테고리에 따른 메뉴 추천하기 - recommendMenu(Category category)

### View
- InputView
  - [x] 코치이름 입력받기 - inputCoachName()
  - [x] 못먹는 정보 입력받기 - inputCoachNotEat()

- OutputView
  - [x] 서비스 시작 문구 출력 - printServiceStart()
  - [x] 코치이름 입력 문구 출력 - printInputCoachName()
  - [x] 못먹는 음식 입력 문구 출력 - printInputCoachNotEat(String coach)
  - [x] 추천 결과 문구 출력 - printServiceResult(List< Category > recommendedCategory, List<Coach> coaches)
  - [x] 서비스 종료 문구 출력 -printServiceEnd()