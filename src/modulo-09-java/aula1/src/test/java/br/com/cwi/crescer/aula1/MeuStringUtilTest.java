package br.com.cwi.crescer.aula1;

import org.junit.Test;
import static org.junit.Assert.*;

public class MeuStringUtilTest {
    
    public MeuStringUtilTest() {
    }

    @Test
    public void verificarStringVaziaEVoltarTrue() {
        MeuStringUtil util = new MeuStringUtil();
        boolean resposta = util.stringVazia("");
        assertTrue(resposta);
    }
    
    @Test
    public void verificarStringVaziaEVoltarFalse() {
        MeuStringUtil util = new MeuStringUtil();
        boolean resposta = util.stringVazia("teste");
        assertFalse(resposta);
    }
    
    @Test
    public void contarVogais5() {
        MeuStringUtil util = new MeuStringUtil();
        int resposta = util.contarVogais("aeiou");
        assertEquals(5, resposta);
    }
    
    @Test
    public void contarVogaisZero() {
        MeuStringUtil util = new MeuStringUtil();
        int resposta = util.contarVogais("bcdrt");
        assertEquals(0, resposta);
    }
    
    @Test
    public void inverterString(){
         MeuStringUtil util = new MeuStringUtil();
        String resposta = util.inverterString("teste");
        assertEquals("etset", resposta);
    }
    
    @Test
    public void verificarPalavraPalindromeOvoERetornarTrue(){
         MeuStringUtil util = new MeuStringUtil();
        boolean resposta = util.ehPalindromo("ovo");
        assertTrue(resposta);
    }
    
    @Test
    public void verificarPalavraPalindromeTesteRetornarFalse(){
         MeuStringUtil util = new MeuStringUtil();
        boolean resposta = util.ehPalindromo("teste");
        assertFalse(resposta);
    }
    
    @Test
    public void verificarFrasePalindromeOvoERetornarTrue(){
         MeuStringUtil util = new MeuStringUtil();
        boolean resposta = util.ehPalindromo("socorram-me subi no ônibus em marrocos");
        assertTrue(resposta);
    }
}
