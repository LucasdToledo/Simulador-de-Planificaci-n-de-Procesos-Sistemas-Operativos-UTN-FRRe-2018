/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulador.de.procesos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Sole
 */
public class UIFinal extends javax.swing.JFrame {
    int contCN;
    int acumul;
    int contp;
    int contM;
    int contT;
    int contCL; //contador de los procesos en Cola de Listos según cómo van llegando
    public Memoria mema;
    public ArrayList<Proceso> colaNuevo;
    public ArrayList<Proceso> colaListos;
    public Asignador asignador;
    public Planificador planificador;
    public ArrayList<Proceso> colaProcesos;
    public ArrayList<Proceso> colaTerminados;
    
    /**
     * Creates new form UIFinal
     * @param _mem
     * @param tamMemoria
     * @param tipoParticionamiento
     */
    
    
    public void setMem(Memoria _mem ,int tamMemoria,boolean tipoParticionamiento) {
        Memoria memoria = new Memoria();
        memoria.CrearMemoria(tamMemoria, tipoParticionamiento);
        this.mema = memoria;
        mema.setListaParticiones(_mem.getListaParticiones());
        mema.Mostrar();
    }

    public void setColaTerminados(ArrayList<Proceso> colaTerminados) {
        this.colaTerminados = colaTerminados;
    }

    

    public ArrayList<Proceso> getColaTerminados() {
        return colaTerminados;
    }
    
    
    
    public UIFinal() {
        contCN = 1;
        colaNuevo = new ArrayList();
        colaListos = new ArrayList();
        colaTerminados = new ArrayList();
        acumul =-1;
        contp = 1;
        contCL = 1;
        contM=1;
        contT = 1;
        initComponents();
    }

    public void setAsignador(int _asignador) {
        Asignador asig = new Asignador();
        asig.setAlgoritmo(_asignador);
        this.asignador = asig;
    }

    public void setPlanificador(int _planificador) {
        Planificador planif = new Planificador();
        planif.setAlgorit(_planificador);
        this.planificador = planif;
    }

    public void setColaProcesos(ArrayList<Proceso> _colaProcesos) {
        this.colaProcesos = _colaProcesos;//Mostramos los procesos cargados en la lista
        Iterator<Proceso> it = colaProcesos.iterator();
        String enLista = "";
        int i = 0;
        while (it.hasNext()) {
            enLista = enLista +"\n"+ "Proceso: "+ i + "  " +it.next();
            i++;
        } 
        JOptionPane.showMessageDialog(null,enLista);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaColaNuevo = new javax.swing.JTable();
        label1 = new java.awt.Label();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaColaListos = new javax.swing.JTable();
        label4 = new java.awt.Label();
        label5 = new java.awt.Label();
        jScrollPane3 = new javax.swing.JScrollPane();
        TablaTerminados = new javax.swing.JTable();
        label6 = new java.awt.Label();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaParticiones = new javax.swing.JTable();
        label2 = new java.awt.Label();
        botonSiguiente = new java.awt.Button();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tablaCPU = new javax.swing.JTable();
        jScrollPane7 = new javax.swing.JScrollPane();
        tablaES = new javax.swing.JTable();
        tiempoo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        botonGantt = new java.awt.Button();
        gantt = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tablaColaNuevo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Tamaño", "Ciclo de CPU", "Ciclo de E/S"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaColaNuevo);

        label1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        label1.setText("SIMULACIÓN");

        TablaColaListos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Tamaño", "Ciclo de CPU", "Ciclo de E/S"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(TablaColaListos);

        label4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        label4.setText("Cola de Nuevos");

        label5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        label5.setText("Cola de Listos");

        TablaTerminados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Tamaño", "Ciclo de CPU", "Ciclo de E/S"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(TablaTerminados);

        label6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        label6.setText("Terminados");

        tablaParticiones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Tam Proceso", "Tam Particion", "Fragmentación"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tablaParticiones);

        label2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        label2.setText("Asignacion en Memoria ");

        botonSiguiente.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        botonSiguiente.setLabel("Siguiente");
        botonSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSiguienteActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText("Proceso en CPU");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("Proceso en E/S");

        tablaCPU.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Tamaño", "Ciclo de CPU", "Ciclo de E/S"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane6.setViewportView(tablaCPU);

        tablaES.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Tamaño", "Ciclo de CPU", "Ciclo de E/S"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane7.setViewportView(tablaES);

        tiempoo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tiempooActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Dubai", 1, 14)); // NOI18N
        jLabel3.setText("Tiempo");

        botonGantt.setActionCommand("Gantt");
        botonGantt.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        botonGantt.setLabel("Gantt");
        botonGantt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGanttActionPerformed(evt);
            }
        });

        gantt.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        gantt.setCaretColor(new java.awt.Color(255, 0, 0));
        gantt.setDisabledTextColor(new java.awt.Color(51, 153, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(gantt)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(label5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(label6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(botonGantt, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(73, 73, 73))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(51, 51, 51)
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tiempoo, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(botonSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(170, 170, 170))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(label5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(label6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(botonSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(tiempoo, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(28, 28, 28)
                                .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                        .addComponent(gantt, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonGantt, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(203, 203, 203))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSiguienteActionPerformed
        Acumular();         //Sumo un valor al tiempo
        contCN = reiniciarTabla(tablaColaNuevo);
        cargarColaNuevo();
        if (acumul == 0){
            cargarParticionesPrimerVez();
        }
        else{ 
            if(acumul > 0 ){
                //Cargamos la cola de Nuevos con los procesos que tienen tiempo de arribo igual al tiempo presente
                contM = reiniciarTabla(tablaParticiones);
                hacerUnaVuelta();
                JOptionPane.showMessageDialog(null, "1");
                cargarParticiones();
               JOptionPane.showMessageDialog(null, "2");
                
                //Se carga de nuevo para actualizar
                Collections.sort(colaListos, (Proceso p1, Proceso p2)-> new Integer(p1.getTarribo()).compareTo(p2.getTarribo()));
                colaListos = planificador.elegirSiguiente(colaListos, acumul);
                cargarColaListos();
                cargarColaTerminados();
                JOptionPane.showMessageDialog(null, colaListos);
            }
        }
    }//GEN-LAST:event_botonSiguienteActionPerformed

    private void tiempooActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tiempooActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tiempooActionPerformed

    private void botonGanttActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGanttActionPerformed
        gantt.setText(String.valueOf(colaTerminados)); 
       
    }//GEN-LAST:event_botonGanttActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(UIFinal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UIFinal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UIFinal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UIFinal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new UIFinal().setVisible(true);
        });
    }
    
    public void Acumular(){
        acumul++;
        tiempoo.setText(String.valueOf(acumul));
    }
    
    public void hacerUnaVuelta(){//CLICK EN SIGUIENTE MAYOR QUE 1. entra aca
        Iterator<Proceso> it = colaNuevo.iterator();//ACA AGARRO PROCESOS DE LA COLA DE NUEVO. 
        ArrayList <Particion> lista = new ArrayList();
       if (!colaNuevo.isEmpty()){
           while (it.hasNext()) {
               lista = asignador.Asignar(mema, it.next());
           }
           mema.setListaParticiones(lista);// que hace esta linea. jl
           mema.Mostrar();
        }
    }
 
    public final void cargarParticiones(){
        //Mostramos los procesos cargados en la lista
        DefaultTableModel modelo=(DefaultTableModel) tablaParticiones.getModel();
        Object[] tabla = new Object[5];
        //Creo un proceso y particion auxiliares para mejorar la legibilidad del código
        Particion part;
        
        colaListos = new ArrayList(); 
        Proceso process;
        Iterator<Particion> it = mema.getListaParticiones().iterator();
        while (it.hasNext()) {
            part = it.next();
            if (part.isEstado() == false){              //Si la particion esta ocupada entra
                process = part.getProces();
                tabla[0]= contM; contM++;
                tabla[1]= process.getDescripcion();
                tabla[2]= process.getTamaño();
                tabla[3]= part.Tamaño();
                tabla[4]= part.Tamaño()- process.getTamaño();
                modelo.addRow(tabla);
                colaListos.add(process);
                
                colaProcesos.remove(process);
                for (int posi = 0; posi <= colaNuevo.size()-1 ; posi++) {
             
                    Proceso pepe = colaNuevo.get(posi);
                    if(colaListos.contains(pepe)){
                        colaNuevo.remove(pepe);
                        posi= posi-1;
                    }
                }
            }
            else{
                tabla[0]= contM; contM++;
                tabla[1]= "Vacío";
                tabla[2]= 0;
                tabla[3]= part.Tamaño();
                tabla[4]= 0;
                modelo.addRow(tabla);
            }
        }
    }
    
    public final void cargarColaNuevo(){
        //Creación de la tabla
        DefaultTableModel modelo=(DefaultTableModel) tablaColaNuevo.getModel();
        Object[] tabla = new Object[5];
        //Creo un proceso auxiliar para mejorar la legibilidad del código
        Proceso process;
        
        Iterator<Proceso> it = colaProcesos.iterator();
        while (it.hasNext()) {
            process = it.next();
            if (process.getTarribo()<=acumul){
                tabla[0]= contCN; contCN++;
                tabla[1]= process.getDescripcion();
                tabla[2]= process.getTamaño();
                tabla[3]= process.getCicloCPU();
                tabla[4]= process.getCicloES();
                modelo.addRow(tabla);
                colaNuevo.add(process);
            }
        }
     
    }    
    
    public final void cargarColaListos(){
        contCL = reiniciarTabla(TablaColaListos);
        //Creación de la tabla
        DefaultTableModel modelo=(DefaultTableModel) TablaColaListos.getModel();
        Object[] tabla = new Object[5];
        //Creo un proceso y particion auxiliares para mejorar la legibilidad del código
        Proceso process;
        Iterator<Proceso> it = colaListos.iterator();
        while (it.hasNext()) {
            process = it.next();
            tabla[0]= contCL; contCL++;
            tabla[1]= process.getDescripcion();
            tabla[2]= process.getTamaño();
            tabla[3]= process.getCicloCPU();
            tabla[4]= process.getCicloES();
            modelo.addRow(tabla);
        }
    }
    
    public final void cargarColaTerminados(){
        //Creación de la tabla
        DefaultTableModel modelo=(DefaultTableModel) TablaTerminados.getModel();
        Object[] tabla = new Object[5];
        //Creo un proceso y particion auxiliares para mejorar la legibilidad del código
        Proceso process;
        ArrayList <Proceso> listaListos = new ArrayList <Proceso>(colaListos);
        Iterator<Proceso> it = listaListos.iterator();
        colaListos = new ArrayList();
        while (it.hasNext()) {
            process = it.next();
            if (process.getCicloCPU() == 0 && process.getCicloES() == 0){
                tabla[0]= contT; contT++;
                tabla[1]= process.getDescripcion();
                tabla[2]= process.getTamaño();
                tabla[3]= process.getCicloCPU();
                tabla[4]= process.getCicloES();
                modelo.addRow(tabla);
                colaTerminados.add(process);
                colaListos = planificador.procesoTerminado(listaListos);
            }
        }    
        
    }   
    
    public final void cargarParticionesPrimerVez(){
        //Mostramos los procesos cargados en la lista
        ArrayList<Particion> listaParticiones;
        listaParticiones = mema.getListaParticiones();
        Iterator<Particion> it = listaParticiones.iterator();
        DefaultTableModel modelo=(DefaultTableModel) tablaParticiones.getModel();
        Object[] tabla = new Object[5];
        mema.Mostrar();
        while (it.hasNext()) {
            tabla[0]= contM; contM++;
            tabla[1]= "Vacío";
            tabla[2]= 0;
            tabla[3]= it.next().Tamaño();
            tabla[4]= 0;
            modelo.addRow(tabla);
        }
     
    }
    public int reiniciarTabla(javax.swing.JTable tabla){
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        while(modelo.getRowCount()>0)modelo.removeRow(0);
        return 1;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaColaListos;
    private javax.swing.JTable TablaTerminados;
    private java.awt.Button botonGantt;
    private java.awt.Button botonSiguiente;
    private javax.swing.JTextField gantt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private java.awt.Label label4;
    private java.awt.Label label5;
    private java.awt.Label label6;
    private javax.swing.JTable tablaCPU;
    private javax.swing.JTable tablaColaNuevo;
    private javax.swing.JTable tablaES;
    private javax.swing.JTable tablaParticiones;
    private javax.swing.JTextField tiempoo;
    // End of variables declaration//GEN-END:variables
}
