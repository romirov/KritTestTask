Тестовый проект для компании Крит

Требования 
CREATE TABLE "public".nalog1nom_ (  
fielda varchar NULL,  
fieldb varchar NULL,  
fieldv varchar NULL,  
field1 varchar NULL, 
field2 varchar NULL,  
field3 varchar NULL,  
field4 varchar NULL,  
field5 varchar NULL, 
field6 varchar NULL,  
field7 varchar NULL,  
field8 varchar NULL,  
field9 varchar NULL,  
field10 varchar NULL,  
field11 varchar NULL,  
field12 varchar NULL,  
field13 varchar NULL,  
field14 varchar NULL,  
field15 varchar NULL,  
field16 varchar NULL,  
field17 varchar NULL,  
field18 varchar NULL,  
field19 varchar NULL,  
field20 varchar NULL,  
field21 varchar NULL,  
field22 varchar NULL,  
field23 varchar NULL,  
field24 varchar NULL,  
field25 varchar NULL,  
ter varchar NULL,  
dat varchar NULL 
); 
В таблицу «nalog1nom_ФамилияСоискателя» должны быть загружены данные из всех файлов, расположенных в папке «To_load» из архива «Исходные данные». Файлы, данные из которых успешно загружены, должны быть перемещены в папку «Loaded». 
Поля таблицы «nalog1nom_ФамилияСоискателя» должны быть заполнены данными из следующих столбцов исходных файлов Excel: 
Поле таблицы nalog1nom_
Файл 16_01.02.2021.xls
fielda
Столбец A
fieldb
Столбец B
fieldv
Столбец C
field1
Столбец D
field2
Столбец E
field3
Столбец F
field4
Столбец G
field5
Столбец H
field6
Столбец I
field7
Столбец J
field8
Столбец K
field9
Столбец L
field10
Столбец M
field11
Столбец N
field12
Столбец O
field13
Столбец P
field14
Столбец Q
field15
Столбец R
field16
Столбец S
field17
Столбец T
field18
Столбец U
field19
Столбец V
field20
Столбец W
field21
Столбец X
field22
Столбец Y
field23
Столбец Z
field24
Столбец AA
field25
Столбец AB
ter
Часть наименования файла, соответствующая региону. Для данного файла это значение «16» dat
dat
Часть наименования файла, соответствующая дате. Для данного файла это значение «01.02.2021»
Требования к алгоритму загрузки данных
	•	в папке «To_load» может быть произвольное количество исходных файлов;
	•	исходные файлы могут быть форматов .xls и .xlsx;
	•	исходные файлы могут содержать один или два листа с произвольными наименованиями, но только на одном из них содержится таблица соответствующей структуры, данные из которой необходимо загрузить в БД;
	•	таблица с исходными данными может располагаться на листе с произвольным количеством строк отступа по высоте;
	•	состав и порядок столбцов в таблицах с исходными данными одинаковы для всех файлов;
	•	количество строк в таблицах с исходными данными может быть разным;
	•	в БД не должны загружаться строки с незаполненными первым и третьим столбцами;
	•	ячейки с нулевыми значениями в таблицах с исходными данными могут быть заполнены нулями или пусты, в таблицу БД в обоих случаях необходимо записывать нули. 
Порядок выполнения 
Реализация алгоритма загрузки данных на языке Java. 
Выполняется в среде разработки соискателя. 
Результат выполнения необходимо предоставить в виде исходного кода и дампа БД на адреса
	•	anton.shumihin@krit.pro
	•	evgeny.shilov@krit.pro 

