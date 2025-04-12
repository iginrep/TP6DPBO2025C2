# TP6DPBO2025C2

# JANJI
Saya Muhammad Igin Adigholib dengan NIM 2301125 mengerjakan Tugas Praktikum 6 dalam mata kuliah Desain dan Pemrograman Berorientasi Objek untuk keberkahanNya maka saya tidak melakukan kecurangan seperti yang telah dispesifikasikan. Aamiin.

# Desain Program
![WhatsApp Image 2025-04-12 at 20 31 44_1c8fde70](https://github.com/user-attachments/assets/27a27ed8-0917-4847-b3d4-e8b3cd11690b)

# Alur Program
Program ini dimulai dari kelas App, yang jadi pintu masuk utama aplikasi. Di method main(), langsung muncul tampilan awal lewat objek StartMenu, yaitu menu awal dari game-nya. Di sana ada dua tombol: "Start Game" buat mulai main, dan "Exit" buat keluar. Nah, kalau tombol "Start Game" ditekan, menu akan nutup dan game FlappyBird langsung dijalankan dalam jendela baru.

Kelas FlappyBird ini adalah inti dari gamenya. Kelas ini merupakan panel (JPanel) yang bisa merespons tombol keyboard dan menjalankan logika game secara berkala pakai Timer. Begitu panel ini aktif, semua gambar penting seperti background, burung, dan pipa langsung dimuat. Burung di sini dibuat dari objek Player, yang punya informasi posisi, gambar, dan kecepatan jatuhnya, plus beberapa method buat ngatur gerakannya dan ngecek tabrakan.

Untuk jalannya game, ada dua Timer yang jalan: gameloop dan pipesCooldown. Timer gameloop ngejalanin update posisi burung dan pipa sebanyak 60 kali per detik, ngecek tabrakan, dan nge-refresh layar. Sedangkan pipesCooldown bakal nambahin pipa baru setiap 1,5 detik. Pipa-pipa ini dibuat dari objek Pipe, yang punya posisi, gambar, kecepatan gerak ke kiri, dan flag buat nentuin apakah udah dilewati burung (buat hitung skor).

Pas main, kita bisa tekan tombol spasi (SPACE) buat bikin burung terbang ke atas. Kalau burung nabrak pipa atau jatuh ke bawah, game otomatis berhenti dan muncul pesan "Game Over". Tapi tenang aja, bisa langsung restart game-nya dengan tekan tombol R — nanti posisi burung di-reset, semua pipa dihapus, dan game dimulai lagi dari awal.

Intinya, program ini bikin game Flappy Bird versi desktop yang ringan dan seru, dibikin pakai Java Swing, dan pastinya responsif terhadap input pemain.

# Dokumentasi
https://github.com/user-attachments/assets/e1c53201-0e5c-4936-9f15-19d79aaa2b7c


