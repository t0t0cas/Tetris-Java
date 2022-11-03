/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tetris.pecas;

import java.awt.Color;

/**
 *
 * @author António
 */
public class PecaS extends Peca {
    
    /**
     * Constrói o array da peça S
     */
    static Bloco[][] S = {
        {new BlocoVazio(), new Bloco(Color.RED), new Bloco(Color.RED)},
        {new Bloco(Color.RED), new Bloco(Color.RED), new BlocoVazio()}
    };
    
    /**
     * Herda todos os métodos da classe Peca e implementa na peça S 
     */    
    public PecaS() {
        //herda tudo da classe Peca e implementa na peça S
        super(S);
    }

}
