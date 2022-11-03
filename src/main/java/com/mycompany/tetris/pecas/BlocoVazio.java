/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tetris.pecas;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author António
 */
public class BlocoVazio extends Bloco{
    
    @Override
    /**
     * cria um bloco vazio que irá ser usado para as peças e para o tabuleiro
     */
    public void draw(Graphics gr, int x, int y, int dx, int dy) {
        gr.setColor(Color.WHITE);
        gr.drawRect(x, y, dx, dy);
    }
}
