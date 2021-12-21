package com.company.ui;

import com.company.algorithmrsa.rsaaes.AlgorithmAES;
import com.company.algorithmrsa.rsaaes.GenerateKey;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;

public class UIRSAController extends JFrame {
    private JLabel JLabelImage;
    private JLabel JLabel1;
    private JLabel JLabel2;

    private JButton btnBrowser;
    private JButton btnDescription;
    private JButton btnEnCription;
    private JButton btnReset;

    private JScrollPane jScrollPane;
    private JTable jTable;
    private JTextField fileNameText;

    DefaultTableModel dtm = new DefaultTableModel(0, 0);
    String header[] = new String[]{"No", "Name File", "File Type", "Proccess", "Start Time", "End Time", "Total Time (s/m)"};
    int a = 1;
    String aesKeyUI, namaFile;
    String[] arrNamaFile;
    File encryptedFile;

    public UIRSAController() {
        initComponent();
    }

    private void initComponent() {
        JLabelImage = new JLabel();
        JLabel1 = new JLabel();
        JLabel2 = new JLabel();

        btnBrowser = new JButton();
        btnEnCription = new JButton();
        btnDescription = new JButton();
        btnReset = new JButton();

        fileNameText = new JTextField();
        jScrollPane = new JScrollPane();
        jTable = new JTable();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        btnBrowser.setText("Browse");
        btnBrowser.addActionListener((event) -> {
            try {
                browserActionPerpormance(event);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        JLabel1.setFont(new Font("Times New Roman", 1, 24));
        JLabel1.setText("Algorithm RSA");
        JLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel1.setVerticalAlignment(SwingConstants.CENTER);

        btnEnCription.setText("Encription");
        btnEnCription.addActionListener((event) -> {
            try {
                // dumy method
                btnEncryptionAction(event);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (NoSuchPaddingException e) {
                e.printStackTrace();
            } catch (IllegalBlockSizeException e) {
                e.printStackTrace();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            } catch (BadPaddingException e) {
                e.printStackTrace();
            } catch (InvalidKeyException e) {
                e.printStackTrace();
            }
        });

        btnDescription.setText("Decription");
        btnDescription.addActionListener((event) -> {
            try {
                // dumy method
                btnDencryptionAction(event);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (NoSuchPaddingException e) {
                e.printStackTrace();
            } catch (IllegalBlockSizeException e) {
                e.printStackTrace();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            } catch (BadPaddingException e) {
                e.printStackTrace();
            } catch (InvalidKeyException e) {
                e.printStackTrace();
            }
        });

        JLabel2.setFont(new Font("Times New Roman", 1, 24));
        JLabel2.setText("Output");
        JLabel2.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel2.setVerticalAlignment(SwingConstants.CENTER);

        btnReset.setText("Reset");
        btnReset.addActionListener((event) -> {
            // dumy method
            btnResetAction(event);
        });

        fileNameText.setEditable(false);
        jTable.setRowHeight(20);
        dtm.setColumnIdentifiers(header);
        jTable.setModel(dtm);

        jScrollPane.setViewportView(jTable);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createParallelGroup()));
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(JLabelImage, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
                                                                        .addGroup(layout.createSequentialGroup().addGap(8, 8, 8).addComponent(btnEnCription)))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(fileNameText, GroupLayout.PREFERRED_SIZE, 450, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(btnBrowser).addComponent(btnReset).addComponent(btnDescription)))
                                                        .addComponent(jScrollPane, GroupLayout.PREFERRED_SIZE, 800, GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createSequentialGroup().addGap(182, 182, 182).addComponent(JLabel1)))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup().addGap(107, 107, 107).addComponent(JLabel2)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//                                .addComponent(txtkey, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(48, 48, 48))
        );
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup()
                        .addContainerGap().addComponent(JLabel1).addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(JLabelImage, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup().addGap(15, 15, 15).addComponent(btnBrowser)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(fileNameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(btnReset)))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(btnEnCription).addComponent(btnDescription)).addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(JLabel2))
//                                .addComponent(txtkey, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(186, Short.MAX_VALUE))
        );
        pack();
    }

    private void btnResetAction(ActionEvent event) {
        resetValue();
    }

    public void resetValue() {
        JLabelImage.setIcon(new ImageIcon(""));
        fileNameText.setText("");

        // reset table row
        a = 1;
        aesKeyUI = "";
        namaFile = "";
        arrNamaFile = new String[50];
        File encrypted;
        if (dtm.getRowCount() > 0) {
            for (int i = jTable.getRowCount() - 1; i > -1; i--) {
                dtm.removeRow(i);
            }
        }
    }

    private void btnEncryptionAction(ActionEvent event) throws NoSuchPaddingException, IllegalBlockSizeException, IOException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        if (fileNameText.getText() != null && !fileNameText.getText().equals("")) {
            namaFile = fileNameText.getText();
            arrNamaFile = namaFile.split("\\\\");
            namaFile = arrNamaFile[arrNamaFile.length - 1];
            arrNamaFile = namaFile.split("\\.");

            GenerateKey gk = this.genKeyData();
            File readFile = new File(fileNameText.getText());
            encryptedFile = new File("DataFile/" + arrNamaFile[0].concat("_Encrypted.").concat(arrNamaFile[1]));
            Timestamp startTime = new Timestamp(System.currentTimeMillis());
            long start = System.currentTimeMillis();
            AlgorithmAES.encryptedAES(gk.getAesKey(), readFile, encryptedFile);
            long end = System.currentTimeMillis();
            long elapsedTime = end - start;
            Timestamp endTime = new Timestamp(System.currentTimeMillis());
            aesKeyUI = gk.getAesKey();
            jTable.getModel();
            JLabelImage.setText("");
            JOptionPane.showMessageDialog(null, "Success Encrypted File");
            dtm.addRow(new Object[]{a++,arrNamaFile[0],"Encrypted",startTime,endTime,elapsedTime});
        } else {
            JOptionPane.showMessageDialog(null, "Please Choose File");
        }
    }

    private GenerateKey genKeyData() throws IOException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException {
        GenerateKey gk = new GenerateKey();
        gk.generateKeyRandom();
        gk.generateKeyPair();
        gk.encryptedAesKey();
        gk.decryptedAesKey();
        return gk;
    }

    private void btnDencryptionAction(ActionEvent event) throws NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, IOException, BadPaddingException, InvalidKeyException {
        if (aesKeyUI != null && !aesKeyUI.equals("")) {
            File decriptedFile = new File("Datafile/" + arrNamaFile[0].concat("_Decrypted.").concat(arrNamaFile[1]));
            Timestamp startTime = new Timestamp(System.currentTimeMillis());
            long start = System.currentTimeMillis();
            AlgorithmAES.dencryptedAES(aesKeyUI,encryptedFile,decriptedFile);
            long end = System.currentTimeMillis();
            long elapsedTime = end - start;
            Timestamp endTime = new Timestamp(System.currentTimeMillis());
            JOptionPane.showMessageDialog(null,"File Success Decrypted");
            dtm.addRow(new Object[]{a++,arrNamaFile[0],"Decrypted",startTime,endTime,elapsedTime});
        } else {
            JOptionPane.showMessageDialog(null,"Please Choose File Decrypted");
        }
    }

    private void browserActionPerpormance(ActionEvent event) throws IOException {
        JFileChooser browseImageFIle = new JFileChooser();
        browseImageFIle.showOpenDialog(null);
        File f = browseImageFIle.getSelectedFile();
        String fileName = f.getAbsolutePath();
        fileNameText.setText(fileName);

        Image getAbsolutePath = null;
        String extension = "";
        int i = fileName.lastIndexOf('.');
        if (i >= 0) {
            extension = fileName.substring(i + 1);
        }

        ImageIcon imageIcon;
        Image image;

        if ("BMP".equals(extension.toUpperCase())) {
            image = ImageIO.read(new File((f.getAbsolutePath())));
            imageIcon = new ImageIcon();
        } else {
            imageIcon = new ImageIcon(fileName);
            image = imageIcon.getImage().getScaledInstance(JLabelImage.getWidth(), JLabelImage.getHeight(), Image.SCALE_SMOOTH);
        }

        JLabel jLabel = new JLabel(imageIcon);
        JLabelImage.setIcon(imageIcon);
        JLabelImage.setIcon(new ImageIcon(image));
    }

    public static void main(String[] args) {

        /**
         * #1. create UI
         * #2, Action all btn
         * */

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new UIRSAController().setVisible(true);
            }
        });
    }
}
