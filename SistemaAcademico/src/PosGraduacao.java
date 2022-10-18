
public class PosGraduacao implements IAcademico {

	@Override
	public boolean aprovado(Matricula materia) {
		return materia.notaFinal() >= 70;
	}

	@Override
	public int creditos(Matricula materia) {
		if (aprovado(materia)) {
			return materia.getCargaHoraria() / 120;
		}
		return 0;

	}

}
