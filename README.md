# TP6DPBO2025C2

# JANJI
Saya Muhammad Igin Adigholib dengan NIM 2301125 mengerjakan Tugas Praktikum 6 dalam mata kuliah Desain dan Pemrograman Berorientasi Objek untuk keberkahanNya maka saya tidak melakukan kecurangan seperti yang telah dispesifikasikan. Aamiin.

# Desain Program
![WhatsApp Image 2025-04-12 at 20 31 44_1c8fde70](https://github.com/user-attachments/assets/27a27ed8-0917-4847-b3d4-e8b3cd11690b)

# Alur Program
Program dimulai dari kelas App, yang berfungsi sebagai titik masuk utama aplikasi. Di dalam metode main, program langsung menampilkan jendela awal berupa objek StartMenu, yang merupakan antarmuka awal game. StartMenu menampilkan dua tombol utama, yaitu "Start Game" untuk memulai permainan dan "Exit" untuk keluar dari aplikasi. Ketika pengguna menekan tombol "Start Game", menu akan ditutup, dan jendela baru akan dibuka untuk menampilkan panel permainan FlappyBird.

Kelas FlappyBird merupakan inti dari permainan. Kelas ini memperluas JPanel dan mengimplementasikan KeyListener serta ActionListener, sehingga dapat merespons input keyboard dan mengatur logika game secara periodik menggunakan Timer. Saat panel dibuat, gambar-gambar seperti latar belakang, burung, dan pipa akan dimuat dari file gambar. Burung direpresentasikan dengan objek Player, yang memiliki atribut posisi, kecepatan, dan gambar, serta method untuk memperbarui dan mendapatkan posisi atau area bounding-nya.

Permainan berlangsung dengan adanya dua Timer, yaitu gameloop dan pipesCooldown. gameloop berjalan 60 kali per detik dan bertugas memperbarui posisi burung serta pipa, mengecek tabrakan, serta memperbarui tampilan layar. Sementara itu, pipesCooldown berjalan setiap 1,5 detik untuk menambahkan sepasang pipa (atas dan bawah) ke dalam permainan. Pipa direpresentasikan oleh objek Pipe, yang memiliki atribut posisi, kecepatan gerak horizontal, dan flag passed yang digunakan untuk menghitung skor saat burung berhasil melewatinya.

Pengguna dapat menekan tombol spasi (SPACE) untuk membuat burung melompat ke atas dengan mengurangi kecepatan vertikalnya. Jika burung bertabrakan dengan pipa atau jatuh ke dasar layar, maka game akan dihentikan, dan dialog "Game Over" akan ditampilkan. Pemain dapat memulai ulang permainan dengan menekan tombol R, yang akan mereset posisi burung, menghapus semua pipa yang ada, dan mengaktifkan kembali kedua timer.

Dengan alur ini, program membentuk permainan Flappy Bird versi desktop berbasis Java Swing yang interaktif dan responsif terhadap input pengguna.

# Dokumentasi
https://github.com/user-attachments/assets/e1c53201-0e5c-4936-9f15-19d79aaa2b7c


