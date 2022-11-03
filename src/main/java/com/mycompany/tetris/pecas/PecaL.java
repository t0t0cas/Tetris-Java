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
public class PecaL extends Peca {
    
    /**
     * Constrói o array da peça L
     */
    static Bloco[][] L = {
        {new Bloco(Color.ORANGE), new BlocoVazio()},
        {new Bloco(Color.ORANGE), new BlocoVazio()},
        {new Bloco(Color.ORANGE), new Bloco(Color.ORANGE)}    
    };
    
    /**
     * Herda todos os métodos da classe Peca e implementa na peça L 
     */    
    public PecaL() {
        super(L);
    }
}
