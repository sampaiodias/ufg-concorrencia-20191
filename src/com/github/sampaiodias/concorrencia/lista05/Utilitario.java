/*
 * Copyright (c) 2019.
 * Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */

package com.github.sampaiodias.concorrencia.lista05;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
 
public class Utilitario {
    
    /**
     * Hashes das senhas que serão quebradas no exercício
     */
    public static final String[] SENHAS = new String[] {
        "17a0a00212dde12b063af7dc22fdf02b",
        "75abfe3020804dd73a2a6040da9df96c",
        "c77aeec24015ad7e6e0b1db9d9deed68"
    };
    
    /**
     * Caracteres possíveis para uso na hash
     */
    private static final String AB = 
            "0123456789abcdefghijklmnopqrstuvwxyz";
    
    /**
     * Classe de randomização do Utilitário
     */
    private static SecureRandom rnd = new SecureRandom();
 
    /**
     * Gera uma hash usando o método criptográfico MD5
     * @param senha Senha que será criptografada
     * @return Hash gerada a partir da senha informada
     */
    public static String md5(String senha){
       String sen = "";
       MessageDigest md = null;
       try {
          md = MessageDigest.getInstance("MD5");
       } catch (NoSuchAlgorithmException e) {
          e.printStackTrace();
       }
       BigInteger hash = new BigInteger(1, md.digest(senha.getBytes()));
       sen = hash.toString(16);
       return sen;
    }
    
    /**
     * Gera uma String aleatória com os caracteres de a-z e 0-9.
     * Fonte: https://stackoverflow.com/a/157202
     * @param tamanho Tamanho da String
     * @return 
     */
    public static String stringAleatoria(int tamanho) {
        StringBuilder sb = new StringBuilder( tamanho );
        for( int i = 0; i < tamanho; i++ ) 
           sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
        return sb.toString();
    }
    
    public static String quebrarSenhaMD5(String hash) {
        String tentativa = "";
        String senha = "";
        while(tentativa.equals(hash) == false) {
            senha = stringAleatoria(5);
            tentativa = md5(senha);
        }
        return senha;
    }
}