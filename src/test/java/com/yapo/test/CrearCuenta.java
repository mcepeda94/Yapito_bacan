package com.yapo.test;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.yapo.config.BaseConfig;
import com.yapo.dataprovider.DataProviderYapito;
import com.yapo.page.FormularioUsuario;
import com.yapo.entities.DatosCrearUser;

public class CrearCuenta extends BaseConfig {

	@Test(description="Create Acount in Yapo", dataProvider = "registrar", dataProviderClass = DataProviderYapito.class)
	public void crearCuenta(DatosCrearUser datos)  {
			
		SoftAssert soft = new SoftAssert();	
		FormularioUsuario formulariousuario  = new FormularioUsuario(driver);
		
		formulariousuario.selectCrearCuenta();
		soft.assertTrue(formulariousuario.clickPersona());
		soft.assertTrue(formulariousuario.IngNombre(datos.getNombCom()));
		soft.assertTrue(formulariousuario.clickGenero(datos.getSexo()));
		soft.assertTrue(formulariousuario.clickRegion(datos.getRegion()));
		soft.assertTrue(formulariousuario.clickComuna(datos.getComuna()));
		soft.assertTrue(formulariousuario.clickMovil(datos.getTelefono()));
		soft.assertTrue(formulariousuario.IngEmail(datos.getEmail()));
		soft.assertTrue(formulariousuario.IngPass(datos.getPass()));
		soft.assertTrue(formulariousuario.IngPass2(datos.getPass()));
		soft.assertTrue(formulariousuario.clickCondiciones());
		soft.assertTrue(formulariousuario.clickBtnCrear());
		soft.assertAll();
		
		}
	}