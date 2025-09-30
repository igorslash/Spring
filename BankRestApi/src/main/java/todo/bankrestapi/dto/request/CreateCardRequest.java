@Getter
@RequaredArgsConstructor
public class CreateCardRequest {

    @NotBlank(message = "Номер карты обязателен")
    @Pattern(regexp = "^\\d{16}$", message = "Номер карты должен содержать 16 цифр")
    private String cardNumber;

    @NotBlank(message = "Имя владельца обязательно")
    private String cardHolder;

    @NotBlank(message = "Срок действия обязателен")
    @Pattern(regexp = "^(0[1-9]|1[0-2])/\\d{2}$", message = "Формат срока: MM/yy, например 05/27")
    private String expiryDate; // "05/27"


    private Long userId;
}