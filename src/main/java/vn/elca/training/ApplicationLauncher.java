package vn.elca.training;

import org.h2.server.web.WebServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ResourceBundleMessageSource;

import org.springframework.core.SpringVersion;
import vn.elca.training.service.GroupService;
import vn.elca.training.service.IGroupService;
import vn.elca.training.service.IProjectService;
import vn.elca.training.web.ApplicationController;

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackageClasses = { ApplicationLauncher.class, ApplicationController.class, IProjectService.class })
@PropertySource({ "classpath:/application.properties", "classpath:/message.properties" })
public class ApplicationLauncher implements CommandLineRunner {

    @Autowired
    private IGroupService groupService;

    public static void main(String[] args) {
        SpringApplication.run(ApplicationLauncher.class, args);
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public static MessageSource messageSource() {
        ResourceBundleMessageSource resourceBundleMessageSource = new ResourceBundleMessageSource();
        resourceBundleMessageSource.setBasename("message");
        return resourceBundleMessageSource;
    }
    
    @Bean
    ServletRegistrationBean h2servletRegistration(){
    	// Access to h2 console by this link: http://localhost:8080/h2console
    	// JDBC URL: jdbc:h2:mem:testdb
    	// other fields left as default, this configuration will access the schema on memory
        ServletRegistrationBean registrationBean = new ServletRegistrationBean( new WebServlet());
        registrationBean.addUrlMappings("/h2console/*");
        return registrationBean;
    }

    @Override
    public void run(String... strings) {
         groupService.insertDummyData();
        System.out.println("version: " + SpringVersion.getVersion());
    }
}
