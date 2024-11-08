# FrequencyDictionary

## Описание
Программа для создания частотного словаря символов английского алфавита из текстового файла. Программа принимает текстовый файл, подсчитывает количество вхождений каждого символа английского алфавита (учитывая регистр) и записывает результаты в выходной файл. 

## Структура проекта
- **Main.java**: Главный класс, запрашивает имена входного и выходного файлов, проверяет их существование, вызывает методы обработки данных и предоставляет пользователю выбор действия по окончании работы.
- **FrequencyDictionary.java**: Класс, отвечающий за чтение входного файла, подсчет символов и запись результата в выходной файл.

## Описание функциональности
1. **Ввод и проверка файлов**:
   - Программа запрашивает имя входного файла и проверяет его наличие. Если файл не найден, выводится сообщение об ошибке.
   - Программа запрашивает имя выходного файла. Если файл не существует, он создается. Если файл не может быть создан, программа завершает выполнение с сообщением об ошибке.
   
2. **Частотный анализ**:
   - Класс `FrequencyDictionary` считывает содержимое входного файла построчно и анализирует каждый символ.
   - Символы английского алфавита подсчитываются и заносятся в `HashMap`, где каждый символ — ключ, а количество вхождений — значение.

3. **Запись результатов**:
   - Частотный словарь записывается в выходной файл в формате `буква: количество`.
   
4. **Завершающий этап**:
   - Программа предлагает пользователю открыть выходной файл, вывести его содержимое на экран или завершить выполнение.

## Пример использования
1. Введите имя входного файла (например, `input.txt`).
2. Введите имя выходного файла (например, `output.txt`).
3. После завершения обработки выберите действие:
   - Нажмите `o` для открытия выходного файла в стандартном приложении.
   - Нажмите `c` для вывода содержимого выходного файла на экран.
   - Нажмите `n` (или иной символ) для завершения работы программы.

Буду рада вашим комментариям!
