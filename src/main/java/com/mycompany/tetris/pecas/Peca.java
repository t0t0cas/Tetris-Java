/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tetris.pecas;

import java.awt.Graphics;
import javax.swing.JComponent;

/**
 *
 * @author António
 */
public class Peca extends JComponent {

    int posX = 6; //coordenada do x
    int posY = 0; //coordenada do y

    Bloco[][] matrix; //conjunto de blocos

    /**
     * Construtor para a matriz da peça
     * @param matrix conjunto de blocos 
     */
    public Peca(Bloco[][] matrix) {
        this.matrix = matrix;
    }
    
    /**
     * Usa-se dois ciclos for's para percorrer a matriz da peça e verifica se na linha de baixo existe um BlocoVazio, caso não exista
     * A peça passará a fazer parte da matriz do Tabuleiro
     * @param jogo tabuleiro do Tetris  
     */
    public void CongelaPeca(Bloco[][] jogo) {
        for (int y = 0; y < matrix.length; y++) {
            for (int x = 0; x < matrix[y].length; x++) {
                if (!(matrix[y][x] instanceof BlocoVazio)){
                    jogo[posY + y][posX + x] = matrix[y][x];
                }
            }
        }
    }

    /**
     * verifica se uma peça pode cair
     *
     * @param jogo matriz do jogo
     * @return true se puder
     */
    public boolean verificaMove(Bloco[][] jogo) {
        //chegou ao final da matriz
        if (posY + matrix.length >= jogo.length) {
            return false;
        }
        //Percorre a matriz para verificar se existem posições livres para cair
        for (int y = 0; y < matrix.length; y++) {
            for (int x = 0; x < matrix[y].length; x++) {
                //verifica se o bloco de baixo não é um bloco vazio e se o bloco não é vazio
                if (!(jogo[posY + y + 1][posX + x] instanceof BlocoVazio) && !(matrix[y][x] instanceof BlocoVazio)) {
                    return false;
                }
            }
        }
        return true;
    }
    
    /**
     * Verifica se a peça chegou ao limite da matriz e percorre-a para verificar se existem posições livres na direita
     * @param jogo matriz do jogo
     * @return
     */
    public boolean verificaDireita(Bloco[][] jogo) {
        //chegou ao limite direito da matriz
        if (posX + matrix[0].length >= jogo[0].length) {
            return false;
        }
        //Percorre a matriz da peça para verificar se existem posições livres na direita para a se mover
        for (int y = 0; y < matrix.length; y++) {
            for (int x = 0; x < matrix[y].length; x++) {
                //celula de baixo está ocupada
                if (!(jogo[posY + y][posX + x + 1] instanceof BlocoVazio)) {
                    return false;
                }
            }
        }
        return true;
    }
    
    /**
     * Verifica se a posição da peça é menor que zero e percorre a matriz da peça para verificar se existem posições livres na esquerda
     * @param jogo matriz do jogo
     * @return 
     */
    public boolean verificaEsquerda(Bloco[][] jogo) {
        //Verifica se a posição da peça é menor que 0
        if (posX <= 0) {
            return false;
        }
        //Verifica se existem posições livres na esquerda para a se mover
        for (int y = 0; y < matrix.length; y++) {
            for (int x = 0; x < matrix[y].length; x++) {
                //os blocos a baixo estão ocupados
                if (!(jogo[posY + y][posX + x - 1] instanceof BlocoVazio)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Move a peça para baixo
     */
    public void paraBaixo() {
        //Incrementa a posição vertical
        posY++;
    }

    /**
     * Move a peça para a direita
     */
    public void paraDireita() {
        //Incrementa a posição horizontal
        posX++;
    }

    /**
     * Move apeça para a esquerda
     */
    public void paraEsquerda() {
        //Diminui a posição horizontal
        posX--;
    }
    
    /**
     * Método que faz com que a peça rode para a esquerda
     */
    public void rodaEsquerda(){
        transposta();
        mirrorHorizontal();
    }
    
    /**
     * Método que faz com que a peça rode para a direita
     */
    public void rodaDireita(){
        transposta();
        mirrorVertical();
    }
    
    /**
     * Método que cria uma matriz transposta da matriz original
     */
    private void transposta(){
        //Cria-se uma nova matriz tmp sendo transposta da matriz original, onde as linhas da matriz original passam a colunas 
        //E as colunas da matriz original passam a linhas
        Bloco[][] tmp = new Bloco[matrix[0].length][matrix.length];
        for(int y=0; y<matrix.length; y++){
            for(int x=0; x<matrix[y].length; x++){
                //percorre-se a matriz original trocando as linhas e as colunas da original para a transposta
                tmp[x][y] = matrix[y][x];
            }
        }
        //A matriz vai ser a matriz transposta
        matrix = tmp;
        repaint();
    }
    
    /**
     * Método que verifica se a peça pode rodar
     * @param jogo matriz do jogo
     * @return falso se a rotação da peça passa o limite da direita
     */
    public boolean verificaRotacao(Bloco[][] jogo){
        //Se a posição da peça juntamente com a posição da sua rotação ultrapassar o limite direito este não roda
        if(posX + matrix.length > jogo[0].length - 1){
            return false;
        }else{
            return true;
        }
    }
    
    /**
     * Método que roda a matriz da peça horizontalmente
     */
    private void mirrorHorizontal() {
        //É criada uma nova matriz onde se vai fazer a rotação horizontal 
        Bloco[][] tmp = new Bloco[matrix.length][matrix[0].length];
        for(int y=0; y<matrix.length; y++)
           for(int x=0; x<matrix[0].length; x++)
               //Nesta matriz tmp vai fazer com que horizontalmente só rode as linhas
               tmp[y][x] = matrix[matrix.length-y-1][x];
        matrix = tmp;   
    }
    
    /**
     * Método que roda a matriz da peça vertical
     */
    private void mirrorVertical() {
        //É criada uma nova matriz onde se vai fazer a rotação vertical
        Bloco[][] tmp = new Bloco[matrix.length][matrix[0].length];
        for(int y=0; y<matrix.length; y++)
           for(int x=0; x<matrix[0].length; x++)
               //Nesta matriz tmp vai fazer com que verticalmente só rode as colunas
               tmp[y][x] = matrix[y][matrix[0].length-x-1];
        matrix = tmp;
        
    }

    /**
     * Desenhar a peça nas coordenadas do contexto gráfico
     *
     * @param gr Contexto Gráfico
     * @param px Coordenada X do canto superior esquerdo
     * @param py Coordenada Y do canto superior esquerdo
     * @param dx Largura dos blocos
     * @param dy Altura dos blocos
     */
    public void draw(Graphics gr, int px, int py, int dx, int dy) {
        for (int y = 0; y < matrix.length; y++) {
            for (int x = 0; x < matrix[y].length; x++) {
                matrix[y][x].draw(gr, px + x * dx, py + y * dy, dx, dy);
            }
        }
    }
}
