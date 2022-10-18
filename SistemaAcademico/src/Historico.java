import java.util.HashSet;
import java.util.Set;

public class Historico {
	private Set<Matricula> disciplinas;

	public Historico() {
		this.disciplinas = new HashSet<Matricula>();
	}

	public boolean addMateria(Matricula aprovada) throws Exception {
		if (aprovada.getSituacao() == Situacao.APROVADO) {
			return this.disciplinas.add(aprovada);
		}
		throw new Exception("Adicionou disciplina não aprovada");
	}

	public boolean cursado(Matricula materia) {
		return this.disciplinas.contains(materia);
	}

}
