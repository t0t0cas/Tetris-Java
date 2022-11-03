/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tetris.pecas;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;

/**
 *
 * @author António
 */
public class Bloco extends JComponent{
    
    Color myColor;//cria a variável que irá ser a cor do bloco
    
    /**
     * Construtor que inicializa o bloco a verde
     */
    public Bloco(){
        this(Color.GREEN);
    }
    
    /**
     * Construtor que passa a cor do bloco
     * @param c variável que vai receber a cor do bloco
     */
    public Bloco(Color c){
      this.myColor = c;
    }
    
    /**
     * desenha o bloco de cada peça e o contorno do bloco
     * @param gr Contexto Gráfico
     * @param x Coordenada X
     * @param y Coordenada Y
     * @param dx Largura dos Blocos
     * @param dy Alturas dos Blocos
     */
    public void draw(Graphics gr, int x, int y, int dx, int dy) {
        gr.setColor(myColor);
        gr.fillRect(x, y, dx, dy);
        gr.setColor(Color.BLACK);
        gr.drawRect(x, y, dx, dy);
    }
    
    
    @Override
    /**
     * desenha os componentes do bloco
     * @param gr Contexto Gráfico
     */
    public void paintComponent(Graphics gr){
        int w = this.getWidth();
        int h = this.getHeight();
       draw(gr, 1 , 1, w-2, h-2);
    }
}