
package vista;

import controladores.ControladorFrameAltaExpediente;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JTable;
import javax.swing.SpinnerNumberModel;
import modelo.Elemento;
import modelo.Oficina;
import modelo.TipoElemento;

/**
 *
 * @author Laboratio
 */
public class VistaAltaExpediente extends javax.swing.JFrame {

    public static String BTN_AGREGAR_ELEMENTO = "Agregar elemento de secuestro";
    public static String BTN_AGREGAR_TRAMITE = "Agregar tipo de tramite al expediente";
    public static String BTN_ACEPTAR = "Aceptar";
    
private SpinnerNumberModel nm = new SpinnerNumberModel();

    
    public VistaAltaExpediente() {
        
        initComponents();
        this.setLocationRelativeTo(null);
        comboOrigenOficina.removeAllItems();
        comboDestinoOficina.removeAllItems();      
        comboResponsable.removeAllItems();
        comboTipoTramite.removeAllItems();
        comboTipoElementoSecuestro.removeAllItems();
        botonAgregarElemento.setActionCommand(BTN_AGREGAR_ELEMENTO);
        botonAgregarTramite.setActionCommand(BTN_AGREGAR_TRAMITE);
        botonAceptar.setActionCommand(BTN_ACEPTAR);
        
       nm.setMinimum(1);
       nm.setMaximum(100);
       spinnerCantidadElementos.setModel(nm);
       spinnerCantidadElementos.setValue(1);
      
    }

  
  public void setControlador(ControladorFrameAltaExpediente control){
      botonAceptar.addActionListener(control);
      botonAgregarElemento.addActionListener(control);
      botonAgregarTramite.addActionListener(control);
  }
  
  
    public void setComboOrigenOficina(ArrayList<Oficina> Oficinas){
        
        for(int i = 0; i<Oficinas.size();i++){
            this.comboOrigenOficina.addItem(Oficinas.get(i));
        }
    }
    
    public Oficina getComboOrigenOficina(){
        return (Oficina) this.comboOrigenOficina.getSelectedItem();
    }
    
    public void setComboDestinoOficina(ArrayList<Oficina> Oficinas){
        
        for(int i = 0; i<Oficinas.size();i++){
            this.comboDestinoOficina.addItem(Oficinas.get(i));
        }
    }
    
    public Oficina getComboDestinoOficina(){
        return (Oficina) this.comboDestinoOficina.getSelectedItem();
    }
    
    public void setComboResponsable(ArrayList<String> arrayResponsable){
        for(int i = 0; i<arrayResponsable.size();i++){
            this.comboResponsable.addItem(arrayResponsable.get(i));
        }
    }
    
    public void setTextoFechaHoy(String fechaHoy){
        this.textoFechaHoy.setText(fechaHoy);
    }
    
    public String getTextoFechaHoy(){
        return this.textoFechaHoy.getText();
    }
    
    public void setTextoNroInterno(String nroInterno){
        this.textoNroInterno.setText(nroInterno);
    }
    
    public Integer getTextoNroInterno(){
        return Integer.parseInt(textoNroInterno.getText());
    }
    
    public void setComboTipoExpediente(){
        
    }
    
    public String getComboTipoExpediente(){
        return ""+this.comboTipoExpediente.getSelectedItem();
    }
    
    public void setTextoNroSumario(Integer NroSumario){
        this.textoNroSumario.setText(String.valueOf(NroSumario));
    }
    
    public Integer getTextoNroSumario(){
        return Integer.parseInt(this.textoNroSumario.getText());
    }
    
    public void settextoAñoSumario(Integer año){
        this.textoAñoSumario.setText(String.valueOf(año));
    }
    
    public Integer getTextoAñoSumario(){
        return Integer.parseInt(this.textoAñoSumario.getText());
    }
    
    public void setTextNroOficio(Integer NroOficio){
        this.textoNroOficio.setText(String.valueOf(NroOficio));
    }
    
    public Integer getTextNroOficio(){
        return Integer.parseInt(this.textoAñoSumario.getText());
    }
    
    public void setTextoCausa(String causa){
        this.textoCausa.setText(causa);
    }
    
    public String getTextoCausa(){
        return this.textoCausa.getText();
    }
    
    public void setTextoNroLibro(Integer nroLibro){
        this.textoNroLibro.setText(String.valueOf(nroLibro));
    }
    
    public Integer getTextoNroLibro(){
        return Integer.parseInt(this.textoNroLibro.getText());
    }
    
    public void setTextoNroFolio(Integer nroFolio){
        this.textoNroFolio.setText(String.valueOf(nroFolio));
    }
    
    public Integer getTextoNroFolio(){
        return Integer.parseInt(textoNroFolio.getText());
    }
    
    public void setComboTipoElementosSecuestro(ArrayList<TipoElemento> tiposElementos){
    
         for(int i = 0; i<tiposElementos.size();i++){
            this.comboTipoElementoSecuestro.addItem(tiposElementos.get(i));
        }
    }
    
    public TipoElemento getComboTipoElementosSecuestro(){
        return (TipoElemento) this.comboTipoElementoSecuestro.getSelectedItem();
    }
    
    public void setTextoDescSecuestro(String descSecuestro){
        this.textoDescSecuestro.setText(descSecuestro);
    }
    
    public String getTextoDescSecuestro(){
        return this.textoDescSecuestro.getText();
    }
    
    public void limpiarTextoDescSecuestro(){
        this.textoDescSecuestro.setText("");
    }
    public void setTablaElementosSecuestros(JTable tablaElementosSecuestros){
        this.tablaElementosSecuestro = tablaElementosSecuestros;
    }
    
    public JTable getTablaElementosSecuestros(){
        return this.tablaElementosSecuestro;
    }
    
    public void setComboTipoTramite(ArrayList<String> arrayTramites){
        for(int i = 0; i<arrayTramites.size();i++){
            this.comboTipoTramite.addItem(arrayTramites.get(i));
        }
    }
    
    public String getComboTipoTramite(){
        return ""+this.comboTipoTramite.getSelectedItem();
    }
    
    public void setTextoDescripcionTramite(String descTramite){
        this.textoDescripcionTramite.setText(descTramite);
    }
    
    public void limpiarTextoDescripcionTramite(){
        this.textoDescripcionTramite.setText("");
    }
    
    public String getTextoDescripcionTramite(){
        return this.textoDescripcionTramite.getText();
    }
    
    public void setTablaTiposDeTramites(JTable tablaTipoDeTramites){
        this.tablaTiposDeTramites = tablaTipoDeTramites;
    }
    
    public JTable getTablaTiposDeTramites(){
        return this.tablaTiposDeTramites;
    }
    
    public void setComboResponsable(){
        
    }
    
    public String getComboResponsable(){
        return ""+this.comboResponsable.getSelectedItem();
    }
    
    public void setTextoPlazo(Integer plazo){
        this.textoPlazo.setText(String.valueOf(plazo));
    }
    
    public Integer getTextoPlazo(){
        return Integer.parseInt(this.textoPlazo.getText());
    }
    
    public String getComboEstadoTramite(){
        return ""+this.comboEstadoTramite.getSelectedItem();
    }
    
    public void setSpinnerCantidadElementos(Integer cantidad){
        this.spinnerCantidadElementos.setValue(cantidad);
    }
    
    public Integer getSpinnerCantidadElementos(){
        return Integer.parseInt(String.valueOf(this.spinnerCantidadElementos.getValue()));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPasswordField1 = new javax.swing.JPasswordField();
        jPasswordField2 = new javax.swing.JPasswordField();
        jButton2 = new javax.swing.JButton();
        botonAceptar = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        spinnerCantidadElementos = new javax.swing.JSpinner();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaElementosSecuestro = new javax.swing.JTable();
        botonAgregarElemento = new javax.swing.JButton();
        textoDescSecuestro = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        comboTipoElementoSecuestro = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        textoFechaHoy = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        textoNroInterno = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        comboTipoExpediente = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        textoNroSumario = new javax.swing.JTextField();
        textoAñoSumario = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textoCausa = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        comboDestinoOficina = new javax.swing.JComboBox<>();
        jLabel20 = new javax.swing.JLabel();
        textoNroLibro = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        textoNroFolio = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        textoNroOficio = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        comboOrigenOficina = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        comboTipoTramite = new javax.swing.JComboBox<>();
        textoDescripcionTramite = new javax.swing.JTextField();
        botonAgregarTramite = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaTiposDeTramites = new javax.swing.JTable();
        jLabel19 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        comboResponsable = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        textoPlazo = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        comboEstadoTramite = new javax.swing.JComboBox<>();

        jPasswordField1.setText("jPasswordField1");

        jPasswordField2.setText("jPasswordField2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        botonAceptar.setText("Aceptar");

        jLabel18.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel18.setText("ALTA ENTRADA DE EXPEDIENTE");

        jLabel14.setText("Tipo:");

        jLabel15.setText("Cantidad:");

        tablaElementosSecuestro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nro", "Tipo", "Cantidad", "Descripcion"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tablaElementosSecuestro);

        botonAgregarElemento.setText("Agregar");

        jLabel16.setText("Descripción:");

        jLabel17.setText("Elementos/Secuestros");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(281, 281, 281)
                        .addComponent(jLabel17))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(textoDescSecuestro, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botonAgregarElemento))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(comboTipoElementoSecuestro, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(spinnerCantidadElementos, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 607, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel16)))))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(spinnerCantidadElementos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(comboTipoElementoSecuestro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textoDescSecuestro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(botonAgregarElemento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel6.setText("Fecha:");

        textoFechaHoy.setText("XX/XX/XXXX");

        jLabel1.setText("N° Interno:");

        textoNroInterno.setEditable(false);

        jLabel2.setText("Tipo:");

        comboTipoExpediente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione el tipo de expediente", "Sumario", "Oficio", "Nota", "Exp. especial" }));
        comboTipoExpediente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboTipoExpedienteActionPerformed(evt);
            }
        });

        jLabel3.setText("N° Sumario:");

        textoNroSumario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textoNroSumarioActionPerformed(evt);
            }
        });

        jLabel5.setText("Causa:");

        textoCausa.setColumns(20);
        textoCausa.setRows(5);
        textoCausa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textoCausaKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(textoCausa);

        jLabel8.setText("Procedencia:");

        jLabel9.setText("Destino:");

        jLabel20.setText("Libro:");

        jLabel21.setText("Folio:");

        jLabel22.setText("N°Oficio:");

        jLabel4.setText("Año:");

        jLabel7.setText("Descripción:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel22)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)))
                            .addComponent(jLabel8)
                            .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(comboTipoExpediente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(textoNroLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel21)
                                .addGap(18, 18, 18)
                                .addComponent(textoNroFolio, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(textoNroOficio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                                    .addComponent(textoNroSumario, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textoAñoSumario, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(comboOrigenOficina, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textoNroInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel9)
                    .addComponent(jLabel7))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
                    .addComponent(comboDestinoOficina, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1))
                .addGap(41, 41, 41))
            .addComponent(jSeparator1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(textoNroInterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboTipoExpediente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(2, 2, 2)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(textoNroSumario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(textoAñoSumario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(textoNroOficio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboOrigenOficina, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textoNroLibro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20)
                            .addComponent(jLabel21)
                            .addComponent(textoNroFolio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(84, 84, 84)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(comboDestinoOficina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(30, 30, 30)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel10.setText("Tipo:");

        botonAgregarTramite.setText("Agregar");

        tablaTiposDeTramites.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Tipo", "Descripcion"
            }
        ));
        jScrollPane3.setViewportView(tablaTiposDeTramites);

        jLabel19.setText("Tramite");

        jLabel23.setText("Descripción:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(jLabel10)))
                        .addGap(18, 18, 18)
                        .addComponent(textoDescripcionTramite, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonAgregarTramite))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 605, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(comboTipoTramite, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addGap(307, 307, 307)
                        .addComponent(jLabel19)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(comboTipoTramite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(textoDescripcionTramite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonAgregarTramite))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator2)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGap(527, 527, 527)
                                .addComponent(jLabel6)
                                .addGap(6, 6, 6)
                                .addComponent(textoFechaHoy))
                            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 33, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(textoFechaHoy))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel12.setText("Responsable:");

        comboResponsable.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel11.setText("Plazo:");

        jLabel13.setText("Estado:");

        comboEstadoTramite.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Entrada", "En proceso", "Finalizado", "Salida", "Parado" }));
        comboEstadoTramite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboEstadoTramiteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(242, 242, 242)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(18, 18, 18)
                        .addComponent(comboResponsable, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textoPlazo, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel13))
                    .addComponent(jButton2))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboEstadoTramite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel18)
                .addGap(7, 7, 7)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(comboResponsable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel12))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textoPlazo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel13))
                    .addComponent(comboEstadoTramite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2)
                    .addComponent(botonAceptar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textoNroSumarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textoNroSumarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textoNroSumarioActionPerformed

    private void comboEstadoTramiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboEstadoTramiteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboEstadoTramiteActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void comboTipoExpedienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboTipoExpedienteActionPerformed
    if(comboTipoExpediente.getSelectedItem().equals("Sumario")){
        textoNroSumario.setEditable(true);
        textoAñoSumario.setEditable(true);
        textoNroOficio.setEditable(false);
    }
      if(comboTipoExpediente.getSelectedItem().equals("Oficio")){
        textoNroOficio.setEditable(true);
        textoNroSumario.setEditable(true);
        textoAñoSumario.setEditable(true);
    }
      if(comboTipoExpediente.getSelectedItem().equals("Nota")){
        textoNroOficio.setEditable(false);
        textoNroSumario.setEditable(false);
        textoAñoSumario.setEditable(false);
    }
    }//GEN-LAST:event_comboTipoExpedienteActionPerformed

    private void textoCausaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textoCausaKeyTyped
       char c= evt.getKeyChar();
       if(Character.isLowerCase(c)){
           String cad = (""+c).toUpperCase();
           c=cad.charAt(0);
           evt.setKeyChar(c);
       } 
    }//GEN-LAST:event_textoCausaKeyTyped

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAceptar;
    private javax.swing.JButton botonAgregarElemento;
    private javax.swing.JButton botonAgregarTramite;
    private javax.swing.JComboBox<Oficina> comboDestinoOficina;
    private javax.swing.JComboBox<String> comboEstadoTramite;
    private javax.swing.JComboBox<Oficina> comboOrigenOficina;
    private javax.swing.JComboBox<String> comboResponsable;
    private javax.swing.JComboBox<TipoElemento> comboTipoElementoSecuestro;
    private javax.swing.JComboBox<String> comboTipoExpediente;
    private javax.swing.JComboBox<String> comboTipoTramite;
    private javax.swing.JButton jButton2;
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
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JSpinner spinnerCantidadElementos;
    private javax.swing.JTable tablaElementosSecuestro;
    private javax.swing.JTable tablaTiposDeTramites;
    private javax.swing.JTextField textoAñoSumario;
    private javax.swing.JTextArea textoCausa;
    private javax.swing.JTextField textoDescSecuestro;
    private javax.swing.JTextField textoDescripcionTramite;
    private javax.swing.JLabel textoFechaHoy;
    private javax.swing.JTextField textoNroFolio;
    private javax.swing.JTextField textoNroInterno;
    private javax.swing.JTextField textoNroLibro;
    private javax.swing.JTextField textoNroOficio;
    private javax.swing.JTextField textoNroSumario;
    private javax.swing.JTextField textoPlazo;
    // End of variables declaration//GEN-END:variables

    public void ejecutar() {
        this.setVisible(true);
    }
}
