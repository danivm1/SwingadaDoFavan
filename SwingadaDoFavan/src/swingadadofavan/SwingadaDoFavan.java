/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swingadadofavan;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.*;

/**
 *
 * @author danivm
 */
public class SwingadaDoFavan extends javax.swing.JFrame {
    ArrayList<Departamento> listaDep;
    ArrayList<Funcionario> listaFunc;
    String botao;
    
    /**
     * Creates new form SwingadaDoFavan
     */
    public SwingadaDoFavan() {
        initComponents();
        listaDep = new ArrayList();
        listaFunc = new ArrayList();
        setLocationRelativeTo(null);
    }

    public void carregaTblDep(){
        int i;
        DefaultTableModel modelo = new DefaultTableModel(new Object[]{"Codigo","Nome"},0);
        
        for(i=0;i<listaDep.size();i++){
            Object linha[] = new Object[]{listaDep.get(i).getCodigo(), listaDep.get(i).getNome()};
            modelo.addRow(linha);
        }
        
        tblDep.setModel(modelo);
        tblDep.getColumnModel().getColumn(0).setResizable(false);
        tblDep.getColumnModel().getColumn(0).setPreferredWidth(80);
        tblDep.getColumnModel().getColumn(1).setResizable(false);
        tblDep.getColumnModel().getColumn(1).setPreferredWidth(420);
        
        carregaCBDep();
    }
    
    public void carregaTblFunc(){
        int i;
        DefaultTableModel modelo = new DefaultTableModel(new Object[]{"Codigo","Nome","Departamento"},0);
        
        for(i=0;i<listaFunc.size();i++){
            Object linha[] = new Object[]{listaFunc.get(i).getMatricula(), listaFunc.get(i).getNome(), listaFunc.get(i).getDep().getNome()};
            modelo.addRow(linha);
        }
        
        tblFunc.setModel(modelo);
        tblFunc.getColumnModel().getColumn(0).setResizable(false);
        tblFunc.getColumnModel().getColumn(0).setPreferredWidth(80);
        tblFunc.getColumnModel().getColumn(1).setResizable(false);
        tblFunc.getColumnModel().getColumn(1).setPreferredWidth(210);
        tblFunc.getColumnModel().getColumn(2).setResizable(false);
        tblFunc.getColumnModel().getColumn(2).setPreferredWidth(210);
    }
    
    public void carregaCBDep(){
        cbDepFunc.removeAllItems();
        cbDepFunc.addItem("Selecione");
        
        for(int i=0;i<listaDep.size();i++){
            cbDepFunc.addItem(listaDep.get(i).getNome());
        }
    }
    
    public void estadoComponenteDep(String n){
        switch(n){
            case "salvar":
                btnSaveDep.setEnabled(false);
                btnCancelDep.setEnabled(false);
                txtFCodigoDep.setEnabled(false);
                txtFNomeDep.setEnabled(false);
                txtFCodigoDep.setText("");
                txtFNomeDep.setText("");
                btnNewDep.setEnabled(true);
                break;
            case "novo":
                btnSaveDep.setEnabled(true);
                btnCancelDep.setEnabled(true);
                txtFCodigoDep.setEnabled(true);
                txtFNomeDep.setEnabled(true);
                btnEdtDep.setEnabled(false);
                btnNewDep.setEnabled(false);
                btnDelDep.setEnabled(false);
                txtFCodigoDep.setText("");
                txtFNomeDep.setText("");
                break;
            case "cancelar":
                btnSaveDep.setEnabled(false);
                btnCancelDep.setEnabled(false);
                txtFCodigoDep.setEnabled(false);
                txtFNomeDep.setEnabled(false);
                txtFCodigoDep.setText("");
                txtFNomeDep.setText("");
                btnNewDep.setEnabled(true);
                break;
            case "tabela":
                btnEdtDep.setEnabled(true);
                btnDelDep.setEnabled(true);
                break;
            case "editar":
                btnSaveDep.setEnabled(true);
                btnCancelDep.setEnabled(true);
                txtFCodigoDep.setEnabled(true);
                txtFNomeDep.setEnabled(true);
                btnEdtDep.setEnabled(false);
                btnDelDep.setEnabled(false);
                btnNewDep.setEnabled(false);
                break;
            case "excluir":
                btnSaveDep.setEnabled(false);
                btnCancelDep.setEnabled(false);
                txtFCodigoDep.setEnabled(false);
                txtFNomeDep.setEnabled(false);
                btnEdtDep.setEnabled(false);
                btnDelDep.setEnabled(false);
                txtFCodigoDep.setText("");
                txtFNomeFunc.setText("");
                break;
        }
    }
    
    public void estadoComponenteFunc(String n){
        switch(n){
            case "salvar":
                btnSaveFunc.setEnabled(false);
                btnCancelFunc.setEnabled(false);
                txtFMatFunc.setEnabled(false);
                txtFNomeFunc.setEnabled(false);
                cbDepFunc.setEnabled(false);
                btnNewFunc.setEnabled(true);
                txtFMatFunc.setText("");
                txtFNomeFunc.setText("");
                cbDepFunc.setSelectedIndex(0);
                break;
            case "novo":
                btnSaveFunc.setEnabled(true);
                btnCancelFunc.setEnabled(true);
                txtFMatFunc.setEnabled(true);
                txtFNomeFunc.setEnabled(true);
                cbDepFunc.setEnabled(true);
                btnNewFunc.setEnabled(false);
                txtFMatFunc.setText("");
                txtFNomeFunc.setText("");
                cbDepFunc.setSelectedIndex(0);
                break;
            case "cancelar":
                txtFMatFunc.setEnabled(false);
                btnCancelFunc.setEnabled(false);
                btnSaveFunc.setEnabled(false);
                txtFMatFunc.setEnabled(false);
                txtFNomeFunc.setEnabled(false);
                cbDepFunc.setEnabled(false);
                btnNewFunc.setEnabled(true);
                txtFMatFunc.setText("");
                txtFNomeFunc.setText("");
                cbDepFunc.setSelectedIndex(0);
                break;
            case "tabela":
                btnEdtFunc.setEnabled(true);
                btnDelFunc.setEnabled(true);
                break;
            case "editar":
                btnSaveFunc.setEnabled(true);
                btnCancelFunc.setEnabled(true);
                txtFMatFunc.setEnabled(true);
                txtFNomeFunc.setEnabled(true);
                btnEdtFunc.setEnabled(false);
                btnDelFunc.setEnabled(false);
                cbDepFunc.setEnabled(true);
                break;
            case "excluir":
                btnSaveFunc.setEnabled(false);
                btnCancelFunc.setEnabled(false);
                txtFMatFunc.setEnabled(false);
                txtFNomeFunc.setEnabled(false);
                btnEdtFunc.setEnabled(false);
                btnDelFunc.setEnabled(false);
                txtFMatFunc.setText("");
                txtFNomeFunc.setText("");
                cbDepFunc.setSelectedIndex(0);
                break;
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Painel = new javax.swing.JTabbedPane();
        Dep = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDep = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtFCodigoDep = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtFNomeDep = new javax.swing.JTextField();
        btnSaveDep = new javax.swing.JButton();
        btnCancelDep = new javax.swing.JButton();
        btnNewDep = new javax.swing.JButton();
        btnDelDep = new javax.swing.JButton();
        btnEdtDep = new javax.swing.JButton();
        Func = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblFunc = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtFMatFunc = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtFNomeFunc = new javax.swing.JTextField();
        btnSaveFunc = new javax.swing.JButton();
        btnCancelFunc = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        cbDepFunc = new javax.swing.JComboBox<>();
        btnNewFunc = new javax.swing.JButton();
        btnDelFunc = new javax.swing.JButton();
        btnEdtFunc = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        tblDep.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tblDep.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nome"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDep.getTableHeader().setReorderingAllowed(false);
        tblDep.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDepMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDep);
        if (tblDep.getColumnModel().getColumnCount() > 0) {
            tblDep.getColumnModel().getColumn(0).setResizable(false);
            tblDep.getColumnModel().getColumn(0).setPreferredWidth(80);
            tblDep.getColumnModel().getColumn(1).setResizable(false);
            tblDep.getColumnModel().getColumn(1).setPreferredWidth(210);
        }

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Departamento"));

        jLabel1.setText("Código:");

        txtFCodigoDep.setEnabled(false);
        txtFCodigoDep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFCodigoDepActionPerformed(evt);
            }
        });

        jLabel2.setText("Nome:");

        txtFNomeDep.setEnabled(false);
        txtFNomeDep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFNomeDepActionPerformed(evt);
            }
        });

        btnSaveDep.setText("Salvar");
        btnSaveDep.setEnabled(false);
        btnSaveDep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveDepActionPerformed(evt);
            }
        });

        btnCancelDep.setText("Cancelar");
        btnCancelDep.setEnabled(false);
        btnCancelDep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelDepActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtFNomeDep, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtFCodigoDep, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSaveDep, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelDep, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFCodigoDep, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSaveDep, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelDep))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFNomeDep, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnNewDep.setText("Novo");
        btnNewDep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewDepActionPerformed(evt);
            }
        });

        btnDelDep.setText("Excluir");
        btnDelDep.setEnabled(false);
        btnDelDep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelDepActionPerformed(evt);
            }
        });

        btnEdtDep.setText("Editar");
        btnEdtDep.setEnabled(false);
        btnEdtDep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEdtDepActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout DepLayout = new javax.swing.GroupLayout(Dep);
        Dep.setLayout(DepLayout);
        DepLayout.setHorizontalGroup(
            DepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DepLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(DepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DepLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(DepLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(btnNewDep, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEdtDep, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnDelDep, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        DepLayout.setVerticalGroup(
            DepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DepLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(DepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNewDep)
                    .addComponent(btnDelDep)
                    .addComponent(btnEdtDep))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Painel.addTab("Departamentos", Dep);

        tblFunc.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tblFunc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Matricula", "Nome", "Departamento"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblFunc.getTableHeader().setReorderingAllowed(false);
        tblFunc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblFuncMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblFunc);
        if (tblFunc.getColumnModel().getColumnCount() > 0) {
            tblFunc.getColumnModel().getColumn(0).setResizable(false);
            tblFunc.getColumnModel().getColumn(0).setPreferredWidth(80);
            tblFunc.getColumnModel().getColumn(1).setResizable(false);
            tblFunc.getColumnModel().getColumn(1).setPreferredWidth(210);
            tblFunc.getColumnModel().getColumn(2).setResizable(false);
            tblFunc.getColumnModel().getColumn(2).setPreferredWidth(210);
        }

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Funcionario"));

        jLabel3.setText("Matricula:");

        txtFMatFunc.setEnabled(false);
        txtFMatFunc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFMatFuncActionPerformed(evt);
            }
        });

        jLabel4.setText("Nome:");

        txtFNomeFunc.setEnabled(false);
        txtFNomeFunc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFNomeFuncActionPerformed(evt);
            }
        });

        btnSaveFunc.setText("Salvar");
        btnSaveFunc.setEnabled(false);
        btnSaveFunc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveFuncActionPerformed(evt);
            }
        });

        btnCancelFunc.setText("Cancelar");
        btnCancelFunc.setEnabled(false);
        btnCancelFunc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelFuncActionPerformed(evt);
            }
        });

        jLabel5.setText("Departamento:");

        cbDepFunc.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFNomeFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtFMatFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSaveFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnCancelFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(46, 46, 46)
                        .addComponent(cbDepFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFMatFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSaveFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelFunc))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFNomeFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbDepFunc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        btnNewFunc.setText("Novo");
        btnNewFunc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewFuncActionPerformed(evt);
            }
        });

        btnDelFunc.setText("Excluir");
        btnDelFunc.setEnabled(false);
        btnDelFunc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelFuncActionPerformed(evt);
            }
        });

        btnEdtFunc.setText("Editar");
        btnEdtFunc.setEnabled(false);
        btnEdtFunc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEdtFuncActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout FuncLayout = new javax.swing.GroupLayout(Func);
        Func.setLayout(FuncLayout);
        FuncLayout.setHorizontalGroup(
            FuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FuncLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(FuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FuncLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(FuncLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(btnNewFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEdtFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnDelFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        FuncLayout.setVerticalGroup(
            FuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FuncLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(FuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNewFunc)
                    .addComponent(btnDelFunc)
                    .addComponent(btnEdtFunc))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        Painel.addTab("Funcionarios", Func);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Painel)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Painel)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtFCodigoDepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFCodigoDepActionPerformed
    }//GEN-LAST:event_txtFCodigoDepActionPerformed

    private void txtFNomeDepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFNomeDepActionPerformed
    }//GEN-LAST:event_txtFNomeDepActionPerformed

    private void btnCancelDepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelDepActionPerformed
        botao = "cancelar";
        estadoComponenteDep(botao);
    }//GEN-LAST:event_btnCancelDepActionPerformed

    private void btnNewDepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewDepActionPerformed
        botao = "novo";
        estadoComponenteDep(botao);
    }//GEN-LAST:event_btnNewDepActionPerformed

    private void btnSaveDepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveDepActionPerformed
        if(botao.equals("novo")){
            Departamento dep =  new Departamento(Integer.parseInt(txtFCodigoDep.getText()), txtFNomeDep.getText());
            listaDep.add(dep);
        }else{
            int i = tblDep.getSelectedRow();
            listaDep.get(i).setCodigo(Integer.parseInt(txtFCodigoDep.getText()));
            listaDep.get(i).setNome(txtFNomeDep.getText());
        }
        
        carregaTblDep();
        
        botao = "salvar";
        estadoComponenteDep(botao);
    }//GEN-LAST:event_btnSaveDepActionPerformed

    private void tblDepMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDepMouseClicked
        int i = tblDep.getSelectedRow();
        
        if(i>=0 && i<listaDep.size()){
            Departamento dep = listaDep.get(i);
            txtFCodigoDep.setText(String.valueOf(dep.getCodigo()));
            txtFNomeDep.setText(dep.getNome());
            botao = "tabela";
            estadoComponenteDep(botao);
        }
    }//GEN-LAST:event_tblDepMouseClicked

    private void btnEdtDepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEdtDepActionPerformed
        botao = "editar";
        estadoComponenteDep(botao);
    }//GEN-LAST:event_btnEdtDepActionPerformed

    private void btnDelDepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelDepActionPerformed
        int i = tblDep.getSelectedRow();
        if(i>=0 && i<listaDep.size()){
            listaDep.remove(i);
            txtFCodigoDep.setText("");
            txtFNomeDep.setText("");
        }
        
        carregaTblDep();
        
        botao = "excluir";
        estadoComponenteDep(botao);
    }//GEN-LAST:event_btnDelDepActionPerformed

    private void tblFuncMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblFuncMouseClicked
        int i = tblFunc.getSelectedRow();
        if(i>=0 && i<listaFunc.size()){
            Funcionario func = listaFunc.get(i);
            txtFMatFunc.setText(String.valueOf(func.getMatricula()));
            txtFNomeFunc.setText(func.getNome());
            botao = "tabela";
            estadoComponenteFunc(botao);
        }
    }//GEN-LAST:event_tblFuncMouseClicked

    private void txtFMatFuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFMatFuncActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFMatFuncActionPerformed

    private void txtFNomeFuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFNomeFuncActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFNomeFuncActionPerformed

    private void btnSaveFuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveFuncActionPerformed
        int i = cbDepFunc.getSelectedIndex();
        
        if(botao.equals("novo")){
            if(i==0){
                JOptionPane.showMessageDialog(this, "Selecione um departamento");
            }else{
                Funcionario func = new Funcionario();
                func.setMatricula(Integer.parseInt(txtFMatFunc.getText()));
                func.setNome(txtFNomeFunc.getText());
             	func.setDep(listaDep.get(i-1));
             
                listaFunc.add(func);
                listaDep.get(i-1).addFunc(func);
            }
        }else{
            int index = tblFunc.getSelectedRow();
            listaFunc.get(index).setMatricula(Integer.parseInt(txtFMatFunc.getText()));
            listaFunc.get(index).setNome(txtFNomeFunc.getText());
            //listaFunc.get(index).setDep();
        }
        
        botao = "salvar";
        estadoComponenteFunc(botao);
        
        carregaTblFunc();
    }//GEN-LAST:event_btnSaveFuncActionPerformed

    private void btnCancelFuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelFuncActionPerformed
        botao = "cancelar";
        estadoComponenteFunc(botao);
    }//GEN-LAST:event_btnCancelFuncActionPerformed

    private void btnNewFuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewFuncActionPerformed
        botao = "novo";
        estadoComponenteFunc(botao);
    }//GEN-LAST:event_btnNewFuncActionPerformed

    private void btnDelFuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelFuncActionPerformed
        int i = tblFunc.getSelectedRow();
        if(i>=0 && i<listaFunc.size()){
            listaFunc.remove(i);
            
            carregaTblFunc();
        
            botao = "excluir";
            estadoComponenteFunc(botao);
        }
    }//GEN-LAST:event_btnDelFuncActionPerformed

    private void btnEdtFuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEdtFuncActionPerformed
        botao = "editar";
        estadoComponenteFunc(botao);
    }//GEN-LAST:event_btnEdtFuncActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SwingadaDoFavan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SwingadaDoFavan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Dep;
    private javax.swing.JPanel Func;
    private javax.swing.JTabbedPane Painel;
    private javax.swing.JButton btnCancelDep;
    private javax.swing.JButton btnCancelFunc;
    private javax.swing.JButton btnDelDep;
    private javax.swing.JButton btnDelFunc;
    private javax.swing.JButton btnEdtDep;
    private javax.swing.JButton btnEdtFunc;
    private javax.swing.JButton btnNewDep;
    private javax.swing.JButton btnNewFunc;
    private javax.swing.JButton btnSaveDep;
    private javax.swing.JButton btnSaveFunc;
    private javax.swing.JComboBox<String> cbDepFunc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblDep;
    private javax.swing.JTable tblFunc;
    private javax.swing.JTextField txtFCodigoDep;
    private javax.swing.JTextField txtFMatFunc;
    private javax.swing.JTextField txtFNomeDep;
    private javax.swing.JTextField txtFNomeFunc;
    // End of variables declaration//GEN-END:variables
}
