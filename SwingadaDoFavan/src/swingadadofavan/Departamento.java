package swingadadofavan;

import java.util.ArrayList;

/**
 *
 * @author danivm
 */
public class Departamento {
    private int codigo;
    private String nome;
    ArrayList<Funcionario> listaFunc;
    
    public Departamento(){
        listaFunc = new ArrayList();
    }
    
    public Departamento(int codigo, String nome){
        this.codigo = codigo;
        this.nome = nome;
        listaFunc = new ArrayList();
    }
    
    public void addFunc(Funcionario func){
        func.setDep(this);
        listaFunc.add(func);
    }
    
    
    
    
    
    
    
    
    //----------- Getters 'n' Setters -----------------------------------------
    
    public ArrayList<Funcionario> getListaFunc() {
        return listaFunc;
    }

    public void setListaFunc(ArrayList<Funcionario> listaFunc) {
        this.listaFunc = listaFunc;
    }
   

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
}
