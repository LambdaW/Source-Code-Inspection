/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.calebe.ticketmachine.tests;

import br.calebe.ticketmachine.core.TicketMachine;
import br.calebe.ticketmachine.exception.PapelMoedaInvalidaException;
import br.calebe.ticketmachine.exception.SaldoInsuficienteException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pardim
 */
public class TicketMachineTest {
    
    public TicketMachineTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test(expected = PapelMoedaInvalidaException.class)
    public void ticketMachineShouldRaisePMIException() throws  SaldoInsuficienteException, PapelMoedaInvalidaException{
        TicketMachine tm = new TicketMachine(10);
        tm.inserir(13);
    }
    
    @Test(expected = SaldoInsuficienteException.class)
    public void PapelMoedaShouldRaiseSaldoInsuficienteExcpetion() throws  SaldoInsuficienteException, PapelMoedaInvalidaException{
        TicketMachine tm = new TicketMachine(10);
        tm.inserir(5);
        tm.retirarTicket();
    }
    
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
