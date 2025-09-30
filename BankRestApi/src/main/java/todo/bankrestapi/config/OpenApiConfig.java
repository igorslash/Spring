@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Система Управления Банковскими Картами API")
                        .version("1.0")
                        .description("API для управления банковскими картами, переводами и авторизацией")
                        .license(new License().name("MIT").url("https://opensource.org/licenses/MIT")))
                .servers(List.of(
                        new Server().url("http://localhost:8080").description("Локальный сервер")
                ));
    }
}