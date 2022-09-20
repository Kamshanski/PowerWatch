PowerWatch
============


##💻 Описание
PowerWatch следит за зарядом батареи и оповещает (сообщение на весь экран), что нужно подключить зарядку.

Подходит для ноутов на Windows, у которых диалог "Критически низкий уровень заряда" появляется поздно или совсем не появляется.


##⚙️ Как работает

Через JNI на KotlinNative добавлен метод для получения результата вызова платформенной функции GetSystemPowerStatus в коде JVM.
На стороне JVM запускается приложение с GUI на Compose Desktop.
Логика приложения:
* Переодично (1-15 сек.) опрашивается заряд батареи
* Если меньше 20%, показывается банер на весь экран


##📖 Использованные ресурсы

* https://github.com/jonnyzzz/kotlin-jni-mix
  :   Пример импользования jni для связи Kotlin Native и Kotlin JVM
* https://gist.github.com/Eng-Fouad/c810fae1ddcb0f0c4538299e31c78638
  :   Пример build.gradle.kts
* https://docs.oracle.com/javase/7/docs/technotes/guides/jni/spec/types.html
  :   Типы в jni
* https://github.com/Windmill-City/KNI + Блог https://jonnyzzz.com/blog/2019/12/15/jni-kotlin/
  :   JNI в связке с KotlinNative
* https://github.com/LandryNorris/JniUtils
  :   не использовал, но может быть дополнением к KNI
* https://kotlinlang.org/api/latest/jvm/stdlib/kotlinx.cinterop/
  :   Дока по cinterop
* https://gist.github.com/theeasiestway/e5f453715cecc55b5ca57d0628b9f12a
  :   Создание объекта в JNI на C++
* https://github.com/adamheinrich/native-utils
  :   Утилита для подгрузки .dll из скомпиленного .jar.
* https://docs.oracle.com/javase/tutorial/uiswing/misc/systemtray.html
  :   Дока по SystemTray в Swing
* https://github.com/JetBrains/compose-jb/tree/master/tutorials/
  :   Туториалы по композу

##🔨 Сборка
Gradle таска :packageUberJarForCurrentOS


##▶️ Запуск
Gradle таска :run

##🧠 Примечания
* Папка для автозагрузки: C:\Users\<USER_NAME>\AppData\Roaming\Microsoft\Windows\Start Menu\Programs\Startup
  В неё нужно поместить ярлык на запускаемый файл.
* Работает на JVM 17. Собирается на JDK 17 (Liberica)

