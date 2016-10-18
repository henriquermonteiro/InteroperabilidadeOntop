/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.utfpr.alvaras.control;

/**
 * Classe abstrata que representa uma cadeia de responsabilidades. Classes que
 * implementem esta classe devem implementar o método "change", realizando as
 * transformações necessárias. Note que uma cadeia de responsabilidade trabalha
 * sobre um elemento apenas. Ex.: @link org.utfpr.alvara.modelo.Alvara .
 *
 * @author henrique
 */
public abstract class ResponsibilityChain<T> {

    private ResponsibilityChain<T> chain;

    public ResponsibilityChain() {
        chain = null;
    }

    public abstract T change(T input);

    public final T process(T input) {
        T ret = change(input);
        
        if (chain != null) {
            return chain.process(ret);
        }
        
        return ret;
    }

    public void addLink(ResponsibilityChain<T> link) {
        if (chain == null) {
            chain = link;
        } else {
            ResponsibilityChain<T> next = chain;

            while (next.chain != null) {
                next = next.chain;
            }

            next.chain = link;
        }
    }

    public ResponsibilityChain<T> removeLink(ResponsibilityChain<T> link) {
        if (link == this) {
            return this.chain;
        } else {
            ResponsibilityChain<T> next = this;

            while (next.chain != link || next.chain != null) {
                next = next.chain;
            }

            if (next.chain != null) {
                next.chain = next.chain.chain;
            }

            return this;
        }
    }
}
