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
public class PecaO extends Peca {
    
    /**
     * Constrói o array da peça O
     */
    static Bloco[][] O = {
        {new Bloco(Color.BLUE), new Bloco(Color.BLUE)},
        {new Bloco(Color.BLUE), new Bloco(Color.BLUE)}
    };

    /**
     * Herda todos os métodos da classe Peca e implementa na peça O
     */
    public PecaO() {
        //herda tudo da classe Peca e implementa na peça O
        super(O);
    }

}