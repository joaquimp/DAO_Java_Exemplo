package br.mack.ps2.entidades;

public class Aluno {
    private long tia;
    private String nome;
    private String curso;

    public Aluno() {}

    public Aluno(long tia, String nome, String curso) {
        this.tia = tia;
        this.nome = nome;
        this.curso = curso;
    }

    public long getTia() {
        return tia;
    }

    public void setTia(long tia) {
        this.tia = tia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    @Override
    public String toString() {
        return nome +
                " [tia:" + tia +
                ", curso: " + curso + "]";
    }
}
