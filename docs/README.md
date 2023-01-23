## 🚀 기능 목록

![img.png](img.png)


### contants

### Controller

- MenuService
  - [ ] 못먹는 정보 입력받기 -> View(interface)에 위임
  - [ ] 못먹는 정보 생성하기 -> InfomationGenerator(interface)에 위임
  - [ ] 추천하는 정보 생성하기 -> InfomationGenerator(interface)에 위임
  - [ ] 추천하는 정보 출력하기 -> View(interface)에 위임
  
  
### Model
- InfomationGenerator(interface) - creatInfomation()
  - FoodInformationCoachCanTEat(Impl)
    - [ ] 못먹는 정보 생성 - creatInformation(String coach, List< String> menus)  
      // coach = "토미,제임스,포코"  
      // menus = {"우동,스시", "뇨끼,월남쌈", "마파두부,고추잡채"}  


  - RecommendationInformation(Impl)
    - [ ] 추천하는 정보 생성 - creatInformation(FoodInformationCoachCanTEat : foodInfoCanTEat)  
    

- RecommendationInfoGenerator(interface)
  - Algorithm
    - [ ] 추천 카테고리 생성 - createCategories() : List< String >
    - [ ] 추천메뉴 생성 - createMenus(List< String > : categories, FoodInformationCoachCanTEat : foodInfoCanTEat) : List<List< String >>

### View
- InputUI
  - [ ] 못먹는 정보 입력받기 - inputFoodInfoCoachCanTEat()

- OutputUI
  - [ ] 추천하는 정보 출력하기 - outputRecommendationInfo()