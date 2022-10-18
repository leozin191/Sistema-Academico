
public class Graduacao implements IAcademico {

	@Override
	public boolean aprovado(Matricula materia) {
		return materia.notaFinal() >= 60;

	}

	@Override
	public int creditos(Matricula materia) {
		if (aprovado(materia)) {
			return materia.getCargaHoraria() / 60;
		}
		return 0;
	}

}
