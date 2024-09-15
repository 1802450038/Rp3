package Model;

import java.util.Objects;
import java.util.Random;
import java.security.SecureRandom;

//01/12/20 -B

public class Sessao {
    public static final String maiusculas = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static final String minusculas = maiusculas.toLowerCase();

    public static final String digitos = "0123456789";

    public static final String alfanumerico = maiusculas + minusculas + digitos;

    private final Random random;

    private final char[] caracteres;

    private final char[] buf;

    private String chaveSessao;
    public  static boolean isAtiva = false;
    public String nextString() {
        for (int idx = 0; idx < buf.length; ++idx)
            buf[idx] = caracteres[random.nextInt(caracteres.length)];
        this.chaveSessao = new String(buf);
        return chaveSessao;
    }

    public Sessao(int tamanho, Random random, String caracteres) {
        if (tamanho < 1)
            throw new IllegalArgumentException();
        if (caracteres.length() < 2)
            throw new IllegalArgumentException();
        this.random = Objects.requireNonNull(random);
        this.caracteres = caracteres.toCharArray();
        this.buf = new char[tamanho];
        this.nextString();
    }

    public Sessao(int tamanho, Random random) {
        this(tamanho, random, alfanumerico);
    }

    public Sessao(int tamanho) {
        this(tamanho, new SecureRandom());
    }

    public Sessao() {
        this(21);
    }

    public static void finalizaSessao(Sessao s) {
        s.chaveSessao = "";
        s = null;
    }

    public static boolean sessaoAtiva(Sessao s) {
        if (s != null && s.chaveSessao.length() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void classificaSessao(Sessao s) {
        if (sessaoAtiva(s) == false) {
            System.out.println("Sessao encerrada ou invalida");
        } else {
            System.out.println("Sessao ativa");
        }
    }

   

}
