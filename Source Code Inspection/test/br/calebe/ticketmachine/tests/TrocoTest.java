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
public class TrocoTest {

    public TrocoTest() {
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

    @Test
    public void trocoIteratorTest() throws PapelMoedaInvalidaException, SaldoInsuficienteException {

        TicketMachine tm_1 = new TicketMachine(10);
        tm_1.inserir(100);
        tm_1.retirarTicket();

        TicketMachine tm_2 = new TicketMachine(20);
        tm_2.inserir(100);
        tm_2.retirarTicket();
    

        assertNotEquals("Checar se as messagens de troco são diferentes", tm_2.getTroco(), tm_1.getTroco());
       
        tm_1.inserir(10);
        tm_1.retirarTicket();
        tm_2.inserir(20);
        tm_2.retirarTicket();
        
        assertEquals("Checar se as messagens de troco são iguais", tm_2.getTroco(), tm_1.getTroco());

       
    }

}
