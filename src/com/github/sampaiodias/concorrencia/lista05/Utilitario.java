/*
 * Copyright (c) 2019.
 * Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */

package com.github.sampaiodias.concorrencia.lista05;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
 
public class Utilitario {
 
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
}