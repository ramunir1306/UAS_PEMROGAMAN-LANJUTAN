/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package main;

import java.awt.event.ActionListener;
import main.koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import static main.f_Utama.tUserLogin;
/*import static main.popUp_editPtoduk.c_kategori;
import static main.popUp_editPtoduk.t_harga;
import static main.popUp_editPtoduk.t_idProduk;
import static main.popUp_editPtoduk.t_namaProduk2;
import static main.popUp_editPtoduk.t_stok;*/

/**
 * /**
 *
 * @author HP
 */
public class p_Transaksi extends javax.swing.JPanel {

    /**
     * Creates new form Transaksi
     */
    DefaultTableModel modelTransaksi;
    ArrayList<String[]> daftarBelanja = new ArrayList<>();

    public p_Transaksi() {
        initComponents();
        reset();
       // load_tabel_transaksi();
        autonumber();
        Kalkulasi();
    }

    void reset() {
        autonumber();
        t_NamaPelanggan.setText(null);
        t_NamaProduk.setText(null);
        t_HargaSatuan.setText(null);
        t_TtlBelanja.setText(null);
        t_TtlHarga.setText(null);
        t_Bayar.setText(null);
        t_Kembalian.setText(null);
    }
    
    void table_sementara() {
    // Ambil model dari tabel yang sudah ada
    DefaultTableModel model = (DefaultTableModel) t_transaksi.getModel();

    // Ambil data dari input
    String nama_produk = t_NamaProduk.getText();
    String jumlah = t_JmlBeli.getText();
    String harga = t_HargaSatuan.getText();
    String subtotal = t_TtlHarga.getText();

    // Validasi
    if (nama_produk.isEmpty() || jumlah.isEmpty() || harga.isEmpty() || subtotal.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Data tidak boleh kosong!");
        return;
    }

    try {
        int jumlah_beli = Integer.parseInt(jumlah);
        int harga_satuan = KonversiINT(t_HargaSatuan);
        int sub_total = KonversiINT(t_TtlHarga);

        // Hitung nomor otomatis
        int no = model.getRowCount() + 1;

        // Tambahkan data ke model
        model.addRow(new Object[]{
            no, nama_produk, jumlah_beli, harga_satuan, sub_total
        });

        // Set ulang model (opsional jika model-nya sudah terhubung ke tabel)
        t_transaksi.setModel(model);

        // Reset input
        t_NamaProduk.setText(null);
        t_JmlBeli.setText(null);
        t_HargaSatuan.setText(null);
        t_TtlHarga.setText(null);

    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Format angka tidak valid!");
    }
    
        // Hitung total bayar dari semua baris
    int totalBayar = 0;
    for (int i = 0; i < model.getRowCount(); i++) {
        int subTotal = (int) model.getValueAt(i, 4); // Index 4 = kolom "Subtotal"
        totalBayar += subTotal;
    }

    // Tampilkan total ke textfield
    t_TtlBelanja.setText("Rp " + String.format("%,d", totalBayar).replace(',', '.'));

}


   /* void load_tabel_transaksi() {
        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("No.");
        model.addColumn("Nama Produk");
        model.addColumn("Jumlah");
        model.addColumn("Harga Satuan");
        model.addColumn("Subtotal");
        int no = 1;
        String sql = "SELECT id_produk, jumlah_beli, harga_satuan, subtotal FROM detail_transaksi";
            

        try {
            Connection conn = koneksi.konek();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String nama_pelanggan = rs.getString("nama_pelanggan");
                int jml = rs.getInt("jumlah_beli");
                int harga = rs.getInt("harga");
                int sbtotal = rs.getInt("subtotal");
                Object[] baris = {no++, nama_pelanggan, jml, harga, sbtotal};
                model.addRow(baris);
            }
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Gagal mengambil data: " + sQLException.getMessage());
            System.out.println("SQL Error: " + sQLException.getMessage());
        }
        t_transaksi.setModel(model);
    } */

    void hitungTotalBelanja() {
        int total = 0;
        for (String[] item : daftarBelanja) {
            total = Integer.parseInt(item[3]);
        }
        t_TtlBelanja.setText(String.valueOf(total));
    }

    void resetInputProduk() {
        t_NamaProduk.setText("");
        t_HargaSatuan.setText("");
        t_JmlBeli.setText("");
        t_TtlHarga.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        t_IdTransk = new javax.swing.JTextField();
        t_NamaPelanggan = new javax.swing.JTextField();
        t_JmlBeli = new javax.swing.JTextField();
        t_NamaProduk = new javax.swing.JTextField();
        t_HargaSatuan = new javax.swing.JTextField();
        t_TtlHarga = new javax.swing.JTextField();
        t_TtlBelanja = new javax.swing.JTextField();
        t_Bayar = new javax.swing.JTextField();
        t_Kembalian = new javax.swing.JTextField();
        b_cariProduk = new javax.swing.JButton();
        b_tambah = new javax.swing.JButton();
        b_ubah = new javax.swing.JButton();
        b_hapus = new javax.swing.JButton();
        b_reset = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        t_transaksi = new javax.swing.JTable();
        b_cetak = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(1070, 633));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.setPreferredSize(new java.awt.Dimension(1070, 633));

        t_IdTransk.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "ID Transaksi", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));

        t_NamaPelanggan.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Nama Pelanggan", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));

        t_JmlBeli.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Jumlah Beli", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));
        t_JmlBeli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_JmlBeliActionPerformed(evt);
            }
        });
        t_JmlBeli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t_JmlBeliKeyReleased(evt);
            }
        });

        t_NamaProduk.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Nama Produk", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));

        t_HargaSatuan.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Harga Satuan", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));
        t_HargaSatuan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t_HargaSatuanKeyReleased(evt);
            }
        });

        t_TtlHarga.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Total Harga", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));
        t_TtlHarga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_TtlHargaActionPerformed(evt);
            }
        });
        t_TtlHarga.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t_TtlHargaKeyReleased(evt);
            }
        });

        t_TtlBelanja.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Total Belanja", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N
        t_TtlBelanja.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t_TtlBelanjaKeyReleased(evt);
            }
        });

        t_Bayar.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Bayar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));
        t_Bayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_BayarActionPerformed(evt);
            }
        });
        t_Bayar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t_BayarKeyReleased(evt);
            }
        });

        t_Kembalian.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Kembalian", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));
        t_Kembalian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_KembalianActionPerformed(evt);
            }
        });
        t_Kembalian.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t_KembalianKeyReleased(evt);
            }
        });

        b_cariProduk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Search.png"))); // NOI18N
        b_cariProduk.setText("Cari Produk");
        b_cariProduk.setToolTipText("");
        b_cariProduk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_cariProdukActionPerformed(evt);
            }
        });

        b_tambah.setBackground(new java.awt.Color(51, 204, 0));
        b_tambah.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        b_tambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Plus+.png"))); // NOI18N
        b_tambah.setText("Tambah");
        b_tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_tambahActionPerformed(evt);
            }
        });

        b_ubah.setBackground(new java.awt.Color(255, 102, 0));
        b_ubah.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        b_ubah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Edit2.png"))); // NOI18N
        b_ubah.setText("Ubah");
        b_ubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_ubahActionPerformed(evt);
            }
        });

        b_hapus.setBackground(new java.awt.Color(255, 51, 51));
        b_hapus.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        b_hapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/delete.png"))); // NOI18N
        b_hapus.setText("Hapus");
        b_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_hapusActionPerformed(evt);
            }
        });

        b_reset.setBackground(new java.awt.Color(0, 153, 255));
        b_reset.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        b_reset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/reset.png"))); // NOI18N
        b_reset.setText("Reset");
        b_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_resetActionPerformed(evt);
            }
        });

        t_transaksi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No.", "Nama Produk", "Jumlah Beli", "Harga Satuan", "Subtotal"
            }
        ));
        jScrollPane1.setViewportView(t_transaksi);

        b_cetak.setBackground(new java.awt.Color(153, 153, 153));
        b_cetak.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        b_cetak.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Print.png"))); // NOI18N
        b_cetak.setText("Cetak");
        b_cetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_cetakActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("SansSerif", 3, 36)); // NOI18N
        jLabel1.setText("Transaksi ");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 883, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(b_cetak))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                    .addGap(466, 466, 466)
                                    .addComponent(b_tambah, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(b_ubah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel3Layout.createSequentialGroup()
                                                    .addComponent(t_IdTransk, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(t_NamaPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(b_cariProduk, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(t_TtlBelanja, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addComponent(t_JmlBeli, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(t_NamaProduk, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(jPanel3Layout.createSequentialGroup()
                                                    .addComponent(t_HargaSatuan, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(t_TtlHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(t_Bayar, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(t_Kembalian, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(b_hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(b_reset, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(t_IdTransk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(t_NamaPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(t_Bayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(t_Kembalian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(b_cariProduk, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(t_NamaProduk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(t_TtlBelanja, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(t_HargaSatuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(t_TtlHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(t_JmlBeli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b_tambah)
                    .addComponent(b_ubah)
                    .addComponent(b_hapus)
                    .addComponent(b_reset))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(b_cetak)
                        .addGap(48, 48, 48))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(11, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 1052, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1070, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 633, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void t_JmlBeliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_JmlBeliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_JmlBeliActionPerformed

    private void t_BayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_BayarActionPerformed
        // TODO add your handling code here:
        t_Bayar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                try {
                    int bayar = Integer.parseInt(t_Bayar.getText());
                    int total = Integer.parseInt(t_TtlBelanja.getText());
                    t_Kembalian.setText(String.valueOf(bayar - total));
                } catch (NumberFormatException e) {
                    t_Kembalian.setText("0");
                }
            }
        });
    }//GEN-LAST:event_t_BayarActionPerformed

    private void t_KembalianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_KembalianActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_KembalianActionPerformed

    private void b_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_tambahActionPerformed
    
        table_sementara();
        
        
        
        /*  String id_transaksi = t_IdTransk.getText();
        String nama_pelanggan = t_NamaPelanggan.getText();
        String kategori = (t_NamaProduk.getText().toString());
        String jumlah_beli = t_JmlBeli.getText();
        String harga_satuan = t_HargaSatuan.getText();
        String subTotal = t_TtlBelanja.getText();
        String user = tUserLogin.getText();
        //Query SQL
        try {
            String sql = "INSERT INTO detail_transaksi(id_transaksi, nama_pelanggan, id_produk, jumlah_beli, harga_satuan,subtotal,user)"
                    + "VALUES (?,?,?,?,?,?,?)";
            Connection con = koneksi.konek();//buat koneksi ke DB
            //siapkan query SQL utk dieksekusi
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, id_transaksi);
            ps.setString(2, nama_pelanggan);
            ps.setString(3, kategori);
            ps.setString(4, jumlah_beli);
            ps.setString(5, harga_satuan);
            ps.setString(6, subTotal);
            ps.setString(7, user);
            //jalankan query
            ps.execute();

            //tampilkan pesan bahwa data berhasil disimpan
           // JOptionPane.showMessageDialog(null, "Data berhasil disimpan");
        } catch (SQLException sQLException) {
            //tampilkan pesan error jika gagal menyimpan
            JOptionPane.showMessageDialog(null, "Data gagal disimpan!"+ sQLException);
            System.out.println(sQLException);
        }*/
    }//GEN-LAST:event_b_tambahActionPerformed

    private void b_ubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_ubahActionPerformed

       
        
                                            

    }//GEN-LAST:event_b_ubahActionPerformed

    private void b_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_hapusActionPerformed
        int row = t_transaksi.getSelectedRow();
        if (row >= 0) {
            daftarBelanja.remove(row);
            modelTransaksi.removeRow(row);
            hitungTotalBelanja();
        }
    }//GEN-LAST:event_b_hapusActionPerformed

    private void b_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_resetActionPerformed
        reset();
    }//GEN-LAST:event_b_resetActionPerformed

    private void b_cetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_cetakActionPerformed

        String idTransaksi = t_IdTransk.getText();
        String namaPelanggan = t_NamaPelanggan.getText();
        int totalBelanja = Integer.parseInt(t_TtlBelanja.getText());
        int bayar = Integer.parseInt(t_Bayar.getText());
        int kembalian = Integer.parseInt(t_Kembalian.getText());

        try {
            Connection conn = koneksi.konek();
            conn.setAutoCommit(false);

            PreparedStatement pstTrans = conn.prepareStatement(
                    "INSERT INTO transaksi(id_transaksi, nama_pelanggan, total, bayar, kembalian, tanggal) VALUES (?, ?, ?, ?, ?, NOW())");
            pstTrans.setString(1, idTransaksi);
            pstTrans.setString(2, namaPelanggan);
            pstTrans.setInt(3, totalBelanja);
            pstTrans.setInt(4, bayar);
            pstTrans.setInt(5, kembalian);
            pstTrans.executeUpdate();

            for (String[] item : daftarBelanja) {
                String namaProduk = item[0];
                int jumlah = Integer.parseInt(item[1]);
                int subtotal = Integer.parseInt(item[3]);

                PreparedStatement pstGetId = conn.prepareStatement("SELECT id_produk FROM produk WHERE nama_produk=?");
                pstGetId.setString(1, namaProduk);
                ResultSet rs = pstGetId.executeQuery();
                String idProduk = "";
                if (rs.next()) {
                    idProduk = rs.getString("id_produk");
                }

                PreparedStatement pstDetail = conn.prepareStatement(
                        "INSERT INTO detail_transaksi(id_transaksi, id_produk, jumlah_beli, subtotal) VALUES (?, ?, ?, ?)");
                pstDetail.setString(1, idTransaksi);
                pstDetail.setString(2, idProduk);
                pstDetail.setInt(3, jumlah);
                pstDetail.setInt(4, subtotal);
                pstDetail.executeUpdate();

                PreparedStatement pstUpdateStok = conn.prepareStatement(
                        "UPDATE produk SET stok = stok - ? WHERE id_produk=?");
                pstUpdateStok.setInt(1, jumlah);
                pstUpdateStok.setString(2, idProduk);
                pstUpdateStok.executeUpdate();
            }

            conn.commit();
            JOptionPane.showMessageDialog(this, "Transaksi berhasil disimpan!");
            reset();
            modelTransaksi.setRowCount(0);
            daftarBelanja.clear();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Gagal simpan transaksi: " + e.getMessage());
            e.printStackTrace();
        }

    }//GEN-LAST:event_b_cetakActionPerformed

    private void t_TtlHargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_TtlHargaActionPerformed
        // TODO add your handling code here:
        t_JmlBeli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                try {
                    int jumlah = Integer.parseInt(t_JmlBeli.getText());
                    int harga = Integer.parseInt(t_HargaSatuan.getText());
                    t_TtlHarga.setText(String.valueOf(jumlah * harga));
                } catch (NumberFormatException e) {
                    t_TtlHarga.setText("0");
                }
            }
        });
    }//GEN-LAST:event_t_TtlHargaActionPerformed

    private void b_cariProdukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_cariProdukActionPerformed
        // TODO add your handling code here:
        popUp_cariProduk pt = new popUp_cariProduk();
        pt.setVisible(true);

    }//GEN-LAST:event_b_cariProdukActionPerformed

    private void t_BayarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_BayarKeyReleased
        formatUangIDR(t_Bayar);
         // Ambil nilai dari text field dan hapus "Rp" serta titik
        String total_belanja = t_TtlBelanja.getText().replaceAll("[^\\d]", "");
        String bayar = t_Bayar.getText().replaceAll("[^\\d]", "");

        // Konversi ke int
        int total = Integer.parseInt(total_belanja);
        int tunai = Integer.parseInt(bayar);

        // Hitung kembalian
        int kembalian = tunai - total;

        // Tampilkan kembalian dalam format uang
        t_Kembalian.setText("Rp " + String.format("%,d", kembalian).replace(',', '.'));
    }//GEN-LAST:event_t_BayarKeyReleased

    private void t_HargaSatuanKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_HargaSatuanKeyReleased
        // TODO add your handling code here:
        formatUangIDR(t_HargaSatuan);
        
    }//GEN-LAST:event_t_HargaSatuanKeyReleased

    private void t_TtlHargaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_TtlHargaKeyReleased
        // TODO add your handling code here:
        formatUangIDR(t_TtlHarga);
    }//GEN-LAST:event_t_TtlHargaKeyReleased

    private void t_TtlBelanjaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_TtlBelanjaKeyReleased
        // TODO add your handling code here:
        formatUangIDR(t_TtlBelanja);
    }//GEN-LAST:event_t_TtlBelanjaKeyReleased

    private void t_KembalianKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_KembalianKeyReleased
      
       

    }//GEN-LAST:event_t_KembalianKeyReleased

    private void t_JmlBeliKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_JmlBeliKeyReleased
        // TODO add your handling code here:
        Kalkulasi();
    }//GEN-LAST:event_t_JmlBeliKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_cariProduk;
    private javax.swing.JButton b_cetak;
    private javax.swing.JButton b_hapus;
    private javax.swing.JButton b_reset;
    private javax.swing.JButton b_tambah;
    private javax.swing.JButton b_ubah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField t_Bayar;
    public static javax.swing.JTextField t_HargaSatuan;
    private javax.swing.JTextField t_IdTransk;
    private javax.swing.JTextField t_JmlBeli;
    private javax.swing.JTextField t_Kembalian;
    private javax.swing.JTextField t_NamaPelanggan;
    public static javax.swing.JTextField t_NamaProduk;
    private javax.swing.JTextField t_TtlBelanja;
    private javax.swing.JTextField t_TtlHarga;
    private javax.swing.JTable t_transaksi;
    // End of variables declaration//GEN-END:variables
private void autonumber() {
        try {
            java.sql.Connection conn = koneksi.konek();
            java.sql.Statement statement = conn.createStatement();
            String sql = "SELECT * FROM transaksi ORDER BY id_transaksi DESC";
            java.sql.ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                String Id_Pelanggan = resultSet.getString("id_transaksi").substring(2);
                String IP = "" + (Integer.parseInt(Id_Pelanggan) + 1);
                String Nol = "";

                if (IP.length() == 1) {
                    Nol = "000";
                } else if (IP.length() == 2) {
                    Nol = "00";
                } else if (IP.length() == 3) {
                    Nol = "";
                }

                t_IdTransk.setText("TK" + Nol + IP);
            } else {
                t_IdTransk.setText("TK0001");
            }
            resultSet.close();
            statement.close();
        } catch (Exception e) {
            System.out.println("autonumber error");
        }
        t_IdTransk.setEditable(false);
    }

    private void formatUangIDR(JTextField field) {
        String input = field.getText();
        if (!input.isEmpty()) {
            input = input.replaceAll("[^\\d]", ""); // Hapus karakter selain angka
            try {
                long value = Long.parseLong(input);
                field.setText("Rp " + String.format("%,d", value).replace(',', '.'));
            } catch (NumberFormatException ex) {
                field.setText("Rp 0");
            }
        } else {
            field.setText("Rp 0");
        }
    }

    private void Kalkulasi() {
        try {
            // Ambil harga dari tf_Harga (hapus "Rp" dan pemisah ribuan)
            String hargaText = t_HargaSatuan.getText().replaceAll("[^\\d]", ""); // Hapus "Rp" dan tanda titik
            long harga = Long.parseLong(hargaText); // Konversi ke long

            // Ambil berat dari tf_Berat (pastikan validasi hanya angka/desimal)
            String beratText = t_JmlBeli.getText().replaceAll("[^\\d.]", ""); // Hanya angka/desimal
            double jmlBeli = beratText.isEmpty() ? 0 : Double.parseDouble(beratText); // Jika kosong, berat = 0

            // Hitung total harga
            long total = (long) (harga * jmlBeli);

            // Tampilkan total di tf_Total dengan format mata uang
            t_TtlHarga.setText("Rp " + String.format("%,d", total).replace(',', '.'));
        } catch (NumberFormatException e) {
            // Jika input tidak valid, kosongkan tf_Total
            t_TtlHarga.setText("Rp 0");
        }
    }
    
    private int KonversiINT(JTextField field){
        String input =  field.getText().replaceAll("[^\\d]", ""); //Hapus semua karakter kecuali angka
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

//    private void initListeners() {
//        // Tambahkan listener untuk mendeteksi perubahan pada tf_Total dan tf_Tunai
//        tf_Total.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
//            @Override
//            public void insertUpdate(javax.swing.event.DocumentEvent e) {
//                HitungKembalian();
//            }
//
//            @Override
//            public void removeUpdate(javax.swing.event.DocumentEvent e) {
//                HitungKembalian();
//            }
//
//            @Override
//            public void changedUpdate(javax.swing.event.DocumentEvent e) {
//                HitungKembalian();
//            }
//        });
//
//        tf_Tunai.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
//            @Override
//            public void insertUpdate(javax.swing.event.DocumentEvent e) {
//                HitungKembalian();
//            }
//
//            @Override
//            public void removeUpdate(javax.swing.event.DocumentEvent e) {
//                HitungKembalian();
//            }
//
//            @Override
//            public void changedUpdate(javax.swing.event.DocumentEvent e) {
//                HitungKembalian();
//            }
//        });
//    }
//
//    private void HitungKembalian() {
//        try {
//            // Ambil total dari tf_Total (hapus "Rp" dan pemisah ribuan)
//            String totalText = tf_Total.getText().replaceAll("[^\\d]", ""); // Hapus "Rp" dan tanda titik
//            long total = totalText.isEmpty() ? 0 : Long.parseLong(totalText); // Jika kosong, total = 0
//
//            // Ambil tunai dari tf_Tunai (hanya angka)
//            String tunaiText = tf_Tunai.getText().replaceAll("[^\\d]", ""); // Hapus karakter non-angka
//            long tunai = tunaiText.isEmpty() ? 0 : Long.parseLong(tunaiText); // Jika kosong, tunai = 0
//
//            // Hitung kembalian
//            long kembali = tunai - total;
//
//            // Tampilkan kembalian di tf_Kembali dengan format mata uang
//            tf_Kembali.setText("Rp " + String.format("%,d", kembali).replace(',', '.'));
//        } catch (NumberFormatException e) {
//            // Jika input tidak valid, kosongkan tf_Kembali
//            tfF_Kembali.setText("Rp 0");
//        }
//    }
}
