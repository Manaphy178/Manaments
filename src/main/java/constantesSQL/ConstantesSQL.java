package constantesSQL;

public class ConstantesSQL {
	public final static String SQL_OBTENER_INSTRUMENTOS = "Select * From tabla_instrumentos";
	public final static String SQL_REGISTRAR_INSTRUMENTO = "INSERT INTO `tabla_instrumentos` (`nombre`, `tipo`, `marca`, `gamma`, `description`, `precio`) VALUES ( ?, ?, ?, ?, ?, ?);";
	public final static String SQL_BORRAR_INSTRUMENTOS = "DELETE FROM `tabla_instrumentos` WHERE `tabla_instrumentos`.`id` = ?;";
	public static final String SQL_OBTENER_INSTRUMENTO_POR_ID = "SELECT * FROM tabla_instrumentos WHERE `tabla_instrumentos`.`id` = ?;";
	public static final String SQL_ACTUALIZAR_INSTRUMENTO = "UPDATE `tabla_instrumentos` SET `nombre` = ?, `tipo` = ?, `marca` = ?, `gamma` = ?, `description` = ?, `precio` = ? WHERE `tabla_instrumentos`.`id` = ?";
}
