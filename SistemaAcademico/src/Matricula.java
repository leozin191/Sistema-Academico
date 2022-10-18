import java.util.ArrayList;
import java.util.List;

public class Matricula {
	protected Disciplina disciplina;
	protected Situacao situacao;
	protected List<Atividade> atividades;

	public Matricula(Disciplina d) {
		this.disciplina = d;
		this.situacao = Situacao.CURSANDO;
		this.atividades = new ArrayList<Atividade>();

	}

	public String getNome() {
		return this.disciplina.getNome();
	}

	public int notaFinal() {
		int soma = 0;
		for (Atividade atividade : atividades) {
			soma += atividade.getNota();
		}
		return soma;

	}

	public void lancarNota(int avaliacao, int nota) throws Exception {
		if (avaliacao >= 0 && avaliacao < atividades.size()) {
			Atividade a = atividades.get(avaliacao);
			if (nota > 0 && nota <= a.getValor()) {
				a.lancarNota(nota);
			} else {
				throw new Exception("Lançou nota negativa ou maior que máximo");
			}
		} else {
			throw new Exception("Lançou nota de avaliação inválida");
		}

	}

	public void addAtividade(Atividade nova) {
		int notaTotal = notaFinal();
		if (notaTotal < 100) {
			if (nova.getValor() + notaTotal <= 100) {
				atividades.add(nova);
			} else {
				// TODO: lançar erro(nota total > 100)
			}

		}

	}

	public void fecharSemestre(IAcademico grad) {
		if (situacao == Situacao.CURSANDO) {
			if (grad.aprovado(this)) {
				situacao = Situacao.APROVADO;
			} else {
				situacao = Situacao.REPROVADO;
			}
		} else if (situacao == Situacao.PENDENTE) {
			situacao = Situacao.REPROVADO;
		}
	}

	public int getCargaHoraria() {
		return this.disciplina.getCargaHoraria();
	}

	public Situacao getSituacao() {
		return situacao;

	}

	@Override
	public String toString() {
		return this.disciplina.toString() + " Nota =  " + this.notaFinal() + " \n";
	}
}
