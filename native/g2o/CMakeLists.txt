cmake_minimum_required(VERSION 3.10.2)   # Menentukan versi minimum CMake
project("yourprojectname")                 # Nama proyek (ganti dengan nama proyek kamu)

# Ganti dengan path ke folder g2o yang kamu ekstrak dari ZIP
set(G2O_PATH "${CMAKE_SOURCE_DIR}/native/g2o")  # <-- Ganti ini dengan path tempat kamu mengekstrak g2o!

# Tentukan direktori header g2o
include_directories(${G2O_PATH}/g2o/core)
include_directories(${G2O_PATH}/g2o/stuff)
include_directories(${G2O_PATH}/g2o/solvers)
include_directories(${G2O_PATH}/g2o/solvers/dense)

# Tentukan file sumber g2o yang akan di-build menjadi shared library (.so)
add_library(g2o STATIC
    ${G2O_PATH}/g2o/core/optimization_algorithm_gauss_newton.cpp
    ${G2O_PATH}/g2o/core/sparse_optimizer.cpp
    ${G2O_PATH}/g2o/stuff/matrix.cpp
    # Jika ada file lain yang kamu butuhkan, tambahkan di sini
)

# Tentukan library C++ standar yang akan digunakan
target_link_libraries(g2o log)

# Tentukan output shared object (.so) yang akan digunakan di Android
add_library(g2o SHARED IMPORTED)
set_target_properties(g2o PROPERTIES IMPORTED_LOCATION ${CMAKE_SOURCE_DIR}/libs/${ANDROID_ABI}/libg2o.so)
