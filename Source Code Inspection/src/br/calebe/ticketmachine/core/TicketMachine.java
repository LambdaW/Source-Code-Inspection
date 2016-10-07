package br.calebe.ticketmachine.core;

import br.calebe.ticketmachine.exception.PapelMoedaInvalidaException;
import br.calebe.ticketmachine.exception.SaldoInsuficienteException;
import java.util.Iterator;

/**
 *
 * @author Calebe de Paula Bianchini
 */
public class TicketMachine {

    protected int valor;
    protected int saldo;
    protected int[] papelMoeda = {2, 5, 10, 20, 50, 100};

    public TicketMachine(int valor) {
        this.valor = valor;
        this.saldo = 0;
    }

    public void verificarSaldo(boolean achou) throws  PapelMoedaInvalidaException{
        
        if(!achou)
            throw new PapelMoedaInvalidaException("Prezado usuário, você inseriu um Valor de Moeda Inválido"
                    + "\nTente novamente com os seguintes valores: 2,5,10,20,50,100.");
        else 
            imprimir();
    }
    
    public void inserir(int quantia) throws PapelMoedaInvalidaException, SaldoInsuficienteException {
        boolean achou = false;
        for (int i = 0; i < papelMoeda.length && !achou; i++) {
            
            if (papelMoeda[i] == quantia) {
                achou = true;
                this.saldo += quantia;
            }
        }
       
        verificarSaldo(achou);
    }
    
    public void retirarTicket() throws SaldoInsuficienteException{
        
        if(saldo >= valor){
            saldo-=valor;
            //imprime ticket
            //mostra saldo atual
            imprimir();
 
        }else{
            throw new SaldoInsuficienteException("Prezado usuário, você não possui saldo"
                    + " suficiente para a compra do ticket./nValor do Ticket: "+this.valor+
                    "\nValor do seu saldo: "+this.saldo );
        }
            
    }
    
    public int getValor(){
        return this.valor;
    }

    public int getSaldo() {
        return saldo;
    }

    public String  getTroco() {
        
        Iterator<PapelMoeda> iterator_troco =  new Troco(saldo).getIterator();
        
        StringBuilder troco_msg = new StringBuilder("Seu troco será:\n  ");
       
        while(iterator_troco.hasNext()){
            PapelMoeda pm;
            pm = iterator_troco.next();
            troco_msg.append("\nCédula de ").append(pm.getValor()).append(", quantidade:").append(pm.getQuantidade());
            
        }
        
        this.saldo=0;
 
        //zera saldo do cliente, e retorna o troco
        return troco_msg.toString();
    }
    
  

    public String imprimir() {
        StringBuilder result = new StringBuilder("*****************\n");
        result.append( "*** R$ ").append(saldo).append(",00 ****\n");
        result.append( "*****************\n");
        return result.toString();
    }
    
    
    public void setValor(int valor){
        this.valor = valor;
    }
}
    

