package br.calebe.ticketmachine.core;

import java.util.Iterator;

/**
 *
 * @author Calebe de Paula Bianchini
 */
class Troco {
    
    protected PapelMoeda[] papeisMoeda;

    public Troco(int valor) {
        
        
        int[] moedas = {2, 5, 10, 20, 50, 100};
        papeisMoeda = new PapelMoeda[moedas.length];
        
        for(int i = moedas.length - 1; i != -1;) {
            int count = valor / moedas[i];
            valor %= moedas[i];
            papeisMoeda[i--] = new PapelMoeda(moedas[i], count);

        }
        
    }

    public Iterator<PapelMoeda> getIterator() {
        return new TrocoIterator(this);
    }

    class TrocoIterator implements Iterator<PapelMoeda> {

        private int trocoIteratorCount;
        protected Troco troco;

        public TrocoIterator(Troco troco) {
            this.troco = troco;
        }

        @Override
        public boolean hasNext() {
           return trocoIteratorCount > 0;
        }

        @Override
        public PapelMoeda next() {
            return (hasNext()) ? troco.papeisMoeda[--trocoIteratorCount] : null;
         }

        @Override
        public void remove() {
            next();
        }
    }
}
