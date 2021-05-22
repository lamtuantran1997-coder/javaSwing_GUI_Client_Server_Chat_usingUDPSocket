/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.awt.Dialog;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author foet1
 */
public class GUI_Client extends javax.swing.JFrame {
     private static DatagramSocket clientSocket;
     private static final int port = 6789;
     private static InetAddress ip;
     private Database db;
     private boolean checkDB = false;
     private boolean checkDB_onClose = false;
     private boolean checkDB_onClose_intent = false;
     private boolean stopThread ;
     
     private String user;
     java.lang.Thread readMessage ;

  
    /**
     * Creates new form GUI
     */
    public GUI_Client() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog2 = new javax.swing.JDialog();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        text_area = new javax.swing.JTextArea();
        text_input = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jDialog3 = new javax.swing.JDialog();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        userSQL = new javax.swing.JTextField();
        passSQL = new javax.swing.JPasswordField();
        portSQL = new javax.swing.JTextField();
        submit1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jDialog1 = new javax.swing.JDialog();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        firstName = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        lastName = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        usernameAccount = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        passAccount = new javax.swing.JPasswordField();
        jLabel18 = new javax.swing.JLabel();
        confirmPassAccount = new javax.swing.JPasswordField();
        jLabel19 = new javax.swing.JLabel();
        emailAccount = new javax.swing.JTextField();
        createAccount = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        password = new javax.swing.JPasswordField();
        submit = new javax.swing.JButton();
        signUp = new javax.swing.JButton();

        jDialog2.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jDialog2.setTitle("CHAT BOX");
        jDialog2.setBackground(new java.awt.Color(204, 0, 0));
        jDialog2.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                jDialog2WindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                jDialog2WindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                jDialog2WindowOpened(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setText("Your Chat Box");

        text_area.setColumns(20);
        text_area.setRows(5);
        text_area.setFocusable(false);
        jScrollPane1.setViewportView(text_area);

        text_input.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_inputActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Enter text here: ");

        javax.swing.GroupLayout jDialog2Layout = new javax.swing.GroupLayout(jDialog2.getContentPane());
        jDialog2.getContentPane().setLayout(jDialog2Layout);
        jDialog2Layout.setHorizontalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog2Layout.createSequentialGroup()
                .addGap(176, 176, 176)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jDialog2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jDialog2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(text_input, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 17, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jDialog2Layout.setVerticalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(text_input, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(27, 27, 27))
        );

        jDialog3.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jDialog3.setTitle("Connect to Database");
        jDialog3.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                jDialog3WindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                jDialog3WindowClosing(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel8.setText("DATABASE");

        jLabel9.setText(" MySQL Username: ");

        jLabel10.setText("MySQL Password: ");

        jLabel11.setText("MySQL Port: ");

        jLabel12.setText("Connect to your local MySQL account");

        userSQL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userSQLActionPerformed(evt);
            }
        });

        portSQL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                portSQLActionPerformed(evt);
            }
        });

        submit1.setText("Connect");
        submit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submit1ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel4.setText("Note: Connectivity only works if MySQL was installed in your computer.");

        javax.swing.GroupLayout jDialog3Layout = new javax.swing.GroupLayout(jDialog3.getContentPane());
        jDialog3.getContentPane().setLayout(jDialog3Layout);
        jDialog3Layout.setHorizontalGroup(
            jDialog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog3Layout.createSequentialGroup()
                .addGroup(jDialog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialog3Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel10))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialog3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jDialog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGap(18, 18, 18)
                .addGroup(jDialog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(userSQL, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jDialog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(passSQL, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                        .addComponent(portSQL)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jDialog3Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel4)
                .addContainerGap(74, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialog3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jDialog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialog3Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(128, 128, 128))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialog3Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(166, 166, 166))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialog3Layout.createSequentialGroup()
                        .addComponent(submit1)
                        .addGap(31, 31, 31))))
        );
        jDialog3Layout.setVerticalGroup(
            jDialog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addGap(27, 27, 27)
                .addGroup(jDialog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(userSQL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jDialog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(passSQL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jDialog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(portSQL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(submit1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(26, 26, 26))
        );

        jDialog1.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jDialog1.setTitle("Sign Up");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel13.setText("Create new account");

        jLabel14.setText("First name: ");

        firstName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstNameActionPerformed(evt);
            }
        });

        jLabel15.setText("Last name: ");

        jLabel16.setText("Username: ");

        jLabel17.setText("Password: ");

        passAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passAccountActionPerformed(evt);
            }
        });

        jLabel18.setText("Confirm  password:");

        jLabel19.setText("Email: ");

        emailAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailAccountActionPerformed(evt);
            }
        });

        createAccount.setText("Create");
        createAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createAccountActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialog1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel17)
                            .addComponent(jLabel18)
                            .addComponent(jLabel16)
                            .addComponent(jLabel15)
                            .addComponent(jLabel14)
                            .addComponent(jLabel19))
                        .addGap(35, 35, 35)
                        .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lastName, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(firstName, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(usernameAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(passAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(confirmPassAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(emailAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jDialog1Layout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addComponent(jLabel13)))
                .addContainerGap(143, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialog1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(createAccount)
                .addGap(87, 87, 87))
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addGap(18, 18, 18)
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(firstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(lastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(usernameAccount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(passAccount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(confirmPassAccount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(emailAccount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(createAccount)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LOG IN");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText(" Log In");

        jLabel2.setText("Username");

        jLabel3.setText("Password");

        username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameActionPerformed(evt);
            }
        });

        submit.setText("Submit");
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });

        signUp.setText("Sign up");
        signUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signUpActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(username)
                            .addComponent(password)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(signUp)
                        .addGap(26, 26, 26)
                        .addComponent(submit)))
                .addGap(67, 67, 67))
            .addGroup(layout.createSequentialGroup()
                .addGap(155, 155, 155)
                .addComponent(jLabel1)
                .addContainerGap(169, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(submit)
                    .addComponent(signUp))
                .addContainerGap(139, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameActionPerformed

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
      
         
        
        if(username.getText().equals("") || password.getText().equals("")){
            JOptionPane.showMessageDialog(this, "You must fill in all the fields", "Alert", JOptionPane.INFORMATION_MESSAGE);
        } else{
            if(!checkDB)  {
                jDialog3.setLocationRelativeTo(this);
                jDialog3.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
                jDialog3.pack();
                jDialog3.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                jDialog3.setVisible(true);
                checkDB = true;
             }
            if(checkDB_onClose && !checkDB_onClose_intent){
                checkDB = false;
                } else{
            if(!db.Search_data(username.getText(),password.getText())){
                JOptionPane.showMessageDialog(this, "Your account doesn't exist. Please create one.", "Alert", JOptionPane.INFORMATION_MESSAGE);
            } else{
            try {
                user = username.getText();
                while(true){
                byte [] send_1 = username.getText().getBytes();
                byte [] send_2 = password.getText().getBytes();
                DatagramPacket packet_send_1 = new DatagramPacket(send_1, send_1.length, ip, port);
                DatagramPacket packet_send_2 = new DatagramPacket(send_2, send_2.length, ip, port);
                clientSocket.send(packet_send_1);
                clientSocket.send(packet_send_2);
                
                byte [] receive = new byte[6500];
                DatagramPacket packet_receive = new DatagramPacket(receive, receive.length);
                clientSocket.receive(packet_receive);
                String message_receive = new String(packet_receive.getData(),0,packet_receive.getLength());
                if(message_receive.equals("Success"))
                break;
                    
            }
                JOptionPane.showMessageDialog(this,"Log In Successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                this.setVisible(false);
                this.dispose();
                jDialog2.setLocationRelativeTo(null);
                jDialog2.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
                jDialog2.pack();
                jDialog2.setVisible(true);
            } catch (UnknownHostException ex) {
                Logger.getLogger(GUI_Client.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(GUI_Client.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            }   
        }
        }
    }//GEN-LAST:event_submitActionPerformed

    private void text_inputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_inputActionPerformed
            text_area.append(text_input.getText()+"\n");
            String s1 = user + ": "+ text_input.getText();
            byte [] send = s1.getBytes();
            DatagramPacket packet_send = new DatagramPacket(send, send.length, ip, port);
            try {
             clientSocket.send(packet_send);
            } catch (IOException ex) {
                Logger.getLogger(GUI_Server.class.getName()).log(Level.SEVERE, null, ex);
            }
            text_input.setText("");
    }//GEN-LAST:event_text_inputActionPerformed

    private void jDialog2WindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_jDialog2WindowOpened
         stopThread =false;
        readMessage = new java.lang.Thread(() -> {
                    while (true) {
                        byte [] receive = new byte[6500];
                        DatagramPacket packet_receive = new DatagramPacket(receive, receive.length);
                        try {
                            clientSocket.receive(packet_receive);
                        } catch (IOException ex) {
                            Logger.getLogger(GUI_Client.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        String s = new String(packet_receive.getData(), 0, packet_receive.getLength());
                        text_area.append(s + "\n");
                        if(stopThread){
                            
                            break;
                        }
                   }
                });
        readMessage.start();
                
    }//GEN-LAST:event_jDialog2WindowOpened

    private void signUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signUpActionPerformed
        if(!checkDB){
            JOptionPane.showMessageDialog(this, "You must activate Database first by clicking on Submit.", "Alert", JOptionPane.INFORMATION_MESSAGE);
        }   else{
        jDialog1.setLocationRelativeTo(this);
                jDialog1.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
                jDialog1.pack();
                jDialog1.setVisible(true);
             }
    }//GEN-LAST:event_signUpActionPerformed

    private void userSQLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userSQLActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userSQLActionPerformed

    private void portSQLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_portSQLActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_portSQLActionPerformed

    private void submit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submit1ActionPerformed
        if(userSQL.getText().equals("") || passSQL.getText().equals("") || portSQL.getText().equals("")){
            JOptionPane.showMessageDialog(this, "You must fill in all the fields", "Alert", JOptionPane.INFORMATION_MESSAGE);
        } else{
            db = new Database(userSQL.getText(), passSQL.getText(), Integer.parseInt(portSQL.getText()));
            db.createDB();
            db.createTable();
            JOptionPane.showMessageDialog(this, "Connect Successfully to your Database", "Success", JOptionPane.INFORMATION_MESSAGE);
            jDialog3.setVisible(false);
            jDialog3.dispose();
            checkDB_onClose_intent = true;
        }
        

    }//GEN-LAST:event_submit1ActionPerformed

    private void firstNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_firstNameActionPerformed

    private void passAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passAccountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passAccountActionPerformed

    private void emailAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailAccountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailAccountActionPerformed

    private void createAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createAccountActionPerformed
        
        if(firstName.getText().equals("") || lastName.getText().equals("") || usernameAccount.getText().equals("") || passAccount.getText().equals("") || confirmPassAccount.getText().equals("") || emailAccount.getText().equals("")){
            JOptionPane.showMessageDialog(this, "You must fill in all the fields", "Alert", JOptionPane.INFORMATION_MESSAGE);
        } else{
            if(!passAccount.getText().equals(confirmPassAccount.getText())){
                 JOptionPane.showMessageDialog(this, "Your password field and confirm password field must be the same.", "Alert", JOptionPane.INFORMATION_MESSAGE);
            } else{
                if(db.checkUsernameAndEmail(usernameAccount.getText(), emailAccount.getText())){
                    JOptionPane.showMessageDialog(this, "Your username and email are not available.", "Alert", JOptionPane.INFORMATION_MESSAGE);
                } else{
                String fN = firstName.getText();
                String lN = lastName.getText();
                String uN = usernameAccount.getText();
                String pass = passAccount.getText();
                String em = emailAccount.getText();
                db.Add_data(fN, lN, uN, pass, em);
                JOptionPane.showMessageDialog(this, "Create Account Successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                jDialog1.setVisible(false);
                jDialog1.dispose();
                }
            }
        }
        
    }//GEN-LAST:event_createAccountActionPerformed

    private void jDialog3WindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_jDialog3WindowClosed
        checkDB_onClose = true;
    }//GEN-LAST:event_jDialog3WindowClosed

    private void jDialog3WindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_jDialog3WindowClosing
        checkDB_onClose = true;
    }//GEN-LAST:event_jDialog3WindowClosing

    private void jDialog2WindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_jDialog2WindowClosed
        
        System.exit(0);
    }//GEN-LAST:event_jDialog2WindowClosed

    private void jDialog2WindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_jDialog2WindowClosing
        stopThread = true;
    }//GEN-LAST:event_jDialog2WindowClosing

    /**
     * @param args the command line arguments
     * @throws java.net.SocketException
     * @throws java.net.UnknownHostException
     */
    public static void main(String args[]) throws SocketException, UnknownHostException, IOException {
        clientSocket = new DatagramSocket();
       
        ip = InetAddress.getLocalHost();
        

        
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI_Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_Client().setVisible(true);
            }
        });
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField confirmPassAccount;
    private javax.swing.JButton createAccount;
    private javax.swing.JTextField emailAccount;
    private javax.swing.JTextField firstName;
    private javax.swing.JDialog jDialog1;
    private static javax.swing.JDialog jDialog2;
    private javax.swing.JDialog jDialog3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField lastName;
    private javax.swing.JPasswordField passAccount;
    private javax.swing.JPasswordField passSQL;
    private javax.swing.JPasswordField password;
    private javax.swing.JTextField portSQL;
    private javax.swing.JButton signUp;
    private javax.swing.JButton submit;
    private javax.swing.JButton submit1;
    private static javax.swing.JTextArea text_area;
    private static javax.swing.JTextField text_input;
    private javax.swing.JTextField userSQL;
    private javax.swing.JTextField username;
    private javax.swing.JTextField usernameAccount;
    // End of variables declaration//GEN-END:variables
}
