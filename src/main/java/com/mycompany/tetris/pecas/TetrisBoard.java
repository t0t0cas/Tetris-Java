/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tetris.pecas;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author António
 */
public class TetrisBoard extends JPanel implements ActionListener, MouseListener, KeyListener{
    
    Bloco[][] jogo;//conjunto de blocos
    Peca pecai;//peça que se move
    Timer timer;
    public int pontos = 0;//inicialização dos pontuação
    JLabel lblPontos;//inicialização da label da Pontuação
   
    /**
     * Método que inicia o jogo
     */
    public TetrisBoard() {
        IniciarJogo();
        //inicializar o timer
        timer = new Timer(200, this);
        timer.start();
        //coloca o componente a escutar o rato
        addMouseListener(this);
        //coloca o componente a escutar o teclado
        addKeyListener(this);
    }
    
    /**
     * Construtor para o labelPontos 
     */
    public void setlblPontos(JLabel lblPontos){
        this.lblPontos = lblPontos;
    }
    
    /**
     * Método para parar o tempo
     */
    public void stopTimer(){
        timer.stop();
    }
    
    /**
     * Método para voltar a contar o tempo
     */
    public void restartTimer(){
        timer.restart();
    }
    
    /**
     * Construtor para o timer
     */
    public Timer getTimer() {
        return timer;
    }
    
    /**
     * Cria o tabuleiro com BlocoVazio() e executa o método criaPecas() 
     */
    public void IniciarJogo() {
        //alocar a matriz no jogo
        jogo = new Bloco[24][13];
        //criar os blocos vazios
        for (int y = 0; y < jogo.length; y++) {
            for (int x = 0; x < jogo[y].length; x++) {
                jogo[y][x] = new BlocoVazio();
            }
        }
        //chama o método cria peças
        criaPecas();
    }
    
    /**
     * Gera aleatóriamente um número entre 0 e 6, e consoante esse número aparece no tabuleiro
     * A peça correspondente a esse número
     */
    private void criaPecas(){
        Random r = new Random();
        switch(r.nextInt(7)) {
            case 0: pecai = new PecaL(); break;
            case 1: pecai = new PecaO(); break;
            case 2: pecai = new PecaS(); break;
            case 3: pecai = new PecaT(); break;
            case 4: pecai = new PecaZ(); break;
            case 5: pecai = new PecaI(); break;
            case 6: pecai = new PecaJ(); break;
        }
    }
    
    /**
     * Desenha o tabuleiro no contexto gráfico com os valores da matriz definida no IniciarJogo()
     * @param gr Contexto Gráfico
     */
    @Override
    public void paintComponent(Graphics gr) {
        gr.setColor(Color.LIGHT_GRAY);
        gr.fillRect(0, 0, getWidth(), getHeight());

        int dx = getWidth() / jogo[0].length;//colunas
        int dy = getHeight() / jogo.length;//linhas
        //desenhar o tabuleiro
        for (int y = 0; y < jogo.length; y++) {
            for (int x = 0; x < jogo[y].length; x++) {
                //desenha o tabuleiro
                jogo[y][x].draw(gr, x * dx, y * dy, dx, dy);
            }
        }
        //desenha a peça 
        pecai.draw(gr, dx * pecai.posX, dy * pecai.posY, dx, dy);
    }
    
    /**
     * Verifica se a peça pode cair e se poder esta cai. 
     * Quando esta chega ao limite do tabuleiro a peça "congela" sendo incrementado a pontução e mostrado no ecrã 
     * E chama o criaPecas() para criar novas peças sucessivamente
     * Depois chama o verificaLinhas() para ver se existe alguma linha já totalmente preenchida 
     *  
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (pecai.verificaMove(jogo)) {
            pecai.paraBaixo();//peça desce
        } else {
            pecai.CongelaPeca(jogo);
            pontos = pontos+20;
            lblPontos.setText("Pontuação " + pontos);
            criaPecas();
        }
        repaint();
        verificaLinhas();
        perderJogo();
        //requer o foco da aplicação
        this.requestFocus();
    }
    
    /**
     * Métodos que permitem usar o rato na interface gráfica 
     * 
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        //verificar qual o botão do rato a ser executado
        if (e.getButton() == MouseEvent.BUTTON1) {
            //faz a verificação se a peça tanto pode se mover para a esquerda como para rodar para a esquerda
            if (pecai.verificaEsquerda(jogo) && pecai.verificaRotacao(jogo)) {
                //move a peça para a esquerda
                pecai.paraEsquerda();
                //roda a peça para a esquerda
                pecai.rodaEsquerda();
            }
            //verificar qual o botão do rato a ser executado
        } else if (e.getButton() == MouseEvent.BUTTON3) {
           //faz a verificação se a peça tanto pode se mover para a direita como para rodar para a direita
            if (pecai.verificaDireita(jogo) && pecai.verificaRotacao(jogo)) {
                //move a peça para a direita
                pecai.paraDireita();
                //roda a peça para a direita
                pecai.rodaDireita();
            }
        }
        repaint();
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
       
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //quando o rato voltar ao componente
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //quando o rato sair do componente
    }
    
    /**
     * Métodos que permitem usar o teclado na interface gráfica 
     * 
     */
    @Override
    public void keyTyped(KeyEvent e) {
        
    }
    @Override
    public void keyPressed(KeyEvent e) {
        //verifica se a tecla pressionada foi a seta para a direita
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            //verifica se a peça pode-se mover para a direita
            if(pecai.verificaDireita(jogo)){
                //move a peça para a direita
                pecai.paraDireita();
            }
        }
        
        //verifica se a tecla pressionada foi a seta para a esquerda
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            //verifica se a peça pode-se mover para a esquerda
            if(pecai.verificaEsquerda(jogo)){
                //move a peça para a esquerda
                pecai.paraEsquerda();
            }
        }
        
        //verifica se a tecla pressionada foi a seta para a baixo
        if(e.getKeyCode() == KeyEvent.VK_DOWN){
            //verifica se a peça pode descer
            if(pecai.verificaMove(jogo)){
                //move a peça para baixo
                pecai.paraBaixo();
            }
        }
        
        //verifica se a tecla pressionada foi a tecla Q
        if(e.getKeyCode() == KeyEvent.VK_Q){
            //verifica se a peça pode rodar
            if(pecai.verificaRotacao(jogo)){
                //roda a peça para a esquerda
                pecai.rodaEsquerda();
            }
        }
        
        //verifica se a tecla pressionada foi a tecla E
        if(e.getKeyCode() == KeyEvent.VK_E){
            //verifica se a peça pode rodar
            if(pecai.verificaRotacao(jogo)){
                //roda a peça para a direita
                pecai.rodaDireita();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
    
    /**
     * Método que faz a verificação linha a linha do tabuleiro se existem linhas totalmente preenchidas com peças
     *  
     */
    public void verificaLinhas(){
        //dois ciclos for's que iram percorrer o tabuleiro todo, sendo o y para as linhas e o x para as colunas
        for (int y = 0; y < jogo.length; y++) {
            Bloco[] blocos = jogo[y];
            //inicialização da variável booliana eliminar como true 
            boolean eliminar = true;
            for (int x = 0; x < jogo[y].length; x++) {
                Bloco bloco = blocos[x];
                //verifica se na determinada posição (y,x) está a fila preenchida com peças sem que haja um bloco vazio
                if(jogo[y][x] instanceof BlocoVazio){
                    //caso esteja um BlocoVazio então o eliminar passa a falso e é usado o break para sair da verificação das linhas
                    eliminar = false;
                    break;
                }
            }
            //sendo o elimina true então vai chamar o método eliminaLinhas();
            if(eliminar){
                eliminaLinhas(y);
            }
        }
    }
    
    /**
     * O y é inicializado com o valor das linhas do tabuleiro e este a cada iteração vai decrementando
     * De modo a que verifique linha a linha enquanto que o x vai percorrer cada coluna começando da esquerda
     * Para a direita, poois será incrementado.
     * Com isso o tabuleiro atualiza e a linha totalmente preenchida desaparece fazendo com que a linha de cima desca ocupando a posição da linha destruida
     * Após isso é incrementado a pontuação e fazemos o repaint para voltar a pintar as peças que estavam na linha de cima para a nova linha de baixo
     * @param linhas são as linhas do tabuleiro  
     */
    public void eliminaLinhas(int linhas){
        for (int y = linhas; y > 0 ; y--) {
            for (int x = 0; x < jogo[y].length; x++) {
                //tabuleiro atualiza e recebe a linha de cima
                jogo[y][x] = jogo[y-1][x]; 
            }
        }
        pontos = pontos + 90;
        lblPontos.setText("Pontuação " + pontos);
        repaint();
    }
    /**
     * Método que verifica se o jogador perdeu
     */
    public void perderJogo(){
        int end = 0;//end é para verificar que o jogador perdeu e força a saida do loop de estar a verificar todas as linhas
        for (int y = 0; y < jogo.length; y++) {
            if (end == 0) {
                Bloco[] blocos = jogo[y];
                for (int x = 0; x < blocos.length; x++) {
                    Bloco bloco = blocos[x];
                    if (!(jogo[0][x] instanceof BlocoVazio)) {
                        timer.stop();
                        JOptionPane.showMessageDialog(this, "GameOver");
                        end = 1;
                        System.exit(0);
                        break;
                    }
                }
            }
        }
    }
}   
