package com.mycompany.element.ws.endpoint;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.jdom.xpath.XPath;
import org.jdom.JDOMException;
import org.jdom.Namespace;
import org.jdom.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;

import com.mycompany.element.ws.action.HumanResourceService;
import com.mycompany.element.ws.action.HumanResourceImpl;

/**
 * Bean que se encarga de administrar el servicio web de prueba
 * @author jose
 *
 */
@Endpoint                                                                              
public class HolidayEndpoint {

  private static final String NAMESPACE_URI = "http://www.pruebaconcepto.com/hr/schemas";

  private XPath startDateExpression;

  private XPath endDateExpression;

  private XPath nameExpression;

  private HumanResourceService humanResourceService;

  
  /**
   * Constructor donde se obtiene el contenido del wsdl 
   * @param humanResourceService
   * @throws JDOMException
   */
  @Autowired
  public HolidayEndpoint(HumanResourceService humanResourceService)                      
      throws JDOMException {
	  
    this.humanResourceService = humanResourceService;

    Namespace namespace = Namespace.getNamespace("hr", NAMESPACE_URI);

    startDateExpression = XPath.newInstance("//hr:StartDate");
    startDateExpression.addNamespace(namespace);

    endDateExpression = XPath.newInstance("//hr:EndDate");
    endDateExpression.addNamespace(namespace);

    nameExpression = XPath.newInstance("concat(//hr:FirstName,' ',//hr:LastName)");
    nameExpression.addNamespace(namespace);
    	
    System.out.println("HolidayEndpoint");
    
    
  }
  
  
  /**
   * Se utilizan los valores contenidos en el wdsl para usarse en servicios de negocio 
   * @param holidayRequest
   * @throws Exception
   */
  @PayloadRoot(namespace = NAMESPACE_URI, localPart = "HolidayRequest")                  
  public void handleHolidayRequest(@RequestPayload Element holidayRequest)               
      throws Exception {
	System.out.println("handleHolidayRequest");
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Date startDate = dateFormat.parse(startDateExpression.valueOf(holidayRequest));
    Date endDate = dateFormat.parse(endDateExpression.valueOf(holidayRequest));
    String name = nameExpression.valueOf(holidayRequest);

    humanResourceService.bookHoliday(startDate, endDate, name);
  }

}
