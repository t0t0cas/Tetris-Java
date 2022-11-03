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
public class PecaJ extends Peca {
    
    /**
     * Constrói o array da peça J
     */    
    static Bloco[][] J = {
        {new BlocoVazio(), new Bloco(Color.YELLOW)},
        {new BlocoVazio(), new Bloco(Color.YELLOW)},
        {new Bloco(Color.YELLOW), new Bloco(Color.YELLOW)},
    };

    /**
     * Herda todos os métodos da classe Peca e implementa na peça J 
     */    
    public PecaJ() {
        super(J);
    }

}
