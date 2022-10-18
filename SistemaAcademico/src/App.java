public class App {
	public static void main(String[] args) throws Exception {
		Graduacao grad = new Graduacao();
		PosGraduacao pos = new PosGraduacao();
		Aluno joao = new Aluno(grad, "Joao");
		Aluno maria = new Aluno(pos, "Maria");

		Disciplina pontes = new Disciplina("Pontes", 180);
		Matricula pj = joao.matricular(pontes);
		Matricula mj = maria.matricular(pontes);
		for (int i = 0; i < 4; i++) {
			pj.addAtividade(new Atividade(25));
			mj.addAtividade(new Atividade(25));
		}
		for (int i = 0; i < 4; i++) {
			pj.lancarNota(i, 17);
			mj.lancarNota(i, 23);
		}
		pj.fecharSemestre(grad);
		mj.fecharSemestre(pos);
		joao.aprovado("Pontes");
		maria.aprovado("Pontes");
		joao.imprimirHistorico();
		maria.imprimirHistorico();

	}
}
