package com.yapo.test;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.yapo.config.BaseConfig;
import com.yapo.dataprovider.DataProviderYapito;
import com.yapo.entities.DatosPublicar;
import com.yapo.page.FormularioPublicar;

public class PublicarVenta extends BaseConfig {

	@Test(description="Post sale", dataProvider = "publicar", dataProviderClass = DataProviderYapito.class)
	public void publicarVenta(DatosPublicar datos) throws InterruptedException  {
			
		SoftAssert soft = new SoftAssert();	
		FormularioPublicar formulariopublicar  = new FormularioPublicar(driver);
		
		formulariopublicar.selectPublicar();
		soft.assertTrue(formulariopublicar.clickCategoria(datos.getCategoria()));
		soft.assertTrue(formulariopublicar.clickNuevoUsado(datos.getNuevoUsado()));
		soft.assertTrue(formulariopublicar.clickGenero(datos.getGenero()));
		soft.assertTrue(formulariopublicar.clickTalla(datos.getTalla()));
		soft.assertTrue(formulariopublicar.clicktitulo(datos.getTitulo()));
		soft.assertTrue(formulariopublicar.clickdescripcion(datos.getDescripcion()));
		soft.assertTrue(formulariopublicar.clickprecio(datos.getPrecio()));
		soft.assertTrue(formulariopublicar.clickimagen(datos.getImagen()));
		Thread.sleep(5000);
		soft.assertTrue(formulariopublicar.clickRegion(datos.getRegion()));
		soft.assertTrue(formulariopublicar.clickComuna(datos.getComuna()));
		soft.assertTrue(formulariopublicar.clickPersona());
		soft.assertTrue(formulariopublicar.IngNombre(datos.getNomComple()));
		soft.assertTrue(formulariopublicar.IngEmail(datos.getEmail()));
		soft.assertTrue(formulariopublicar.IngEmailConfir(datos.getEmail()));
		soft.assertTrue(formulariopublicar.clickMovil(datos.getPhone()));
		soft.assertTrue(formulariopublicar.IngPass(datos.getPass()));
		soft.assertTrue(formulariopublicar.IngPass2(datos.getPass()));
		soft.assertTrue(formulariopublicar.clickCondiciones());
		//soft.assertTrue(formulariopublicar.clickBtnPublicar());
		soft.assertAll();
	
}
}