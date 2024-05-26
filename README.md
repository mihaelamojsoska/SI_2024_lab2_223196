# Втора лабораториска вежба по Софтверско инженерство
## Михаела Мојсоска, бр. на индекс 223196
## 2. Control Flow Graph
![controlFlowGraph](https://github.com/mihaelamojsoska/SI_2024_lab2_223296/assets/139136378/184312da-15ac-4704-861d-2765a228ed6a)
## 3. Цикломатска комплексност
(Number of edges - Number of nods) + 2*1 = (31 - 23) + 2 = 10 <br>
Има 10 региони.
## 4. Tест случаи според Every Branch критериумот
![everyStatement](https://github.com/mihaelamojsoska/SI_2024_lab2_223296/assets/139136378/93787baf-83d1-46d5-b969-93e8cc56ccc1)
**1->allitems=null,payment=100<br>**
-allItems е null, што предизвикува RuntimeException со порака "allItems list can't be null!",кодот завршува тука.<br>
**2->allItems = ("dog","123G", 100, 0.1f)),payment=150<br>**
-allItems содржи невалиден баркод "123G", кодот го проверува секој
знак од баркодот и фрла RuntimeException со порака "Invalid character in item
barcode!" бидејќи баркодот содржи невалидни знаци. <br>
**3->  allitems=("",null,50,0.1f"),payment=100<br>**
-allItems содржи еден елемент со празно име и null баркод. Името на елементот се
поставува на "unknown", и бидејќи баркодот е null, се фрла RuntimeException со порака
"No barcode!".<br>
**4->allitems=("fish","1234",200,0.1f"),allitems=("fish2","9876,300,0.2f"),payment=400<br>**
-allItems содржи два елементи: еден со баркод "1234" и попуст од 0.1, и друг со баркод
"9876" со попуст 0.2. Вкупната цена се пресметува и споредува со payment кое е 400.<br>
**5->allitems=("cow","1234",100,0.1f"),allitems=("cow2","9876",300,-0.1f"),payment=100<br>**
-allItems содржи два елементи: еден со баркод "1234" и попуст од 0.1 и цена од 100, и
друг со баркод "9876" и цена од 300, со попуст -0.1. Вкупната цена се пресметува и
споредува со payment кое е 100.
## 5. Тест случаи според Multiple Condition критериумот
![multipleCondition](https://github.com/mihaelamojsoska/SI_2024_lab2_223296/assets/139136378/c1f54210-ca96-45dd-afd7-06a96a1161bb)<br>
**FXX<br>**
цената на првиот елемент е 170, што значи дека item.getPrice() > 300 е false (F).Останатите услови се неважни бидејќи првиот услов не е исполнет.<br>
**TFX<br>**
цената на вториот елемент е 320, што значи дека item.getPrice() > 300 е true (T), но попустот е 0, така што item.getDiscount() > 0 е false (F). Третиот услов е неважен.<br>
**TTF<br>**
цената на третиот елемент е 320, попустот е 0.1, така што и двата услови се true (TT), но баркодот не почнува со '0', така што item.getBarcode().charAt(0) == '0' е false (F).<br>
**TTT<br>**
цената на четвртиот елемент е 320, попустот е 0.1, и баркодот почнува со '0', така што сите услови се исполнети (TTT) и сумата се намалува за 30 единици.<br>
## 6. Објаснување на напишаните unit tests
### Метод everyBranchTest
**Test Case 1: Null List<br>**
кога allItems е нула, се фрла RuntimeException, проверува дали пораката содржи "can't be null!"<br>
**Test Case 2: Invalid Character in Barcode<br>**
Тестира дали фрла RuntimeException кога barcode содржи невалидни карактери, проверува дали пораката содржи "Invalid character in item barcode!".<br>
**Test Case 3: No Barcode<br>**
Тестира дали фрла RuntimeException кога barcode е null, проверува дали пораката содржи "No barcode!".<br>
**Test Case 4: Valid Items and Payment<br>**
Да да се утврди дали функцијата успешно се справува со ситуацијата во која сите items се валидни и плаќањето е доволно за да се покрие целокупниот износ. Функцијата треба да врати true.<br>
**Test Case 5: Valid Items but Insufficient Payment<br>**
Да проверите дали функцијата правилно се справува со случајот кога сите items се валидни, но плаќањето не е доволно за покривање на вкупните трошоци.Функцијата треба да врати false.<br>
### Метод multipleConditionsTest:
**Test Case 1: Valid Items and Sufficient Payment<br>**
Тестира дали функцијата враќа true кога вкупната сума на items (со попусти и намалувања) е помала или еднаква на плаќањето од 1000.<br>
**Test Case 1: Valid Items but Insufficient Payment<br>**
Тестира дали функцијата враќа false кога вкупната сума на items (со попусти и намалувања) е поголема од плаќањето од 100.

