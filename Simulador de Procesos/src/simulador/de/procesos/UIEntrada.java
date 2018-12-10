/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulador.de.procesos;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mireya
 */
public class UIEntrada extends javax.swing.JFrame {
    int Contador;
    public ArrayList<Proceso> colaProcesos;
    public boolean tipoMemoria;
    public int tamMemoria;
    public int asignador;
    public int planificador;
    //Acá van un montón de banderas que se encargan de que el usuario no pueda avanzar a menos que haya completado todo
    public boolean fplan;   //la f es de flag
    public boolean fasig;
    public boolean ftam;
    public boolean fprocesos;

    /**
     *
     */
    public  String tipoParticionamiento;

    /**
     * Creates new form UIEntrada
     */
    public UIEntrada() {
        fplan = false;
        fasig = false;
        ftam = false;
        fprocesos = false;
        colaProcesos = new ArrayList();
        this.Contador = 0;
        tipoParticionamiento=null;
        tamMemoria=1024;
        initComponents();
        miTabla.setBackground(Color.white);
        miTabla.setForeground(Color.blue);
        //jTFinal.setBackground(Color.GREEN);
        //jTFinal.setBackground(Color.red);
        //jTFCapturaQuantum.grabFocus();
    }

//Contador del total de procesos
        /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        miTabla = new javax.swing.JTable();
        NOM = new javax.swing.JTextField();
        Nombre = new java.awt.Label();
        cicloES = new javax.swing.JTextField();
        tarribo = new javax.swing.JTextField();
        tam = new javax.swing.JTextField();
        ciclodeCPU = new javax.swing.JTextField();
        label1 = new java.awt.Label();
        label2 = new java.awt.Label();
        label3 = new java.awt.Label();
        label4 = new java.awt.Label();
        botonAgregarEntrada = new java.awt.Button();
        botonInicialEntrada = new java.awt.Button();
        label5 = new java.awt.Label();
        label6 = new java.awt.Label();
        boxParticionamiento = new javax.swing.JComboBox<>();
        boxPlanificador = new javax.swing.JComboBox<>();
        boxAsignacion = new javax.swing.JComboBox<>();
        label7 = new java.awt.Label();
        label8 = new java.awt.Label();
        label9 = new java.awt.Label();
        totMem = new javax.swing.JTextField();
        label10 = new java.awt.Label();
        quantum = new javax.swing.JTextField();
        BotonProcesosAleatorios = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        miTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Tamaño", "Tiempo de Aribo", "Ciclo deE/S", "Ciclo de CPU"
            }
        ));
        jScrollPane1.setViewportView(miTabla);

        NOM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NOMActionPerformed(evt);
            }
        });

        Nombre.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        Nombre.setText("Nombre");

        cicloES.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cicloESActionPerformed(evt);
            }
        });

        tarribo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tarriboActionPerformed(evt);
            }
        });

        tam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tamActionPerformed(evt);
            }
        });

        ciclodeCPU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ciclodeCPUActionPerformed(evt);
            }
        });

        label1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        label1.setText("Ciclo de E/S");

        label2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        label2.setText("Tiempo de Arribo");

        label3.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        label3.setText("Tamaño");

        label4.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        label4.setText("Ciclo de CPU");

        botonAgregarEntrada.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        botonAgregarEntrada.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        botonAgregarEntrada.setLabel("Agregar");
        botonAgregarEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarEntradaActionPerformed(evt);
            }
        });

        botonInicialEntrada.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        botonInicialEntrada.setLabel("Siguiente");
        botonInicialEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonInicialEntradaActionPerformed(evt);
            }
        });

        label5.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        label5.setText("Planificador");

        label6.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        label6.setText("Método de Asignación");

        boxParticionamiento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Fijo", "Variable" }));
        boxParticionamiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxParticionamientoActionPerformed(evt);
            }
        });

        boxPlanificador.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "RoundRobin+Q", "SRTF", "SJF", "FCFS" }));
        boxPlanificador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxPlanificadorActionPerformed(evt);
            }
        });

        boxAsignacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "WorstFit", "FirstFiT", "BestFit" }));
        boxAsignacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxAsignacionActionPerformed(evt);
            }
        });

        label7.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        label7.setText("Particionamiento");

        label8.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        label8.setText("Lista de Procesos");

        label9.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        label9.setText("Tamaño de Memoria");

        totMem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totMemActionPerformed(evt);
            }
        });

        label10.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        label10.setText("Quantum");

        quantum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantumActionPerformed(evt);
            }
        });

        BotonProcesosAleatorios.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BotonProcesosAleatorios.setText("AGREGAR 5 PROCESOS ALEATORIOS");
        BotonProcesosAleatorios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonProcesosAleatoriosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(40, 40, 40)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(label6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(17, 17, 17)
                                            .addComponent(label7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(9, 9, 9)
                                            .addComponent(label9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(85, 85, 85)
                                    .addComponent(label5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(166, 166, 166)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(boxPlanificador, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(boxParticionamiento, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(boxAsignacion, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(totMem, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(quantum, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(53, 53, 53)
                                    .addComponent(label8, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(NOM, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(76, 76, 76)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(tam, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(61, 61, 61)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(tarribo, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(29, 29, 29)))
                                    .addGap(31, 31, 31)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(cicloES, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(53, 53, 53)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(ciclodeCPU, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(46, 46, 46)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(botonAgregarEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(botonInicialEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(216, 216, 216)
                        .addComponent(BotonProcesosAleatorios)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(totMem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(label7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boxParticionamiento, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(label6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boxAsignacion, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(label5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boxPlanificador, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(quantum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(label8, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botonAgregarEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonInicialEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(label1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(label3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Nombre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(label2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cicloES, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(ciclodeCPU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tarribo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(NOM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(13, 13, 13)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BotonProcesosAleatorios)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NOMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NOMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NOMActionPerformed

    private void tarriboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tarriboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tarriboActionPerformed

    private void botonAgregarEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarEntradaActionPerformed
        // TODO add your handling code here:
        Ingresar();
        //La cola de procesos ya no está vacía
        fprocesos = true;
        JOptionPane.showMessageDialog(null, "Proceso cargado correctamente");
    }//GEN-LAST:event_botonAgregarEntradaActionPerformed

    private void botonInicialEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonInicialEntradaActionPerformed
       if ((fasig)&&(fplan)&&(ftam)&&(fprocesos)){
           Iniciar();
           if (tipoMemoria ==true){ 
               UIFinal b = new UIFinal();
               b.setVisible(true);
           }
           else{
               UIMemoria a = new UIMemoria();
               a.setMem(tamMemoria, tipoMemoria);
               a.setAsignador(asignador);
               a.setPlanificador(planificador);
               a.setVisible(true);  
           }
           this.setVisible(false);
       }
       else{
           JOptionPane.showMessageDialog(null,"Por favor, carga todos los datos antes de avanzar");
       }
    }//GEN-LAST:event_botonInicialEntradaActionPerformed

    private void boxParticionamientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxParticionamientoActionPerformed
        String algoritmoParticionamiento = (String) boxParticionamiento.getSelectedItem();
        algoritmoParticionamiento = algoritmoParticionamiento.toUpperCase();
        tipoMemoria = "VARIABLE".equals(algoritmoParticionamiento);
    }//GEN-LAST:event_boxParticionamientoActionPerformed

    private void totMemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totMemActionPerformed
        tamMemoria = Integer.parseInt(totMem.getText());
        ftam = true;
        JOptionPane.showMessageDialog(null, "Tamaño de memoria guardada");
    }//GEN-LAST:event_totMemActionPerformed

    private void ciclodeCPUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ciclodeCPUActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ciclodeCPUActionPerformed

    private void cicloESActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cicloESActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cicloESActionPerformed

    private void tamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tamActionPerformed

    private void quantumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quantumActionPerformed
      // TODO add your handling code here:
    }//GEN-LAST:event_quantumActionPerformed

    private void boxPlanificadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxPlanificadorActionPerformed
        String asing;
        asing= (String) boxPlanificador.getSelectedItem();
        switch (asing){
                case("RoundRobin+Q"): 
                    planificador = 1;
                    break;
                case ("SRTF"):
                    planificador = 2;
                    break;
                case ("SJF"):
                    planificador = 3;
                    break;
                case ("FCFS"):
                    planificador = 4;
                    break;
                default:
                    planificador = 4;
                    break;
            }
        //Indico que ya se cargo un algoritmo al planificador
        fplan = true;
        JOptionPane.showMessageDialog(null, "Algoritmo de Planificación guardado");
    }//GEN-LAST:event_boxPlanificadorActionPerformed

    private void boxAsignacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxAsignacionActionPerformed
        String asing;
        asing= (String) boxAsignacion.getSelectedItem();
        switch (asing){
                case("BestFit"): 
                    asignador = 1;
                    break;
                case ("FirstFIT"):
                    asignador = 2;
                    break;
                case ("WorstFit"):
                    asignador = 3;
                    break;
                default:
                    asignador = 2;
                    break;
            }
        //Indico que ya se cargó un asignador
        fasig = true;
        JOptionPane.showMessageDialog(null, "Asignador elegido");
    }//GEN-LAST:event_boxAsignacionActionPerformed

    private void BotonProcesosAleatoriosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonProcesosAleatoriosActionPerformed
        IngresarAleatorios();
        fprocesos = true;
        JOptionPane.showMessageDialog(null, "Procesos generados correctamente");
    }//GEN-LAST:event_BotonProcesosAleatoriosActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UIEntrada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new UIEntrada().setVisible(true);
        });
    }
    

    public void Ingresar(){ //Ingresar proceso a la tabla
    DefaultTableModel modelo=(DefaultTableModel) miTabla.getModel();
    Contador ++;
    Object[] tabla = new Object[6];
    //Creo un nuevo proceso con los datos ingresados
    Proceso proceso;
    proceso = new Proceso();
    tabla[0]= Contador;
    tabla[1]= NOM.getText();
    tabla[2]= tam.getText();
    tabla[3]= tarribo.getText();
    tabla[4]= cicloES.getText();
    tabla[5]= ciclodeCPU.getText();
    
    //tabla[6]= "Listo";
    modelo.addRow(tabla);
    //miTabla.setModel(modelo);
    proceso.CrearProceso(NOM.getText(), Integer.parseInt(tarribo.getText()), Integer.parseInt(tam.getText()),  Integer.parseInt(cicloES.getText()), Integer.parseInt(ciclodeCPU.getText()));
    
    //Guardo el nuevo proceso en la cola de procesos
    colaProcesos.add(proceso);
    
    //Ordeno los procesos por tiempo de arribo en la lista
    Collections.sort(colaProcesos, (Proceso p1, Proceso p2) -> new Integer(p1.getTarribo()).compareTo(p2.getTarribo()));
    //Pongo en blanco todos los espacios para que se pueda ingresar un nuevo proceso
    NOM.setText(null);
    NOM.grabFocus();
    cicloES.setText(null);
    cicloES.grabFocus();
    tarribo.setText(null);
    tarribo.grabFocus();
    tam.setText(null);
    tam.grabFocus();
    ciclodeCPU.setText(null);
    ciclodeCPU.grabFocus();
}
    
    public void IngresarAleatorios(){ //Ingresar 5 procesos a la tabla
        //Voy a crear 5 procesos, por ello creo un ciclo for
        for(int i = 1; i <= 5; i++){
            DefaultTableModel modelo=(DefaultTableModel) miTabla.getModel();
            Contador ++;
            Object[] tabla = new Object[6];
            //Creo un nuevo proceso con datos aleatorios
            Proceso proceso;
            proceso = new Proceso();
            tabla[0]= Contador;
            tabla[1]= "PAutoGen"; //Indico que es un proceso autogenerado
            
            /*Creo las variables necesarias para cargar los procesos
            Hacemos uso de la función random, que genera un valor aleatorio dentro de un rango
            Coloco int porque el random genera un double y el +1 es para que no de un valor 0*/
            int tamp = (int) (Math.random() * 511) + 1;  //Tamaño del proceso
            int tarrib = (int) (Math.random() * 9) + 1;  //Tiempo de arribo
            int cicloE = (int) (Math.random() * 50) + 1;  //CicloES
            int cicloCP = (int) (Math.random() * 50) + 1; //CicloCPU

            //Ahora guardo los valores en la tabla
            tabla[2]= tamp;
            tabla[3]= tarrib;
            tabla[4]= cicloE;
            tabla[5]= cicloCP;
            modelo.addRow(tabla);
            
            //Y ahora creo el proceso con estos atributos
            proceso.CrearProceso("PAutoGen", tarrib, tamp, cicloE, cicloCP);

            //Guardo el nuevo proceso en la cola de procesos
            colaProcesos.add(proceso);
        }
    
    //Ordeno los procesos por tiempo de arribo en la lista
    Collections.sort(colaProcesos, (Proceso p1, Proceso p2) -> new Integer(p1.getTarribo()).compareTo(p2.getTarribo()));

}
    
    
    public void Iniciar(){ //Inicia la secuencia de procesos
        NOM.setVisible(false);
        cicloES.setVisible(false);
        tarribo.setVisible(false);
        tam.setVisible(false);
        ciclodeCPU.setVisible(false);
        botonAgregarEntrada.setVisible(false);
        botonInicialEntrada.setVisible(false);
        
        //Mostramos los procesos cargados en la lista
        Iterator<Proceso> it = colaProcesos.iterator();
        String enLista = "";
        int i = 0;
        while (it.hasNext()) {
            enLista = enLista +"\n"+ "Proceso: "+ i + "  " +it.next();
            i++;
        } 
        JOptionPane.showMessageDialog(null,enLista);
}
    public void Borrar(int c){ //Elimina los registros de la tabla procesos
        miTabla.setValueAt(0,c,0);
        miTabla.setValueAt("0",c,1);
        miTabla.setValueAt("0",c,2);
        miTabla.setValueAt("0",c,3);
        miTabla.setValueAt("0",c,4);
        miTabla.setValueAt("******",c,5);
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonProcesosAleatorios;
    private javax.swing.JTextField NOM;
    private java.awt.Label Nombre;
    private java.awt.Button botonAgregarEntrada;
    private java.awt.Button botonInicialEntrada;
    private javax.swing.JComboBox<String> boxAsignacion;
    private javax.swing.JComboBox<String> boxParticionamiento;
    private javax.swing.JComboBox<String> boxPlanificador;
    private javax.swing.JTextField cicloES;
    private javax.swing.JTextField ciclodeCPU;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.Label label1;
    private java.awt.Label label10;
    private java.awt.Label label2;
    private java.awt.Label label3;
    private java.awt.Label label4;
    private java.awt.Label label5;
    private java.awt.Label label6;
    private java.awt.Label label7;
    private java.awt.Label label8;
    private java.awt.Label label9;
    private javax.swing.JTable miTabla;
    private javax.swing.JTextField quantum;
    private javax.swing.JTextField tam;
    private javax.swing.JTextField tarribo;
    private javax.swing.JTextField totMem;
    // End of variables declaration//GEN-END:variables
}
