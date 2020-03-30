package br.mack.ps2.persistencia;

import br.mack.ps2.entidades.Aluno;
import java.util.List;

public interface AlunoDAO {
    boolean create (Aluno aluno);
    List<Aluno> read ();
    boolean update(Aluno aluno);
    boolean delete(Aluno aluno);
}
