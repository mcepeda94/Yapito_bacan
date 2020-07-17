package com.yapo.page;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.yapo.config.BaseConfig;

public class FormularioPublicar extends BaseConfig{
	
	public FormularioPublicar(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	
	@FindBy(id = "category_group")
	public WebElement categoria;
	@FindBy(id = "condition")
	public WebElement nuevoUsado;
	@FindBy(id = "gender")
	public WebElement genero;
	
	@FindBy(id = "clothing_size")
	public WebElement talla;
	@FindBy(id = "subject")
	public WebElement titulo;
	@FindBy(xpath = "//*[@id=\"body\"]")
	public WebElement descripcion;
	@FindBy(id = "price")
	public WebElement precio;
	@FindBy(id = "add_images")
	public WebElement imagen;
	@FindBy(id = "region")
	public WebElement region;
	@FindBy(id = "communes")
	public WebElement comuna;
	@FindBy(xpath = "//*[@id=\"p_ad\"]")
	public WebElement persona;
	@FindBy(id = "name")
	public WebElement nomComple;
	@FindBy(id = "email")
	public WebElement email;
	@FindBy(id = "email_confirm")
	public WebElement emailConfir;
	@FindBy(id = "phone")
	public WebElement movile;
	@FindBy(id = "passwd")
	public WebElement pass1;
	@FindBy(id = "passwd_ver")
	public WebElement pass2;
	@FindBy(xpath = "//*[@id=\"aiform\"]/div[1]/div/ins")
	public WebElement condiciones;
	@FindBy(xpath = "//*[@id=\"submit_create_now\"]")
	public WebElement btnPublicar;
	
	
	
	public boolean clickCategoria (String Categoria) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 3);
			wait.until(ExpectedConditions.elementToBeClickable(categoria));
			Select selectcategoria = new Select(categoria);
			selectcategoria.selectByVisibleText(Categoria);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean clickNuevoUsado (String NuevoUsado) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 3);
			wait.until(ExpectedConditions.elementToBeClickable(nuevoUsado));
			Select selectNuevoUsado = new Select(nuevoUsado);
			selectNuevoUsado.selectByVisibleText("Nuevo");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}	
	public boolean clickGenero (String Genero) {
		
		try {
			WebDriverWait wait = new WebDriverWait(driver, 3);
			wait.until(ExpectedConditions.elementToBeClickable(genero));
			Select selectGenero = new Select(genero);
			selectGenero.selectByVisibleText(Genero);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}	
	public boolean clickTalla (String Talla) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 3);
			wait.until(ExpectedConditions.elementToBeClickable(talla));
			Select selectTalla = new Select(talla);
			selectTalla.selectByVisibleText(Talla);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}	
	public boolean clicktitulo (String Titulo) {
		try {
			titulo.sendKeys(Titulo);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean clickdescripcion (String Descripcion) {
		try {
			descripcion.sendKeys(Descripcion);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}		
	public boolean clickprecio (String Precio) {
		try {
			precio.sendKeys(Precio);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}	
/***************************************/	
	public boolean clickimagen (String Imagen) {
		try {

			imagen.click();
			//put path to your image in a clipboard
		    StringSelection ss = new StringSelection(Imagen);
		    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

		    //imitate mouse events like ENTER, CTRL+C, CTRL+V
		    Robot robot = new Robot();
		    robot.keyPress(KeyEvent.VK_ENTER);
		    robot.keyRelease(KeyEvent.VK_ENTER);
		    robot.keyPress(KeyEvent.VK_CONTROL);
		    robot.keyPress(KeyEvent.VK_V);
		    robot.keyRelease(KeyEvent.VK_V);
		    robot.keyRelease(KeyEvent.VK_CONTROL);
		    robot.keyPress(KeyEvent.VK_ENTER);
		    robot.keyRelease(KeyEvent.VK_ENTER);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}		
/***************************************/	
	public boolean clickRegion (String Region) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.elementToBeClickable(region));
			Select selectregion = new Select(region);
			selectregion.selectByVisibleText(Region);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}	
	public boolean clickComuna (String Comuna) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.elementToBeClickable(comuna));
			Select selectregion = new Select(comuna);
			selectregion.selectByVisibleText(Comuna);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}	
	public boolean clickPersona () {
		try {
			persona.click();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean IngNombre (String NomComple) {
		try {
			nomComple.sendKeys(NomComple);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean clickMovil (String Phone) {
		try {
			movile.sendKeys(Phone);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean IngEmail (String Email) {
		try {
			email.sendKeys(Email);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean IngEmailConfir (String Email) {
		try {

			emailConfir.sendKeys(Email);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean IngPass (String Pass) {
		try {
			pass1.sendKeys(Pass);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean IngPass2 (String Pass) {
		try {
			pass2.sendKeys(Pass);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}	
	public boolean clickCondiciones () {
		try {
			condiciones.click();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean clickBtnPublicar () {
		try {
			btnPublicar.click();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public void selectPublicar() {
		driver.get("https://www2.yapo.cl/ai/form/0");
	}	
	
	
	
	
	
}