
package com.javarush.cryptanalyser.abdeev.GUI;

import com.javarush.cryptanalyser.abdeev.repository.FileOutput;
import com.javarush.cryptanalyser.abdeev.repository.FileInput;
import com.javarush.cryptanalyser.abdeev.services.CodeCracker;
import com.javarush.cryptanalyser.abdeev.services.Decoder;
import com.javarush.cryptanalyser.abdeev.services.Encryptor;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.nio.file.Path;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class GraphicUserInterface extends JFrame {


    public GraphicUserInterface() {
        visualSetup();
        initComponents();

    }
    FileInput input = new FileInput();
    FileOutput out = new FileOutput();
    CodeCracker crack = new CodeCracker();
    Encryptor encryptor = new Encryptor();
    private void initComponents() {


        JTabbedPane jTabbedPane = new JTabbedPane();

            JPanel firstFuncWindow = new JPanel();
                    JLabel jLabel1 = new JLabel();
                JButton chooseFileButton1 = new JButton();
                chosenFilePathTextField1 = new javax.swing.JTextField();
                    JLabel jLabel5 = new JLabel();
                chosenFileContentExampleTextField1 = new javax.swing.JTextField();
                    JLabel jLabel3 = new JLabel();
                JLabel jLabel2 = new JLabel();
                enterKeyTextField1 = new javax.swing.JFormattedTextField();
                startEncryptingButton1 = new javax.swing.JButton();
                resultFileContentExampleTextField1 = new javax.swing.JTextField();
                    JLabel jLabel4 = new JLabel();
                resultFilePathTextField1 = new javax.swing.JTextField();
                    JLabel jLabel6 = new JLabel();
                resultFileCopyPathButton1 = new javax.swing.JButton();
                resultFileOpenButton1 = new javax.swing.JButton();
                resultFileOpenFolder1 = new javax.swing.JButton();

            JPanel secondFuncWindow = new JPanel();
                JLabel jLabel9 = new JLabel();
                JButton chooseFileButton2 = new JButton();
                chosenFilePathTextField2 = new javax.swing.JTextField();
                    JLabel jLabel7 = new JLabel();
                chosenFileContentExampleTextField2 = new javax.swing.JTextField();
                    JLabel jLabel11 = new JLabel();
                JLabel jLabel10 = new JLabel();
                enterKeyTextField2 = new javax.swing.JFormattedTextField();
                startDecryptButton2 = new javax.swing.JButton();
                resultFileContentExampleTextField2 = new javax.swing.JTextField();
                    JLabel jLabel12 = new JLabel();
                resultFilePathTextField2 = new javax.swing.JTextField();
                    JLabel jLabel8 = new JLabel();
                resultFileCopyPathButton2 = new javax.swing.JButton();
                resultFileOpenButton2 = new javax.swing.JButton();
                resultFileOpenFolder2 = new javax.swing.JButton();

            JPanel thirdFuncWindow = new JPanel();
                JLabel jLabel15 = new JLabel();
                JButton chooseFileButton3 = new JButton();
                chosenFilePathTextField3 = new javax.swing.JTextField();
                    JLabel jLabel13 = new JLabel();
                chosenFileContentExampleTextField3 = new javax.swing.JTextField();
                    JLabel jLabel17 = new JLabel();
                startDecryptButton3 = new javax.swing.JButton();
                resultFileContentExampleTextField3 = new javax.swing.JTextField();
                    JLabel jLabel18 = new JLabel();
                resultFilePathTextField3 = new javax.swing.JTextField();
                    JLabel jLabel14 = new JLabel();
                resultFileCopyPathButton3 = new javax.swing.JButton();
                resultFileOpenButton3 = new javax.swing.JButton();
                resultFileOpenFolder3 = new javax.swing.JButton();


        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Crypto Analyser");
        setLocation(new java.awt.Point(320, 180));
        setVisible(true);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Microsoft YaHei UI", Font.PLAIN, 14));
        jLabel1.setText("Выберите текстовой файл             ");

        chooseFileButton1.setText("Выбрать файл");
        chooseFileButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        chooseFileButton1.addActionListener(evt -> jButton1ActionPerformed());

        chosenFilePathTextField1.setEditable(false);
        chosenFilePathTextField1.setBackground(new java.awt.Color(204, 204, 204));
        chosenFilePathTextField1.setFont(new java.awt.Font("Lucida Console", Font.PLAIN, 12));
        chosenFilePathTextField1.setToolTipText("Ссылка на файл");

        jLabel2.setFont(new java.awt.Font("Microsoft YaHei UI", Font.PLAIN, 14));
        jLabel2.setText("Введите ключ шифрования");

        startEncryptingButton1.setBackground(new java.awt.Color(102, 204, 255));
        startEncryptingButton1.setFont(new java.awt.Font("Segoe UI", Font.PLAIN, 14));
        startEncryptingButton1.setText("Зашифровать");
        startEncryptingButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        startEncryptingButton1.setEnabled(false);
        startEncryptingButton1.addActionListener(evt -> jButton2ActionPerformed());
        enterKeyTextField1.setToolTipText("Введите ключ шифрования здесь...");

        enterKeyTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jFormattedTextField1KeyReleased();
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jFormattedTextField1KeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", Font.PLAIN, 10));
        jLabel3.setText("(Примерное содержание файла)");

        resultFileContentExampleTextField1.setEditable(false);
        resultFileContentExampleTextField1.setBackground(new java.awt.Color(204, 204, 204));
        resultFileContentExampleTextField1.setFont(new java.awt.Font("Segoe UI", Font.PLAIN, 14));
        resultFileContentExampleTextField1.setToolTipText("Часть текста из файла");
        resultFileContentExampleTextField1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        chosenFileContentExampleTextField1.setEditable(false);
        chosenFileContentExampleTextField1.setBackground(new java.awt.Color(204, 204, 204));
        chosenFileContentExampleTextField1.setFont(new java.awt.Font("Segoe UI", Font.PLAIN, 14));
        chosenFileContentExampleTextField1.setToolTipText("Часть текста из файла");
        chosenFileContentExampleTextField1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel4.setFont(new java.awt.Font("Segoe UI", Font.PLAIN, 10));
        jLabel4.setText("(Результат шифрования)");

        jLabel5.setFont(new java.awt.Font("Segoe UI", Font.PLAIN, 10));
        jLabel5.setText("(Ссылка на исходный файл)");

        resultFilePathTextField1.setEditable(false);
        resultFilePathTextField1.setBackground(new java.awt.Color(204, 204, 204));
        resultFilePathTextField1.setToolTipText("Ссылка на файл с зашифрованным текстом");
        resultFilePathTextField1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jLabel6.setFont(new java.awt.Font("Segoe UI", Font.PLAIN, 10));
        jLabel6.setText("(Ссылка на файл с зашифрованным текстом)");

        resultFileCopyPathButton1.setText("Скопировать ссылку");
        resultFileCopyPathButton1.setEnabled(false);
        resultFileCopyPathButton1.addActionListener(evt -> jButton3ActionPerformed());

        resultFileOpenButton1.setText("Открыть файл");
        resultFileOpenButton1.setEnabled(false);
        resultFileOpenButton1.addActionListener(evt -> jButton4ActionPerformed());

        resultFileOpenFolder1.setText("Открыть папку с файлом");
        resultFileOpenFolder1.setEnabled(false);
        resultFileOpenFolder1.addActionListener(evt -> jButton5ActionPerformed());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(firstFuncWindow);
        firstFuncWindow.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(279, 279, 279)
                                .addComponent(jLabel5))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(269, 269, 269)
                                .addComponent(jLabel3))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(288, 288, 288)
                                .addComponent(jLabel4)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(resultFileContentExampleTextField1)
                            .addComponent(chosenFilePathTextField1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(enterKeyTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(startEncryptingButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(chosenFileContentExampleTextField1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(152, 152, 152)
                                        .addComponent(chooseFileButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(resultFileCopyPathButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(resultFileOpenButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(resultFileOpenFolder1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addComponent(resultFilePathTextField1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chooseFileButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chosenFilePathTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chosenFileContentExampleTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(enterKeyTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(startEncryptingButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(resultFileContentExampleTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(resultFilePathTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(resultFileCopyPathButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(resultFileOpenButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(resultFileOpenFolder1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(245, 245, 245))
        );

        jTabbedPane.addTab("Зашифровать текст из файла", firstFuncWindow);

        resultFileContentExampleTextField2.setEditable(false);
        resultFileContentExampleTextField2.setBackground(new java.awt.Color(204, 204, 204));
        resultFileContentExampleTextField2.setFont(new java.awt.Font("Segoe UI", Font.PLAIN, 14));
        resultFileContentExampleTextField2.setToolTipText("Часть текста из файла");
        resultFileContentExampleTextField2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));


        jLabel7.setFont(new java.awt.Font("Segoe UI", Font.PLAIN, 10));
        jLabel7.setText("(Ссылка на зашифрованный файл)");

        resultFilePathTextField2.setEditable(false);
        resultFilePathTextField2.setBackground(new java.awt.Color(204, 204, 204));
        resultFilePathTextField2.setToolTipText("Ссылка на файл с зашифрованным текстом");
        resultFilePathTextField2.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));


        jLabel8.setFont(new java.awt.Font("Segoe UI", Font.PLAIN, 10));
        jLabel8.setText("(Ссылка на файл с расшифрованным текстом)");

        resultFileCopyPathButton2.setText("Скопировать ссылку");
        resultFileCopyPathButton2.setEnabled(false);
        resultFileCopyPathButton2.addActionListener(evt -> jButton6ActionPerformed());

        resultFileOpenButton2.setText("Открыть файл");
        resultFileOpenButton2.setEnabled(false);
        resultFileOpenButton2.addActionListener(evt -> jButton7ActionPerformed());

        jLabel9.setFont(new java.awt.Font("Microsoft YaHei UI", Font.PLAIN, 14));
        jLabel9.setText("Выберите зашифрованный файл ");

        chooseFileButton2.setText("Выбрать файл");
        chooseFileButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        chooseFileButton2.addActionListener(evt -> jButton8ActionPerformed());

        chosenFilePathTextField2.setEditable(false);
        chosenFilePathTextField2.setBackground(new java.awt.Color(204, 204, 204));
        chosenFilePathTextField2.setFont(new java.awt.Font("Lucida Console", Font.PLAIN, 12));
        chosenFilePathTextField2.setToolTipText("Ссылка на файл");


        jLabel10.setFont(new java.awt.Font("Microsoft YaHei UI", Font.PLAIN, 14));
        jLabel10.setText("Введите ключ для расшифровки");

        startDecryptButton2.setBackground(new java.awt.Color(0, 204, 51));
        startDecryptButton2.setFont(new java.awt.Font("Segoe UI", Font.PLAIN, 14));
        startDecryptButton2.setText("Расшифровать");
        startDecryptButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        startDecryptButton2.setEnabled(false);
        startDecryptButton2.addActionListener(evt -> jButton9ActionPerformed());

        enterKeyTextField2.setToolTipText("Введите ключ шифрования здесь...");

        enterKeyTextField2.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent evt) {
                jFormattedTextField2KeyReleased();
            }
            public void keyTyped(KeyEvent evt) {
                jFormattedTextField2KeyTyped(evt);
            }
        });

        chosenFileContentExampleTextField2.setEditable(false);
        chosenFileContentExampleTextField2.setBackground(new java.awt.Color(204, 204, 204));
        chosenFileContentExampleTextField2.setFont(new java.awt.Font("Segoe UI", Font.PLAIN, 14));
        chosenFileContentExampleTextField2.setToolTipText("Часть текста из файла");
        chosenFileContentExampleTextField2.setCursor(new java.awt.Cursor(Cursor.DEFAULT_CURSOR));

        resultFileOpenFolder2.setText("Открыть папку с файлом");
        resultFileOpenFolder2.setEnabled(false);
        resultFileOpenFolder2.addActionListener(evt -> jButton10ActionPerformed());

        jLabel11.setFont(new java.awt.Font("Segoe UI", Font.PLAIN, 10));
        jLabel11.setText("(Примерное содержание файла)");

        jLabel12.setFont(new java.awt.Font("Segoe UI", Font.PLAIN, 10));
        jLabel12.setText("(Результат дешифрования)");

        javax.swing.GroupLayout jPanel2Layout = new GroupLayout(secondFuncWindow);
        secondFuncWindow.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(269, 269, 269)
                                .addComponent(jLabel11))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(288, 288, 288)
                                .addComponent(jLabel12)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(resultFileContentExampleTextField2)
                            .addComponent(chosenFilePathTextField2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(enterKeyTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(startDecryptButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(chosenFileContentExampleTextField2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addGap(152, 152, 152)
                                        .addComponent(chooseFileButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(resultFileCopyPathButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel8)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(resultFileOpenButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(resultFileOpenFolder2, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addComponent(resultFilePathTextField2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(265, 265, 265)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chooseFileButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chosenFilePathTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chosenFileContentExampleTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(24, 24, 24)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(enterKeyTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(startDecryptButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(resultFileContentExampleTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(resultFilePathTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(resultFileCopyPathButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(resultFileOpenButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(resultFileOpenFolder2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(245, 245, 245))
        );

        jTabbedPane.addTab("Расшифровать текст из файла по ключу", secondFuncWindow);

        resultFileContentExampleTextField3.setEditable(false);
        resultFileContentExampleTextField3.setBackground(new java.awt.Color(204, 204, 204));
        resultFileContentExampleTextField3.setFont(new java.awt.Font("Segoe UI", Font.PLAIN, 14));
        resultFileContentExampleTextField3.setToolTipText("Часть текста из файла");
        resultFileContentExampleTextField3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));


        jLabel13.setFont(new java.awt.Font("Segoe UI", Font.PLAIN, 10));
        jLabel13.setText("(Ссылка на зашифрованный файл)");

        resultFilePathTextField3.setEditable(false);
        resultFilePathTextField3.setBackground(new java.awt.Color(204, 204, 204));
        resultFilePathTextField3.setToolTipText("Ссылка на файл с зашифрованным текстом");
        resultFilePathTextField3.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));



        jLabel14.setFont(new java.awt.Font("Segoe UI", Font.PLAIN, 10));
        jLabel14.setText("(Ссылка на файл с взломанным текстом)");

        resultFileCopyPathButton3.setText("Скопировать ссылку");
        resultFileCopyPathButton3.setEnabled(false);
        resultFileCopyPathButton3.addActionListener(evt -> jButton11ActionPerformed());

        resultFileOpenButton3.setText("Открыть файл");
        resultFileOpenButton3.setEnabled(false);
        resultFileOpenButton3.addActionListener(evt -> jButton12ActionPerformed());

        jLabel15.setFont(new java.awt.Font("Microsoft YaHei UI", Font.PLAIN, 14));
        jLabel15.setText("Выберите зашифрованный файл ");

        chooseFileButton3.setText("Выбрать файл");
        chooseFileButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        chooseFileButton3.addActionListener(evt -> jButton13ActionPerformed());

        chosenFilePathTextField3.setEditable(false);
        chosenFilePathTextField3.setBackground(new java.awt.Color(204, 204, 204));
        chosenFilePathTextField3.setFont(new java.awt.Font("Lucida Console", Font.PLAIN, 12));
        chosenFilePathTextField3.setToolTipText("Ссылка на файл");



        startDecryptButton3.setBackground(new java.awt.Color(255, 102, 102));
        startDecryptButton3.setFont(new java.awt.Font("Segoe UI", Font.PLAIN, 14));
        startDecryptButton3.setText("Взлом");
        startDecryptButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        startDecryptButton3.setEnabled(false);
        startDecryptButton3.addActionListener(evt -> jButton14ActionPerformed());

        chosenFileContentExampleTextField3.setEditable(false);
        chosenFileContentExampleTextField3.setBackground(new java.awt.Color(204, 204, 204));
        chosenFileContentExampleTextField3.setFont(new java.awt.Font("Segoe UI", Font.PLAIN, 14));
        chosenFileContentExampleTextField3.setToolTipText("Часть текста из файла");
        chosenFileContentExampleTextField3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        resultFileOpenFolder3.setText("Открыть папку с файлом");
        resultFileOpenFolder3.setEnabled(false);
        resultFileOpenFolder3.addActionListener(evt -> jButton15ActionPerformed());

        jLabel17.setFont(new java.awt.Font("Segoe UI", Font.PLAIN, 10));
        jLabel17.setText("(Примерное содержание файла)");

        jLabel18.setFont(new java.awt.Font("Segoe UI", Font.PLAIN, 10));
        jLabel18.setText("(Результат взлома файла)");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(thirdFuncWindow);
        thirdFuncWindow.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(279, 279, 279)
                                .addComponent(jLabel13))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(288, 288, 288)
                                .addComponent(jLabel18))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(269, 269, 269)
                                .addComponent(jLabel17)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(resultFileContentExampleTextField3)
                            .addComponent(chosenFilePathTextField3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(chosenFileContentExampleTextField3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel15)
                                        .addGap(152, 152, 152)
                                        .addComponent(chooseFileButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(resultFileCopyPathButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(resultFileOpenButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(resultFileOpenFolder3, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGap(15, 15, 15)
                                                .addComponent(jLabel14)))))
                                .addGap(0, 4, Short.MAX_VALUE))))
                    .addComponent(resultFilePathTextField3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(283, 283, 283)
                .addComponent(startDecryptButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chooseFileButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chosenFilePathTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chosenFileContentExampleTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(startDecryptButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(resultFileContentExampleTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(resultFilePathTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(resultFileCopyPathButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(resultFileOpenButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(resultFileOpenFolder3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(245, 245, 245))
        );

        jTabbedPane.addTab("Расшифровать текст из файла без ключа", thirdFuncWindow);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }

    private void jFormattedTextField1KeyTyped(KeyEvent evt) {
        char keyChar = evt.getKeyChar();
        if(!(Character.isDigit(keyChar))) {
            evt.consume();
        }
    }

    private void jButton2ActionPerformed() {
        String originalText = input.fileToStringConversion(Path.of(chosenFilePathTextField1.getText()));
        int cryptoKey = Integer.parseInt(enterKeyTextField1.getText());

        String textResult = encryptor.encryptorStart(originalText, cryptoKey);
        out.writeResultToFile(textResult);

        resultFilePathTextField1.setText(FileOutput.execPathStr);
        resultFileContentExampleTextField1.setText((textResult.codePointCount(0, textResult.length()) > 50 ? textResult.substring(0, textResult.offsetByCodePoints(0, 80))+"..." : textResult));

            if(!FileOutput.execPathStr.isEmpty()){
                resultFileCopyPathButton1.setEnabled(true);
                resultFileOpenButton1.setEnabled(true);
                resultFileOpenFolder1.setEnabled(true);
        }
    }


    private void jButton1ActionPerformed() {
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Выбор документа");
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Текстовый файл (*.txt)", "txt");
        chooser.setFileFilter(filter);


        int returnVal = chooser.showOpenDialog(null);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            File f = chooser.getSelectedFile();
            String filePath = f.getAbsolutePath();


            chosenFilePathTextField1.setText(filePath);
            String textExample = input.fileToStringConversion(Path.of(filePath));
            chosenFileContentExampleTextField1.setText((textExample.codePointCount(0, textExample.length()) > 50 ? textExample.substring(0, textExample.offsetByCodePoints(0, 80)) + "..." : textExample));
        }
    }


    private void jFormattedTextField1KeyReleased() {
        startEncryptingButton1.setEnabled(enterKeyTextField1.getText().length() > 0 && chosenFilePathTextField1.getText().length() > 0);
    }

    private void jButton4ActionPerformed() {
        try{
        Runtime.getRuntime().exec("rundll32 url.dll, FileProtocolHandler "+ FileOutput.execPathStr);
                }catch(Exception e){
                    e.printStackTrace();
                }
    }

    private void jButton3ActionPerformed() {
        String myString = FileOutput.execPathStr;
        StringSelection stringSelection = new StringSelection(myString);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
    }

    private void jButton5ActionPerformed() {
        try{
        Runtime.getRuntime().exec("rundll32 url.dll, FileProtocolHandler "+Path.of(FileOutput.execPathStr).getParent());
                }catch(Exception e){
                    e.printStackTrace();
                }
    }

    private void jButton6ActionPerformed() {
        String myString = FileOutput.execPathStr;
        StringSelection stringSelection = new StringSelection(myString);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
    }

    private void jButton7ActionPerformed() {
        try{
        Runtime.getRuntime().exec("rundll32 url.dll, FileProtocolHandler "+ FileOutput.execPathStr);
                }catch(Exception e){
                    e.printStackTrace();
                }
    }

    private void jButton8ActionPerformed() {
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Выбор документа");
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Текстовый файл (*.txt)", "txt");
        chooser.setFileFilter(filter);


        int returnVal = chooser.showOpenDialog(null);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            File f = chooser.getSelectedFile();
            String filePath = f.getAbsolutePath();


            chosenFilePathTextField2.setText(filePath);
            String textExample = input.fileToStringConversion(Path.of(chosenFilePathTextField2.getText()));
            chosenFileContentExampleTextField2.setText((textExample.codePointCount(0, textExample.length()) > 50 ? textExample.substring(0, textExample.offsetByCodePoints(0, 80)) + "..." : textExample));
        }
    }



    private void jButton9ActionPerformed() {
        Decoder decoder = new Decoder();
        String text = decoder.decoder(input.fileToStringConversion(Path.of(chosenFilePathTextField2.getText())), Integer.parseInt(enterKeyTextField2.getText()));
        out.writeResultToFile(text);

        resultFilePathTextField2.setText(FileOutput.execPathStr);
        resultFileContentExampleTextField2.setText((text.codePointCount(0, text.length()) > 50 ? text.substring(0, text.offsetByCodePoints(0, 80))+"..." : text));

        if(!FileOutput.execPathStr.isEmpty()){
        resultFileCopyPathButton2.setEnabled(true);
        resultFileOpenButton2.setEnabled(true);
        resultFileOpenFolder2.setEnabled(true);}
    }

    private void jButton10ActionPerformed() {
        try{
        Runtime.getRuntime().exec("rundll32 url.dll, FileProtocolHandler "+Path.of(FileOutput.execPathStr).getParent());
                }catch(Exception e){
                    e.printStackTrace();
                } 
    }


    private void jButton11ActionPerformed() {
        String myString = FileOutput.execPathStr;
        StringSelection stringSelection = new StringSelection(myString);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
    }

    private void jButton12ActionPerformed() {
        try{
        Runtime.getRuntime().exec("rundll32 url.dll, FileProtocolHandler "+ FileOutput.execPathStr);
                }catch(Exception e){
                    e.printStackTrace();
                }     
    }

    private void jButton13ActionPerformed() {
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Выбор документа");
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Текстовый файл (*.txt)", "txt");
        chooser.setFileFilter(filter);


        int returnVal = chooser.showOpenDialog(null);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            File f = chooser.getSelectedFile();
           String filePath =  f.getAbsolutePath();
        chosenFilePathTextField3.setText(filePath);
        String textExample= input.fileToStringConversion(Path.of(chosenFilePathTextField3.getText()));
        chosenFileContentExampleTextField3.setText((textExample.codePointCount(0, textExample.length()) > 50 ? textExample.substring(0, textExample.offsetByCodePoints(0, 80))+"..." : textExample));
        startDecryptButton3.setEnabled(true);}


    }



    private void jButton14ActionPerformed() {
        String text = crack.codeBreak(input.fileToStringConversion(Path.of(chosenFilePathTextField3.getText())));
        out.writeResultToFile(text);
        resultFilePathTextField3.setText(FileOutput.execPathStr);
        resultFileContentExampleTextField3.setText((text.codePointCount(0, text.length()) > 50 ? text.substring(0, text.offsetByCodePoints(0, 80))+"..." : text));
        if(!FileOutput.execPathStr.isEmpty()){
        resultFileCopyPathButton3.setEnabled(true);
        resultFileOpenButton3.setEnabled(true);
        resultFileOpenFolder3.setEnabled(true);}
    }

    private void jButton15ActionPerformed() {
        try{
        Runtime.getRuntime().exec("rundll32 url.dll, FileProtocolHandler "+Path.of(FileOutput.execPathStr).getParent());
                }catch(Exception e){
                    e.printStackTrace();
                } 
    }
    private void jFormattedTextField2KeyTyped(java.awt.event.KeyEvent evt) {
        char keyChar = evt.getKeyChar();
        if(!(Character.isDigit(keyChar))){
        evt.consume();}
    }
    private void jFormattedTextField2KeyReleased() {
        startDecryptButton2.setEnabled(enterKeyTextField2.getText().length() > 0 && chosenFilePathTextField2.getText().length() > 0);
    }


    public void visualSetup() {
        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }

    }
    private javax.swing.JButton resultFileOpenFolder2;
    private javax.swing.JButton resultFileCopyPathButton3;
    private javax.swing.JButton resultFileOpenButton3;
    private javax.swing.JButton startDecryptButton3;
    private javax.swing.JButton resultFileOpenFolder3;
    private javax.swing.JButton startEncryptingButton1;
    private javax.swing.JButton resultFileCopyPathButton1;
    private javax.swing.JButton resultFileOpenButton1;
    private javax.swing.JButton resultFileOpenFolder1;
    private javax.swing.JButton resultFileCopyPathButton2;
    private javax.swing.JButton resultFileOpenButton2;
    private javax.swing.JButton startDecryptButton2;
    private javax.swing.JFormattedTextField enterKeyTextField1;
    private javax.swing.JFormattedTextField enterKeyTextField2;
    private javax.swing.JTextField chosenFilePathTextField1;
    private javax.swing.JTextField resultFilePathTextField3;
    private javax.swing.JTextField chosenFilePathTextField3;
    private javax.swing.JTextField chosenFileContentExampleTextField3;
    private javax.swing.JTextField chosenFileContentExampleTextField1;
    private javax.swing.JTextField resultFileContentExampleTextField1;
    private javax.swing.JTextField resultFilePathTextField1;
    private javax.swing.JTextField resultFileContentExampleTextField2;
    private javax.swing.JTextField resultFilePathTextField2;
    private javax.swing.JTextField chosenFilePathTextField2;
    private javax.swing.JTextField chosenFileContentExampleTextField2;
    private javax.swing.JTextField resultFileContentExampleTextField3;

}
