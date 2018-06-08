
package vista;

import controladores.ControladorFrameTipoTramite;
import javax.swing.JTable;

public class VistaTipoTramites extends javax.swing.JFrame {

   public static String BTN_AGREGAR = "boton agregar";
   public static String BTN_CANCELAR = "boton cancelar";
   public static String BTN_SELECCIONAR = "boton seleccionar";
   public static String BTN_MODIFICAR = "boton modificar";
   
   
   
   
    public VistaTipoTramites() {
        initComponents();
        btn_agregar.setActionCommand(BTN_AGREGAR);
        btn_cancelar.setActionCommand(BTN_CANCELAR);
        btn_seleccionar.setActionCommand(BTN_SELECCIONAR);
        btn_modificar.setActionCommand(BTN_MODIFICAR);
        
    }
    
    
    public void setControlador(ControladorFrameTipoTramite control){
      btn_agregar.addActionListener(control);
      btn_modificar.addActionListener(control);
      btn_seleccionar.addActionListener(control);
      btn_modificar.addActionListener(control);
    }

    public void Ejecutar(){
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
    
    public void SetTablaTipoTramite(JTable tablaTipoTramites){
        tablaTipoTramites = tablaTramites;
    }
    
    public JTable getTablaTipoTramite(){
        return tablaTramites;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaTramites = new javax.swing.JTable();
        btn_seleccionar = new javax.swing.JButton();
        btn_cancelar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btn_agregar = new javax.swing.JButton();
        btn_modificar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tablaTramites.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Id", "Nombre"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaTramites);
        if (tablaTramites.getColumnModel().getColumnCount() > 0) {
            tablaTramites.getColumnModel().getColumn(0).setResizable(false);
            tablaTramites.getColumnModel().getColumn(1).setResizable(false);
        }

        btn_seleccionar.setText("Seleccionar");
        btn_seleccionar.setEnabled(false);

        btn_cancelar.setText("Cancelar");
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel2.setText("Tipos de Tramites/Trabajos");

        btn_agregar.setText("Agregar");

        btn_modificar.setText("Modificar");
        btn_modificar.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btn_modificar)
                            .addGap(73, 73, 73)
                            .addComponent(btn_agregar))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_cancelar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_seleccionar)))))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_agregar)
                    .addComponent(btn_modificar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_seleccionar)
                    .addComponent(btn_cancelar))
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
          this.dispose();
    }//GEN-LAST:event_btn_cancelarActionPerformed

  
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_agregar;
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_modificar;
    private javax.swing.JButton btn_seleccionar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaTramites;
    // End of variables declaration//GEN-END:variables
}
