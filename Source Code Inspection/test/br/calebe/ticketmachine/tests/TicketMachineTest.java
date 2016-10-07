/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.calebe.ticketmachine.tests;

import br.calebe.ticketmachine.core.PapelMoeda;

import br.calebe.ticketmachine.core.TicketMachine;
import br.calebe.ticketmachine.exception.PapelMoedaInvalidaException;
import br.calebe.ticketmachine.exception.SaldoInsuficienteException;
import java.util.Iterator;
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
    public void ticketMachineShouldRaisePMIException() throws SaldoInsuficienteException, PapelMoedaInvalidaException {
        TicketMachine tm = new TicketMachine(10);
        tm.inserir(13);
    }

    @Test(expected = SaldoInsuficienteException.class)
    public void ticketMachineShouldRaiseSaldoInsuficienteExcpetion() throws SaldoInsuficienteException, PapelMoedaInvalidaException {
        TicketMachine tm = new TicketMachine(10);
        tm.inserir(5);
        tm.retirarTicket();
    }

    @Test
    public void ticketMachineSaldoTest() throws PapelMoedaInvalidaException, SaldoInsuficienteException {
        TicketMachine tm = new TicketMachine(10);
        assertEquals("O saldo inicial do cliente deve ser zero", 0, tm.getSaldo());
        tm.inserir(10);
        assertEquals("O saldo do cliente deve ser dez", 10, tm.getSaldo());
        tm.retirarTicket();
        assertEquals("O saldo do cliente deve ser zero", 0, tm.getSaldo());
    }

    @Test
    public void ticketMachineValorTest() {
        TicketMachine tm = new TicketMachine(10);
        assertEquals("O valor do ticket machine dever ser 10", 10, tm.getValor());
        tm.setValor(20);
        assertEquals("O valor do ticket machine dever ser 20", 20, tm.getValor());
    }

    @Test
    public void ticketMachineObterTroco() throws SaldoInsuficienteException, PapelMoedaInvalidaException {
       
        TicketMachine tm = new TicketMachine(10);
        tm.inserir(100);
        tm.retirarTicket();
        tm.getTroco();
        assertEquals("Cliente deve ter 0 de saldo após retirar o troco", 0, tm.getSaldo());

    }

}
