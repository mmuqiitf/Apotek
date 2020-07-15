-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 15, 2020 at 12:23 PM
-- Server version: 10.4.13-MariaDB
-- PHP Version: 7.4.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `apotek`
--

-- --------------------------------------------------------

--
-- Table structure for table `golongan`
--

CREATE TABLE `golongan` (
  `id_golongan` int(11) NOT NULL,
  `nama_golongan` varchar(30) NOT NULL,
  `warna` varchar(10) NOT NULL,
  `keterangan` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `golongan`
--

INSERT INTO `golongan` (`id_golongan`, `nama_golongan`, `warna`, `keterangan`) VALUES
(1, 'Obat Bebas', 'Hijau', 'Lingkaran Hijau'),
(2, 'Obat Bebas Terbatas', 'Biru', 'Lingkaran Biru'),
(3, 'Obat Keras', 'Merah', 'Lingkaran merah dengan huruf K di tengah');

-- --------------------------------------------------------

--
-- Table structure for table `jabatan`
--

CREATE TABLE `jabatan` (
  `id_jabatan` int(11) NOT NULL,
  `nama` varchar(30) NOT NULL,
  `keterangan` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `jabatan`
--

INSERT INTO `jabatan` (`id_jabatan`, `nama`, `keterangan`) VALUES
(1, 'Kepala Manager', NULL),
(2, 'Apoteker', NULL),
(3, 'Asisten Apoteker', NULL),
(4, 'Divisi Pembelian', NULL),
(5, 'Divisi Gudang', NULL),
(6, 'Divisi Peracikan', NULL),
(7, 'Divisi Tata Usaha', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `obat`
--

CREATE TABLE `obat` (
  `id_obat` int(11) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `harga` int(11) NOT NULL,
  `dosis` varchar(50) NOT NULL,
  `stok` int(11) NOT NULL,
  `satuan` varchar(50) NOT NULL,
  `keterangan` varchar(50) DEFAULT NULL,
  `id_golongan` int(11) NOT NULL,
  `id_supplier` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `obat`
--

INSERT INTO `obat` (`id_obat`, `nama`, `harga`, `dosis`, `stok`, `satuan`, `keterangan`, `id_golongan`, `id_supplier`) VALUES
(1, 'CAVIT D3', 26410, '1x 1 Tablet', 35, 'Strip', 'Tidak ada keterangan', 1, 1),
(3, 'Bio Strath Tab 100S', 225000, '3 kali sehari 2 tablet', 20, 'Strip', 'Simpan di tempat sejuk dan kering', 1, 2),
(4, 'Neurobion Forte ', 40924, '1 table sehari sesudah makan', 25, 'Strip', 'Simpan di tempat sejuk dan kering', 1, 1),
(5, 'CEFADROXIL IF D.SYR 60ML 125MG/5ML', 17000, 'Diminum sesudah makan', 10, 'Botol', 'Harus dengan resep dokter', 3, 4),
(7, 'CEFIXIME DEXA DRY SYR 30ML 100MG/5ML', 45000, 'anak : 1,5-3mg/kgBB 2 x sehari, berat dpt ditingka', 11, 'Botol', 'Harus dengan resep dokter', 3, 4),
(8, 'Alleron', 2000, 'Dewasa : 1 kaplet 3-4xsehari, anak-anak 6-12 tahun', 15, 'Strip', 'Simpan di tempat sejuk dan kering', 2, 3),
(9, 'PROCOLD TAB STR 6S', 4000, 'dewasa 1 caplet. Anak-anak 6-12 tahun: ½ caplet', 20, 'Strip', 'Simpan di tempat sejuk dan dingin', 2, 1);

-- --------------------------------------------------------

--
-- Table structure for table `pasien`
--

CREATE TABLE `pasien` (
  `id_pasien` int(11) NOT NULL,
  `nama` varchar(30) NOT NULL,
  `alamat` varchar(40) NOT NULL,
  `no_telp` varchar(13) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `pasien`
--

INSERT INTO `pasien` (`id_pasien`, `nama`, `alamat`, `no_telp`) VALUES
(1, 'Muqiit', 'Bandung', '081324325'),
(2, 'Fatur', 'Bandung', '08543542353'),
(3, 'Rahman', 'Bandung', '0852353123');

-- --------------------------------------------------------

--
-- Table structure for table `pegawai`
--

CREATE TABLE `pegawai` (
  `id_pegawai` int(11) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(30) NOT NULL,
  `nama` varchar(30) NOT NULL,
  `no_telp` varchar(13) NOT NULL,
  `alamat` varchar(50) NOT NULL,
  `id_jabatan` int(11) NOT NULL,
  `level` enum('admin','pegawai') NOT NULL DEFAULT 'pegawai'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `pegawai`
--

INSERT INTO `pegawai` (`id_pegawai`, `username`, `password`, `nama`, `no_telp`, `alamat`, `id_jabatan`, `level`) VALUES
(1, 'muqiit', 'muqiit', 'Muqiit', '081313448003', 'Bandung', 1, 'admin'),
(2, 'fatur', 'fatur', 'Faturrahman', '088943532', 'Bandung', 2, 'pegawai');

-- --------------------------------------------------------

--
-- Table structure for table `supplier`
--

CREATE TABLE `supplier` (
  `id_supplier` int(11) NOT NULL,
  `nama` varchar(30) NOT NULL,
  `no_telp` varchar(13) NOT NULL,
  `alamat` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `supplier`
--

INSERT INTO `supplier` (`id_supplier`, `nama`, `no_telp`, `alamat`) VALUES
(1, 'Kimia Farma', '0888234323', 'Bandung'),
(2, 'CV Cinita', '0248313757', 'Semarang'),
(3, 'PT Metro Pillars Group', '02188357528', 'Bekasi'),
(4, 'PT Dexa Medica', '02153200134', 'Tangerang');

-- --------------------------------------------------------

--
-- Table structure for table `transaksi`
--

CREATE TABLE `transaksi` (
  `id_transaksi` int(11) NOT NULL,
  `invoice` varchar(50) DEFAULT NULL,
  `id_pasien` int(11) DEFAULT NULL,
  `id_pegawai` int(11) DEFAULT NULL,
  `tanggal` date DEFAULT NULL,
  `total` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `transaksi`
--

INSERT INTO `transaksi` (`id_transaksi`, `invoice`, `id_pasien`, `id_pegawai`, `tanggal`, `total`) VALUES
(1, '#INV001', 1, 1, '2020-07-13', 100),
(2, '#INV001', 1, 1, '2020-07-13', 100),
(6, '#INV20071372939', 1, 2, '2020-07-13', 46000),
(8, '#INV20071317833', 1, 2, '2020-07-13', NULL),
(9, '#INV20071391240', 2, 2, '2020-07-13', NULL),
(10, '#INV20071355318', 2, 2, '2020-07-13', NULL),
(11, '#INV20071347528', 1, 2, '2020-07-13', NULL),
(12, '#INV20071343431', 2, 2, '2020-07-13', NULL),
(13, '#INV20071492523', 1, 2, '2020-07-14', NULL),
(14, '#INV20071440001', 1, 2, '2020-07-14', NULL),
(15, '#INV20071490403', 1, 2, '2020-07-14', NULL),
(16, '#INV20071446740', 2, 2, '2020-07-14', NULL),
(17, '#INV20071468601', 2, 2, '2020-07-14', NULL),
(18, '#INV20071432269', 2, 2, '2020-07-14', NULL),
(19, '#INV20071491394', 2, 2, '2020-07-14', NULL),
(20, '#INV20071417647', 1, 2, '2020-07-14', 87848),
(21, '#INV20071494329', 3, 2, '2020-07-14', 900000),
(22, '#INV20071484121', 3, 2, '2020-07-14', 241000),
(23, '#INV20071551354', 3, 1, '2020-07-15', 93000);

-- --------------------------------------------------------

--
-- Table structure for table `transaksi_item`
--

CREATE TABLE `transaksi_item` (
  `id_transaksi_item` int(11) NOT NULL,
  `id_transaksi` int(11) DEFAULT NULL,
  `id_obat` int(11) DEFAULT NULL,
  `qty` int(11) DEFAULT NULL,
  `subtotal` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `transaksi_item`
--

INSERT INTO `transaksi_item` (`id_transaksi_item`, `id_transaksi`, `id_obat`, `qty`, `subtotal`) VALUES
(1, 13, 1, 2, 52820),
(2, 13, 5, 2, 52820),
(3, 14, 9, 5, 20000),
(4, 14, 4, 2, 81848),
(5, 15, 3, 4, 900000),
(6, 15, 8, 2, 4000),
(7, 16, 4, 2, 81848),
(8, 16, 8, 5, 10000),
(9, 17, 7, 2, 90000),
(10, 17, 8, 3, 6000),
(11, 18, 5, 3, 51000),
(12, 18, 7, 2, 90000),
(13, 19, 9, 2, 8000),
(14, 19, 8, 2, 8000),
(15, 20, 8, 3, 6000),
(16, 20, 4, 2, 81848),
(17, 21, 3, 2, 450000),
(18, 21, 7, 2, 450000),
(19, 22, 7, 5, 225000),
(20, 22, 9, 2, 8000),
(21, 22, 8, 2, 8000),
(22, 6, 5, 2, 34000),
(23, 6, 9, 3, 12000),
(24, 23, 5, 5, 85000),
(25, 23, 9, 2, 8000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `golongan`
--
ALTER TABLE `golongan`
  ADD PRIMARY KEY (`id_golongan`) USING BTREE;

--
-- Indexes for table `jabatan`
--
ALTER TABLE `jabatan`
  ADD PRIMARY KEY (`id_jabatan`);

--
-- Indexes for table `obat`
--
ALTER TABLE `obat`
  ADD PRIMARY KEY (`id_obat`),
  ADD KEY `FK_obat_golongan` (`id_golongan`),
  ADD KEY `FK_obat_supplier` (`id_supplier`);

--
-- Indexes for table `pasien`
--
ALTER TABLE `pasien`
  ADD PRIMARY KEY (`id_pasien`);

--
-- Indexes for table `pegawai`
--
ALTER TABLE `pegawai`
  ADD PRIMARY KEY (`id_pegawai`),
  ADD KEY `FK_pegawai_jabatan` (`id_jabatan`);

--
-- Indexes for table `supplier`
--
ALTER TABLE `supplier`
  ADD PRIMARY KEY (`id_supplier`);

--
-- Indexes for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`id_transaksi`),
  ADD KEY `FK_transaksi_pasien` (`id_pasien`),
  ADD KEY `FK_transaksi_pegawai` (`id_pegawai`),
  ADD KEY `invoice` (`invoice`);

--
-- Indexes for table `transaksi_item`
--
ALTER TABLE `transaksi_item`
  ADD PRIMARY KEY (`id_transaksi_item`) USING BTREE,
  ADD KEY `FK_transaksi_item_transaksi` (`id_transaksi`),
  ADD KEY `FK_transaksi_item_obat` (`id_obat`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `golongan`
--
ALTER TABLE `golongan`
  MODIFY `id_golongan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `jabatan`
--
ALTER TABLE `jabatan`
  MODIFY `id_jabatan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `obat`
--
ALTER TABLE `obat`
  MODIFY `id_obat` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `pasien`
--
ALTER TABLE `pasien`
  MODIFY `id_pasien` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `pegawai`
--
ALTER TABLE `pegawai`
  MODIFY `id_pegawai` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `supplier`
--
ALTER TABLE `supplier`
  MODIFY `id_supplier` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `transaksi`
--
ALTER TABLE `transaksi`
  MODIFY `id_transaksi` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT for table `transaksi_item`
--
ALTER TABLE `transaksi_item`
  MODIFY `id_transaksi_item` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `obat`
--
ALTER TABLE `obat`
  ADD CONSTRAINT `FK_obat_golongan` FOREIGN KEY (`id_golongan`) REFERENCES `golongan` (`id_golongan`),
  ADD CONSTRAINT `FK_obat_supplier` FOREIGN KEY (`id_supplier`) REFERENCES `supplier` (`id_supplier`);

--
-- Constraints for table `pegawai`
--
ALTER TABLE `pegawai`
  ADD CONSTRAINT `FK_pegawai_jabatan` FOREIGN KEY (`id_jabatan`) REFERENCES `jabatan` (`id_jabatan`);

--
-- Constraints for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD CONSTRAINT `FK_transaksi_pasien` FOREIGN KEY (`id_pasien`) REFERENCES `pasien` (`id_pasien`),
  ADD CONSTRAINT `FK_transaksi_pegawai` FOREIGN KEY (`id_pegawai`) REFERENCES `pegawai` (`id_pegawai`);

--
-- Constraints for table `transaksi_item`
--
ALTER TABLE `transaksi_item`
  ADD CONSTRAINT `FK_transaksi_item_obat` FOREIGN KEY (`id_obat`) REFERENCES `obat` (`id_obat`),
  ADD CONSTRAINT `FK_transaksi_item_transaksi` FOREIGN KEY (`id_transaksi`) REFERENCES `transaksi` (`id_transaksi`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
