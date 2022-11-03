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
public class PecaT extends Peca {
   
    /**
     * Constrói o array da peça T
     */
    static Bloco[][] T = {
        {new Bloco(Color.MAGENTA), new Bloco(Color.MAGENTA), new Bloco(Color.MAGENTA)},
        {new BlocoVazio(), new Bloco(Color.MAGENTA), new BlocoVazio()}
    };

    /**
     * Herda todos os métodos da classe Peca e implementa na peça T
     */
    public PecaT() {
        //herda tudo da classe Peca e implementa na peça T
        super(T);
    }

}
