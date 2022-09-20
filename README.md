Использованные ресурсы:

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


Примечания:
Папка для автозагрузки: C:\Users\ruban\AppData\Roaming\Microsoft\Windows\Start Menu\Programs\Startup
  В неё нужно поместить ярлык на запускаемый файл.
Loading Kotlin/Native binary as JNI library
============

The idea of that project is to experiment with both JVM (11 in my case)
and Kotlin/Native.

What we do

- we run Java application
- we build shared library with Kotlin/Native to implement JNI contracts
- we load Kotlin/Native library into JVM application

Hack with pleasure!

License
=======

MIT, see the LICENSE file in the repository


Building and Running
====================

Execute `./gradlew build` task. Fix path to the library in Java sources. Start Java application

