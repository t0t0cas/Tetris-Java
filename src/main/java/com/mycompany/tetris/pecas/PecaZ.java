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
public class PecaZ extends Peca {
    
    /**
     * Constrói o array da peça Z
     */
    static Bloco[][] Z = {
        {new Bloco(Color.GREEN), new Bloco(Color.GREEN), new BlocoVazio()},
        {new BlocoVazio(), new Bloco(Color.GREEN), new Bloco(Color.GREEN)}
    };
    
    /**
     * Herda todos os métodos da classe Peca e implementa na peça Z 
     */
    public PecaZ() {
        //herda tudo da classe Peca e implementa na peça Z
        super(Z);
    }

}
