/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author Dmitruk
 */
public class LimitaCaracteres extends PlainDocument {

    public enum TipoEntrada {
        TELEFONE;
    };
    private int qtdCaracteres;
    private TipoEntrada tpEntrada;

    public LimitaCaracteres(int qtdCaracteres, TipoEntrada tpEntrada) {
        this.qtdCaracteres = qtdCaracteres;
        this.tpEntrada = tpEntrada;
    }

    @Override
    public void insertString(int i, String string, AttributeSet as) throws BadLocationException {
        if (string == null || getLength() == qtdCaracteres) {
            return;
        }
        int totalCarac = getLength() + string.length();
        // filtro de caracteres
        String regex = "";
        switch (tpEntrada) {
            case TELEFONE:
                regex = "/[^-().0-9]/";
                break;
        }
        // fazendo a substituição
        string = string.replaceAll(regex,"" );
        if (totalCarac != qtdCaracteres) {
            super.insertString(i, string, as); //To change body of generated methods, choose Tools | Templates.
        } else {
            String nova = string.substring(0, qtdCaracteres);
            super.insertString(i, nova, as);
        }
    }
}
