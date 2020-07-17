package com.yapo.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.yapo.config.BaseConfig;

public class Formulario extends BaseConfig{
	
	public Formulario(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(id = "searcharea_expanded")
	public WebElement RM;
	
	
	@FindBy(xpath = "//*[@id=\"multicom-head\"]")
	private WebElement clickComuna;
	@FindBy(xpath = "//*[@id=\"multicom-widget\"]")
	private WebElement comuna;
	
	
	@FindBy(id = "catgroup")
	private WebElement categoria;
	@FindBy(id = "estate_type_ret")
	private WebElement tipoInmueble;
	
	@FindBy(id="ps_2")
	private WebElement preMin;
	@FindBy(id="pe_2")
	private WebElement preMax;
	
	@FindBy(id="rooms_ros")
	private WebElement dorMin;
	@FindBy(id="rooms_roe")
	private WebElement dorMax;
	
	@FindBy(id="ss_0")
	private WebElement m2min;
	@FindBy(id="se_0")
	private WebElement m2max;
	
	@FindBy(id="bathrooms_brs")
	private WebElement banoMin;
	@FindBy(id="bathrooms_bre")
	private WebElement banoMax;
	
	@FindBy(id="condominio_cos")
	private WebElement gastoMin;
	@FindBy(id="condominio_coe")
	private WebElement gastoMax;
	
	@FindBy(id="garage_spaces_gs")
	private WebElement estacionamiento;
	
	@FindBy(id = "searchbutton")
	private WebElement btnBuscar;
	
	/*----------------------------------------------------------*/
	
	public boolean clickRegion (String Region) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 3);
			wait.until(ExpectedConditions.elementToBeClickable(RM));
			Select selectRegion = new Select(RM);
			selectRegion.selectByVisibleText(Region);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean clickComuna (String Comuna) {
		try {
			
			clickComuna.click();
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.elementToBeClickable(comuna));		
			WebElement selectComuna = driver.findElement(By.xpath("//*[@id=\"multicom-widget\"]/label["+Comuna+"]"));
			selectComuna.click();

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
		
	public boolean clickSeleccionandoCategoria(String Categoria) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 3);
			wait.until(ExpectedConditions.elementToBeClickable(categoria));
			System.out.println("Seleccionando categoria");
			Select selectCategoria = new Select(categoria);
			selectCategoria.selectByVisibleText(Categoria);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean seleccionandotipoPropiedad(String TipoInmueble) {
		try {
			System.out.println("Seleccionando tipo de inmueble");
			Select selectTipoInmueble = new Select(tipoInmueble);
			selectTipoInmueble.selectByVisibleText(TipoInmueble);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean preMin(String PreMin) {
		try {
			Select selectMinPrecio = new Select(preMin);
			selectMinPrecio.selectByVisibleText(PreMin);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean preMax(String PreMax) {
		try {
			Select selectMaxPrecio = new Select(preMax);
			selectMaxPrecio.selectByVisibleText(PreMax);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean SelectdorMin(String DorMin) {
		try {
			Select selectMinDor = new Select(dorMin);
			selectMinDor.selectByVisibleText(DorMin);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean SelectdorMax(String DorMax) {
		try {
			Select selectMaxDor = new Select(dorMax);
			selectMaxDor.selectByVisibleText(DorMax);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}	
	
	public boolean Selectm2Min(String M2Min) {
		try {
			Select selectm2min = new Select(m2min);
			selectm2min.selectByVisibleText(M2Min);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean Selectm2Max(String M2Max) {
		try {
			Select selectm2max = new Select(m2max);
			selectm2max.selectByVisibleText(M2Max);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}	

	public boolean SelectbanoMin(String BanoMin) {
		try {
			Select selectbanoMin = new Select(banoMin);
			selectbanoMin.selectByVisibleText(BanoMin);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean SelectbanoMax(String BanoMax) {
		try {
			Select selectbanoMax = new Select(banoMax);
			selectbanoMax.selectByVisibleText(BanoMax);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean SelectGastoMin(String GastoMin) {
		try {
			Select selectGastoMin = new Select(gastoMin);
			selectGastoMin.selectByVisibleText(GastoMin);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean SelectGastoMax(String GastoMax) {
		try {
			Select selectGastoMax = new Select(gastoMax);
			selectGastoMax.selectByVisibleText(GastoMax);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}	
	
	public boolean SelectParking(String Estacionamiento) {
		try {
			Select selectestacionamiento = new Select(estacionamiento);
			selectestacionamiento.selectByVisibleText(Estacionamiento);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}	
	
	public void pressSearch() {
		btnBuscar.click();
	}
	
	public void selectMetropolitana() {
		driver.get("https://www.yapo.cl/region_metropolitana");
	}

}
