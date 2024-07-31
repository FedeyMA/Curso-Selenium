package pages;

public class PaginaPrincipal extends BasePage{

    private String sectionLink = "//a[normalize-space()='%s' and @href]";
    private String elegirUnPlanButton = "//a[normalize-space()='Elegir Plan' and @href]";
    
    public PaginaPrincipal(){
        super(driver);
    }

    // Method navigate to www.freerangetesters.com
    public void navigateToFreeRangeTesters(){
        navigateTo("https://www.freerangetesters.com");
        
    }

    public void clickOnSectionNavigationBar(String section){
        //remplazar marcador de posicion en sectionLink con el nombre
        String xpathSection = String.format(sectionLink, section);
        clickElement(xpathSection);
    }

    public void clickOnElegirUnPlanButton(){
        clickElement(elegirUnPlanButton);
    }
}
