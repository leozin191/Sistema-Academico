import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Aluno {

	protected int matricula;
	public String nome;
	protected IAcademico nivel;
	protected List<Matricula> disciplina;
	protected Historico historico;

	public Aluno(IAcademico nivel, String nome) {
		Random rn = new Random();
		this.matricula = rn.nextInt();
		this.nome = nome;
		this.nivel = nivel;
		this.disciplina = new ArrayList<Matricula>();
		this.historico = new Historico();
	}

	public boolean aprovado(String nomeDisciplina) {
		for (Matricula matricula : disciplina) {
			if (matricula.getNome().equals(nomeDisciplina)) {
				if (matricula.getSituacao() == Situacao.APROVADO) {
					try {
						return historico.addMateria(matricula);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {
				}
			}
		}
		return false;
	}

	public String imprimirHistorico() {
		System.out.println(this.nome);
		int cargaHoraria = 0;
		for (Matricula matricula : disciplina) {
			System.out.println(matricula);
			if (matricula.getSituacao() == Situacao.APROVADO) {
				cargaHoraria += matricula.getCargaHoraria();
			}
		}
		int creditos = 0;
		int creditosFormatura = 0;
		int horasPorCredito = 0;
		if (nivel.getClass() == Graduacao.class) {
			creditosFormatura = 50;
			horasPorCredito = 60;
		} else if (nivel.getClass() == PosGraduacao.class) {
			creditosFormatura = 20;
			horasPorCredito = 120;
		}
		creditos = cargaHoraria / horasPorCredito;
		if (creditos < creditosFormatura) {
			System.out.println("Créditos restantes para formatura : " + (creditosFormatura - creditos));
		} else {
			System.out.println("Créditos restantes para formatura : 0 ");
		}
		return "";
	}

	public boolean formado() {
		return false;
	}

	public Matricula matricular(Disciplina d) {
		Matricula m = new Matricula(d);
		this.disciplina.add(m);
		return m;
	}

}
