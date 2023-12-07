
# For more information about using CMake with Android Studio, read the
# documentation: https://d.android.com/studio/projects/add-native-code.html.
# For more examples on how to use CMake, see https://github.com/android/ndk-samples.

# Sets the minimum CMake version required for this project.
cmake_minimum_required(VERSION 3.10.2)
project("fridademo")
set(NATIVE_LIB "native-lib")

add_library(crypto STATIC IMPORTED)
set_target_properties(crypto PROPERTIES IMPORTED_LOCATION ${CMAKE_HOME_DIRECTORY}/boringssl/lib/libcrypto_${ANDROID_ABI}.a)
add_library(ssl STATIC IMPORTED)
set_target_properties(ssl PROPERTIES IMPORTED_LOCATION ${CMAKE_HOME_DIRECTORY}/boringssl/lib/libssl_${ANDROID_ABI}.a)
find_library(
        log-lib
        log
)
add_library(
        ${NATIVE_LIB}
        SHARED
    # List C/C++ source files with relative paths to this CMakeLists.txt.
        native-lib.cpp
        )
target_include_directories(${NATIVE_LIB} PUBLIC
        boringssl/include/)
target_link_libraries(${NATIVE_LIB}
        crypto)
# Specifies libraries CMake should link to your target library. You
# can link libraries from various origins, such as libraries defined in this
# build script, prebuilt third-party libraries, or Android system libraries.
target_link_libraries(
        ${NATIVE_LIB}
        ${log-lib}
        )

