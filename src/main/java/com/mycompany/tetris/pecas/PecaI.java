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
public class PecaI extends Peca {
   
    /**
     * Constrói o array da peça I
     */
    static Bloco[][] I = {
        {new Bloco(Color.CYAN)},
        {new Bloco(Color.CYAN)},
        {new Bloco(Color.CYAN)},
        {new Bloco(Color.CYAN)}
    };
    
    /**
     * Herda todos os métodos da classe Peca e implementa na peça I 
     */
    public PecaI(){ 
        super(I);
    }
}
