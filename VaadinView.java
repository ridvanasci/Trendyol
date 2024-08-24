
@SpringBootApplication
public class VaadinView extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(MyVaadinApp.class);
    }

    @Bean
    public ServletRegistrationBean h2ConsoleServletRegistration() {
        ServletRegistrationBean registration = new ServletRegistrationBean(new WebServlet());
        registration.addUrlMappings("/h2-console/*");
        System.out.println("H2 Console servlet registered successfully!");
        return registration;
    }
}