package ma.emsi.tp1_jee_api.server;


import jakarta.xml.ws.Endpoint;
import ma.emsi.tp1_jee_api.Tp1JeeApiApplication;
import ma.emsi.tp1_jee_api.repository.ProductRepository;
import ma.emsi.tp1_jee_api.webservice.ProductWebService;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class ServerWS {
    @Autowired
    public static void main(String[] args) {
        ConfigurableApplicationContext context=SpringApplication.run(Tp1JeeApiApplication.class,args);
        ProductWebService productWebService=context.getBean(ProductWebService.class);
        String url = "http://localhost/8088/";
        Endpoint.publish(url,productWebService);
        System.out.println(url + " deployed");
    }
}
