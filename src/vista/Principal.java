package vista;

import controladores.ControladorFramePrincipal;

public class Principal extends javax.swing.JFrame {
    
    public static final String BTN_ALTAEXPEDIENTE = "ALTA_EXPEDIENTES";
    public static final String BTN_BUSCAREXPEDIENTE = "BUSCAR_EXPEDIENTES";
    
    public static final String MENUITEM_EMPLEADOS = "ALTA_EMPLEADOS";
    public static final String MENUITEM_TRAMITES = "ALTA_TRAMITES";
    public static final String MENUITEM_OFICINAS = "OFICINAS";
    
    
    public Principal() {
        initComponents();
        mItem_personal.setActionCommand(MENUITEM_EMPLEADOS);
        mItem_tramites.setActionCommand(MENUITEM_TRAMITES);
        mItem_Oficinas.setActionCommand(MENUITEM_OFICINAS);
    }
    
    public void setControlador(ControladorFramePrincipal control){
        
        mItem_personal.addActionListener(control);
        mItem_tramites.addActionListener(control);
        mItem_Oficinas.addActionListener(control);
    }
     
    public void Ejecutar(){
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        boton_altaExpediente = new javax.swing.JButton();
        boton_buscarExpediente = new javax.swing.JButton();
        boton_buscarTramite = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mItem_personal = new javax.swing.JMenuItem();
        mItem_tramites = new javax.swing.JMenuItem();
        mItem_Oficinas = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        boton_altaExpediente.setText("Alta Expediente");

        boton_buscarExpediente.setText("Buscar Expediente");

        boton_buscarTramite.setText("Buscar Tramite");

        jMenu1.setText("File");

        mItem_personal.setText("Personal");
        jMenu1.add(mItem_personal);

        mItem_tramites.setText("Tramites");
        jMenu1.add(mItem_tramites);

        mItem_Oficinas.setText("Oficinas");
        jMenu1.add(mItem_Oficinas);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 537, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(boton_altaExpediente, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(46, 46, 46)
                    .addComponent(boton_buscarExpediente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(46, 46, 46)
                    .addComponent(boton_buscarTramite, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(109, 109, 109)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(boton_buscarExpediente, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(boton_altaExpediente, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(boton_buscarTramite, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(89, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton_altaExpediente;
    private javax.swing.JButton boton_buscarExpediente;
    private javax.swing.JButton boton_buscarTramite;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem mItem_Oficinas;
    private javax.swing.JMenuItem mItem_personal;
    private javax.swing.JMenuItem mItem_tramites;
    // End of variables declaration//GEN-END:variables
}
