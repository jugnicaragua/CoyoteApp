object Versions {
    const val gradle = "4.1.0-alpha03"
    const val kotlin = "1.3.70"

    const val koin = "2.1.3"
    const val navigation = "2.2.1"

    const val javaVersionConstant = "1.8"

    const val skeleton = "2.0.1"
    const val blur = "3.0.0"

    const val timber    = "4.7.1"
    const val constraintlayout = "1.1.3"
    const val core = "1.2.0"
    const val appcompat = "1.1.0"
    const val lifecycle = "2.2.0-beta01"
    const val databinding = "3.1.4"

    const val retrofit = "2.7.2"
    const val interceptor = "4.4.0"

    const val googleMaterial = "1.2.0-alpha05"
    const val backdrop = "1.0.0"
    const val androidTest = "1.1.1"
    const val junit = "4.13"
    const val testrunner = "1.1.1"
    const val espresso = "3.2.0"
    const val androidRules = "1.1.0"

    const val coroutine = "1.3.4"
    const val coil = "0.9.5"
    const val coilTransformation = "0.0.4"

    const val room = "2.2.4"
}

object Room {
    val runtime = "androidx.room:room-runtime:${Versions.room}"
    val compiler = "androidx.room:room-compiler:${Versions.room}"
    val ktx = "androidx.room:room-ktx:${Versions.room}"
    val test = "androidx.room:room-testing:${Versions.room}"
}

object Kotlin {
    val build = "com.android.tools.build:gradle:${Versions.gradle}"
    val plugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
}

object AndroidX {
    val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    val annotations = "androidx.annotation:annotation:${Versions.androidRules}"
    val androidXcore ="androidx.core:core-ktx:${Versions.core}"
    val constraintlayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintlayout}"
}

object Databinding {
    val databinding = "com.android.databinding:compiler:${Versions.databinding}"
}

object Libs {
    val timber = "com.jakewharton.timber:timber:${Versions.timber}"
    val backdrop = "com.yusufpats.backdroplayout:backdropLayout:${Versions.backdrop}"
    val skeleton = "com.faltenreich:skeletonlayout:${Versions.skeleton}"
    val blur = "jp.wasabeef:blurry:${Versions.blur}"
}

object Navigation{
    val navigationGradle = "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navigation}"
    val runtime = "androidx.navigation:navigation-runtime-ktx:${Versions.navigation}"
    val fragment = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    val ui = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
}

object Koin {
    val core = "org.koin:koin-core:${Versions.koin}"
    val android = "org.koin:koin-android:${Versions.koin}"
    val scope = "org.koin:koin-androidx-scope:${Versions.koin}"
    val viewModel = "org.koin:koin-androidx-viewmodel:${Versions.koin}"
    val extension = "org.koin:koin-androidx-ext:${Versions.koin}"
    val test = "org.koin:koin-test:${Versions.koin}"
}

object Retrofit {
    val okHttp = "com.squareup.okhttp3:logging-interceptor:${Versions.interceptor}"
    val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    val retrofitConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
}

object Coroutines {
    val coroutine = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutine}"
}

object Google {
    val material = "com.google.android.material:material:${Versions.googleMaterial}"
}

object Coil {
    val coil = "io.coil-kt:coil:${Versions.coil}"
    val gif = "io.coil-kt:coil-gif:${Versions.coil}"
    val transformation = "com.github.Commit451.coil-transformations:transformations:${Versions.coilTransformation}"
    val transformationGpu = "com.github.Commit451.coil-transformations:transformations-gpu:${Versions.coilTransformation}"
}

object TestLibs {
    val junit = "junit:junit:${Versions.junit}"
    val androidTest = "androidx.test.ext:junit:${Versions.androidTest}"
    val testrunner = "androidx.test:runner:${Versions.testrunner}"
    val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    val androidRules = "androidx.test:rules:${Versions.androidRules}"
}