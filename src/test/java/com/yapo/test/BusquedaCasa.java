package com.yapo.test;


import org.testng.asserts.SoftAssert;
import org.testng.annotations.Test;
import com.yapo.config.BaseConfig;
import com.yapo.dataprovider.DataProviderYapito;
import com.yapo.page.Formulario;
import com.yapo.entities.DatosBusqueda;


public class BusquedaCasa extends BaseConfig {
	@Test(description="Search a house in Puente Alto", dataProvider = "buscar", dataProviderClass = DataProviderYapito.class)
	public void busquedaCasa(DatosBusqueda datos) throws InterruptedException {
		
		SoftAssert soft = new SoftAssert();	
		Formulario formulario = new Formulario(driver);
		
		formulario.selectMetropolitana();
		//Thread.sleep(10000);
		soft.assertTrue(formulario.clickRegion(datos.getRegion()),"se cayo :C");
		soft.assertTrue(formulario.clickComuna(datos.getComuna()));
		soft.assertTrue(formulario.clickSeleccionandoCategoria(datos.getCategoria()));
		soft.assertTrue(formulario.seleccionandotipoPropiedad(datos.getTipoInmueble()));
		soft.assertTrue(formulario.preMin(datos.getPreMin()));
		soft.assertTrue(formulario.preMax(datos.getPreMax()));
		soft.assertTrue(formulario.SelectdorMin(datos.getDorMin()));
		soft.assertTrue(formulario.SelectdorMax(datos.getDorMax()));
		soft.assertTrue(formulario.Selectm2Min(datos.getM2Min()));
		soft.assertTrue(formulario.Selectm2Max(datos.getM2Max()));
		soft.assertTrue(formulario.SelectbanoMin(datos.getBanoMin()));
		soft.assertTrue(formulario.SelectbanoMax(datos.getBanoMax()));
		soft.assertTrue(formulario.SelectGastoMin(datos.getGastoMin()));
		soft.assertTrue(formulario.SelectGastoMax(datos.getGastoMax()));
		soft.assertTrue(formulario.SelectParking(datos.getEstacionamiento()));
		formulario.pressSearch();
		soft.assertAll();

	}
}

