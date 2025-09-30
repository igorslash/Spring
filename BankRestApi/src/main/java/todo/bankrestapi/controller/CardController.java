@RestController
@RequestMapping("/api/cards")
@RequiredArgsConstructor
@Tag(name = "Банковские карты", description = "Управление картами (CRUD, статусы, просмотр)")
public class CardController {

    private final CardService cardService;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    @Operation(summary = "Создать карту", description = "ADMIN — для любого пользователя, USER — для себя")
    public ResponseEntity<CardDto> createCard(/* ... */) { /* ... */ }

    @GetMapping("/my")
    @PreAuthorize("hasRole('USER')")
    @Operation(summary = "Получить свои карты", description = "С пагинацией")
    public ResponseEntity<Page<CardDto>> getMyCards(
            @Parameter(description = "Номер страницы", example = "0") @RequestParam(defaultValue = "0") int page,
            @Parameter(description = "Размер страницы", example = "20") @RequestParam(defaultValue = "20") int size,
            Authentication authentication) { /* ... */ }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Получить все карты", description = "Только для ADMIN")
    public ResponseEntity<Page<CardDto>> getAllCards(/* ... */) { /* ... */ }

    @PatchMapping("/{cardId}/status")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    @Operation(summary = "Обновить статус карты", description = "USER может только блокировать свою карту")
    public ResponseEntity<CardDto> updateCardStatus(/* ... */) { /* ... */ }
}