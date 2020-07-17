package com.yapo.dataprovider;

import org.testng.annotations.DataProvider;
import com.google.gson.Gson;
import com.yapo.entities.DatosCrearUser;
import com.yapo.entities.DatosBusqueda;
import com.yapo.entities.DatosPublicar;

public class DataProviderYapito {

	@DataProvider
	public static Object[][] registrar() {
		Gson gson = new Gson();
		DatosCrearUser datos = gson.fromJson(FileDataProvider.asString(String.format("src/test/resources/datosUser.json")),
				DatosCrearUser.class);

		return new Object[][] { { datos } };
	}

	@DataProvider
	public static Object[][] buscar() {
		Gson gson = new Gson();
		DatosBusqueda datos = gson.fromJson(FileDataProvider.asString(String.format("src/test/resources/datosBusqueda.json")),
				DatosBusqueda.class);

		return new Object[][] { { datos } };
	}
	@DataProvider
	public static Object[][] publicar() {
		Gson gson = new Gson();
		DatosPublicar datos = gson.fromJson(FileDataProvider.asString(String.format("src/test/resources/datosPublicar.json")),
				DatosPublicar.class);

		return new Object[][] { { datos } };
	}
	
}
