-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Aug 07, 2020 at 05:28 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db10118322Perpustakaan`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `id_admin` int(11) NOT NULL,
  `nama_admin` varchar(30) NOT NULL,
  `username` varchar(30) NOT NULL,
  `password` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id_admin`, `nama_admin`, `username`, `password`) VALUES
(1, 'admin', 'admin', 'admin'),
(2, 'Abizar Deriana', 'abizar1', 'gotoxy'),
(3, 'Farhan Afson', 'farhanaf', 'kerinci123'),
(4, 'Permata Ariani', 'permariani12', 'akuncatik12'),
(5, 'Muhammad Arifin', 'arifinmuh14', 'bandungjuara'),
(6, 'Syamsu Rizal', 'naruto133', 'sasuke19'),
(7, 'Ardian Samsudin', 'summerblack', 'kotabaru11'),
(8, 'Fetiana Rahmisyam', 'rahmianafeti12', 'persib1933'),
(9, 'Rifqi Gates', 'gatesrifqi111', 'micorosoft10'),
(10, 'Farhan Muhammad', 'muhfarhan12', 'akuganteng12');

-- --------------------------------------------------------

--
-- Table structure for table `anggota`
--

CREATE TABLE `anggota` (
  `id_anggota` int(11) NOT NULL,
  `nama_anggota` varchar(50) NOT NULL,
  `no_tlp` varchar(15) NOT NULL,
  `alamat` varchar(30) NOT NULL,
  `username` varchar(30) NOT NULL,
  `password` varchar(40) NOT NULL,
  `status` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `anggota`
--

INSERT INTO `anggota` (`id_anggota`, `nama_anggota`, `no_tlp`, `alamat`, `username`, `password`, `status`) VALUES
(1, 'Fuaza Dwifalah', '081182462727', 'Jln Raya Cileunyi No 945', 'Aneng2001', 'anengarifah1', 'AKTIF'),
(2, 'Reihan Naufal Muntaza', '082127788165', 'Jalan Raya Cibiru No 1', 'reihan20', 'reihanbiru20', 'AKTIF'),
(3, 'Ananta Heriyana', '082124698211', 'Jalan Kircon No 21', 'jamaica88', 'ilovejamaica1', 'AKTIF'),
(4, 'Arfin Faisal', '081141567080', 'Jalan Kemayoran No 490', 'pergitenang', 'jauhmelangkah', 'AKTIF'),
(5, 'Miranda Yahyani', '081314303921', 'Kompleks Cibening Indah No D3', 'andalusia20', 'kpop2020', 'TIDAK AKTIF'),
(6, 'Ricky Namara', '081384886829', 'Jalan Kasblanka No 41', 'youtube333', 'iamayoutuber2020', 'TIDAK AKTIF'),
(7, 'Lazuardi Latief', '082112618111', 'Kompleks Cibening Indah No D3', 'latieflazuardi22', 'gaspar1999', 'AKTIF'),
(8, 'Zainal Khalidin', '081221480643', 'Kompleks Bumi Kirana No 3', 'juandaexport', 'itb2020', 'TIDAK AKTIF'),
(9, 'Dimas Anugrah', '082129908090', 'Kompleks Cibiru Indah No 33', 'batman099', 'batmanvsuperman', 'AKTIF'),
(10, 'Zabiyan Aqsal', '081228908177', 'Komplek Permata Biru No H3', 'laboratoriumkimia', 'kimiaisfun', 'TIDAK AKTIF'),
(11, 'Zaidan Anggara', '089789878754', 'Jalan Cibiru Raya No. 14', 'zaidanangga', '123456', 'TIDAK AKTIF');

-- --------------------------------------------------------

--
-- Table structure for table `buku`
--

CREATE TABLE `buku` (
  `id_buku` int(11) NOT NULL,
  `judul_buku` varchar(50) NOT NULL,
  `penerbit` varchar(50) NOT NULL,
  `penulis` varchar(50) NOT NULL,
  `deskripsi` varchar(100) NOT NULL,
  `tahun_terbit` varchar(5) NOT NULL,
  `date_created` date NOT NULL,
  `id_admin` int(11) NOT NULL,
  `status` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `buku`
--

INSERT INTO `buku` (`id_buku`, `judul_buku`, `penerbit`, `penulis`, `deskripsi`, `tahun_terbit`, `date_created`, `id_admin`, `status`) VALUES
(1, 'Senja & Pagi', 'Loveable x Bhumi Anoma', 'Alffy Rev', 'Novel ini bercerita tentang perjalanan cinta penulisnya yang terbilang singkat', '2018', '2020-06-08', 1, 'ADA'),
(2, 'Unity Tutorial Game Engine', 'Penerbit Informatika', 'Rickman Roedavan', 'Buku ini berisi mengenai tata cara penggunaan unity', '2018', '2020-06-09', 1, 'ADA'),
(3, 'Resign', 'Gramedia Pustaka Utama', 'Almira Bastari', 'Buku ini mengisahkan kehidupan para pegawai kantor yang ingin keluar dari pekerjaan', '2018', '2020-08-12', 2, 'ADA'),
(4, 'Antologi Rasa', 'Gramedia Pustaka Utama', 'Ika Natassa', 'Dalam novel Antologi Rasa mengisahkan tentang cinta yang terjalin di antara tiga sahabat', '2018', '2020-06-13', 2, 'ADA'),
(5, 'Yang Fana Adalah Waktu', 'Gramedia Pustaka Utama', 'Sapardi Djoko Damono', 'Yang F6ana Adalah Waktu merupakan sekuel dari trilogi Hujan Bulan Juni dan Pingkan Melipat Jarak', '2018', '2020-06-14', 3, 'ADA'),
(6, 'Perangkat Keras Komputer', 'PT Elex Media Komputindo', 'Bobi Kurniawan, St.,M.Kom', 'Buku ini membahas seputar perangkat keras komputer', '2014', '2020-06-14', 3, 'DIHAPUS'),
(7, '7 In 1 Pemograman Web Untuk Pemula', 'PT Elex Media Komputindo', 'Rohi Abdulloh', 'Buku ini berisi mengenai pemrograman web yang ditujukan bagi para pemula', '2018', '2020-07-14', 3, 'ADA'),
(8, 'Aroma Karsa', 'Bentang Pustaka', 'Dee Lestari', 'Dalam buku ini,terdapat kisah romansa, petualangan, detektif, fantasi, bahkan mitologi', '2018', '2020-07-17', 4, 'ADA'),
(9, 'Modul Pemrograman Web (HTML,PHP&MySQL/MariaDB)', 'Penerbit Modula', 'Budi Raharjo', 'Buku ini berisikan tentang pemrograman web dari HTML hingga MariaDb', '2016', '2020-08-01', 5, 'ADA'),
(10, 'Jika Kamu Menjadi Tanda Tambah', 'BIP', 'Trista Speed Shaskan', 'Buku ini mengajarkan konsep penjumlahan dalam matematika kepada anak-anak', '2010', '2020-08-02', 6, 'DIHAPUS'),
(11, 'Bumi Manusia', 'Lentera Dipantara', 'Pramoedya Ananta Toer', 'Sebuah roman yang dikenal dengan tetralogi buru. Ditulis oleh pram saat di dalam penjara', '2017', '2020-08-07', 1, 'DIHAPUS');

-- --------------------------------------------------------

--
-- Table structure for table `detail_peminjaman`
--

CREATE TABLE `detail_peminjaman` (
  `id_peminjaman` int(11) NOT NULL,
  `id_buku` int(11) NOT NULL,
  `tanggal_pinjam` date NOT NULL,
  `tanggal_kembali` date NOT NULL,
  `status` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `detail_peminjaman`
--

INSERT INTO `detail_peminjaman` (`id_peminjaman`, `id_buku`, `tanggal_pinjam`, `tanggal_kembali`, `status`) VALUES
(1, 10, '2020-08-01', '2020-08-06', 'DIKEMBALIKAN'),
(2, 7, '2020-08-03', '2020-08-08', 'DIPINJAM'),
(3, 1, '2020-08-03', '2020-08-08', 'DIKEMBALIKAN'),
(4, 9, '2020-08-03', '2020-08-08', 'DIPINJAM'),
(5, 2, '2020-08-03', '2020-08-08', 'DIPINJAM'),
(6, 5, '2020-08-04', '2020-08-09', 'DIPINJAM'),
(7, 6, '2020-08-04', '2020-08-09', 'DIPINJAM'),
(8, 7, '2020-08-05', '2020-08-10', 'DIKEMBALIKAN'),
(9, 7, '2020-08-05', '2020-08-10', 'DIPINJAM'),
(10, 8, '2020-08-06', '2020-08-11', 'DIKEMBALIKAN'),
(11, 2, '2020-08-07', '2020-08-12', 'DIPINJAM'),
(12, 3, '2020-08-07', '2020-08-12', 'DIPINJAM'),
(13, 4, '2020-08-07', '2020-08-12', 'DIKEMBALIKAN'),
(14, 9, '2020-08-07', '2020-08-12', 'DIPINJAM'),
(15, 8, '2020-08-07', '2020-08-12', 'DIPINJAM'),
(16, 3, '2020-08-07', '2020-08-12', 'DIPINJAM');

-- --------------------------------------------------------

--
-- Table structure for table `peminjaman`
--

CREATE TABLE `peminjaman` (
  `id_peminjaman` int(11) NOT NULL,
  `id_anggota` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `peminjaman`
--

INSERT INTO `peminjaman` (`id_peminjaman`, `id_anggota`) VALUES
(1, 1),
(2, 1),
(3, 2),
(14, 2),
(15, 2),
(16, 2),
(4, 3),
(5, 4),
(6, 5),
(7, 6),
(13, 6),
(8, 7),
(9, 8),
(10, 9),
(11, 10),
(12, 10);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id_admin`);

--
-- Indexes for table `anggota`
--
ALTER TABLE `anggota`
  ADD PRIMARY KEY (`id_anggota`);

--
-- Indexes for table `buku`
--
ALTER TABLE `buku`
  ADD PRIMARY KEY (`id_buku`),
  ADD KEY `id_admin` (`id_admin`);

--
-- Indexes for table `detail_peminjaman`
--
ALTER TABLE `detail_peminjaman`
  ADD KEY `id_peminjaman` (`id_peminjaman`),
  ADD KEY `detail_peminjaman_ibfk_2` (`id_buku`);

--
-- Indexes for table `peminjaman`
--
ALTER TABLE `peminjaman`
  ADD PRIMARY KEY (`id_peminjaman`),
  ADD KEY `id_anggota` (`id_anggota`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `id_admin` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `anggota`
--
ALTER TABLE `anggota`
  MODIFY `id_anggota` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `buku`
--
ALTER TABLE `buku`
  MODIFY `id_buku` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `peminjaman`
--
ALTER TABLE `peminjaman`
  MODIFY `id_peminjaman` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `buku`
--
ALTER TABLE `buku`
  ADD CONSTRAINT `buku_ibfk_1` FOREIGN KEY (`id_admin`) REFERENCES `admin` (`id_admin`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `detail_peminjaman`
--
ALTER TABLE `detail_peminjaman`
  ADD CONSTRAINT `detail_peminjaman_ibfk_1` FOREIGN KEY (`id_peminjaman`) REFERENCES `peminjaman` (`id_peminjaman`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `detail_peminjaman_ibfk_2` FOREIGN KEY (`id_buku`) REFERENCES `buku` (`id_buku`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `peminjaman`
--
ALTER TABLE `peminjaman`
  ADD CONSTRAINT `peminjaman_ibfk_1` FOREIGN KEY (`id_anggota`) REFERENCES `anggota` (`id_anggota`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
