package app.project.configuration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import app.project.model.Employee;
import app.project.viewResolver.ExcelViewResolver;
import app.project.viewResolver.JsonViewResolver;
import app.project.viewResolver.PdfViewResolver;
import app.project.viewResolver.XmlViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "app.project")
public class MvcConfiguration extends WebMvcConfigurerAdapter {

	/*
	 * Configure ContentNegotiationManager
	 * 
	 * @see
	 * org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter
	 * #configureContentNegotiation(org.springframework.web.servlet.config.
	 * annotation.ContentNegotiationConfigurer)
	 */
	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		configurer.ignoreAcceptHeader(true).defaultContentType(MediaType.TEXT_HTML);
	}

	/*
	 * Configure ContentNegotiatingViewResolver
	 */
	@Bean
	public ViewResolver contentNegotiatingViewResolver(ContentNegotiationManager manager) {
		ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
		resolver.setContentNegotiationManager(manager);

		// Define view Resolvers
		List<ViewResolver> resolvers = new ArrayList<ViewResolver>();
		resolvers.add(pdfViewResolver());
		resolvers.add(jspViewResolver());
		resolvers.add(jsonViewResolver());
		resolvers.add(xmlViewResolver());
		resolvers.add(excelViewResolver());

		resolver.setViewResolvers(resolvers);
		return resolver;
	}

	@Bean
	public ViewResolver pdfViewResolver() {
		return new PdfViewResolver();
	}

	@Bean
	public ViewResolver jsonViewResolver() {
		return new JsonViewResolver();
	}

	@Bean
	public ViewResolver xmlViewResolver() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setClassesToBeBound(Employee.class);
		return new XmlViewResolver(marshaller);
	}

	@Bean
	public ViewResolver excelViewResolver() {
		return new ExcelViewResolver();
	}

	@Bean
	public ViewResolver jspViewResolver() {
		InternalResourceViewResolver viewResolvers = new InternalResourceViewResolver();
		viewResolvers.setViewClass(JstlView.class);
		viewResolvers.setPrefix("/WEB-INF/views/");
		viewResolvers.setSuffix(".jsp");
		return viewResolvers;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry resourceRegistry) {
		resourceRegistry.addResourceHandler("/static/**").addResourceLocations("/static/");
	}

}
