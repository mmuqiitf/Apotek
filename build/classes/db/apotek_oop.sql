-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versi server:                 10.4.13-MariaDB - mariadb.org binary distribution
-- OS Server:                    Win64
-- HeidiSQL Versi:               11.0.0.5919
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Membuang struktur basisdata untuk apotek_oop
CREATE DATABASE IF NOT EXISTS `apotek_oop` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `apotek_oop`;

-- membuang struktur untuk table apotek_oop.golongan
CREATE TABLE IF NOT EXISTS `golongan` (
  `id_golongan` int(11) NOT NULL AUTO_INCREMENT,
  `nama_golongan` varchar(30) NOT NULL,
  `warna` varchar(10) NOT NULL,
  `keterangan` varchar(50) NOT NULL,
  PRIMARY KEY (`id_golongan`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- Membuang data untuk tabel apotek_oop.golongan: ~3 rows (lebih kurang)
/*!40000 ALTER TABLE `golongan` DISABLE KEYS */;
INSERT IGNORE INTO `golongan` (`id_golongan`, `nama_golongan`, `warna`, `keterangan`) VALUES
	(1, 'Obat Bebas', 'Hijau', 'Lingkaran Hijau'),
	(2, 'Obat Bebas Terbatas', 'Biru', 'Lingkaran Biru'),
	(3, 'Obat Keras', 'Merah', 'Lingkaran merah dengan huruf K di tengah');
/*!40000 ALTER TABLE `golongan` ENABLE KEYS */;

-- membuang struktur untuk table apotek_oop.jabatan
CREATE TABLE IF NOT EXISTS `jabatan` (
  `id_jabatan` int(11) NOT NULL AUTO_INCREMENT,
  `nama` varchar(30) NOT NULL,
  `keterangan` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id_jabatan`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;

-- Membuang data untuk tabel apotek_oop.jabatan: ~7 rows (lebih kurang)
/*!40000 ALTER TABLE `jabatan` DISABLE KEYS */;
INSERT IGNORE INTO `jabatan` (`id_jabatan`, `nama`, `keterangan`) VALUES
	(1, 'Kepala Manager', NULL),
	(2, 'Apoteker', NULL),
	(3, 'Asisten Apoteker', NULL),
	(4, 'Divisi Pembelian', NULL),
	(5, 'Divisi Gudang', NULL),
	(6, 'Divisi Peracikan', NULL),
	(7, 'Divisi Tata Usaha', NULL);
/*!40000 ALTER TABLE `jabatan` ENABLE KEYS */;

-- membuang struktur untuk table apotek_oop.obat
CREATE TABLE IF NOT EXISTS `obat` (
  `id_obat` int(11) NOT NULL AUTO_INCREMENT,
  `nama` varchar(50) NOT NULL,
  `harga` int(11) NOT NULL,
  `dosis` varchar(50) NOT NULL,
  `stok` int(11) NOT NULL,
  `satuan` varchar(50) NOT NULL,
  `keterangan` varchar(50) DEFAULT NULL,
  `id_golongan` int(11) NOT NULL,
  `id_supplier` int(11) NOT NULL,
  PRIMARY KEY (`id_obat`),
  KEY `FK_obat_golongan` (`id_golongan`),
  KEY `FK_obat_supplier` (`id_supplier`),
  CONSTRAINT `FK_obat_golongan` FOREIGN KEY (`id_golongan`) REFERENCES `golongan` (`id_golongan`),
  CONSTRAINT `FK_obat_supplier` FOREIGN KEY (`id_supplier`) REFERENCES `supplier` (`id_supplier`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- Membuang data untuk tabel apotek_oop.obat: ~0 rows (lebih kurang)
/*!40000 ALTER TABLE `obat` DISABLE KEYS */;
INSERT IGNORE INTO `obat` (`id_obat`, `nama`, `harga`, `dosis`, `stok`, `satuan`, `keterangan`, `id_golongan`, `id_supplier`) VALUES
	(1, 'CAVIT D3', 26410, '1x 1 Tablet', 35, 'Strip', 'Tidak ada keterangan', 1, 1);
/*!40000 ALTER TABLE `obat` ENABLE KEYS */;

-- membuang struktur untuk table apotek_oop.pasien
CREATE TABLE IF NOT EXISTS `pasien` (
  `id_pasien` int(11) NOT NULL AUTO_INCREMENT,
  `nama` varchar(30) NOT NULL,
  `alamat` varchar(40) NOT NULL,
  `no_telp` varchar(13) NOT NULL,
  PRIMARY KEY (`id_pasien`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- Membuang data untuk tabel apotek_oop.pasien: ~1 rows (lebih kurang)
/*!40000 ALTER TABLE `pasien` DISABLE KEYS */;
INSERT IGNORE INTO `pasien` (`id_pasien`, `nama`, `alamat`, `no_telp`) VALUES
	(1, 'Muqiit', 'Bandung', '081324325');
/*!40000 ALTER TABLE `pasien` ENABLE KEYS */;

-- membuang struktur untuk table apotek_oop.pegawai
CREATE TABLE IF NOT EXISTS `pegawai` (
  `id_pegawai` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(30) NOT NULL,
  `nama` varchar(30) NOT NULL,
  `no_telp` varchar(13) NOT NULL,
  `alamat` varchar(50) NOT NULL,
  `id_jabatan` int(11) NOT NULL,
  `level` enum('admin','pegawai') NOT NULL DEFAULT 'pegawai',
  PRIMARY KEY (`id_pegawai`),
  KEY `FK_pegawai_jabatan` (`id_jabatan`),
  CONSTRAINT `FK_pegawai_jabatan` FOREIGN KEY (`id_jabatan`) REFERENCES `jabatan` (`id_jabatan`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- Membuang data untuk tabel apotek_oop.pegawai: ~0 rows (lebih kurang)
/*!40000 ALTER TABLE `pegawai` DISABLE KEYS */;
INSERT IGNORE INTO `pegawai` (`id_pegawai`, `username`, `password`, `nama`, `no_telp`, `alamat`, `id_jabatan`, `level`) VALUES
	(1, 'mmuqiitf', 'muqiit', 'Muqiit', '081313448003', 'Bandung', 1, 'admin');
/*!40000 ALTER TABLE `pegawai` ENABLE KEYS */;

-- membuang struktur untuk table apotek_oop.supplier
CREATE TABLE IF NOT EXISTS `supplier` (
  `id_supplier` int(11) NOT NULL AUTO_INCREMENT,
  `nama` varchar(30) NOT NULL,
  `no_telp` varchar(13) NOT NULL,
  `alamat` varchar(50) NOT NULL,
  PRIMARY KEY (`id_supplier`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- Membuang data untuk tabel apotek_oop.supplier: ~1 rows (lebih kurang)
/*!40000 ALTER TABLE `supplier` DISABLE KEYS */;
INSERT IGNORE INTO `supplier` (`id_supplier`, `nama`, `no_telp`, `alamat`) VALUES
	(1, 'Kimia Farma', '0888234323', 'Bandung');
/*!40000 ALTER TABLE `supplier` ENABLE KEYS */;

-- membuang struktur untuk table apotek_oop.transaksi
CREATE TABLE IF NOT EXISTS `transaksi` (
  `id_transaksi` int(11) NOT NULL AUTO_INCREMENT,
  `id_obat` int(11) NOT NULL,
  `id_pasien` int(11) NOT NULL,
  `id_pegawai` int(11) NOT NULL,
  `qty` int(11) NOT NULL,
  PRIMARY KEY (`id_transaksi`),
  KEY `FK_transaksi_obat` (`id_obat`),
  KEY `FK_transaksi_pasien` (`id_pasien`),
  KEY `FK_transaksi_pegawai` (`id_pegawai`),
  CONSTRAINT `FK_transaksi_obat` FOREIGN KEY (`id_obat`) REFERENCES `obat` (`id_obat`),
  CONSTRAINT `FK_transaksi_pasien` FOREIGN KEY (`id_pasien`) REFERENCES `pasien` (`id_pasien`),
  CONSTRAINT `FK_transaksi_pegawai` FOREIGN KEY (`id_pegawai`) REFERENCES `pegawai` (`id_pegawai`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Membuang data untuk tabel apotek_oop.transaksi: ~0 rows (lebih kurang)
/*!40000 ALTER TABLE `transaksi` DISABLE KEYS */;
/*!40000 ALTER TABLE `transaksi` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
